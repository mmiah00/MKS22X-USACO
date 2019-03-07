import java.util.*;
import java.io.*;

public class USACO {
  public static int bronze(String filename){
    return 1;
  }

  private static int [] instructions (String filename) {
    int[] n = new int[4];
    Scanner inf = new Scanner (filename);
    n[0] = inf.nextInt ();
    n[1] = inf.nextInt ();
    n[2] = inf.nextInt ();
    n[3] = inf.nextInt ();
    inf.close ();
    return n;
  }

  private ArrayList<String> readFile (String filename) {
    Scanner inf = new Scanner (filename);
    while (inf.hasNextLine ()) {
      String line = inf.nextLine ();
    }
    return new ArrayList <String> ();
  }

  public static int silver(String filename) {
    return 1;
  }

  public static void toString (int [] s) {
    String ans = "";
    for (int x = 0; x < s.length; x ++) {
      System.out.println (s[x]);
    }
  }

  public static void main (String[] args) {
    toString (instructions ("makelake.in"));
  }
}
