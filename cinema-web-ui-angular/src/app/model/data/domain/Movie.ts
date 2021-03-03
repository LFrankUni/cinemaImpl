import { Identifiable } from '../Identifiable';

export interface Movie extends Identifiable {
  title: string;
  description: string;
  minutes: string;
}
