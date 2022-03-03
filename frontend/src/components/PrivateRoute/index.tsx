import { Redirect, Route } from 'react-router-dom';
import { hasAnyRoles, isAuthenticated, Role } from 'util/auth';


type Props = {
    children: React.ReactNode;
    path: string;
    roles?: Role[];
};

const PrivateRoute = ({ children, path, roles = [] }: Props) => {
    return (
        <Route
            path={path}
            render={({ location }) =>
                !isAuthenticated() ? (
                    <Redirect
                        to={{
                            pathname: "/dashboard/auth/login",
                            state: { from: location },
                        }}
                    />
                ) : hasAnyRoles(roles) ?
                    (
                        <Redirect to='/' />
                    ) : (
                        children
                    )
            }
        />
    );
};

export default PrivateRoute;
