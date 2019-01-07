import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectedEnfantsComponent } from './selected-enfants.component';

describe('SelectedEnfantsComponent', () => {
  let component: SelectedEnfantsComponent;
  let fixture: ComponentFixture<SelectedEnfantsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectedEnfantsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectedEnfantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
