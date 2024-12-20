package app.common;

import app.word.WordData;
import java.io.*;
import java.util.*;

public class Util {

  public static List<WordData> readWordData(String fileName) {
    List<WordData> wordDataList = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String word = null;
      List<String> meaning = new ArrayList<>();
      List<String> sentence = new ArrayList<>();

      String line;
      while ((line = reader.readLine()) != null) {
        line = line.trim();

        if (line.isEmpty() && word != null) {
          wordDataList.add(new WordData(word, meaning, sentence));
          word = null;
          meaning = new ArrayList<>();
          sentence = new ArrayList<>();
        } else if (line.startsWith("word:")) {
          word = line.substring(5).trim();
        } else if (line.startsWith("meanings:")) {
          meaning = Arrays.asList(line.substring(9).trim().split(","));
        } else if (line.startsWith("examples:")) {
          sentence = Arrays.asList(line.substring(9).trim().split(","));
        }
      }

      if (word != null) {
        wordDataList.add(new WordData(word, meaning, sentence));
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return wordDataList;
  }

  public static int getLCS(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    int[][] dp = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[n][m];
  }
}
