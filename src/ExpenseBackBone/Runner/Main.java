package ExpenseBackBone.Runner;

import ExpenseBackBone.Assets.Finances;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * TODO: Make it work with txt files aswell, read/write
 */


public class Main {
    static boolean isImportant;
    static Finances finance;

    public static void main(String[] args) {
        welcome();
        codeBase();
    }

    public static void welcome(){
        try {
            Scanner startingMoney = new Scanner(System.in);
            System.out.print("Welcome, please enter a starting amount: ");
            finance = new Finances(startingMoney.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again.");
            welcome();
        }
        finance.displayMoney();
        System.out.println("Welcome to our finance application! please choose an option: ");
    }

    //Code Base
    public static void codeBase(){
        try{
            while(true) {
                Scanner choices = new Scanner(System.in);
                System.out.println("1. Display all expenses");
                System.out.println("2. Display Importance");
                System.out.println("3. Add new expense");
                System.out.println("4. Display remaining money");
                System.out.println("5. Add finance to existing");
                System.out.println("6. Exit application");
                System.out.print("Please enter your option: ");

                int choice = choices.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Here are all your expenses: ");
                        finance.listAllExpenses();
                        break;
                    case 2:
                        System.out.println("Here are all your important expenses: ");
                        if (isImportant) {finance.getExpensesByImportance(true);}
                        else {finance.getExpensesByImportance(false);}
                        break;
                    case 3:
                        Scanner newExpense = new Scanner(System.in);
                        System.out.print("Please enter the description of the expense: ");
                        String newExpenseDescription = newExpense.nextLine();
                        System.out.print("Please enter the amount of the expense: ");
                        int newExpenseAmount = newExpense.nextInt();
                        newExpense.nextLine();
                        System.out.print("Is this expense important? (true/false): ");
                        boolean isImportant = newExpense.nextBoolean();
                        newExpense.nextLine();
                        finance.addExpense(newExpenseDescription, newExpenseAmount, isImportant);
                        break;
                    case 4:
                        finance.displayRemainingMoney();
                        break;
                    case 5:
                        System.out.print("Please enter the amount you want to add: ");
                        Scanner addMoney = new Scanner(System.in);
                        int addMoneyAmount = addMoney.nextInt();
                        finance.addMoneyToExisting(addMoneyAmount);
                        break;
                    case 6:
                        System.out.println("Thank you for using our application!");
                        return;
                    default:
                        System.out.println("Invalid option, please try again.");
                        break;
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input, please try again.");
            codeBase();
        }
    }
}
