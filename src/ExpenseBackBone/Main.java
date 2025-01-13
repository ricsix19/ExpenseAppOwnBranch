package ExpenseBackBone.Runner;

import ExpenseBackBone.Assets.Finances;
import ExpenseBackBone.Exceptions.WelcomeException;

import java.util.Scanner;

public class Main {
    static boolean isImportant;
    static Finances startingFinance;

    public static void main(String[] args) {
        Welcome();
        codeBase();
    }

    public static void Welcome(){
        try {
            Scanner startingMoney = new Scanner(System.in);
            System.out.print("Welcome, please enter a starting amount: ");
            startingFinance = new Finances(startingMoney.nextInt());
        } catch (WelcomeException e) {
            throw new WelcomeException("Invalid data used. Use a number instead");
        }
        System.out.println("Welcome to our finance application! please choose an option: ");
    }

    public static void codeBase(){
        while(true){
            Scanner choices = new Scanner(System.in);
            System.out.println("1. Display all expenses");
            System.out.println("2. Display Importance");
            System.out.println("3. Add new expense");
            System.out.println("4. Display remaining money");
            System.out.println("5. Add finance to existing");
            System.out.println("6. Exit application");
            System.out.print("Please enter your option: ");

            int choice = choices.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Here are all your expenses: ");
                    startingFinance.listAllExpenses();
                    break;
                case 2:
                    System.out.println("Here are all your important expenses: ");
                    if(isImportant){startingFinance.getExpensesByImportance(true);}
                    else {startingFinance.getExpensesByImportance(false);}
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
                    startingFinance.addExpense(newExpenseDescription, newExpenseAmount, isImportant);
                    break;
                case 4:
                    startingFinance.displayRemainingMoney();
                    break;
                case 5:
                    System.out.print("Please enter the amount you want to add: ");
                    Scanner addMoney = new Scanner(System.in);
                    int addMoneyAmount = addMoney.nextInt();
                    startingFinance.addMoneyToExisting(addMoneyAmount);
                    break;
                case 6:
                    System.out.println("Thank you for using our application!");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
    }
}
