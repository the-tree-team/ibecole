import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllSanctionComponent } from './all-sanction.component';

describe('AllSanctionComponent', () => {
  let component: AllSanctionComponent;
  let fixture: ComponentFixture<AllSanctionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllSanctionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllSanctionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
