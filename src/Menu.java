import java.util.ArrayList;

public class Menu {

    private ArrayList<Item> items;

    public Menu(ArrayList<Item> items){
        this.items = items;
    }

    public void addMenuItem(Item item){
        items.add(item);
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
