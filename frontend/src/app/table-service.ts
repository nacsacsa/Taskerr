import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

export interface User {
  id?: number;
  name?: string;
  email?: string;
}

export interface Task {
  id?: number;
  table?: Table;
  name?: string;
  description?: string;
  done?: boolean;
}

export interface Table {
  id?: number;
  user?: User;  
  name: string;
  tasks?: Task[];
}


@Injectable({
  providedIn: 'root',
})
export class TableService {
  private baseUrl = 'http://localhost:8080/api/table'
  constructor(private http: HttpClient) {}

  private getHeaders(){
    return new HttpHeaders({'Authorization': `Bearer ${localStorage.getItem('token')}`,
    'Access-Control-Allow-Origin':'*'});
  }

  createTable(name: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/create`, { name }, { headers: this.getHeaders() });
  }

  updateTable(table: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/update`, table, { headers: this.getHeaders() });
  }

  deleteTable(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete?id=${id}`, { headers: this.getHeaders() });
  }

  getTablesByUser(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/user`, { headers: this.getHeaders() });
  }
}
