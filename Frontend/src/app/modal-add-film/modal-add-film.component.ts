import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { FilmComponent } from '../film/film.component';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-modal-add-film',
  templateUrl: './modal-add-film.component.html',
  styleUrls: ['./modal-add-film.component.css']
})
export class ModalAddFilmComponent implements OnInit {
  form!: FormGroup;
  title: string;
  hasFailed: boolean = false;
  errormessage?: string;
  isSubmitted: boolean;

  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<ModalAddFilmComponent>,
    @Inject(MAT_DIALOG_DATA) data: any
  ) {
    this.title = data.title;
    this.isSubmitted = data.isSubmitted;
  
  }
  ngOnInit(): void {
    this.form = this.fb.group({
      filmTitle: new FormControl('', [Validators.required]),
      isSubmitted: this.isSubmitted,
    })
  }

  close() {
    this.isSubmitted = false;
    this.dialogRef.close(this.isSubmitted);
  }

  save() {
    if (this.form.value.filmTitle === null) {
      this.hasFailed = true;
      this.errormessage = 'Voer een titel in';
    } else {
      this.isSubmitted = true;
      this.dialogRef.close(this.form.value);
    }
  }

  public myError = (controlName: string, errorName: string) => {
    return this.form.controls[controlName].hasError(errorName);
  }


}
