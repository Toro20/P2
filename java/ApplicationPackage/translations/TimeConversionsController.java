package ApplicationPackage.translations;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources")
@CrossOrigin(origins = "http://localhost:4200")
public class TimeConversionsController {

    @GetMapping("time-conversions")
    public ConvertedTimes getTimeConversions(){
        TimeConversions timeConversions = new TimeConversions();

        String ETtime = timeConversions.ConvertToET();
        String MTtime = timeConversions.ConvertToMT();
        String UTCtime = timeConversions.ConvertToUTC();


        return new ConvertedTimes(ETtime, MTtime, UTCtime);

    }
}
