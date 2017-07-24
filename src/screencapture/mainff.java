/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package screencapture;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Header;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.javafx.animation.TickCalculation;
import com.teamdev.jxcapture.Codec;
import com.teamdev.jxcapture.EncodingParameters;
import com.teamdev.jxcapture.VideoCapture;
import com.teamdev.jxcapture.video.Desktop;
import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.ICodec;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.TimeZone;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import java.util.Timer;

/**
 *
 * @author aa
 */
public class mainff extends javax.swing.JFrame implements Runnable{
  
volatile boolean flag;
private final String username;
private final String password;
static String filename; private static final double FRAME_RATE = 50;

 private static final int SECONDS_TO_RUN_FOR = 20;
 private static Dimension screenBounds;




String location;
    BufferedImage b;
    FileOutputStream fo;
    FileInputStream fi;
    ZipOutputStream zo;
    int count;
    String user,pass,email;
         VideoCapture vedeocapture;
         Codec videoCodec;
         Timer timer;
         Thread timeupdate;
    
    /**
     * Creates new form mainff
     */
    public mainff() throws FileNotFoundException, IOException {
        initComponents();
        this.setResizable(false);
      timer=new Timer();

        
hour.setEnabled(false);
            second.setEnabled(false);
            minute.setEnabled(false);
            set.setEnabled(false);
            time.setVisible(false);
            jCheckBox1.setEnabled(false);
        username="kumarankush782@gmail.com";
       password="codejam2018";
        flag=false;
     
        location="D:\\screenshots\\shots\\";
        FileInputStream cr=new FileInputStream("D:\\screenshots\\credentials\\credential.coded.txt");
        File f=new File("D:\\screenshots\\credentials\\credential.txt");
        FileOutputStream fo=new FileOutputStream(f);
        int x=-1;
         start.setEnabled(false);
           stop.setEnabled(false);
           Emailpdf.setEnabled(false);
           mailcheckbox.setEnabled(false);
           pdfcheckbox.setEnabled((false));
           screenrecord.setEnabled(false);
        while((x=cr.read())!=-1)
        {
            x=x+10;
            fo.write(x);
        }
        fo.close();
        FileInputStream fi=new FileInputStream(f);
        DataInputStream dis=new DataInputStream(fi);
        String s=dis.readLine();
        dis.close();
        f.delete();
        String array[]=s.split(",");
        user=array[0];
        pass=array[1];
        email=array[2];
        jLabel1.setText("Hey   "+user);
        FileInputStream fis;
   
   
        
        //System.out.println(user+pass+email);
        
        new Thread(this).start();
    }
     public void run() {
        int sl;
        BufferedImage bufferi;
        Random random=new Random();
        while(true)
        {
     while(flag)
        {
            try {
                b=new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
               
                
            } catch (AWTException ex) {
                Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ImageIO.write(b, "jpg", new File(location+"ScreenShot"+Integer.toString(count)+getDateNow()+".jpg"));
                count++;
            } catch (IOException ex) {
                Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
            }
         try {
             sl=random.nextInt(60)*1000;
             Thread.sleep(sl);
         } catch (InterruptedException ex) {
             Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
        }
    
    }
     
    private String getDateNow()
    {
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
         df.setTimeZone(TimeZone.getTimeZone("PST"));
        return df.format(new Date());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        mailcheckbox = new javax.swing.JCheckBox();
        screenrecord = new javax.swing.JCheckBox();
        Emailpdf = new javax.swing.JCheckBox();
        pdfcheckbox = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hour = new javax.swing.JTextField();
        minute = new javax.swing.JTextField();
        second = new javax.swing.JTextField();
        set = new javax.swing.JButton();
        time = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        start.setText("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        stop.setText("Stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        mailcheckbox.setText("Mail Zip");

        screenrecord.setText("Screen Record");
        screenrecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenrecordActionPerformed(evt);
            }
        });

        Emailpdf.setText("Mail pdf");
        Emailpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailpdfActionPerformed(evt);
            }
        });

        pdfcheckbox.setText("GeneratePDF");

        jButton1.setText("Configure");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Commit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Set Timer");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Minutes");

        jLabel3.setText("Hours");

        jLabel4.setText("Seconds");

        hour.setText("0");
        hour.setMinimumSize(new java.awt.Dimension(10, 20));
        hour.setPreferredSize(new java.awt.Dimension(50, 20));
        hour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourActionPerformed(evt);
            }
        });

        minute.setText("0");
        minute.setPreferredSize(new java.awt.Dimension(50, 20));

        second.setText("0");
        second.setPreferredSize(new java.awt.Dimension(50, 20));

        set.setText("Set");
        set.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setActionPerformed(evt);
            }
        });

        time.setText("Wiil stop in");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(start)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(stop)
                .addGap(60, 60, 60)
                .addComponent(jCheckBox1)
                .addGap(76, 76, 76))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(60, 60, 60)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mailcheckbox)
                            .addComponent(Emailpdf))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(time)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(screenrecord)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(minute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(second, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pdfcheckbox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(set)
                                .addGap(36, 36, 36)))))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jCheckBox1)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stop)
                            .addComponent(start))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mailcheckbox)
                            .addComponent(screenrecord))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Emailpdf)
                            .addComponent(pdfcheckbox)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(minute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(second, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(set)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void screenrecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screenrecordActionPerformed
        // TODO add your handling code here:
           if(screenrecord.isSelected())
        {
            Emailpdf.setSelected(false);
            mailcheckbox.setSelected(false);
            pdfcheckbox.setSelected(false);
        }
    }//GEN-LAST:event_screenrecordActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
          vedeocapture=VideoCapture.create();
        vedeocapture.setVideoSource(new Desktop());
         java.util.List<Codec> videoCodecs = vedeocapture.getVideoCodecs();
                 
         videoCodec = videoCodecs.get(0);
        if(screenrecord.isSelected())
        {
            EncodingParameters encodingParameters = new EncodingParameters(new File("D:\\screenshots\\video\\"+"Desktop" +getDateNow()+new Date().getTime()+"."+ vedeocapture.getVideoFormat().getId()));
        // Resize output video
        encodingParameters.setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().height));
        encodingParameters.setBitrate(800000);
        encodingParameters.setFramerate(10);
        encodingParameters.setCodec(videoCodec);
        System.out.println("encodingParameters = " + encodingParameters);

        vedeocapture.setEncodingParameters(encodingParameters);
        vedeocapture.start();
        }
          File f=new File(location);
        File files[]=f.listFiles();
        for(File x:files)
        {
            x.delete();
        }
        // TODO add your handling code here:
        count=0;
        flag=true;
    }//GEN-LAST:event_startActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        // TODO add your handling code here:
        
        if(timeupdate!=null)
        {
            timeupdate.stop();
            time.setVisible(false);
          timer.cancel();


        }
        
       // timer.cancel();
       time.setVisible(false);
           
        if(screenrecord.isSelected())
        {
            vedeocapture.stop();
        }
         flag=false;
        if(true)
        {
        byte buffer[]=new byte[1024];
        String name="shots"+getDateNow()+"-"+new Date().getTime();
        
    try {
        fo=new FileOutputStream("D:screenshots\\zip\\"+name+".zip");
        zo=new ZipOutputStream(fo);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
    }
        String[] shotsName=new File("D:\\screenshots\\shots").list();
        for(String file:shotsName)
        {
            ZipEntry ze=new ZipEntry("D:\\screenshots\\shots"+file);
            try {
                zo.putNextEntry(ze);
            } catch (IOException ex) {
                Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                fi=new FileInputStream("D:\\screenshots\\shots\\"+file);
                int x=-1;
                while((fi.read(buffer))!=-1)
                {
                    zo.write(buffer);
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                if(fi!=null)
                    
                {
                    try {
                        fi.close();
                    } catch (IOException ex) {
                        Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            try {
                zo.closeEntry();
            } catch (IOException ex) {
                Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
            try {
                zo.close();
            } catch (IOException ex) {
                Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
            }
              if(pdfcheckbox.isSelected())
            {
            generatePDF(name);
            }
            if(mailcheckbox.isSelected())
            {
                sendMail(name);
            }
            if(pdfcheckbox.isSelected())
            {
            generatePDF(name);
            }
            if(Emailpdf.isSelected())
            {
                sendMailPDF(name);
            }
            if(screenrecord.isSelected())
            {
                generateVedeo( name);
            }
        }     
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    
    }//GEN-LAST:event_stopActionPerformed

    private void EmailpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailpdfActionPerformed
        // TODO add your handling code here:
          if(Emailpdf.isSelected())
        {
        pdfcheckbox.setSelected(true);
        }
        else
        {
            pdfcheckbox.setSelected(false);
        }
    }//GEN-LAST:event_EmailpdfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         String password=JOptionPane.showInputDialog(this, "Please enter password first");
        if(password.equals(pass))
        {
           start.setEnabled(true);
           stop.setEnabled(true);
           Emailpdf.setEnabled(true);
           mailcheckbox.setEnabled(true);
           pdfcheckbox.setEnabled((true));
           screenrecord.setEnabled(true);
           jCheckBox1.setEnabled(true);
           
           
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          start.setEnabled(false);
           stop.setEnabled(false);
           Emailpdf.setEnabled(false);
           mailcheckbox.setEnabled(false);
           pdfcheckbox.setEnabled((false));
           screenrecord.setEnabled(false);
           jCheckBox1.setEnabled(false);
         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void hourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_hourActionPerformed

    private void setActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setActionPerformed
        // TODO add your handling code here:
         vedeocapture=VideoCapture.create();
        vedeocapture.setVideoSource(new Desktop());
         java.util.List<Codec> videoCodecs = vedeocapture.getVideoCodecs();
                 
         videoCodec = videoCodecs.get(0);
        time.setVisible(true);
          if(screenrecord.isSelected())
        {
            EncodingParameters encodingParameters = new EncodingParameters(new File("D:\\screenshots\\video\\"+"Desktop" +getDateNow()+new Date().getTime()+"."+ vedeocapture.getVideoFormat().getId()));
        // Resize output video
        encodingParameters.setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().height));
        encodingParameters.setBitrate(800000);
        encodingParameters.setFramerate(10);
        encodingParameters.setCodec(videoCodec);
        System.out.println("encodingParameters = " + encodingParameters);

        vedeocapture.setEncodingParameters(encodingParameters);
        vedeocapture.start();
        }
          File f=new File(location);
        File files[]=f.listFiles();
        for(File x:files)
        {
            x.delete();
        }
        // TODO add your handling code here:
        count=0;
        flag=true;
        Date d=new Date();
        d.setHours(d.getHours()+Integer.parseInt(hour.getText()));
        d.setMinutes(d.getMinutes()+Integer.parseInt(minute.getText()));
        d.setSeconds(d.getSeconds()+Integer.parseInt(second.getText()));
        timer=new Timer();
        timer.schedule(new task(), d);
        timeupdate =new Thread(new Runnable() {

              @Override
              public void run() {
                  long seconds=d.getTime()-new Date().getTime();
                  seconds=seconds/1000;
                  while(seconds>0)
                  {
                      time.setText("Stop in "+seconds+"  seconds");
                      try {
                          Thread.sleep(1000);
                      } catch (InterruptedException ex) {
                          Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      seconds--;
                  }
              //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              }
          });
        timeupdate.start();
       
       
        
       
        
        
    }//GEN-LAST:event_setActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox1.isSelected())
        {
            hour.setEnabled(true);
            second.setEnabled(true);
            minute.setEnabled(true);
            set.setEnabled(true);
        }
        else
        {
             hour.setEnabled(false);
            second.setEnabled(false);
            minute.setEnabled(false);
            set.setEnabled(false);
            
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(mainff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new mainff().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
       public void sendMail(String name)
    {
        Properties prop=new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.host","smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        Session s=Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() 
                        
                        {
				return new PasswordAuthentication(username, password);
                                
			}
});
        
        
            Message message=new MimeMessage(s);
            
    try {
        message.setFrom(new InternetAddress(username));
       message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
       message.setSubject("Screen Shots on"+getDateNow());
        BodyPart bp=new MimeBodyPart();
        bp.setText("These Screen shots are from"+user+"on  date"+getDateNow());
        Multipart mp=new MimeMultipart();
        mp.addBodyPart(bp);
        BodyPart attachment=new MimeBodyPart();
        String filename="D:screenshots\\zip\\"+name+".zip";
        DataSource ds=new FileDataSource(filename);
        attachment.setDataHandler(new DataHandler(ds));
        attachment.setFileName(name+".zip");
        mp.addBodyPart(attachment);
        message.setContent(mp);
        Transport.send(message);
    } catch (MessagingException ex) {
        Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
     public void sendMailPDF(String name)
    {
        Properties prop=new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.host","smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        Session s=Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() 
                        
                        {
				return new PasswordAuthentication(username, password);
                                
			}
});
        
        
            Message message=new MimeMessage(s);
            
    try {
        message.setFrom(new InternetAddress(username));
       message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
       message.setSubject("Screen Shots on"+getDateNow());
        BodyPart bp=new MimeBodyPart();
        bp.setText("These Screen shots are from"+user+"on  date"+getDateNow());
        Multipart mp=new MimeMultipart();
        mp.addBodyPart(bp);
        BodyPart attachment=new MimeBodyPart();
        String filename="D:screenshots\\pdf\\"+name+".pdf";
        DataSource ds=new FileDataSource(filename);
        attachment.setDataHandler(new DataHandler(ds));
        attachment.setFileName(name+".pdf");
        mp.addBodyPart(attachment);
        message.setContent(mp);
        Transport.send(message);
    } catch (MessagingException ex) {
        Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    private void generatePDF(String name)
    {
        //requires xuggler and slf4j jar files
        int count=1;
        Document d=new Document();
    try {
        PdfWriter.getInstance(d, new FileOutputStream("D:\\screenshots\\pdf\\"+name+".pdf"));
        d.open();
        File f=new File("D:\\screenshots\\shots");
        String files[]=f.list();
        d.add(new Header("main", "Screnshots on"+name));
        Paragraph par=new Paragraph("                                                          Screnshots on   "+getDateNow());
        d.add(par);
        d.addSubject("Screenshots");
        d.left(0.0f);
        d.right(0.0f);
        for(String x:files)
        {
            d.add(new Paragraph("\"                                                          Screnshot   " +count));
            Image i=Image.getInstance(location+x);
            
            i.scaleAbsolute(550,350);
            d.add(i);
            count++;
        }
        d.close();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
    } catch (DocumentException ex) {
        Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
    } 
     catch (IOException ex) {
        Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    private void generateVedeo(String name)
    { 
        

    }
   

 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Emailpdf;
    private javax.swing.JTextField hour;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JCheckBox mailcheckbox;
    private javax.swing.JTextField minute;
    private javax.swing.JCheckBox pdfcheckbox;
    private javax.swing.JCheckBox screenrecord;
    private javax.swing.JTextField second;
    private javax.swing.JButton set;
    private javax.swing.JButton start;
    private javax.swing.JButton stop;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables

  class task extends TimerTask{

        @Override
        public void run() {
            time.setVisible(false);
            if(timeupdate.isAlive())
        {
            timeupdate.stop();
            time.setVisible(false);
          


        }
        if(screenrecord.isSelected())
        {
            vedeocapture.stop();
        }
         flag=false;
        if(true)
        {
        byte buffer[]=new byte[1024];
        String name="shots"+getDateNow()+"-"+new Date().getTime();
        
    try {
        fo=new FileOutputStream("D:screenshots\\zip\\"+name+".zip");
        zo=new ZipOutputStream(fo);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
    }
        String[] shotsName=new File("D:\\screenshots\\shots").list();
        for(String file:shotsName)
        {
            ZipEntry ze=new ZipEntry("D:\\screenshots\\shots"+file);
            try {
                zo.putNextEntry(ze);
            } catch (IOException ex) {
                Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                fi=new FileInputStream("D:\\screenshots\\shots\\"+file);
                int x=-1;
                while((fi.read(buffer))!=-1)
                {
                    zo.write(buffer);
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                if(fi!=null)
                    
                {
                    try {
                        fi.close();
                    } catch (IOException ex) {
                        Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            try {
                zo.closeEntry();
            } catch (IOException ex) {
                Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
            try {
                zo.close();
            } catch (IOException ex) {
                Logger.getLogger(mainff.class.getName()).log(Level.SEVERE, null, ex);
            }
              if(pdfcheckbox.isSelected())
            {
            generatePDF(name);
            }
            if(mailcheckbox.isSelected())
            {
                sendMail(name);
            }
            if(pdfcheckbox.isSelected())
            {
            generatePDF(name);
            }
            if(Emailpdf.isSelected())
            {
                sendMailPDF(name);
            }
            if(screenrecord.isSelected())
            {
                generateVedeo( name);
            }
        }     
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
}
   

}
