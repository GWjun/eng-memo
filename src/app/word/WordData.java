package app.word;

import java.util.List;

public class WordData {

  private final String word;
  private final List<String> meaning;
  private final List<String> sentence;

  public WordData(String word, List<String> meaning, List<String> sentence) {
    this.word = word;
    this.meaning = meaning;
    this.sentence = sentence;
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
}
