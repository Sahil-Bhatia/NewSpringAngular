import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';

let URL = "http://localhost:5000/wallet/";

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http:HttpClient) { }



  findByMobile(mobile:number):Observable<any>{
 
    return this.http.get(URL+"find/"+mobile);
}


getAllAccounts():Observable<any>{
  let options = { "headers": 
              new HttpHeaders({ "Content-Type": "application/json" }) };
  return this.http.get(URL);
}

addNewAccount(data:Account):Observable<any>{
  let options = { "headers": 
              new HttpHeaders({ "Content-Type": "application/json" }) };
              return this.http.post(URL+"new/",data,options);
              
}
 deleteAccount(mobile:number):Observable<any>{
   return this.http.delete(URL+"delete/"+mobile);
 }

 depositMoney(data:Account):Observable<any>{
  let options = { "headers": 
  new HttpHeaders({ "Content-Type": "application/json" }) };
   return this.http.put(URL+"deposit",data,options);
 }
 withdrawMoney(data:Account):Observable<any>{
  let options = { "headers": 
  new HttpHeaders({ "Content-Type": "application/json" }) };
   return this.http.put(URL+"withdraw",data,options);
 }

transferMoney(data:any):Observable<any>{
  let options = { "headers": 
  new HttpHeaders({ "Content-Type": "application/json" }) };

   return this.http.put(URL+"transfer",data,options);
 }
 
updateAccountDetails(data:Account):Observable<any>{
  let options = { "headers": 
  new HttpHeaders({ "Content-Type": "application/json" }) };

   return this.http.put(URL+"update",data,options);
}




}
