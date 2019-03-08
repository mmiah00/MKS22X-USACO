import java.util.*;
import java.io.*;
import java.util.Scanner;

public class USACO {
  public static int bronze(String filename){
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

  public static int silver(String filename) {
    return 1;
  }

  private static void toString (int [] s) {
    String ans = "";
    for (int x = 0; x < s.length; x ++) {
      System.out.println (s[x]);
    }
  }

  public static void main (String[] args) {
    //toString (instructions ("makelake.in"));
    try {
      for (int i = 0; i < instructions ("makelake.in").size(); i ++) {
        toString (instructions ("makelake.in").get (i));
      }
      //toString (sizes ("makelake.in"));
    }
    catch (FileNotFoundException e) {
      System.out.println ("file not found");
    }
  }
}
