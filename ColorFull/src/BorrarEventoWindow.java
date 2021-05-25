
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BorrarEventoWindow extends javax.swing.JFrame {
   
    public BorrarEventoWindow() {
        initComponents();
        this.setVisible(true);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ir = new javax.swing.JButton();
        fechaIni_jDateChooser = new com.toedter.calendar.JDateChooser();
        fecha_inicioJL = new javax.swing.JLabel();
        tiempoJL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(234, 225, 200));
        setMaximumSize(new java.awt.Dimension(340, 179));
        setPreferredSize(new java.awt.Dimension(340, 179));
        getContentPane().setLayout(null);

        ir.setBackground(new java.awt.Color(234, 225, 200));
        ir.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        ir.setText("Ir");
        ir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irActionPerformed(evt);
            }
        });
        getContentPane().add(ir);
        ir.setBounds(250, 90, 50, 33);
        getContentPane().add(fechaIni_jDateChooser);
        fechaIni_jDateChooser.setBounds(130, 100, 100, 20);

        fecha_inicioJL.setFont(new java.awt.Font("Dosis ExtraBold", 0, 18)); // NOI18N
        fecha_inicioJL.setText("Fecha Inicio:");
        getContentPane().add(fecha_inicioJL);
        fecha_inicioJL.setBounds(20, 80, 120, 60);

        tiempoJL.setFont(new java.awt.Font("Dosis ExtraBold", 1, 36)); // NOI18N
        tiempoJL.setText("Borrar Evento");
        getContentPane().add(tiempoJL);
        tiempoJL.setBounds(40, 10, 270, 71);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void irActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irActionPerformed
        
        Conectar cc = new Conectar();       
        ArrayList fechas;

        DateFormat f=new SimpleDateFormat("yyyy-MM-d");
        String fecha_inicioS = f.format(fechaIni_jDateChooser.getDate());

        fechas = cc.Consultar(cc, fecha_inicioS);

        Object[] fechasObject = new Object[fechas.size()];
        
        for (int i=0;i<fechas.size();i++){
            fechasObject[i]=fechas.get(i);
        }
  
        Object seleccion = JOptionPane.showInputDialog(
            null,
            "Seleccione evento a eliminar",
            "Selector de opciones",
            JOptionPane.QUESTION_MESSAGE,
            null,  // null para icono defecto
            fechasObject,"opcion 1");
        
        cc.elimininar(cc,String.valueOf(seleccion));
    }//GEN-LAST:event_irActionPerformed
    
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EventoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventoWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser fechaIni_jDateChooser;
    private javax.swing.JLabel fecha_inicioJL;
    private javax.swing.JButton ir;
    private javax.swing.JLabel tiempoJL;
    // End of variables declaration//GEN-END:variables
}


