package frontend;

import javax.swing.JOptionPane;

/**
 *
 * @author pride
 */
public class Menu extends javax.swing.JDialog {

    public String nombre1, nombre2;
    private MainView view;
    private JOptionPane mensaje;
    public final int MENvsMEN = 1;
    public final int MENvsCPU = 2;
    public int gameType = 0;
    public String difficulty;
    
    
    public Menu(MainView view) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.view=view;
        mensaje = new JOptionPane();
        this.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbP2 = new javax.swing.JComboBox<>();
        cmbP1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbDif = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbP2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPU", "Person" }));

        cmbP1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Person", "CPU" }));

        jLabel1.setText("Player 1");

        jLabel2.setText("Player 2");

        cmbDif.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Low", "Medium", "High" }));

        jLabel3.setText("Difficulty:");

        btn.setText("Accept");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cmbDif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(cmbP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cmbDif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
       /* Rules rule = new Rules(cmbP1.getSelectedItem().toString(),cmbP2.getSelectedItem().toString(),cmbDif.getSelectedItem().toString()); 
        JOptionPane.showMessageDialog(null, rule.toString());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });*/
        
        
        if( recojer() ){
            enviarModelo();
            dispose();
        }
         
         this.dispose();
    }//GEN-LAST:event_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JComboBox<String> cmbDif;
    private javax.swing.JComboBox<String> cmbP1;
    private javax.swing.JComboBox<String> cmbP2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
public boolean recojer(){

        if( this.cmbP1.getSelectedItem().toString().equals("") ){
            mensaje.showMessageDialog(this,"Llene el nombre del jugador 1 por favor.","[X] Error:",JOptionPane.ERROR_MESSAGE);
            return false;   
        }
        if( this.cmbP2.getSelectedItem().toString().equals("")){
            mensaje.showMessageDialog(this,"Llene el nombre del jugador 2 por favor.","[X] Error:",JOptionPane.ERROR_MESSAGE);
            return false;   
        }
        if( this.cmbP1.getSelectedItem().toString().equals( this.cmbP2.getSelectedItem().toString() )){
            mensaje.showMessageDialog(this,"Escriba nombres diferentes para los jugadores.","[X] Error:",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        System.out.println("seleccionado "+ cmbDif.getSelectedItem().toString());
        
        this.difficulty=cmbDif.getSelectedItem().toString();
        
          //--Vaildar tipo de juego =   this.gameType = ( MENvsMEN == MENvsMEN ) ? MENvsMEN : MENvsCPU;
     this.gameType=2;
      this.nombre1 = "victor";
      this.nombre2 = "Machine";
        
        return true;
    }
    
    public void enviarModelo(){
        view.getMenu();
    }

}
