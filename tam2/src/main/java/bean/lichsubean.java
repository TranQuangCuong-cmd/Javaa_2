package bean;

import java.util.Date;

public class lichsubean {
	private Date NgayMua;
	private String MaSach;
	private String tensach;
	private int SoLuongMua;
	private int gia;
	private int thanhtien;
	public lichsubean(Date ngayMua, String maSach, String tensach, int soLuongMua, int gia, int thanhtien) {
		super();
		NgayMua = ngayMua;
		MaSach = maSach;
		this.tensach = tensach;
		SoLuongMua = soLuongMua;
		this.gia = gia;
		this.thanhtien = thanhtien;
	}
	public lichsubean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public String getMaSach() {
		return MaSach;
	}
	public void setMaSach(String maSach) {
		MaSach = maSach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public int getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public int getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}
}
