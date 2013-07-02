package pl.wikizabytki;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File; 
import java.io.IOException;
import java.util.ArrayList;
import jxl.*; 
import javax.swing.UIManager;
import jxl.read.biff.BiffException;
import pl.wikizabytki.classes.Gmina;
import pl.wikizabytki.classes.Monument;
import pl.wikizabytki.classes.Powiat;

public class Main extends javax.swing.JFrame {
    Log log;
    ArrayList<Powiat> powiats = new ArrayList<>();
    
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        log = new Log(loger);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bStart = new javax.swing.JButton();
        tFile = new javax.swing.JTextField();
        lFile = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        loger = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bStart.setText("Start");
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartActionPerformed(evt);
            }
        });

        tFile.setText("C:\\Users\\Pawel\\Dropbox\\Wiki\\Wiki Lubi Zabytki\\Listy\\kujawsko-pomorskie.xls");
        tFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tFileActionPerformed(evt);
            }
        });

        lFile.setText("XLS path");

        jScrollPane2.setViewportView(loger);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lFile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tFile, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bStart, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tFile, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartActionPerformed
        Runnable run = new Runnable() {
            @Override
            public void run() {
                try {
                    start(tFile.getText());
                } catch (IOException | BiffException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        Thread t = new Thread(run);
        t.start();
    }//GEN-LAST:event_bStartActionPerformed

    private void tFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tFileActionPerformed

    private void start(String path) throws IOException, BiffException {
        Workbook workbook = Workbook.getWorkbook(new File(tFile.getText()));
        Sheet sheet = workbook.getSheet(0);
 
        int currentPowiat = 0;
        int currentGmina = 0;
        
        for(int i=1; i<100 /*sheet.getColumn(0).length*/; ++i) {
            String id = sheet.getCell(0,i).getContents();
            String powiat = sheet.getCell(2,i).getContents();
            String gmina = sheet.getCell(3,i).getContents();
            String town = sheet.getCell(4,i).getContents();
            String name = sheet.getCell(5,i).getContents();
            String hint = sheet.getCell(6,i).getContents();
            String street = sheet.getCell(7,i).getContents();
            int partOf = Integer.parseInt(sheet.getCell(9,i).getContents());
            String material = sheet.getCell(10,i).getContents();
            String date = sheet.getCell(11,i).getContents();
            String number = sheet.getCell(12,i).getContents();
            
            //powiat
            if(powiats.isEmpty())
                powiats.add(new Powiat(powiat));
            
            if(!powiats.get(currentPowiat).name.equals(powiat)) {
                boolean flag = false;
                for(Powiat p : powiats)
                    if(p.name.equals(powiat)) {
                        //System.out.println("Znalazłem powiat '"+powiat+"'");
                        currentPowiat = powiats.indexOf(p);
                        flag = true; break; 
                    };
                if(!flag) {
                    //System.out.println("Dodaję powiat '"+powiat+"'");
                    powiats.add(new Powiat(powiat));
                    currentPowiat = powiats.size()-1;
                }
            } //else System.out.println("Aktualny powiat pasuje!");
            
            //gmina
            if(powiats.get(currentPowiat).gminas.isEmpty()) 
                powiats.get(currentPowiat).gminas.add(new Gmina(gmina));
            
            if(!powiats.get(currentPowiat).gminas.get(currentGmina).name.equals(gmina)) {
                boolean flag = false;
                for(Gmina g : powiats.get(currentPowiat).gminas)
                    if(g.name.equals(gmina)) {
                        //System.out.println("Znalazłem gminę '"+gmina+"'");
                        currentGmina = powiats.get(currentPowiat).gminas.indexOf(g);
                        flag = true; break; 
                    };

                if(!flag) {
                    //System.out.println("Dodaję gminę '"+gmina+"'");
                    powiats.get(currentPowiat).gminas.add(new Gmina(gmina));
                    currentGmina = powiats.get(currentPowiat).gminas.size()-1;
                }
            } //else System.out.println("Aktualna gmina pasuje!");
            
            //zabytek
            Monument m = new Monument(id, name, number, gmina, town, street, partOf);
            powiats.get(currentPowiat).gminas.get(currentGmina).add(m);
        }
        

        for(Powiat p : powiats) log.log(p.show());
        
        workbook.close();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code ">
        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bStart;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lFile;
    private javax.swing.JTextPane loger;
    private javax.swing.JTextField tFile;
    // End of variables declaration//GEN-END:variables
}
