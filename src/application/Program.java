package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		//Buscando dados no banco com Statement e ResultSet:
		
		Connection conn = null;
		Statement st = null; // Inserir o comando
		ResultSet rs = null; // Retorno em forma de tabela
		try {
			conn = DB.getConnection();
			
			st = conn.createStatement();
			
			rs = st.executeQuery("select * from department");
			
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
				
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.CloseConnection();
		}
	}

}
