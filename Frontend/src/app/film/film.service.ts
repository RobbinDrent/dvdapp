import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Film } from './film';
import { FilmDTO } from './filmDTO';

@Injectable({
  providedIn: 'root'
})
export class FilmService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getFilms(): Observable<Film[]> {
    return this.http.get<Film[]>(`${this.apiServerUrl}/film/all`);
  }


public addFilm(filmDTO: FilmDTO) : Observable<FilmDTO> {
  console.log('service');
  return this.http.post<FilmDTO>(`${this.apiServerUrl}/film/add`, filmDTO);
}
}