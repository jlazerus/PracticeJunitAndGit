import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {
    // The parameter array method shown in the book uses the '$' shortcut, which is deprecated
    // Use this Object array idiom instead.
    // See https://github.com/Pragmatists/JUnitParams/blob/master/src/test/java/junitparams/usage/SamplesOfUsageTest.java
    private Object[] numberOfGamesWon() {
        return new Object[] {0, 1, 2, 3, 4};
    }

    @Test
    @Parameters(method = "numberOfGamesWon")
    public void constructorShouldSetGamesWon(int numberOfGamesWon) {
        FootballTeam team = new FootballTeam(numberOfGamesWon);
        assertEquals(numberOfGamesWon + " games passed to constructor but "
                        + team.getGamesWon() + " were returned",
                numberOfGamesWon, team.getGamesWon());
    }

    public Object[] illegalNumberOfGamesWon() {
        return new Object[] {-10, -1};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "illegalNumberOfGamesWon")
    public void constructorShouldThrowExceptionForIllegalNumGamesWon(int illegalNumberOfGamesWon) {
        FootballTeam team = new FootballTeam(illegalNumberOfGamesWon);

    }

    private static final int ANY_NUMBER = 123;

    @Test
    public void shouldbePossibleToCompareTeams() {
        FootballTeam team = new FootballTeam(ANY_NUMBER);

        assertTrue("Footbal teams should implement Comparable",
                team instanceof Comparable);
    }

//    @Test
//    public void compareToOtherTeamsReturns0() {
//        FootballTeam team1 = new FootballTeam(ANY_NUMBER);
//        FootballTeam team2 = new FootballTeam(ANY_NUMBER);
//
//        assertEquals(0,  team1.compareTo(team2));
//    }

    @Test
    public void teamWithMoreWinsShouldBeGreater() {
        FootballTeam team1 = new FootballTeam(2);
        FootballTeam team2 = new FootballTeam(3);

        assertTrue(team2.compareTo(team1) > 0);
    }

    @Test
    public void teamWithFewerWinsShouldBeLesser() {
        FootballTeam team1 = new FootballTeam(2);
        FootballTeam team2 = new FootballTeam(3);

        assertTrue("Team with " + team1.getGamesWon()
        + " games won should be ranked after the team with "
        + team2.getGamesWon() + " games won",
                team1.compareTo(team2) < 0);
    }

    @Test
    public void teamWithSameWinsShouldBeEqual() {
        FootballTeam team1 = new FootballTeam(2);
        FootballTeam team2 = new FootballTeam(2);

        assertTrue("Both teams have won the same number of games: "
                        + team1.getGamesWon() + "  vs. " + team2.getGamesWon()
                        + " and should be ranked equal",
                team1.compareTo(team2) == 0);
    }
}
