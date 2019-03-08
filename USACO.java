import java.util.*;
import java.io.*;
import java.util.Scanner;

public class USACO {
  public static int bronze(String filename){
    return 1;
  }

  private static int [] sizes (String filename) throws FileNotFoundException {
    ArrayList <String> instructions = readFile (filename);
    //String [] sizes = new String [4];
    String firstLine = instructions.get (0);
    String[] nums = firstLine.split (" ");
    int [] sizes = new int [4];
    for (int i = 0; i < 4; i ++) {
      sizes[i] = Integer.parseInt (nums[i]);
    }
    return sizes;
  }

  private static ArrayList<String> readFile (String filename) throws FileNotFoundException {
    File f = new File (filename);
    Scanner inf = new Scanner (f);
    ArrayList <String> lines = new ArrayList <String> ();
    while (inf.hasNextLine ()) {
      String line = inf.nextLine();
      lines.add (line);
    }
    return lines;
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
    //toString (instructions ("makelake.in"));
    try {
      toString (sizes("makelake.in"));
    }
    catch (Exception e) {
      System.out.println ("file not found");
    }
  }
}
