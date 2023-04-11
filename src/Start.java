import java.util.ArrayList;
import java.util.Collection;

public class Start {
    public static void main(String[] args) {
         new Start();
    }

    public Start(){
        Menu menu = new Menu(new ArrayList<>());
        menu.addMenuItem( new Item("Coke", 0.99));

        System.out.println(menu.getMenuItem("Coke").getName());
    }

}
