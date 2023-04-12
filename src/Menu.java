import java.io.*;
import java.util.ArrayList;

public class Menu {

    private ArrayList<Item> items;
    private ArrayList<Menu> order;

    public Menu(ArrayList<Item> items){
        this.items = items;
        getMenuFromText();
    }

    public Menu(){
        this.items = new ArrayList<Item>();
    }

    public void getMenuFromText(){
        try {

        FileInputStream fstream = new FileInputStream("src/res/Menu.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            // Print the content on the console
            //System.out.println (strLine);

            String[] arr = strLine.split("\\s*,\\s*");
            addMenuItem(new Item(arr[0], Double.valueOf(arr[1]), arr[2]));

        }

        //Close the input stream
        fstream.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void addMenuItem(Item item){
        items.add(item);
    }
    public void removeMenuItem(Item item){
        this.items.remove(item);
    }

    public Item getMenuItem(int index){
        return items.get(index);
    }

    public Item getMenuItem(String menuItem){
        Item item = null;

        for (Item i: items) {
            if(i.getName().toLowerCase().equals(menuItem.toLowerCase())){
                item = i;
            }
        }

        return item;
    }

}
