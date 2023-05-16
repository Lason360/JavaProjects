import java.util.ArrayList;
class track{
    private String name;
    private double duration;
    track(String name, double duration){
        this.name = name;
        this.duration = duration;
    }

}
abstract class Performance {
    private mainSinger mainArtist;
    public String performanceName;
    protected final String venue;
    protected final int year;
    private ArrayList<BackupSinger> backupSingerList;
    private ArrayList<BackupDancer> backupDancersList;
    private ArrayList<track> trackList;


    public mainSinger getMainSinger(){
        return this.mainArtist;
    }
    //Add track method
    void addTrack(String name, double duration){
        track T = new track(name,duration);
        trackList.add(T);
    }

    //record show method
    void recordShow(){}
    public Performance(mainSinger mainArtist, String performanceName,String venue,int year,ArrayList<track> trackList,ArrayList<BackupSinger> backupSingerList,ArrayList<BackupDancer> backupDancersList){
        this.mainArtist = mainArtist;
        this.performanceName = performanceName;
        this.venue = venue;
        this.year = year;
        this.trackList = trackList;
    }

}
class livePerformance extends Performance{

    public livePerformance(mainSinger mainArtist, String performanceName,String venue,int year,ArrayList<track> trackList,ArrayList<BackupSinger> backupSingerList,ArrayList<BackupDancer> backupDancersList){
        super(mainArtist,performanceName,venue,year,trackList,backupSingerList,backupDancersList);
        System.out.println("Welcome to the Performance "+this.performanceName+" by "+this.getMainSinger().get()+"!");
    }
    //overriding record show
    void recordShow(){
        System.out.println("This live performance is being recorded");
    }

    //audience is interactable in only live performances
    void interactWithAudience(){
        System.out.println("interacting with the audience");
    }
}
class studioPerformance extends Performance{

    public studioPerformance(mainSinger mainArtist, String performanceName,String venue,int year,ArrayList<track> trackList,ArrayList<BackupSinger> backupSingerList,ArrayList<BackupDancer> backupDancersList){
        super(mainArtist,performanceName,venue,year,trackList,backupSingerList,backupDancersList);
    }

    //overriding record show
    void recordShow(){
        System.out.println("This studio performance is being recorded");
    }

    //audio processing is only available in studio performances
    void audioProcessing(){
        System.out.println("Audio is being processed");
    }
}