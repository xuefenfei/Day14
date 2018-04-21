package cn.itcast.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.resource.cci.ResultSet;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
public class DataSourceUtil {
	
	private static final DataSource source=new ComboPooledDataSource();
	
	
	// 获取数据源
		public static DataSource getDataSource() {
			return source;
		}

		// 获取连接对象
		public static Connection getConnection() throws SQLException {
			return source.getConnection();
		}

		// 关闭动作
		public static void closeResultSet(ResultSet rs) {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		// 关闭动作
		public static void closeStatement(Statement st) {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		// 关闭动作
		public static void closeConnection(Connection con) {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	

}
