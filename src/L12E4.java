import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class L12E4 {

    public static ArrayList<carSales> loadFile(String filename) {
        List<String> carDetails;
        ArrayList<carSales> carList = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String line = in.readLine();
            while (line != null) {
                carDetails = Arrays.asList(line.split(","));
                carSales newCar = new carSales();
                newCar.make = carDetails.get(0);
                newCar.model = carDetails.get(1);
                newCar.year = Integer.parseInt(carDetails.get(2));
                newCar.vin = carDetails.get(3);
                newCar.price = Integer.parseInt(carDetails.get(4));
                newCar.colour = carDetails.get(5);
                newCar.mileage = Integer.parseInt(carDetails.get(6));
                newCar.condition = carDetails.get(7);

                carList.add(newCar);
                line = in.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error occurred reading file: " + e.toString());
        }
        return carList;
    }

    public static void displayCar(carSales car) {
        System.out.println(car.make + " " + car.model + " " + "(" +car.year + ")" + "\n" + "Vin: " + car.vin + "\n" + "Colour: " + car.colour + "\n" + "Mileage: " + car.mileage + "\n" + "Condition: " + car.condition + "\n" + "Price: "+ car.price + "\n" + "------------------------------------------");
    }

    public static void main(String[] args) {
        ArrayList<carSales> carList = loadFile("src/carSales.txt");
        for (carSales carSales : carList) {
            displayCar(carSales);
        }
    }

}