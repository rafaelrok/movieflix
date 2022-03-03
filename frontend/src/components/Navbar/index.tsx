import './styles.css';

import { MdLogout } from "react-icons/md";
import 'bootstrap/js/src/collapse.js';
import { Link, NavLink } from 'react-router-dom';
import { useContext, useEffect } from 'react';
import history from 'util/history';
import { AuthContext } from 'AuthContext';
import { getTokenData, isAuthenticated } from 'util/auth';
import { removeAuthData } from 'util/storage';



const Navbar = () => {

    const { authContextData, setAuthContextData } = useContext(AuthContext);

    useEffect(() => {
        if (isAuthenticated()) {
            setAuthContextData({
                authenticated: true,
                tokenData: getTokenData()
            });
        }
        else {
            setAuthContextData({
                authenticated: false
            });
        }
    }, [setAuthContextData]);

    const handleLogoutClick = (event: React.MouseEvent<HTMLAnchorElement>) => {
        event.preventDefault();
        removeAuthData();
        setAuthContextData({
            authenticated: false
        });
        history.replace('/');
    }

    return (
        <>
            <nav className="navbar navbar-light navbar-expand-md navbar-fixed-top navigation-clean-button">
                <div className="container">
                    <button
                        data-bs-toggle="collapse"
                        className="navbar-toggler"
                        data-bs-target="#navcol-1"
                        aria-expanded="false"
                        aria-label="Toggle navigation">
                        <span className="visually-hidden">Toggle navigation</span>
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div><Link className="navbar-brand" to="/movies"><span>MovieFlix</span> </Link></div>
                    <div className="collapse navbar-collapse" id="navcol-1">
                        <ul className="navbar-nav nav-right">
                        </ul>
                        <p className="ms-auto navbar-text actions">
                            {
                                authContextData.authenticated ? (
                                    <>
                                        <span className="nav-username">Bem vindo, {authContextData.tokenData?.user_name}</span>
                                        <NavLink
                                            to="/"
                                            onClick={handleLogoutClick}
                                            className="btn btn-light action-button"
                                            activeClassName="active">
                                            <MdLogout className="icon-button-content" />
                                            Sair
                                        </NavLink>
                                    </>
                                ) : (
                                    <>
                                        <NavLink
                                            className="login"
                                            to="/"
                                            activeClassName="active">
                                            Login
                                        </NavLink>
                                    </>
                                )
                            }
                        </p>
                    </div>
                </div>
            </nav>
        </>
    );
}

export default Navbar;