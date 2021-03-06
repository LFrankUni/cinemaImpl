import { Component } from '@angular/core';
import { MediaService } from '@core/services';
import { Route } from '@model/routing';
import { APP_ROUTES, CINEMA_FEAUTURE } from 'src/app/app-routing.module';

@Component({
  selector: 'app-shell',
  templateUrl: './shell.component.html',
  styleUrls: ['./shell.component.scss'],
})
export class ShellComponent {
  public readonly home: string = CINEMA_FEAUTURE;
  public readonly routes: Route[];

  constructor(public readonly media: MediaService) {
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
