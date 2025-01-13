package ExpenseBackBone.Runner;

import ExpenseBackBone.Assets.Finances;

import java.util.Scanner;

public class Main {
    static boolean isImportant;

    public static void main(String[] args) {
        Scanner startingMoney = new Scanner(System.in);
        System.out.print("Welcome, please enter a starting amount: ");
        Finances startingFinance = new Finances(startingMoney.nextInt());
        System.out.println("Welcome to our finance application! please choose an option: ");
        while(true){
            Scanner choices = new Scanner(System.in);
            System.out.println("1. Display all expenses");
            System.out.println("2. Display Importance");
            System.out.println("3. Add new expense");
            System.out.println("4. Display remaining money");
            System.out.println("5. Exit application");
            System.out.print("Please enter your option: ");

            int choice = choices.nextInt();
            //choices.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Here are all your expenses: ");
                    startingFinance.listAllExpenses();
                    break;
                case 2:
                    System.out.println("Here are all your important expenses: ");
                    if(isImportant){
                        startingFinance.getExpensesByImportance(true);
                    } else {
                        startingFinance.getExpensesByImportance(false);
                    }
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
                    System.out.println("Thank you for using our application!");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
    }
}
