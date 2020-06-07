package com.atguigu;

import com.atguigu.domain.Student;
import com.atguigu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import java.io.IOException;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {
        //获取SqlSession对象，从qlSessionFactor中获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //指定要执行的sql语句的标识。sql映射文件中的namespace+"."+标签的id值
        String sqlId = "com.atguigu.dao.StudentDao.selectStudents";
        //执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //输出结果
        studentList.forEach(stu -> System.out.println(stu));
        //关闭SqlSession对象
        sqlSession.close();
    }
}
