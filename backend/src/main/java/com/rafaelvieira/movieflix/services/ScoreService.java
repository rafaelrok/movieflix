package com.rafaelvieira.movieflix.services;

import com.rafaelvieira.movieflix.dto.MovieDTO;
import com.rafaelvieira.movieflix.dto.ReviewDTO;
import com.rafaelvieira.movieflix.entities.Movie;
import com.rafaelvieira.movieflix.entities.Score;
import com.rafaelvieira.movieflix.entities.User;
import com.rafaelvieira.movieflix.repositories.MovieRepository;
import com.rafaelvieira.movieflix.repositories.ScoreRepository;
import com.rafaelvieira.movieflix.services.exceptions.ResourceNotFoundException;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.rafaelvieira.movieflix.enums.AssessmentOpenAi.COMMENT_RATING;

/**
 * @author rafae
 */

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private MovieRepository movieRepository;


    @Value("${openai.api.key}")
    private String openAIKey;


    @Transactional
    public MovieDTO saveScoreWithReview(ReviewDTO reviewDTO, Movie movie, User user) {

        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }

        Score score = new Score();

        double value = scoreProcessByOpenAi(reviewDTO);

        score.setMovie(movie);
        score.setUser(user);
        score.setValue(value);
        scoreRepository.saveAndFlush(score);

        double sum = 0;
        for(Score s : movie.getScores()) {
            sum += s.getValue();
        }

        double movieScoreAverage = sum / movie.getScores().size();
        movie.setScore(movieScoreAverage);
        movie.setCount(movie.getScores().size());
        movie = movieRepository.saveAndFlush(movie);

        return new MovieDTO(movie);
    }

    public double scoreProcessByOpenAi(ReviewDTO reviewDTO) {
        try {
            final OpenAiService service = new OpenAiService(openAIKey, Duration.ofSeconds(45));

            final CompletionRequest completionRequest = CompletionRequest.builder()
                    .model("text-davinci-003")
                    .prompt(COMMENT_RATING + reviewDTO.getText() + " Nota: ")
                    .maxTokens(100)
                    .build();

            String status = service.createCompletion(completionRequest).getChoices().get(0).getText().trim();

            final Pattern pattern = Pattern.compile("\\d+\\.\\d+");
            final Matcher matcher = pattern.matcher(status);
            double scoreValue = Double.MIN_VALUE;

            while (matcher.find()) {
                double number = Double.parseDouble(matcher.group());
                scoreValue = Math.max(scoreValue, number);
            }

            return scoreValue;
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Connection not found with openAI" + e);
        }

    }
}
