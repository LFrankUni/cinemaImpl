import { Identifiable } from '../Identifiable';
import { Seat } from './Seat';
import { User } from './User';

export interface Ticket extends Identifiable {
  seat?: Seat;
  state?: string;
  user?: User;
  price?: number;
}
