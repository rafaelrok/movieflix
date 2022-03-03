import MovieCard from 'components/MovieCard';
import { Movie } from 'types/movie';
import { Link } from 'react-router-dom';
import Pagination from 'components/Pagination';
import { useState, useEffect, useCallback } from 'react';
import { SpringPage } from 'types/vendor/spring';
import { requestBackend } from 'util/requests';
import { AxiosRequestConfig } from 'axios';
import CardLoader from './CardLoader';

import './styles.css';

import { Genre } from 'types/genre';
import MovieFilter from 'components/MovieFilter';


const MovieList = () => {
    const [page, setPage] = useState<SpringPage<Movie>>();
    const [isLoading, setIsLoading] = useState(false);

    const [genre, setGenre] = useState<Genre>();
    const [activePage, setActivePage] = useState(0);


    const handleChangeGenre = (genre?: Genre) => {
        setActivePage(0);
        setGenre(genre);
    }

    const getMovie = useCallback(() => {
        const params: AxiosRequestConfig = {
            method: 'GET',
            url: '/movies',
            params: {
                page: activePage,
                size: 8,
                genreId: genre?.id
            },
        };

        setIsLoading(true);
        requestBackend(params)
            .then((response) => {
                setPage(response.data);
            })
            .finally(() => {
                setIsLoading(false);
            });
    }, [activePage, genre]);

    useEffect(() => {
        getMovie();
    }, [getMovie]);

    return (
        <div className="container my-4 movie-container">
            <div className="movie-filter-container">
                <MovieFilter handleChangeGenre={handleChangeGenre} />
            </div>
            <div className="row">
                {isLoading ? (
                    <CardLoader />
                ) : (
                    page?.content.map((movie) => (
                        <div className="col-sm-6 col-lg-4 col-xl-3" key={movie.title}>
                            <Link to={`/movies/${movie.id}`}>
                                <MovieCard movie={movie} />
                            </Link>
                        </div>
                    ))
                )}
            </div>
            <div className="row">
                <Pagination
                    forcePage={page?.number}
                    pageCount={page ? page.totalPages : 0}
                    range={3}
                    onChange={page => setActivePage(page)}
                />
            </div>
        </div>
    );
};

export default MovieList;
