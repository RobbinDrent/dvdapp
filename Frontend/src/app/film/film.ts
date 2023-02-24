export interface Film {
    filmId: number;
    title: string;
    discs: Set<any>;
    directors: Set<any>;
}