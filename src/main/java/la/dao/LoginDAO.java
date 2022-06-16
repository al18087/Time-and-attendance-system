package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import la.bean.LoginBean;

public class LoginDAO {
	private String url = "jdbc:postgresql:work";
	private String user = "user1";
	private String pass = "himitu";
	
	public LoginDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}
	}
	
	public LoginBean findLogin(int loginId, String password) throws DAOException {
		String sql = "SELECT * FROM login WHERE login_id = ? AND password = ?";
		try (
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			// プレースホルダの設定
			st.setInt(1, loginId);
			st.setString(2, password);
			
			// SQL文を実行
			try (ResultSet rs = st.executeQuery();) {
				
				if (rs.next()) {
					loginId = rs.getInt("login_id");
					password = rs.getString("password");
					String name = rs.getString("name");
					LoginBean bean = new LoginBean(loginId, password, name);
					return bean;
				} else {
					return null;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("レコードの取得に失敗しました。");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
}
