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
}
