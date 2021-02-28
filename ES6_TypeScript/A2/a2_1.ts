class turn{
    private prevNo = Symbol();
    private currNo = Symbol();
    constructor(){
        this.prevNo = 0;
        this.currNo = 1;
    }
    next(){
        let curr = Symbol();
        curr = this.prevNo + this.currNo;
        this.prevNo = this.currNo;
        this.currNo = curr;

        return {
            current : curr,
            next : this.prevNo + this.currNo
        }
    }
}

let t = new turn();
console.log(t.next());
console.log(t.next());
console.log(t.next());
console.log(t.next());
console.log(t.next());
