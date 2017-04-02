/**
 * Auto
 */
public class Auto {
    private String merk;
    private String type;
    private String kenteken;

    public Auto (String merk, String type, String kenteken) {
        this.merk = merk;
        this.type = type;
        this.kenteken = kenteken;    
    }


    public int hashCode(String text) {
        int hash = text.charAt(0) - 'A';
        return hash % TABLE_SIZE;
    }


    public static void main(String[] args) {
        Auto auto = new Auto("Mercedes", "CLA 180 AMG", "6-ABC-3");


    }
}