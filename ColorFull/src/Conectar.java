
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Conectar {
    Connection con;
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eventosbd","root","root");
        } catch (Exception e) {
            System.err.println("Error:" +e);
        }
        return con;
    }
    
    public void Guardar(Conectar cc, Evento evento){
        
        Connection cn = cc.conexion();       
        String color_evento = String.valueOf(evento.getColor().getRGB());
        String sql="";
        
        sql="INSERT INTO eventos (fecha_inicio,fecha_fin,hora_inicio,min_inicio,ampm_inicio,hora_fin,min_fin,ampm_fin,titulo,descripcion,color_evento,ocurrencia) VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ;";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setDate(1, (new java.sql.Date(evento.getFecha_inicio().getTime())));
            pst.setDate(2, (new java.sql.Date(evento.getFecha_fin().getTime())));
            pst.setInt(3, evento.getHora_inicio());
            pst.setInt(4, evento.getMin_inicio());
            pst.setString(5, evento.getAmpm_inicio());
            pst.setInt(6, evento.getHora_fin());
            pst.setInt(7, evento.getMin_fin());
            pst.setString(8, evento.getAmpm_fin());
            pst.setString(9, evento.getTitulo());
            pst.setString(10, evento.getDescripcion());
            pst.setString(11, color_evento);
            pst.setString(12, evento.getOcurrencia());
            
            int auxi = pst.executeUpdate();
            if (auxi>0) {
                JOptionPane.showMessageDialog(null,"Evento creado con éxito");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Uno o más campos están vacíos. Revisa de nuevo");
        }    
    }
    
    public void modificar(Conectar cc, Evento evento, int idEvento){
        
        Connection cn = cc.conexion();       
        String color_evento = String.valueOf(evento.getColor().getRGB());
        String sql="";
        
        System.out.println("holi");
        System.out.println("id en consulta: "+idEvento);
        
        sql="UPDATE eventos SET fecha_inicio=?, fecha_fin=?, hora_inicio=?, min_inicio=?, ampm_inicio=?, hora_fin=?, min_fin=?, ampm_fin=?, titulo=?, descripcion=?,color_evento=?,ocurrencia=? WHERE IdEvento=?;";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setDate(1, (new java.sql.Date(evento.getFecha_inicio().getTime())));
            pst.setDate(2, (new java.sql.Date(evento.getFecha_fin().getTime())));
            pst.setInt(3, evento.getHora_inicio());
            pst.setInt(4, evento.getMin_inicio());
            pst.setString(5, evento.getAmpm_inicio());
            pst.setInt(6, evento.getHora_fin());
            pst.setInt(7, evento.getMin_fin());
            pst.setString(8, evento.getAmpm_fin());
            pst.setString(9, evento.getTitulo());
            pst.setString(10, evento.getDescripcion());
            pst.setString(11, color_evento);
            pst.setString(12, evento.getOcurrencia());
            pst.setInt(13, idEvento);
            
            int auxi = pst.executeUpdate();
            if (auxi>0) {
                JOptionPane.showMessageDialog(null,"Evento actualizado con éxito");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Uno o más campos están vacíos. Revisa de nuevo");
        }
    }
    
    public void elimininar(Conectar cc, String evento){
        
        Connection cn = cc.conexion();
        String sql="";
        
        sql="DELETE FROM eventos WHERE titulo=?;";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, evento);
            
            int auxi = pst.executeUpdate();
            if (auxi>0) {
                JOptionPane.showMessageDialog(null,"Evento eliminado con éxito");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Existe un error con el evento");
        } 
    }
    public ArrayList Consultar(Conectar cc, String evento)
    {
        Connection cn = cc.conexion();    
        Statement st;
        ResultSet rs;
        
        ArrayList fechas = new ArrayList();

        try {
                st=cn.createStatement();
                rs=st.executeQuery("SELECT * FROM eventos WHERE fecha_inicio='"+evento+"';");
                while (rs.next()) {      
                    fechas.add(rs.getString("titulo"));
                }
                cn.close();
        } catch (Exception e) {
                System.out.println("error: "+e);
        }       
        return fechas;
    }
    public int ConsultarID(Conectar cc, String evento, String fecha)
    {
        Connection cn = cc.conexion();    
        Statement st;
        ResultSet rs;
        
        int id = 0;

        try {
                st=cn.createStatement();
                rs=st.executeQuery("SELECT * FROM eventos WHERE titulo='"+evento+"' AND fecha_inicio='"+fecha+"';");
                while (rs.next()) {      
                    id = rs.getInt("IdEvento");
                }
                cn.close();
        } catch (Exception e) {
                System.out.println("error: "+e);
        }       
        return id;
    }
    
    
    
    /*public static void main(String[] args) {

        Conectar cc=new Conectar(); 
        Connection cn = cc.conexion();
            
        Statement st;
        ResultSet rs;
               
        try {
            st=cn.createStatement();
            String fecha="2021-05-22";
            
            String sql="SELECT * FROM eventos WHERE fecha_inicio='"+fecha+"';";

            rs=st.executeQuery(sql);
            while (rs.next()) {                
                System.out.println(rs.getString("fecha_inicio"));
            }
            cn.close();
        } catch (Exception e) {
        }  
    }*/
}