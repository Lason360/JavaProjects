import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class ItemCodeNotFound extends Exception{}

//instances of objects
class GroceryItem implements Serializable{
    public int price, weight, size, discount, itemCode;
    public String name,mfd,exd;
    public GroceryItem(String name,int price,int discount, int code){
        this.name = name;
        this.price = price;
        this.discount = discount;
        itemCode = code;
    }

}

//customer bill instance
class bill implements Serializable{
    String cashier, customer, date, time;
    ArrayList<GroceryItem> items;
    int totDiscount, totPrice;

    // bill constructor
    bill(String cashier,String customer, String date, String time){
        this.cashier = cashier;
        this.customer = customer;
        this.date = date;
        this.time = time;
    }

    //adding items to the bill
    public void addItems() throws IOException, ItemCodeNotFound {
        Scanner input = new Scanner(System.in);
        char billContinue = 'Y';
        while(billContinue == 'Y'){
            this.items.add(POS.getItemDetails());
            System.out.println("Are there more objects?(Y/N), if you wanna save enter 'save': ");
            billContinue = (char)input.nextLine();
        }
        if(billContinue == "save"){
            this.saveBill();
        }
        else if(billContinue == "N"){
            this.printBill();
            return;
        }
        else{
            System.out.println("invalid input");
        }

    }

    //saves the bill when this method is called
    public void saveBill() throws IOException {
        FileOutputStream fileStream = new FileOutputStream("bill.ser");
        ObjectOutputStream output = new ObjectOutputStream(fileStream);
        output.writeObject(this);
    }

    public void printBill(){
        this.totPrice = 0;
        int billSubTot = 0;
        for(GroceryItem x : this.items){
            billSubTot = billSubTot+x.price;
            this.totPrice = this.totDiscount + x.price* x.discount/100;
            System.out.println(x.name+" "+x.price);
        }
        this.totDiscount = totPrice/billSubTot*100;
        System.out.println(this.totPrice);
        System.out.println(this.totDiscount);
    }
}
class POS {

    //POS system is for inputing items to the bill
    public static GroceryItem getItemDetails() throws IOException, ItemCodeNotFound {
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            String item_code = br.readLine();
            GroceryItem item = null;
            // Fetch item details from the database
            br.close();
            r.close();
            if (item == null) {
                throw new ItemCodeNotFound();
            }
            return item;
        } catch (ItemCodeNotFound e) {
            System.out.println("Item not available. Try again...");
            return getItemDetails();
        }

    }
}

    public class POSsystem {

        //this method requests for saved files that requires to be continued
        public static bill getSavedBill(String fileName) throws IOException, ClassNotFoundException {
            FileInputStream fileStream = new FileInputStream(fileName);
            ObjectInputStream output = new ObjectInputStream(fileStream);
            bill savedBill = (bill) output.readObject();
            return savedBill;
        }

        public static void main(String[] args) throws IOException, ClassNotFoundException, ItemCodeNotFound {

            //hardcoding grocery items
            GroceryItem banana = new GroceryItem("banana",100,25,101);
            GroceryItem milk = new GroceryItem("milk",500,0,102);
            GroceryItem battery = new GroceryItem("battery", 750,10,103);

            System.out.println("Insert Pending bill Name\n For new bill enter 1");
            Scanner input = new Scanner(System.in);
            int billStatus = input.nextInt();
            bill customerBill;
            if (billStatus == 1) {
                //hard coding new bill
                String cashier = "Lasana Subasinghe";
                String customer = "Chalana Gayan";
                String date = "5/9/2023";
                String time = "9.15 AM";
                customerBill = new bill(cashier, customer, date, time);
            } else if (billStatus == 0) {
                //getting a new bill
                Scanner input2 = new Scanner(System.in);
                String fileName = input.nextLine();
                customerBill = getSavedBill(fileName);
            }
            else{
                return;
            }
            customerBill.addItems();
        }
}
