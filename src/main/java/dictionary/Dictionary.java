/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Vector;

/**
 *
 * @author Duy Gooner
 */
public class Dictionary {

    // danh sách các từ
    private ArrayList<Word> words;

    // lấy các từu trong danh sách
    public ArrayList<Word> getWords() {
        return words;
    }

    // đọc data từ file
    public void loadFromFile() {
        try {
            words = new ArrayList<>();
            Path path = Paths.get(".\\data\\dictionary.txt");
            java.util.List<String> dataList = Files.readAllLines(path);
            ListIterator<String> itr = dataList.listIterator();
            //code to read data from file to list
            Word word = new Word();
            int count = 0;
            while (itr.hasNext()) {
                String p = itr.next();

                if (p.startsWith("@")) {
                    count++;
                    word = new Word();
                    String[] part = p.split("/", 2);
                    String s2 = part[0].substring(1).trim();
                    if (s2.startsWith("'") || s2.startsWith("-") || s2.startsWith("(")) {
                        s2 = s2.substring(1, s2.length());
                    }
                    word.setWord(s2);

                    if (part.length < 2) {
                        word.setPhonetics("");
                    } else {
                        word.setPhonetics("/" + part[1]);
                    }
                    while (itr.hasNext()) {
                        String p1 = itr.next();
                        if (!p1.startsWith("@")) {
                            word.addToMeaning(p1);
                        } else {
                            words.add(word);
                            itr.previous();
                            break;
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // sắp xếp các từ
    public void sortWords() {
        Collections.sort(words);
    }
    // tìm kiếm từ
//    int search(String s) {
//        Word toSearch = new Word(s.trim());
//        int i = Collections.binarySearch(words, toSearch);
//        return i;
//    }
}
