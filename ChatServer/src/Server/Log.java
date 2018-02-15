package Server;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class Log {

	public Log(String description) {
		
		try {
			PreparedStatement pstm=new DB().getCon().prepareStatement("INSERT INTO log (time,description) VALUES(?,?)");
			pstm.setString(1,Calendar.getInstance().getTime().toString());
			pstm.setString(2,description);
			pstm.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
