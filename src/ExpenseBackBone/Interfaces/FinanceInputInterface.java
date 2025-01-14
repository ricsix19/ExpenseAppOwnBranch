package ExpenseBackBone.Interfaces;

import java.util.Scanner;

//Handling all inputs in here
public interface FinanceInputInterface {
    public Scanner choices = new Scanner(System.in);
    public Scanner newExpense = new Scanner(System.in);
    public Scanner addMoney = new Scanner(System.in);
}
