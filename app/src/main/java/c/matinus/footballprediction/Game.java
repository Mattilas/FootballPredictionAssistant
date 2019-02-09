package c.matinus.footballprediction;


import android.support.annotation.NonNull;

public class Game {
    private Team awayTeam;
    private final double currentRankImportance = 0.6d;
    private final double directConfrontationsImportance = 0.4d;
    private final double drawLikelihoodImportance = 0.2d;
    private final double gameConditionsImportance = 0.25d;
    private Team homeTeam;
    private final double lastResultImportance = 0.05d;
    private final double previousRankImportance = 0.4d;
    private final double stakeImportance = 0.2d;
    private final double stakesImportance = 0.2d;
    private final double teamCompletenessImportance = 0.5d;
    private final double teamCurrentFitnessImportance = 0.1d;
    private final double teamLevelImportance = 0.45d;

    public Team getHomeTeam() {
        return this.homeTeam;
    }

    public Team getAwayTeam() {
        return this.awayTeam;
    }

    public double getStakeImportance() {
        return 0.2d;
    }

    public double getPreviousRankImportance() {
        return 0.4d;
    }

    public double getCurrentRankImportance() {
        return 0.6d;
    }

    public double getLastResultImportance() {
        return 0.05d;
    }

    public double getTeamCompletenessImportance() {
        return 0.5d;
    }

    public double getDrawLikelihoodImportance() {
        return 0.2d;
    }

    public double getDirectConfrontationsImportance() {
        return 0.4d;
    }

    public double getTeamLevelImportance() {
        return 0.45d;
    }

    public double getTeamCurrentFitnessImportance() {
        return 0.1d;
    }

    public double getGameConditionsImportance() {
        return 0.25d;
    }

    public double getStakesImportance() {
        return 0.2d;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }


    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Game)) {
            return false;
        }

        Game game = (Game) o;

        return this.homeTeam.isSameTeam(game.homeTeam.getName()) &&
                this.awayTeam.isSameTeam(game.awayTeam.getName());
    }

    @NonNull
    @Override
    public String toString() {
        return this.getHomeTeam() + " - " + this.getAwayTeam();
    }



}
