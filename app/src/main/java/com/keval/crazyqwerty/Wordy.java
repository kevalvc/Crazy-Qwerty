package com.keval.crazyqwerty;

/**
 * Created by Guest2 on 4/7/2018.
 */

public class Wordy {
    private String wordtitle, meaning;

    public Wordy() {
    }

    public Wordy(String wordtitle, String meaning) {
        this.wordtitle = wordtitle;
        this.meaning = meaning;
    }

    public String getTitle() {
        return wordtitle;
    }

    public void setTitle(String name) {
        this.wordtitle = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

}
