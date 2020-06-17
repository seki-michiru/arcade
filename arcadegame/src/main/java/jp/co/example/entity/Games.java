package jp.co.example.entity;

public class Games {

	private Integer gameId;
	private String gameName;

	public Games() {



	}

	public Games(Integer gameId, String gameName) {

		this.gameId = gameId;
		this.gameName = gameName;

	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}






}
