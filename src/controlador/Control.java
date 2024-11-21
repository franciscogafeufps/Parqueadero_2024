
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Vehiculo;
import servicios.Conexion;

public class Control {
    
    public static void guardar(Vehiculo v){
      try{
         Connection conexion = Conexion.obtener();
         PreparedStatement consulta;
         consulta = conexion.prepareStatement("INSERT INTO registro (placa, modelo, tipo, valor) "
                 + "VALUES(?, ?, ?, ?)");        
         consulta.setString(1, v.getPlaca());
         consulta.setInt(2, v.getModelo());
         
         consulta.setInt(3, v.getTipo());
         consulta.setInt(4, v.getValor());
         consulta.executeUpdate();
      }catch(SQLException ex){
            
      } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static Boolean existePlaca(String placa){
      try{
         Connection conexion = Conexion.obtener();
         PreparedStatement consulta;
         consulta = conexion.prepareStatement("SELECT * FROM registro WHERE placa = ?");        
         consulta.setString(1, placa);
         
         ResultSet rs = consulta.executeQuery();
         if(rs.next()){
             return true;
         }
         return false;
      }catch(SQLException ex){
            
      } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public static String totalizar(){
      try{
         Connection conexion = Conexion.obtener();
         PreparedStatement consulta;
         consulta = conexion.prepareStatement("select " + "sum(valor) as total, count(placa) as cantidad, tipo " + "from ingreso group by tipo");        
         
         ResultSet rs = consulta.executeQuery();
         
         String total = "";
         if(rs.next()){
             total = total + "El total de carros es " + rs.getInt("cantidad") + " con un valor de " + rs.getInt("valor") + "";

         }
         
         if(rs.next()){
             total = total + ", el total de motos es " + rs.getInt("cantidad") + " con un valor de " + rs.getInt("valor") + "";

         }
         return total;
      }catch(SQLException ex){
            
      } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
      return "Error al totalizar";
    }
    
    public static void eliminar(){
      try{
         Connection conexion = Conexion.obtener();
         PreparedStatement consulta;
         consulta = conexion.prepareStatement("DELETE FROM registro");        
         consulta.executeUpdate();
      }catch(SQLException ex){
            
      } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
}
