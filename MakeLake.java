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

  /*
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
  */

  private void stomp (int r, int c, int numTimes) {
    int cap = highest (r,c) - numTimes; //highest number that can be in the 3x3 grid
    for (int y = r - 1; y < r + 2; y ++) {
      for (int x = c - 1; x < c + 2; x ++) {
        int dif = pasture[y][x] - cap;
        if (dif > 0) { //if value is greater than cap
          pasture [y][x] = cap; //set value to cap otherwise is doesnt change
        }
      }
    }
  }

  private int highest (int r, int c) {
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

  public int[][] execute () { //does all the instructions and returns pasture
    for (int i = 0; i < instructions.size (); i ++) {
      int [] stomps = instructions.get (i);
      stomp (stomps[0], stomps[1], stomps [2]);
    }
    for (int i = 0; i < pasture.length; i ++) {
      for (int y = 0; y < pasture[i].length; y ++) {
        int depth = pasture [i][y];
        if (depth < elevation) {
          pasture[i][y] = elevation - depth;
        }
        else {
          pasture[i][y] = 0;
        }
      }
    }
    return pasture;
  }
}
