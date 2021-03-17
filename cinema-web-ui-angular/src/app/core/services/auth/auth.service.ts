import { Injectable } from '@angular/core';
import { CinemaService } from '@core/data';
import { User } from '@model/data';
import { BehaviorSubject, Observable, of, throwError } from 'rxjs';
import { map, switchMap, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private readonly _user$: BehaviorSubject<User> = new BehaviorSubject<User>(
    null
  );

  constructor(private readonly cinema: CinemaService) {}

  public get user$() {
    return this._user$.asObservable();
  }

  public signUp(user: Omit<User, 'id'>): Observable<User> {
    return this.cinema
      .executeFunction<User>('signUp', [
        { type: 'String', value: user.firstName },
        { type: 'String', value: user.lastName },
        { type: 'String', value: user.email },
        { type: 'String', value: user.password },
      ])
      .pipe(
        map((res) => res.value),
        tap((user) => this._user$.next(user))
      );
  }

  public signIn({
    email,
    password,
  }: Pick<User, 'email' | 'password'>): Observable<User> {
    return this.cinema
      .executeFunction<User>('signIn', [
        { type: 'String', value: email },
        { type: 'String', value: password },
      ])
      .pipe(
        map((res) => res.value),
        tap((user) => this._user$.next(user))
      );
  }

  public signOut(): void {
    this._user$.next(null);
  }
}
