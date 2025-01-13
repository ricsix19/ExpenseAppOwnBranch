package ExpenseBackBone.Assets;

public class Basics {
    private int startingMoney; //itt megadom a kezdo toket es majd getter setterekkel kezelem a Mainben
    private int remainingMoney; //egyenlore meg nem fogok vele semmit kezdeni csak definialom hogy tudjam hogy kell majd

    public Basics(int startingMoney) {
        this.startingMoney = startingMoney;
    }

    public int getStartingMoney() {
        return startingMoney;
    }

    public void setStartingMoney(int startingMoney) {
        this.startingMoney = startingMoney;
    }

    //display money
    public void displayMoney(){
        System.out.println("Összeged: " + getStartingMoney() + "FT");
    }

    //hozzaadas a meglevohoz
    public void addMoneyToExisting(int addMoney) {
        setStartingMoney(getStartingMoney() + addMoney); //illetve a startingMoney variable name nem biztos hogy helyt allo, de ezt majd atbeszeljuk, meg atirhatod ha gondolod
        System.out.println("Hozzáadtunk " + addMoney + "FT összeget az eredeti összeghez.");
        //Jelenlegi osszeg nem feltetlen szukseges, ha gondolod kiveheted.
        System.out.println("Jelenlegi összeged: " + getStartingMoney() + "FT");
    }
}
