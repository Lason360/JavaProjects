import java.util.ArrayList;

//interface for singers
interface sing{
    public void sing();
}

//interface for dancers
interface dance{
    public void dance();
}

//interface for backup artists
interface iBackup{
    public void backup();
}

//abstract class for all artists
abstract class Artist{
    private String name;
    public String get(){
        return this.name;
    }
    public Artist(String name){
        this.name = name;
    }
}

//abstract class for the structure of singers
abstract class Singer extends Artist implements sing{
    public Singer(String name){
        super(name);
    }
}

//artist extends to main artist
class mainSinger extends Artist implements sing{
    public mainSinger (String name){
        super(name);
    }
    public void sing(){

        System.out.println("The Main artist: "+this.get()+" is Singing");
    }
}

//artist extended to singer
class BackupSinger extends Singer implements sing,iBackup{
    public BackupSinger(String name){
        super(name);
    }
    public void sing(){
        System.out.println("The Backup singer: "+ this.get()+" is Singing");
    }
    public void backup(){
        System.out.println(this.get()+" is backing up by singing");
    }
}

//artist extended to Backup dancere
class BackupDancer extends Artist implements dance,iBackup{
    public BackupDancer(String name){
        super(name);
    }
    public void dance(){
        System.out.println("The Backup dancer: "+ this.get()+" is Dancing");
    }
    public void backup(){
        System.out.println(this.get()+" is backing up by dancing");
    }
}

//track
class track{
    private String name;
    private double duration;
    track(String name, double duration){
        this.name = name;
        this.duration = duration;
    }

}

//abstract of the show
abstract class Performance {
    private mainSinger mainArtist;
    public String performanceName;
    protected final String venue;
    protected final int year;
    private ArrayList<BackupSinger> backupSingerList;
    private ArrayList<BackupDancer> backupDancersList;
    private ArrayList<track> trackList;

    //getter for main artist
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

//extended performance - live performance
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

//extended performance - studio performance
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
public class Main {
    public static void main(String[] args) {
        //instance of the main singer
        mainSinger MS = new mainSinger("Taylor Swift");

        //instances of the backup singers
        BackupSinger BS_1 = new BackupSinger("Jeslyn");
        BackupSinger BS_2 = new BackupSinger("Melanie");

        //instances of the backup dancers
        BackupDancer BD_1 = new BackupDancer("Stephanie");
        BackupDancer BD_2 = new BackupDancer("Jake");

        //instances of the tracks
        track T_1 = new track("Lavender Haze", 2.02);
        track T_2 = new track("All too well", 3.42);
        track T_3 = new track("the Lakes", 2.31);
        track T_4 = new track("The Man",3.02);
        track T_5 = new track("Love Story", 3.30);

        //array list of backup dancers
        ArrayList<BackupDancer> listDancers = new ArrayList<>();
        listDancers.add(BD_1);
        listDancers.add(BD_2);

        //array list of backup singers
        ArrayList<BackupSinger> listSingers = new ArrayList<>();
        listSingers.add(BS_1);
        listSingers.add(BS_2);

        //array list of tracks
        ArrayList<track> listTracks = new ArrayList<>();
        listTracks.add(T_1);
        listTracks.add(T_2);
        listTracks.add(T_3);
        listTracks.add(T_4);
        listTracks.add(T_5);

        //initiating a live performance
        livePerformance ErasTour = new livePerformance(MS,"Eras Tour","Glendale",2023,listTracks,listSingers,listDancers);

    }
}
