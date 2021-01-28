package homework1;

import java.util.Objects;

/**
 * 王金宇
 * 2020/10/28 0028
 */
public class Commodity {
    private String id;
    private String name;
    private int price;
    private int Sales;

    public Commodity() {
    }

    public Commodity(String id, String name, int price, int sales) {
        this.id = id;
        this.name = name;
        this.price = price;
        Sales = sales;
    }

    public String getId() {
        return id;
    }

    public Commodity setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Commodity setName(String name) {
        this.name = name;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Commodity setPrice(int price) {
        this.price = price;
        return this;
    }

    public int getSales() {
        return Sales;
    }

    public Commodity setSales(int sales) {
        Sales = sales;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return price == commodity.price &&
                Sales == commodity.Sales &&
                Objects.equals(id, commodity.id) &&
                Objects.equals(name, commodity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, Sales);
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", Sales=" + Sales +
                '}';
    }
}
