import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        System.out.println("Yeah. Going after your tweets. *yam*");
        System.out.println(getMergedProperties());
    }


    private static Properties getMergedProperties(){
        Properties properties= getProperties("src/main/java/tweetlimit.properties");
        return properties;
    }

    private static Properties getProperties(String file) {
        Properties properties = new Properties();
        FileInputStream localPropertiesStream = null;
        try {
            localPropertiesStream = new FileInputStream(file);
            properties.load(localPropertiesStream);
        } catch (IOException e) {
            System.out.println("Problem reading properties file");
            e.printStackTrace();
        } finally {
            if (localPropertiesStream != null) {
                try {
                    localPropertiesStream.close();
                } catch (Exception e) {
                    System.out.println("Dramatic error reading properties file.");
                    throw new RuntimeException(e);
                }
            }
        }
        if (!properties.isEmpty()) {
            return properties;
        } else {
            throw new RuntimeException("Error Reading Properties file: " + file);
        }
    }
}
