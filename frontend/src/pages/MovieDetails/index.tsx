import { useState, useEffect, useCallback } from 'react';
import { useParams } from 'react-router-dom';
import { Movie } from 'types/movie';
import MovieInfoLoader from './MovieInfoLoader';
import MovieImageLoader from './MovieImageLoader';
import MovieReview from './MovieReview';
import { hasAnyRoles } from 'util/auth';
import MovieForm from './MovieForm';

import './styles.css';
import { requestBackend } from '../../util/requests';

type UrlParams = {
    movieId: string;
};

const MovieDetails = () => {
    const { movieId } = useParams<UrlParams>();
    const [movie, setMovie] = useState<Movie>();
    const [isLoading, setIsLoading] = useState(false);

    const getMovie = useCallback(() => {
        setIsLoading(true);
        requestBackend({ url: `/movies/${movieId}` })
            .then(response => setMovie(response.data))
            .finally(() => {
                setIsLoading(false);
            });
    }, [movieId]);

    useEffect(() => {
        getMovie()
    }, [getMovie]);

    return (
        <div className="movie-details-container">
            <div className="base-card movie-details-card">
                <div className="row">
                    <div className="col-xl-6">
                        {isLoading ? (
                            <MovieInfoLoader />
                        ) : (
                            <>
                                <div className="img-container">
                                    <img src={movie?.imgUrl} alt={movie?.title} />
                                </div>
                            </>
                        )}
                    </div>
                    <div className="col-xl-6">
                        {isLoading ? (
                            <MovieImageLoader />
                        ) : (
                            <>
                                <div className="info-container">
                                    <h1>{movie?.title}</h1>
                                    <h2>{movie?.year}</h2>
                                    <p>{movie?.subTitle}</p>
                                </div>
                                <div className="description-container">
                                    <p>{movie?.synopsis}</p>
                                </div>
                            </>
                        )}
                    </div>
                </div>
            </div>
            {hasAnyRoles(['ROLE_MEMBER']) &&
                (
                    < MovieForm
                        movieId={movieId}
                    />
                )
            }
            <div className="base-card movie-review-card">
                {movie?.reviews.map(review => (
                    <MovieReview review={review} key={review.id} />
                ))}
            </div>
        </div>
    );
};

export default MovieDetails;
