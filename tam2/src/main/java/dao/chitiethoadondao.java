package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.chitiethoadonbean;
import bean.khachhangbean;

public class chitiethoadondao {
	public ArrayList<chitiethoadonbean> getchitiethoadon(int mahd){
		ArrayList<chitiethoadonbean> ds =new ArrayList<chitiethoadonbean>();
		try {
			//b1: kết nối vào cơ sở dữ liệu QlSach
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			//b2: lay du lieu ve
			String sql = "select * from ChiTietHoaDon where MaHoaDon = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, mahd);
			ResultSet rs=cmd.executeQuery();
			//b3: duyệt rs để lưu vào danh sach
			while(rs.next()) {
				//lấy về
//				MaChiTietHD
//				MaSach
//				SoLuongMua
//				MaHoaDon
//				DaMua

				int MaChiTietHD= rs.getInt("MaChiTietHD");
				String MaSach= rs.getString("MaSach");
				int SoLuongMua= rs.getInt("SoLuongMua");
				int MaHoaDon= rs.getInt("MaHoaDon");
				String DaMua= rs.getString("DaMua");
				chitiethoadonbean kh = new chitiethoadonbean(MaSach, SoLuongMua, MaHoaDon, false);
					kh.setMaChiTietHD(MaChiTietHD);
				ds.add(kh);
			}
			//b4 đóng các đối tượng
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int insert(int mahd, String masach, int sl, Boolean damua) {
		try {
			//b1: kết nối vào cơ sở dữ liệu QlSach
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			//b2: lay du lieu ve
			String sql = "insert into ChiTietHoaDon(MaSach, SoLuongMua, MaHoaDon, DaMua) values(?,?,?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			cmd.setInt(2, sl);
			cmd.setInt(3, mahd);
			cmd.setBoolean(4, damua);
			int rs=cmd.executeUpdate();
			//b3: duyệt rs để lưu vào danh sach
			//b4 đóng các đối tượng
			kn.cn.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}