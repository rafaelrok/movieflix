import { useEffect, useState } from 'react';
import Select from 'react-select';
import { Genre } from 'types/genre';
import { requestBackend } from 'util/requests';

import './styles.css';

type Props = {
    handleChangeGenre: (genre: Genre) => void;
}

const MovieFilter = ({ handleChangeGenre }: Props) => {
    const [genres, setGenres] = useState<Genre[]>([]);
    const [isLoadingGenres, setIsLoadingGenres] = useState(false);

    useEffect(() => {
        setIsLoadingGenres(true);
        requestBackend({ url: '/genres' })
            .then(response => setGenres(response.data))
            .finally(() => setIsLoadingGenres(false));
    }, []);

    return (
        <div className="base-card movie-filter-container">
            <Select
                isClearable
                isLoading={isLoadingGenres}
                options={genres}
                getOptionLabel={(option: Genre) => option.name}
                getOptionValue={(option: Genre) => String(option.id)}
                className="genre-select"
                placeholder="Selecione um gênero"
                onChange={value => handleChangeGenre(value as Genre)}
            />
        </div>
    );
};

export default MovieFilter;
