import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface IpQuery {
  id: string;
  ip: string;
  city: string;
  region: string;
  country: string;
  loc: string;
  org: string;
  postal: string;
  timezone: string;
}

@Injectable({
  providedIn: 'root'
})
export class IpQueryService {
  private baseUrl = 'https://fantastic-fishstick-vj44ggj4xrq3pqjv-9090.app.github.dev/api/v1';

  constructor(private http: HttpClient) {}

  getMyIp(): Observable<IpQuery> {
    return this.http.get<IpQuery>(`${this.baseUrl}/miIp`);
  }

  getIpDetails(): Observable<IpQuery> {
    return this.http.get<IpQuery>(`${this.baseUrl}/detalle`);
  }

  queryIp(ip: string): Observable<IpQuery> {
    return this.http.get<IpQuery>(`${this.baseUrl}/consulta/${ip}`);
  }
}
