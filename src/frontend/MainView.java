package frontend;

import backend.GameDriver;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MainView extends javax.swing.JFrame {
   
    
    JLabel chips[];
    GameDriver game;
    boolean flag=false;
    
    public MainView() {
        initComponents();
        init();
        game = new GameDriver();
        
    }
      public void getMenu(){
         game.iniciarJuego(this.chips);
    }
    

    public void control( JLabel chip){
        ArrayList<Integer> list=new ArrayList();
        Random rnd = new Random();
        int result = 0;
        switch (game.menu.difficulty) {
            case "Low":
                if ( game.jugando ){
                    if( ! game.PENSANDO ){
                         game.putChip( chip );
                    }
                    if (  game.menu.gameType ==  game.MENvsCPU &&  game.turn ==  game.PLAYER2 ){
                        for (int i = 0; i < chips.length; i++) { 
                            if (chips[i].getText() == null) {
                                     list.add(i);
                                }
                        } 
                        if (list.size() == 0) {
                            this.lblEstado.setText("Empate");
                            game.jugando = false;
                            game.finish = true;
                            break;
                        }else{
                        result = list.get(rnd.nextInt(list.size()));
                         game.PENSANDO = true;
                         chips = game.putChipCPU(result,chips);
                         game.PENSANDO = false;
                     }
                    }
                }
                if(  game.finish ){
                     game.restartGame(chips);
                     this.lblEstado.setText("");
                    return;
                }
                if (  game.finish() != 0){
                    /*Asignamos resultados.*/
                    if (  game.finish() == 1 ){
                        this.lblEstado.setText( game.player1.name + " gano");
                    }else{
                       this.lblEstado.setText( game.player2.name + " gano");
                    }
                     game.jugando = false;
                     game.finish = true;
                }
                break;
            case "Medium":
                if ( game.jugando ){
                    if( ! game.PENSANDO ){
                         game.putChip( chip );
                    }
                    if (  game.menu.gameType ==  game.MENvsCPU &&  game.turn ==  game.PLAYER2 ){
                        for (int i = 0; i < chips.length; i++) { 
                            if (chips[i].getText() == null) {
                                     list.add(i);
                                }
                        } 
                        if (list.size() == 0) {
                            this.lblEstado.setText("Empate");
                            game.jugando = false;
                            game.finish = true;
                            break;
                        }else{
                        result = list.get(rnd.nextInt(list.size()));
                         game.PENSANDO = true;
                         //---Una vez tira random y la otra con el arbol IA 
                         //---(Combinacion de ambas para nivel Medio)
                            if (!flag) {
                                chips = game.putChipCPU(result,chips);
                                flag=true;
                            }else{
                                chips = game.putChipCPU( game.cpu.movimiento(  game.board ),chips);
                                flag=false;
                            }
                         game.PENSANDO = false;
                     }
                    }
                }
                if(  game.finish ){
                     game.restartGame(chips);
                     this.lblEstado.setText("");
                    return;
                }
                if (  game.finish() != 0){
                    /*Asignamos resultados.*/
                    if (  game.finish() == 1 ){
                        this.lblEstado.setText( game.player1.name + " gano");
                    }else{
                       this.lblEstado.setText( game.player2.name + " gano");
                    }
                     game.jugando = false;
                     game.finish = true;
                }
                break;
            case "High":
                if ( game.jugando ){
                    if( ! game.PENSANDO ){
                         game.putChip( chip );
                    }
                    if (  game.menu.gameType ==  game.MENvsCPU &&  game.turn ==  game.PLAYER2 ){
                         game.PENSANDO = true;
                         chips = game.putChipCPU( game.cpu.movimiento(  game.board ),chips);
                         game.PENSANDO = false;
                    }
                }
                if(  game.finish ){
                     game.restartGame(chips);
                     this.lblEstado.setText("");
                    return;
                }
                if (  game.finish() != 0){

                    /*Asignamos resultados.*/
                    if (  game.finish() == 1 ){
                        this.lblEstado.setText( game.player1.name + " gano");
                    }else{
                       this.lblEstado.setText( game.player2.name + " gano");
                    }
                     game.jugando = false;
                     game.finish = true;

                } else if (  game.lleno() ){
                     this.lblEstado.setText("Empate");
                     game.jugando = false;
                     game.finish = true;
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Algo paso con la dificultad");
        }//---End switch
    }

     public void init(){
        //---Referenciamos todas las etiquetas.
        chips = new JLabel[9];
        chips[0] = f1; chips[1] =f2; chips[2] = f3;
        chips[3] = f4; chips[4] = f5; chips[5] =f6;
        chips[6] = f7; chips[7] = f8; chips[8] = f9;
        for (int j = 0; j < chips.length; j++) {
                   chips[j].setFont(new Font("Arial", Font.PLAIN, 40));
            }
    }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        f1 = new javax.swing.JLabel();
        f2 = new javax.swing.JLabel();
        f3 = new javax.swing.JLabel();
        f4 = new javax.swing.JLabel();
        f5 = new javax.swing.JLabel();
        f6 = new javax.swing.JLabel();
        f7 = new javax.swing.JLabel();
        f8 = new javax.swing.JLabel();
        f9 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        Tablero = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        mnuJuego = new javax.swing.JMenu();
        mnuIniciar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        f1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f1.setName("f1"); // NOI18N
        f1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f1MouseClicked(evt);
            }
        });
        getContentPane().add(f1);
        f1.setBounds(0, 60, 100, 100);

        f2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f2.setName("f2"); // NOI18N
        f2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f2MouseClicked(evt);
            }
        });
        getContentPane().add(f2);
        f2.setBounds(100, 60, 110, 100);

        f3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f3.setName("f3"); // NOI18N
        f3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f3MouseClicked(evt);
            }
        });
        getContentPane().add(f3);
        f3.setBounds(210, 60, 100, 100);

        f4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f4.setName("f4"); // NOI18N
        f4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f4MouseClicked(evt);
            }
        });
        getContentPane().add(f4);
        f4.setBounds(0, 160, 100, 100);

        f5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f5.setName("f5"); // NOI18N
        f5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f5MouseClicked(evt);
            }
        });
        getContentPane().add(f5);
        f5.setBounds(100, 160, 110, 100);

        f6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f6.setName("f6"); // NOI18N
        f6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f6MouseClicked(evt);
            }
        });
        getContentPane().add(f6);
        f6.setBounds(210, 160, 100, 100);

        f7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f7.setName("f7"); // NOI18N
        f7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f7MouseClicked(evt);
            }
        });
        getContentPane().add(f7);
        f7.setBounds(0, 260, 100, 100);

        f8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f8.setName("f8"); // NOI18N
        f8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f8MouseClicked(evt);
            }
        });
        getContentPane().add(f8);
        f8.setBounds(100, 260, 110, 100);

        f9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f9.setName("f9"); // NOI18N
        f9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f9MouseClicked(evt);
            }
        });
        getContentPane().add(f9);
        f9.setBounds(210, 260, 100, 100);

        lblEstado.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(153, 153, 153));
        getContentPane().add(lblEstado);
        lblEstado.setBounds(0, 0, 310, 40);

        Tablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tablero.png"))); // NOI18N
        getContentPane().add(Tablero);
        Tablero.setBounds(0, 10, 320, 400);

        mnuJuego.setText("Juego");

        mnuIniciar.setText("Iniciar nuevo juego");
        mnuIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIniciarActionPerformed(evt);
            }
        });
        mnuJuego.add(mnuIniciar);

        Menu.add(mnuJuego);

        setJMenuBar(Menu);

        getAccessibleContext().setAccessibleName("Victor");

        setSize(new java.awt.Dimension(310, 408));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void mnuIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIniciarActionPerformed
         game.menu = new Menu(this);
    }//GEN-LAST:event_mnuIniciarActionPerformed

    private void f9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f9MouseClicked
        control(f9);
    }//GEN-LAST:event_f9MouseClicked

    private void f8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f8MouseClicked
        control(f8);
    }//GEN-LAST:event_f8MouseClicked

    private void f7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f7MouseClicked
        control(f7);
    }//GEN-LAST:event_f7MouseClicked

    private void f6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f6MouseClicked
        control(f6);
    }//GEN-LAST:event_f6MouseClicked

    private void f5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f5MouseClicked
        control(f5);
    }//GEN-LAST:event_f5MouseClicked

    private void f4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f4MouseClicked
        control(f4);
    }//GEN-LAST:event_f4MouseClicked

    private void f3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f3MouseClicked
        control(f3);
    }//GEN-LAST:event_f3MouseClicked

    private void f2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f2MouseClicked
        control(f2);
    }//GEN-LAST:event_f2MouseClicked

    private void f1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f1MouseClicked
        control(f1);
    }//GEN-LAST:event_f1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menu;
    private javax.swing.JLabel Tablero;
    private javax.swing.JLabel f1;
    private javax.swing.JLabel f2;
    private javax.swing.JLabel f3;
    private javax.swing.JLabel f4;
    private javax.swing.JLabel f5;
    private javax.swing.JLabel f6;
    private javax.swing.JLabel f7;
    private javax.swing.JLabel f8;
    private javax.swing.JLabel f9;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JMenuItem mnuIniciar;
    private javax.swing.JMenu mnuJuego;
    // End of variables declaration//GEN-END:variables
     public static void main(String args[]) {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainView dialog = new MainView();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
     
     
}
