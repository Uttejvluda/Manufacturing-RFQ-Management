
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


export interface Part{
  partId:number,
  partDescription:string,
  partSpecification:string,
  stockInHand:number
}
export interface partreorderdetails{
  prrid:number,
  reorderstatus:string,
  date:Date,
  part:Part
}
export interface Result{
  result:string;
}
@Injectable({
  providedIn: 'root'
})
export class PlantService {

  constructor(private http:HttpClient) { }

  id:number=0;
  setId(i:number){
    this.id=i;
  }
  details={id:0,min:0,max:0}

  getPartReorderDetails():Observable<Part[]>{
    return this.http.get<Part[]>("http://localhost:8082/plant/viewPartsReOrder");
  }

  getStockDetails(i:number):Observable<Part>{
    return this.http.get<Part>("http://localhost:8082/plant/viewStockInHand/"+i);
  }

  updateMinAndMax(id:number,min:number,max:number):Observable<Result>{
    this.details={id:id,min:min,max:max}
    return this.http.put<Result>("http://localhost:8082/plant/updateMinMaxQuantity?id="+id+"&min="+min+"&max="+max,this.details);
  }
}
