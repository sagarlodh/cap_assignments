//a default params
function add(x=5,y=5){
    console.log(x+y);
}
add();

//b REST params
function userFriends(username, ...arr){
    console.log(username);
    for (const iterator of arr) {
        console.log(iterator);
        
    }
}
userFriends("sagar",["h","e","r"]);


//c SPREAD Params
function printCapitalNames(...names){

    for (const i of names) {
        console.log(i.toUpperCase());
    }
}
let names = ["hover","egg","roy"];
printCapitalNames(...names);


// 6 String Literal
function description(lModel,desk_no,name) {
    
    let text = {
            "model":lModel,
            "no":desk_no,
            "name":name
    }
    console.log(`This is the Model : ${text.model}\n
This is the NO : ${text.no}\n
This is the Name : ${text.name}`);
}
description("EA12",12,"DELL");


