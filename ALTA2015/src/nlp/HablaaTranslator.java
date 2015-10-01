/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nlp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rperera
 */
public class HablaaTranslator 
{
    //http://hablaa.com/english-french/apple/
    
    public static void main(String[] args) {
        HablaaTranslator ht = new HablaaTranslator();
        ht.getHablaSource("http://hablaa.com/english-french/apple");
    }
    
    
    
    
    public void getHablaSource(String surl)
    {
        URL url;
        try 
        {
            url = new URL(surl);
        
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

            httpCon.addRequestProperty("Host", "http://hablaa.com/");
            httpCon.addRequestProperty("Connection", "keep-alive");
            httpCon.addRequestProperty("Cache-Control", "max-age=0");
            httpCon.addRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            httpCon.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36");
            httpCon.addRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
            httpCon.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
            
            HttpURLConnection.setFollowRedirects(false);
            httpCon.setInstanceFollowRedirects(false);
            httpCon.setDoOutput(true);
            httpCon.setUseCaches(true);

            httpCon.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(httpCon.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuilder a = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
            {
                a.append(inputLine);
            }
            in.close();

            System.out.println(a.toString());

            httpCon.disconnect();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
