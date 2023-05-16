import java.io.*;
public class retrieveGame {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fileStream = new FileInputStream("MyGame.ser");

        ObjectInputStream os = new ObjectInputStream(fileStream);

        Object object2 = os.readObject();

        Object object1 = os.readObject();

        Box box1 = (Box) object1;

        Box box2 = (Box) object2;

        System.out.println(box1.b);

    }
}
