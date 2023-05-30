package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.adminsachbean;

public class adminsachdao {
	public ArrayList<adminsachbean> getsach(){
		ArrayList<adminsachbean> ds=new ArrayList<adminsachbean>();
		try {
			//b1 Kết nối vào csdl QLSach
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			//B2: Lấy dữ liệu về
			String sql ="select * from sach";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			//B3: Duyệt rs để lưu vào danh sách
			while (rs.next()) {
				//lay ve ma loai va ten loai
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				int soluong= rs.getInt("soluong");
				int gia= rs.getInt("gia");
				String anh =rs.getString("anh");
				String maloai = rs.getString("maloai");
				Date NgayNhap = rs.getDate("NgayNhap");
				String sotap = rs.getString("sotap");
				ds.add(new adminsachbean(masach, tensach, tacgia, soluong, gia, anh, maloai, NgayNhap, sotap));
			}
			//b4 đóng các đối tượng
			rs.close();
			kn.cn.close();
			return ds;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return ds;
	}
	public  Boolean addsach(String masach,String tensach,String tacgia,int soluong,int gia,String maloai,String sotap,String ngaynhap, String anh){
    	try {
    		//b1 Kết nối vào csdl QLSach
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			//B2: Lấy dữ liệu về
			String sql ="insert into sach values(?, ? ,?,?,?,?,?,GETDATE(),?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			cmd.setString(2,tensach);
			cmd.setInt(3, soluong);
			cmd.setInt(4, gia);
			cmd.setString(5, maloai);
			cmd.setString(6, sotap);
			cmd.setString(7,anh);
			cmd.setString(8,tacgia);
			cmd.executeUpdate();
			kn.cn.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public static void main(String[] args) {
		adminsachdao ld = new adminsachdao();
		ld.addsach("123", "HEHHEHEHEHEH","cuong",12,2222,"ccc","12","null","null");
	}
}
