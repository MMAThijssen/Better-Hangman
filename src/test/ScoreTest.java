
package test;

import junit.framework.TestCase;
import processing.Lives;
import processing.Score;

public class ScoreTest extends TestCase {
	
	public void testScore() {
		Score score = Score.getInstance();
		assertNotNull(score);
	}
	
	public void testGetScore() {
		Score score = Score.getInstance();
		assertNotNull(score.getScore());
	}
	
	public void testSettleScore() {
		// tests that score field is not null after settleScore
		Score score = Score.getInstance();
		Lives lives = Lives.getInstance();
		lives.setLives(7);
		score.settleScore(lives.getLives(), lives.getInitialLives());
		assertNotNull(score.getScore());
	}
	
	public void testSettleScore2() {
		// tests that score is settled correctly
		int winBonus = 300;
		int difficultyBonus= 100;
		int livesLostPenalty = -25;
		Score score = Score.getInstance();
		
		// tests when no lives are lost
		Lives lives = Lives.getInstance();
		lives.setInitialLives(5);
		score.settleScore(lives.getLives(), lives.getInitialLives());
		int actualScore = (difficultyBonus/5) + 0;
		assertEquals(score.getScore(), actualScore);
		
		// tests when lives are lost
		lives.subtract(2);
		score.settleScore(lives.getLives(), lives.getInitialLives());
		int actualScore2 = (difficultyBonus/5) + (2*livesLostPenalty);
		assertEquals(score.getScore(), actualScore2);
		
		//tests when no lives are left
		lives.setInitialLives(2);
		lives.subtract(2);
		score.settleScore(lives.getLives(), lives.getInitialLives());
		int actualScore3 = (difficultyBonus/2) + (2*livesLostPenalty);
		assertEquals(score.getScore(), actualScore3);
		
		//tests math.rounding
		lives.setInitialLives(7);
		score.settleScore(lives.getLives(), lives.getInitialLives());
		int actualScore4 = (difficultyBonus/7) + (0*livesLostPenalty);
		actualScore4 = Math.round(actualScore4);
		assertEquals(score.getScore(), actualScore4);
		
		//tests application of winBonus
		score.applyWinBonus();
		int actualScore5 = winBonus + (difficultyBonus/7) + (0*livesLostPenalty);
		assertEquals(score.getScore(), actualScore5);
	}

}