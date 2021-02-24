import type { Observable } from "rxjs";
import { ajax } from "rxjs/ajax";
import { pluck } from "rxjs/operators";
import type { CinemaRequest, CinemaResponse, Parameter } from "../../model";

const CONSTRUCTOR_COMMAND: string = "constructor";
const SERVICE_NAME: string = "Service";

function createRequest<T>(body: CinemaRequest): Observable<CinemaResponse<T>> {
  return ajax({
    url: "http://localhost:8080/cinema-rest-api/command",
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(body),
  }).pipe(pluck("response"));
}

export function createObject<T>(type: string): Observable<CinemaResponse<T>> {
  return createRequest({ targetType: type, targetFunction: { name: CONSTRUCTOR_COMMAND } });
}

export function executeFunction<T>(name: string, parameter?: Parameter[], targetType: string = SERVICE_NAME): Observable<CinemaResponse<T>> {
  return createRequest({ targetFunction: { name, parameter }, targetType });
}
