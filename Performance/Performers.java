import java.util.ArrayList;
interface sing{
    public void sing();
}
interface dance{
    public void dance();
}
interface iBackup{
    public void backup();
}
abstract class Artist{
    private String name;
    public String get(){
        return this.name;
    }
    public Artist(String name){
        this.name = name;
    }
}
abstract class Singer extends Artist implements sing{
    public Singer(String name){
        super(name);
    }
}
class mainSinger extends Artist implements sing{
    public mainSinger (String name){
        super(name);
    }
    public void sing(){

        System.out.println("The Main artist: "+this.get()+" is Singing");
    }
}
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

class BackupDancer extends Artist implements dance{
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