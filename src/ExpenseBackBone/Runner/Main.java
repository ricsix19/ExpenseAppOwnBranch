package ExpenseBackBone.Runner;

import ExpenseBackBone.Assets.Finances;
import ExpenseBackBone.Assets.MenuOptions;
import ExpenseBackBone.Interfaces.FinanceInputInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * TODO: Make it work with txt files aswell, read/write
 *      file reading: User could upload a file that has expenses, so you need to handle that
 *                    with this in mind, you need to calculate remaining money from the file, and calculate the sum of the file.
 *
 *      file writing: Users can write into files, meaning you need to make features that can support this, eg. Summing expenses and writing into a file and styling it.
 *                    Gotta make a feature to ask the user whether he wants to export his file or just leave it in the database eventually.
 *
 *      Thats it for now
 */


public class Main {
    //static boolean isImportant;
    private static Finances finance;
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
                MenuOptions.displayMenu();
                int choice = FinanceInputInterface.choices.nextInt();
                MenuOptions.executeMenuOption(choice, finance);

                if(choice == 6){
                    System.out.println("Thank you for using our application!");
                    break;
                }

                MenuOptions.executeMenuOption(choice, finance);

                //Was too long so made a class for it instead
                /*
                System.out.println("1. Display all expenses");
                System.out.println("2. Display Importance");
                System.out.println("3. Add new expense");
                System.out.println("4. Display remaining money");
                System.out.println("5. Add finance to existing");
                System.out.println("6. Exit application");
                System.out.print("Please enter your option: ");
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
                        System.out.print("Please enter the description of the expense: ");
                        String newExpenseDescription = FinanceInputInterface.newExpense.nextLine();
                        System.out.print("Please enter the amount of the expense: ");
                        int newExpenseAmount = FinanceInputInterface.newExpense.nextInt();
                        FinanceInputInterface.newExpense.nextLine();
                        System.out.print("Is this expense important? (true/false): ");
                        boolean isImportant = FinanceInputInterface.newExpense.nextBoolean();
                        FinanceInputInterface.newExpense.nextLine();
                        finance.addExpense(newExpenseDescription, newExpenseAmount, isImportant);
                        break;
                    case 4:
                        finance.displayRemainingMoney();
                        break;
                    case 5:
                        System.out.print("Please enter the amount you want to add: ");
                        int addMoneyAmount = FinanceInputInterface.addMoney.nextInt();
                        finance.addMoneyToExisting(addMoneyAmount);
                        break;
                    case 6:
                        System.out.println("Thank you for using our application!");
                        return;
                    default:
                        System.out.println("Invalid option, please try again.");
                        break;
                 }
                 */
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input, please try again.");
            codeBase();
        }
    }
}
