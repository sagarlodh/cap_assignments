// we can push arms nos into a list and then use this
// here i have taken predfined list with numbers
var listArm = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371];
var iterator = listArm[Symbol.iterator]();
function getNextArmstrong() {
    return {
        "next value": iterator.next().value
    };
}
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
//# sourceMappingURL=a2_2.js.map