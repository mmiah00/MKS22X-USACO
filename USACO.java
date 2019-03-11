import java.util.*;
import java.io.*;
import java.util.Scanner;

public class USACO {
  public static int bronze(String filename){
    try {
      int[][] field;
      MakeLake a = new MakeLake (pasture (filename), sizes(filename)[2], instructions (filename));
      field = a.execute ();
      return sum (field) * 72 * 72;
    } catch (FileNotFoundException e) {
      return -1;
    }
    //them sum the numbers and multiply by 72 * 72
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

  private static int sum (int[][] depths) {
    int ans = 0;
    for (int y = 0; y < depths.length; y ++) {
      for (int x = 0; x < depths[y].length; x ++) {
        ans += depths [y][x];
      }
    }
    return ans;
  }

  /************************************************************************************************************************/
  public static int silver(String filename) {
    try {
      return solve (filename);
    }catch (FileNotFoundException e) {
      return -1;
    }
  }

  private static int[] nmt (String filename) throws FileNotFoundException {
    ArrayList <String> file = readFile (filename);
    String firstLine = file.get (0);
    String [] nums = firstLine.split (" ");
    int []  sizes = new int [3];
    for (int i = 0; i < 3; i ++) {
      sizes[i] = Integer.parseInt (nums[i]);
    }
    return sizes;
  }

  private static char [][] field (String filename) throws FileNotFoundException {
    char [][] pasture = new char [nmt (filename)[0]] [nmt (filename)[1]];
    ArrayList <String> lines = readFile (filename);
    ArrayList <String> field = new ArrayList <String> ();
    for (int i = 1; i <= nmt (filename)[0]; i ++) {
      field.add (lines.get (i));
    }

    int index = 0; //keeps track of index of pasture
    for (int i = 0; i < field.size (); i ++) {
      String line = field.get (i);
      char[] row = new char [line.length()];
      for (int x = 0; x < line.length (); x ++) {
        row[x] = line.charAt (x);
      }
      pasture[index] = row; //add this row to pasture
      index ++;
    }
    return pasture;
  }

  private static int[][] cowsCors (String filename) throws FileNotFoundException {
    int[][] coordinates = new int[2][2];
    ArrayList <String> lines = readFile (filename);
    String lastLine = lines.get (lines.size () - 1);
    String [] nums = lastLine.split (" ");
    coordinates[0][0] = Integer.parseInt (nums[0]);
    coordinates [0][1] = Integer.parseInt (nums[1]);
    coordinates[1][0] = Integer.parseInt (nums[2]);
    coordinates [1][1] = Integer.parseInt (nums[3]);
    return coordinates;
  }

  private static int solve (String filename ) throws FileNotFoundException {
    char [][] field = field (filename);
    int [] start = cowsCors (filename)[0];
    int steps = nmt (filename)[2];
    return help (filename, field, start[0], start[1], steps);
  }

  private static int help (String f, char [][] pasture, int y, int x, int steps) throws FileNotFoundException{
    int [] end = cowsCors (f) [1];
    int ans = 0;
    if (steps == 0 && y == end[0] && x == end [1]) {
      return 1;
    }
    else {
      if (onBoard (pasture, y + 1, x)) {
        if (pasture[y + 1][x] != '*') {
          ans += help (f, pasture, y + 1, x, steps - 1);
        }
      }
      if (onBoard (pasture, y - 1, x)) {
        if (pasture[y - 1][x] != '*') {
          ans += help (f, pasture, y - 1, x, steps - 1);
        }
      }
      if (onBoard (pasture, y, x + 1)) {
        if (pasture[y][x + 1] != '*') {
          ans += help (f, pasture, y, x + 1, steps - 1);
        }
      }
      if (onBoard (pasture, y, x - 1)) {
        if (pasture[y + 1][x] != '*') {
          ans += help (f, pasture, y, x - 1, steps - 1);
        }
      }
      return ans;
    }
  }

  private static boolean onBoard (char[][] board, int y, int x) {
    return (y < board.length && y > 0 && x < board[y].length && x > 0);
  }

  private static String toString (int [] s) {
    String ans = "";
    for (int x = 0; x < s.length; x ++) {
      ans += s[x] + " ";
    }
    return ans;
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

  private static String toString (char[][] s) {
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
      //MakeLake a = new MakeLake (pasture ("makelake.in"), sizes("makelake.in")[2], instructions ("makelake.in"));
      //System.out.println (sum (a.execute ()));
      System.out.println (toString (nmt ("ctravel.1.in")));
      System.out.println (toString (field ("ctravel.1.in")));
      System.out.println (toString (cowsCors ("ctravel.1.in")));
    }
    catch (FileNotFoundException e) {
      System.out.println ("file not found");
    }
  }
}
