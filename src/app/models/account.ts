export class Account{
    accountHolder:string;
    accountMobile:number;
    accountBalance:number;
    accountId:number;
    
    constructor(accountHolder:string,accountMobile:number,accountBalance:number){
      
        this.accountHolder=accountHolder;
        this.accountMobile=accountMobile;
        this.accountBalance=accountBalance;
    }


}