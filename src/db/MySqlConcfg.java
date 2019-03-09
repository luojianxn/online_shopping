package db;

public class MySqlConcfg extends BaseConcfg{
	
	public MySqlConcfg(){
		this.driver="com.mysql.jdbc.Driver";
		this.url="jdbc:mysql://192.168.100.146/test";
		this.username="root";
		this.password="123456";		
	}
}
