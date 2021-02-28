/*let p = new Promise((resolve,reject)=>{
    let a = Math.floor(Math.random() * 10)
    if(a){
        resolve(`${a} is generated`)
    }else{
        reject(`error while generating`)
    }
    return a;
})
let q = new Promise((resolve,reject)=>{
    let b = Math.floor(Math.random() * 10);
    if(b){
        resolve(`${b} is generated`)
    }else{
        reject(`error while generating`)
    }
    return b;
})*/
// generating P
var p = Promise.resolve(Math.floor(Math.random() * 10));
// generating Q
var q = Promise.resolve(Math.floor(Math.random() * 10));
// PROMISE.ALL
Promise.all([p, q]).then(function (values) {
    // logging generated values
    console.log("The generated values : " + values);
    // logging the sum
    console.log("Sum : " + (values[0] + values[1]));
}).catch(function (message) {
    console.log("Error while processing...");
});
//# sourceMappingURL=a3_1.js.map