package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.hoadonbean;
import dao.hoadondao;

public class hoadonbo {
	private hoadondao hddao = new hoadondao();
	public int themhoadon(int makh, Date ngaymua, boolean damua) {
		return hddao.themhoadon(makh, ngaymua, damua);
	}
	
	public ArrayList<hoadonbean> gethoadon(int makh) {
		return hddao.gethoadon(makh);
	}
}