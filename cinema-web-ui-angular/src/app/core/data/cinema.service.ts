import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '@environment';
import {
  Cinema,
  CinemaRequest,
  CinemaResponse,
  Movie,
  MovieShow,
  Parameter,
  Room,
  Row,
  RowCategory,
  Seat,
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

  public getAllCategories(): Observable<CinemaResponse<RowCategory[]>> {
    return this.executeFunction<RowCategory[]>('getAllRowCategories');
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

  public openRoom(room: Room): Observable<CinemaResponse<void>> {
    return this.executeFunction('open', null, room.id, 'Room');
  }

  public closeRoom(room: Room): Observable<CinemaResponse<void>> {
    return this.executeFunction('close', null, room.id, 'Room');
  }

  public addRow(
    name: string,
    category: RowCategory,
    target: Room
  ): Observable<CinemaResponse<Row>> {
    return this.executeFunction(
      'addRow',
      [
        { type: 'String', value: name },
        { type: 'RowCategory', value: category.id },
      ],
      target.id,
      'Room'
    );
  }

  public addMovie(
    movie: Movie,
    target: Cinema
  ): Observable<CinemaResponse<Movie>> {
    return this.executeFunction(
      'addMovie',
      [{ type: 'Movie', value: movie.id }],
      target.id,
      'Cinema'
    );
  }

  public getAllRooms(cinema: Cinema): Observable<CinemaResponse<Room[]>> {
    return this.executeFunction('getAllRooms', null, cinema.id, 'Cinema');
  }

  public getAllMovies(cinema?: Cinema): Observable<CinemaResponse<Movie[]>> {
    return cinema
      ? this.executeFunction('getAllMovies', null, cinema.id, 'Cinema')
      : this.executeFunction('getAllMovies');
  }

  public getAllRows(room: Room): Observable<CinemaResponse<Row[]>> {
    return this.executeFunction('getAllRows', null, room.id, 'Room');
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

  public addSeats(
    numberOfSeats: number,
    target: Row
  ): Observable<CinemaResponse<Seat[]>> {
    return this.executeFunction(
      'addSeats',
      [{ type: 'Integer', value: numberOfSeats }],
      target.id,
      'RoomRow'
    );
  }

  public getAllSeats(row: Row): Observable<CinemaResponse<Seat[]>> {
    return this.executeFunction('getAllSeats', null, row.id, 'RoomRow');
  }

  public getAllMovieShows(
    from: Date,
    to: Date,
    cinema: Cinema,
    target: Movie
  ): Observable<CinemaResponse<MovieShow[]>> {
    return this.executeFunction(
      'getAllMovieShows',
      [
        { type: 'String', value: from.toISOString() },
        { type: 'String', value: to.toISOString() },
        { type: 'Cinema', value: cinema.id },
      ],
      target.id,
      'Movie'
    );
  }
}
