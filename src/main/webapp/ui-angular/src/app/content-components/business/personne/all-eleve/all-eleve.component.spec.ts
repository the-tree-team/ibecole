import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllEleveComponent } from './all-eleve.component';

describe('AllEleveComponent', () => {
  let component: AllEleveComponent;
  let fixture: ComponentFixture<AllEleveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllEleveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllEleveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
