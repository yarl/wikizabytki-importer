package pl.wikizabytki;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File; 
import java.io.IOException;
import java.util.ArrayList;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import jxl.*; 
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import jxl.read.biff.BiffException;
import org.wikipedia.Wiki;
import pl.wikizabytki.classes.Gmina;
import pl.wikizabytki.classes.Monument;
import pl.wikizabytki.classes.Powiat;

public class Main extends javax.swing.JFrame {
    public static Log log;
    
    public static ArrayList<Powiat> powiats = new ArrayList<>();
    public static String VOIV;
    public static String VOIV_CODE;
    public static Wiki wiki = new Wiki("pl.wikipedia.org");
    
    public static DefaultMutableTreeNode top = new DefaultMutableTreeNode("(woj)");
    public static DefaultTreeModel model = new DefaultTreeModel(top);
    
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        log = new Log(loger);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        loger = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        tFile = new javax.swing.JTextField();
        bLoad = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tLogin = new javax.swing.JTextField();
        tPassword = new javax.swing.JPasswordField();
        bLogin = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        bTree = new javax.swing.JButton();
        bStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setViewportView(loger);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Path to XLS file"));

        tFile.setText("C:\\Users\\Pawel\\Dropbox\\Wiki\\Wiki Lubi Zabytki\\Listy\\dolnoslaskie.xls");

        bLoad.setText("Load");
        bLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tFile, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bLoad)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tFile, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bLoad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));

        tLogin.setText("YarluBot");

        bLogin.setText("Log in");
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(tPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bLogin)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bLogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tree.setModel(model);
        jScrollPane1.setViewportView(tree);

        bTree.setText("Load tree");
        bTree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTreeActionPerformed(evt);
            }
        });

        bStart.setText("<html><b>Upload to wiki</b></html>");
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bStart, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bTree, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTree)
                    .addComponent(bStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartActionPerformed
        uploadWiki();
    }//GEN-LAST:event_bStartActionPerformed

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
        try {
            wiki.login(tLogin.getText(), tPassword.getPassword());
            log.green(wiki.getDomain() + ": logged in\n");
        } catch (IOException | FailedLoginException ex) {
            log.red(ex.getLocalizedMessage() + "\n");
        }
    }//GEN-LAST:event_bLoginActionPerformed

    private void bLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadActionPerformed
        loadXLS(tFile.getText());
    }//GEN-LAST:event_bLoadActionPerformed

    private void bTreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTreeActionPerformed
        loadTree();
    }//GEN-LAST:event_bTreeActionPerformed

    private void loadXLS(String path) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                //@source: http://stackoverflow.com/a/7451775
                WorkbookSettings workbookSettings = new WorkbookSettings();
                workbookSettings.setEncoding("Cp1250");

                Workbook workbook = null;
                try {
                    workbook = Workbook.getWorkbook(new File(tFile.getText()), workbookSettings);
                } catch (IOException | BiffException ex) {
                    log.red("Something wrong with file!\n");
                }
                Sheet sheet = workbook.getSheet(0);
                log.log("\nFile: loading content...\n");

                int currentPowiat = 0;
                int currentGmina = 0;

                VOIV = sheet.getCell(1,1).getContents();
                switch(VOIV){
                    case "dolnośląskie": VOIV_CODE = "PL-DS"; break;
                    case "kujawsko-pomorskie": VOIV_CODE = "PL-KP"; break;
                    case "lubelskie": VOIV_CODE = "PL-LU"; break;
                    case "lubuskie": VOIV_CODE = "PL-LB"; break;
                    case "łódzkie": VOIV_CODE = "PL-LD"; break;
                    case "małopolskie": VOIV_CODE = "PL-MA"; break;
                    case "mazowieckie": VOIV_CODE = "PL-MZ"; break;
                    case "opolskie": VOIV_CODE = "PL-OP"; break;
                    case "podkarpackie": VOIV_CODE = "PL-PK"; break;
                    case "podlaskie": VOIV_CODE = "PL-PD"; break;
                    case "pomorskie": VOIV_CODE = "PL-PM"; break;
                    case "śląskie": VOIV_CODE = "PL-SL"; break;
                    case "świętokrzyskie": VOIV_CODE = "PL-SK"; break;
                    case "warmińsko-mazurskie": VOIV_CODE = "PL-WN"; break;
                    case "wielkopolskie": VOIV_CODE = "PL-WP"; break;
                    case "zachodniopomorskie": VOIV_CODE = "PL-ZP"; break;
                    default: VOIV_CODE = "??";
                }

                //if default stop

                for(int i=1; i<sheet.getColumn(0).length; ++i) {
                    String id = sheet.getCell(0,i).getContents();
                    String powiat = sheet.getCell(2,i).getContents();
                    String gmina = sheet.getCell(3,i).getContents();
                    String town = sheet.getCell(4,i).getContents();
                    String name = sheet.getCell(5,i).getContents();
                    String hint = sheet.getCell(6,i).getContents();
                    String street = sheet.getCell(7,i).getContents();
                    int partOf = (sheet.getCell(9,i).getContents().isEmpty()) ? 1 : Integer.parseInt(sheet.getCell(9,i).getContents());
                    String material = sheet.getCell(10,i).getContents();
                    String date = sheet.getCell(11,i).getContents();
                    String number = sheet.getCell(12,i).getContents();

                    //fixes
                    if(gmina.endsWith(" - gm."))
                        gmina = gmina.substring(0, gmina.indexOf(" - gm."));

                    if(gmina.endsWith(" - m."))
                        gmina = gmina.substring(0, gmina.indexOf(" - m."));

                    if(gmina.startsWith("M. "))
                        gmina = gmina.substring(3);
                    else if(!powiat.startsWith("m. "))
                        gmina = "gmina " + gmina;

                    if(powiat.startsWith("m. "))
                        powiat = powiat.substring(3);
                    else
                        powiat = "powiat " + powiat;

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
                            currentGmina = 0;
                        }
                    } //else System.out.println("Aktualny powiat pasuje!");

                    //gmina
                    if(powiats.get(currentPowiat).gminas.isEmpty()) 
                        powiats.get(currentPowiat).gminas.add(new Gmina(gmina, currentPowiat));

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
                            powiats.get(currentPowiat).gminas.add(new Gmina(gmina, currentPowiat));
                            currentGmina = powiats.get(currentPowiat).gminas.size()-1;
                        }
                    } //else System.out.println("Aktualna gmina pasuje!");

                    //zabytek
                    Monument m = new Monument(id, name, number, gmina, town, street, partOf, hint, date);
                    powiats.get(currentPowiat).gminas.get(currentGmina).add(m);
                }
                log.log("File: loading done\n\n");
                workbook.close();
            }
        };
        Thread t = new Thread(run);
        t.start();
    }
    
    public void loadTree() {
        log.log("\nTree: loading...\n");
        for(Powiat p : powiats) p.createTree();
        log.log("Tree: loading done\n\n");
    }
    
    public void uploadWiki() {
        String text = "";
        for(Powiat p : powiats) text += "* [[/" + p.name + "]]\n";
        
        try {
            Main.wiki.edit("Wikipedia:Wiki Lubi Zabytki/" + Main.VOIV, text, "import zabytków");
            Main.log.green(Main.VOIV + ": uploaded!\n");
            for(Powiat p : powiats) p.uploadWiki();
        } catch (IOException | LoginException ex) {
            Main.log.red(ex.getLocalizedMessage() + "\n");
        }
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
    private javax.swing.JButton bLoad;
    private javax.swing.JButton bLogin;
    private javax.swing.JButton bStart;
    private javax.swing.JButton bTree;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane loger;
    private javax.swing.JTextField tFile;
    private javax.swing.JTextField tLogin;
    private javax.swing.JPasswordField tPassword;
    public static javax.swing.JTree tree;
    // End of variables declaration//GEN-END:variables
}
