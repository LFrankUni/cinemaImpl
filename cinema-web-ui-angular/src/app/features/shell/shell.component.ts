import { Component } from '@angular/core';
import { MediaService } from '@core/services';
import { Route } from '@model/routing';

@Component({
  selector: 'app-shell',
  templateUrl: './shell.component.html',
  styleUrls: ['./shell.component.scss'],
})
export class ShellComponent {
  public readonly home: string = '';
  public readonly routes: Route[];

  constructor(public readonly media: MediaService) {
    this.routes = this.createAbsolutePaths([]);
  }

  private createAbsolutePaths(routes: Route[], prefix: string = ''): Route[] {
    return routes?.map((route) => ({
      name: route.name,
      path: `${prefix}/${route.path}`,
      children: this.createAbsolutePaths(route.children, route.path),
    }));
  }
}
