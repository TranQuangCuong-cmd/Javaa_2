package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.sachbean;
import bean.xacnhanbean;

public class xacnhandao {
	 public ArrayList<xacnhanbean> getdanhsach(){
	    	ArrayList<xacnhanbean> ds= new ArrayList<xacnhanbean>();
	    	try {
	    		//B1: ket noi vao csdl QlSach
	    		KetNoi kn= new KetNoi();
	    		kn.KetNoi();
	    		//B2: lay du lieu ve
	    		String sql="select * from ViewXacNhan";
	    		PreparedStatement cmd=kn.cn.prepareStatement(sql);
	    		ResultSet rs= cmd.executeQuery();
	    		//B3: Duyet rs de luu vao ds
	    		while(rs.next()) {
	    			  long MaChiTietHD=rs.getLong("MaChiTietHD");
	    			   String hoten=rs.getString("hoten");
	    			   String tensach=rs.getString("tensach");;
	    			    Date NgayMua=rs.getDate("NgayMua");
	    			    long SoLuongMua=rs.getLong("SoLuongMua");;
	    			    long gia=rs.getLong("gia");;
	    			    long ThanhTien=rs.getLong("ThanhTien");;
	    			    boolean damua=rs.getBoolean("damua");
	    			    ds.add(new xacnhanbean(MaChiTietHD, hoten, tensach, NgayMua, SoLuongMua, gia, ThanhTien, damua));
	    		}
	    		//b4: Dong cac doi tuong
	    		rs.close();kn.cn.close();
	    		return ds;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	    	
}
	 public boolean xacnhan( int macthd) {
		 try {
	    		//B1: ket noi vao csdl QlSach
	    		KetNoi kn= new KetNoi();
	    		kn.KetNoi();
	    		//B2: lay du lieu ve
	    		String sql="update ChiTietHoaDon set damua = 1 where MaChiTietHD = ?";
	    		PreparedStatement cmd=kn.cn.prepareStatement(sql);
	    		cmd.setInt(1, macthd);
	    		cmd.executeUpdate();
	    		kn.cn.close();
	    		return true;
			} catch (Exception e) {
				return false;
			}
	 }
}
