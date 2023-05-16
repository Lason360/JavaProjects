import java.io.*;
public class buffer {
    public static void main(String[] args) {
        try{
            FileReader reader = new FileReader("Foo.txt");
            BufferedReader read = new BufferedReader(reader);
            String line = null;
            while((line = read.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        }
        catch (IOException ex){
            System.out.println("Ammata hudu code eka waradine");
           //ex.printStackTrace();
        }
    }
}
