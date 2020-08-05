package template.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import template.StartUI;
import template.Store;

/**
 *
 */

public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("template");
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        StartUI ui2 = context.getBean(StartUI.class);
        System.out.println(ui == ui2);
        System.out.println("ui: " + ui.getInfoStore());
        System.out.println("ui2: " + ui2.getInfoStore());
        Store store1 = context.getBean(Store.class);
        Store store2 = context.getBean(Store.class);
        System.out.println(store1 == store2);

    }
}
