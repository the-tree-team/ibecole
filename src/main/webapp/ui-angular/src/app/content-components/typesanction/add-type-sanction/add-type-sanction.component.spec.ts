import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTypeSanctionComponent } from './add-type-sanction.component';

describe('AddTypeSanctionComponent', () => {
  let component: AddTypeSanctionComponent;
  let fixture: ComponentFixture<AddTypeSanctionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddTypeSanctionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddTypeSanctionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
