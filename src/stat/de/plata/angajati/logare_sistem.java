package stat.de.plata.angajati;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import newpackage.administrator.Meniul_Principal_Administrator;

public class logare_sistem extends javax.swing.JFrame {
    
    Connection conexiune=null;
    PreparedStatement st=null;
    ResultSet rs=null;
    String nume;
    String parola;
    int id;
    String selected;
  

    public logare_sistem() {
        initComponents();
        afisareDataCurenta();
        conexiune = conexiune_baza_de_date.baza_de_date();
        
        setSize(700,500);
        setVisible(true);
        setResizable(false);

        setLayout(new BorderLayout());
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        JLabel background=new JLabel(new ImageIcon("C:\\pizzacasei.cf\\stat-plata-master\\stat-plata-master\\src\\stat\\de\\plata\\angajati\\imagini\\2017-10-01_161406.png"));

        add(background);

        background.setLayout(new FlowLayout());
        
           jComboBox1.insertItemAt("", 0);
           jComboBox1.setSelectedIndex(0);
           jComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             
                selected = jComboBox1.getSelectedItem().toString();
                
            }
        });
           
           

    }
    
   public void afisareDataCurenta(){
        
        Calendar calendar =new GregorianCalendar();
        
        int an = calendar.get(Calendar.YEAR);
        int luna = calendar.get(Calendar.MONTH);
        int zi = calendar.get(Calendar.DAY_OF_MONTH);
        
        jMenu2.setText((luna+1)+"/"+zi+"/"+an);
        int ora = calendar.get(Calendar.HOUR);
        int minut= calendar.get(Calendar.MINUTE);
        int secunda = calendar.get(Calendar.SECOND);
     
        
        jMenu3.setText(ora+":"+minut+":"+secunda);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPasswordField1 = new javax.swing.JPasswordField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Introduceti datele");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 300, 100, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 340, 70, 20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 370, 70, 20);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(120, 340, 120, 20);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 420, 90, 23);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Pozitia ocupata");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(280, 340, 100, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Contabil" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(370, 340, 90, 20);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(120, 370, 120, 20);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // TODO add your handling code here:
       
         String pass = new String(jPasswordField1.getPassword());
       if (jTextField1.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Campul Nume Utilizator este gol.");
    } else if (jPasswordField1.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Campul Parola este gol.");
    } else if(jTextField1.getText().equals("") && pass.equals("")){
        JOptionPane.showMessageDialog(null, "Campul Nume Utilizator si campul Parola sunt goale.");
    } else {
        
        String interogare = "select * from Utilizatori where nume=? and parola=? and pozitia_ocupata=?";
           try {
               int count = 0;
               st= conexiune.prepareStatement(interogare);
               
               st.setString(1,jTextField1.getText());
               String passText = new String(jPasswordField1.getPassword());
               st.setString(2,passText);
               st.setString(3,selected);
               
               rs = st.executeQuery();
      
               if(rs.next()){

                    if (selected=="Administrator"){

                    JOptionPane.showMessageDialog(null, "Logare cu succes");
                    Meniul_Principal_Administrator meniu = new Meniul_Principal_Administrator();
                    meniu.setVisible(true);
                    this.dispose();   

                    }else if(selected=="Contabil"){

                        JOptionPane.showMessageDialog(null, "Logare cu succes");
                        Meniul_Principal meniu = new Meniul_Principal();
                        meniu.setVisible(true);
                        this.dispose();
                    }
                  
               }else{
                    JOptionPane.showMessageDialog(null,"Logare nu a fost realizata cu succes");
               }
               
           } catch(Exception e)

        {
             JOptionPane.showMessageDialog(null, e);

        }
        finally {
            
            try{
                rs.close();
                st.close();
                
            }
            catch(Exception e){
                
            }
    }
    

    }//GEN-LAST:event_jButton1ActionPerformed
    }
 
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(logare_sistem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(logare_sistem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(logare_sistem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(logare_sistem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new logare_sistem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
