import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '@environment';
import {
  Cinema,
  CinemaRequest,
  CinemaResponse,
  Parameter,
  Room,
  RowCategory,
} from '@model';
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

  public createObject<T>(
    type: string,
    parameter?: Parameter[]
  ): Observable<CinemaResponse<T>> {
    return this.createRequest({
      targetType: type,
      targetFunction: { name: this.CONSTRUCTOR_COMMAND, parameter },
    });
  }

  public executeFunction<T>(
    name: string,
    parameter?: Parameter[],
    targetId?: number,
    targetType: string = targetId == null ? this.SERVICE_NAME : undefined
  ): Observable<CinemaResponse<T>> {
    return this.createRequest({
      targetFunction: { name, parameter },
      targetType,
      targetId,
    });
  }

  public createCinema({
    nameOfCinema,
  }: Omit<Cinema, 'id'>): Observable<CinemaResponse<Cinema>> {
    return this.createObject('Cinema', [
      { type: 'String', value: nameOfCinema },
    ]);
  }

  public getAllCinemas(): Observable<CinemaResponse<Cinema[]>> {
    return this.executeFunction<Cinema[]>('getAllCinemas');
  }

  public addRoom(
    name: string,
    target: Cinema
  ): Observable<CinemaResponse<Room>> {
    return this.executeFunction(
      'addRoom',
      [{ type: 'String', value: name }],
      target.id,
      'Cinema'
    );
  }

  public createRowCategory({
    name,
    priceInCents,
  }: Omit<RowCategory, 'id'>): Observable<CinemaResponse<RowCategory>> {
    return this.createObject('RowCategory', [
      { type: 'String', value: name },
      { type: 'Integer', value: priceInCents },
    ]);
  }

  public getAllRowCategories(): Observable<CinemaResponse<RowCategory[]>> {
    return this.executeFunction('getAllRowCategories');
  }
}
