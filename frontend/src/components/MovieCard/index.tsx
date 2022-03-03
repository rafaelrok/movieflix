import './styles.css';

import { Movie } from 'types/movie';

type Props = {
    movie: Movie;
}

const MovieCard = ({ movie }: Props) => {

    return (
        <div className="base-card movie-card">
            <div className="card-top-container">
                <img src={movie.imgUrl} alt={movie.title} />
            </div>
            <div className="card-bottom-container">
                <h1>{movie.title}</h1>
                <h2>{movie.year}</h2>
                <h6>{movie.synopsis}</h6>
            </div>
        </div>
    );
}

export default MovieCard;