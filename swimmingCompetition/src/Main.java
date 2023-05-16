class Animal{
    private String name;
    void Animal(String name){
        this.name = name;
    }
    void sleep(){
        System.out.println("ZZZ");
    }

}
class Deer extends Animal{

}

public class Main {
    public static void main(String [] args){

        Animal Bambi2 = new Animal();
        Bambi2.Animal("bambi");
        Deer Bambi3 = (Deer) Bambi;
        Deer Bambi4 = (Deer) Bambi2;
    }
}