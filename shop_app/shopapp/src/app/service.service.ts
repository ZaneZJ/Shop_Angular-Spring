import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Service } from './service';

@Injectable({
    providedIn: 'root'
})
export class ServiceService {
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }

    public getAllServices(): Observable<Service[]> {
        return this.http.get<Service[]>(`${this.apiServerUrl}/shop/service/all`);
    }

    public getServicesByTheme(theme: string): Observable<Service[]> {
        return this.http.get<Service[]>(`${this.apiServerUrl}/shop/service/all/${theme}`);
    }

    public addService(service: Service): Observable<Service> {
        return this.http.post<Service>(`${this.apiServerUrl}/shop/service/add`, service);
    }

    // public updateUser(user: User): Observable<User> {
    //     return this.http.put<User>(`${this.apiServerUrl}/shop/update`, user);
    // }

    public deleteService(username: string, serviceId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/shop/service/delete/${username}/${serviceId}`);
    }
}
