package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import la.bean.LoginBean;

public class RegisterDAO {
	private String url = "jdbc:postgresql:work";
	private String user = "user1";
	private String pass = "himitu";
	
	public RegisterDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}
	}
	
	public LoginBean saveRegister(int loginId, String password, String name) throws DAOException {
		String sql = "INSERT INTO login VALUES (?, ?, ?)";
		try (
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			// プレースホルダの設定
			st.setInt(1, loginId);
			st.setString(2, password);
			st.setString(3, name);
			
			// SQL文を実行
			st.executeUpdate();
			LoginBean bean = new LoginBean(loginId, password, name);
			return bean;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの追加に失敗しました。");
		}
	}
}
