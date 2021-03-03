import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieShowCardComponent } from './movie-show-card.component';

describe('MovieShowCardComponent', () => {
  let component: MovieShowCardComponent;
  let fixture: ComponentFixture<MovieShowCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MovieShowCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieShowCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
