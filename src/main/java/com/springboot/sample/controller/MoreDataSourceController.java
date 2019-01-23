package com.springboot.sample.controller;

import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoreDataSourceController {

	//注入方式一：类成员属性注入方式
	@Autowired
	@Qualifier("bi1")
	private DataSource dataSource1;
	
	@Resource(name = "bi2")
	private DataSource dataSource2;
	
	@Resource(name = "bi3")
	private DataSource dataSource3;

	@RequestMapping("/getMoreDataSource")
	public String getMoreDataSource(){
		
		try {
			Connection conn1 = dataSource1.getConnection();
			Connection conn2 = dataSource2.getConnection();
			Connection conn3 = dataSource3.getConnection();
			
			System.out.println(conn1);
			System.out.println(conn2);
			System.out.println(conn3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "success";
	}
}
