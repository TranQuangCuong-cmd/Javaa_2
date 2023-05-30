package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {
	public Connection cn;
	public void KetNoi() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.print("Xong b1");
			String url = "jdbc:sqlserver://DESKTOP-M512K4K:1433;databaseName=QlSach;user=sa; password=2001";
			cn = DriverManager.getConnection(url);
			System.out.print("Xong b2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
	}
}
