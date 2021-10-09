package lab3.utils;

import lab3.exceptions.InvalidChromeException;
import lab3.exceptions.InvalidFirefoxException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static FileInputStream fileInputStream;
    private static Properties properties;
//    private static Context context;
//
//    static {
//        try {
//            fileInputStream = new FileInputStream("/Users/a111/IdeaProjects/software_testing/conf.properties");
//            properties = new Properties();
//            properties.load(fileInputStream);
//            if (properties.getProperty(Constants.WEBDRIVER_CHROME_DRIVER) != null) {
//                if (properties.getProperty(Constants.WEBDRIVER_CHROME_DRIVER).equals(Constants.CHROME_DRIVER)) {
//                    context.setChromedriver(properties.getProperty(Constants.WEBDRIVER_CHROME_DRIVER));
//                }
//            } else {
//                throw new InvalidChromeException();
//            }
//
//            if (properties.getProperty(Constants.WEBDRIVER_FIREFOX_DRIVER) != null) {
//                if (properties.getProperty(Constants.WEBDRIVER_FIREFOX_DRIVER).equals(Constants.FIREFOX_FIREFOX)) {
//                    context.setGeckodriver(properties.getProperty(Constants.WEBDRIVER_FIREFOX_DRIVER));
//                }
//            } else {
//                throw new InvalidFirefoxException();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fileInputStream != null) try {
//                fileInputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    private static Configuration instance;

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void reading(Context context) {
//        Properties props = new Properties();
        properties = new Properties();
        try {
            properties.load(new FileInputStream("conf.properties"));

            if (properties.getProperty(Constants.WEBDRIVER_CHROME_DRIVER) != null) {
                if (properties.getProperty(Constants.WEBDRIVER_CHROME_DRIVER).equals(Constants.CHROME_DRIVER)) {
                    context.setChromedriver(properties.getProperty(Constants.WEBDRIVER_CHROME_DRIVER));
                }
            } else {
                throw new InvalidChromeException();
            }

            if (properties.getProperty(Constants.WEBDRIVER_FIREFOX_DRIVER) != null) {
                if (properties.getProperty(Constants.WEBDRIVER_FIREFOX_DRIVER).equals(Constants.FIREFOX_FIREFOX)) {
                    context.setGeckodriver(properties.getProperty(Constants.WEBDRIVER_FIREFOX_DRIVER));
                }
            } else {
                throw new InvalidFirefoxException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

