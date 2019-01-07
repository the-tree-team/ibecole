import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMatieresDialogComponent } from './add-matieres-dialog.component';

describe('AddMatieresDialogComponent', () => {
  let component: AddMatieresDialogComponent;
  let fixture: ComponentFixture<AddMatieresDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddMatieresDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMatieresDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
