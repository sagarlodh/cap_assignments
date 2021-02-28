// IMPLEMENTATIONS
var Employee = /** @class */ (function () {
    function Employee(NAME, TYPE, DEPT) {
        this.name = NAME;
        this.type = TYPE;
        this.dept = DEPT;
    }
    Employee.prototype.getDetails = function () {
        return {
            Employee_Name: this.name,
            Employee_Type: this.type,
            Employee_Department: this.dept
        };
    };
    return Employee;
}());
;
var Circle = /** @class */ (function () {
    function Circle(NAME, TYPE, AREA) {
        this.name = NAME;
        this.type = TYPE;
        this.area = AREA;
    }
    Circle.prototype.getDetails = function () {
        return {
            Circle_Name: this.name,
            Circle_Type: this.type,
            Circle_Area: this.area
        };
    };
    return Circle;
}());
// for employee
var e = new Employee("Kartik", "Manager", "Marketing");
console.log(e.getDetails());
// for circle
var c = new Circle("Big Circle", "Big-O", 1212212);
console.log(c.getDetails());
//# sourceMappingURL=a3_3.js.map