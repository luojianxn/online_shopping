package db.Interface;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface IDbUtils {
	
	public Connection getConnection(IConnectConfig confg);
	public Connection getConnection();
	public Connection getCurrentConnection();
	public void setConnectConfig(IConnectConfig confg);
	public  List<Map<String, Object>> getMapList(String sql);

}
