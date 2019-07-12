package steps;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.url;

public class BaseSteps {

    public String getCurrentUrl() {
        URL url = null;
        try {
            url = new URL( url() );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url.toString();
    }
}
