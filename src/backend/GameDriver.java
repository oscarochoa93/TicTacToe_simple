package backend;

import backend.ArbolG;
import backend.Player;
import frontend.Menu;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.JLabel;

/**
 *
 * @author pride
 */
public class GameDriver {
    public Menu menu;
    public Player player1, player2;
    public ArbolG cpu;
    public boolean jugando, finish;
    public final int MENvsMEN = 1;
    public final int MENvsCPU = 2;
    public final int PLAYER1 = 1;
    public final int PLAYER2 = 2;
    public boolean PENSANDO = false;
    public int turn = 0;
    public int generalTurn = 0;
    public int[] board = new int[9];
    JLabel[] chips;

    public GameDriver() {
        Arrays.fill(board,0);
    }
    
    public JLabel[] suspenderJuego(JLabel chips[]){
        //Llenamos el board con 0s*/
        Arrays.fill(board,0);
        /*Borramos los iconos.*/
        for ( int i = 0; i < 9; i ++ ){
            chips[i].setText(null);
        }
        /*Reinciamos el turn.*/
        turn = 1;
        jugando = false;
        finish = false;
        /*Borramos jugadores.*/
        player1 = null;
        player2 = null;
        return chips;
    }
    public JLabel[] putChipCPU( int index,JLabel chips[]){
        if( index == -1 ) System.out.println("aquo lo del -1");; 
        switch ( index ){
            case 0: chips[0].setText( player2.getChip() );chips[0].setForeground(Color.RED); break;
            case 1: chips[1].setText( player2.getChip() );chips[1].setForeground(Color.RED); break;
            case 2: chips[2].setText( player2.getChip() );chips[2].setForeground(Color.RED);break;
            case 3: chips[3].setText( player2.getChip() );chips[3].setForeground(Color.RED); break;
            case 4: chips[4].setText( player2.getChip() );chips[4].setForeground(Color.RED) ;break;
            case 5: chips[5].setText( player2.getChip() );chips[5].setForeground(Color.RED); break;
            case 6: chips[6].setText( player2.getChip() );chips[6].setForeground(Color.RED); break;
            case 7: chips[7].setText( player2.getChip() );chips[7].setForeground(Color.RED);break;
            case 8: chips[8].setText( player2.getChip() );chips[8].setForeground(Color.RED); break;        
        }
        this.board[index] = 2;
        
        /*Cambiamos el turn.*/
        turn = ( turn == PLAYER1 ) ? PLAYER2 : PLAYER1;
      return chips;
    }
    public boolean estaOcupada( int casilla ){
        return ( board[casilla] != 0 );
    }
    public void putChip( JLabel chip ){
        int casilla = Integer.parseInt(""+chip.getName().charAt(1)) - 1;
        if ( estaOcupada(casilla ) ){
            return;
        }
        if ( turn == PLAYER1 ){
            chip.setText( player1.getChip() );
            chip.setForeground(Color.BLUE);
        }else{
            chip.setText( player2.getChip() );
            chip.setForeground(Color.RED);
        }//---end if
        board[casilla] = turn;
        
        /*Cambiamos el turn.*/
        turn =( turn == PLAYER1 ) ? PLAYER2 : PLAYER1;
    }
    public int finish(){
        //---Filas
        if ( board[0] == board[1] && board[0] == board[2] && board[0] != 0 )
            return board[0];
        else if ( board[3] == board[4] && board[3] == board[5]  && board[3] != 0  )
            return board[3];
        else if ( board[6] == board[7] && board[6]== board[8]  && board[6] != 0 )
            return board[6];
        //---Columnas
        else if( board[0] == board[3] && board[0] == board[6]  && board[0] != 0 )
            return board[0];
        else if ( board[1] == board[4] && board[1] == board[7]  && board[1] != 0)
            return board[1];
        else if ( board[2] == board[5] && board[2] == board[8]  && board[2] != 0 )
            return board[2];
        //---Diagonales
        else if ( board[0] == board[4] && board[0] == board[8] && board[0] !=0 )
            return board[0];
        else if ( board[2] == board[4] && board[2] == board[6] && board[2] != 0 )
            return board[2];
        
        return 0;
        
    }
    public boolean lleno(){
        boolean res = true;
        for ( int i = 0; i < board.length; i ++ ){
            if ( board[i] == 0 ){
                res = false;
            }
        }
        return res;
    }
    public void iniciarJuego(JLabel[] chips){
        Arrays.fill(board,0);
        for ( int i = 0; i < 9; i ++ ){
            chips[i].setText(null);
        }
        if ( menu.gameType == MENvsMEN ){
            this.player1 = new Player( menu.nombre1, "O" );
            this.player2 = new Player( menu.nombre2, "X");
        } else {
            this.player1 = new Player( menu.nombre1, "O" );
            this.player2 = new Player ( "Computadora", "X");
            cpu = new ArbolG();
        }
        this.turn = 1;
        this.generalTurn = PLAYER1;
        jugando = true;
        finish = false;
    }
    
    public void restartGame(JLabel [] chips){
        Arrays.fill(board,0);
        for ( int i = 0; i < 9; i ++ ){
            chips[i].setText(null);
        }
        if ( this.menu.gameType == MENvsCPU ){
            generalTurn = PLAYER1;
        }else{
            generalTurn = ( generalTurn == PLAYER1 ) ? PLAYER2 : PLAYER1;
        }
        turn = generalTurn;
        jugando = true;
        finish = false;
    }
}
