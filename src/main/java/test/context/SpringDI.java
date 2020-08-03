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
        ui.add("Hello annotationConfigApplicationContext !!!");
        ui.add("Hello Sekator !!!");
        ui.print();
    }
}
