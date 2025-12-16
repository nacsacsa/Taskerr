import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private authUrl: string = 'http://localhost:8080/auth/login';
  private registationUrl: string = 'http://localhost:8080/auth/registration';

  constructor(private http: HttpClient) {}

  login(email: string, password: string): Observable<any>{
    return this.http.post(this.authUrl, {email, password}, {responseType:'text'})
  }

  registation(name: string, email: string, password: string): Observable<any>{
    return this.http.post(this.registationUrl, {name, email, password}, {responseType:'text'})
  }
}
