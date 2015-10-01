/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.List;

/**
 *
 * @author rperera
 */
public class DocWords 
{
    private int docid;
    private List<Word> words;

    /**
     * @return the docid
     */
    public int getDocid() {
        return docid;
    }

    /**
     * @param docid the docid to set
     */
    public void setDocid(int docid) {
        this.docid = docid;
    }

    /**
     * @return the words
     */
    public List<Word> getWords() {
        return words;
    }

    /**
     * @param words the words to set
     */
    public void setWords(List<Word> words) {
        this.words = words;
    }
}
