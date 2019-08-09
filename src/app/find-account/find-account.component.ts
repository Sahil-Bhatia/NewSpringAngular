import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-find-account',
  templateUrl: './find-account.component.html',
  styleUrls: ['./find-account.component.css']
})
export class FindAccountComponent implements OnInit {

  findAccountsList: any[] = [];
  accountObject: any;
  constructor(private service: AccountService, private router: Router) {
    this.router.routeReuseStrategy.shouldReuseRoute = function () {
      return false;
    };
  }

  ngOnInit() {
  }

  accountMobile: number;

  findAccount(): any {
    //this.findAccountsList.push({accountId:101,accountMobile:1234567894,accountHolder:"Rahul",accountBalance:1250})

    this.service.findByMobile(this.accountMobile).
      subscribe((data) => {
        alert(data.message + "\n" + "Status Code: " + data.statusCode + " \n");
        this.accountObject = data.accountObject;
        this.findAccountsList.push(data.accountObject);
        console.log("Fetched records for Accounts" + this.findAccountsList);
        //this.findAccountsList=err.error;
      }
      );


  }
}
