package bean;

import java.util.Date;

public class hoadonbean {
	private int MaHoaDon;
	private int makh;
	private Date NgayMua = new Date();
	private boolean damua = false;
	public hoadonbean(int makh, Date ngayMua, boolean damua) {
		super();
		this.makh = makh;
		NgayMua = ngayMua;
		this.damua = damua;
	}
	public int getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public hoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}

}