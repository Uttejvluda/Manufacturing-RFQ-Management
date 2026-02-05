import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
export interface suppliers{
  supplier_id:number,
  name:string,
  email:string,
  phone:number,
  location:string,
  feedback:number
}

@Injectable({
  providedIn: 'root'
})

export class SupplierService {

  constructor(private http:HttpClient) { }
 
  addSupplier(s:suppliers){
    return this.http.post<suppliers[]>('http://localhost:8080/supplier/addSupplier',s);
  }

  getsupplier():Observable<suppliers[]>{
    return this.http.get<suppliers[]>("http://localhost:8080/supplier/getAllSuppliers");
  }

  updatesupplier(s:suppliers){
    console.log("called");
    return this.http.post<suppliers[]>('http://localhost:8080/supplier/editSupplier',s);
  }

  updateFeedback(s:suppliers){
    return this.http.post<suppliers[]>('http://localhost:8080/supplier/updateFeedback',s);
  }
  
}
