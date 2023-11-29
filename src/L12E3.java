public class L12E3 {
    public static void displayCarSales(carSales thiscarSales) {
        System.out.println(thiscarSales.make + " " + thiscarSales.model + " " + "(" + thiscarSales.year + ")" + "\n" + "Vin: " + thiscarSales.vin + "\n" + "Colour: " + thiscarSales.colour  + "\n" + "Mileage: " + thiscarSales.mileage + "\n" + "Condition: " + thiscarSales.condition + "\n" + "Price: " + thiscarSales.price + "\n" + "-----------------------------");
    }

    public static void main(String[] args) {
        carSales carSales1 = new carSales();
        displayCarSales(carSales1);

        carSales1.make = "Ferrari";
        carSales1.model = "F430";
        carSales1.year = 2009;
        carSales1.vin = "3GYVKNEFXAG625569";
        carSales1.colour = "White";
        carSales1.mileage = 45336;
        carSales1.condition = "Good";
        carSales1.price = 55125;
        displayCarSales(carSales1);

    }
}
