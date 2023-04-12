import java.util.ArrayList;

public class Start {
    public static void main(String[] args) {
         new Start();
    }

    public Start(){
        Menu menu = new Menu(new ArrayList<>());
        Menu order = new Menu();
        menu.addMenuItem( new Item("Coke", 0.99, "Just a regular Coke Bruh"));

        System.out.println(menu.getMenuItem("Coke").getName() + "\n\n" + menu.getMenuItem("Hipster's Delight").getPrice());
    }

}
