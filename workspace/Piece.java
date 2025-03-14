





import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Piece {
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
        
        try {
            if (this.img == null) {
              this.img = ImageIO.read(getClass().getResource(img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(img.getScaledInstance(50, 50, Image.SCALE_DEFAULT), x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
      ArrayList<Square> controlledSquares = new ArrayList<>();

      if (start.getCol() + 1 < 8) {
          controlledSquares.add(board[start.getRow()][start.getCol() + 1]);
      }

      return controlledSquares;
  }

    
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.
    public ArrayList<Square> getLegalMoves(Board b, Square start){
    	ArrayList<Square> moves = new ArrayList<>();

        // Ensure moves stay within bounds and check for capture opportunities
        if (start.getCol() + 1 < 8) {
            moves.add(b.getSquareArray()[start.getRow()][start.getCol() + 1]);
        }

        int row = start.getRow();
        int col = start.getCol();
    
     
            // Move Right
    if (col + 1 < 8 && b.getSquareArray()[row][col + 1].getOccupyingPiece() == null) {
        moves.add(b.getSquareArray()[row][col + 1]);
    }

    // Move Left
    if (col - 1 >= 0 && b.getSquareArray()[row][col - 1].getOccupyingPiece() == null) {
        moves.add(b.getSquareArray()[row][col - 1]);
    }

    // Move Up
    if (row - 1 >= 0 && b.getSquareArray()[row - 1][col].getOccupyingPiece() == null) {
        moves.add(b.getSquareArray()[row - 1][col]);
    }

    // Move Down
    if (row + 1 < 8 && b.getSquareArray()[row + 1][col].getOccupyingPiece() == null) {
        moves.add(b.getSquareArray()[row + 1][col]);
    }

  
        return moves;
    }
    
       
    }
