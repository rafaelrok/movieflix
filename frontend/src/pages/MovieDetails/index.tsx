import axios from 'axios';
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { Movie } from 'types/movie';
import { BASE_URL } from 'util/requests';
import MovieInfoLoader from './MovieInfoLoader';
import MovieImageLoader from './MovieImageLoader';
import ButtonIcon from 'components/ButtonIcon';

import './styles.css';
import MovieReview from './MovieReview';
import { hasAnyRoles } from 'util/auth';


type UrlParams = {
    movieId: string;
};

const MovieDetails = () => {
    const { movieId } = useParams<UrlParams>();

    const [isLoading, setIsLoading] = useState(false);
    const [movie, setMovie] = useState<Movie>();


    useEffect(() => {
        setIsLoading(true);
        axios
            .get(`${BASE_URL}/movies/${movieId}`)
            .then((response) => {
                setMovie(response.data);
            })
            .finally(() => {
                setIsLoading(false);
            });
    }, [movieId]);

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
                    <div className="base-card movie-review-card">
                        <div className='input-container'>
                            <input
                                type="text"
                                className="form-control base-input"
                                id="inputReview"
                                placeholder="Deixe sua avaliação aqui"
                                name="avaliação"
                            />
                        </div>
                        <div className="review-button">
                            <ButtonIcon text="SALVAR AVALIAÇÃO" />
                        </div>
                    </div>
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
