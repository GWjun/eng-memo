package app.word;

import java.util.List;

public class WordData {

  private final String word;
  private final List<String> meaning;
  private final List<String> sentence;
  private final int score;

  public WordData(String word, List<String> meaning, List<String> sentence, int score) {
    this.word = word;
    this.meaning = meaning;
    this.sentence = sentence;
    this.score = score;
  }

  public String getWord() {
    return word;
  }

  public List<String> getMeaning() {
    return meaning;
  }

  public List<String> getSentence() {
    return sentence;
  }

  public int getScore() {
    return score;
  }
}
