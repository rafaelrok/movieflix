import { Redirect, Route } from 'react-router-dom';
import { isAuthenticated } from 'util/auth';


type Props = {
    children: React.ReactNode;
    path: string;
}

const PrivateRoute = ({ children, path }: Props) => {

    return (
        <Route
            path={path}
            render={({ location }) => {
                if (!isAuthenticated()) {
                    return (
                        <Redirect
                            to={{
                                pathname: "/",
                                state: { from: location }
                            }}
                        />
                    )
                }
                return children;
            }}
        />
    );
}

export default PrivateRoute;
