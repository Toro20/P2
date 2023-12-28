package edu.wgu.d387_sample_code.translations;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/resources")
@CrossOrigin(origins = "http://localhost:4200")
public class WelcomeMessageController {
    ExecutorService executorService = Executors.newFixedThreadPool(2);


    @GetMapping("welcomemessages")
    public WelcomeMessages getWelcomeMessage(){
        String englishWelcomeMessage;
        String frenchWelcomeMessage;

        Future<String> englishMessage = executorService.submit(()->{
            Locale en_CA = new Locale("en", "CA");
            ReadWelcomeMessage readEnglish = new ReadWelcomeMessage(en_CA);
            System.out.println(readEnglish.getWelcomeMessage());

            return readEnglish.getWelcomeMessage();
        });


        Future<String> frenchMessage = executorService.submit(()->{
            Locale fr_CA = new Locale("fr", "CA");
            ReadWelcomeMessage readFrench = new ReadWelcomeMessage(fr_CA);
            System.out.println(readFrench.getWelcomeMessage());
            return readFrench.getWelcomeMessage();
        });

        try{
            englishWelcomeMessage = englishMessage.get();
            frenchWelcomeMessage = frenchMessage.get();

            return new WelcomeMessages(englishWelcomeMessage, frenchWelcomeMessage);

        }catch (Exception e){
            return new WelcomeMessages("Could not get english message", "Could not get french message");
        }
    }
}
