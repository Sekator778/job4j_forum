package test;

/**
 *
 */

public class StartUI {
    private Store store;

    public StartUI(Store store) {
        this.store = store;
    }

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
