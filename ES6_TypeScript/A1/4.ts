var arr = ["sagar","rahu","toy"];
// to object func
/*function toObject(arr) {
    var rv = {};
    for (var i = 0; i < arr.length; i++)
      rv[i] = {
          "name":arr[i],
          "length":arr[i].length
      };
    return rv;
}*/

// to object
const res = arr.reduce(function(newArr, a){
    newArr.push({string: a,string_length: a.length});
    return newArr;
  },[])
console.log(res);

//if needed uncomment
//console.log(JSON.stringify(res));



