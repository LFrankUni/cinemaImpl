import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '@environment';
import {
  Cinema,
  CinemaRequest,
  CinemaResponse,
  Identifiable,
  Movie,
  MovieShow,
  Parameter,
  Room,
  Row,
  RowCategory,
  Seat,
  Ticket,
  User,
} from '@model';
import { isNonNull } from '@utilities/isNonNull';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CinemaService {
  private readonly COMMAND_RESOURCE: string = 'command';
  private readonly OBJECT_RESOURCE: string = 'object';
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

  public getObject<T>(id: string): Observable<T> {
    return this.http.get<T>(
      `${environment.api.url}/${this.OBJECT_RESOURCE}/${id}`
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

  public income(): Observable<CinemaResponse<number>> {
    return this.executeFunction('income');
  }
  public income_cinema(cinema: Cinema): Observable<CinemaResponse<number>> {
    return this.executeFunction('income', null, cinema.id, 'Cinema');
  }
  public income_movie(movie: Movie): Observable<CinemaResponse<number>> {
    return this.executeFunction('income', null, movie.id, 'Movie');
  }
  public income_room(room: Room): Observable<CinemaResponse<number>> {
    return this.executeFunction('income', null, room.id, 'Room');
  }
  public income_show(show: MovieShow): Observable<CinemaResponse<number>> {
    return this.executeFunction('income', null, show.id, 'MovieShow');
  }

  public getTheMovie(movieShow: MovieShow): Observable<CinemaResponse<Movie>> {
    return this.executeFunction('getTheMovie', null, movieShow.id, 'MovieShow');
  }

  public getTheRoom(movieShow: MovieShow): Observable<CinemaResponse<Room>> {
    return this.executeFunction('getTheRoom', null, movieShow.id, 'MovieShow');
  }

  public getTheSeat(ticket: Ticket): Observable<CinemaResponse<Seat>> {
    return this.executeFunction('getTheSeat', null, ticket.id, 'Ticket');
  }

  public getThePrice(ticket: Ticket): Observable<CinemaResponse<number>> {
    return this.executeFunction('getPrice', null, ticket.id, 'Ticket');
  }

  public getTheUser(ticket: Ticket): Observable<CinemaResponse<User>> {
    return this.executeFunction('getTheUser', null, ticket.id, 'Ticket');
  }

  public getTheRow(seat: Seat): Observable<CinemaResponse<Row>> {
    return this.executeFunction('getTheRow', null, seat.id, 'Seat');
  }

  public getTheState(ticket: Ticket): Observable<CinemaResponse<string>> {
    return this.executeFunction('getTheState', null, ticket.id, 'Ticket');
  }

  public getAllTickets(
    movieShow: MovieShow
  ): Observable<CinemaResponse<Ticket[]>> {
    return this.executeFunction(
      'getAllTickets',
      null,
      movieShow.id,
      'MovieShow'
    );
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
  public availableMovies(cinema: Cinema): Observable<CinemaResponse<Movie[]>> {
    return this.executeFunction('availableMovies', null, cinema.id, 'Cinema');
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

  public getAllMovieShows_room(
    from: Date,
    to: Date,
    room: Room
  ): Observable<CinemaResponse<MovieShow[]>> {
    return this.executeFunction(
      'getScheduledMovieShows',
      [
        { type: 'String', value: from.toISOString() },
        { type: 'String', value: to.toISOString() },
      ],
      room.id,
      'Room'
    );
  }

  public scheduleMovieShows(
    movie: Movie,
    start: Date,
    days: number,
    threeDimensional: boolean,
    price: number,
    target: Room
  ): Observable<CinemaResponse<MovieShow[]>> {
    return this.executeFunction(
      'scheduleMovieShows',
      [
        { type: 'Movie', value: movie.id },
        { type: 'String', value: start.toISOString() },
        { type: 'Integer', value: days },
        { type: 'Boolean', value: threeDimensional },
        { type: 'Integer', value: price },
      ],
      target.id,
      'Room'
    );
  }

  public checkSchedule(
    movie: Movie,
    start: Date,
    days: number,
    target: Room
  ): Observable<CinemaResponse<MovieShow[]>> {
    return this.executeFunction(
      'checkSchedule',
      [
        { type: 'Movie', value: movie.id },
        { type: 'String', value: start.toISOString() },
        { type: 'Integer', value: days },
      ],
      target.id,
      'Room'
    );
  }

  public reserve(
    user: User,
    target: Ticket
  ): Observable<CinemaResponse<Ticket>> {
    return this.executeFunction(
      'reserve',
      [{ type: 'User', value: user.id }],
      target.id,
      'Ticket'
    );
  }
  public unreserve(ticket: Ticket): Observable<CinemaResponse<Ticket>> {
    return this.executeFunction('unreserve', null, ticket.id, 'Ticket');
  }
  public book(ticket: Ticket): Observable<CinemaResponse<Ticket>> {
    return this.executeFunction('book', null, ticket.id, 'Ticket');
  }

  public getScheduledMovieShows(
    from: Date,
    to: Date,
    target: Cinema
  ): Observable<CinemaResponse<MovieShow[]>> {
    return this.executeFunction(
      'getScheduledMovieShows',
      [
        { type: 'String', value: from },
        { type: 'String', value: to },
      ],
      target.id,
      'Cinema'
    );
  }
}
