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
        ans += pasture [r][c];
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

  public boolean stomp (int r, int c, int numTimes) {
    if (r + 1 > pasture.length || r - 1 < 0 || c + 1 > pasture [r].length || c - 1 < 0) {
      return false; //if cannot fit in 3x3 box
    }

    while (numTimes > 0) {
      for (int y = r - 1; y <= r + 1; y ++) {
        for (int x = c - 1; x <= c + 1; x ++) {
          int[] highest = highest (y,x);
          pasture [highest[0]][highest[1]] -= 1;
        }
      }
      //go through board to find highest
      numTimes --;
    }
    return true;
  }

  private int[] highest (int r, int c) { //returns an array of the coordinates of the highest in a 3x3 grid
    int highest = 0;
    int[] coordinates = new int[2];
    for (int y = r - 1; y <= r + 1; y ++) {
      for (int x = c - 1; x <= c + 1; x ++) {
        if (pasture [y][x] > highest) {
          highest = pasture[y][x];
          coordinates[0] = y;
          coordinates[1] = x;
        }
      }
    }
    return coordinates;
  }

  public int[][] execute () { //does all the instructions and returns pasture
    for (int i = 0; i < instructions.size (); i ++) {
      int [] stomps = instructions.get (i);
      stomp (stomps[0], stomps[1], stomps [2]);
    }
    return pasture; 
  }


}
