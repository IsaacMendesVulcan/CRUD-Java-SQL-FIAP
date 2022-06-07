package br.com.fiap.htjaccessdb.DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.htjaccessdb.factory.ConnectionFactory;
import br.com.fiap.htjaccessdb.models.User_Physical_Activity;

public class User_Physical_ActivityDAO {
	
	public void save(User_Physical_Activity pa) {
		//( TOTAL_TIME_MIN, TOTAL_KCALS, ACTIVITY, CREATED_AT)
		String sql = "INSERT INTO USER_PHYSICAL_ACTIVITY  VALUES (ID_USER_PHYSICAL_ACTIVITY.NEXTVAL,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnection();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			
			pstm.setInt(1, pa.getTotalTimeMin());
			pstm.setFloat(2, pa.getTotalKcals());
			pstm.setString(3, pa.getActivity());
			pstm.setDate(4, new Date(pa.getCreatedAt().getTime()));
			
			pstm.execute();
			
			System.out.println("Saved successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if (pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			}
		
		
			
	
			
		
		
	}

	public List<User_Physical_Activity> getAll(){
		
		String sql = "SELECT * FROM USER_PHYSICAL_ACTIVITY";
		
		List<User_Physical_Activity> upad = new ArrayList<User_Physical_Activity>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnection();
			
			
			//pstm = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			
			while (rset.next()) {
				User_Physical_Activity upae = new User_Physical_Activity();
				
				upae.setTotalTimeMin(rset.getInt("TOTAL_TIME_MIN"));
				upae.setTotalKcals(rset.getFloat("TOTAL_KCALS"));
				upae.setActivity(rset.getString("ACTIVITY"));
				upae.setCreatedAt(rset.getDate("CREATED_AT"));
				
				upad.add(upae);
				
				}
				
			}catch (Exception e) {
				e.printStackTrace();
				}finally {
					try {
						if(rset!=null) {
							rset.close();
						}
				
						if(pstm!=null) {
							pstm.close();
						}
				
						if(conn!=null) {
							conn.close();
						}
				
					}catch (Exception e) {
						e.printStackTrace();
					}
			
				}
		
			return upad;
		
	}
}
