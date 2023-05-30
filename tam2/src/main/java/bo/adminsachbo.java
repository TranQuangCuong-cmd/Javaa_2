package bo;

import java.util.ArrayList;

import bean.adminsachbean;
import dao.adminsachdao;


public class adminsachbo {
	 adminsachdao sdao= new adminsachdao();
	   ArrayList<adminsachbean> ds;
	   public ArrayList<adminsachbean> getsach(){
		   ds=sdao.getsach();
		   return ds;
	   }

}
