public class ReportsChecker {
    public static void Check(Year year, Month month) {
        boolean flag = true;
        for (int numberMonth = 0; numberMonth < 3; numberMonth++) {
            int expense = 0;
            int profit = 0;
            for (MonthRecord key :month.arr.get(numberMonth)){
                if (key.isExpense){
                    expense += key.sumForItemName();
                } else {
                    profit += key.sumForItemName();
                }
            }
            for (YearRecord array: year.arr) {
                if (array.month == (numberMonth+1) && !array.is_expense && array.amount != profit){
                    flag = false;
                    System.out.println("Несоответствие доходов в месяце № "+ (numberMonth + 1) + " и годового отчета");
                } else if (array.month == (numberMonth+1) && array.is_expense && array.amount != expense) {
                    flag = false;
                    System.out.println("Несоответствие доходов в месяце № "+ (numberMonth + 1) + " и годового отчета");
                }
            }
        }
        if (flag){
            System.out.println("Несоответсвтвий не обнаружено");
        }
    }
}
