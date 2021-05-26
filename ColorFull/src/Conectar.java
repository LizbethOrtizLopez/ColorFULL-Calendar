
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
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
    
    public void Guardar(Conectar cc, Evento evento, int dias) {
        
        Connection cn = cc.conexion();        
        String sql="";
        
        Evento eventos[];
        eventos= new Evento[1];
        eventos[0] = evento;

        int secuencia = 1;
        
        switch (evento.getOcurrencia()){
            case "No repetir":
                secuencia = 1;
                eventos= new Evento[secuencia];
                eventos[0] = evento;
                break;
            case "Diariamente":
                
                secuencia = dias+1;
                eventos= new Evento[secuencia];
                eventos[0] = evento;
                for (int i=1;i<secuencia;i++){ 
                    eventos[i] = new Evento(); 

                    Date dia_auxiliar = eventos[i-1].getFecha_inicio();  
                    Calendar c = Calendar.getInstance();
                    c.setTime(dia_auxiliar);
                    c.add(Calendar.DATE, 1);
                    dia_auxiliar = c.getTime();  
                    
                    eventos[i].setTitulo(evento.getTitulo());
                    eventos[i].setDescripcion(evento.getDescripcion());
                    eventos[i].setFecha_fin(evento.getFecha_fin());
                    eventos[i].setHora_inicio(evento.getHora_inicio());
                    eventos[i].setMin_inicio(evento.getMin_inicio());
                    eventos[i].setHora_fin(evento.getHora_fin());
                    eventos[i].setMin_fin(evento.getMin_fin());
                    eventos[i].setColor(evento.getColor());
                    eventos[i].setAmpm_fin(evento.getAmpm_fin());
                    eventos[i].setAmpm_inicio(evento.getAmpm_inicio());
                    eventos[i].setOcurrencia(evento.getOcurrencia());
                    eventos[i].setFecha_inicio(dia_auxiliar); 
                }
                break;
                
            case "Semanalmente":
                
                secuencia = Math.round(dias / 7)+1;
                eventos= new Evento[secuencia];
                eventos[0] = evento;

                for (int i=1;i<secuencia;i++){
                    eventos[i] = new Evento(); 

                    Date dia_auxiliar = eventos[i-1].getFecha_inicio();  
                    Calendar c = Calendar.getInstance();
                    c.setTime(dia_auxiliar);
                    c.add(Calendar.DATE, 7);
                    dia_auxiliar = c.getTime();  
                    
                    eventos[i].setTitulo(evento.getTitulo());
                    eventos[i].setDescripcion(evento.getDescripcion());
                    eventos[i].setFecha_fin(evento.getFecha_fin());
                    eventos[i].setHora_inicio(evento.getHora_inicio());
                    eventos[i].setMin_inicio(evento.getMin_inicio());
                    eventos[i].setHora_fin(evento.getHora_fin());
                    eventos[i].setMin_fin(evento.getMin_fin());
                    eventos[i].setColor(evento.getColor());
                    eventos[i].setAmpm_fin(evento.getAmpm_fin());
                    eventos[i].setAmpm_inicio(evento.getAmpm_inicio());
                    eventos[i].setOcurrencia(evento.getOcurrencia());
                    eventos[i].setFecha_inicio(dia_auxiliar);  
                }
                break;
                
            case "Mensualmente":
                secuencia = Math.round(dias / 30)+1;
                eventos= new Evento[secuencia];
                eventos[0] = evento;
                
                for (int i=1;i<secuencia;i++){
                    eventos[i] = new Evento(); 

                    Date dia_auxiliar = eventos[i-1].getFecha_inicio();  
                    Calendar c = Calendar.getInstance();
                    c.setTime(dia_auxiliar);
                    c.add(Calendar.MONTH, 1);
                    dia_auxiliar = c.getTime();  
                    
                    eventos[i].setTitulo(evento.getTitulo());
                    eventos[i].setDescripcion(evento.getDescripcion());
                    eventos[i].setFecha_fin(evento.getFecha_fin());
                    eventos[i].setHora_inicio(evento.getHora_inicio());
                    eventos[i].setMin_inicio(evento.getMin_inicio());
                    eventos[i].setHora_fin(evento.getHora_fin());
                    eventos[i].setMin_fin(evento.getMin_fin());
                    eventos[i].setColor(evento.getColor());
                    eventos[i].setAmpm_fin(evento.getAmpm_fin());
                    eventos[i].setAmpm_inicio(evento.getAmpm_inicio());
                    eventos[i].setOcurrencia(evento.getOcurrencia());
                    eventos[i].setFecha_inicio(dia_auxiliar); 
                }
                break;

            case "Anualmente":
                
                secuencia = Math.round(dias / 365)+1;
                eventos= new Evento[secuencia];
                eventos[0] = evento;
                for (int i=1;i<secuencia;i++){
                    eventos[i] = new Evento(); 

                    Date dia_auxiliar = eventos[i-1].getFecha_inicio();  
                    Calendar c = Calendar.getInstance();
                    c.setTime(dia_auxiliar);
                    c.add(Calendar.YEAR, 1);
                    dia_auxiliar = c.getTime();  
                    
                    eventos[i].setTitulo(evento.getTitulo());
                    eventos[i].setDescripcion(evento.getDescripcion());
                    eventos[i].setFecha_fin(evento.getFecha_fin());
                    eventos[i].setHora_inicio(evento.getHora_inicio());
                    eventos[i].setMin_inicio(evento.getMin_inicio());
                    eventos[i].setHora_fin(evento.getHora_fin());
                    eventos[i].setMin_fin(evento.getMin_fin());
                    eventos[i].setColor(evento.getColor());
                    eventos[i].setAmpm_fin(evento.getAmpm_fin());
                    eventos[i].setAmpm_inicio(evento.getAmpm_inicio());
                    eventos[i].setOcurrencia(evento.getOcurrencia());
                    eventos[i].setFecha_inicio(dia_auxiliar); 
                }
                break;      
        }
        for (int i=0;i<secuencia;i++)
        {
            sql="INSERT INTO eventos (fecha_inicio,fecha_fin,hora_inicio,min_inicio,ampm_inicio,hora_fin,min_fin,ampm_fin,titulo,descripcion,color_evento,ocurrencia) VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ;";
            try {
                PreparedStatement pst = cn.prepareStatement(sql);

                pst.setDate(1, (new java.sql.Date(eventos[i].getFecha_inicio().getTime())));
                pst.setDate(2, (new java.sql.Date(eventos[i].getFecha_fin().getTime())));
                pst.setInt(3, eventos[i].getHora_inicio());
                pst.setInt(4, eventos[i].getMin_inicio());
                pst.setString(5, eventos[i].getAmpm_inicio());
                pst.setInt(6, eventos[i].getHora_fin());
                pst.setInt(7, eventos[i].getMin_fin());
                pst.setString(8, eventos[i].getAmpm_fin());
                pst.setString(9, eventos[i].getTitulo());
                pst.setString(10, eventos[i].getDescripcion());
                
                String color_evento = String.valueOf(eventos[i].getColor().getRGB());
                pst.setString(11, color_evento);
                
                pst.setString(12, eventos[i].getOcurrencia());

                int auxi = pst.executeUpdate();
                if (auxi>0) {
                    System.out.println("Evento creado con éxito");
                }
            } catch (SQLException ex) {
                Logger.getLogger(EventoWindow.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Uno o más campos están vacíos. Revisa de nuevo");
            }   
        }
        JOptionPane.showMessageDialog(null,"Evento creado con éxito");
    }
    
    public void modificar(Conectar cc, Evento evento, int idEvento){
        
        Connection cn = cc.conexion();       
        String color_evento = String.valueOf(evento.getColor().getRGB());
        String sql="";
        
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
    
    public void eliminarByTitulo(Conectar cc, String evento){
        
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
    
    public void elimininarByFecha(Conectar cc, String evento, String fecha){
        
        Connection cn = cc.conexion();
        String sql="";
        
        sql="DELETE FROM eventos WHERE titulo=? AND fecha_inicio=?;";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, evento);
            pst.setString(2,fecha);
            
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
}