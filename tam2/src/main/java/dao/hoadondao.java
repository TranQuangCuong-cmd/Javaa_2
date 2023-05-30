package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.giohangbean;
import bean.hoadonbean;
import bean.khachhangbean;
import bean.lichsubean;

public class hoadondao {
	public int themhoadon(int makh, Date ngaymua, boolean damua) {
		try {
			//b1: kết nối vào cơ sở dữ liệu QlSach
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			//b2: lay du lieu ve
			String sql = "insert into hoadon(makh, NgayMua, damua) values(?,?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, makh);
			cmd.setDate(2, new java.sql.Date(ngaymua.getTime()));
			cmd.setBoolean(3, damua);
			int rs=cmd.executeUpdate();
			//b3: duyệt rs để lưu vào danh sach
			//b4 đóng các đối tượng
			kn.cn.close();
			if(rs > 0) return getLast();
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	private int getLast() {
		try {
			//b1: kết nối vào cơ sở dữ liệu QlSach
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			//b2: lay du lieu ve
			String sql = "select max(MaHoaDon) as last from hoadon";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs=cmd.executeQuery();
			//b3: duyệt rs để lưu vào danh sach
			while(rs.next()) {
				return rs.getInt("last");
			}
			//b4 đóng các đối tượng
			rs.close();
			kn.cn.close();
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	public ArrayList<hoadonbean> gethoadon(){
		ArrayList<hoadonbean> ds =new ArrayList<hoadonbean>();
		try {
			//b1: kết nối vào cơ sở dữ liệu QlSach
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			//b2: lay du lieu ve
			String sql = "select * from hoadon";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs=cmd.executeQuery();
			//b3: duyệt rs để lưu vào danh sach
			while(rs.next()) {
//				MaHoaDon
//				makh
//				NgayMua
//				damua

				int MaHoaDon= rs.getInt("MaHoaDon");
				int makh= rs.getInt("makh");
				Date NgayMua= rs.getDate("NgayMua");
				boolean damua= rs.getBoolean("damua");
				hoadonbean hd = new hoadonbean(makh, NgayMua, damua);
					hd.setMaHoaDon(MaHoaDon);
				ds.add(hd);
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
	public ArrayList<hoadonbean> gethoadon(int makhi){
		ArrayList<hoadonbean> ds =new ArrayList<hoadonbean>();
		try {
			//b1: kết nối vào cơ sở dữ liệu QlSach
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			//b2: lay du lieu ve
			String sql = "select * from hoadon where makh = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, makhi);
			ResultSet rs=cmd.executeQuery();
			//b3: duyệt rs để lưu vào danh sach
			while(rs.next()) {
//				MaHoaDon
//				makh
//				NgayMua
//				damua

				int MaHoaDon= rs.getInt("MaHoaDon");
				int makh= rs.getInt("makh");
				Date NgayMua= rs.getDate("NgayMua");
				boolean damua= rs.getBoolean("damua");
				hoadonbean hd = new hoadonbean(makh, NgayMua, damua);
					hd.setMaHoaDon(MaHoaDon);
				ds.add(hd);
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
	public int taohoadon(ArrayList<giohangbean> ds,long id) {
		try {
			
			
			//B1: ket noi vao csdl QlSach
			KetNoi kn=new KetNoi();
			kn.KetNoi();
			
			//B2: tạo hóa đơn
			String sql="insert into hoadon values (?,GETDATE(),0); ";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1,id);
			cmd.executeUpdate();
			
			//B3: lấy mã hóa đơn mới tạo về
			sql="SELECT @@IDENTITY AS 'id';";
			cmd = kn.cn.prepareStatement(sql);	
			ResultSet rs = cmd.executeQuery();
			int mhd = 0;
			while(rs.next()) {
				mhd = rs.getInt("id");
			}
			
			//B4: Thêm từng cuốn sách vào chi tiết hóa đơn
			sql="insert into ChiTietHoaDon values (?,?,?,0);";
			cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(3,mhd);
			for (giohangbean s : ds) {
				cmd.setString(1,s.getMasach());
				cmd.setLong(2,s.getSoluong());
				cmd.executeUpdate();
			}

			rs.close(); kn.cn.close();
			return mhd;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<lichsubean> getlichsu(int fl, long makh) {
		try {
			//B1: ket noi vao csdl QlSach
			KetNoi kn=new KetNoi();
			kn.KetNoi();
			
			//B2: lay du lieu ve
			String sql="select hoadon.NgayMua , ChiTietHoaDon.MaSach, sach.tensach, ChiTietHoaDon.SoLuongMua, sach.gia, (sach.gia*ChiTietHoaDon.SoLuongMua) as 'thanhtien' from hoadon inner join ChiTietHoaDon on hoadon.MaHoaDon = ChiTietHoaDon.MaHoaDon inner join sach on ChiTietHoaDon.MaSach = sach.masach where ChiTietHoaDon.damua = ? and makh = ? order by hoadon.NgayMua desc";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1,fl);
			cmd.setLong(2, makh);
			ResultSet rs = cmd.executeQuery();
			//B3: Duyet rs de luu vao arraylist
			ArrayList<lichsubean> ls = new ArrayList<lichsubean>();
			while(rs.next()) {
				Date ngayMua = rs.getDate("NgayMua");
				String maSach = rs.getString("MaSach");
				String tensach = rs.getString("tensach"); 
				int soLuongMua = rs.getInt("SoLuongMua");
				int gia = rs.getInt("gia"); 
				int thanhtien = rs.getInt("thanhtien");
				
				ls.add(new lichsubean(ngayMua, maSach, tensach, soLuongMua, gia, thanhtien));
			}
			//B4: Dong cac doi tuong
			rs.close(); kn.cn.close();
			return ls;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public static void main() {
		hoadondao hd = new hoadondao();
		for (lichsubean t : hd.getlichsu(0, 20)) {
			System.out.println(t.getTensach());
		}
	}
}