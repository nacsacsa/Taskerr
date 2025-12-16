import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../app/table-service';


@Injectable({
  providedIn: 'root',
})
export class TaskService {

  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  private getHeaders(): HttpHeaders {
    return new HttpHeaders({Authorization: `Bearer ${localStorage.getItem('token')}`,});
  }

  createTask(task: Task): Observable<Task> {
    return this.http.post<Task>(`${this.baseUrl}/task/create`, task, { headers: this.getHeaders() });
  }

  updateTask(task: Task): Observable<Task> {
    return this.http.put<Task>(`${this.baseUrl}/task/update`, task, { headers: this.getHeaders() });
  }

  deleteTask(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/task/delete?id=${id}`, { headers: this.getHeaders() });
  }

  getTasksByTable(tableId: number): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.baseUrl}/task/table?Id=${tableId}`, { headers: this.getHeaders() });
  }
}