package jp.co.example.entity;

import java.util.Date;

public class Scores {

	private Integer scoreId;
	private Integer userId;
	private Integer gameId;
	private Integer score;
	private Integer scoreCoin;
	private Date scoreDate;

	public Scores() {



	}

	public Scores(Integer scoreId, Integer userId, Integer gameId, Integer score, Integer scoreCion, Date scoreDate) {

		this.scoreId = scoreId;
		this.userId = userId;
		this.gameId = gameId;
		this.score = score;
		this.scoreCoin = scoreCion;
		this.scoreDate = scoreDate;

	}

	public Integer getScoreId() {
		return scoreId;
	}

	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getScoreCoin() {
		return scoreCoin;
	}

	public void setScoreCoin(Integer scoreCoin) {
		this.scoreCoin = scoreCoin;
	}

	public Date getScoreDate() {
		return scoreDate;
	}

	public void setScoreDate(Date scoreDate) {
		this.scoreDate = scoreDate;
	}




}
