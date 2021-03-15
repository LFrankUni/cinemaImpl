import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CinemaService } from '@core/data';
import {
  MOVIE_SHOW_QUERY_PARAM_CINEMA_ID,
  MOVIE_SHOW_QUERY_PARAM_SHOW_ID,
} from '@features/cinema/routes/constants';
import { Cinema, Movie, MovieShow, Room, Ticket } from '@model/data';
import { forkJoin, Observable } from 'rxjs';
import { map, pluck, shareReplay, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-movie-show',
  templateUrl: './movie-show.component.html',
  styleUrls: ['./movie-show.component.scss'],
})
export class MovieShowComponent implements OnInit {
  public cinema$: Observable<Cinema>;
  public movieShow$: Observable<MovieShow>;
  public movie$: Observable<Movie>;
  public room$: Observable<Room>;
  public tickets$: Observable<Ticket[]>;

  constructor(
    private readonly route: ActivatedRoute,
    private readonly cinemaService: CinemaService
  ) {}

  ngOnInit(): void {
    this.cinema$ = this.route.queryParams.pipe(
      pluck(MOVIE_SHOW_QUERY_PARAM_CINEMA_ID),
      switchMap((id) => this.cinemaService.getObject<Cinema>(id))
    );
    this.movieShow$ = this.route.queryParams.pipe(
      pluck(MOVIE_SHOW_QUERY_PARAM_SHOW_ID),
      switchMap((id) => this.cinemaService.getObject<MovieShow>(id)),
      shareReplay(1)
    );
    this.movie$ = this.movieShow$.pipe(
      switchMap((show) => this.cinemaService.getTheMovie(show)),
      map((res) => res.value)
    );
    this.tickets$ = this.movieShow$.pipe(
      switchMap((show) => this.cinemaService.getAllTickets(show)),
      map((res) => res.value),
      switchMap((tickets) =>
        forkJoin(
          tickets.map((ticket) =>
            this.cinemaService
              .getTheSeat(ticket)
              .pipe(
                map((res) => res.value),
                switchMap((seat) =>
                  this.cinemaService
                    .getTheRow(seat)
                    .pipe(map((res) => ({ ...seat, row: res.value })))
                )
              )
              .pipe(
                map((seat) => ({ ...ticket, seat })),
                switchMap((ticket) =>
                  this.cinemaService.getTheState(ticket).pipe(
                    map((res) => res.value),
                    map((state) => ({ ...ticket, state: state }))
                  )
                ),
                switchMap((ticket) =>
                  this.cinemaService.getTheUser(ticket).pipe(
                    map((res) => res.value),
                    map((user) => ({ ...ticket, user: user }))
                  )
                )
              )
          )
        )
      )
    );

    this.room$ = this.movieShow$.pipe(
      switchMap((show) => this.cinemaService.getTheRoom(show)),
      map((res) => res.value)
    );
  }
}
