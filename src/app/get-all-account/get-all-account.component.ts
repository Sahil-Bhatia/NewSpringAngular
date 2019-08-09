
import { Component, OnInit, forwardRef, Inject } from '@angular/core';
import { AccountService } from '../account.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-get-all-account',
  templateUrl: './get-all-account.component.html',
  styleUrls: ['./get-all-account.component.css'],

})
export class GetAllAccountComponent{

  accountsList: any[] = [];
  constructor(private service: AccountService,private router:Router) {
   // this.router.routeReuseStrategy.shouldReuseRoute = function() {
      //return false;
      
    this.service.getAllAccounts().
    subscribe((result) => {
      alert("Status Code: "+result.statusCode+"\n"+result.message);
      this.accountsList = result.accountList;
      console.log("Fetched records for Accounts");
    });

  }
   }



