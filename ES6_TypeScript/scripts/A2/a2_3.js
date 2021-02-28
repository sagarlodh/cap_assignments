var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
// we can push arms nos into a list and then use this
// here i have taken predfined list with numbers
var listArm = [3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474];
var iterator = listArm[Symbol.iterator]();
function getnext() {
    return iterator.next().value;
}
// generator
function arms() {
    var current, next, reset;
    var _a;
    return __generator(this, function (_b) {
        switch (_b.label) {
            case 0:
                current = 1;
                next = 2;
                _b.label = 1;
            case 1:
                if (!true) return [3 /*break*/, 3];
                return [4 /*yield*/, current];
            case 2:
                reset = _b.sent();
                _a = [next, getnext(next)], current = _a[0], next = _a[1];
                if (reset) {
                    current = 1;
                    next = 2;
                    // arms();
                }
                return [3 /*break*/, 1];
            case 3: return [2 /*return*/];
        }
    });
}
var s = arms();
console.log(s.next().value); // 1
console.log(s.next().value); // 2
console.log(s.next().value); // ...
console.log(s.next().value);
console.log(s.next().value);
console.log(s.next().value);
console.log(s.next().value);
console.log(s.next().value);
console.log(s.next().value); // 9 
// should return next ARMSTRONGs
console.log(s.next().value);
console.log(s.next().value);
console.log(s.next().value);
console.log(s.next().value);
console.log(s.next().value);
console.log(s.next().value);
console.log(s.next().value);
// reset generator
console.log(s.next(true).value);
console.log(s.next().value); // 1
console.log(s.next().value); // 2
//# sourceMappingURL=a2_3.js.map