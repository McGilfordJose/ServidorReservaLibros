/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import sources.Cliente;
import sources.ConexionBD;
import sources.ConsultarSQL;
import sources.Insertar;
import sources.Servidor;
import sources.Timer;


/**
 *
 * @author chuch
 */
public class Reloj extends javax.swing.JFrame implements Observer{

    private static int h;
    private static int m;
    private static int s;
    private static boolean tc;
    private static ConexionBD con;
    private static Connection conL;
    private static Connection conR;
    private static String nombreUsuario="";
    private static int r=0;
    /**
     * Creates new form Reloj
     */
    public Reloj() {
        initComponents();
        h = (int) (Math.random()*25);
        m = (int) (Math.random()*60);
        s = (int) (Math.random()*60);
        con = new ConexionBD();
        conR=con.ConexionReloj();
        conL=con.ConexionLibros();
        nombreUsuario = System.getProperty("user.name");
        System.out.println(nombreUsuario);
        
        try {
            Runtime.getRuntime().exec("cmd /C time "+h+":"+m+":"+s);
        } catch (IOException ex) {
            Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
        }
        tc = true;
        Servidor s = new Servidor(6008);
        s.addObserver(this);//Agraga a quien va a observar
        Thread t = new Thread(s);
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Enviar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hora");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        tc=true;
        r=(int)(Math.random()*100001);
        Cliente c = new Cliente(5008,h+":"+m+":"+s+"\n"+nombreUsuario+"\n"+r+"\n","192.168.1.76");
        Thread t1 = new Thread(c);
        t1.start();
        //System.out.println(c.getStatus());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tc=false;
        jTextField1.setText(h+":"+m+":"+s);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reloj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reloj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reloj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reloj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reloj().setVisible(true);
            }
        });
         while(true)
          {
           
              if(tc==true)
              {
                  //System.out.println("Activo");
                Timer t = new Timer();
                t.start();
                h=t.getH();
                m=t.getM();
                s=t.getS();
                //System.out.println(s+" "+s%5);
                if(s%5==0)
                {
                    r=(int)(Math.random()*100001);
                   //m=m+10;
                    Cliente c = new Cliente(5008,h+":"+m+":"+s+"\n"+nombreUsuario+"\n"+r+"\n","192.168.1.76");
                    Thread t1 = new Thread(c);
                    t1.start();
                    try {
                    InetAddress address = InetAddress.getLocalHost();
                    Insertar insert = new Insertar(conR, 1, 0, "",h+":"+m+":"+s,address.getHostAddress(), nombreUsuario, r, "");
                    insert.start();
                    /*if(address.getHostAddress().compareTo("192.168.1.76")==0)
                    {
                    Cliente c2 = new Cliente(6008,"Codigo "+1+"\n"+h+":"+m+":"+s+"\n"+nombreUsuario+"\n"+r+"\n","192.168.1.75");
                    Thread t2 = new Thread(c2);
                    t2.start();
                    }
                    else
                    {
                    Cliente c2 = new Cliente(6008,"Codigo "+1+"\n"+h+":"+m+":"+s+"\n"+nombreUsuario+"\n"+r+"\n","192.168.1.76");
                    Thread t2 = new Thread(c2);
                    t2.start();
                    }*/
                    
                    
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
              }
              ConsultarSQL Cons1 = new ConsultarSQL(conL, "libro",4);
              ConsultarSQL Cons2 = new ConsultarSQL(conL, "cliente",5);
              Cons1.start();
              Cons2.start();
              Thread.sleep(1000);
              //System.out.println(h+":"+m+":"+s);
          }
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        String []str = o1.toString().split("\n");
        System.out.println(o1.toString());
        //System.out.println("Str "+str[2]); La ip de nuestro cliente
        if(str[1].compareTo("Maestro")==0)
        {
        this.jTextField1.setText(str[0]);
        tc=true;
        try {
            Runtime.getRuntime().exec("cmd /C time "+str[0]);
        } catch (IOException ex) {
            Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
        }
        //String []inser = str[2].split("|");
        
        int idc=0;
        idc= (int) (Math.random()*100001);
        Insertar insert = new Insertar(conR, 0, idc,h+":"+m+":"+s,str[0],"", "", 0, "");
        insert.start();
        
        }
        else if(str[1].compareTo("Cliente")==0)
        {
            System.out.println("Enviando");
                    Cliente c = new Cliente(7008,h+":"+m+":"+s+"\nReloj\n",str[2]);
                    Thread t1 = new Thread(c);
                    t1.start();
        }
        
        else
        {
        this.jTextArea1.append(o1.toString()+"\n");
        ConsultarSQL ConsLibro = new ConsultarSQL(conL, "libro",0);
        ConsLibro.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
            }
        ImageIcon iconr = new ImageIcon(getClass().getResource("/imagenes/"+ConsLibro.getPortada()));
        Icon iconor = new ImageIcon(iconr.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_DEFAULT));
        jLabel2.setIcon( iconor );
        Cliente c = new Cliente(7008,"Libro Resultado "+ConsLibro.getIdLibro()+" "+ConsLibro.getNombreLibro()+" "+ConsLibro.getAutor()+" "+ConsLibro.getPortada()+"\nConsulta\n",str[2]);
        Thread t1 = new Thread(c);
        t1.start();
        }
        //this.jTextField1.append((String) o1+"\n");
        //this.jTextField1.append((String) o1+"\n");
    }
}