import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieShowListComponent } from './movie-show-list.component';

describe('MovieShowListComponent', () => {
  let component: MovieShowListComponent;
  let fixture: ComponentFixture<MovieShowListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MovieShowListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieShowListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
