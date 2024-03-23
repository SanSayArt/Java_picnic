package control;

import java.util.Scanner;

public class GetSelect {
    static Scanner scan = new Scanner(System.in);

    public Integer getIntegerSel(String sel) {
        System.out.printf(sel);
        String choice = scan.next();
        if (choice.matches("\\d+")) {
            return Integer.parseInt(choice);
        }
        return null;
    }
    public String getStringSel(String sel){
        System.out.printf(sel);
        return scan.next();
    }
    public void closeScan(){
        scan.close();
    }
}
