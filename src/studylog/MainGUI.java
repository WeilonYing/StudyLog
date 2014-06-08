package studylog;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.List;



/*
 *Hello all. Prepare to get cancer from this terrible coding :)
 */

/**
 *
 * @author Dylan
 */
public class MainGUI extends javax.swing.JFrame {
    //String logFile = "Log.txt"; //Change this if you want to change the log file name.
    
    int Time;
    int DTotal;
    int DHours;
    int DMinutes;
    
    int JHours;
    int JMinutes;
    int JTotal;
    
    int WHours;
    int WMinutes;
    int WTotal;
    
    int KHours;
    int KMinutes;
    int KTotal;
    
    int PHours;
    int PMinutes;
    int PTotal;
    
    String Leader = "Nobody";
    int TitleChooser;
        
    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        
        initComponents();
        SetLabels();
        setSize(1010, 635);
        setResizable(false);
        setLocationRelativeTo(null);

        rewriteData();
        Leader();
        RandomTitle();
    }
    public int RandomInteger(int min, int max) { 
       int number = (min + (int)(Math.random() * ((max - min) + 1)));
       return number;
               }
    public void RandomTitle() {
        TitleChooser = RandomInteger(1, 16);

        switch (TitleChooser) {
            case 1:
                setTitle("StudyLog - much more interesting than paper!");
                break;
            case 2:
                setTitle("Completely Scientific!");
                break;
            case 3:
                setTitle("This isn't even my final form!");
                break;
            case 4:
                setTitle("こんにちは　日本！"); //Hello Japan!
                break;
            case 5:
                setTitle("[Shameless promotion goes here]");
                break;
            case 6:
                setTitle("Totally not rigged!");
                break;
            case 7:
                setTitle("Made with 11 secret herbs and spices!");
                break;
            case 8:
                setTitle("Now with 100% more random titles!");
                break;
            case 9:
                setTitle("30% bonus to intellect while active");
                break;
            case 10:
                setTitle("Now with 20% less bias!");
                break;
            case 11:
                setTitle("Independent Potato that doesn't need no Sasha");
                break;
            case 12:
                setTitle("Now serves mouth-watering baked potatoes!");
                break;
            case 13:
                setTitle("Down Down! Prices are Down!");
                break;
            case 14:
                setTitle("DragonStryke 2.0");
                break;
            case 15:
                setTitle("Now with Mr. Willey DLC!");
                break;
            case 16:
                setTitle("Feed your family for under $10!");
                break;
            default:
                setTitle("Study Log");
         }
        
        /* OBSOLETE CODE
        if (TitleChooser == 1) {
           this.setTitle("StudyLog - much more interesting than paper!");
        }
        else if (TitleChooser == 2) {
            this.setTitle("Completely Scientific!");
        }
        else if (TitleChooser == 3) {
            this.setTitle("This isn't even my final form!");
        }
        else if (TitleChooser == 4) {
            this.setTitle("こんにちは　日本！"); //Hello Japan!
        }
        else if (TitleChooser == 5) {
            this.setTitle("[Shameless promotion goes here]");
        }
        else if (TitleChooser == 6) {
            this.setTitle("Totally not rigged!");
        }
        else if (TitleChooser == 7) {
            this.setTitle("Made with 11 secret herbs and spices!");
        }
        else if (TitleChooser == 8) {
            this.setTitle("Now with 100% more random titles!");
        }
        else if (TitleChooser == 9) {
            this.setTitle("30% bonus to intellect while active"); 
        }
        else if (TitleChooser == 10) {
            this.setTitle("Now with 20% less bias!");
        }
        */
         
     }
    
    public void rewriteData() { //Regenerate names if not found
        //Add names here.
        String[] names = {"Dylan", "Jack", "Weilon", "Katrina", "Phoebe"};
        if (Files.notExists(Paths.get("Logs"), LinkOption.NOFOLLOW_LINKS)) {
            boolean mkFolder = new File("Logs").mkdir(); //Create the directory. If failed, it will return false.
            if (!mkFolder) {
                JOptionPane.showMessageDialog(null, "Cannot create data files. Please move "
                        + "StudyLog to a different directory or run as "
                        + "Administrator.", "Cannot create data files", JOptionPane.ERROR_MESSAGE);
            }
        }
        for (int i = 0; i < names.length; i++) {
            if (!GetData.checkFileExists("Logs/Log" + names[i] + ".txt")) {
                String sourceFileRegen = "Logs/Log" + names[i] + ".txt";
                GetData.regenFile(sourceFileRegen);
                GetData.write(sourceFileRegen, names[i], "0");;
            }
        }
        
        //Obsolete code. Still needed for reference.
        /*checkExistingData = GetData.getTime(names[i]);
            if (checkExistingData == null) {
                GetData.write(logFile, names[i], "0");
        }*/
    }
    public void SetLabels() {
       DTotal = GetData.getTimeDylan();
       DHours = DTotal/60;
       DMinutes = (DTotal - DHours*60);
       lblDylanTime.setText(DHours+" Hour(s), "+DMinutes+" Minutes");
       
       JTotal = GetData.getTimeJack();
       JHours = JTotal/60;
       JMinutes = (JTotal - JHours*60);
       lblJackTime.setText(JHours+" Hour(s), "+JMinutes+" Minutes");
        
       WTotal = GetData.getTimeWeilon();
       WHours = WTotal/60;
       WMinutes = (WTotal - WHours*60);
       lblWhaleTime.setText(WHours+" Hour(s), "+WMinutes+" Minutes");
       
       KTotal = GetData.getTimeKatrina();
       KHours = KTotal/60;
       KMinutes = (KTotal - KHours*60);
       lblKatrinaTime.setText(KHours+" Hour(s), "+KMinutes+" Minutes");

       PTotal = GetData.getTimePhoebe();
       PHours = PTotal/60;
       PMinutes = (PTotal - PHours*60);
       lblPhoebeTime.setText(PHours+" Hour(s), "+PMinutes+" Minutes");
    }
    public void Leader() {
        if (DTotal > JTotal && DTotal > WTotal && DTotal > KTotal && DTotal > PTotal) {
            Leader = "Dylan";
        }
        else if (JTotal > DTotal && JTotal > WTotal && JTotal > KTotal && JTotal > PTotal) {
            Leader = "Jack"; }
        else if (WTotal > DTotal && WTotal > JTotal && WTotal > KTotal && WTotal > PTotal) {
            Leader = "Weilon"; }
        else if (KTotal > DTotal && KTotal > WTotal && KTotal > JTotal && KTotal > PTotal) {
            Leader = "Katrina"; }
        else if (PTotal > DTotal && PTotal > WTotal && PTotal > KTotal && PTotal > JTotal) {
            Leader = "Phoebe"; }
        
        lblWinning.setText("Currently in the lead is " + Leader + "!");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNAME = new javax.swing.JTextField();
        txtTIME = new javax.swing.JTextField();
        btnSubmitTimes = new javax.swing.JButton();
        btnRoles = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblWinningTime = new javax.swing.JLabel();
        lblWinning = new javax.swing.JLabel();
        lblPhoebe = new javax.swing.JLabel();
        lblPhoebeTime = new javax.swing.JLabel();
        lblKatrina = new javax.swing.JLabel();
        lblKatrinaTime = new javax.swing.JLabel();
        lblDylan = new javax.swing.JLabel();
        lblDylanTime = new javax.swing.JLabel();
        lblWhale = new javax.swing.JLabel();
        lblWhaleTime = new javax.swing.JLabel();
        lblJack = new javax.swing.JLabel();
        lblJackTime = new javax.swing.JLabel();
        lblWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        txtNAME.setFont(new java.awt.Font("Helvetica-Narrow", 0, 36)); // NOI18N
        getContentPane().add(txtNAME);
        txtNAME.setBounds(80, 140, 390, 54);

        txtTIME.setFont(new java.awt.Font("Helvetica-Narrow", 0, 36)); // NOI18N
        txtTIME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTIMEActionPerformed(evt);
            }
        });
        getContentPane().add(txtTIME);
        txtTIME.setBounds(80, 250, 390, 54);

        btnSubmitTimes.setFont(new java.awt.Font("Helvetica-Narrow", 0, 24)); // NOI18N
        btnSubmitTimes.setText("Submit Times");
        btnSubmitTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitTimesActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmitTimes);
        btnSubmitTimes.setBounds(80, 310, 390, 80);

        btnRoles.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRoles.setText("Rules");
        btnRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRolesActionPerformed(evt);
            }
        });
        getContentPane().add(btnRoles);
        btnRoles.setBounds(170, 460, 200, 60);

        jLabel2.setFont(new java.awt.Font("Helvetica-Narrow", 0, 24)); // NOI18N
        jLabel2.setText("Time (in minutes):");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 200, 392, 44);

        jLabel4.setFont(new java.awt.Font("Helvetica-Narrow", 0, 24)); // NOI18N
        jLabel4.setText("First Name:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 90, 392, 44);

        lblWinningTime.setFont(new java.awt.Font("Helvetica-Narrow", 0, 24)); // NOI18N
        getContentPane().add(lblWinningTime);
        lblWinningTime.setBounds(100, 440, 360, 44);

        lblWinning.setFont(new java.awt.Font("Helvetica-Narrow", 0, 24)); // NOI18N
        lblWinning.setText("Currently in the lead is");
        getContentPane().add(lblWinning);
        lblWinning.setBounds(80, 400, 470, 44);

        lblPhoebe.setFont(new java.awt.Font("Helvetica-Narrow", 0, 24)); // NOI18N
        lblPhoebe.setText("Phoebe");
        getContentPane().add(lblPhoebe);
        lblPhoebe.setBounds(530, 310, 110, 44);

        lblPhoebeTime.setFont(new java.awt.Font("Helvetica-Narrow", 0, 24)); // NOI18N
        lblPhoebeTime.setText("___________________");
        getContentPane().add(lblPhoebeTime);
        lblPhoebeTime.setBounds(620, 310, 290, 44);

        lblKatrina.setFont(new java.awt.Font("Helvetica-Narrow", 0, 24)); // NOI18N
        lblKatrina.setText("Katrina");
        getContentPane().add(lblKatrina);
        lblKatrina.setBounds(530, 260, 80, 44);

        lblKatrinaTime.setFont(new java.awt.Font("Helvetica-Narrow", 0, 24)); // NOI18N
        lblKatrinaTime.setText("___________________");
        getContentPane().add(lblKatrinaTime);
        lblKatrinaTime.setBounds(620, 260, 290, 44);

        lblDylan.setFont(new java.awt.Font("Helvetica-Narrow", 0, 24)); // NOI18N
        lblDylan.setText("Dylan");
        getContentPane().add(lblDylan);
        lblDylan.setBounds(530, 110, 80, 44);

        lblDylanTime.setFont(new java.awt.Font("Helvetica-Narrow", 0, 24)); // NOI18N
        lblDylanTime.setText("___________________");
        getContentPane().add(lblDylanTime);
        lblDylanTime.setBounds(620, 110, 310, 44);

        lblWhale.setFont(new java.awt.Font("Helvetica-Narrow", 0, 24)); // NOI18N
        lblWhale.setText("Weilon");
        getContentPane().add(lblWhale);
        lblWhale.setBounds(530, 160, 80, 44);

        lblWhaleTime.setFont(new java.awt.Font("Helvetica-Narrow", 0, 24)); // NOI18N
        lblWhaleTime.setText("___________________");
        getContentPane().add(lblWhaleTime);
        lblWhaleTime.setBounds(620, 160, 300, 44);

        lblJack.setFont(new java.awt.Font("Helvetica-Narrow", 0, 24)); // NOI18N
        lblJack.setText("Jack");
        getContentPane().add(lblJack);
        lblJack.setBounds(530, 210, 60, 44);

        lblJackTime.setFont(new java.awt.Font("Helvetica-Narrow", 0, 24)); // NOI18N
        lblJackTime.setText("___________________");
        getContentPane().add(lblJackTime);
        lblJackTime.setBounds(620, 210, 300, 44);

        lblWallpaper.setFont(new java.awt.Font("Helvetica-Narrow", 0, 24)); // NOI18N
        lblWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studylog/Wallpaper.png"))); // NOI18N
        getContentPane().add(lblWallpaper);
        lblWallpaper.setBounds(0, 0, 1000, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTIMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTIMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTIMEActionPerformed

    private void btnSubmitTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitTimesActionPerformed
      String Currentname = txtNAME.getText();
        if (Currentname.equalsIgnoreCase("dylan")) {
             Time = GetData.getTimeDylan();
             System.out.println(Time);
             Time = Time + getTextboxTime();
             GetData.setTimeDylan(Time);
             System.out.println(Time);
        }
        else if (Currentname.equalsIgnoreCase("weilon")) {
             Time = GetData.getTimeWeilon();
             System.out.println(Time);
             Time = Time + getTextboxTime();
             GetData.setTimeWeilon(Time);
             System.out.println(Time);
        }
        else if (Currentname.equalsIgnoreCase("jack")) {
             Time = GetData.getTimeJack();
             System.out.println(Time);
             Time = Time + getTextboxTime();
             GetData.setTimeJack(Time);
             System.out.println(Time);
        }
        else if (Currentname.equalsIgnoreCase("katrina")) {
             Time = GetData.getTimeKatrina();
             System.out.println(Time);
             Time = Time + getTextboxTime();
             GetData.setTimeKatrina(Time);
             System.out.println(Time);
        }
        else if (Currentname.equalsIgnoreCase("phoebe")) {
             Time = GetData.getTimePhoebe();
             System.out.println(Time);
             Time = Time + getTextboxTime();
             GetData.setTimePhoebe(Time);
             System.out.println(Time);
        }
        else {
            JOptionPane.showMessageDialog(null, "Enter your name correctly!");
        }
        txtTIME.setText("");
        SetLabels(); 
        Leader();
    }//GEN-LAST:event_btnSubmitTimesActionPerformed

    private void btnRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRolesActionPerformed
        Rules rulesWindow = new Rules(this, true);
        rulesWindow.setVisible(true);
    }//GEN-LAST:event_btnRolesActionPerformed

    public int getTextboxTime() {
        int intTime = 0;
        try {
            String stringTime = txtTIME.getText();
            intTime = Integer.parseInt(stringTime);
        }
        catch (NumberFormatException e) {
            intTime = 0;
            
        }
        finally {
            if (intTime == 0) {
                JOptionPane.showMessageDialog(null, "Enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            }
            System.out.println("Time = " + intTime);
            return intTime;
            
        }
    }
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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRoles;
    private javax.swing.JButton btnSubmitTimes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblDylan;
    private javax.swing.JLabel lblDylanTime;
    private javax.swing.JLabel lblJack;
    private javax.swing.JLabel lblJackTime;
    private javax.swing.JLabel lblKatrina;
    private javax.swing.JLabel lblKatrinaTime;
    private javax.swing.JLabel lblPhoebe;
    private javax.swing.JLabel lblPhoebeTime;
    private javax.swing.JLabel lblWallpaper;
    private javax.swing.JLabel lblWhale;
    private javax.swing.JLabel lblWhaleTime;
    private javax.swing.JLabel lblWinning;
    private javax.swing.JLabel lblWinningTime;
    private javax.swing.JTextField txtNAME;
    private javax.swing.JTextField txtTIME;
    // End of variables declaration//GEN-END:variables
}
