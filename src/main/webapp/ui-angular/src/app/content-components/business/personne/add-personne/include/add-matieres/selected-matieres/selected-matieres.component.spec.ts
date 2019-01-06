import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectedMatieresComponent } from './selected-matieres.component';

describe('SelectedMatieresComponent', () => {
  let component: SelectedMatieresComponent;
  let fixture: ComponentFixture<SelectedMatieresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectedMatieresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectedMatieresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
