
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
import java.text.SimpleDateFormat;
import java.util.Arrays;
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

/**
 *
 * @author HASSAN MUGABO, AT CYBAROX ICT TRAINING CENTER
 * 
 */

public class CalendarPage extends  JPanel{
    private final int month;
    private int year;
    private GregorianCalendar   calendar;
    private final String[] MONTHS = {"Enero","Febrero","Marzo","Abril",
                                  "Mayo","Junio","Julio","Agosto","Septiembre","Octubre",
                                  "Noviembre","Diciembre"};

    private final int[] DAYS_IN_MONTH = {
    31,28,31,30, //jan,feb,mar,apri
    31,30,31,31, //may,jun,jul,Agu
    30,31,30,31  //sep,oct,nov,dec
    };
    private JLabel dateview;
    Font  digitalClock  =null;

/**
 * 
 * @param y the current year of the date (Calendar.YEAR).
 * @param m the current month of the date (Calendar.MONTH).
 * @param dateview  A JLabel that will display month and year of a date.
 * @param parrent  A JPanel that hosts this calendar page.
 */

    public CalendarPage(int y ,int m,JLabel dateview,Container parrent) throws  IllegalArgumentException{
        checkParameters(y, m, dateview, parrent);
        
        month =m;
        year = y;
        this.dateview =dateview;
        loadDigitalFont();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        setFont(parrent.getFont());
      
        JPanel  headderPAne  =  new JPanel(new GridLayout(1, 7, 120, 5));
        BevelBorder  bb =new BevelBorder(BevelBorder.RAISED, Color.lightGray, Color.DARK_GRAY);
      
        EmptyBorder eb =  new EmptyBorder(20, 20, 20, 20);
        setBorder(new CompoundBorder(bb, eb));
        headderPAne.setBackground(Color.WHITE);
        
        String[] weekDays  ={"Dom","Lun","Mar","Mi??r","Jue","Vi","Sa"}; 
        for(int i = 0; i < weekDays.length; ++i){
            JLabel  dayName  =  new JLabel(weekDays[i],JLabel.CENTER);
            if(i ==0){
                dayName.setForeground(Color.red);
            }
            dayName.setFont(getFont());
            headderPAne.add(dayName);
        }
        JSeparator separator =  new JSeparator(JSeparator.HORIZONTAL);
        
        headderPAne.add(separator);
        separator.setBorder(new LineBorder(Color.BLUE, 3));
         
        JPanel page  =  printPage();
        page.setOpaque(false);    
        add(headderPAne); 
        add(separator); 
        add(Box.createVerticalStrut(10));
        add(page);
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
        int daysInMoth  =  this.DAYS_IN_MONTH[month];
        LineBorder  bb =new LineBorder(Color.LIGHT_GRAY);
        LineBorder bbred= new LineBorder(Color.RED);
        LineBorder bbblue= new LineBorder(Color.BLUE);
        
        EmptyBorder eb =  new EmptyBorder(30, 10, 10, 10);

        if(cal.isLeapYear(cal.get(Calendar.YEAR))  && month == 1)
            ++daysInMoth;

        printDate(dateview);
        page.setLayout(new GridLayout(6, 7, 10, 5));
        
        if(leadGap == 0)leadGap = 7;
        String before[]= previousMonth( month,  leadGap);

        for(int i = 0; i < before.length; i++){
            JLabel  l =  new JLabel(before[i]);
            l.setFont(getFont());
            l.setBorder(new CompoundBorder(bb, eb));
            l.setForeground(Color.LIGHT_GRAY);
            page.add(l); 
        }
        
        for(int i = 1; i <= daysInMoth; i++){
            
            JPanel panel=new JPanel();
            panel.setLayout(new GridLayout(3,1,1,0));
            panel.setOpaque(false);
            
            boolean bandera = false;

            Conectar cc=new Conectar(); 
            Connection cn = cc.conexion();           
            Statement st;
            ResultSet rs;

            Calendar  c  =  Calendar.getInstance();
            int today  =  c.get(Calendar.DAY_OF_MONTH);
            int yr  =  c.get(Calendar.YEAR);
            int mt  =  c.get(Calendar.MONTH);
            
            String fecha="";
            if(month<10){
                String auxi = "0"+String.valueOf(month+1);
                fecha = String.valueOf(year)+"-"+auxi+"-"+String.valueOf(i);
            }
            else{
                fecha = String.valueOf(year)+"-"+String.valueOf(month+1)+"-"+String.valueOf(i);
            }
 
            try {
                st=cn.createStatement();
                rs=st.executeQuery("SELECT * FROM eventos WHERE fecha_inicio='"+fecha+"';");
                while (rs.next()) {  
                    bandera = true;
                    JLabel x = new JLabel();
                    Color colorcito = new Color(Integer.parseInt(rs.getString("color_evento")),true);
                    x.setText(rs.getString("titulo"));
                    x.setFont(getFont());
                    x.setOpaque(true);
                    x.setBackground(colorcito);
                    panel.add(x);
                }
                cn.close();
            } catch (Exception e) {
                System.out.println("error: "+e);
            }
            
            JLabel  l = new JLabel(String.valueOf(i));    
            l.setBackground(rgb(176,190,197));
            l.setFont(getFont());
            panel.add(l);
    
            if (bandera){
                panel.setBorder(bb);
                panel.add(l);
                page.add(panel);
            }
            else{
                l.setBorder(bb);
                page.add(l);
            }
           
            if(i == today && yr == year && mt == month){
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
            }else if(i ==1){
                if(bandera){ 
                    panel.setOpaque(false);
                    panel.setBorder(bbblue);
                    panel.setForeground(Color.blue);
                }
                else {
                    l.setOpaque(false); 
                    l.setBorder(bbblue);
                    l.setForeground(Color.blue);                
                } 
            }
        }//end  for loop  
        
       JLabel  l = null;

       int gaps  =(  (7 *6)- (daysInMoth+leadGap));
       String[] after  = nextMonth(month,  gaps); 
 
       for(int v =0; v < after.length; ++v){ 
           l =  new JLabel(after[v]);
           l.setFont(getFont());
           l.setForeground(Color.LIGHT_GRAY);
           l.setBorder(bb);
           page.add(l);
        }
        return page;
    }
    
    private String[] previousMonth(int current, int leadGab){

        Calendar  c  =  Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, current);
        c.add(Calendar.MONTH, -1);

        int yr  =c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH);

        GregorianCalendar  cal  =  new 
          GregorianCalendar(yr,m,1);

        int daysInMoth  =  this.DAYS_IN_MONTH[m];

        StringBuilder  sb  =  new StringBuilder();
        if(cal.isLeapYear(cal.get(Calendar.YEAR))  && (m) == 1)
            ++daysInMoth;

        for(int i = daysInMoth; i >=1; --i){
        sb.append(i).append(" ");
        }

        String[] x  =  sb.toString().split("\\s");
        String[] part  =  Arrays.copyOfRange(x, 0, leadGab);
        part =  reverse(part);

        return part;
    }    

    private String[] nextMonth(int current, int leadGab){
        Calendar  c  =  Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, current);
        c.add(Calendar.MONTH, 1);

        int yr  =c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH);

        GregorianCalendar  cal  =  new 
          GregorianCalendar(yr,m,1);

        int daysInMoth  =  this.DAYS_IN_MONTH[m];

           StringBuilder  sb  =  new StringBuilder();
           if(cal.isLeapYear(cal.get(Calendar.YEAR))  && (m) == 1)
               ++daysInMoth;

           for(int i = 1; i <= daysInMoth; ++i){
           sb.append(i).append(" ");
           }

           String[] x  =  sb.toString().split("\\s");
           String[] part  =  Arrays.copyOfRange(x, 0, leadGab);
           return part;
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
  
    public static  String[] reverse(String[] array){
        for(int i = 0; i < (array.length - (i+1)); ++i){

            String temp  =  array[array.length - (i+1)];
            array[array.length - (i+1)] = array[i] ;
            array[i] = temp;
         }  
         return array;   
    }

    public Color rgb(int r,int g, int b){
        return new Color(r,g,b);
    } 
    
    public void printDate(JPanel dateview){
        Calendar  now  =  Calendar.getInstance();
        String[] fullDate  = {MONTHS[month],String.valueOf(now.get(Calendar.YEAR))};
        SimpleDateFormat   dateFormat =  
        new SimpleDateFormat("EEEE, MMMM dd, YYYY");
        
        JLabel  date  =  new JLabel(dateFormat.format(now.getTime()));
        date.setFont(dateview.getFont());
        dateview.add(Box.createHorizontalStrut(200));
        dateview.add(date);
        JSeparator separator =  new JSeparator(JSeparator.HORIZONTAL);
        separator.setBorder(new LineBorder(Color.LIGHT_GRAY, 4));
        dateview.add(Box.createVerticalStrut(7));
        dateview.add(separator);
    }
    
    public void printDate(JLabel dateview){
        String[] fullDate  = {MONTHS[month],String.valueOf(year)};
        dateview.setText(fullDate[0]+", "+fullDate[1]);
    }

}//end method 
