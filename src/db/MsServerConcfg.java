package db;

public class MsServerConcfg extends BaseConcfg{
	
	public MsServerConcfg(){
		this.driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		this.url="jdbc:sqlserver://192.168.100.146;databasename=test";
		this.username="sa";
		this.password="123456";
		
	}

}
