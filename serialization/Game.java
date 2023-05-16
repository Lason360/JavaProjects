import java.io.*;
class Box implements Serializable{
    public int w,h,b;

    public Box (int w,int h, int b){
        this.w = w;
        this.h = h;
        this.b = b;
    }
}

public class Game {
    public static void main(String[] args) throws IOException {
        Box box1 = new Box(12, 32, 100000);
        Box box2 = new Box(112, 332, 442);
        FileOutputStream fileStream = new FileOutputStream("MyGame.ser");
        ObjectOutputStream os = new ObjectOutputStream(fileStream);
        os.writeObject(box1);
        os.writeObject(box2);
        os.close();
    }
}