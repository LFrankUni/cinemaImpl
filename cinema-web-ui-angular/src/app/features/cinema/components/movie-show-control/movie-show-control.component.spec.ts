import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieShowControlComponent } from './movie-show-control.component';

describe('MovieShowControlComponent', () => {
  let component: MovieShowControlComponent;
  let fixture: ComponentFixture<MovieShowControlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MovieShowControlComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieShowControlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
