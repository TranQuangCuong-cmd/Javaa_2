package bo;

import java.util.ArrayList;

import bean.chitiethoadonbean;
import bean.giohangbean;
import dao.chitiethoadondao;

public class chitiethoadonbo {
	private chitiethoadondao cthddao = new chitiethoadondao();
	public void insert(int mahd, giohangbo g) {
		for(giohangbean x: g.ds) {
			cthddao.insert(mahd, x.getMasach(), (int) x.getSoluong(), false);
		}
	}
	
	public ArrayList<chitiethoadonbean> getchitiethoadon(int mahd){
		return cthddao.getchitiethoadon(mahd);
	}
}