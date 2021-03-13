import { Identifiable } from '../Identifiable';

export interface MovieShow extends Identifiable {
  start: string;
  end: string;
  threeDimensional: boolean;
  priceInCent: number;
}
