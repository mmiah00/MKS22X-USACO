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
    int i = 0; //lines in file
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

  public String toString () {
    String ans = "";
    for (int r = 0; r < pasture.length; r ++) {
      for (int c = 0; c < pasture[r].length; c ++) {
        ans += pasture [r][c];
        if (c == pasture[r].length - 1)  {
          ans += "\n";
        }
      }
    }
    return ans;
  }

  public static void main (String[] args) {
    MakeLake test = new MakeLake ("makelake.in", 4,6,22, 2);
    test.toString ();

  }

}
