package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class StartUI {
    @Autowired
    private Store store;

    public void add(String data) {
        this.store.add(data);
    }
    public void print() {
        for (String s : store.getAll()
             ) {
            System.out.println(s);
        }
    }
}
