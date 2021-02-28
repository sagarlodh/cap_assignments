//a default params
function add(x, y) {
    if (x === void 0) { x = 5; }
    if (y === void 0) { y = 5; }
    console.log(x + y);
}
add();
//b REST params
function userFriends(username) {
    var arr = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        arr[_i - 1] = arguments[_i];
    }
    console.log(username);
    for (var _a = 0, arr_1 = arr; _a < arr_1.length; _a++) {
        var iterator_1 = arr_1[_a];
        console.log(iterator_1);
    }
}
userFriends("sagar", ["h", "e", "r"]);
//c SPREAD Params
function printCapitalNames() {
    var names = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        names[_i] = arguments[_i];
    }
    for (var _a = 0, names_1 = names; _a < names_1.length; _a++) {
        var i = names_1[_a];
        console.log(i.toUpperCase());
    }
}
var names = ["hover", "egg", "roy"];
printCapitalNames.apply(void 0, names);
// 6 String Literal
function description(lModel, desk_no, name) {
    var text = {
        "model": lModel,
        "no": desk_no,
        "name": name
    };
    console.log("This is the Model : " + text.model + "\n\nThis is the NO : " + text.no + "\n\nThis is the Name : " + text.name);
}
description("EA12", 12, "DELL");
//# sourceMappingURL=5.js.map