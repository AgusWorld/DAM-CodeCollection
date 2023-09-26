import java.sql.*;
import java.util.Properties;

public class pokemonMain {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static String url = "jdbc:mysql://localhost:3306/pokemondb";
	static Properties info = new Properties();

	public static void main(String[] args) {
		info.put("user", "root");
		info.put("password", "super3");

//		act1();System.out.println();
//		act2();System.out.println();
//		act3();System.out.println();
//		act4();System.out.println();		
//		act5();System.out.println();
//		act6();System.out.println();
		
	}

	static public void act1() {
		try {
			conn = DriverManager.getConnection(url, info);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select name from pokemon where name is not null");
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static public void act2() {
		try {
			conn = DriverManager.getConnection(url, info);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select name from pokemon where evolution is not null and name is not null");
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static public void act3() {
		try {
			conn = DriverManager.getConnection(url, info);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select name from pokemon where name is not null and candy_count>=25");
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static public void act4() {
		try {
			conn = DriverManager.getConnection(url, info);
			stmt = conn.createStatement();
			stmt.executeUpdate("insert into pokemon (name, evolution, candy_count) values ('Pokemon1', '[{\"num\":\"001\",\"name\":\"Bulbasaur\"}]', 0);");
			rs = stmt.executeQuery("select name from pokemon where name is not null");
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	static public void act5() {
		try {
			conn = DriverManager.getConnection(url, info);
			stmt = conn.createStatement();
			stmt.executeUpdate("update pokemon set evolution='[{\"num\":\"007\",\"name\":\"Arbok\"}]' where name like 'Charizard'");
			rs = stmt.executeQuery("select name from pokemon where name is not null");
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	static public void act6() {
		try {
			conn = DriverManager.getConnection(url, info);
			stmt = conn.createStatement();
			stmt.executeUpdate("delete from pokemon where name like 'Pikachu'");
			rs = stmt.executeQuery("select name from pokemon where name is not null");
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
