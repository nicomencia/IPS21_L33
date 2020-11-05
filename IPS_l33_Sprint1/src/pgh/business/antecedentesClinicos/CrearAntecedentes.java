package pgh.business.antecedentesClinicos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pgh.business.prescripcion.Prescripcion;
import pgh.jdbc.Database;

public class CrearAntecedentes {
		
		private static String SQL = "Insert into AntecedentesClinicos (idAntecedentesClinicos, descripcion, hora_Asignacion, dia_Asignacion) values (?,?,?,?) ";
		Database db = new Database();
			
			public void crearPrescripcion(Antecedentes antecedentes) {
				
				Connection c = null;
				ResultSet rs = null;
				PreparedStatement pst = null;
				StringBuilder query=new StringBuilder();
				query.append(SQL);
				
				try {
					
					c = db.getConnection();

					
					java.sql.Date sqlDate = new java.sql.Date(antecedentes.getDiaAsignacion().getTime());
				
				  pst = c.prepareStatement(query.toString());
					pst.setInt(1, antecedentes.getIdAntecedentes());
					pst.setString(2,antecedentes.getDescripcion());
					pst.setString(3, antecedentes.getHoraAsignacion());
					pst.setDate(4,sqlDate);
		     
					
				  pst.executeUpdate();	
				    
				  pst.close();
				  c.close();
				    
				  System.out.print("Antecedentes creados con exito");
				  

					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}


}
