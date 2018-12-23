import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditTypeSanctionComponent } from './add-edit-type-sanction.component';

describe('AddEditTypeSanctionComponent', () => {
  let component: AddEditTypeSanctionComponent;
  let fixture: ComponentFixture<AddEditTypeSanctionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddEditTypeSanctionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditTypeSanctionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
