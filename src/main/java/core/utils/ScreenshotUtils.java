package core.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import selenium.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScreenshotUtils {
    private final static Logger LOGGER = Logger.getLogger(ScreenshotUtils.class.getName());

    private static final String CUSTOM_REPORT_OUTPUT_PATH = System.getProperty("screenshots.path.output");
    private static final String FITNESSE_SERVER_REPORT_OUTPUT_PATH = "FitNesseRoot";
    private static final String REPORTS_BASE_PATH = StringUtils.isNotEmpty(CUSTOM_REPORT_OUTPUT_PATH) ? CUSTOM_REPORT_OUTPUT_PATH : FITNESSE_SERVER_REPORT_OUTPUT_PATH;
    private static final String SCREENSHOTS_PATH = "files/screenshots/";

    public static String takeScreenshot(String prefix) {
        String path;

        try {
            WebDriver augmentedDriver = new Augmenter().augment(DriverManager.getDriver());
            File source = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);

            path = FileUtils.getFile(SCREENSHOTS_PATH + DateUtils.getCurrentDate(), prefix + "_" + source.getName()).getPath();

            FileUtils.copyFile(source, new File(REPORTS_BASE_PATH, path));

            return path;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unable to take screenshot", e);

            return null;
        }
    }

}
