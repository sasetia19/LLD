package Model;

public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }
    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] == null)System.out.print(" _ ");
                else System.out.print(board[i][j].pieceType+" ");
            }
            System.out.println();
        }
    }
    public int getFreeSpaces(){
        int freeSpaces=0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] == null)freeSpaces++;
            }
        }
        return freeSpaces;
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece){
        if(row>=size || col>=size || board[row][col] != null)return false;

        board[row][col] = playingPiece;
        return true;
    }
}
