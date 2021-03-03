import { Component, OnInit } from '@angular/core';
import { CinemaService } from '@core';
import { Cinema } from '@model';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.scss'],
})
export class OverviewComponent implements OnInit {
  private _cinemas$: Observable<Cinema[]>;

  constructor(private readonly cinemaService: CinemaService) {}

  ngOnInit(): void {
    this._cinemas$ = this.cinemaService
      .executeFunction<Cinema[]>('getAllCinemas')
      .pipe(map((res) => res.value));
  }

  public get cinemas$(): Observable<Cinema[]> {
    return this._cinemas$;
  }
}
