package demo1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 王金宇
 * 2020/10/20 0020
 */
public class Test2 {
    public static void main(String[] args) {
        //<课程名称，教师姓名>
        Map<String, String> map = new HashMap<>();

        //添加一组数据
        map.put("java基础", "feifei");
        map.put("体育课", "呆毛王");
        map.put("英语课", "小明");
        map.put("劳动课", "小红");

        //判断是否开设手工课
        System.out.println(map.containsKey("手工课"));

        //判断feifei老师是否任课
        System.out.println(map.containsValue("feifei"));

        //判断体育老师是谁
        System.out.println(map.get("体育课"));

        //替换英语老师为xinxin
        map.replace("英语课", "xinxin");
        System.out.println(map);

        //删除劳动课
        map.remove("劳动课");
        System.out.println(map);

        //查看开设了哪些课
        Set<String> keySet = map.keySet();
        System.out.println(keySet);

        //查看有哪些老师上课
        Collection<String> values = map.values();
        System.out.println(values);

        //查看所有课程及任课老师
        /*Set<Map.Entry<String, String>> entrySet = map.entrySet();
        System.out.println(entrySet);*/
        for (Map.Entry<String, String> entrySet : map.entrySet()) {
            System.out.println(entrySet.getKey() + "任课教师为：" + entrySet.getValue());
        }
    }
}
