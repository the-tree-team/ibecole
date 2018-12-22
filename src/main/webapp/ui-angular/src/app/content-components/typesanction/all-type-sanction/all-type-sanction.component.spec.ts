import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllTypeSanctionComponent } from './all-type-sanction.component';

describe('AllTypeSanctionComponent', () => {
  let component: AllTypeSanctionComponent;
  let fixture: ComponentFixture<AllTypeSanctionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllTypeSanctionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllTypeSanctionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
