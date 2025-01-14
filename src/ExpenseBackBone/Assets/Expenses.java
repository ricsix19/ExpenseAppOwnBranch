package ExpenseBackBone.Assets;

public class Expenses {
    private String description;
    private int amount;
    private boolean isImportant;
    //---------------------
    public Expenses(String description, int amount, boolean isImportant) {
        this.description = description;
        this.amount = amount;
        this.isImportant = isImportant;
    }
    //Getter & Setter
    //---------------------
    public String getDescription() {
        return description;
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
        return description + ": " + amount + " Ft, Importance: " + (isImportant ? "Yes" : "No");
    }
}
