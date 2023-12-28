package ApplicationPackage.translations;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeConversions {

    private final ZonedDateTime eventStartTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles")).withHour(12).withMinute(30);

    public String ConvertToET(){
        ZonedDateTime ETtime = eventStartTime.withZoneSameInstant(ZoneId.of("America/New_York"));

        return ETtime.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }

    public String ConvertToUTC(){
        ZonedDateTime UTCtime = eventStartTime.withZoneSameInstant(ZoneId.of("UTC"));

        return UTCtime.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }

    public String ConvertToMT(){
        ZonedDateTime MTtime = eventStartTime.withZoneSameInstant(ZoneId.of("America/Denver"));

        return MTtime.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }


}
