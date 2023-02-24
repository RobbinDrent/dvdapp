import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalAddFilmComponent } from './modal-add-film.component';

describe('ModelAddFilmComponent', () => {
  let component: ModalAddFilmComponent;
  let fixture: ComponentFixture<ModalAddFilmComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalAddFilmComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalAddFilmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
