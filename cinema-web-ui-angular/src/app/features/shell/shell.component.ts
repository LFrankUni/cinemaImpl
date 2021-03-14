import { Component } from '@angular/core';
import { AuthService, MediaService } from '@core/services';
import { Route } from '@model/routing';
import { AuthDialogService } from '@shared/auth/auth-dialog.service';
import { APP_ROUTES, CINEMA_FEAUTURE } from 'src/app/app-routing.module';

@Component({
  selector: 'app-shell',
  templateUrl: './shell.component.html',
  styleUrls: ['./shell.component.scss'],
})
export class ShellComponent {
  public readonly home: string = CINEMA_FEAUTURE;
  public readonly routes: Route[];

  constructor(
    public readonly media: MediaService,
    public readonly authDialog: AuthDialogService,
    public readonly auth: AuthService
  ) {
    this.routes = this.createAbsolutePaths(APP_ROUTES);
  }

  private createAbsolutePaths(routes: Route[], prefix: string = ''): Route[] {
    return routes?.map((route) => ({
      name: route.name,
      path: `${prefix}/${route.path}`,
      children: this.createAbsolutePaths(route.children, route.path),
    }));
  }
}
