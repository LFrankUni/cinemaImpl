import { Component, Input, ViewEncapsulation } from '@angular/core';
import { MatListOption } from '@angular/material/list';
import { CinemaService } from '@core/data';
import { AuthService } from '@core/services';
import { Ticket } from '@model/data';
import { AuthDialogService } from '@shared/auth/auth-dialog.service';
import { isNonNull } from '@utilities/isNonNull';
import { from, Observable } from 'rxjs';
import { filter, map, mergeAll, switchMap, take, tap } from 'rxjs/operators';

@Component({
  selector: 'app-movie-show-control',
  templateUrl: './movie-show-control.component.html',
  styleUrls: ['./movie-show-control.component.scss'],
  encapsulation: ViewEncapsulation.None,
})
export class MovieShowControlComponent {
  private _ticketMap: Map<string, Ticket[]>;
  private _selectedTickets: Ticket[] = [];

  @Input()
  public set tickets(value: Ticket[]) {
    if (isNonNull(value)) {
      this._ticketMap = new Map<string, Ticket[]>();
      value.forEach((ticket) => this._put(ticket));
      this.auth.user$
        .pipe(
          filter(isNonNull),
          map((user) =>
            value.filter(
              (ticket) =>
                ticket.state !== 'Available' && ticket?.user?.id == user.id
            )
          )
        )
        .subscribe({
          next: (tickets) =>
            (this._selectedTickets = [...this._selectedTickets, ...tickets]),
        });
    }
  }

  constructor(
    private readonly cinema: CinemaService,
    public readonly auth: AuthService,
    public readonly authDialog: AuthDialogService
  ) {}

  public get ticketMap() {
    return this._ticketMap;
  }

  public get selectedTickets(): Ticket[] {
    return this._selectedTickets;
  }

  private _put(ticket: Ticket): void {
    if (!isNonNull(this._ticketMap.get(ticket.seat.row.name)))
      this._ticketMap.set(ticket.seat.row.name, []);
    this._ticketMap.get(ticket.seat.row.name).push(ticket);
  }

  public _sort(ticket: Ticket[]): Ticket[] {
    return ticket.sort((a, b) => a.seat.number - b.seat.number);
  }

  public _color(ticket: Ticket): Observable<string> {
    return this.auth.user$.pipe(
      map((user) => {
        if (
          ticket.state === 'Available' &&
          this._selectedTickets.some((x) => x.id === ticket.id)
        )
          return 'accent';
        if (ticket.state === 'Available') return 'success';
        if (ticket.state === 'Reserved' && ticket?.user?.id === user?.id)
          return 'warn-light';
        if (ticket.state === 'Booked' && ticket?.user?.id === user?.id)
          return 'black';
      })
    );
  }
  public _disabled(ticket: Ticket): Observable<boolean> {
    return this.auth.user$.pipe(
      map(
        (user) => ticket.state !== 'Available' && ticket?.user?.id !== user?.id
      )
    );
  }

  public _onClickTicket(ticket: Ticket): void {
    if (ticket.state === 'Available') {
      if (this.selectedTickets.includes(ticket))
        this._selectedTickets = this.selectedTickets.filter(
          (curr) => curr.id !== ticket.id
        );
      else this.selectedTickets.push(ticket);
    }
  }

  public _onDelete(ticket: Ticket): void {
    if (ticket.state === 'Available')
      this._selectedTickets = this._selectedTickets.filter(
        (x) => x.id !== ticket.id
      );
    else if (ticket.state === 'Reserved') this._onUnreserve(ticket);
  }

  public _total(tickets: Ticket[]): number {
    return tickets
      .filter((ticket) => ticket.state === 'Reserved')
      .map((ticket) => ticket.price)
      .reduce((sum, next) => (sum += next), 0);
  }

  public _bookDisable(tickets: Ticket[]): boolean {
    return !tickets.some((ticket) => ticket.state === 'Reserved');
  }

  public _onReserve(selected: MatListOption[]): void {
    const tickets = selected
      .map((x) => x.value)
      .filter((ticket) => ticket.state === 'Available');

    this.auth.user$
      .pipe(
        take(1),
        switchMap((user) =>
          from(
            tickets.map((ticket) =>
              this.cinema.reserve(user, ticket).pipe(
                tap(() => {
                  ticket.state = 'Reserved';
                  ticket.user = user;
                })
              )
            )
          ).pipe(mergeAll(1))
        )
      )
      .subscribe();
  }

  public _onUnreserve(ticket: Ticket): void {
    this.cinema.unreserve(ticket).subscribe({
      next: (_) => {
        ticket.user = null;
        (ticket.state = 'Available'),
          (this._selectedTickets = this._selectedTickets.filter(
            (x) => x.id !== ticket.id
          ));
      },
    });
  }

  public _onBook(selected: MatListOption[]): void {
    from(
      selected
        .map((x) => x.value)
        .filter((ticket) => ticket.state === 'Reserved')
        .map((ticket) =>
          this.cinema.book(ticket).pipe(tap(() => (ticket.state = 'Booked')))
        )
    )
      .pipe(mergeAll(1))
      .subscribe();
  }
}
