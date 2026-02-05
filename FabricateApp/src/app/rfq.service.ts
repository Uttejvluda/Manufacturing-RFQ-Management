import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Part } from './plant.service';
import { suppliers } from './supplier.service';

export interface rfq {
  rfqId: number,
  demandid: number,
  partId: number,
  quantity: number,
  partName: string,
  timetoSupply: number,
  specification: string

}


@Injectable({
  providedIn: 'root'
})
export class RfqService {

  constructor(private http: HttpClient) { }

 
  rfqId: number = 0;
  setRfqId(id: number) {
    this.rfqId = id;
  }

  getRfqId() {
    return this.rfqId;
  }

  getRFQDetails(): Observable<rfq> {
    return this.http.get<rfq>("http://localhost:8081/rfq/getRFQOfPlant");
  }

  getSuppliers(rfqid: number): Observable<suppliers> {
    return this.http.get<suppliers>("http://localhost:8081/rfq/getPotentialVendorsOfRFQ/" + rfqid);
  }
}
