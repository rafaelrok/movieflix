import Navbar from "components/Navbar";
import Home from "pages/Home";
import MovieList from "pages/MovieList";

import { Router, Route, Switch } from "react-router-dom";
import MovieDetails from "pages/MovieDetails";
import history from "util/history";
//import PrivateRoute from "components/PrivateRoute";


const Routes = () => (

    <Router history={history}>
        <Navbar />
        <Switch>
            <Route path="/" exact>
                <Home />
            </Route>
            <Route path="/movies">
                <MovieList />
            </Route>
            <Route path="/movies/:movieId">
                <MovieDetails />
            </Route>
        </Switch>
    </Router>
);

export default Routes;