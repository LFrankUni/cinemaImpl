import { Component, Input, OnInit } from '@angular/core';
import { Row, Ticket, User } from '@model/data';
import { isNonNull } from '@utilities/isNonNull';

@Component({
  selector: 'app-movie-show-control',
  templateUrl: './movie-show-control.component.html',
  styleUrls: ['./movie-show-control.component.scss'],
})
export class MovieShowControlComponent {
  private _ticketMap: Map<string, Ticket[]> = new Map<string, Ticket[]>();

  @Input()
  public set tickets(value: Ticket[]) {
    if (isNonNull(value)) {
      value.forEach((ticket) => this._put(ticket));
    }
  }

  constructor() {}

  public get ticketMap() {
    return this._ticketMap;
  }

  private _put(ticket: Ticket): void {
    if (!isNonNull(this._ticketMap.get(ticket.seat.row.name)))
      this._ticketMap.set(ticket.seat.row.name, []);
    this._ticketMap.get(ticket.seat.row.name).push(ticket);
  }

  public _sort(ticket: Ticket[]): Ticket[] {
    return ticket.sort((a, b) => a.seat.number - b.seat.number);
  }

  public _color(ticket: Ticket, user: User): string {
    return;
  }
}
