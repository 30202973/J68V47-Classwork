import java.util.*;
public class L8E3 {

    static String[] addDirection(String[] directions, String newDirection, int index) {
        String[] newDirections = new String[directions.length + 1];

        System.arraycopy(directions, 0, newDirections, 0, index);

        newDirections[index] = newDirection;

        System.arraycopy(directions, index, newDirections, index + 1, directions.length - index);

        return newDirections;
    }

    static String[] removeLastDirection(String[] directions) {

        String[] newDirections = new String[directions.length - 1];

        System.arraycopy(directions, 0, newDirections, 0, newDirections.length);

        return newDirections;
    }

    public static void main(String[] args) {
        String[] directions = {"Start by exiting the building you are currently in and turning left onto the main road.",
                "Walk down the road for two blocks until you reach the traffic lights.",
                "At the traffic lights, turn right onto Oak Street.",
                "Follow Oak Street for one block then turn left onto Elm Street.",
                "Walk to the end of Elm Street. Your doctor's office will be the third building on the right side of the road.",
                "Enter through the front door of the office. Let the receptionist know you have arrived for your appointment.",
                "Take a seat in the waiting room. The doctor will call your name when it's time to be seen. You've arrived!"
        };

        displayDirections(directions);

        directions = addDirection(directions, "After turning onto Elm Street, walk past the grocery store on your right.", 4);
        displayDirections(directions);

        directions = removeLastDirection(directions);
        displayDirections(directions);
    }

    static void displayDirections(String[] directions) {

        int step = 1;
        for(String direction : directions) {
            System.out.format("%d. %s %n", step, direction);
            step++;
        }
        System.out.println();
    }
}
