package util;

import java.lang.reflect.Field;

/**
 * 王金宇
 * 2020/11/9 0009
 */
public class ReflectUtil {

    //方法可以自动生成INSERT
    public static String createInsert(Object instance) throws Exception{
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
            if (value!=null){
                if (!columns.toString().equals("(")){
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

    //方法可以自动生成delete
    public static String createDelete(Object instance,String primaryKey) throws Exception{
        StringBuffer sql = new StringBuffer("delete from ");

        Class<?> classFile = null;
        String tableName = null;
        Field field = null;
        Object value = null;
        //获得表名
        classFile = instance.getClass();
        tableName = classFile.getSimpleName();
        //获得主键字段对应属性
        field = classFile.getDeclaredField(primaryKey);
        field.setAccessible(true);
        value = field.get(instance);

        //装配sql
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
     * update 表  set 字段名='值'，字段名='值'  where 主键字段名='主键值'
     */

    public static String createUpdate(Object instance,String primaryKey)throws Exception{
        StringBuffer sql = new StringBuffer("update ");
        StringBuffer set = new StringBuffer(" set ");
        StringBuffer where = new StringBuffer(" where ");

        Class<?> classFile = null;
        String tableName = null;
        Field[] fieldArray = null;
        //获得表名
        classFile = instance.getClass();
        tableName = classFile.getSimpleName();
        //需要更新的字段信息
        fieldArray = classFile.getDeclaredFields();
        for (Field f : fieldArray) {
            f.setAccessible(true);
            String fieldName = f.getName();
            Object value = f.get(instance);
            if (value!=null && !fieldName.equals(primaryKey)){
                if (" set ".equals(set.toString())){
                    set.append(",");
                }
                set.append(fieldName);
                set.append("=");
                set.append("'");
                set.append(value);
                set.append("'");
            }else if(fieldName.equals(primaryKey)){
                where.append(fieldName);
                where.append("=");
                where.append("'");
                where.append(value);
                where.append("'");
            }
        }
        sql.append(set);
        sql.append(where);
        System.out.println(sql);
        return sql.toString();
    }
}
