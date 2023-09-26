var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var animal = /** @class */ (function () {
    function animal(especie, nom, posX, posY, url) {
        if (especie === void 0) { especie = "NoEspecie"; }
        if (nom === void 0) { nom = "NoNom"; }
        if (posX === void 0) { posX = 100; }
        if (posY === void 0) { posY = 100; }
        if (url === void 0) { url = "http://cdn.onlinewebfonts.com/svg/img_546302.png"; }
        this._especie = especie;
        this._nom = nom;
        this._posX = posX;
        this._posY = posY;
        this._url = url;
    }
    Object.defineProperty(animal.prototype, "nom", {
        get: function () {
            return this._nom;
        },
        set: function (value) {
            this._nom = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(animal.prototype, "especie", {
        get: function () {
            return this._especie;
        },
        set: function (value) {
            this._especie = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(animal.prototype, "url", {
        get: function () {
            return this._url;
        },
        set: function (value) {
            this._url = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(animal.prototype, "posY", {
        get: function () {
            return this._posY;
        },
        set: function (value) {
            this._posY = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(animal.prototype, "posX", {
        get: function () {
            return this._posX;
        },
        set: function (value) {
            this._posX = value;
        },
        enumerable: false,
        configurable: true
    });
    return animal;
}());
var Balena = /** @class */ (function (_super) {
    __extends(Balena, _super);
    function Balena(especie, nom, posX, posY, url, aletas, mar) {
        if (especie === void 0) { especie = "NoEspecie"; }
        if (nom === void 0) { nom = "NoNom"; }
        if (posX === void 0) { posX = 100; }
        if (posY === void 0) { posY = 100; }
        if (url === void 0) { url = "http://cdn.onlinewebfonts.com/svg/img_546302.png"; }
        if (aletas === void 0) { aletas = 2; }
        if (mar === void 0) { mar = "ATLANTIC"; }
        var _this = _super.call(this, especie, nom, posX, posY, url) || this;
        _this._aletas = aletas;
        _this._mar = mar;
        return _this;
    }
    Object.defineProperty(Balena.prototype, "aletas", {
        get: function () {
            return this._aletas;
        },
        set: function (value) {
            this._aletas = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Balena.prototype, "mar", {
        get: function () {
            return this._mar;
        },
        set: function (value) {
            this._mar = value;
        },
        enumerable: false,
        configurable: true
    });
    Balena.prototype.toStringFun = function () {
        var vari = "Especie: " + this.especie
            + "\nNom: " + this.nom
            + "\nX: " + this.posX
            + "\nY: " + this.posY
            + "\nAletas: " + this.aletas
            + "\nMar: " + this.mar;
        return vari;
    };
    return Balena;
}(animal));
var Puma = /** @class */ (function (_super) {
    __extends(Puma, _super);
    function Puma(especie, nom, posX, posY, url, potes, pais) {
        if (especie === void 0) { especie = "NoEspecie"; }
        if (nom === void 0) { nom = "NoNom"; }
        if (posX === void 0) { posX = 100; }
        if (posY === void 0) { posY = 100; }
        if (url === void 0) { url = "http://cdn.onlinewebfonts.com/svg/img_546302.png"; }
        if (potes === void 0) { potes = 4; }
        if (pais === void 0) { pais = "India"; }
        var _this = _super.call(this, especie, nom, posX, posY, url) || this;
        _this._potes = potes;
        _this._pais = pais;
        return _this;
    }
    Puma.prototype.toStringFun = function () {
        var vari = "Especie: " + this.especie
            + "\nNom: " + this.nom
            + "\nX: " + this.posX
            + "\nY: " + this.posY
            + "\nPotes: " + this.potes
            + "\nPais: " + this.pais;
        return vari;
    };
    Object.defineProperty(Puma.prototype, "pais", {
        get: function () {
            return this._pais;
        },
        set: function (value) {
            this._pais = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Puma.prototype, "potes", {
        get: function () {
            return this._potes;
        },
        set: function (value) {
            this._potes = value;
        },
        enumerable: false,
        configurable: true
    });
    return Puma;
}(animal));
var balena;
var puma;
var espai1 = document.getElementById("animal1");
var espai2 = document.getElementById("animal2");
var boton = document.getElementById("selEnviar");
boton.addEventListener("click", funcion);
function funcion() {
    var selEspecie = (document.getElementById("selEspecie").value);
    var selX = +(document.getElementById("selX").value);
    var selY = +(document.getElementById("selY").value);
    var selURL = (document.getElementById("selURL").value);
    var selNom = (document.getElementById("selNom").value);
    if (selY < 600 && selX < 233) {
        selY = 600;
        selX = 233;
    }
    var css = "background-image:url(" + selURL + ");top:" + selY + "px;left:" + selX + "px; position:absolute; background-size: cover; width:150px;height:150px; margin:1px;";
    if (selEspecie == "Balena") {
        var selAletas = +(document.getElementById("selAletas").value);
        balena = new Balena(selEspecie, selNom, selX, selY, selURL, selAletas);
        espai1.style.cssText = css;
    }
    else {
        var selPotes = +(document.getElementById("selPotes").value);
        puma = new Puma(selEspecie, selNom, selX, selY, selURL, selPotes);
        espai2.style.cssText = css;
    }
}
var buttonToString = document.getElementById("selToString");
buttonToString.addEventListener("click", imprimir);
function imprimir() {
    var selEspecie = (document.getElementById("selEspecie").value);
    if (selEspecie == "Balena") {
        document.getElementById("selESPAI").innerText = balena.toStringFun();
    }
    else {
        document.getElementById("selESPAI").innerText = puma.toStringFun();
    }
}
var opcioSeleccionada = document.getElementById("selEspecie");
opcioSeleccionada.addEventListener("click", dependeAnimal);
function dependeAnimal() {
    var selEspecie = (document.getElementById("selEspecie").value);
    if (selEspecie == "Balena") {
        document.getElementById("selPotes").style.cssText = "display: none;";
        document.getElementById("selAletas").style.cssText = "display: ;";
        document.getElementById("selPais").style.cssText = "display: none;";
        document.getElementById("selMar").style.cssText = "display: ;";
    }
    else {
        document.getElementById("selAletas").style.cssText = "display: none;";
        document.getElementById("selPotes").style.cssText = "display: ;";
        document.getElementById("selMar").style.cssText = "display: none;";
        document.getElementById("selPais").style.cssText = "display: ;";
    }
}
//# sourceMappingURL=Act2.js.map