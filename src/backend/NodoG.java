package backend;

/**
 *
 * @author pride
 */
public class NodoG {
        int bestMove;
        NodoG nodos[];
        public int board[];
        boolean myTurn = false;
        int index;
        int winner = 0;

       public NodoG(){
            board = new int[9];
        }
}
