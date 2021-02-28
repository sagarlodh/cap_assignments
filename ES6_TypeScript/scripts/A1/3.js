// 1 2 3
//3
var Order = {
    id: 1,
    title: "KING",
    price: 20,
    printOrder: function () {
        console.log(this.id);
        console.log(this.title);
        console.log(this.price);
    },
    getPrice: function () {
        console.log(this.price);
    }
};
Order.printOrder();
Order.getPrice();
// uncomment these two lines
//const newOrder = Object.assign({},Order);
//console.log(newOrder);
//# sourceMappingURL=3.js.map