
import java.awt.Color;
import java.awt.Component;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;

public class Calendario extends javax.swing.JFrame {
    
    private final String[] MONTHS = {"Enero","Febrero","Marzo","Abril",
                                  "Mayo","Junio","Julio","Agosto","Septiembre","Octubre",
                                  "Noviembre","Diciembre"};
    private  CalendarPage calenderPage;
    private  SemanaPage semanaPage;
    private DiaPage diaPage;
    //private  DiaPage diaPage; 
    private Calendar  calDate;
    GregorianCalendar greCal;
    private DefaultComboBoxModel<String> yearboxModel;
   
    public Calendario() {
        
        //if(diaJDateChooser.getDate()==null) System.out.println("hola toy chikito");
        //DateFormat f=new SimpleDateFormat("yyyy-MM-d");
        //String dia = f.format(diaJDateChooser.getDate());
        
        //System.out.println("asi inicia el dia: "+dia);
 
        /*try {
            evento.setFecha_inicio(new SimpleDateFormat("yyyy-MM-d").parse(fecha_inicioS));
            evento.setFecha_fin(new SimpleDateFormat("yyyy-MM-d").parse(fecha_finS));
            
        } catch (ParseException ex) {
            Logger.getLogger(EventoWindow.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        calDate = Calendar.getInstance(); 
        initComponents(); 
        displayCalendar(0);
        calenderPage.printDate(dateView);     
        //calenderPage.printTime(clockView); 
        this.setVisible(true);
    }
    
    private void initComboYear(){
     
        int x  =  Integer.valueOf(yearboxModel.getSelectedItem().toString());
        yearboxModel.removeAllElements();
        for(int i= x; i >= 1900; --i ){
            yearboxModel.addElement(String.valueOf(i));
        }
    }
         
    private void displayCalendar(int month){
        
        calDate.add(Calendar.MONTH, month);
        int y = calDate.get(Calendar.YEAR);
        int m = calDate.get(Calendar.MONTH);    
        calenderPage =  new CalendarPage(y ,m,topDAte,calendarView);
        
        if(calendarView.getComponents().length > 0){
            Component com  = calendarView.getComponent(0);
            if(com instanceof  JPanel){
                calendarView.remove(0);
                calendarView.add(calenderPage,0);
                calendarView.revalidate();
            }
        }
        else calendarView.add(calenderPage);
    }
    
    private void displaySemana(int month){
        //calendarView.removeAll();
        
        calDate.add(Calendar.MONTH, month);
        int y = calDate.get(Calendar.YEAR);
        int m = calDate.get(Calendar.MONTH);    
        semanaPage =  new SemanaPage(y ,m,topDAte,calendarView);
        if(calendarView.getComponents().length > 0){
            Component com  = calendarView.getComponent(0);
            if(com instanceof  JPanel){
                calendarView.remove(0);
                calendarView.add(semanaPage,0);
                calendarView.revalidate();
            }
        }
        else calendarView.add(semanaPage);
    }
    
    private void displayDia(int mes, int dia, int year, int dia_semana){
        System.out.println("hola");
        calDate.add(Calendar.MONTH, mes);
        int y = calDate.get(Calendar.YEAR);
        int m = calDate.get(Calendar.MONTH); 
        diaPage =  new DiaPage(year ,mes, dia,dia_semana, topDAte,calendarView);
        if(calendarView.getComponents().length > 0){
            Component com  = calendarView.getComponent(0);
            if(com instanceof  JPanel){
                calendarView.remove(0);
                calendarView.add(diaPage,0);
                calendarView.revalidate();
            }
        }
        else calendarView.add(diaPage);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        dateView = new javax.swing.JPanel();
        calendarView = new javax.swing.JPanel();
        vistaBox = new javax.swing.JComboBox<>();
        modificarEvento_button = new javax.swing.JButton();
        eliminarEvento_button = new javax.swing.JButton();
        creaEvento_button = new javax.swing.JButton();
        topDAte = new javax.swing.JLabel();
        vistaJL = new javax.swing.JLabel();
        nameJL = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1180, 700));
        setPreferredSize(new java.awt.Dimension(1180, 730));
        getContentPane().setLayout(null);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arrows-Left-Round-icon.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(220, 80, 30, 29);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arrows-Right-Round-icon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1110, 80, 30, 29);

        dateView.setBackground(new java.awt.Color(234, 225, 200));
        dateView.setFont(new java.awt.Font("Dosis ExtraBold", 0, 14)); // NOI18N
        getContentPane().add(dateView);
        dateView.setBounds(570, 10, 580, 50);

        calendarView.setBackground(new java.awt.Color(234, 225, 200));
        getContentPane().add(calendarView);
        calendarView.setBounds(220, 120, 920, 440);

        vistaBox.setFont(new java.awt.Font("Dosis ExtraBold", 0, 12)); // NOI18N
        vistaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes", "Semana", "Dia" }));
        vistaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vistaBoxActionPerformed(evt);
            }
        });
        getContentPane().add(vistaBox);
        vistaBox.setBounds(80, 390, 67, 22);

        modificarEvento_button.setBackground(new java.awt.Color(234, 225, 200));
        modificarEvento_button.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        modificarEvento_button.setText("Modificar Evento");
        modificarEvento_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarEvento_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(modificarEvento_button);
        modificarEvento_button.setBounds(30, 280, 160, 33);

        eliminarEvento_button.setBackground(new java.awt.Color(234, 225, 200));
        eliminarEvento_button.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        eliminarEvento_button.setText("Eliminar Evento");
        eliminarEvento_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEvento_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarEvento_button);
        eliminarEvento_button.setBounds(30, 220, 160, 33);

        creaEvento_button.setBackground(new java.awt.Color(234, 225, 200));
        creaEvento_button.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        creaEvento_button.setText("Crear Evento");
        creaEvento_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creaEvento_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(creaEvento_button);
        creaEvento_button.setBounds(30, 150, 160, 33);

        topDAte.setFont(new java.awt.Font("Dosis ExtraBold", 0, 24)); // NOI18N
        topDAte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topDAte.setText("jLabel1");
        getContentPane().add(topDAte);
        topDAte.setBounds(220, 80, 920, 30);

        vistaJL.setFont(new java.awt.Font("Dosis ExtraBold", 1, 24)); // NOI18N
        vistaJL.setText("Modo vista:");
        getContentPane().add(vistaJL);
        vistaJL.setBounds(50, 320, 130, 71);

        nameJL.setFont(new java.awt.Font("Dosis ExtraBold", 1, 36)); // NOI18N
        nameJL.setText("ColorFULL Calendar");
        getContentPane().add(nameJL);
        nameJL.setBounds(20, 0, 370, 71);

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg1.png"))); // NOI18N
        fondo.setMinimumSize(new java.awt.Dimension(0, 0));
        fondo.setPreferredSize(new java.awt.Dimension(1180, 750));
        fondo.setRequestFocusEnabled(false);
        getContentPane().add(fondo);
        fondo.setBounds(0, -30, 1180, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void creaEvento_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creaEvento_buttonActionPerformed

	EventoWindow nuevo_evento = new EventoWindow();
        nuevo_evento.show();  
        displayCalendar(0);
        //dispose();
    }//GEN-LAST:event_creaEvento_buttonActionPerformed

    private void eliminarEvento_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEvento_buttonActionPerformed
        BorrarEventoWindow borrar_evento = new BorrarEventoWindow();
        borrar_evento.show();  
        displayCalendar(0);
    }//GEN-LAST:event_eliminarEvento_buttonActionPerformed

    private void modificarEvento_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarEvento_buttonActionPerformed
        ModificarEventoWindow1 modificar_evento = new ModificarEventoWindow1();
        modificar_evento.show();  
        displayCalendar(0);
    }//GEN-LAST:event_modificarEvento_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         String opt = (String)vistaBox.getSelectedItem();
         if (opt=="Mes"){
             displayCalendar(1);
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String opt = (String)vistaBox.getSelectedItem();
        System.out.println("esto es el opt: "+opt+'\n');
         if (opt=="Mes"){
             displayCalendar(-1);
         }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void vistaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vistaBoxActionPerformed
        String opt = (String)vistaBox.getSelectedItem();
        System.out.println("esto es el opt: "+opt+'\n');
        if (opt=="Mes"){
             displayCalendar(0);
        }
        else if (opt=="Semana"){
             displaySemana(0);
        }
        else if (opt=="Dia"){

            com.toedter.calendar.JDateChooser jd = new com.toedter.calendar.JDateChooser();
            String message ="Elegir fecha:\n";
            Object[] params = {message,jd};
            JOptionPane.showConfirmDialog(null,params,"Elegir fecha a buscar", JOptionPane.PLAIN_MESSAGE);
            
            Date date = jd.getDate();
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(date);
            
            DateFormat yearD=new SimpleDateFormat("yyyy");
            int year = Integer.parseInt(yearD.format(((com.toedter.calendar.JDateChooser)params[1]).getDate()));
  
            DateFormat monthD=new SimpleDateFormat("MM");
            int month = Integer.parseInt(monthD.format(((com.toedter.calendar.JDateChooser)params[1]).getDate()));

            DateFormat dayD=new SimpleDateFormat("d");
            int day = Integer.parseInt(dayD.format(((com.toedter.calendar.JDateChooser)params[1]).getDate()));
            
            int dia_semana = calendario.get(Calendar.DAY_OF_WEEK);         
            displayDia(month,day,year,dia_semana);
        }
    }//GEN-LAST:event_vistaBoxActionPerformed
 
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calendario().setVisible(true);
            }
        });
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel calendarView;
    private javax.swing.JButton creaEvento_button;
    private javax.swing.JPanel dateView;
    private javax.swing.JButton eliminarEvento_button;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton modificarEvento_button;
    private javax.swing.JLabel nameJL;
    private javax.swing.JLabel topDAte;
    private javax.swing.JComboBox<String> vistaBox;
    private javax.swing.JLabel vistaJL;
    // End of variables declaration//GEN-END:variables
}


