package my.example.jpa;

public interface DatabaseServiceable {

	@Deprecated
	public void createConnection(Object... params) ;

	@Deprecated
	public void closeConnection();

	public void rollback();
	
	public void begin();
	
	public void flush();
	
	public void commit();
}