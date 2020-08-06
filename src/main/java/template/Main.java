package template;

import java.util.Calendar;

/**
 *
 */

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(StartUI.class);
        StartUI ui = context.get(StartUI.class);
        ui.add("Hello world !!!");
        ui.add("Hello Sekator !!!");
        ui.print();
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
    }
}
