public class Item {

    private String name, description;
    private double price;


    public Item(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
