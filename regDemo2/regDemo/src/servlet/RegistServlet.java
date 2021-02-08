package servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.RegisterDao;
import domain.User;
import utils.EmailUitl;
import utils.UploadUtils;

/**
 * 用户注册的Servlet
 */
@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private RegisterDao registerDao;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			Map<String,String> map = new HashMap<String,String>();
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			// 3.解析request请求，返回的是List集合，List集合中存放的是FileItem对象
			List<FileItem> list = null;
			registerDao = new RegisterDao();
			try {
				list = servletFileUpload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<String> hobbyList = new ArrayList<String>();
			// 4.遍历集合，获得每个FileItem，判断是表单项还是文件上传项
			String url = null;
			for (FileItem fileItem : list) {
				if(fileItem.isFormField()){
					String name = fileItem.getFieldName(); 
					String value = fileItem.getString("UTF-8");//
					System.out.println(name+"    "+value);
					if("hobby".equals(name)){
						String hobbyValue = fileItem.getString("UTF-8");
						hobbyList.add(hobbyValue);
						hobbyValue = hobbyList.toString().substring(1, hobbyList.toString().length()-1); // xxx,yyy
		//				System.out.println(name+"     "+hobbyValue);
						map.put(name, hobbyValue);
					}else{
						map.put(name, value);
					}
				}else{
					String fileName = fileItem.getName();
					if(fileName !=null && !"".equals(fileName)){
						map.put("path", fileName);
					}
				
				}
			}

			User user = new User();
			user.setUsername(map.get("username"));
			user.setAddress(map.get("city") + map.get("district"));
			user.setHobby(map.get("hobby"));
			user.setOthers(map.get("others"));
			user.setEmail(map.get("email"));
			user.setPath(map.get("path"));
			user.setPassword(map.get("password"));
			user.setPhone(map.get("phone"));
			user.setSex(map.get("sex"));

			try {
				String id = registerDao.insertUser(user);
				String str = "click here\r\n" +
						"			http://localhost:8080/regDemo/check?id="+id+" \r\n" +
						"			active your account! ";
				EmailUitl.sendMail(map.get("email"), str);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
