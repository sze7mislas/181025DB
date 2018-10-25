import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SzemelyDB {
	final String JDBC_DRIVER = "org.sqlite.JDBC";
	final String URL = "jdbc:sqlite:Szemely.db";

	Connection conn = null;
	Statement createStatement = null;
	DatabaseMetaData dbmd = null;

	public SzemelyDB() {
		try {
			conn = DriverManager.getConnection(URL);
			System.out.println("A kapcsolat létrejött az adatbázissal!");
		} catch (SQLException e) {
			System.err.println("Valami baj van a kapcsolat létrehozásakor" + e);
		}
		// megnézi üres-e az adatbázis
		if(conn!=null) {
			try {
				createStatement=conn.createStatement();
			} catch (SQLException e) {
				System.err.println("Valami baj van createStatement létrehozásakor!!!!"+e);
			}
		}
		

	}
	public void showAllSzemely() {
		String sql="SELECT * FROM szemely";
		try {
			ResultSet rs=createStatement.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("id");
				String vezeteknev = rs.getString("vezeteknev");
				String keresztnev = rs.getString("keresztnev");
				String szuldatum = rs.getString("szuldatum");
				System.out.println(id + " | " + vezeteknev + " | " + 
						   keresztnev + " | " +  szuldatum);
						
			}
			
		} catch (SQLException e) {
			System.err.println("Hiba a szemelyek kiolvasásakor!!!!");
		}
	}
}
