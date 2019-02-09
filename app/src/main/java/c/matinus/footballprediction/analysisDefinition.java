package c.matinus.footballprediction;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Context;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class analysisDefinition extends AppCompatActivity {

    private int arraysize = 0;
    private Document doc = null;
    private String[] ligue1Teams;
    private Context contexte = this;

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_definition);

        //Populating type of game spinner
        populateGameTypeSpinner();

        //Saving data from the web
        Thread thread = new Thread(){
            public void run(){
                try {
                    Document doc = Jsoup.connect("https://us.soccerway.com/national/france/ligue-1/20182019/regular-season/r48044/?ICID=HP_POP_05").get();
                    //Document doc = Jsoup.connect("http://fr.soccerway.com/national/france/ligue-1").get();
                    setDoc(doc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
        while (thread.getState() != Thread.State.TERMINATED) {
        }


        //Auto-complete widget configuration
        configurateTeamsAutoComplete();


        //Game importance label edition
        final TextView awayTeamGameImportanceTextView = findViewById(R.id.gameImportanceForAwayTeam);
        awayTeamGameImportanceTextView.setText("Game importance: 3 (important)");
        ((SeekBar) findViewById(R.id.awayTeamGameImportanceSelectionSeekBar)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (seekBar.getProgress() == 0) {
                    awayTeamGameImportanceTextView.setText("Game importance: 0 (absolutely unimportant)");
                }
                if (seekBar.getProgress() == 1) {
                    awayTeamGameImportanceTextView.setText("Game importance: 1 (not important)");
                }
                if (seekBar.getProgress() == 2) {
                    awayTeamGameImportanceTextView.setText("Game importance: 2 (good for training)");
                }
                if (seekBar.getProgress() == 3) {
                    awayTeamGameImportanceTextView.setText("Game importance: 3 (important)");
                }
                if (seekBar.getProgress() == 4) {
                    awayTeamGameImportanceTextView.setText("Game importance: 4 (decisive)");
                }
                if (seekBar.getProgress() == 5) {
                    awayTeamGameImportanceTextView.setText("Game importance: 5 (crucial)");
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        final TextView homeTeamGameImportanceTextView = (TextView) findViewById(R.id.gameImportanceForHomeTeam);
        homeTeamGameImportanceTextView.setText("Game importance: 3 (important)");
        ((SeekBar) findViewById(R.id.homeTeamGameImportanceSelectionSeekBar)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (seekBar.getProgress() == 0) {
                    homeTeamGameImportanceTextView.setText("Game importance: 0 (absolutely unimportant)");
                }
                if (seekBar.getProgress() == 1) {
                    homeTeamGameImportanceTextView.setText("Game importance: 1 (not important)");
                }
                if (seekBar.getProgress() == 2) {
                    homeTeamGameImportanceTextView.setText("Game importance: 2 (good for training)");
                }
                if (seekBar.getProgress() == 3) {
                    homeTeamGameImportanceTextView.setText("Game importance: 3 (important)");
                }
                if (seekBar.getProgress() == 4) {
                    homeTeamGameImportanceTextView.setText("Game importance: 4 (decisive)");
                }
                if (seekBar.getProgress() == 5) {
                    homeTeamGameImportanceTextView.setText("Game importance: 5 (crucial)");
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    //Clicking to choose game type
    public void typeOfGameChoice(View view) {
        ((Spinner) findViewById(R.id.gameType)).performClick();
    }

    //Game type spinner
    public void populateGameTypeSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.gameType);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gameType,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public int ligue1NumberOfTeamsCalculation() {
        int k = 1;
        if (this.doc == null) {
            System.out.println("NULL/nNULL/nNULL");
        }
        Iterator it = this.doc.select("tr").iterator();
        while (it.hasNext()) {
            int j = 1;
            Iterator it2;
            it2 = ((Element) it.next()).children().iterator();
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




    @SuppressLint("ClickableViewAccessibility")
    public void configurateTeamsAutoComplete() {
        //Composing the dropdown menu list of teams
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

        //Declaring autocomplete views
        final AutoCompleteTextView homeTeamAutoComplete = findViewById(R.id.homeTeamName);
        final AutoCompleteTextView awayTeamAutoComplete = findViewById(R.id.awayTeamName);

        //Adding the dropdown menu list to them
        ArrayAdapter<String> adapter = new ArrayAdapter(contexte , android.R.layout.simple_dropdown_item_1line, this.ligue1Teams);
        awayTeamAutoComplete.setAdapter(adapter);
        final ArrayAdapter<String> adapter2 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.ligue1Teams);
        homeTeamAutoComplete.setAdapter(adapter2);

        //Displaying drop down menu after 1 letter typed
        awayTeamAutoComplete.setThreshold(1);
        homeTeamAutoComplete.setThreshold(1);

        //Display drop down menu after one click performed on home team autocomplete text view
        homeTeamAutoComplete.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event)  {

                //Reinitialising home team autocomplete text view adapter
                try{
                    adapter2.clear();
                    for (int i=0 ; i<ligue1Teams.length ; i++){
                        adapter2.add(ligue1Teams[i]);
                    }
                } catch (Exception e) {
                    TextView debug = findViewById(R.id.debuggingLabel);
                    debug.setText(""+e.getMessage());
                }


                //Removing the away team from the home team possibilities if necessary
                //if(!awayTeamAutoComplete.getText().toString().equals("") ) {
                   //adapter2.remove(awayTeamAutoComplete.getText().toString());
                //}

                //Debugging
                //TextView debug = findViewById(R.id.debuggingLabel);
               // debug.setText(""+awayTeamAutoComplete.getListSelection());

                //Displaying drop-down menu
                homeTeamAutoComplete.showDropDown();
                homeTeamAutoComplete.clearComposingText();

                return false;
            }
        });

        //Display drop down menu after one click performed on away team autocomplete text view
        awayTeamAutoComplete.setOnTouchListener(new View.OnTouchListener(){  public boolean onTouch(View v, MotionEvent event){awayTeamAutoComplete.showDropDown(); return false; }});
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

    public void analyse (View view) {
        //Verifying that game is valid

        //Verifying that game is incoming

    }

    public boolean isIncomingGame (Game game) {
        boolean isIncoming = false ;

        //Creating the list of incoming games


        return isIncoming;
    }

}
