import Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToe {
    Deque<Player> players;
    Board gameBoard;

    public TicTacToe(){
        initializeGame();
    }

    private void initializeGame(){
        //create 2 players
        PlayingPiece playingPiece1 = new PlayingPieceO();
        Player player1 = new Player("sagar",playingPiece1);

        PlayingPiece playingPiece2 = new PlayingPieceX();
        Player player2 = new Player("sushant",playingPiece2);

        players = new LinkedList<>();
        players.add(player1);
        players.add(player2);

        //initialize board
        gameBoard = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;
        while(noWinner){
            //get free spaces from board
            gameBoard.printBoard();
            int freeCells = gameBoard.getFreeSpaces();
            if(freeCells==0){
                noWinner=false;
                continue;
            }

            //get the player whose turn it is
            Player currPlayer = players.removeFirst();
            //take the input
            System.out.println("Player: "+ currPlayer.name + "Enter row, column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            //place the piece
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow,inputColumn,currPlayer.playingPiece);
            if(!pieceAddedSuccessfully){
                System.out.println("Incorrect position chosen, please try again!");
                players.addFirst(currPlayer);
                continue;
            }
            players.addLast(currPlayer);

            //check if winner is concluded
            boolean winner = isThereWinner(inputRow,inputColumn,currPlayer.playingPiece.pieceType);
            if(winner){
                return currPlayer.name;
            }
        }
        return "Tie";
    }

    private boolean isThereWinner(int row, int col, PieceType pieceType){


        boolean rowCheck = true;
        boolean colCheck = true;
        boolean leftDiagonal = true;
        boolean rightDiagonal = true;

        //row check
        //column check
        for(int i=0;i< gameBoard.size;i++){
            if(gameBoard.board[row][i]==null || gameBoard.board[row][i].pieceType != pieceType)rowCheck = false;
            if(gameBoard.board[i][col]==null || gameBoard.board[i][col].pieceType != pieceType)colCheck = false;
        }

        //top left diagonal check
        for(int i=0,j=0;i<gameBoard.size;i++,j++){
            if(gameBoard.board[i][j]==null || gameBoard.board[i][j].pieceType != pieceType)leftDiagonal = false;
        }
        //top right diagonal check
        for(int i=0,j=gameBoard.size-1;i<gameBoard.size;i++,j--){
            if(gameBoard.board[i][j]==null || gameBoard.board[i][j].pieceType != pieceType)rightDiagonal = false;
        }

        return rowCheck | colCheck | leftDiagonal | rightDiagonal;
    }
}
