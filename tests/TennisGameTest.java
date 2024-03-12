import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
    //Test love vs love
    @Test
    public void testTennisGame_loveVsLove()throws TennisGameException{
        TennisGame game = new TennisGame();
        String score = game.getScore();
        assertEquals("Score is incorrect", "love - love", score);
    }

    //Test 30 vs 15
    @Test
    public void testTennisGame_ScoreIsFifteenThirty() throws TennisGameException {
        TennisGame game = new TennisGame();
        game.player1Scored();
        game.player2Scored();
        game.player2Scored();
        String score = game.getScore();
        assertEquals("Score incorrect", "30 - 15", score);
    }

    //Test 30 vs love
    @Test
    public void testTennisGame_ThirtyVsLove()throws TennisGameException{
        TennisGame game = new TennisGame();
        game.player2Scored();
        game.player2Scored();
        String score = game.getScore() ;
        assertEquals("Score is incorrect", "30 - love", score);
    }

    //Test 40 vs love
    @Test
    public void testTennisGame_FortyVsLove()throws TennisGameException{
        TennisGame game = new TennisGame();
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        String score = game.getScore() ;
        assertEquals("Score is incorrect", "40 - love", score);
    }

    //Test player2 wins
    @Test
    public void testTennisGame_Player2Wins()throws TennisGameException{
        TennisGame game = new TennisGame();
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        String score = game.getScore() ;
        assertEquals("Score is incorrect", "player2 wins", score);
    }

    //Test player1 wins
    @Test
    public void testTennisGame_Player1Wins()throws TennisGameException{
        TennisGame game = new TennisGame();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        String score = game.getScore() ;
        assertEquals("Player 1 should win", "player1 wins", score);
    }
    //Test deuce
    @Test
    public void testTennisGame_Deuce()throws TennisGameException{
        TennisGame game = new TennisGame();
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        String score = game.getScore() ;
        assertEquals("Player 1 should win", "deuce", score);
    }

    //Test player 2 has advantage
    @Test
    public void testTennisGame_Player2Advantage()throws TennisGameException{
        TennisGame game = new TennisGame();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();

        game.player2Scored();
        game.player2Scored();
        game.player2Scored();

        game.player2Scored();
        game.player1Scored();

        game.player2Scored();
        String score = game.getScore() ;
        assertEquals("Advantage score incorrect", "player2 has advantage", score);
    }

    //Test player 1 has advantage
    @Test
    public void testTennisGame_Player1HasAdvantage() throws TennisGameException{
        TennisGame game = new TennisGame();

        game.player1Scored();
        game.player1Scored();
        game.player1Scored();

        game.player2Scored();
        game.player2Scored();
        game.player2Scored();

        game.player1Scored();

        String score = game.getScore() ;

        assertEquals("Advantage score incorrect", "player1 has advantage", score);
    }

    //Test exception handling
    @Test (expected = TennisGameException.class)
    public void testTennisGame_afterEndPlayer1Win() throws TennisGameException{
        TennisGame game = new TennisGame();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
    }

    //Test exception handling
    @Test (expected = TennisGameException.class)
    public void testTennisGame_afterEndPlayer2Win() throws TennisGameException{
        TennisGame game = new TennisGame();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player2Scored();
    }
}
