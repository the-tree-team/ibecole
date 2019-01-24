import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllProfesseurComponent } from './all-professeur.component';

describe('AllProfesseurComponent', () => {
  let component: AllProfesseurComponent;
  let fixture: ComponentFixture<AllProfesseurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllProfesseurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllProfesseurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
