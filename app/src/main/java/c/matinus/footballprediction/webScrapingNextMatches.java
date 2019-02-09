package c.matinus.footballprediction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class webScrapingNextMatches {
    public static void main(String[] args) {
        Document doc = null;
        ArrayList<String> stringArrayList = new ArrayList();
        try {
            doc = Jsoup.connect("http://www.betexplorer.com/soccer/france/ligue-1/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator it = doc.select("tr").iterator();
        while (it.hasNext()) {
            int j = 1;
            Iterator it2 = ((Element) it.next()).children().iterator();
            while (it2.hasNext()) {
                Element tdb = (Element) it2.next();
                if (tdb.cssSelector().contains("td:nth-child(2)")) {
                    System.out.println(tdb.text());
                }
                j++;
            }
        }
    }
}

