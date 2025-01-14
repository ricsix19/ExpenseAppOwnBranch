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
        this.remainingMoney = startingMoney;
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

    //---------------------------------------------------

    //display money
    public void displayMoney(){
        System.out.println("Amount: " + getStartingMoney() + "FT");
    }

    //Adds money to existing money
    public void addMoneyToExisting(int addMoney) {
        this.startingMoney += addMoney; // updating the remaining money
        updateRemainingMoney();
        System.out.println("We've addded " + addMoney + " FT to the starting money");
    }

    //Addig new Expense
    public void addExpense(String description, int amount, boolean isExistential) {
        expenses.add(new Expenses(description, amount, isExistential));
        System.out.println("Új kiadás hozzáadva: " + description + ", " + amount + "Ft, Fontos: " + (isExistential ? "Igen" : "Nem"));
        updateRemainingMoney();
    }

    //Sum of all total expense
    public int calculateTotalExpenses(){
        return expenses.stream().mapToInt(Expenses::getAmount).sum();
    }

    //Works, lists expenses by importance
    public void getExpensesByImportance(boolean isImportant) {
        List<Expenses> importantExpenses = expenses.stream().filter(expense -> expense.isImportant() == isImportant).collect(Collectors.toList());
        System.out.println("Important: " + importantExpenses);
        List<Expenses> notImportantExpenses = expenses.stream().filter(expense -> expense.isImportant() != isImportant).collect(Collectors.toList());
        System.out.println("Not important: " + notImportantExpenses);
    }

    //
    private void updateRemainingMoney() {
        this.remainingMoney = this.startingMoney - calculateTotalExpenses();
    }

    //Displays remaining money
    public void displayRemainingMoney(){
        updateRemainingMoney();
        System.out.println("Kiadasok utani maradek: " + getRemainingMoney() + " FT");
    }

    //Lists all expense
    public void listAllExpenses(){
        expenses.forEach(System.out::println);
    }
}
