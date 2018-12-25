import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditTypeSanctionComponent } from './edit-type-sanction.component';

describe('EditTypeSanctionComponent', () => {
  let component: EditTypeSanctionComponent;
  let fixture: ComponentFixture<EditTypeSanctionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditTypeSanctionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditTypeSanctionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
