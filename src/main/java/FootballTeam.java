public class FootballTeam implements Comparable<FootballTeam>{
    private int gamesWon;

    FootballTeam(int gamesWon) {
        if(gamesWon < 0 ) {
            throw new IllegalArgumentException("A team can't win fewer than zero games! was " + gamesWon + ")");
        }
        this.gamesWon = gamesWon;
    }

    int getGamesWon() {

    return gamesWon;
    }

    @Override
    public int compareTo(FootballTeam otherTeam) {
        if(gamesWon > otherTeam.getGamesWon()) {
            return 1;
        }
        else if(gamesWon < otherTeam.getGamesWon()) {
            return -1;
        }
        return 0;
    }
}
