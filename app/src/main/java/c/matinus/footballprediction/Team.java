package c.matinus.footballprediction;

public class Team {
    private int CP1previousRank;
    private int C1currentRank;
    private int TC1leagueSize;
    private int CC1leagueRank;
    private int TCC1leaguesRankingTableSize;
    private int V5M1numberOfVictoriesOverThe5LastGames;
    private int N5M1numberOfDrawsOverThe5LastGames;
    private int RDM1lastGameResult;
    private int MADnumberOfGamesPlayedAtHome;
    private int VADnumberOfVictoriesObtainedAtHome;
    private int NADnumberOfDrawsObtainedAtHome;
    private int MAD_CD_numberOfGamesPlayedAtHomeAgainstOpposingTeam;
    private Game game;
    private teamLocation location;
    private String name;


    private int numberOfDrawsObtainedAtHomeAgainstOpposingTeam;
    private int numberOfDrawsObtainedAway;
    private int numberOfDrawsObtainedAwayAgainstOpposingTeam;


    private int numberOfGamesPlayedAway;
    private int numberOfGamesPlayedAwayAgainstOpposingTeam;
    private int numberOfGamesWonAtHomeAgainstOpposingTeam;
    private int numberOfGamesWonAwayAgainstOpposingTeam;
    private int numberOfLackingPlayers;
    private int numberOfVictoriesObtainedAway;
    private int stakes;

    public Team(Game game, String name, teamLocation location) {
        setGame(game);
        if (location.equals(teamLocation.AWAY)) {
            game.setAwayTeam(this);
        } else {
            game.setHomeTeam(this);
        }
        this.setName(name);
    }

    public int getRank() {
        return this.C1currentRank;
    }

    public void setRank(int rank) {
        this.C1currentRank = rank;
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public teamLocation getLocation() {
        return this.location;
    }

    public void setLocation(teamLocation location) {
        this.location = location;
    }

    public int getCurrentRank() {
        return this.C1currentRank;
    }

    public void setCurrentRank(int currentRank) {
        this.C1currentRank = currentRank;
    }

    public int getPreviousRank() {
        return this.CP1previousRank;
    }

    public void setPreviousRank(int previousRank) {
        this.CP1previousRank = previousRank;
    }

    public int getLeagueSize() {
        return this.TC1leagueSize;
    }

    public void setLeagueSize(int leagueSize) {
        this.TC1leagueSize = leagueSize;
    }

    public int getLeagueRank() {
        return this.CC1leagueRank;
    }

    public void setLeagueRank(int leagueRank) {
        this.CC1leagueRank = leagueRank;
    }

    public int getLeaguesRankingTableSize() {
        return this.TCC1leaguesRankingTableSize;
    }

    public void setLeaguesRankingTableSize(int leaguesRankingTableSize) {
        this.TCC1leaguesRankingTableSize = leaguesRankingTableSize;
    }

    public int getV5M1numberOfVictoriesOverThe5LastGames() {
        return this.V5M1numberOfVictoriesOverThe5LastGames;
    }

    public void setV5M1numberOfVictoriesOverThe5LastGames(int v5M1numberOfVictoriesOverThe5LastGames) {
        this.V5M1numberOfVictoriesOverThe5LastGames = v5M1numberOfVictoriesOverThe5LastGames;
    }

    public int getGetNumberOfDrawsOverThe5LastGames() {
        return this.N5M1numberOfDrawsOverThe5LastGames;
    }

    public void setGetNumberOfDrawsOverThe5LastGames(int getNumberOfDrawsOverThe5LastGames) {
        this.N5M1numberOfDrawsOverThe5LastGames = getNumberOfDrawsOverThe5LastGames;
    }

    public int getLastGameResult() {
        return this.RDM1lastGameResult;
    }

    public void setLastGameResult(int lastGameResult) {
        this.RDM1lastGameResult = lastGameResult;
    }

    public int getMADCDnumberOfGamesPlayedAtHomeAgainstOpposingTeam() {
        return this.MAD_CD_numberOfGamesPlayedAtHomeAgainstOpposingTeam;
    }

    public void setMADCDnumberOfGamesPlayedAtHomeAgainstOpposingTeam(int MADCDnumberOfGamesPlayedAtHomeAgainstOpposingTeam) {
        this.MAD_CD_numberOfGamesPlayedAtHomeAgainstOpposingTeam = MADCDnumberOfGamesPlayedAtHomeAgainstOpposingTeam;
    }

    public int getNumberOfGamesPlayedAwayAgainstOpposingTeam() {
        return this.numberOfGamesPlayedAwayAgainstOpposingTeam;
    }

    public void setNumberOfGamesPlayedAwayAgainstOpposingTeam(int numberOfGamesPlayedAwayAgainstOpposingTeam) {
        this.numberOfGamesPlayedAwayAgainstOpposingTeam = numberOfGamesPlayedAwayAgainstOpposingTeam;
    }

    public int getNumberOfGamesWonAtHomeAgainstOpposingTeam() {
        return this.numberOfGamesWonAtHomeAgainstOpposingTeam;
    }

    public void setNumberOfGamesWonAtHomeAgainstOpposingTeam(int numberOfGamesWonAtHomeAgainstOpposingTeam) {
        this.numberOfGamesWonAtHomeAgainstOpposingTeam = numberOfGamesWonAtHomeAgainstOpposingTeam;
    }

    public int getNumberOfGamesWonAwayAgainstOpposingTeam() {
        return this.numberOfGamesWonAwayAgainstOpposingTeam;
    }

    public void setNumberOfGamesWonAwayAgainstOpposingTeam(int numberOfGamesWonAwayAgainstOpposingTeam) {
        this.numberOfGamesWonAwayAgainstOpposingTeam = numberOfGamesWonAwayAgainstOpposingTeam;
    }

    public int getNumberOfDrawsObtainedAtHomeAgainstOpposingTeam() {
        return this.numberOfDrawsObtainedAtHomeAgainstOpposingTeam;
    }

    public void setNumberOfDrawsObtainedAtHomeAgainstOpposingTeam(int numberOfDrawsObtainedAtHomeAgainstOpposingTeam) {
        this.numberOfDrawsObtainedAtHomeAgainstOpposingTeam = numberOfDrawsObtainedAtHomeAgainstOpposingTeam;
    }

    public int getNumberOfDrawsObtainedAwayAgainstOpposingTeam() {
        return this.numberOfDrawsObtainedAwayAgainstOpposingTeam;
    }

    public void setNumberOfDrawsObtainedAwayAgainstOpposingTeam(int numberOfDrawsObtainedAwayAgainstOpposingTeam) {
        this.numberOfDrawsObtainedAwayAgainstOpposingTeam = numberOfDrawsObtainedAwayAgainstOpposingTeam;
    }

    public int getMADnumberOfGamesPlayedAtHome() {
        return this.MADnumberOfGamesPlayedAtHome;
    }

    public void setMADnumberOfGamesPlayedAtHome(int MADnumberOfGamesPlayedAtHome) {
        this.MADnumberOfGamesPlayedAtHome = MADnumberOfGamesPlayedAtHome;
    }

    public int getNumberOfGamesPlayedAway() {
        return this.numberOfGamesPlayedAway;
    }

    public void setNumberOfGamesPlayedAway(int numberOfGamesPlayedAway) {
        this.numberOfGamesPlayedAway = numberOfGamesPlayedAway;
    }

    public int getVADnumberOfVictoriesObtainedAtHome() {
        return this.VADnumberOfVictoriesObtainedAtHome;
    }

    public void setVADnumberOfVictoriesObtainedAtHome(int VADnumberOfVictoriesObtainedAtHome) {
        this.VADnumberOfVictoriesObtainedAtHome = VADnumberOfVictoriesObtainedAtHome;
    }

    public int getNumberOfVictoriesObtainedAway() {
        return this.numberOfVictoriesObtainedAway;
    }

    public void setNumberOfVictoriesObtainedAway(int numberOfVictoriesObtainedAway) {
        this.numberOfVictoriesObtainedAway = numberOfVictoriesObtainedAway;
    }

    public int getNADnumberOfDrawsObtainedAtHome() {
        return this.NADnumberOfDrawsObtainedAtHome;
    }

    public void setNADnumberOfDrawsObtainedAtHome(int NADnumberOfDrawsObtainedAtHome) {
        this.NADnumberOfDrawsObtainedAtHome = NADnumberOfDrawsObtainedAtHome;
    }

    public int getNumberOfDrawsObtainedAway() {
        return this.numberOfDrawsObtainedAway;
    }

    public void setNumberOfDrawsObtainedAway(int numberOfDrawsObtainedAway) {
        this.numberOfDrawsObtainedAway = numberOfDrawsObtainedAway;
    }

    public int getNumberOfLackingPlayers() {
        return this.numberOfLackingPlayers;
    }

    public void setNumberOfLackingPlayers(int numberOfLackingPlayers) {
        this.numberOfLackingPlayers = numberOfLackingPlayers;
    }

    public int getStakes() {
        return this.stakes;
    }

    public void setStakes(int stakes) {
        this.stakes = stakes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSameTeam (String teamName) {
        int similitude = 0;
        String partieCommune = "";

        for ( int i=0; i< name.length()  ; i++){
            for ( int j=0; j< teamName.length() ; j++){
                    if(name.charAt(i) == teamName.charAt(j)) {
                        if (partieCommune.indexOf(name.charAt(i)) == -1){
                            similitude ++;
                            partieCommune += name.charAt(i);
                        }

                    }
            }
        }
        return similitude >= 3;
    }

    public String toString() {
        return this.getName();
    }

}
