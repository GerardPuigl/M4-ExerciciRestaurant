//Variables necessaries

const NOTE5 = 5;
const NOTE10 = 10;
const NOTE20 = 20;
const NOTE50 = 50;
const NOTE100 = 100;
const NOTE200 = 200;
const NOTE500 = 500;

var totalcost;

var menu = new Array;
var price = new Array;

// varroduir plats i preus dins d'arrays
var platePrices = new Map;

platePrices.set("Braves", 4.50);
platePrices.set("Xipirons", 6.00);
platePrices.set("Pop", 9.50);
platePrices.set("Xistorra", 5.40);
platePrices.set("Musclos", 8.00);

var k = 0;
platePrices.forEach((prices, plate) => {
    menu[k] = plate;
    price[k] = prices;
    k++;
});

// Mostrar arrays per pantalla

for (let i = 0; i < price.length; i++) {
    document.writeln(menu[i] + " - " + price[i] + " €", "</br>");
}

// Sol·licitud de comanda
var order = new Map;

var keep = 1;
while (keep != 0) {
    plate = prompt("Què voleu menjar?")

    if (order.get(plate) == null) {
        order.set(plate, 1);
    } else {
        order.set(plate, order.get(plate) + 1);
    }

    do {

        keep = prompt("Voleu demanar un altre plat? (1:Si / 0:No)")

        if (keep != 0 && keep != 1) {
            alert("Heu d'introduir 0 o 1!");
        }
    } while (keep != 0 && keep != 1);

}

// Llistat comanda i preu final
totalcost = 0;

document.writeln("La teva comanda és:","</br>")

order.forEach((numeroPlatos, plateOrder) => {
    for (let i = 0; i < numeroPlatos; i++) {							//per si demanen 2 vegades un plat


        if (platePrices.has(plateOrder)) {
            totalcost = totalcost + platePrices.get(plateOrder);

            document.writeln(plateOrder + " - " + platePrices.get(plateOrder) + " €", "</br>");
        } else {
            document.writeln("El producte " + plateOrder + " no existeix!", "</br>");
        }
    }
});

document.writeln("Preu total " + totalcost + " €", "</br>");

document.writeln("Gràcies per la vostra comanda!", "</br>");

