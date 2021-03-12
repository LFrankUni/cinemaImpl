import { Identifiable } from '../Identifiable';
import { Movie } from './Movie';

export interface MovieShow extends Identifiable {
  start: string;
  end: string;
  threeDimensional: boolean;
  priceInCent: number;
  movie?: Movie;
}
