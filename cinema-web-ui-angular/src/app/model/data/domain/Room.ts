import { Identifiable } from '../Identifiable';

export interface Room extends Identifiable {
  nameOfRoom: string;
  open: boolean;
}
