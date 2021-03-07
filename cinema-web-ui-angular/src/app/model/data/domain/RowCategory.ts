import { Identifiable } from '../Identifiable';

export interface RowCategory extends Identifiable {
  priceInCents: number;
  name: string;
}
