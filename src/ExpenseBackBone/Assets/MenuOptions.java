package ExpenseBackBone.Assets;

import ExpenseBackBone.Interfaces.FinanceInputInterface;
import ExpenseBackBone.Assets.Finances;

public class MenuOptions {
    // Constants defining menu choices
    private static final int LIST_EXPENSES = 1;
    private static final int LIST_IMPORTANT_EXPENSES = 2;
    private static final int ADD_EXPENSE = 3;
    private static final int DISPLAY_REMAINING_MONEY = 4;
    private static final int ADD_MONEY = 5;
    private static final int EXIT = 6;

    private static boolean isImportant;

    public static void displayMenu() {
        System.out.println("1. Display all expenses");
        System.out.println("2. Display Importance");
        System.out.println("3. Add new expense");
        System.out.println("4. Display remaining money");
        System.out.println("5. Add finance to existing");
        System.out.println("6. Exit application");
        System.out.print("Please enter your option: ");
    }

    public static void executeMenuOption(int choice, Finances finance) {
        switch (choice) {
            case LIST_EXPENSES:
                System.out.println("Here are all your expenses: ");
                finance.listAllExpenses();
                break;
            case LIST_IMPORTANT_EXPENSES:
                System.out.print("Would you like to see important expenses? (true/false): ");
                isImportant = FinanceInputInterface.newExpense.nextBoolean();
                FinanceInputInterface.newExpense.nextLine();
                System.out.println("Here are your important expenses: ");
                finance.getExpensesByImportance(isImportant);
                break;
            case ADD_EXPENSE:
                System.out.print("Please enter the description of the expense: ");
                String newExpenseDescription = FinanceInputInterface.newExpense.nextLine();
                System.out.print("Please enter the amount of the expense: ");
                int newExpenseAmount = FinanceInputInterface.newExpense.nextInt();
                FinanceInputInterface.newExpense.nextLine();
                System.out.print("Is this expense important? (true/false): ");
                isImportant = FinanceInputInterface.newExpense.nextBoolean();
                FinanceInputInterface.newExpense.nextLine();
                finance.addExpense(newExpenseDescription, newExpenseAmount, isImportant);
                break;
            case DISPLAY_REMAINING_MONEY:
                finance.displayRemainingMoney();
                break;
            case ADD_MONEY:
                System.out.print("Please enter the amount you want to add: ");
                int addMoneyAmount = FinanceInputInterface.addMoney.nextInt();
                finance.addMoneyToExisting(addMoneyAmount);
                break;
            case EXIT:
                //System.out.println("Thank you for using our application!");
                return;
            default:
                System.out.println("Invalid option, please try again.");
                break;
        }
    }
}