package br.com.fiap.htjaccessdb.app;





import java.sql.Date;

import br.com.fiap.htjaccessdb.DAO.User_Physical_ActivityDAO;
import br.com.fiap.htjaccessdb.models.User_Physical_Activity;

public class Main {
	
	public static void main(String[] args) {
		
		User_Physical_ActivityDAO paDao = new User_Physical_ActivityDAO();
		
		
		//------INSERT DB------
		User_Physical_Activity pa = new User_Physical_Activity();
		
		pa.setTotalTimeMin(72);
		pa.setTotalKcals(909);
		pa.setActivity("TAE KWON DO");
		pa.setCreatedAt(new Date(0));
		
		paDao.save(pa);
		
		//------CONSULT DB------
		for (User_Physical_Activity u : paDao.getAll()) {
			System.out.println(u);
		}
	}

}
