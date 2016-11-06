package com.stephen.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//import com.stephen.controller.mybatisConnectionFactory;

public class CheckvalidDAO {
	private SqlSessionFactory sqlSessionFactory = null;
	public CheckvalidDAO() throws IOException
	{
		
    }
	
	public String selectByUsername(String username){
		String resource = "mybatis-config.xml";
        InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			return "-2";
		}
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        String userpasswd = null;
        /*if(this.sqlSessionFactory == null){
        	return "-1";
        }*/
        SqlSession session = sqlSessionFactory.openSession();
        try {
        	 userpasswd=(String)session.selectOne("com.stephen.Checkvalid.selectByUsername", username);
 
        } finally {
            session.close();
        }
        //System.out.println("selectByUsername("+username+") --> "+ userpasswd);
        return userpasswd;
    } 
}
