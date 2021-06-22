

public class SetTest {
    /*

    @Test
    public void addItem_Integer() {
        Set<Integer> IntegerSet = new Set<Integer>();

        //Trying a range of integer values, including negative values and 0
        int min = -100;
        int max = 100;

        for (Integer i = min; i < max; i++) {
            IntegerSet.addItem(i);
        }

        //Check if all values are added correctly
        for (Integer i = min; i < max; i++) {
            assertTrue(IntegerSet.contains(i));
        }


        //Checking if return value is correct
        boolean returnValueOfAddItemMethod = IntegerSet.addItem(-3);
        System.out.println(returnValueOfAddItemMethod);
        assertFalse("returnValueofAddItemMethod has to be false!", returnValueOfAddItemMethod);

        //Checking if its possible to add null
        IntegerSet.addItem(null);


    }

    @Test
    public void addItem_String() {
        Set<String> StringSet = new Set<String>();

        //Storing test cases
        ArrayList<String> testStrings = new ArrayList<String>();


        //Test cases: numbers
        for (Integer i = 0; i < 3; i++) {
            testStrings.add(i.toString());
        }

        //Test case: empty string
        testStrings.add("");

        //Test case: special characters
        testStrings.add("üäÖ#ß??'_!");

        //Checking all test cases
        for (String testString : testStrings) {
            StringSet.addItem(testString);
        }


        //Checking if test cases are added correctly
        for (int i = 0; i < testStrings.size(); i++) {
            assertTrue(StringSet.contains(testStrings.get(i)));
        }


        //Checking if return value of addItem method is correct
        boolean returnValueOfAddItemMethod = StringSet.addItem("0");
        System.out.println(returnValueOfAddItemMethod);
        assertFalse(returnValueOfAddItemMethod);

        //Checking if its possible to add null
        StringSet.addItem(null);

    }

    @Test
    public void removeItem_Integer() {
        Set<Integer> IntegerSet = new Set<Integer>();

        int min = 0;
        int max = 5;
        int delta = 2;

        //Adding a range of integers
        for (int i = min; i < max; i++) {
            IntegerSet.addItem(i);
        }

        //Removing all integers, also trying to remove integers not previously added
        for (int i = min - delta; i < max + delta; i++) {
            IntegerSet.removeItem(i);
        }


        //Checking if all integers are removed
        for (int i = min; i < max; i++) {
            assertFalse(IntegerSet.contains(i));
        }

    }

    @Test
    public void removeItem_String() {
        Set<String> StringSet = new Set<String>();

        //Storing test cases
        ArrayList<String> testStrings = new ArrayList<String>();

        int min = -20;
        int max = 3;
        //Test cases: integer values including negative ones
        for (Integer i = min; i < max; i++) {
            testStrings.add(i.toString());
        }

        //Test case: empty string
        testStrings.add("");

        //Test case: special characters
        testStrings.add("üäÖ#ß??'_!");

        //Adding all test cases
        for (String testString : testStrings) {
            StringSet.addItem(testString);
        }

        //Checking if removing of all test cases is possible
        for (String testString : testStrings) {
            StringSet.removeItem(testString);
        }

        //Checking if all test cases are removed properly
        for (String testString : testStrings) {
            assertFalse(StringSet.contains(testString));
        }

    }

    @Test
    public void contains_String() {
        Set<String> StringSet = new Set<String>();


        ArrayList<String> testStrings = new ArrayList<String>();

        int min = 0;
        int max = 5;

        for (Integer i = min; i < max; i++) {
            testStrings.add(i.toString());
        }

        testStrings.add("");
        testStrings.add("üäÖ#ß??'_!");

        for (String testString : testStrings) {
            StringSet.addItem(testString);
        }


        //Checking if all added test cases are contained in set
        for (String testString : testStrings) {
            assertTrue(StringSet.contains(testString));
        }
    }

    @Test
    public void contains_Integer() {
        Set<Integer> IntegerSet = new Set<Integer>();

        int min = 0;
        int max = 5;

        for (int i = min; i < max; i++) {
            IntegerSet.addItem(i);
        }


        //Checking if all added test cases are contained in set
        for (int i = min; i < max; i++) {
            assertTrue(IntegerSet.contains(i));
        }
    }

    @Test
    public void size_Integer() {
        Set<Integer> IntegerSet = new Set<Integer>();

        //Checking size after removing an item not included in set
        IntegerSet.removeItem(-100);
        assertEquals(0, IntegerSet.size());

        System.out.println("Size of empty IntegerSet is: " + IntegerSet.size());

        //Checking size of empty set
        assertEquals(0, IntegerSet.size());

        int amount = 5;

        for (int i = 0; i < 5; i++) {
            IntegerSet.addItem(i);
        }

        //Adding values and checking if size is correct
        assertEquals(amount, IntegerSet.size());


        //Checking size after item has been removed
        IntegerSet.removeItem(1);
        assertEquals(amount - 1, IntegerSet.size());

    }

    @Test
    public void size_String() {
        Set<String> StringSet = new Set<String>();

        //Adding items to set
        StringSet.addItem("test1");
        StringSet.addItem("test2");
        StringSet.addItem("test3");

        //Checking if size is correct
        System.out.println(StringSet.toString());
        assertEquals(StringSet.size(), 3);

        //Checking if size is correct after removing item
        StringSet.removeItem("test1");
        assertEquals(2, StringSet.size());

    }

     */
}
