import java.util.*;
import java.io.*;
import java.util.Scanner;

public class USACO {
  public static int bronze(String filename){
    /*
    MakeLake a = new MakeLake (pasture (filename), sizes(filename)[2], instructions (filename));
    pasture = a.execute ();
    //them sum the numbers and multiply by 72 * 72
    */
    return 1;
  }

  private static ArrayList<String> readFile (String filename) throws FileNotFoundException { //creates an arrayList of all the lines in the file
    File f = new File (filename);
    Scanner inf = new Scanner (f);
    ArrayList <String> lines = new ArrayList <String> ();
    while (inf.hasNextLine ()) {
      String line = inf.nextLine();
      lines.add (line);
    }
    return lines;
  }

  private static int [] sizes (String filename) throws FileNotFoundException { //turns the first line into a int array
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

  private static ArrayList <int []> instructions (String filename) throws FileNotFoundException { //returns an arrayList of int[] that has each line of instructions
    int numInstructions = sizes(filename)[3];
    ArrayList <String> lines = readFile (filename);
    ArrayList <int []> instructions = new ArrayList <int[]> ();
    for (int i = lines.size () - numInstructions; i < lines.size (); i ++) { //starting from the first line of instructions
      String temp = lines.get (i); //the line
      String [] params = temp.split (" "); //splitting line to get the 3 numbers
      int [] stomps = new int [3]; // the int[] of the numbers
      for (int l = 0; l < 3; l ++) {
        stomps[l] = Integer.parseInt (params[l]); //parsing through to make the string into ints
      }
      instructions.add (stomps); //add that int[] to the instructions
    }
    return instructions;
  }

  private static int[][] pasture (String filename) throws FileNotFoundException {
    int [][] pasture = new int [sizes(filename)[0]] [sizes (filename)[1]];
    ArrayList <String> lines = readFile (filename);
    ArrayList <String> field = new ArrayList <String> (); // only the lines with the depths
    for (int i = 1; i <= sizes (filename)[0]; i ++) {
      field.add (lines.get (i));
    }

    int index = 0; //keeps track of index of pasture
    for (int i = 0; i < field.size (); i ++) {
      String line = field.get (i);
      String[] depths = line.split (" "); //splits the string into the numbers
      int [] row = new int [sizes(filename)[1]]; //makes a int[] size c
      for (int x = 0; x < row.length; x ++) {
        row [x] = Integer.parseInt (depths[x]); //parses through each string to make them into ints
      }
      pasture[index] = row; //add this row to pasture
      index ++;
    }
    return pasture;
  }

  /************************************************************************************************************************/
  public static int silver(String filename) {
    return 1;
  }

  private static void toString (int [] s) {
    String ans = "";
    for (int x = 0; x < s.length; x ++) {
      System.out.println (s[x]);
    }
  }

  private static String toString (int[][] s) {
    String ans = "";
    for (int y = 0; y < s.length; y ++) {
      for (int x = 0; x < s[y].length; x ++) {
        ans += s[y][x] + " ";
        if (x == s[y].length - 1)  {
          ans += "\n";
        }
      }
    }
    return ans;
  }

  public static void main (String[] args) {
    //toString (instructions ("makelake.in"));
    try {
      /*
      for (int i = 0; i < instructions ("makelake.in").size(); i ++) {
        toString (instructions ("makelake.in").get (i));
      }
      */
      //System.out.println (toString (pasture ("makelake.1.in")));
      MakeLake a = new MakeLake (pasture ("makelake.in"), sizes("makelake.in")[2], instructions ("makelake.in"));
      a.stomp (instructions ("makelake.in").get (0)[0], instructions ("makelake.in").get (0)[1], instructions ("makelake.in").get (0)[2]);
      System.out.println (a.toString ());
      //toString (sizes ("makelake.in"));
    }
    catch (FileNotFoundException e) {
      System.out.println ("file not found");
    }
  }
}
