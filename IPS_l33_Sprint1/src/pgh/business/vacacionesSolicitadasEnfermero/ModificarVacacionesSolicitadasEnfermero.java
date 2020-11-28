package pgh.business.vacacionesSolicitadasEnfermero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.business.jornadamedico.JornadaMedicoDTO;
import pgh.jdbc.Database;

public class ModificarVacacionesSolicitadasEnfermero {

private static String SQL = "UPDATE VACACIONES_ENFERMERO_SOLICITADAS SET esperando = ? , aprobadas=? , canceladas=? WHERE IDVACACIONES_SOLICITADAS_ENFERMERO = ? ";
Database db = new Database();
	
		
	public void modificarEstados (boolean aceptadas, boolean canceladas, boolean esperando, int idvacaciones) {
					
			Connection c = null;
			PreparedStatement pst = null;
			
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				
				pst.setBoolean(1, esperando);
				pst.setBoolean(2, aceptadas);
				pst.setBoolean(3, canceladas);
				pst.setInt(4, idvacaciones);
				
				
				int retorno =pst.executeUpdate();
				System.out.println("actualizadas");
			
			
				c.close();
				pst.close();
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
		}
	
		
	}

