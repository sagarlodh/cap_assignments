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
var Accountss = /** @class */ (function () {
    function Accountss(balance) {
        this.total_Balance = balance;
    }
    Object.defineProperty(Accountss.prototype, "Balance", {
        get: function () {
            return this.total_Balance;
        },
        enumerable: false,
        configurable: true
    });
    Accountss.prototype.deposit = function (amount) {
        this.total_Balance += amount;
        console.log("Deposited : $" + amount);
        console.log("Total Balance : $" + this.Balance);
    };
    Accountss.prototype.withdraw = function (amount) {
        if (amount < this.Balance) {
            this.total_Balance -= amount;
            console.log("Withdraw Amount : $" + amount);
            console.log("Remaining Balance : $" + this.Balance);
        }
        else {
            return "Less Cash Present";
        }
    };
    return Accountss;
}());
// savings account
var Savings_Account = /** @class */ (function (_super) {
    __extends(Savings_Account, _super);
    function Savings_Account() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.interest = 0.05;
        return _this;
    }
    Savings_Account.prototype.getAfterInterest = function () {
        console.log("After Interest Added : $" + (this.Balance + (this.Balance * this.interest)));
    };
    return Savings_Account;
}(Accountss));
// current account
var Current_Account = /** @class */ (function (_super) {
    __extends(Current_Account, _super);
    function Current_Account() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.cashCreditR = 5.00;
        return _this;
    }
    Current_Account.prototype.cashCredit = function () {
        console.log("After Cash Credited : $" + (this.Balance - ((this.Balance * 0.02) - this.cashCreditR)));
    };
    return Current_Account;
}(Accountss));
// objects 1
var savingss = new SavingsAccount(1000);
savings.deposit(500);
savings.withdraw(100);
savings.getAfterInterest();
console.log("=========================================");
var checkingg = new CurrentAccount(2000);
checking.deposit(600);
checking.withdraw(100);
checking.cashCredit();
// we can add many objects...
//# sourceMappingURL=a3_2.js.map