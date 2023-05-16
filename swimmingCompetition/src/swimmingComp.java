import java.util.Scanner;
import java.util.ArrayList;

//Main Class is swimming competition which has every objects.
public class swimmingComp {

    
    //People class is the super class of swimmer, judge, spectator and staff member
    static class people{
        private String name;
        private int idNumber;

        //every one can check scorecard
        public void checkScoreCard(){
            System.out.println(this.name+" is checking the score card");
        }
        public people(String name, int idNumber){
            this.name = name;
            this.idNumber = idNumber;
        }


    }

    //swimmers
    static class swimmer extends people{
        public void swim(){
            //swimmer starts swimming
            System.out.println( super.name+"is swimming");
        }
        public swimmer(String Name,int ID) {
            super(Name,ID);
        }
    }

    //spectators
    static class spectator extends people{
        public spectator(String name,int id){
            super(name,id);
        }

    }

    //judge
    static class judge extends people{
        public judge(String name,int id){
            super(name,id);
        }
        public void blowWhistle(){
            System.out.println(super.name+" judge is blowing the whistle.");
        }
    }

    //staffMembers
    static class staffMember extends people{
        public staffMember(String name,int id){
            super(name,id);
        }

    }
    public static void main(String[] args) {
        //number of spectators
        Scanner input = new Scanner(System.in);
        System.out.println("Number of spectators in the pavilion: ");
        int numSpectators = input.nextInt();
        ArrayList <swimmingComp.spectator> specArray = new ArrayList<swimmingComp.spectator>();

        //number of judges
        System.out.println("Number of judges: ");
        int numJudges = input.nextInt();
        ArrayList <swimmingComp.judge> judgeArray = new ArrayList<swimmingComp.judge>();

        //number of swimmers
        System.out.println("Number of Swimmers in the competition: ");
        int numSwimmers = input.nextInt();
        ArrayList <swimmingComp.swimmer> swimmerArray = new ArrayList<swimmingComp.swimmer>();

        //number of staff Members
        System.out.println("Number of Staff Members: ");
        int numStaff = input.nextInt();
        ArrayList <swimmingComp.staffMember> staffArray = new ArrayList<swimmingComp.staffMember>();

        //creating spectator objects
        for(int x = 0;x<numSpectators;x++){
            int a = input.nextInt();
            input.nextLine();
            String b = input.nextLine();
            swimmingComp.spectator specA = new swimmingComp.spectator(b,a);
            specArray.add(specA);
        }

        //creating judge objects
        for(int x = 0;x<numJudges;x++){
            int a = input.nextInt();
            input.nextLine();
            String b = input.nextLine();
            swimmingComp.judge judgeA = new swimmingComp.judge(b,a);
            judgeArray.add(judgeA);
        }

        //creating swimmer objects
        for(int x = 0;x<numSwimmers;x++){
            int a = input.nextInt();
            input.nextLine();
            String b = input.nextLine();
            swimmingComp.swimmer swimmerA = new swimmingComp.swimmer(b,a);
            swimmerArray.add(swimmerA);
        }

        //creating staff member objects
        for(int x = 0;x<numStaff;x++){
            int a = input.nextInt();
            input.nextLine();
            String b = input.nextLine();
            swimmingComp.staffMember staffA = new swimmingComp.staffMember(b,a);
            staffArray.add(staffA);
        }

    }
}
