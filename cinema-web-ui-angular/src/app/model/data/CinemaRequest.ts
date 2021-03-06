export interface CinemaRequest {
  targetType: string;
  targetFunction: Function;
  targetId?: number;
}

export interface Function {
  name: string;
  parameter?: Parameter[];
}

export interface Parameter {
  type: string;
  value: any;
}
