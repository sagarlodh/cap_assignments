var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
// main account
var Accounts = /** @class */ (function () {
    function Accounts(balance) {
        this.total_Balance = balance;
    }
    Object.defineProperty(Accounts.prototype, "Balance", {
        get: function () {
            return this.total_Balance;
        },
        enumerable: false,
        configurable: true
    });
    Accounts.prototype.deposit = function (amount) {
        this.total_Balance += amount;
        console.log("Deposited : $" + amount);
        console.log("Total Balance : $" + this.Balance);
    };
    Accounts.prototype.withdraw = function (amount) {
        if (amount < this.Balance) {
            this.total_Balance -= amount;
            console.log("Withdraw Amount : $" + amount);
            console.log("Remaining Balance : $" + this.Balance);
        }
        else {
            return "Less Cash Present";
        }
    };
    return Accounts;
}());
// savings account
var SavingsAccount = /** @class */ (function (_super) {
    __extends(SavingsAccount, _super);
    function SavingsAccount() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.interest = 0.05;
        return _this;
    }
    SavingsAccount.prototype.getAfterInterest = function () {
        console.log("After Interest Added : $" + (this.Balance + (this.Balance * this.interest)));
    };
    return SavingsAccount;
}(Accounts));
// current account
var CurrentAccount = /** @class */ (function (_super) {
    __extends(CurrentAccount, _super);
    function CurrentAccount() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.cashCreditR = 5.00;
        return _this;
    }
    CurrentAccount.prototype.cashCredit = function () {
        console.log("After Cash Credited : $" + (this.Balance - ((this.Balance * 0.02) - this.cashCreditR)));
    };
    return CurrentAccount;
}(Accounts));
// objects 1
var savings = new SavingsAccount(1000);
savings.deposit(500);
savings.withdraw(100);
savings.getAfterInterest();
console.log("=========================================");
var checking = new CurrentAccount(2000);
checking.deposit(600);
checking.withdraw(100);
checking.cashCredit();
// we can add many objects...
//# sourceMappingURL=8.js.map