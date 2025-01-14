package ExpenseBackBone.Assets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Finances {
    private int finance;
    //Starting money, usage in Main

    private int remainingMoney;
    //Remainder of our money, gotta update it when expense hits.

    private List<Expenses> expenses;
    //Storing our expenses

    //Constructor of Finances
    //---------------------------------------------------
    public Finances(int finance) {
        this.finance = finance;
        this.remainingMoney = finance;
        this.expenses = new ArrayList<>();
    }
    //---------------------------------------------------
    //Getter & Setter
    public int getFinance() {
        return finance;
    }

    public void setFinance(int finance) {
        this.finance = finance;
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

    //Displays how much money we got
    public void displayMoney(){
        System.out.println("Amount: " + getFinance() + "FT");
    }

    //Adds money to existing money
    public void addMoneyToExisting(int addMoney) {
        this.finance += addMoney; // updating the remaining money
        updateRemainingMoney(); //updating remaining money
        System.out.println("We've addded " + addMoney + " Ft to the starting money");
    }

    //Addig new Expense
    public void addExpense(String description, int amount, boolean isImportant) {
        expenses.add(new Expenses(description, amount, isImportant));
        System.out.println("New expense added: " + description + ", " + amount + "Ft, Importantance: " + (isImportant ? "Igen" : "Nem"));
        updateRemainingMoney();
    }

    //Sum of all total expense
    public int calculateTotalExpenses(){
        return expenses.stream().mapToInt(Expenses::getAmount).sum();
    }

    //Works, lists expenses by importance
    public void getExpensesByImportance(boolean isImportant) {
        List<Expenses> importantExpenses = expenses.stream().filter(expense -> expense.isImportant() == isImportant).toList();
        System.out.println("Important: " + importantExpenses);
        List<Expenses> notImportantExpenses = expenses.stream().filter(expense -> expense.isImportant() != isImportant).toList();
        System.out.println("Not important: " + notImportantExpenses);
    }


    //
    private void updateRemainingMoney() {
        this.remainingMoney = this.finance - calculateTotalExpenses();
    }

    //Displays remaining money
    public void displayRemainingMoney(){
        updateRemainingMoney();
        System.out.println("Remaining money left: " + getRemainingMoney() + " FT");
    }

    //Lists all expense and displays how much money we got
    public void listAllExpenses(){
        expenses.forEach(System.out::println);
    }
}
