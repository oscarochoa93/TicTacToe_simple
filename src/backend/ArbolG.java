package backend;

/**
 *
 * @author pride
 */
public class ArbolG {
      
    public static int tiradas = 0;
    NodoG arbol = new NodoG();
    int[] board;
    
    public int movDisponibles( int[] board ){
        int mov = 0;
        for ( int i = 0; i < 9; i ++ ){
            if ( board[i] == 0 ){
                mov++;
            }
        }
        return mov;
    }
    
    public int[] posVacias( int[] board ){
        int[] indices = new int[movDisponibles(board)];
        int indice = 0;
        
        for ( int i = 0; i < 9; i ++ ){
            if ( board[i] == 0 ){
                indices[indice] = i;
                indice++;
            }
        }
        return indices;
    }
    
    public int movimiento( int[] board ){
        this.board = board;
        tiradas ++;
        
        for ( int i = 0; i < 9; i ++ ){
            this.arbol.board[i] = this.board[i];
        }
        movCPU( arbol );
        
        return arbol.bestMove;
    }

    public void movCPU( NodoG root ){
        int moves = movDisponibles(root.board);
        int indices[] = posVacias(root.board);
        root.nodos = new NodoG[moves];
        
        int winner = finish(root.board);
        if ( winner == 1 ) winner = -1;
        else if ( winner == 2 ) winner = 1;
  
        if ( winner!= 0 || moves == 0){
            root.winner = winner;
        }else{
            for( int i = 0; i < moves; i ++ ){
                root.nodos[i] = new NodoG();
                for ( int j = 0; j < 9; j ++ ){
                    root.nodos[i].board[j] = root.board[j];
                    if ( root.myTurn ){
                        root.nodos[i].board[indices[i]] = 1;
                    }else{
                        root.nodos[i].board[indices[i]] = 2;
                    }
                }
                root.nodos[i].myTurn = !root.myTurn;
                root.nodos[i].index = indices[i];
                movCPU(root.nodos[i]); 
            }
            if (!root.myTurn){
                root.winner = Max(root);
            }else{
                root.winner = Min(root);
            }
       }    

    }
   
    public int Max( NodoG root ){
        int Max = -111;
        for (int i = 0; i < root.nodos.length; i++){
            if (root.nodos[i].winner > Max){
                Max = root.nodos[i].winner;
                root.bestMove = root.nodos[i].index;
                if (Max == 1) break;
            }
         }
        root.nodos = null;
        
        return Max;
    }
    
    public int Min( NodoG root ){
        int Min = 111;
        for (int i = 0; i < root.nodos.length; i++)
          if (root.nodos[i].winner < Min ){
            Min = root.nodos[i].winner;
            root.bestMove = root.nodos[i].index;
            if (Min == -1) break;
          }
        root.nodos = null;
        
        return Min;
    }
                
    public int finish( int[] board ){
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
        else if ( board[1] == board[4] && board[1] == board[7]  && board[1] != 0  )
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
}
