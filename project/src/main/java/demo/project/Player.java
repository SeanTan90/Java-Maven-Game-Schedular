package demo.project;

public class Player {
	private String name;
	private Game[] games;
	
	
	public Player() {
		//default no parameter constructor
	}
	
	public Player(String name, Game[] games) {
		this.name = name;
		this.games = games;
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Game[] getGames() {
		return games;
	}
	
	public void setGames(Game[] games) {
		this.games = games;
	}
	
	public String getName() {
		return name;
	}
	

}
