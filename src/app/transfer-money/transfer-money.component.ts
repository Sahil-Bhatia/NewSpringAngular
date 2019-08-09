import { Component, OnInit } from '@angular/core';

import { AccountService } from '../account.service';
import { Router } from '@angular/router';
import { Account } from '../models/account';
@Component({
  selector: 'app-transfer-money',
  templateUrl: './transfer-money.component.html',
  styleUrls: ['./transfer-money.component.css']
})
export class TransferMoneyComponent implements OnInit {
  accountObject: any;

  constructor(private service:AccountService, private router:Router) {
    this.router.routeReuseStrategy.shouldReuseRoute = function() {
      return false;
  };
   }

  ngOnInit() {
  }
  
  fromAccountMobile:number;
  
  toAccountMobile:number;
  transferAmount:number;

  transferMoney():any{

    var ob_from:any=new Account(null,this.fromAccountMobile,this.transferAmount);
    
    var ob_to:any=new Account(null,this.toAccountMobile,null);
    var data:Account[]=[];
    data.push(ob_from);
    data.push(ob_to);
    this.service.transferMoney(data).subscribe(data => {
      alert(data.message+"\n"+"Status Code: "+data.statusCode+" \n");
      this.accountObject=data.accountObject;

  //Show Some Message. Say pop a dialog/modal confirming the data save.
})
   this.router.navigate(['list']);
  
  }

}
