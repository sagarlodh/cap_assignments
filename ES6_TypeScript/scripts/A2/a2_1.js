var turn = /** @class */ (function () {
    function turn() {
        this.prevNo = Symbol();
        this.currNo = Symbol();
        this.prevNo = 0;
        this.currNo = 1;
    }
    turn.prototype.next = function () {
        var curr = Symbol();
        curr = this.prevNo + this.currNo;
        this.prevNo = this.currNo;
        this.currNo = curr;
        return {
            current: curr,
            next: this.prevNo + this.currNo
        };
    };
    return turn;
}());
var t = new turn();
console.log(t.next());
console.log(t.next());
console.log(t.next());
console.log(t.next());
console.log(t.next());
//# sourceMappingURL=a2_1.js.map