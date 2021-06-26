package exercises;

import java.util.Arrays;

public class Food implements Comparable<Food> {

    //Member variables
    public static final String[] TYPES = {"Apple", "Pear", "Cookie", "Grape"};
    String type;
    int calories;

    //Creating food instances
    public Food(String type, int calories) {
        if (isValidType(type)) {
            for (String s : TYPES) {
                if (s.equals(type)) {
                    this.type = type;
                    this.calories = calories;
                    break;
                }
            }
        }
    }

    //Compare a Food object to another by the product of type length and amount of calories
    public int compareTo(Food other) {
        int valFood = this.type.length() * this.calories;
        int valFoodOther = other.type.length() * other.calories;

        return Integer.compare(valFood, valFoodOther);

    /*
    if (valFood < valFoodOther) return -1;
    else if (valFood > valFoodOther) return 1;
    else return 0;

     */
    }

    //Interpret the value of method compareTo
    public String evaluateComparison(Food other) {
        switch (compareTo(other)) {
            case -1:
                return this.getType() + " is less than " + other.type;
            case 1:
                return this.getType() + " is greater than " + other.type;
            default:
                return "Both are equal";
        }

        // Not allowed by test
        /*
        return switch (compareTo(other)) {
            case -1 -> this.getType() + " is less than " + other.type;
            case 1 -> this.getType() + " is greater than " + other.type;
            default -> "Both are equal";
        };

         */
    }

    //Creates a String out of food type and amount of calories
    public String toString() {
        return "type: " + this.type + "," + "calories: " + this.calories;
    }

    //Returns type of Food object
    public String getType() {
        return this.type;

    }

    //Returns calories of Food object
    public int getCalories() {
        return this.calories;
    }

    //Create an array filled with n Food objects
    public static Food[] createSortedRandomList(int n) {
        Food[] foods = new Food[n];
        for (int i = 0; i < n; i++) {
            String rndmFoodType = TYPES[(int) (Math.random() * TYPES.length)];
            int rndmAmountCalories = (int) (Math.random() * 500);
            foods[i] = new Food(rndmFoodType, rndmAmountCalories);
        }

        java.util.Arrays.sort(foods);
        return foods;
    }

    //Return the amount of calories a food of given type has
    public static int caloriesOfFood(String type) {

        switch (type) {
            case "Apple":
                return 52;
            case "Pear":
                return 57;
            case "Cookie":
                return 502;
            case "Grape":
                return 67;
            default:
                return -1;
        }

        //Not allowed by test
        /*
        return switch (type) {
            case "Apple" -> 52;
            case "Pear" -> 57;
            case "Cookie" -> 502;
            case "Grape" -> 67;
            default -> -1;
        };

         */
    }

    //Return if a type is valid
    public static Boolean isValidType(String type) {
        boolean validTypeFound = false;
        for (int i = 0; i < TYPES.length && !validTypeFound; i++) {
            if (TYPES[i].equals(type)) {
                validTypeFound = true;
                break;
            }
        }
        if (!validTypeFound) {
            System.out.println("INVALID TYPE ENTERED: " + type);
        }

        return validTypeFound;
    }

    //Testing methods
    public static void main(String[] args) {
        // Testing each food
        String[] foodTypes = {"Apple", "Pear", "Cookie", "Grape", "ThisFoodDoesntExist"};

        for (int i = 0; i < foodTypes.length; i++) {
            System.out.println("--- Test for Food " + i + " ---");
            Food tempFood = new Food(foodTypes[i], caloriesOfFood(foodTypes[i]));
            System.out.println(tempFood.toString());
            System.out.println(tempFood.getType());
            System.out.println(tempFood.getCalories());
        }

        //Testing createSortedRandomList
        int amountTests = 10;
        for (int i = 0; i < amountTests; i++) {
            System.out.println("--- This should be an Array with " + i + " foods.");
            System.out.println(Arrays.toString(createSortedRandomList(i)));
        }

        // Comparing foods to each other
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < amountTests; i++) {
            int rndm1 = (int) (Math.random() * TYPES.length);
            int rndm2 = (int) (Math.random() * TYPES.length);
            Food temp1 = new Food(TYPES[rndm1], caloriesOfFood(TYPES[rndm1]));
            Food temp2 = new Food(TYPES[rndm2], caloriesOfFood(TYPES[rndm2]));


            System.out.println("--- Comparison " + i + ": " + TYPES[rndm1] + " // " + TYPES[rndm2] + " ---");
            System.out.println(temp1.compareTo(temp2) + " -> " + temp1.evaluateComparison(temp2));
        }


    }

}
