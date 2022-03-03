import { useHistory, useLocation } from 'react-router-dom';
import ButtonIcon from 'components/ButtonIcon';
import { useForm } from 'react-hook-form';
import { requestBackendLogin } from 'util/requests';
import { useContext, useState } from 'react';
import { AuthContext } from 'AuthContext';
import { saveAuthData } from 'util/storage';
import { getTokenData } from 'util/auth';

import { ReactComponent as AuthImage } from '../../assets/images/auth-image.svg';

import './styles.css';

type CredentialsDTO = {
    username: string;
    password: string;
};

type LocationState = {
    from: string;
}

const Home = () => {

    const location = useLocation<LocationState>();

    const { from } = location.state || { from: { pathname: '/movies' } };

    const { setAuthContextData } = useContext(AuthContext);

    const [hasError, setHasError] = useState(false);

    const { register, handleSubmit, formState: { errors } } = useForm<CredentialsDTO>();

    const history = useHistory();

    const onSubmit = (formData: CredentialsDTO) => {
        requestBackendLogin(formData)
            .then(response => {
                saveAuthData(response.data);
                setHasError(false);
                setAuthContextData({
                    authenticated: true,
                    tokenData: getTokenData()
                })
                history.replace(from);
            })
            .catch(err => {
                setHasError(true);
                console.log('ERROR', err);
            });
    };


    return (
        <div className="home-container">
            <div className="auth-banner-container">
                <h1>
                    Avalie Filmes
                </h1>
                <p>
                    Diga o que você achou do seu filme favorito.
                </p>
                <AuthImage />
            </div>
            <div className="base-card login-card">
                <h1>LOGIN</h1>
                {hasError && (
                    <div className="alert alert-danger">
                        Erro ao efetuar login!
                    </div>
                )}
                <form onSubmit={handleSubmit(onSubmit)}>
                    <div className="form-floating mb-4">
                        <input
                            {...register('username', {
                                required: 'Campo obrigatório',
                                pattern: {
                                    value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i,
                                    message: 'Email inválido'
                                }
                            })}
                            type="email"
                            className={`form-control base-input ${errors.username ? 'is-invalid' : ''}`}
                            id="floatingInput"
                            placeholder="name@example.com"
                            name="username"
                        />
                        <label htmlFor="floatingInput">Email</label>
                        <div className="invalid-feedback d-block">{errors.username?.message}</div>
                    </div>
                    <div className="form-floating mb-2">
                        <input
                            {...register('password', {
                                required: 'Campo obrigatório'
                            })}
                            type="password"
                            className={`form-control base-input ${errors.password ? 'is-invalid' : ''}`}
                            id="floatingPassword"
                            placeholder="Password"
                            name="password"
                        />
                        <label htmlFor="floatingPassword">Senha</label>
                        <div className="invalid-feedback d-block">{errors.password?.message}</div>
                    </div>
                    <div className="login-submit">
                        <ButtonIcon text="FAZER LOGIN" />
                    </div>
                </form>
            </div>
        </div>
    );
};

export default Home;