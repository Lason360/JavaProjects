import java.util.ArrayList;

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
