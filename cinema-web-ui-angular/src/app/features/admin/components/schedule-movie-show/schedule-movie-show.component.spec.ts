import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleMovieShowComponent } from './schedule-movie-show.component';

describe('ScheduleMovieShowComponent', () => {
  let component: ScheduleMovieShowComponent;
  let fixture: ComponentFixture<ScheduleMovieShowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ScheduleMovieShowComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ScheduleMovieShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
