package ExpenseBackBone.Assets;

public class Expenses {
    private String name;
    private int amount;
    private boolean isImportant;
    //---------------------
    public Expenses(String name, int amount, boolean isImportant) {
        this.name = name;
        this.amount = amount;
        this.isImportant = isImportant;
    }
    //---------------------
    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isImportant() {
        return isImportant;
    }
    //---------------------
    @Override
    public String toString() {
        return name + ": " + amount + " Ft, Fontos: " + (isImportant ? "Igen" : "Nem");
    }
}
