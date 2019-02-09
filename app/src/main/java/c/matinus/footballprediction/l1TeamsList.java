package c.matinus.footballprediction;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class l1TeamsList {

    private int arraysize = 0;
    private Document doc = null;
    private String[] ligue1Teams;





    public static void main(String[] args) {

        l1TeamsList t = new l1TeamsList();
            t.soccerWayL1HomePageContentSaving();


        //Auto-complete widget configuration
        t.configurateTeamsAutoComplete();
    }




    public void soccerWayL1HomePageContentSaving() {
        try {
            doc = Jsoup.connect("https://us.soccerway.com/national/france/ligue-1/20182019/regular-season/r48044/?ICID=HP_POP_05").get();
            System.out.println(doc.title());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int ligue1NumberOfTeamsCalculation() {
        int k = 1;
        if (this.doc == null) {
            System.out.println("NULL/nNULL/nNULL");
        }
        Iterator it = this.doc.select("tr").iterator();
        while (it.hasNext()) {
            int j = 1;
            Iterator it2 = ((Element) it.next()).children().iterator();
            while (it2.hasNext()) {
                Element tdb = (Element) it2.next();
                if (j == 1) {
                    if (tdb.cssSelector().contains("td.rank") && Integer.parseInt(tdb.text()) >= k) {
                        k = Integer.parseInt(tdb.text());
                    }
                    j++;
                }
            }
        }
        this.arraysize = k;
        return k;
    }

    public void configurateTeamsAutoComplete() {
        //AutoCompleteTextView homeTeamAutoComplete = findViewById(R.id.homeTeamName);
        //AutoCompleteTextView awayTeamAutoComplete = findViewById(R.id.awayTeamName);
        ligue1NumberOfTeamsCalculation();
        this.ligue1Teams = new String[this.arraysize];
        int i = 0;
        Iterator it = ligue1TeamsWebScraping().iterator();
        while (it.hasNext()) {
            String team = (String) it.next();
            Arrays.fill(this.ligue1Teams, i, i + 1, team);
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(team);
            printStream.println(stringBuilder.toString());
            i++;
        }
        //ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.ligue1Teams);
        //awayTeamAutoComplete.setAdapter(adapter);
        //awayTeamAutoComplete.setSelection(1);
        //ArrayAdapter<String> adapter2 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.ligue1Teams);
        //homeTeamAutoComplete.setAdapter(adapter2);
    }

    public ArrayList<String> ligue1TeamsWebScraping() {
        ArrayList<String> stringArrayList = new ArrayList();
        int nombreDEquipesEnregistrees = 0;
        int nombreDEquipesTotal = this.arraysize;
        Iterator it = this.doc.select("td").iterator();
        while (it.hasNext()) {
            int i = 1;
            Iterator it2 = ((Element) it.next()).children().iterator();
            while (it2.hasNext()) {
                Element tdb = (Element) it2.next();
                if (i == 1 && nombreDEquipesEnregistrees < nombreDEquipesTotal && tdb.cssSelector().contains("td.text.team.large-link > a")) {
                    stringArrayList.add(tdb.text());
                    nombreDEquipesEnregistrees++;
                }
                i++;
            }
        }
        return stringArrayList;
    }

}
