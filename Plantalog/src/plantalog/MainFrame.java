
package plantalog;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.imgscalr.Scalr;
import plantalog.models.Plant;
import plantalog.models.PlantImage;
import plantalog.models.Specimen;
import plantalog.models.SpecimenRegion;

/**
 * Handles all user interactions for the business activities
 */
public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cards = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        regionSearchTextField = new javax.swing.JTextField();
        regionFilterButton = new javax.swing.JButton();
        regionSearchResultsPane = new javax.swing.JScrollPane();
        regionSearchResults = new javax.swing.JList();
        plantSearchResultsPane = new javax.swing.JScrollPane();
        plantSearchResults = new javax.swing.JList();
        plantSearchTextField = new javax.swing.JTextField();
        plantFilterButton = new javax.swing.JButton();
        specimenFilterButton = new javax.swing.JButton();
        specimenSearchResultsPane = new javax.swing.JScrollPane();
        specimenSearchResults = new javax.swing.JList();
        mainPanel = new javax.swing.JPanel();
        specimenName = new javax.swing.JLabel();
        specimenNotes = new javax.swing.JLabel();
        plantNotes = new javax.swing.JLabel();
        mainImage = new javax.swing.JLabel();
        ImageListScrollPane = new javax.swing.JScrollPane();
        imagesList = new javax.swing.JList();
        header = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        greeting = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        search = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cards.setLayout(new java.awt.CardLayout());

        loginPanel.setPreferredSize(new java.awt.Dimension(690, 418));
        loginPanel.setRequestFocusEnabled(false);

        usernameLabel.setText("Username");

        passwordLabel.setText("Password");

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        passwordField.setToolTipText("");

        loginButton.setText("Login");
        loginButton.setToolTipText("");
        getRootPane().setDefaultButton(loginButton);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                .addComponent(passwordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(usernameLabel)
                                .addGap(8, 8, 8)))
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameField)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(287, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginButton)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        cards.add(loginPanel, "login");

        regionSearchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regionSearchTextFieldActionPerformed(evt);
            }
        });

        regionFilterButton.setText("Filter");
        regionFilterButton.setToolTipText("");
        regionFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regionFilterButtonActionPerformed(evt);
            }
        });

        regionSearchResults.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        regionSearchResults.setToolTipText("");
        regionSearchResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultOnClick(evt);
            }
        });
        regionSearchResultsPane.setViewportView(regionSearchResults);

        plantSearchResults.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        plantSearchResults.setToolTipText("");
        plantSearchResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plantSearchResultsresultOnClick(evt);
            }
        });
        plantSearchResultsPane.setViewportView(plantSearchResults);

        plantSearchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plantSearchTextFieldActionPerformed(evt);
            }
        });

        plantFilterButton.setText("Filter");
        plantFilterButton.setToolTipText("");
        plantFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plantFilterButtonActionPerformed(evt);
            }
        });

        specimenFilterButton.setText("Load");
        specimenFilterButton.setToolTipText("");
        specimenFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specimenFilterButtonActionPerformed(evt);
            }
        });

        specimenSearchResults.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        specimenSearchResults.setToolTipText("");
        specimenSearchResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                specimenSearchResultsresultOnClick(evt);
            }
        });
        specimenSearchResultsPane.setViewportView(specimenSearchResults);

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(regionSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regionFilterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(plantSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plantFilterButton))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(regionSearchResultsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plantSearchResultsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(specimenSearchResultsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specimenFilterButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(regionSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(regionFilterButton)
                            .addComponent(plantSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(plantFilterButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(regionSearchResultsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(plantSearchResultsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(specimenFilterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(specimenSearchResultsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cards.add(searchPanel, "search");

        mainPanel.setPreferredSize(new java.awt.Dimension(690, 418));

        specimenName.setToolTipText("");

        mainImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainImage.setToolTipText("");
        mainImage.setAlignmentX(0.5F);
        mainImage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        mainImage.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        mainImage.setIconTextGap(0);

        imagesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        imagesList.setToolTipText("");
        imagesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagesListresultOnClick(evt);
            }
        });
        ImageListScrollPane.setViewportView(imagesList);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plantNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specimenName, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specimenNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(ImageListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 178, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(specimenName, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(plantNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(specimenNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(mainImage, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ImageListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cards.add(mainPanel, "main");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plantalog/logo.png"))); // NOI18N

        logoutButton.setText("Logout");
        logoutButton.setVisible(false);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        search.setText("Search New");
        search.setToolTipText("");
        search.setVisible(false);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo)
                .addGap(37, 37, 37)
                .addComponent(search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(greeting, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logoutButton)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo)
                .addContainerGap())
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search)
                    .addComponent(logoutButton)
                    .addComponent(greeting, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regionFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regionFilterButtonActionPerformed
        refreshRegionSearchPane();
        refreshPlantSearchPane();
        refreshSpecimenSearchPane();
    }//GEN-LAST:event_regionFilterButtonActionPerformed
    
    private void resultOnClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultOnClick
        refreshPlantSearchPane();
        refreshSpecimenSearchPane();
    }//GEN-LAST:event_resultOnClick

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        Plantalog.currentUser = DBC.login(username, password);
        if(Plantalog.currentUser != null){
            usernameField.setText("");
            passwordField.setText("");
            greeting.setText("Hello " + Plantalog.currentUser.name);
            setCard("search");
            logoutButton.setVisible(true);
            search.setVisible(true);
            refreshRegionSearchPane();
            refreshPlantSearchPane();
            refreshSpecimenSearchPane();
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void regionSearchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regionSearchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regionSearchTextFieldActionPerformed

    private void plantSearchResultsresultOnClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plantSearchResultsresultOnClick
        refreshSpecimenSearchPane();
    }//GEN-LAST:event_plantSearchResultsresultOnClick

    private void plantSearchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plantSearchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plantSearchTextFieldActionPerformed

    private void plantFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plantFilterButtonActionPerformed
        refreshPlantSearchPane();
        refreshSpecimenSearchPane();
    }//GEN-LAST:event_plantFilterButtonActionPerformed

    private void specimenFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specimenFilterButtonActionPerformed
        Specimen s = (Specimen)this.specimenSearchResults.getSelectedValue();
        if(s != null){
            loadData(s);
            setCard("main");
        }
    }//GEN-LAST:event_specimenFilterButtonActionPerformed

    private void specimenSearchResultsresultOnClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_specimenSearchResultsresultOnClick
        // TODO add your handling code here:
    }//GEN-LAST:event_specimenSearchResultsresultOnClick

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        setCard("search");
    }//GEN-LAST:event_searchActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        Plantalog.currentUser = null;
        logoutButton.setVisible(false);
        search.setVisible(false);
        greeting.setText("");
        setCard("login");
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void imagesListresultOnClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagesListresultOnClick
        PlantImage p = (PlantImage)this.imagesList.getSelectedValue();
        if(p != null)
            loadImage(mainImage, p);
        else
            System.out.println("failed to find image selected");
    }//GEN-LAST:event_imagesListresultOnClick

    /**
     * Load data for a specimen in the main frame
     * 
     * @param s
     */
    private void loadData(Specimen s){
        this.specimenName.setText(s.plant + " " + s.lives_in);
        this.specimenNotes.setText(s.notes);
        this.plantNotes.setText(s.plant.notes);
        if(s.plant.images.size() > 0)
            loadImage(mainImage, s.plant.images.get(0));
        else{
            mainImage.setIcon(null);
            mainImage.setText("No images available");
            
        }
        this.imagesList.setModel(toListModel(s.plant.images));
    }
    
    private void loadImage(JLabel label, PlantImage pi){
        
        label.setText("Loading...");
        label.setIcon(null);
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                BufferedImage i = (BufferedImage)pi.getImage();
                if(i != null){
                    label.setText("");
                    BufferedImage bi = Scalr.resize(i, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH,
                            label.getWidth()-4, label.getHeight()-4, Scalr.OP_ANTIALIAS);
                    label.setIcon(new ImageIcon(bi));
                }else{
                    label.setText("Error Loading Image: Invalid URL");
                }
            }
        });
    }
    
    private void refreshRegionSearchPane(){
        this.regionSearchResults.setModel(toListModel(DBC.getRegions(this.regionSearchTextField.getText())));
    }
    private void refreshPlantSearchPane(){
        this.plantSearchResults.setModel(toListModel(DBC.getPlants(this.plantSearchTextField.getText())));
    }
    private void refreshSpecimenSearchPane(){
        SpecimenRegion r = (SpecimenRegion)this.regionSearchResults.getSelectedValue();
        Plant p = (Plant)this.plantSearchResults.getSelectedValue();
        this.specimenSearchResults.setModel(toListModel(DBC.getSpecimens(r,p)));
    }
    
    private void setCard(String cardname){
        ((CardLayout)this.cards.getLayout()).show(this.cards, cardname);        
    }
    
    private <T> DefaultListModel<T> toListModel(ArrayList<T> list){
        DefaultListModel<T> l = new DefaultListModel();
        for(T t: list)
            l.addElement(t);
        return l;
    }
    public static void start() {
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame m = new MainFrame();
                m.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        DBC.disconnect();
                        System.exit(0);
                    }
                });
                m.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ImageListScrollPane;
    private javax.swing.JPanel cards;
    private javax.swing.JLabel greeting;
    private javax.swing.JPanel header;
    private javax.swing.JList imagesList;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel mainImage;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton plantFilterButton;
    private javax.swing.JLabel plantNotes;
    private javax.swing.JList plantSearchResults;
    private javax.swing.JScrollPane plantSearchResultsPane;
    private javax.swing.JTextField plantSearchTextField;
    private javax.swing.JButton regionFilterButton;
    private javax.swing.JList regionSearchResults;
    private javax.swing.JScrollPane regionSearchResultsPane;
    private javax.swing.JTextField regionSearchTextField;
    private javax.swing.JButton search;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JButton specimenFilterButton;
    private javax.swing.JLabel specimenName;
    private javax.swing.JLabel specimenNotes;
    private javax.swing.JList specimenSearchResults;
    private javax.swing.JScrollPane specimenSearchResultsPane;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
