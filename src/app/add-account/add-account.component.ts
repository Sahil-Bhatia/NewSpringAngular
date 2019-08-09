import { Component, OnInit, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { Account } from '../models/account';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-add-account',
  templateUrl: './add-account.component.html',
  styleUrls: ['./add-account.component.css']
})
export class AddAccountComponent implements OnInit {

  constructor(private service: AccountService, private router: Router) {
    this.router.routeReuseStrategy.shouldReuseRoute = function () {
      return false;
    };
  }

  ngOnInit() {
  }

  accountMobile: number;
  accountHolder: string;
  accountBalance: number;
  //accountObject:Account=null;

  messageResponse:string;

  addAccount(): any {
    var ob: any = new Account(this.accountHolder, this.accountMobile, this.accountBalance);
    this.service.addNewAccount(ob).subscribe(data => {
      console.log(data);
      this.messageResponse=data.message+"\n"+"Status Code: "+data.statusCode+"\n";
      alert(this.messageResponse);
      //this.accountObject=data.accountObject;
    })
    this.router.navigate(['list']);

  }

}
