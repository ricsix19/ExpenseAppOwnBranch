package ExpenseBackBone.Assets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Finances {
    private int startingMoney; //itt megadom a kezdo toket es majd getter setterekkel kezelem a Mainben
    private int remainingMoney; //egyenlore meg nem fogok vele semmit kezdeni csak definialom hogy tudjam hogy kell majd
    private List<Expenses> expenses;

    public Finances(int startingMoney) {
        this.startingMoney = startingMoney;
        this.remainingMoney = remainingMoney;
        this.expenses = new ArrayList<>();
    }

    public int getStartingMoney() {
        return startingMoney;
    }

    public void setStartingMoney(int startingMoney) {
        this.startingMoney = startingMoney;
    }

    public int getRemainingMoney() {
        return remainingMoney;
    }

    public void setRemainingMoney(int remainingMoney) {
        this.remainingMoney = remainingMoney;
    }

    public List<Expenses> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expenses> expenses) {
        this.expenses = expenses;
    }

    //display money
    public void displayMoney(){
        System.out.println("Amount: " + getStartingMoney() + "FT");
    }

    //hozzaadas a meglevohoz
    public void addMoneyToExisting(int addMoney) {
        setStartingMoney(getStartingMoney() + addMoney); //illetve a startingMoney variable name nem biztos hogy helyt allo, de ezt majd atbeszeljuk, meg atirhatod ha gondolod
        this.remainingMoney += addMoney;
        System.out.println("Hozzáadtunk " + addMoney + "FT összeget az eredeti összeghez.");
        //Jelenlegi osszeg nem feltetlen szukseges, ha gondolod kiveheted.
        updateRemainingMoney();
        System.out.print("Jelenlegi összeged: ");
    }

    //Uj kiadas hozzaadasa
    public void addExpense(String description, int amount, boolean isExistential) {
        expenses.add(new Expenses(description, amount, isExistential));
        System.out.println("Új kiadás hozzáadva: " + description + ", " + amount + "Ft, Fontos: " + (isExistential ? "Igen" : "Nem"));
        updateRemainingMoney();
    }

    //osszes kiadas kiszamitasa
    public int calculateTotalExpenses(){
        return expenses.stream().mapToInt(Expenses::getAmount).sum();
    }

    //TODO befezezni ezt, egyenlore a 3. caseben van benne
    public void getExpensesByImportance(boolean isImportant) {
        List<Expenses> importantExpenses = expenses.stream().filter(expense -> expense.isImportant() == isImportant).collect(Collectors.toList());
        System.out.println("Important: " + importantExpenses);
        List<Expenses> notImportantExpenses = expenses.stream().filter(expense -> expense.isImportant() != isImportant).collect(Collectors.toList());
        System.out.println("Not important: " + notImportantExpenses);
    }

    //maradek penz frissitese
    private void updateRemainingMoney() {
        this.remainingMoney = this.startingMoney - calculateTotalExpenses();
    }

    //kiadasok utani maradek penz kiirasa
    public void displayRemainingMoney(){
        updateRemainingMoney();
        System.out.println("Kiadasok utani maradek: " + getRemainingMoney() + " FT");
    }

    //Minden kiadas
    public void listAllExpenses(){
        expenses.forEach(System.out::println);
    }
}
