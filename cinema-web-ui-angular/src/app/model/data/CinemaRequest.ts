export interface CinemaRequest {
  targetType: string;
  targetFunction: Function;
}

export interface Function {
  name: string;
  parameter?: Parameter[];
}

export interface Parameter {
  type: string;
  value: any;
}
