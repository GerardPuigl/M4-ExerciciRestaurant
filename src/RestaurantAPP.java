import java.util.*;

public class RestaurantAPP {

	public static void main(String[] args) {

		// Variables necessaries
		final int NOTE5 = 5;
		final int NOTE10 = 10;
		final int NOTE20 = 20;
		final int NOTE50 = 50;
		final int NOTE100 = 100;
		final int NOTE200 = 200;
		final int NOTE500 = 500;

		double totalcost;

		String[] menu = new String[5];
		double[] price = new double[5];

		// Introduir plats i preus dins d'arrays
		HashMap<String, Double> platePrices = new HashMap<String, Double>();

		platePrices.put("Braves", 4.50);
		platePrices.put("Xipirons", 6.00);
		platePrices.put("Pop", 9.50);
		platePrices.put("Xistorra", 5.40);
		platePrices.put("Musclos", 8.00);

		int k = 0;
		for (String plate : platePrices.keySet()) {
			menu[k] = plate;
			price[k] = platePrices.get(plate);
			k++;
		}

		// Mostrar arrays per pantalla
		for (int i = 0; i < price.length; i++) {
			System.out.println(menu[i] + " - " + price[i] + " €");
		}

		// Sol·licitud de comanda
		HashMap<String, Integer> order = new HashMap<String, Integer>();

		int keep = 1;
		while (keep != 0) {
			System.out.println("Què voleu menjar?");

			Scanner sc = new Scanner(System.in);
			String plate = sc.next();
			
			if (order.get(plate) == null) {
				order.put(plate, 1);
			} else {
				order.put(plate, order.get(plate) + 1);
			}

			do {
				try {
					System.out.println("Voleu demanar un altre plat? (1:Si / 0:No)");
					
					Scanner sc1 = new Scanner(System.in);
					keep = sc1.nextInt();
				
				} catch (InputMismatchException e) {
					System.out.println("Heu d'introduir 0 o 1!");
					keep = 3;
				}
			} while (keep != 0 && keep != 1);

		}

		// Llistat comanda i preu final
		totalcost = 0;

		for (String plateOrder : order.keySet()) {
			for (int i = 0; i < order.get(plateOrder); i++) {							//per si demanen 2 vegades un plat
				try {
					totalcost = totalcost + platePrices.get(plateOrder);

					System.out.println(plateOrder + " - " + platePrices.get(plateOrder));
				} catch (Exception e) {
					System.out.println("El producte " + plateOrder + " no existeix!");
				}
			}

		}

		System.out.println("Preu total " + totalcost);

		System.out.println("Gràcies per la vostra comanda!");
	}

}
