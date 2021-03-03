import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '@environment';
import { CinemaRequest, CinemaResponse, Parameter } from '@model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CinemaService {
  private readonly COMMAND_RESOURCE: string = 'command';
  private readonly CONSTRUCTOR_COMMAND: string = 'constructor';
  private readonly SERVICE_NAME: string = 'Service';

  constructor(private readonly http: HttpClient) {}

  private createRequest<T>(body: CinemaRequest): Observable<CinemaResponse<T>> {
    return this.http.post(
      `${environment.api.url}/${this.COMMAND_RESOURCE}`,
      body,
      {
        headers: { 'Content-Type': 'application/json' },
      }
    );
  }

  public createObject<T>(type: string): Observable<CinemaResponse<T>> {
    return this.createRequest({
      targetType: type,
      targetFunction: { name: this.CONSTRUCTOR_COMMAND },
    });
  }

  public executeFunction<T>(
    name: string,
    parameter?: Parameter[],
    targetType: string = this.SERVICE_NAME
  ): Observable<CinemaResponse<T>> {
    return this.createRequest({
      targetFunction: { name, parameter },
      targetType,
    });
  }
}
