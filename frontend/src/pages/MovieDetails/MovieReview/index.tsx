import { ReactComponent as StarImage } from 'assets/images/star.svg';
import { Review } from 'types/review';
import './styles.css';

type Props = {
    review: Review;
}

const MovieReview = ({ review }: Props) => {

    return (
        <div className="movie-comments-container">
            <div className="movie-details-user">
                <StarImage />
                <h2> {review.user.name} </h2>
            </div>
            <div className="movie-comments">
                {review.text}
            </div>
        </div>
    )
}

export default MovieReview;