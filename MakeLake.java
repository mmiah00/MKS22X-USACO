import java.util.*;
import java.io.*;

public class MakeLake {
  private int elevation;
  private ArrayList<int []> instructions;
  private int[][] pasture;

  public MakeLake (int[][] p, int e, ArrayList <int[]> i) {
    pasture = p;
    elevation = e;
    instructions = i;
  }

  public String toString () {
    String ans = "";
    for (int r = 0; r < pasture.length; r ++) {
      for (int c = 0; c < pasture[r].length; c ++) {
        ans += pasture [r][c]+ " ";
        if (c == pasture[r].length - 1)  {
          ans += "\n";
        }
      }
    }
    return ans;
  }

  public static void main (String[] args) {
    /*
    MakeLake test = new MakeLake ("makelake.in", 4,6,22, 2);
    System.out.println (test.toString ());
    */
  }

  /*
  public boolean stomp (int r, int c, int numTimes) {
    if (r + 1 > pasture.length || r - 1 < 0 || c + 1 > pasture [r].length || c - 1 < 0) {
      return false; //if cannot fit in 3x3 box
    }
    while (numTimes > 0) {
      ArrayList <int[]> largest = highest (r,c); //arrayList of coordinates for the squares with the highest value
      for (int i = 0; i < largest.size (); i ++) {
        int y = largest.get(i)[0];
        int x = largest.get(i)[1];
        pasture[y][x] -= 1; //subtracting one from each square
      }
      //go through board to find highest
      numTimes --;
    }
    return true;
  }
  */

  public void stomp (int r, int c, int numTimes) {
    int cap = highest (r,c) - numTimes;
    for (int y = r - 1; y < r + 2; y ++) {
      for (int x = c - 1; x < c + 2; x ++) {
        int dif = pasture[y][x] - cap;
        if (dif > 0) {
          pasture [y][x] = cap;
        }
        System.out.println (toString ());
      }
    }
  }

  public int highest (int r, int c) {
    int highest = 0;
    for (int y = r - 1; y < r + 2; y ++) {
      for (int x = c - 1; x < c + 2; x ++) {
        if (pasture [y][x] > highest) {
          highest = pasture [y][x];
        }
      }
    }
    return highest;
  }
//find highest single value and each gets capped at that
  public int[][] execute () { //does all the instructions and returns pasture
    for (int i = 0; i < instructions.size (); i ++) {
      int [] stomps = instructions.get (i);
      stomp (stomps[0], stomps[1], stomps [2]);
    }
    for (int i = 0; i < pasture.length; i ++) {
      for (int y = 0; y < pasture[i].length; y ++) {
        int depth = pasture [i][y];
        /*
        if (depth - elevation <= 0) {
          pasture [i][y] = 0;
        }
        else {
          pasture [i][y] -= elevation;
        }
        */
      }
    }
    return pasture;
  }


}
/*
private ArrayList <int[]> highest (int r, int c) { //returns an arrayList of the coordinates of each square with the highest in a  3x3 grid
  int highest = 0;
  ArrayList <int[]> coordinates = new ArrayList <int[]> ();
  for (int y = r - 1; y <= r + 1; y ++) {
    for (int x = c - 1; x <= c + 1; x ++) {
      int[] a = {y,x};
      if (pasture [y][x] > highest) {
        highest = pasture[y][x];
        coordinates = new ArrayList <int[]> ();
        coordinates.add (a);
      }
      if (pasture [y][x] == highest) {
        coordinates.add (a);
      }
    }
  }
  return coordinates;
}
*/
