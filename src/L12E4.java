import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class L12E4 {
    public static ArrayList<carSales> loadFile(String filename) {
        List<String> carSaleDetails;
        ArrayList<carSales> thisCar = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String line = in.readLine();
            while (line != null) {
                carSaleDetails = Arrays.asList(line.split(","));
                carSales newcarSales = new carSales();
                newcarSales.make = carSaleDetails.get(0);
                newcarSales.model = carSaleDetails.get(1);
                newcarSales.year = Integer.parseInt(carSaleDetails.get(2));
                newcarSales.vin = carSaleDetails.get(3);
                newcarSales.colour = carSaleDetails.get(4);
                newcarSales.mileage = Integer.parseInt(carSaleDetails.get(5));
                newcarSales.condition = carSaleDetails.get(6);
                newcarSales.price = Integer.parseInt(carSaleDetails.get(7));

                thisCar.add(newcarSales);
                line = in.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error occurred reading file: " + e.toString());
        }
        return thisCar;
    }




    public static void displayCarSales(carSales thiscarSales) {
        System.out.println(thiscarSales.make + " " + thiscarSales.model + " " + "(" + thiscarSales.year + ")" + "\n" + "Vin: " + thiscarSales.vin + "\n" + "Colour: " + thiscarSales.colour  + "\n" + "Mileage: " + thiscarSales.mileage + "\n" + "Condition: " + thiscarSales.condition + "\n" + "Price: " + thiscarSales.price + "\n" + "-----------------------------");
    }

    public static void main(String[] args) {

        ArrayList<carSales> thisCar = loadFile("src/carSales.txt");

        for (carSales thiscarSales : thisCar) {
            displayCarSales(thiscarSales);
        }
    }

}
