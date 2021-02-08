package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;


import utils.JDBCUtils;
import domain.User;
public class RegisterDao {
	private PreparedStatement pst = null;
	private Statement st = null;
	private Connection conn = null;
	private String sql = "";
	public String insertUser(User user) throws Exception {
		conn = JDBCUtils.getInstance().getConnection();
		sql = "insert into user(username,password,sex,address,hobby,path,email,phone,others,id)values(?,?,?,?,?,?,?,?,?,null)";
		pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		pst.setString(1,user.getUsername());
		pst.setString(2,user.getPassword());
		pst.setString(3,user.getSex());
		pst.setString(4,user.getAddress());
		pst.setString(5, user.getHobby());
		pst.setString(6, user.getPath());
		pst.setString(7, user.getEmail());
		pst.setString(8, user.getPhone());
		pst.setString(9, user.getOthers());
		pst.execute();
		ResultSet generatedKeys = pst.getGeneratedKeys();
		String colId = "0" ;
		while(generatedKeys.next()){

			colId = generatedKeys.getString(1);
			JDBCUtils.getInstance().closeResource(null, conn, pst);
		}

		return colId;
	}
	public void updateUser(String  id) throws Exception {
		conn = JDBCUtils.getInstance().getConnection();
		sql = "update   user set flag=1 where id = "+id;
		pst = conn.prepareStatement(sql);
		pst.executeUpdate();
		JDBCUtils.getInstance().closeResource(null, conn, pst);

	}

}
