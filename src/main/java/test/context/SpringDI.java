package test.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.StartUI;

/**
 *
 */

public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("test");
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        StartUI ui2 = context.getBean(StartUI.class);
        System.out.println(ui == ui2);
        System.out.println("ui: " + ui.getInfoStore());
        System.out.println("ui2: " + ui2.getInfoStore());
    }
}
