import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';
import { Router } from '@angular/router';
import { Account } from '../models/account';
@Component({
  selector: 'app-withdraw-money',
  templateUrl: './withdraw-money.component.html',
  styleUrls: ['./withdraw-money.component.css']
})
export class WithdrawMoneyComponent implements OnInit {
  accountObject: any;

  
  constructor(private service:AccountService, private router:Router) {
    this.router.routeReuseStrategy.shouldReuseRoute = function() {
      return false;
  };
   }

  ngOnInit() {
  }
  
  accountMobile:number;
  withdrawAmount:number;

  withdrawMoney():any{
  var ob:any=new Account(null,this.accountMobile,this.withdrawAmount);
this.service.withdrawMoney(ob).subscribe(data => {
  alert(data.message+"\n"+"Status Code: "+data.statusCode+" \n");
  this.accountObject=data.accountObject;

  //Show Some Message. Say pop a dialog/modal confirming the data save.
})
   this.router.navigate(['list']);
  
  }


}
