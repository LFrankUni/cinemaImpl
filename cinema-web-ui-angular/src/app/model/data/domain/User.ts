import { Identifiable } from '../Identifiable';

export interface User extends Identifiable {
  firstName: string;
  lastName: string;
  email: string;
  password: string;
}
