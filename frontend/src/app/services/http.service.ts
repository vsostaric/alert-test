import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {environment} from '../../environments/environment';

@Injectable()
export class HttpRequestService {

  baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) {
  }

  public sendPostRequest(url: string, body, success, error) {

    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    headers.append('charset', 'utf-8');
    headers.append('timeout', '30000');

    this.http.post(this.baseUrl + url, body, {headers: headers, withCredentials: true}).subscribe(success, error);

  }

  public sendGetRequest(url) {
    const headers = new HttpHeaders();
    headers.append('timeout', '30000');
    return this.http.get(this.baseUrl + url, {headers});
  }
}
