
import { AxiosRequestConfig } from 'axios';
import { useEffect } from 'react';
import { useForm } from 'react-hook-form';
import { useHistory } from 'react-router-dom';
import { requestBackend } from 'util/requests';

import Swal from 'sweetalert2';


import './styles.css';
import { Review } from 'types/review';


type UrlParams = {
    text: string;
    movieId: string;
};

type Props = {
    movieId: string;
}

const MovieForm = ({ movieId }: Props) => {

    const history = useHistory();

    const {
        register,
        handleSubmit,
        formState: { errors },
        setValue,
    } = useForm<UrlParams>();

    useEffect(() => {
        requestBackend({ url: '/reviews' })
            .then((response) => {
                const review = response.data as Review;
                setValue(`movieId`, review.movie.id.toString());
                setValue('text', review.text);
            });

    }, [movieId, setValue]);

    const onSubmit = (formData: UrlParams) => {
        const data = {
            ...formData,
        };

        const config: AxiosRequestConfig = {
            method: 'POST',
            url: '/reviews',
            data,
            withCredentials: true,
        };

        requestBackend(config)
            .then(() => {
                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: 'Avaliação cadastrado com sucesso!',
                    showConfirmButton: false,
                    timer: 1500
                })
                history.push(`/movies/${movieId}`);
            })
            .catch(() => {
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Algo deu errado!',
                    confirmButtonColor: '#DF5753',
                    footer: '<p>Verifiquei os dados</p>'
                })
                history.push(`/movies/${movieId}`);
            });
    };


    return (
        <div className="base-card movie-review-card">
            <form className='input-container' onSubmit={handleSubmit(onSubmit)}>
                <input
                    {...register('text', { required: 'Campo obrigatório' })}
                    type="text"
                    className={`form-control base-input ${errors.text ? 'is-invalid' : ''}`}
                    id="floatingInput"
                    placeholder="Digite seu comentário"
                    name="text"
                />
                <input
                    {...register("movieId")}
                    hidden={true}
                    value={movieId}
                />
                <button
                    className="btn btn-primary"
                    type="submit">
                    Salvar Avaliação
                </button>
            </form>
        </div>
    );
};

export default MovieForm;
