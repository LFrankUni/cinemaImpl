import { Identifiable } from '../Identifiable';
import { Row } from './Row';

export interface Seat extends Identifiable {
  number: number;
  row?: Row;
}
