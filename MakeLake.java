import java.util.*;
import java.io.*;

public class MakeLake {
  private int elevation;
  private int numInstructions;
  private int[][] pasture;

  public MakeLake (String f, int r, int c, int e, int n) {
    pasture = new int [r][c];
    elevation = e;
    numInstructions = n;
    makePasture (f); 
  }

  private void makePasture (String filename) {
    Scanner inf = new Scanner (filename);
    int i = 0;
    int x = 0; // pasture rows
    while (inf.hasNextLine ()) {
      if (i != 0) {
        String line = inf.nextLine ();
        for (int y = 0; y < line.length(); y ++) {
          pasture [x][y] = (int) line.charAt (y);
        }
        x ++;
      }
      i ++;
    }
  }
}
