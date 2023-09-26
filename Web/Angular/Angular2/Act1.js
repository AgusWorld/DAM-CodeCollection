var Data = /** @class */ (function () {
    function Data(dia, mes, any) {
        if (dia === void 0) { dia = 1; }
        if (mes === void 0) { mes = 1; }
        if (any === void 0) { any = 1970; }
        this._dia = dia;
        this._mes = mes;
        this._any = any;
    }
    Object.defineProperty(Data.prototype, "any", {
        get: function () {
            return this._any;
        },
        set: function (value) {
            this._any = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Data.prototype, "mes", {
        get: function () {
            return this._mes;
        },
        set: function (value) {
            this._mes = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Data.prototype, "dia", {
        get: function () {
            return this._dia;
        },
        set: function (value) {
            this._dia = value;
        },
        enumerable: false,
        configurable: true
    });
    Data.prototype.toString = function () {
        var frase = ("DIA/MES/ANY -> " + this._dia + "/" + this._mes + "/" + this._any);
        return frase;
    };
    return Data;
}());
var daresult = document.getElementById("texto");
var lafecha = new Data(1, 1, 1970);
var button1 = document.getElementById("actualizar");
button1.addEventListener("click", actualizar);
function actualizar() {
    lafecha.dia = +(document.getElementById("dia").value);
    lafecha.mes = +(document.getElementById("mes").value);
    lafecha.any = +(document.getElementById("any").value);
}
var button2 = document.getElementById("mostrar");
button2.addEventListener("click", mostrar);
function mostrar() {
    daresult.innerText = lafecha.toString();
}
//# sourceMappingURL=Act1.js.map