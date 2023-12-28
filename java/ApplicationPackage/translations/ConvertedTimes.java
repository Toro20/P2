package ApplicationPackage.translations;

public class ConvertedTimes {

    private String ETtime;
    private String MTtime;
    private String UTCtime;

    public ConvertedTimes(String ETtime, String MTtime, String UTCtime){
        this.ETtime = ETtime;
        this.MTtime = MTtime;
        this.UTCtime = UTCtime;
    }

    public String getUTCtime() {
        return UTCtime;
    }

    public String getETtime() {
        return ETtime;
    }

    public String getMTtime() {
        return MTtime;
    }

}
