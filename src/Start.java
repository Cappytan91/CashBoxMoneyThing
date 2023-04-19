import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Start {

    public Menu menu;
    public Menu order;

    public static void main(String[] args) {
         new Start();
    }

    public Start(){
        this.menu = new Menu(new ArrayList<>());
        this.order = new Menu();

        //loop();
    }

    public void loop(){
        Scanner scan = new Scanner(System.in);
        String input = "";
        System.out.println("What would you like to add to your order?");
        while (!input.toLowerCase().equals("done")){
            input = scan.nextLine();
            //System.out.println("Hio");
            if(menu.getMenuItem(input) != null) {
                order.addMenuItem(menu.getMenuItem(input));
            }
            else if(!input.toLowerCase().equals("done")) {
                System.out.println("Sorry we don't have that, is there anything else i can help with?");
            }

        }

        order.printRcpt();


    }

}
