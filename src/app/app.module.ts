import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
//import {NgbModule} from '@ng-bootstrap/ng-bootstrap'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import {Routes,RouterModule} from '@angular/router';
import { AddAccountComponent } from './add-account/add-account.component';
import { DeleteAccountComponent } from './delete-account/delete-account.component';
import { UpdateAccountComponent } from './update-account/update-account.component';
import { FindAccountComponent } from './find-account/find-account.component';
import { GetAllAccountComponent } from './get-all-account/get-all-account.component';
import { DepositMoneyComponent } from './deposit-money/deposit-money.component';
import { WithdrawMoneyComponent } from './withdraw-money/withdraw-money.component';
import { TransferMoneyComponent } from './transfer-money/transfer-money.component';

const routes:Routes=[
  { path:'',redirectTo:'list',pathMatch:'full'},
  { path:'add',component:AddAccountComponent},
  { path:'list',component:GetAllAccountComponent},
  { path:'update',component:UpdateAccountComponent},
  { path:'delete',component:DeleteAccountComponent},
  { path:'deposit',component:DepositMoneyComponent},
  { path:'withdraw',component:WithdrawMoneyComponent},
  { path:'transfer',component:TransferMoneyComponent},
  { path:'find',component:FindAccountComponent} 
];
@NgModule({
  declarations: [
    AppComponent,
    AddAccountComponent,
    DeleteAccountComponent,
    UpdateAccountComponent,
    FindAccountComponent,
    GetAllAccountComponent,
    DepositMoneyComponent,
    WithdrawMoneyComponent,
    TransferMoneyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
    //NgbModule
        
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
