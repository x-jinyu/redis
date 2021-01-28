package homework1;

import java.util.*;

/**
 * 王金宇
 * 2020/10/28 0028
 * 该类用于管理商品
 */
public class CommodityManager {
    //使用List存储<商品信息>
    private List<Commodity> list = new ArrayList();
    private Scanner input = new Scanner(System.in);

    public CommodityManager() {      //通过构造方法储存默认的值
        this.list.add(new Commodity("1001", "mate 30", 8900, 50000));
        this.list.add(new Commodity("1002", "novo", 4500, 15000));
        this.list.add(new Commodity("1003", "vivo", 8700, 36000));
        this.list.add(new Commodity("1004", "oppo", 1200, 78000));
    }

    public void findCommodity(){
        System.out.println("----------查找商品----------");
        System.out.println("请输入商品名称");
        String name = input.next();
        System.out.println("商品编号\t\t商品名称\t\t商品价格\t\t销量");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().contains(name)){
                System.out.println(list.get(i).getId() + "\t\t" + list.get(i).getName() + "\t\t" + list.get(i).getPrice() + "\t\t" + list.get(i).getSales());
            }
        }
    }

    public void modification(){
        System.out.println("----------修改商品信息----------");
        System.out.println("请输入要修改的商品编号");
        String id = input.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().contains(id)) {
                System.out.println("请输入新的商品编号");
                String uid = input.next();
                System.out.println("请输入新的商品名称");
                String name = input.next();
                System.out.println("请输入新的商品价格");
                int price = input.nextInt();
                System.out.println("请输入新的商品销量");
                int sales = input.nextInt();
                list.get(i).setId(uid);
                list.get(i).setName(name);
                list.get(i).setPrice(price);
                list.get(i).setSales(sales);
                break;
            }
        }
    }

    public void remove() {       //删除
        System.out.println("----------删除商品信息----------");
        System.out.println("请输入要删除的商品编号");
        String id = input.next();
        for (Iterator<Commodity> iter = this.list.iterator(); iter.hasNext(); ) {
            Commodity next = iter.next();
            if (!next.getId().contains(id)) {
                System.out.println("没有" + id + "商品编号");
                return;
            } else {
                iter.remove();
                System.out.println("删除成功");
                return;
            }
        }
    }

    public void add() {      //添加
        while (true) {
            System.out.println("请输入商品编号");
            String id = input.next();
            System.out.println("请输入商品名称");
            String name = input.next();
            System.out.println("请输入商品价格");
            int price = input.nextInt();
            System.out.println("请输入商品销量");
            int sales = input.nextInt();
            this.list.add(new Commodity(id, name, price, sales));
            showCom();

            System.out.println("是否继续添加（Y/N）");
            String conis = input.next();
            if ("n".equals(conis) || "N".equals(conis)) {
                break;
            } else if ("Y".equals(conis) || "y".equals(conis)) {
                continue;
            }
        }
    }

    public void sortByName() {       //根据名字进行升序
        list.sort(new Comparator<Commodity>() {
            @Override
            public int compare(Commodity o1, Commodity o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        showCom();
    }

    public void sortByPrice() {      //根据价格进行升序
        list.sort(new Comparator<Commodity>() {
            @Override
            public int compare(Commodity o1, Commodity o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
        showCom();
    }

    public void sortBySales() {      //根据销量进行降序
        list.sort(new Comparator<Commodity>() {
            @Override
            public int compare(Commodity o1, Commodity o2) {
                return o2.getSales() - o1.getSales();
            }
        });
        showCom();
    }

    public void showCom() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId() + "\t\t" + list.get(i).getName() + "\t\t" + list.get(i).getPrice() + "\t\t" + list.get(i).getSales());
        }
    }
}
