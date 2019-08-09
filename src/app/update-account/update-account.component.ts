import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';
import { Router } from '@angular/router';
import { Account } from '../models/account';

@Component({
  selector: 'app-update-account',
  templateUrl: './update-account.component.html',
  styleUrls: ['./update-account.component.css']
})
export class UpdateAccountComponent implements OnInit {
  accountObject: any;

  constructor(private service: AccountService, private router: Router) {
    this.router.routeReuseStrategy.shouldReuseRoute = function () {
      return false;
    };
  }

  ngOnInit() {
  }

  accountMobile: number;
  accountHolder: string;

  updateAccount(): any {
    var ob: any = new Account(this.accountHolder, this.accountMobile, null);
    this.service.updateAccountDetails(ob).subscribe(data => {
      alert(data.message + "\n" + "Status Code: " + data.statusCode + " \n");
      this.accountObject = data.accountObject;

      //Show Some Message. Say pop a dialog/modal confirming the data save.
    })
   // this.router.navigate(['list']);
    this.accountMobile=null;
    this.accountHolder=null;
  }

}
