import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
    providedIn: 'root'
})
export class UserService {
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }

    public getUser(): Observable<User[]> {
        return this.http.get<User[]>(`${this.apiServerUrl}/shop/all`);
    }

    public addUser(user: User): Observable<User> {
        return this.http.post<User>(`${this.apiServerUrl}/shop/add`, user);
    }

    public updateUser(user: User): Observable<User> {
        return this.http.put<User>(`${this.apiServerUrl}/shop/update`, user);
    }

    public deleteUser(user_userId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/shop/delete/${user_userId}`);
    }
}
