package bean;

public class chitiethoadonbean {
	private int MaChiTietHD;
	private String MaSach;
	private int SoLuongMua;
	private int MaHoaDon;
	private boolean DaMua = false ;
	public chitiethoadonbean(String maSach, int soLuongMua, int maHoaDon, boolean daMua) {
		super();
		MaSach = maSach;
		SoLuongMua = soLuongMua;
		MaHoaDon = maHoaDon;
		DaMua = daMua;
	}
	public int getMaChiTietHD() {
		return MaChiTietHD;
	}
	public void setMaChiTietHD(int maChiTietHD) {
		MaChiTietHD = maChiTietHD;
	}
	public String getMaSach() {
		return MaSach;
	}
	public void setMaSach(String maSach) {
		MaSach = maSach;
	}
	public int getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public int getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public boolean isDaMua() {
		return DaMua;
	}
	public void setDaMua(boolean daMua) {
		DaMua = daMua;
	}
	public chitiethoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}

}