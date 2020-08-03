package test;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Component
public class Store {
    private List<String> data = new ArrayList<>();

    public List<String> getAll() {
        return data;
    }

    public void add(String data) {
        this.data.add(data);
    }
}
