package util;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 王金宇
 * 2020/11/19 0019
 */
public class ReflectUtil {
    public static String createInsert(Object instance) throws Exception {
        StringBuffer sql = new StringBuffer("insert into ");
        StringBuffer columns = new StringBuffer("(");
        StringBuffer values = new StringBuffer(" values(");

        Class classFile = null;
        String tableName = null;
        Field[] fieldArray = null;

        //通过方法getClass()获取instance的类名，然后通过getSimpleName()方法获取简易类名
        classFile = instance.getClass();
        tableName = classFile.getSimpleName();

        fieldArray = classFile.getDeclaredFields(); //将字段值全部返回成一个数组
        for (Field field : fieldArray) {
            String fieldName = field.getName(); //字段名字
            field.setAccessible(true);  //忽略私有公有的属性
            Object value = field.get(instance);//字段值
            if (value != null) {
                if (!columns.toString().equals("(")) {
                    columns.append(",");
                    values.append(",");
                }
                columns.append(fieldName);
                values.append("'");
                values.append(value);
                values.append("'");
            }
        }
        columns.append(")");
        values.append(")");

        //装配sql命令
        sql.append(tableName);
        sql.append(columns);
        sql.append(values);
        System.out.println(sql.toString());
        return sql.toString();
    }

    public static String createDelete(Object instance, String primaryKey) throws Exception {
        StringBuffer sql = new StringBuffer("delete from ");
        Class classFile = null;
        Field field = null;
        String tableName = null;
        Object value = null;
        //1.获得操作表名
        classFile = instance.getClass();
        tableName = classFile.getSimpleName();
        //2.获得主键字段对应属性
        field = classFile.getDeclaredField(primaryKey);
        field.setAccessible(true);
        value = field.get(instance);

        //3.装配SQL
        sql.append(tableName);
        sql.append(" where ");
        sql.append(primaryKey);
        sql.append(" = ");
        sql.append("'");
        sql.append(value);
        sql.append("'");
        System.out.println(sql);
        return sql.toString();
    }

    /*
     * 自动生成update
     *
     *  update 表  set 字段名='值'，字段名='值'  where 主键字段名='主键值'
     *
     */

    public static String createUpdate(Object instance, String primaryKey) throws Exception {
        StringBuffer sql = new StringBuffer("update ");
        StringBuffer set = new StringBuffer(" set ");
        StringBuffer where = new StringBuffer(" where ");
        Class classFile = null;
        String tableName = null;
        Field fieldArray[] = null;

        //1.获得操作表名
        classFile = instance.getClass();
        tableName = classFile.getSimpleName();
        //2.需要更新的字段信息
        fieldArray = classFile.getDeclaredFields();
        for (Field f : fieldArray) {
            f.setAccessible(true);
            String fieldName = f.getName();
            Object value = f.get(instance);

            if (value != null && !fieldName.equals(primaryKey)) {
                if (!" set ".equals(set.toString())) {
                    set.append(",");
                }
                set.append(fieldName);
                set.append("=");
                set.append("'");
                set.append(value);
                set.append("'");
            } else if (fieldName.equals(primaryKey)) {
                where.append(fieldName);
                where.append("=");
                where.append("'");
                where.append(value);
                where.append("'");
            }
        }
        //组装
        sql.append(classFile.getSimpleName());
        sql.append(set);
        sql.append(where);
        System.out.println(sql);
        return sql.toString();
    }


    /*
     *   将临时表中数据行封装成为对应实体类对象
     *
     *   ResultSet table ,Class 实体类  private Integer DeptNo
     *    //当前类所有属性信息
     *   属性数组 =实体类.getDeclaredFields()
     *   while(table.next()){
     *    //每次得到一行数据，就生成一个对应实体类对象
     *   Object instance= 实体类.newInstance();
     *    //将当前数据行字段内容赋值给实例对象同名属性
     *    for(int i=0;i<属性数组.length;i++){
     *         属性对象 =        属性数组【i】; // private Integer deptNo
     *         //到当前数据行得到与当前属性同名字段的值
     *         String value =  table.getString(属性对象.名字)
     *         if(value!=null){
     *               if(属性对象.类型==“Integer”){
     *                       属性对象。set(instance,Integer.valueof(value));
     *                }else  if(属性对象.类型==“Double”){
     *                       属性对象。set(instance,Double.valueof(value));
     *                }else  if(属性对象.类型==“String”){
     *                       属性对象。set(instance,value);
     *                }
     *         }
     *     }
     *
     * }
     *
     */

    public static List convertData(ResultSet table, Class classFile) throws Exception {
        Field fieldArray[] = null;
        List list = new ArrayList();
        //1.获得当前实体类所有的属性信息
        fieldArray = classFile.getDeclaredFields();
        //2.赋值
        while (table.next()) {
            //2.1 每次得到一个数据行就生成一个对应实体类实例对象
            Object instance = classFile.newInstance();
            //2.2将当前数据行字段的值赋值给实例对象同名属性
            for (int i = 0; i < fieldArray.length; i++) {
                Field field = fieldArray[i];
                String fieldName = field.getName();
                String fieldTypeName = field.getType().getSimpleName();
                String value = null;
                try {
                    value = table.getString(fieldName);
                } catch (SQLException throwables) {
                    //throwables.printStackTrace();
                    System.out.println(fieldName + "字段不存在");
                    continue; //临时表没有这个字段，换下一个字段
                }
                if (value != null) {
                    field.setAccessible(true);
                    if (fieldTypeName.equals("Integer")) {
                        field.set(instance, Integer.valueOf(value));
                    } else if (fieldTypeName.equals("Double")) {
                        field.set(instance, Double.valueOf(value));
                    } else if (fieldTypeName.equals("String")) {
                        field.set(instance, value);
                    }
                }
            }
            //2.3将封装好的实体类对象存入到List
            list.add(instance);
        }

        return list;
    }

    /*
     * 作用：在添加和更新环节，自动将得到请求参数内容赋值到对应实体类的属性
     *   dept_Add.html                                   Dept.class
     *   部门名：<input type="text" name="dname">        String dname
     *   部门位置：<input type="text" name="loc">        String loc
     *                                                    Integer deptNo
     *   注册页与更新页发送的请求参数名称必须与对应的实体类属性名
     *   完全一致（包括大小写）
     *
     *   //1.通过反射机制创建当前类的实例对象 instance
     *   //2.得到当前实体类所有属性信息【Interger deptNo,String dname,String loc】
     *   //3.根据属性名到请求包读取同名请求参数内容String value=req.getParameter("deptNo")
     *   //4.如果 value=='' or value==null  or value=="on"都不能赋值
     *   //5.根据属性类型对参数内容进行类型转变后进行赋值 Double.value,Integer.value
     */

    public static Object init(HttpServletRequest request, Class classFile) throws Exception {
        Object instance = null;
        Field[] fieldArray = null;
        //1.通过反射机制创建当前类的实例对象 instance
        instance = classFile.newInstance();
        //2.得到当前实体类所有属性信息
        fieldArray = classFile.getDeclaredFields();
        //3.根据属性名到请求包读取同名请求参数内容
        for (int i = 0; i < fieldArray.length; i++) {
            Field field = fieldArray[i];
            String fieldName = field.getName();
            String typeName = field.getType().getSimpleName();
            field.setAccessible(true);
            String value = request.getParameter(fieldName);
            if (value != null && !"".equals(value) && !"on".equals(value)) {
                if (typeName.equals("Integer")) {
                    field.set(instance, Integer.valueOf(value));
                } else if (typeName.equals("Double")) {
                    field.set(instance, Double.valueOf(value));
                } else if (typeName.equals("String")) {
                    field.set(instance, value);
                }
            }
        }
        return instance;
    }
}
