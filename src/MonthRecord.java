import java.util.ArrayList;

public class MonthRecord {
    final String item_name;
    final boolean isExpense;
    final int quantity;
    final int sumOfOne;

    public MonthRecord(String item_name, boolean isExpense, int quantity, int sumOfOne) {
        this.item_name = item_name;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }

    public int sumForItemName() {
        return quantity*sumOfOne;
    }

}
