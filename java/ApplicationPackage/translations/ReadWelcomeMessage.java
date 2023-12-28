package ApplicationPackage.translations;

import java.util.Locale;
import java.util.ResourceBundle;

public class ReadWelcomeMessage {
    private ResourceBundle resourceBundle;

    public ReadWelcomeMessage(Locale locale){
        resourceBundle = ResourceBundle.getBundle("locales", locale);
    }

    public String getWelcomeMessage(){
        return resourceBundle.getString("welcomeMessage");
    }
}
