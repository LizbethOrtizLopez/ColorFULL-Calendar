
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JOptionPane;

/**
 *
 * @author HASSAN MUGABO, AT CYBAROX ICT TRAINING CENTER
 * 
 */

public class DiaPage extends  JPanel{
    
    private final int month;
    private int year;
    private int day;
    private int dia_semana;
    private String fecha;
    
    private ArrayList fechas;
    
    private GregorianCalendar calendar;

    private JLabel dateview;
    Font  digitalClock  =null;

    public DiaPage(int y ,int m, int d, int diaSem, String f, JLabel dateview,Container parrent) throws  IllegalArgumentException{
        checkParameters(y, m, dateview, parrent);
  
        month =m;
        year = y;
        day = d;
        dia_semana = diaSem;
        fecha=f;
        
        if(consultar()==0){
            JOptionPane.showMessageDialog(null,"No tienes eventos en este día");
        }
        else{
            this.dateview =dateview;
            loadDigitalFont();
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBackground(Color.WHITE);
            setFont(parrent.getFont());
            
            JPanel  headderPAne  =  new JPanel();
            BevelBorder  bb =new BevelBorder(BevelBorder.RAISED, Color.lightGray, Color.DARK_GRAY);
            EmptyBorder eb =  new EmptyBorder(20, 20, 20, 20);
            setBorder(new CompoundBorder(bb, eb));
            headderPAne.setBackground(Color.WHITE);
            
            String[] weekDays  ={"Dom","Lun","Mar","Miér","Jue","Vi","Sa"}; 

            JLabel  dayName  =  new JLabel(weekDays[dia_semana-1],JLabel.CENTER);
            if(weekDays[dia_semana-1] =="Dom"){
                dayName.setForeground(Color.red);
            }
            dayName.setFont(getFont());
            headderPAne.add(dayName);
            
            JSeparator separator =  new JSeparator(JSeparator.HORIZONTAL);
        
            headderPAne.add(separator);
            separator.setBorder(new LineBorder(Color.BLUE, 10));

            JPanel page  =  printPage();
            page.setOpaque(false);    
            add(headderPAne); 
            add(separator); 
            add(Box.createHorizontalStrut(867));
            add(page); 
        }
    }
    
    private int consultar(){    
       Conectar cc = new Conectar();         
       fechas = cc.Consultar(cc, this.fecha);    
       if (fechas.size()==0){  
           return 0;
       } 
       return 1;
    }
  
  private void checkParameters(int y ,int m,JLabel dateview,Container parrent)
          throws  IllegalArgumentException{
   
         if(
           //year must be > 0 and month index must be between 0 & 11 enclusively for 12 months.
           y < 1 || (m < 0 || m > 11) ||
           //A dateview must exist before dispalying a date 
            dateview ==null ||
            //and must be a JLabel.   
            (dateview instanceof JLabel == false)
            //A hosting Container  must exist before dispalying this calendar page     
            || parrent == null ||
            
             //and must be an instance of JPanel.
             (parrent instanceof JPanel == false)
                ){//throw an exception if one of these conditions is true.
            throw new IllegalArgumentException("Illegal Arguments,"
                    + " please check the parameters correctly.");
        }//end if for test.

    }  
    
    private  JPanel   printPage(){

        final   JPanel  page  =  new JPanel();
        page.setOpaque(false);
        int leadGap = 0;
        GregorianCalendar    cal  =  new GregorianCalendar(year,month,1);
        leadGap =  cal.get(Calendar.DAY_OF_WEEK)-1;
        LineBorder  bb =new LineBorder(Color.LIGHT_GRAY);
        EmptyBorder eb =  new EmptyBorder(10, 10, 10, 10);
        LineBorder bbred= new LineBorder(Color.RED);
        LineBorder bbblue= new LineBorder(Color.BLUE);

        page.setLayout(new GridLayout(1, 1, 1, 5));
        if(leadGap == 0)leadGap = 7;

        Calendar  c  =  Calendar.getInstance();
        int today  =  c.get(Calendar.DAY_OF_MONTH);
        int yr  =  c.get(Calendar.YEAR);
        int mt  =  c.get(Calendar.MONTH);
            
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(26,1,1,0));
        panel.setOpaque(false);
            
        boolean bandera = false;

        Conectar cc=new Conectar(); 
        Connection cn = cc.conexion();           
        Statement st;
        ResultSet rs;

        try {
            st=cn.createStatement();
            rs=st.executeQuery("SELECT * FROM eventos WHERE fecha_inicio='"+this.fecha+"';");
            while (rs.next()) {  
                bandera = true;
                JLabel x = new JLabel();
                x.setText(rs.getString("titulo"));
                x.setFont(getFont());
                Color colorcito = new Color(Integer.parseInt(rs.getString("color_evento")),true);
                x.setOpaque(true);
                x.setBackground(colorcito);
                panel.add(x);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
            
                        
        JLabel  l = new JLabel(String.valueOf(day));
        l.setBackground(rgb(176,190,197));
        l.setFont(getFont());
        l.setVerticalTextPosition(JLabel.TOP);

            
        if (bandera){
            panel.setBorder(bb);
            panel.add(l);
            page.add(panel);
        }
        else{
            l.setBorder(bb);
            page.add(l);
        }
           
        if(day == today && yr == year && mt == month){
            if(bandera){ 
                panel.setOpaque(false);
                panel.setBorder(bbred);
                panel.setForeground(Color.red);
            }
            else {
                l.setOpaque(false);   
                l.setForeground(Color.red);  
                l.setBorder(bbred);
             }
        }else if(day ==1){
            if(bandera){ 
                panel.setOpaque(false);
                panel.setBorder(bbblue);
                panel.setForeground(Color.blue);
            }
            else{
                l.setOpaque(false); 
                l.setBorder(bbblue);
                l.setForeground(Color.blue);                
            } 
        }
       return page;
    }
   
    private void loadDigitalFont(){

         GraphicsEnvironment   ge  =  GraphicsEnvironment.getLocalGraphicsEnvironment();

            try {       
               digitalClock  = Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream(
                      "digitalx-7.ttf")).deriveFont(((float)44)); 
               ge.registerFont(digitalClock);

            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (FontFormatException ex) {
                ex.printStackTrace();
            }
     }   
  
    public   Color rgb(int r,int g, int b){
        return new Color(r,g,b);
    } 
}
    