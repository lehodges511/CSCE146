public class Prize {
    //instance variables
    private double price;
    private String name;

    //constructors

    public Prize() {
        this.price = 0;
        this.name = null;
    }

    public Prize(double aPrice, String aName){
        setPrice(aPrice);
        setName(aName);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double aPrice) {
        this.price = aPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }
}
