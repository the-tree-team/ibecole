import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEnfantsDialogComponent } from './add-enfants-dialog.component';

describe('AddEnfantsDialogComponent', () => {
  let component: AddEnfantsDialogComponent;
  let fixture: ComponentFixture<AddEnfantsDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddEnfantsDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEnfantsDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
