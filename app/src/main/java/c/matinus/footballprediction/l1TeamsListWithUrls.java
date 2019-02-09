package c.matinus.footballprediction;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class l1TeamsListWithUrls {






        public static void main(String[] args) {
            Iterator it;
            Document doc;
            ArrayList<String> stringArrayList;
            Document doc2 = null;
            ArrayList<String> stringArrayList2 = new ArrayList();
            try {
                doc2 = Jsoup.connect("http://fr.soccerway.com/national/france/ligue-1").get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int j = 0;
            int k = 1;

            Iterator it2 = doc2.select("tr").iterator();
            while (true) {
                int i = 1;
                if (!it2.hasNext()) {
                    break;
                }
                j = 1;
                it = ((Element) it2.next()).children().iterator();
                while (it.hasNext()) {
                    Element tdb = (Element) it.next();
                    if (j == 1) {
                        if (tdb.cssSelector().contains("td.rank") && Integer.parseInt(tdb.text()) >= k) {
                            k = Integer.parseInt(tdb.text());
                            PrintStream printStream = System.out;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("");
                            stringBuilder.append(k);
                            printStream.println(stringBuilder.toString());
                        }
                        j++;
                    }
                }
            }


            int nombreDEquipesAffichees = 0;
            it = doc2.select("td").iterator();
            while (it.hasNext()) {
                int i2 = 1;
                int i=1;
                Iterator it3 = ((Element) it.next()).children().iterator();
                while (it3.hasNext()) {
                    Element tdb2 = (Element) it3.next();
                    if (i2 == i && nombreDEquipesAffichees < k) {
                        StringBuilder bd = new StringBuilder(tdb2.text());
                        if (tdb2.cssSelector().contains("td.text.team.large-link > a")) {
                            System.out.println(tdb2.text());
                            nombreDEquipesAffichees++;
                        }
                    }
                    i2++;
                    i = 1;
                }
                i = 1;
            }
            System.out.println("\n\n\n");
            nombreDEquipesAffichees = 0;
            it = doc2.select("td").iterator();
            while (it.hasNext()) {
                Iterator it3 = ((Element) it.next()).children().iterator();
                while (it3.hasNext()) {
                    int j2;
                    Element tdb2 = (Element) it3.next();
                    if (nombreDEquipesAffichees < k) {
                        StringBuilder bd = new StringBuilder(tdb2.text());
                        j2 = j;
                        if (tdb2.cssSelector().contains("td.text.team.large-link > a") ) {
                            String[] table = tdb2.toString().split("/");
                            PrintStream printStream2 = System.out;
                            doc = doc2;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringArrayList = stringArrayList2;
                            stringBuilder2.append(tdb2.text());
                            stringBuilder2.append(" , /");
                            stringBuilder2.append(table[3]);
                            stringBuilder2.append("/");
                            stringBuilder2.append(table[4]);
                            printStream2.println(stringBuilder2.toString());
                            nombreDEquipesAffichees++;
                        } else {
                            doc = doc2;
                            stringArrayList = stringArrayList2;
                        }
                    } else {
                        j2 = j;
                        doc = doc2;
                        stringArrayList = stringArrayList2;
                    }
                    j = j2;
                    doc2 = doc;
                    stringArrayList2 = stringArrayList;
                }
                doc = doc2;
                stringArrayList = stringArrayList2;
            }
            doc = doc2;
            stringArrayList = stringArrayList2;
        }
    }


