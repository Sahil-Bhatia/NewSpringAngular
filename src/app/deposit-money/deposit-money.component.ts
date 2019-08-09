import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';
import { Router } from '@angular/router';
import { Account } from '../models/account';

@Component({
  selector: 'app-deposit-money',
  templateUrl: './deposit-money.component.html',
  styleUrls: ['./deposit-money.component.css']
})
export class DepositMoneyComponent implements OnInit {

  constructor(private service: AccountService, private router: Router) {
    this.router.routeReuseStrategy.shouldReuseRoute = function () {
      return false;
    };
  }

  ngOnInit() {
  }

  accountMobile: number;
  depositAmount: number;
  accountObject:Account;
  depositMoney(): any {
    var ob: any = new Account(null, this.accountMobile, this.depositAmount);
    this.service.depositMoney(ob).subscribe(data => {
      alert(data.message+"\n"+"Status Code: "+data.statusCode+" \n");
      this.accountObject=data.accountObject;

    })
    
      this.accountMobile=null;
      this.depositAmount=null;
    //this.router.navigate(['list']);

  }

}
