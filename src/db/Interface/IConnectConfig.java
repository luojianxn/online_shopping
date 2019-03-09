package db.Interface;

public interface IConnectConfig {
	public String getDriver();
	public void setDriver(String driver);
	public String getUrl();
	public void setUrl(String url);
	public String getUsername() ;
	public void setUsername(String username);
	public String getPassword();
	public void setPassword(String password) ;

}
