package edu.wgu.d387_sample_code.translations;

public class WelcomeMessages {
    private String englishWelcomeMessage;
    private String frenchWelcomeMessage;

    public WelcomeMessages(String englishWelcomeMessage, String frenchWelcomeMessage){
        this.englishWelcomeMessage = englishWelcomeMessage;
        this.frenchWelcomeMessage = frenchWelcomeMessage;
    }

    public String getEnglishWelcomeMessage(){
        return englishWelcomeMessage;
    }

    public String getFrenchWelcomeMessage(){
        return frenchWelcomeMessage;
    }
}
