/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.Objects;

/**
 *
 * @author Duy Gooner
 */
public class Word implements Comparable<Word> {

    String word;
    Meaning meaning;
    String mean;
    String phonetics;

    public Word() {
        this.meaning = new Meaning();
    }

    public Word(String word) {
        this.meaning = new Meaning();
        this.word = word;

    }

    public Word(String word, Meaning meaning, String phonetics) {
        this.word = word;
        this.meaning = meaning;
        this.phonetics = phonetics;
    }

    public Word(String word, String mean, String phonetics) {
        this.word = word;
        this.mean = mean;
        this.phonetics = phonetics;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getMean() {
        return mean;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning.toString();
    }

    public void setMeaning(Meaning meaning) {
        this.meaning = new Meaning();
    }

    public String getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(String phonetics) {
        this.phonetics = phonetics;
    }

    public void addToMeaning(String s) {
        this.meaning.Add(s);
    }

    @Override
    public int compareTo(Word word) {
        // return word.getWord().compareTo(this.getWord());
        return this.getWord().compareTo(word.getWord());
    }

    @Override
    public String toString() {
        return this.word;
    }

}
