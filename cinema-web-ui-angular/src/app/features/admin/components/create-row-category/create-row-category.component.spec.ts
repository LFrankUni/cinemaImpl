import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateRowCategoryComponent } from './create-row-category.component';

describe('CreateRowCategoryComponent', () => {
  let component: CreateRowCategoryComponent;
  let fixture: ComponentFixture<CreateRowCategoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateRowCategoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateRowCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
