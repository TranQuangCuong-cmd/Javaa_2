package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import bean.loaibean;

public class loaidao {
	public  ArrayList<loaibean> getloai(){
		ArrayList<loaibean> ds= new ArrayList<loaibean>();
    	try {
    		//b1 Kết nối vào csdl QLSach
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			//B2: Lấy dữ liệu về
			String sql ="select * from loai";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			//B3: Duyệt rs để lưu vào danh sách
			while (rs.next()) {
				//lay ve ma loai va ten loai
				String maloai = rs.getString("maloai");
				String tenloai = rs.getString("tenloai");
				ds.add(new loaibean(maloai,tenloai));
			}
			//b4 đóng các đối tượng
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}
	
	
	public  Boolean addloai(String maloai,String tenloai){
    	try {
    		//b1 Kết nối vào csdl QLSach
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			//B2: Lấy dữ liệu về
			String sql ="insert into loai values( ? , ? )";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
			cmd.setString(2,tenloai);
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
		loaidao ld = new loaidao();
		ld.addloai("HAHAHA", "HEHHEHEHEHEH");
	}
}
