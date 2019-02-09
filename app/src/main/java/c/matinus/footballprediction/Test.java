package c.matinus.footballprediction;

public class Test {

    public static void main(String[] args) {

        //Rencontres à comparer
        Game toPlay = new Game();
        Game toCompare = new Game();

        //Equipes
        Team t = new Team(toPlay, "Marseille", teamLocation.AWAY);
        Team t2 = new Team(toPlay, "Lyon", teamLocation.HOME);

        Team t3 = new Team(toCompare, "Olympique Mars…", teamLocation.AWAY);
        Team t4 = new Team(toCompare, "Olympique Lyonnais", teamLocation.HOME);

        //Affichage des rencontres
        System.out.println("Rencontre 1 : " + toPlay + "\n" +  "Rencontre 2 : " + toCompare );

        //Comparaison
        System.out.println();
        System.out.println("Rencontre 1 identique à Rencontre 2 ? " + toPlay.equals(toCompare));
    }

}
