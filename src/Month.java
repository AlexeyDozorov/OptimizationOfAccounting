
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Month{//
    ArrayList<ArrayList<MonthRecord>> arr;
    HashMap<Integer, String> titleOfMonth = new HashMap<>();

    public Month() {
        titleOfMonth.put(0,"***Месяц Январь***");
        titleOfMonth.put(1,"***Месяц Февраль***");
        titleOfMonth.put(2,"***Месяц Март***");
    }

    public void  createArr() {
        arr = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            ReadFile readFile = new ReadFile();
            ArrayList<MonthRecord> arrayList = new ArrayList<>();
            String fileContents = readFile.readFileContentsOrNull("resources\\m.20210" + i + ".csv");
            if (fileContents != null){
                String[] lines = fileContents.split("\n"); // если я ставлю System.lineSeparator(), то у меня почему то не разделяет строку, следовательно не считывает файлы, не пойму почему
                for (int j = 1; j < lines.length ; j++) {
                    String[] lineContents = lines[j].split(",");
                    MonthRecord monthRecord = new MonthRecord(lineContents[0],Boolean.parseBoolean(lineContents[1]),Integer.parseInt(lineContents[2]),Integer.parseInt(lineContents[3]));
                    arrayList.add(monthRecord);
                }
                arr.add(arrayList);
            }
        }
    }

    public void informationMonth() {
        for (int numberMonth = 0; numberMonth <3; numberMonth++) {
            System.out.println(titleOfMonth.get(numberMonth));
            int maxExpense = 0;
            int expense;
            String nameWaste = "";
            int profit;
            int maxProfit = 0;
            String nameProfit = "";
            for (MonthRecord key :arr.get(numberMonth)){
                if (!key.isExpense){
                    profit = key.sumForItemName();
                    if (profit >maxProfit) {
                        maxProfit = profit;
                        nameProfit = key.item_name;
                    }
                } else {
                    expense = key.sumForItemName();
                    if (expense >maxExpense) {
                        maxExpense = expense;
                        nameWaste = key.item_name;
                    }
                }
            }
            System.out.println("Самая большая прибыль была от товара "+ nameProfit+ ", оно принесло "+ maxProfit);
            System.out.println("Самая большая трата была от товара "+ nameWaste+ ", оно принесло "+ maxExpense + "\n");
        }

    }
    boolean isReportRead(){
        return (arr != null && arr.size() == 3);
    }
}
