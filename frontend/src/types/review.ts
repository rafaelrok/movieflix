import { Movie } from './movie';
import { User } from './user';

export type Review = {
  id: number;
  text: string;
  user: User;
  movie: Movie;
};
