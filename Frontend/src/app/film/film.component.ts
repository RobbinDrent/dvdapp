import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {
  HttpClient,
  HttpErrorResponse,
  HttpResponse,
} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { FilmService } from './film.service';
import { Film } from './film';
import { FilmDTO } from './filmDTO';
import { NgForm } from '@angular/forms';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { ModalAddFilmComponent } from '../modal-add-film/modal-add-film.component';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.css'],
})
export class FilmComponent implements OnInit {
  title = 'DvdManager';
  public films: Film[] = [];

  constructor(
    private httpclient: HttpClient,
    private filmservice: FilmService,
    private matDialog: MatDialog
  ) {}

  ngOnInit() {
    this.getFilms();
  }

  public getFilms(): void {
    this.filmservice.getFilms().subscribe(
      (response: Film[]) => {
        this.films = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  onOpenDialog() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.data = {
      name: null,
      isSubmitted: true,
    };

    const dialogRef = this.matDialog.open(ModalAddFilmComponent, dialogConfig);

    dialogRef.afterClosed().subscribe((data) => {
      console.log(data);
      if (data.filmTitle !== null && data.isSubmitted) {
        this.filmservice.addFilm({ title: data.filmTitle }).subscribe({
          complete: () => {
            window.location.reload();
          },
          error: () => {
            alert('Film niet toegevoegd');
          },
        });
      }
    });
  }
}
