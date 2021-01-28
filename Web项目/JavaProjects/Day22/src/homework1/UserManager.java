package homework1;

import java.util.HashMap;
import java.util.Map;

/**
 * 王金宇
 * 2020/10/28 0028
 * <p>
 * 该类用于管理用户
 */
public class UserManager {
    //使用Map存储<用户名,密码>
    private Map<String, String> map = new HashMap<>();

    //通过无参构造方法存储默认的用户信息
    public UserManager() {
        map.put("zhangsan", "123");
    }

    //判断用户名是否存在
    public boolean containsName(String name){
        return map.containsKey(name);
    }

    //提供方法添加用户名以及密码
    public void add(String name,String password){
        map.put(name, password);
    }

    //提供方法判断用户名密码是否合法
    public boolean validUser(String name,String password){
        if (password != null){
            return password.equals(map.get(name));
        }
        return false;
    }
}
