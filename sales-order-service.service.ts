import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http'
import { from } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SalesOrderServiceService {

  constructor(private http:HttpClient) { }

     getSalesorder(){
       return this.http.get('')

       
     }
}
