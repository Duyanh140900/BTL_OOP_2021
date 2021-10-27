/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author Duy Gooner
 */
class Meaning {

    private StringBuilder meaning;

    public Meaning() {
        this.meaning = new StringBuilder("");
    }

    public Meaning(StringBuilder meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return meaning + "";
    }

    public void Add(String s) {
        meaning.append(s + "\n");
    }
}
