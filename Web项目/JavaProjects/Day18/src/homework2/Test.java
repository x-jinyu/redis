package homework2;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;


/**
 * 王金宇
 * 2020/10/20 0020
 * 定义TreeMap存储<小汽车,拥有者姓名>,要求根据小汽车价格降序排序
 * 添加元素
 * 返回价格最高小汽车的拥有者姓名
 * 判断是否有超过100万的小汽车
 * 删除所有低于10万的小汽车
 * 打印
 */
public class Test {
    public static void main(String[] args) {
        TreeMap<Car, String> treeMap = new TreeMap<>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                    return o2.price - o1.price;
            }
        });
        treeMap.put(new Car(111111, "豪车"), "老夏");
        treeMap.put(new Car(20000, "豪车"), "老贝比");
        treeMap.put(new Car(3333333, "豪车"), "老波波");
        System.out.println(treeMap);

        //返回价格最高小汽车的拥有者姓名

        for (Car car1 : treeMap.keySet()) {
            if (car1.price == (treeMap.firstKey().price)) {
                System.out.println(treeMap.get(car1));
            }
        }

        //判断是否有超过100万的小汽车
        /*for (Map.Entry<Car, String> entry : treeMap.entrySet()) {

        }*/
        Car car = treeMap.firstKey();
        if (car.price >= 1000000){
            System.out.println("存在");
        }else{
            System.out.println("不存在");
        }

        //删除所有低于10万的小汽车
        for (Car car1 : treeMap.keySet()) {
            if (car1.price <= 100000){
                treeMap.remove(car1);
            }
        }
        System.out.println(treeMap);
    }

    static class Car {
        int price;
        String brand;

        public Car(int price, String brand) {
            this.price = price;
            this.brand = brand;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return Double.compare(car.price, price) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(price);
        }

        @Override
        public String toString() {
            return "Car{" +
                    "price=" + price +
                    ", brand='" + brand + '\'' +
                    '}';
        }
    }
}
