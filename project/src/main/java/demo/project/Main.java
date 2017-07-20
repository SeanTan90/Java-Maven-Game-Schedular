package demo.project;

public class Main {
	
	private Main() {
		//default no parameter constructor (private)
	}

	public static void main(String[] args) {
		
		
		// Create 5 Game objects
		Game basketball = new Game("basketball",2);
		Game football = new Game("football",3);
		Game tennis = new Game("tennis",1);
		Game badminton = new Game("badminton",2);
		Game hockey = new Game("hockey",1);
		
		
		
		//Declare the games that each player plays
		Game[] gamesTomPlay = {basketball, football, tennis};
		Game[] gamesJohnPlay = {basketball, badminton, hockey};
		Game[] gamesMaxPlay = {tennis, badminton};
		Game[] gamesJanePlay = {football, hockey};
		Game[] gamesSallyPlay = {tennis, badminton, hockey}; 
		
		
		// Create 5 Player objects
		Player tom = new Player("tom", gamesTomPlay);
		Player john = new Player("john", gamesJohnPlay);
		Player max = new Player("max", gamesMaxPlay);
		Player jane = new Player("jane",gamesJanePlay);
		Player sally = new Player("sally", gamesSallyPlay);
		
		// Create a SchedularService object
		SchedularService service = new SchedularService();
		
		//Declare the games of each day
		Game[] gamesPlayedOnDay1 = {basketball, football};
		Game[] gamesPlayedOnDay2 = {tennis, badminton};
		Game[] gamesPlayedOnDay3 = {football, tennis, hockey};
		Game[] gamesPlayedOnDay4 = {basketball,tennis, hockey};
		Game[] gamesPlayedOnDay5 = {badminton, hockey};
		
		// Create 5 Day objects
		Day day1 = new Day("day1", gamesPlayedOnDay1);
		Day day2 = new Day("day2", gamesPlayedOnDay2);
		Day day3 = new Day("day3", gamesPlayedOnDay3);
		Day day4 = new Day("day4", gamesPlayedOnDay4);
		Day day5 = new Day("day5", gamesPlayedOnDay5);
		
		
		
		// Create 5 games
		service.createGame(basketball);
		service.createGame(football);
		service.createGame(tennis);
		service.createGame(badminton);
		service.createGame(hockey);
		
		// Create 5 players
		service.createPlayer(tom);
		service.createPlayer(john);
		service.createPlayer(max);
		service.createPlayer(jane);
		service.createPlayer(sally);
		
		// Create 5 days
		service.createDay(day1);
		service.createDay(day2);
		service.createDay(day3);
		service.createDay(day4);
		service.createDay(day5);
		
		System.out.println(service.gameWiseReport("basketball"));
		System.out.println(service.playerWiseReport("tom"));
		System.out.println(service.dayWiseReport("day2"));
	}

}
