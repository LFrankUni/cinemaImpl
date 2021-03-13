import { Identifiable } from '../Identifiable';
import { Seat } from './Seat';

export interface Ticket extends Identifiable {
  seat?: Seat;
  state?: string;
}
