class person{
    private String name;
    public void setName(String n){
        this.name = n;
    }
    public String getName(){
        return this.name;
    }

}
interface sport{
    default void scoreGoal(){
        System.out.println("Goaaaaaal!!!!!");
    }
}
class teacher extends  person implements sport{
//    public String getName(){
//        return super.getName();
//    }
    public void scoreGoal(){
        System.out.println("hi");
    }
}
public class apples{
    public static void main(String[] args) {
        teacher Shanudri = new teacher();
        Shanudri.setName("Shanudri");
        System.out.println(Shanudri.getName());
        Shanudri.scoreGoal();
    }
}
