package Database;
//Import thư viện jdbc
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Database {
	//Khai báo 1 phương thức kết nối csdl
	public static Connection connect(){
		//Ban đầu chưa kết nối nên đối tượng connection là null
		Connection db = null;
		try {
			//Import thư viện jdbc
			Class.forName("com.mysql.jdbc.Driver");
			//Gán link csdl cho chuỗi url
			String url = "jdbc:mysql://localhost:3306/hethong_muaban?useUnicode=true&characterEncoding=UTF-8";
			//Kết nối đến csdl theo đường link của chuỗi url
			db = (Connection) DriverManager.getConnection(url, "root", "");
			
		}
		//Bắt trường hợp không tìm thấy thư viện jdbc
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		//Bắt trường hợp không thể kết nối đến CSDL
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Sau khi kết nối thì trả về đối tượng db
		return db;
	}
}
