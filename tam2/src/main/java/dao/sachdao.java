package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;
import bean.sachbean;

public class sachdao {
	public ArrayList<sachbean> getsach(){
		ArrayList<sachbean> ds=new ArrayList<sachbean>();
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
				ds.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
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

}
