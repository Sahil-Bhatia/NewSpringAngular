import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-delete-account',
  templateUrl: './delete-account.component.html',
  styleUrls: ['./delete-account.component.css']
})
export class DeleteAccountComponent implements OnInit {

  constructor(private service:AccountService, private router:Router) {
    this.router.routeReuseStrategy.shouldReuseRoute = function() {
      return false;
  };
   }
  ngOnInit() {
  }
  accountMobile:number;
  accountObject:Account;
  deleteAccount():any{
  this.service.deleteAccount(this.accountMobile).subscribe(result => {
    alert("Status Code: "+result.statusCode+"\n"+result.message);
    
    this.accountObject=result.accountObject;
    this.accountMobile=null;
    
  })
     //this.router.navigate(['list']);
    
    }
  
}
