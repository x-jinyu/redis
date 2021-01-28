package test;

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.Student;

import java.io.InputStream;
import java.util.List;

/**
 * 王金宇
 * 2020/11/28 0028
 */
public class MyTest {
    SqlSession session;

    @Before
    public void openSession() throws Exception {
        //创建文件流读取SqlMapConfig.xml文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得SqlSession连接的工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //从工厂中取出一个连接对象
        session = factory.openSession();

    }

    @Test
    public void testStudentGetAll() throws Exception {

        //使用连接对象完成数据库的操作
        List<Student> list = session.selectList("dao.impl.selectAll");
        list.forEach(stu -> System.out.println(stu));
    }

    @Test
    public void testGetStudentById() {
        Student stu = session.selectOne("dao.impl.getById", 1);
        System.out.println(stu);
    }

    @Test
    public void testGetStudentByName() {
        List<Student> list = session.selectList("dao.impl.getName", "三");
        list.forEach(stu -> System.out.println(stu));
    }

    @Test
    public void testInsertStudent() {
        Student stu = new Student("钱七", "8028@qq.com", 22);
        int num = session.insert("dao.impl.insertStudent", stu);
        session.commit();
        System.out.println("增加成功：" + num);
    }

    @Test
    public void testDeleteStudent() {
        int num = session.delete("dao.impl.deleteStudent", 5);
        session.commit();
        System.out.println("删除成功：" + num);
    }

    @After
    public void closeSession() {
        session.close();
    }
}
