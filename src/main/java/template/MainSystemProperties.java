package template;
import java.util.Properties;

public class MainSystemProperties {
    public static void main(String[] a) {
        // List all System properties
        Properties pros = System.getProperties();
        pros.list(System.out);

        // Get a particular System property given its key
        // Return the property value or null
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("java.library.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}