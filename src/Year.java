
import java.util.*;

public class Year{

    ArrayList<YearRecord> arr;


    public void  createArr() {
        arr = new ArrayList<>();
        ReadFile readFile = new ReadFile();
        String fileContents = readFile.readFileContentsOrNull("resources\\y.2021.csv");
        if (fileContents != null) {
            String[] lines = fileContents.split("\n");
            for (int j = 1; j < lines.length; j++) {
                String[] lineContents = lines[j].split(",");
                YearRecord yearRecord = new YearRecord(Integer.parseInt(lineContents[0]),Integer.parseInt(lineContents[1]), Boolean.parseBoolean(lineContents[2]));
                arr.add(yearRecord);
            }
        }
    }
    public void informationYear(){
        System.out.println("*** 2021 год ***");
        for (int i = 1; i < 12; i++) {
            int profit = 0;
            int expense = 0;
            for (YearRecord array:arr) {
                if (!array.is_expense && array.month == i) {
                    profit = array.amount;
                } else if (array.is_expense && array.month == i){
                    expense = array.amount;
                }
            }
            System.out.println("В "+ i +" месяце года прибыль составила "+ (profit-expense));
        }
        System.out.println("Средний доход за все месяцы в году - "+ AverageProfit());
        System.out.println("Средний расход за все месяцы в году - "+ AveragExpense());

    }
    public double AverageProfit(){
        int profit = 0;
        int i = 0;
        for (YearRecord array: arr) {
            if (!array.is_expense){
                profit += array.amount;
                i++;
            }
        }
        if (i != 0){
            return (double) profit/i;
        } else {
            return 0;
        }
    }
    public double AveragExpense(){
        int expense = 0;
        int i = 0;
        for (YearRecord array: arr) {
            if (array.is_expense){
                expense += array.amount;
                i++;
            }
        }
        if (i != 0){
            return (double) expense/i;
        } else {
            return 0;
        }
    }
    boolean isReportRead(){
        return (arr != null && arr.size() == 6);
    }
}
