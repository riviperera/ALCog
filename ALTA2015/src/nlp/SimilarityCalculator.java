/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nlp;

import info.debatty.java.stringsimilarity.NGram;

/**
 *
 * @author rperera
 */
public class SimilarityCalculator 
{
    //for LESK impl and ngram distance
    
    public double getNgramDistance(String sent1, String sent2, int grams)
    {
        if(grams == 0)
        {
            grams =2;
        }
        
        NGram ngram = new NGram(grams);
        return ngram.distance(sent1, sent2);
    }
}
