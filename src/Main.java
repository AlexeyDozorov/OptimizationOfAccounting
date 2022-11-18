
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Month month = new Month();
        Year year = new Year();
        printMenu();
        int input = scanner.nextInt();
        while (input != 0){
            if (input == 1){
                month.createArr();
                if (month.arr.size() == 3){
                    System.out.println("Все месячные отчеты успешно считаны");
                }
            } else if (input == 2) {
                year.createArr();

                if (year.arr.size() == 6){
                    System.out.println("Годовой отчет успешно считан");
                }
            } else if (input == 3) {
                if (month.isReportRead() && year.isReportRead()){
                    ReportsChecker.Check(year, month);
                } else{
                    System.out.println("Вы не считали какой то отчет");
                }
            } else if (input == 4){
                if (month.isReportRead()){
                    month.informationMonth();
                } else{
                    System.out.println("Вы не считали какой то отчет");
                }
            } else if (input == 5){
                if (year.isReportRead()){
                    year.informationYear();
                } else{
                    System.out.println("Вы не считали какой то отчет");
                }
            } else {
                System.out.println("Вы ввели какую то не ту цифру");
            }
            printMenu();
            input = scanner.nextInt();
        }
    }
    static void printMenu(){
        System.out.println("1 - Считать все месячные отчёты\n" +
                "2 - Считать годовой отчёт\n"+
                "3 - Сверить отчёты\n"+
                "4 - Вывести информацию о всех месячных отчётах\n"+
                "5 - Вывести информацию о годовом отчёте\n"+
                "0 - Выход");
    }
}

