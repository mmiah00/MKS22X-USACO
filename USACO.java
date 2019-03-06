import java.util.*;
import java.io.*;

public class USACO {

  public static int bronze(String filename){
    return 1;
  }

  private class makeLake {
    private int elevation;
    private int numInstructions;
    private int[][] pasture;

    public makeLake (int r, int c, int e, int n) {
      pasture = new int [r][c];
      elevation = e;
      numInstructions = n;
    }


  }

  public static int silver(String filename) {
    return 1;
  }

  private ArrayList <String> readFile  (String filename) {
    Scanner inf = new Scanner (filename);
    while (inf.hasNextLine ()) {
      String line = inf.nextLine ();
    }
    return new ArrayList <String> ();
  }

}
