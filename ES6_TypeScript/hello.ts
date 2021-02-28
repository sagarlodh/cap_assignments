let ln  = "lastname"
const person = {
    "firstName" : "Sagar",
    ln : "Lodh"
};

let {firstName} = person;
console.log(firstName);

console.log(person);
//console.log(person.firstName);
//console.log(person.ln);

let emp = ["1","2","3"];
let [one,two,three] = emp;
console.log(one+" "+two+" "+three);
let [...cop] = emp;
console.log(cop);




/* use 
            
            >>>> node scripts/hello.js

to run JS scripts..

*/