/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alta2015;

import data.DocWords;
import data.Word;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rperera
 */
public class DataPopulator 
{
    //to poputate docwords from text file
    
    public static void main(String[] args) {
        DataPopulator dp = new DataPopulator();
        dp.getDocWordDataFromFile("./datafiles/raw/Train.txt");
    }
    
    
    
    /*
        Code to read data from train test files
    */
    public List<DocWords> getDocWordDataFromFile(String filepath)
    {
        List<DocWords> docwords = new ArrayList<DocWords>();
        File datafile = new File (filepath);
        try (BufferedReader br = new BufferedReader(new FileReader(datafile))) 
        {
            String line;
            int di=1;
            DocWords dw = null;
            List<Word> words =null;
            Word word =null;
            while ((line = br.readLine()) != null) 
            {
                if(line.contains("<docid"))
                {
                    
                    if(words !=null)
                    {
                        dw.setWords(words);
                        docwords.add(dw);
                    }
                    
                    dw = new DocWords();
                    words = new ArrayList<Word>();
                    dw.setDocid(di++);
                }
                else
                {
                    word = new Word();
                    word.setIndex(Integer.parseInt(line.split(" ")[0].trim()));
                    word.setWord(line.split(" ")[1]);
                    words.add(word);
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        
        return docwords;
    }
}
