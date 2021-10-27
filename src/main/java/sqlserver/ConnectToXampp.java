/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlserver;

import dictionary.Word;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duy Gooner
 */
public class ConnectToXampp {

    public Connection conn;

    public ConnectToXampp() {
        String url = "jdbc:mysql://localhost:3306/dictionary";
        var user = "root";
        var password = "";
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công");
            System.out.println(conn.getCatalog());
        } catch (SQLException ex) {
            Logger.getLogger(ConnectToXampp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // thêm từ 
    public boolean addWord(Word w) {

        String sql = "INSERT INTO mydict(word, phonetic, mean)"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(1, "");
            ps.setString(1, w.getWord());
            ps.setString(2, w.getPhonetics());
            ps.setString(3, w.getMean());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    // xóa từ
    public boolean deleteWord(String w) {
        try {
            String sql = "DELETE FROM mydict WHERE word =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, w);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectToXampp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // lấy danh sách các từ
    public ArrayList<Word> getListYourWord(String word) {
        ArrayList<Word> list = new ArrayList<>();
        String sql = "SELECT * FROM mydict WHERE word = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, word);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Word w = new Word();
                w.setWord(rs.getString("word"));
                w.setPhonetics(rs.getString("phonetic"));
                w.setMean(rs.getString("mean"));

                list.add(w);
            }
        } catch (Exception e) {
        }
        return list;
    }

    // lấy ra một từ
    public Word getWordYourWord(String word) {
        Word w = new Word();
        String sql = "SELECT * FROM mydict WHERE word = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, word);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                w.setWord(rs.getString("word"));
                w.setPhonetics(rs.getString("phonetic"));
                w.setMean(rs.getString("mean"));
            }
        } catch (Exception e) {
        }
        return w;
    }

    // sửa từ
    public boolean editWord(String w, Word newWord) {
        String sql = "UPDATE mydict SET word = ?,phonetic = ?,mean = ? WHERE word = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(1, "");
            ps.setString(1, newWord.getWord());
            ps.setString(2, newWord.getPhonetics());
            ps.setString(3, newWord.getMean());
            ps.setString(4, w);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }
}
