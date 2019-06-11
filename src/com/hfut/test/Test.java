package com.hfut.test;

import com.hfut.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        InputStream is= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();

        List<Teacher>list= session.selectList("com.hfut.mapper.TeacherMapper.selAll");
        System.out.println(list);

        list= session.selectList("com.hfut.mapper.TeacherMapper.selAll1");
        for(Teacher tem:list){
            System.out.println(tem);
        }


        session.close();
        System.out.println("程序执行结束");

    }
}
