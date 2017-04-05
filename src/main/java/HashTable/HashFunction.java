import java.util.Arrays;

/**
 * HashFunction
 */
public class HashFunction {
    String[] theArray;
    int arraySize;
    int itemsInArray;
    public HashFunction (int size) {
        this.arraySize = size;
        this.theArray = new String[size];
        Arrays.fill(theArray, "-1");
    }

    public static void main(String[] args) {
        HashFunction hashFunction = new HashFunction(30);
        //String[] elementsToAdd = {"1", "5", "17", "21", "26"};
        String[] elementsToAdd2 = {"1", "5", "17", "21", "26", "28", "30", "32", "34", "36", "38", "40", "42", "44",
        "46", "48", "50", "52", "54", "56", "58", "60", "62", "64", "66", "68", "70", "72", "74", "76"};

        hashFunction.hashFunction2(elementsToAdd2, hashFunction.theArray);

        hashFunction.findKey("60");

        hashFunction.displayTheStack();
    }

    public void hashFunction1(String[] stringsForArray, String[] theArray) {
        for(int i = 0; i < stringsForArray.length; i++) {
            String newElementVal = stringsForArray[i];
            theArray[Integer.parseInt(newElementVal)] = newElementVal;
        }
    }

    public void hashFunction2(String[] stringsForArray, String[] theArray) {
        for(int i = 0; i < stringsForArray.length; i++) {
            String newElementVal = stringsForArray[i];
            int arrayIndex = Integer.parseInt(newElementVal) % 29;
            System.out.println("Modulus index: " + arrayIndex + " for value: " + newElementVal);

            while(theArray[arrayIndex] != "-1") {
                ++arrayIndex;
                System.out.println("Collision try: " + arrayIndex + " instead");
                arrayIndex %= arraySize;
            }
            
            theArray[arrayIndex] = newElementVal;
        }
    }

    public String findKey(String key) {
        int arrayIndexHash = Integer.parseInt(key) % 29;
        while(theArray[arrayIndexHash] != "-1") {
            if(theArray[arrayIndexHash] == key) {
                System.out.println(key + " was found in index: " + arrayIndexHash);

                return theArray[arrayIndexHash];
            }
        
        ++arrayIndexHash;
        arrayIndexHash %= arraySize;
        
        }

        return null;
    }


    public void displayTheStack() {
        int increment = 0;
        for (int m = 0; m < 3; m++) {

            increment += 10;
            for (int n = 0; n < 71; n++)
                System.out.print("-");


            System.out.println();

            for (int n = increment - 10; n < increment; n++) {
                System.out.format("| %3s " + " ", n);

            }

            System.out.println("|");

 
            for (int n = 0; n < 71; n++)
                System.out.print("-");


            System.out.println();

            for (int n = increment - 10; n < increment; n++) {
                if (theArray[n].equals("-1"))
                    System.out.print("|      ");
                else
                    System.out.print(String.format("| %3s " + " ", theArray[n]));
            }

            System.out.println("|");

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();
        }
    }

}