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

    public getAllUsers(): Observable<User[]> {
        return this.http.get<User[]>(`${this.apiServerUrl}/shop/all`);
    }    
    
    public getUserByUsername(username: string): Observable<User> {
        return this.http.get<User>(`${this.apiServerUrl}/shop/find/${username}`);
    }

    public addUser(user: User): Observable<User> {
        return this.http.post<User>(`${this.apiServerUrl}/shop/add`, user);
    }

    public updateUser(user: User): Observable<User> {
        return this.http.put<User>(`${this.apiServerUrl}/shop/update`, user);
    }

    public deleteUser(userId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/shop/delete/${userId}`);
    }

    public signInUser(username: string, password: string): Observable<User> {
        return this.http.get<User>(`${this.apiServerUrl}/shop/signIn/${username}/${password}`);
    }
}
