
import java.awt.Color;
import javax.swing.JColorChooser;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ModificarEventoWindow extends javax.swing.JFrame {

    private Color color; 
    private int id;
    private int dias;
    private Evento evento_modificar;
    
    public ModificarEventoWindow(Evento evento) {
        
        this.evento_modificar = new Evento();
        
        evento_modificar.setTitulo(evento.getTitulo());
        evento_modificar.setDescripcion(evento.getDescripcion());
        evento_modificar.setFecha_inicio(evento.getFecha_inicio()); 
        evento_modificar.setFecha_fin(evento.getFecha_fin());
        evento_modificar.setHora_inicio(evento.getHora_inicio());
        evento_modificar.setMin_inicio(evento.getMin_inicio());
        evento_modificar.setHora_fin(evento.getHora_fin());
        evento_modificar.setMin_fin(evento.getMin_fin());
        evento_modificar.setColor(evento.getColor());
        evento_modificar.setAmpm_fin(evento.getAmpm_fin());
        evento_modificar.setAmpm_inicio(evento.getAmpm_inicio());
        evento_modificar.setOcurrencia(evento.getOcurrencia());
        evento_modificar.setNotificaciones(evento.getNotificaciones());
        
        initComponents();
        
        
        fechaIni_jDateChooser.setDate(evento.getFecha_inicio());
        fechaFin_jDateChooser1.setDate(evento.getFecha_fin());
        hourPicker.setSelectedItem((Object)evento.getHora_inicio());
        minutePicker.setSelectedItem((Object)evento.getMin_inicio());
        AmPmPicker.setSelectedItem((Object)evento.getAmpm_inicio());
        hourPicker1.setSelectedItem((Object)evento.getHora_fin());
        minutePicker1.setSelectedItem((Object)evento.getMin_fin());
        AmPmPicker1.setSelectedItem((Object)evento.getAmpm_fin());
        titulo_TF.setText(evento.getTitulo());
        descripcion_TF.setText(evento.getDescripcion());
        //color se omite
        ocurrenciaPicker.setSelectedItem((Object)evento.getOcurrencia());
        notificacionesPicker.setSelectedItem((Object)evento.getNotificaciones());
        
        this.dias = 1;
        this.color = null;
          
        this.setVisible(true);
    }
    public void setColor(Color color) {
        this.color = color;
    }
    
    private Object[] DateChooser(){  
       com.toedter.calendar.JDateChooser jd = new com.toedter.calendar.JDateChooser();
       String message ="Elegir fecha:\n";
       Object[] params = {message,jd};
       JOptionPane.showConfirmDialog(null,params,"Elegir fecha a buscar", JOptionPane.PLAIN_MESSAGE); 
       
       return params;
    }
    
    private int diasXPasar(Date fechaIni, Date fechaFin){
        
        long comienzo = fechaIni.getTime();
        long fin = fechaFin.getTime();
        long diferencia = fin - comienzo;
        long dias_Pasar = diferencia / (1000*60*60*24);
        return (int)dias_Pasar;
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        notificacionesPicker = new javax.swing.JComboBox<>();
        notificaciones_JL = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        ocurrenciaPicker = new javax.swing.JComboBox<>();
        elegirColor = new javax.swing.JButton();
        AmPmPicker1 = new javax.swing.JComboBox<>();
        minutePicker1 = new javax.swing.JComboBox<>();
        hourPicker1 = new javax.swing.JComboBox<>();
        AmPmPicker = new javax.swing.JComboBox<>();
        minutePicker = new javax.swing.JComboBox<>();
        hourPicker = new javax.swing.JComboBox<>();
        fechaFin_jDateChooser1 = new com.toedter.calendar.JDateChooser();
        fechaIni_jDateChooser = new com.toedter.calendar.JDateChooser();
        descripcion_TF = new javax.swing.JTextField();
        titulo_TF = new javax.swing.JTextField();
        hora_inicioJL4 = new javax.swing.JLabel();
        hora_inicioJL3 = new javax.swing.JLabel();
        hora_inicioJL2 = new javax.swing.JLabel();
        hora_inicioJL1 = new javax.swing.JLabel();
        ocurrencia_JL = new javax.swing.JLabel();
        descripcion_JL = new javax.swing.JLabel();
        titulo_JL = new javax.swing.JLabel();
        hora_finJL = new javax.swing.JLabel();
        hora_inicioJL = new javax.swing.JLabel();
        fecha_finJL = new javax.swing.JLabel();
        fecha_inicioJL = new javax.swing.JLabel();
        tiempoJL = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(898, 561));
        setPreferredSize(new java.awt.Dimension(750, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        notificacionesPicker.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        notificacionesPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificacionesPickerActionPerformed(evt);
            }
        });
        getContentPane().add(notificacionesPicker);
        notificacionesPicker.setBounds(570, 250, 110, 20);

        notificaciones_JL.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        notificaciones_JL.setText("Notificaciones:");
        getContentPane().add(notificaciones_JL);
        notificaciones_JL.setBounds(430, 230, 120, 60);

        Guardar.setBackground(new java.awt.Color(234, 225, 200));
        Guardar.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(Guardar);
        Guardar.setBounds(490, 380, 130, 33);

        ocurrenciaPicker.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No repetir", "Diariamente", "Semanalmente", "Mensualmente", "Anualmente", "De lunes a viernes" }));
        ocurrenciaPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ocurrenciaPickerActionPerformed(evt);
            }
        });
        getContentPane().add(ocurrenciaPicker);
        ocurrenciaPicker.setBounds(570, 210, 110, 20);

        elegirColor.setBackground(new java.awt.Color(234, 225, 200));
        elegirColor.setFont(new java.awt.Font("Dosis ExtraBold", 0, 14)); // NOI18N
        elegirColor.setText("Elegir Color");
        elegirColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elegirColorActionPerformed(evt);
            }
        });
        getContentPane().add(elegirColor);
        elegirColor.setBounds(490, 310, 130, 40);

        AmPmPicker1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        AmPmPicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmPmPicker1ActionPerformed(evt);
            }
        });
        getContentPane().add(AmPmPicker1);
        AmPmPicker1.setBounds(300, 390, 50, 20);

        minutePicker1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "55", "55", "56", "57", "58", "59" }));
        minutePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minutePicker1ActionPerformed(evt);
            }
        });
        getContentPane().add(minutePicker1);
        minutePicker1.setBounds(200, 390, 37, 20);

        hourPicker1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        hourPicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourPicker1ActionPerformed(evt);
            }
        });
        getContentPane().add(hourPicker1);
        hourPicker1.setBounds(120, 390, 37, 20);

        AmPmPicker.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        AmPmPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmPmPickerActionPerformed(evt);
            }
        });
        getContentPane().add(AmPmPicker);
        AmPmPicker.setBounds(300, 330, 50, 20);

        minutePicker.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "55", "55", "56", "57", "58", "59" }));
        minutePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minutePickerActionPerformed(evt);
            }
        });
        getContentPane().add(minutePicker);
        minutePicker.setBounds(200, 330, 37, 20);

        hourPicker.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        hourPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourPickerActionPerformed(evt);
            }
        });
        getContentPane().add(hourPicker);
        hourPicker.setBounds(120, 330, 37, 20);
        getContentPane().add(fechaFin_jDateChooser1);
        fechaFin_jDateChooser1.setBounds(130, 270, 100, 20);
        getContentPane().add(fechaIni_jDateChooser);
        fechaIni_jDateChooser.setBounds(130, 210, 100, 20);

        descripcion_TF.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        descripcion_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        descripcion_TF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        descripcion_TF.setCaretColor(new java.awt.Color(218, 254, 254));
        descripcion_TF.setName("c00"); // NOI18N
        descripcion_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcion_TFActionPerformed(evt);
            }
        });
        getContentPane().add(descripcion_TF);
        descripcion_TF.setBounds(130, 150, 570, 30);

        titulo_TF.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        titulo_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titulo_TF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        titulo_TF.setCaretColor(new java.awt.Color(218, 254, 254));
        titulo_TF.setName("c00"); // NOI18N
        titulo_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titulo_TFActionPerformed(evt);
            }
        });
        getContentPane().add(titulo_TF);
        titulo_TF.setBounds(350, 90, 350, 30);

        hora_inicioJL4.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        hora_inicioJL4.setText("Min.");
        getContentPane().add(hora_inicioJL4);
        hora_inicioJL4.setBounds(250, 370, 40, 60);

        hora_inicioJL3.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        hora_inicioJL3.setText("Hr.");
        getContentPane().add(hora_inicioJL3);
        hora_inicioJL3.setBounds(170, 370, 30, 60);

        hora_inicioJL2.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        hora_inicioJL2.setText("Min.");
        getContentPane().add(hora_inicioJL2);
        hora_inicioJL2.setBounds(250, 310, 40, 60);

        hora_inicioJL1.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        hora_inicioJL1.setText("Hr.");
        getContentPane().add(hora_inicioJL1);
        hora_inicioJL1.setBounds(170, 310, 30, 60);

        ocurrencia_JL.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        ocurrencia_JL.setText("Ocurrencia:");
        getContentPane().add(ocurrencia_JL);
        ocurrencia_JL.setBounds(430, 190, 120, 60);

        descripcion_JL.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        descripcion_JL.setText("Descripción:");
        getContentPane().add(descripcion_JL);
        descripcion_JL.setBounds(20, 130, 120, 60);

        titulo_JL.setFont(new java.awt.Font("Dosis ExtraBold", 0, 36)); // NOI18N
        titulo_JL.setText("Título:");
        getContentPane().add(titulo_JL);
        titulo_JL.setBounds(230, 70, 120, 60);

        hora_finJL.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        hora_finJL.setText("Hora Fin:");
        getContentPane().add(hora_finJL);
        hora_finJL.setBounds(20, 370, 120, 60);

        hora_inicioJL.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        hora_inicioJL.setText("Hora Inicio:");
        getContentPane().add(hora_inicioJL);
        hora_inicioJL.setBounds(20, 310, 120, 60);

        fecha_finJL.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        fecha_finJL.setText("Fecha Fin:");
        getContentPane().add(fecha_finJL);
        fecha_finJL.setBounds(20, 250, 120, 60);

        fecha_inicioJL.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        fecha_inicioJL.setText("Fecha Inicio:");
        getContentPane().add(fecha_inicioJL);
        fecha_inicioJL.setBounds(20, 190, 120, 60);

        tiempoJL.setFont(new java.awt.Font("Dosis ExtraBold", 1, 36)); // NOI18N
        tiempoJL.setText("Modificar Evento");
        getContentPane().add(tiempoJL);
        tiempoJL.setBounds(20, 0, 310, 71);

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg.png"))); // NOI18N
        fondo.setRequestFocusEnabled(false);
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 898, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void elegirColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elegirColorActionPerformed
        JColorChooser colorChooser = new JColorChooser();
        //variable color guarda el color seleccionado
        setColor(JColorChooser.showDialog(null,"Color del evento", Color.black));
        this.evento_modificar.setColor(color);    
    }//GEN-LAST:event_elegirColorActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed

        Conectar cc = new Conectar();

        DateFormat f=new SimpleDateFormat("yyyy-MM-d");
        String fecha_inicioS = f.format(fechaIni_jDateChooser.getDate());
        String fecha_finS = f.format(fechaFin_jDateChooser1.getDate());
        
        try {
            this.evento_modificar.setFecha_inicio(new SimpleDateFormat("yyyy-MM-d").parse(fecha_inicioS));
            this.evento_modificar.setFecha_fin(new SimpleDateFormat("yyyy-MM-d").parse(fecha_finS));
            
        } catch (ParseException ex) {
            Logger.getLogger(EventoWindow.class.getName()).log(Level.SEVERE, null, ex);
        } 
 
        //cc.modificar(cc,evento,this.id);    
        cc.Guardar(cc, evento_modificar, dias);
        dispose();
    }//GEN-LAST:event_GuardarActionPerformed

    private void ocurrenciaPickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ocurrenciaPickerActionPerformed
        String item = (String)ocurrenciaPicker.getSelectedItem();
        Date fechaIni = fechaIni_jDateChooser.getDate(); //fecha cuando comienza
            
        if (item=="Diariamente" || item=="Semanalmente" || item=="Mensualmente" || item=="Anualmente" || item=="De lunes a viernes"){
           
           com.toedter.calendar.JDateChooser jd = new com.toedter.calendar.JDateChooser();
           String message ="Elegir fecha:\n";
           Object[] params = {message,jd};
           JOptionPane.showConfirmDialog(null,params,"Elegir fecha límite de ocurrencia:", JOptionPane.PLAIN_MESSAGE); 

           DateFormat f=new SimpleDateFormat("yyyy-MM-d");
           String fecha = f.format(((com.toedter.calendar.JDateChooser)params[1]).getDate());
           
           Date fechaFin = jd.getDate(); //fecha del fin de la ocurrencia
           
           this.dias = diasXPasar(fechaIni, fechaFin);      
       }
       else{
            this.dias = 1;
       }
        
       this.evento_modificar.setOcurrencia((String) ocurrenciaPicker.getSelectedItem());
    }//GEN-LAST:event_ocurrenciaPickerActionPerformed

    private void titulo_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titulo_TFActionPerformed
        this.evento_modificar.setTitulo(titulo_TF.getText());
    }//GEN-LAST:event_titulo_TFActionPerformed

    private void descripcion_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcion_TFActionPerformed
        this.evento_modificar.setDescripcion(descripcion_TF.getText());
    }//GEN-LAST:event_descripcion_TFActionPerformed

    private void hourPickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourPickerActionPerformed
        this.evento_modificar.setHora_inicio(Integer.parseInt((String)hourPicker.getSelectedItem()));
    }//GEN-LAST:event_hourPickerActionPerformed

    private void minutePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minutePickerActionPerformed
        this.evento_modificar.setMin_inicio(Integer.parseInt((String)minutePicker.getSelectedItem()));
    }//GEN-LAST:event_minutePickerActionPerformed

    private void AmPmPickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmPmPickerActionPerformed
        this.evento_modificar.setAmpm_inicio((String)AmPmPicker.getSelectedItem());
    }//GEN-LAST:event_AmPmPickerActionPerformed

    private void hourPicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourPicker1ActionPerformed
        this.evento_modificar.setHora_fin(Integer.parseInt((String)hourPicker1.getSelectedItem()));
    }//GEN-LAST:event_hourPicker1ActionPerformed

    private void minutePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minutePicker1ActionPerformed
        this.evento_modificar.setMin_fin(Integer.parseInt((String)minutePicker1.getSelectedItem()));
    }//GEN-LAST:event_minutePicker1ActionPerformed

    private void AmPmPicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmPmPicker1ActionPerformed
        this.evento_modificar.setAmpm_fin((String)AmPmPicker1.getSelectedItem());
    }//GEN-LAST:event_AmPmPicker1ActionPerformed

    private void notificacionesPickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificacionesPickerActionPerformed
        this.evento_modificar.setNotificaciones((String)notificacionesPicker.getSelectedItem());
    }//GEN-LAST:event_notificacionesPickerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AmPmPicker;
    private javax.swing.JComboBox<String> AmPmPicker1;
    private javax.swing.JButton Guardar;
    private javax.swing.JLabel descripcion_JL;
    private javax.swing.JTextField descripcion_TF;
    private javax.swing.JButton elegirColor;
    private com.toedter.calendar.JDateChooser fechaFin_jDateChooser1;
    private com.toedter.calendar.JDateChooser fechaIni_jDateChooser;
    private javax.swing.JLabel fecha_finJL;
    private javax.swing.JLabel fecha_inicioJL;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel hora_finJL;
    private javax.swing.JLabel hora_inicioJL;
    private javax.swing.JLabel hora_inicioJL1;
    private javax.swing.JLabel hora_inicioJL2;
    private javax.swing.JLabel hora_inicioJL3;
    private javax.swing.JLabel hora_inicioJL4;
    private javax.swing.JComboBox<String> hourPicker;
    private javax.swing.JComboBox<String> hourPicker1;
    private javax.swing.JComboBox<String> minutePicker;
    private javax.swing.JComboBox<String> minutePicker1;
    private javax.swing.JComboBox<String> notificacionesPicker;
    private javax.swing.JLabel notificaciones_JL;
    private javax.swing.JComboBox<String> ocurrenciaPicker;
    private javax.swing.JLabel ocurrencia_JL;
    private javax.swing.JLabel tiempoJL;
    private javax.swing.JLabel titulo_JL;
    private javax.swing.JTextField titulo_TF;
    // End of variables declaration//GEN-END:variables
}


