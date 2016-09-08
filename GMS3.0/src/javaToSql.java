import java.sql.*;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class javaToSql 
{
	
	private static String JDriver = 			// SQL数据库引擎
				"com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String connectDB = 
			"jdbc:sqlserver://127.0.0.1:1433;" +
				"DatabaseName=Games_managerment";
		// 数据源注意IP地址和端口号，数据库名字！！！
	private static String user = "drx";			// 数据库用户
	private static String password = "123";	//密码
	
	public static String[] tables = {"ATHLETE","GAME",
		"SCORE","ATHLETE"};
	
	public static String [][] sqltables ={
			{"Ano","Aname","Aage","Aheight","Aweight"},
			{"Gno","Gname","Gtime","Gplace"},
			{"Gno","Gname","Ano","RANKS"}
			};

	
	
	
	
	public static void sqltable(DefaultTableModel j,int i,Object[] cdata )
	{
		Connection con = null;
		String table = tables[i-1];
		String stm = "SELECT * FROM "+table;
		System.out.println("\t\t"+stm);
		try 
		{// 加载数据库引擎，返回给定字符串名的类
			Class.forName(JDriver);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		System.out.println("数据库驱动成功");
		try {
			con 
				= DriverManager.getConnection(connectDB, user,
					password);// 连接数据库对象
			System.out.println("连接数据库成功");
			Statement stmt = con.createStatement();// 创建SQL命令对象
			// 创建表
			System.out.println("查询");
			System.out.println("开始读取数据");
			ResultSet rs = stmt.executeQuery(stm);
			// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录
			
			if(i == 1)
			{
				while (rs.next()) 
				{
					// 输出每个字段
					cdata[0] = tostr(rs.getString("Ano"));
					cdata[1] = tostr(rs.getString("Aname"));
					cdata[2] = tostr(rs.getString("Aage"));
					cdata[3] = tostr(rs.getString("Aheight"));
					cdata[4] = tostr(rs.getString("Aweight"));
					
					j.addRow(cdata);
				}
			}
			
			if(i == 2)
			{
				while (rs.next()) 
				{
					// 输出每个字段
					cdata[0] = tostr(rs.getString("Gno"));
					cdata[1] = tostr(rs.getString("Gname"));
					cdata[2] = tostr(rs.getString("Gtime"));
					cdata[3] = tostr(rs.getString("Gplace"));
					
					j.addRow(cdata);
				}
			}
			if(i == 3)
			{
				while (rs.next()) 
				{
					// 输出每个字段
					cdata[0] = tostr(rs.getString("Gno"));
					cdata[1] = tostr(rs.getString("Gname"));
					cdata[2] = tostr(rs.getString("Ano"));
					cdata[3] = tostr(rs.getString("RANKS"));
					
					j.addRow(cdata);
				}
			}
			
			System.out.println("读取完毕");
			// 关闭连接
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("数据库连接错误");
			JOptionPane.showMessageDialog(null, "'"+stm+"'\n\t"+e.getMessage());
		}
	}
	
	
	public static void srctable(int i,String sdata,
			String scolumn,DefaultTableModel j,Object[] cdata )
	{
		Connection con = null;
		String table = tables[i-1];
		String stm = "SELECT * FROM "
				+table+" WHERE " + scolumn + "='" + 
				sdata+"'";
		System.out.println("\t\t"+stm);
		try 
		{// 加载数据库引擎，返回给定字符串名的类
			Class.forName(JDriver);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		System.out.println("数据库驱动成功");
		try {
			con 
				= DriverManager.getConnection(connectDB, user,
					password);// 连接数据库对象
			System.out.println("连接数据库成功");
			Statement stmt = con.createStatement();// 创建SQL命令对象
			// 创建表
			System.out.println("查询");
			System.out.println("开始读取数据");
			ResultSet rs = stmt.executeQuery(stm);
			// 返回SQL语句查询结果集(集合)
			
			
			// 循环输出每一条记录
			if(i == 1)
			{
				while (rs.next()) 
				{
					// 输出每个字段
					cdata[0] = tostr(rs.getString("Ano"));
					cdata[1] = tostr(rs.getString("Aname"));
					cdata[2] = tostr(rs.getString("Aage"));
					cdata[3] = tostr(rs.getString("Aheight"));
					cdata[4] = tostr(rs.getString("Aweight"));
					
					j.addRow(cdata);
				}
			}
			
			if(i == 2)
			{
				while (rs.next()) 
				{
					// 输出每个字段
					cdata[0] = tostr(rs.getString("Gno"));
					cdata[1] = tostr(rs.getString("Gname"));
					cdata[2] = tostr(rs.getString("Gtime"));
					cdata[3] = tostr(rs.getString("Gplace"));
					
					j.addRow(cdata);
				}
			}
			if(i == 3)
			{
				while (rs.next()) 
				{
					// 输出每个字段
					cdata[0] = tostr(rs.getString("Gno"));
					cdata[1] = tostr(rs.getString("Gname"));
					cdata[2] = tostr(rs.getString("Ano"));
					cdata[3] = tostr(rs.getString("RANKS"));
					
					j.addRow(cdata);
				}
			}
			
			System.out.println("读取完毕");
			// 关闭连接
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("数据库连接错误");
			JOptionPane.showMessageDialog(null, "'"+stm+"'\n\t"+e.getMessage());
		}
	}
	public static void update(String c1,String c2,
			String data,int colname,int tableselect)
	{
		
	}
	public static void update(String c1,String c2,
			String data,String colname,int tableselect)
	{
		
		Connection con = null;
		String table = tables[tableselect-1];
		String stm = "UPDATE "+ table +
				" SET "+colname + " = '" + data +
				"' WHERE " + sqltables[tableselect-1][0]+" = " +c1+
				" AND "+ sqltables[tableselect-1][1]+" = '" +c2+"'";
						
		
		System.out.println(stm);
		
		try 
		{
			Class.forName(JDriver);
			
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		try {
			con 
				= DriverManager.getConnection(connectDB, user,
					password);// 连接数据库对象
			
			Statement st = con.createStatement();// 创建SQL命令对象
			st.executeUpdate(stm);// 执行SQL语句
			

			
			// 关闭连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("数据库连接错误");
			JOptionPane.showMessageDialog(null, "'"+stm+"'\n\t"+e.getMessage());
		}
	}
	
	private static String tostr(String s)
	{
		Scanner scan = new Scanner(s);
		s = scan.next();
		scan.close();
		return s;
	}

	public static void adddata(Object valueAt, Object valueAt2,
			Object valueAt3, Object valueAt4, Object valueAt5,
			int tableselect) 
	{
		// TODO Auto-generated method stub
		Connection con = null;
		String table = tables[tableselect-1];
		String stm = "INSERT INTO "+ table +
				" VALUES( "+valueAt + ",'" + valueAt2 +
				"','" + valueAt3 +"','" +valueAt4+"','"
				+ valueAt5 +"')";
						
		
		System.out.println(stm);
		
		try 
		{
			Class.forName(JDriver);
			
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		try {
			con 
				= DriverManager.getConnection(connectDB, user,
					password);// 连接数据库对象
			
			Statement st = con.createStatement();// 创建SQL命令对象
			st.executeUpdate(stm);// 执行SQL语句
			

			
			// 关闭连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "'"+stm+"'\n\t"+e.getMessage());

			
		}
		
	}

	public static void adddata(Object valueAt, Object valueAt2,
			Object valueAt3, Object valueAt4, 
			int tableselect) 
	{
		// TODO Auto-generated method stub
		Connection con = null;
		String table = tables[tableselect-1];
		String stm = "INSERT INTO "+ table +
				" VALUES( "+valueAt + ",'" + valueAt2 +
				"','" + valueAt3 +"','" +valueAt4+"')";
						
		
		System.out.println(stm);
		
		try 
		{
			Class.forName(JDriver);
			
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		try {
			con 
				= DriverManager.getConnection(connectDB, user,
					password);// 连接数据库对象
			
			Statement st = con.createStatement();// 创建SQL命令对象
			st.executeUpdate(stm);// 执行SQL语句
			

			
			// 关闭连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("数据库连接错误");
			JOptionPane.showMessageDialog(null, "'"+stm+"'\n\t"+e.getMessage());
		}
		
		
	}


}