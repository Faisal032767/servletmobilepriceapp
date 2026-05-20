package mydb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectUtil {

	public static Connection getConnected() throws SQLException, ClassNotFoundException {
		String driver = "com.mysql.cj.jdbc.Driver";

		String url = "jdbc:mysql://localhost:3306/mydb1?createDatabaseIfNotExist=true";

		String username = "root";
		String password = "root";

		Class.forName(driver);

		Connection connection = DriverManager.getConnection(url, username, password);

		return connection;
	}

}
