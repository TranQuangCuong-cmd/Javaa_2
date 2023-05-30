package controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bo.adminsachbo;
import bo.loaibo;
import dao.adminsachdao;
import dao.loaidao;
import dao.sachdao;

/**
 * Servlet implementation class sachadminController
 */
@WebServlet("/sachadminController")
public class sachadminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sachadminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		 DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		 String dirUrl1 = request.getServletContext().getRealPath("") +  File.separator + "image_sach";
		 response.getWriter().println(dirUrl1);
		 String ms = null, ts = null,tg= null,sl= null,gia= null,date= null,st= null,ml= null, edit=null, old_img=null;
		 String name = null;
		 RequestDispatcher rd = null ;
		 edit = request.getParameter("edit");
		 old_img = request.getParameter("old_img");
		 
		try {
				List<FileItem> fileItems = upload.parseRequest(request);//Lấy về các đối tượng gửi lên
				//duyệt qua các đối tượng gửi lên từ client gồm file và các control
					for (FileItem fileItem : fileItems) {
			 			 if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
							// xử lý file
							String nameimg = fileItem.getName();
							System.out.println("Tên ở đây: "+nameimg);
							name = nameimg;
							if (!nameimg.equals("")) {
						           //Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
								String dirUrl = request.getServletContext().getRealPath("") +  File.separator + "image_sach";
								File dir = new File(dirUrl);
								if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
									dir.mkdir();
								}
							           String fileImg = dirUrl + File.separator + nameimg;
							           
							           File file = new File(fileImg);//tạo file
							            try {
							               fileItem.write(file);//lưu file
							              System.out.println("UPLOAD THÀNH CÔNG...!");
							              System.out.println("Đường dẫn lưu file là: "+dirUrl);
							 } catch (Exception e) {
							    e.printStackTrace();
							}
						}
					 }
						else//Neu la control
						{
							String tentk=fileItem.getFieldName();
							if(tentk.equals("ms"))
								 ms = fileItem.getString();
							if(tentk.equals("ts"))
								 ts = fileItem.getString("UTF-8");
							if(tentk.equals("tg"))
								 tg = fileItem.getString("UTF-8");
							if(tentk.equals("g"))
								 gia = fileItem.getString();
							if(tentk.equals("sl"))
								 sl = fileItem.getString();
							if(tentk.equals("nn"))
								 date = fileItem.getString();
							if(tentk.equals("st"))
								 st = fileItem.getString();
							if(tentk.equals("ml"))
								 ml = fileItem.getString();
						}
			 			
					}
					adminsachdao sd = new adminsachdao();
					if(edit!=null ){
						//Chỉnh sửa sách
						System.out.println("sửa sách");
							//Xóa ảnh của sách cũ trước
						String dirUrl = request.getServletContext().getRealPath("") +  File.separator + old_img;
						File dir = new File(dirUrl);
						dir.delete();
					}
					else if(ms!=null && ts !=null && sl!=null && gia!=null) {
						// Thêm sách
						System.out.println("Thêm sách");
		 				sd.addsach(ms, ts, tg,Integer.parseInt(sl), Integer.parseInt(gia), ml, st, date, "image_sach/"+name);
		 				response.sendRedirect("sachadminController2?dss=1");
		 			}
		 			else {
		 				response.sendRedirect("sachadminController2?add=1");
		 			}
			
	 			
	 			
	 			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
