package demo.project;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestForSchedular {
	final private String basketball = "basketball";
	final private String football = "football";
	final private String tennis = "tennis";
	final private String badminton = "badminton";
	final private String sally = "sally";
	
	@Test
	public void addGameSuccess() {

		Game testGame = new Game(basketball,2);
		SchedularService testService = new SchedularService();
		assertEquals("Successful adding of Game",testService.createGame(testGame));
	}
	
	
	@Test
	public void addDuplicateGame() {
		Game testGame = new Game(basketball,2);
		SchedularService testService = new SchedularService();
		testService.createGame(testGame);
		assertEquals("Game already exist within Game List",testService.createGame(testGame));
	}

	@Test
	public void addGameWithoutName() {
		Game testGame = new Game("",2);
		SchedularService testService = new SchedularService();
		testService.createGame(testGame);
		assertEquals("Game name should not be empty",testService.createGame(testGame));
	}
	
	
	@Test
	public void addGameWithoutPlayers() {
		Game testGame = new Game(basketball,0);
		SchedularService testService = new SchedularService();
		testService.createGame(testGame);
		assertEquals("No. of players should not be zero",testService.createGame(testGame));
	}
	
	@Test
	public void addNullGame() {
		Game testGame = null;
		SchedularService testService = new SchedularService();
		testService.createGame(testGame);
		assertEquals("Game should not be null",testService.createGame(testGame));
	}
	
	
	
	@Test
	public void addPlayerSuccess() {
		
		SchedularService testService = new SchedularService();
		
		Game basketball = new Game(basketball,2);
		Game football = new Game(football,3);
		Game tennis = new Game(tennis,1);

		
		testService.createGame(tennis);
		
		Game[] gamesTestPlayerPlay = {basketball, football, tennis};
		Player testPlayer = new Player("tom", gamesTestPlayerPlay);
		assertEquals("Successful adding of Player",testService.createPlayer(testPlayer));
	}
	
	
	@Test
	public void addPlayerWhoDoNotPlayGame() {
		
		SchedularService testService = new SchedularService();
		
		Game basketball = new Game(basketball,2);
		Game football = new Game(football,3);
		Game tennis = new Game(tennis,1);

		
		testService.createGame(tennis);
		
		Game[] gamesTestPlayerPlay = new Game[5]; //Initialize an array of nulls, no games added under Tom
		Player testPlayer = new Player("tom", gamesTestPlayerPlay);
		assertEquals("Player's game list should not be null",testService.createPlayer(testPlayer));
	}
	
	
	@Test
	public void addPlayerWithoutName() {
		
		SchedularService testService = new SchedularService();
		
		Game basketball = new Game(basketball,2);
		Game football = new Game(football,3);
		Game tennis = new Game(tennis,1);

		
		testService.createGame(tennis);
		
		Game[] gamesTestPlayerPlay = {basketball, football, tennis};
		
		Player testPlayer = new Player("", gamesTestPlayerPlay);
		assertEquals("Player name should not be empty",testService.createPlayer(testPlayer));
	}
	
	
	@Test
	public void addDuplicatePlayer() {
		
		SchedularService testService = new SchedularService();
		
		Game basketball = new Game(basketball,2);
		Game football = new Game(football,3);
		Game tennis = new Game(tennis,1);

		
		testService.createGame(tennis);
		
		Game[] gamesTestPlayerPlay = {basketball, football, tennis};
		
		Player testPlayer = new Player("tom", gamesTestPlayerPlay);
		
		testService.createPlayer(testPlayer);
		assertEquals("Player already exist within Player List",testService.createPlayer(testPlayer));
	}
	
	
	@Test
	public void addNullPlayer() {
		
		SchedularService testService = new SchedularService();

		Player testPlayer = null;
		
		testService.createPlayer(testPlayer);
		
		assertEquals("Player object should not be null",testService.createPlayer(testPlayer));
	}
	
	@Test
	public void addNullDay() {
		
		SchedularService testService = new SchedularService();

		Day testDay = null;		
		assertEquals("Day object should not be null",testService.createDay(testDay));
	}
	
	@Test
	public void addDaySuccess() {
		
		SchedularService testService = new SchedularService();
		
		Game basketball = new Game(basketball,2);
		Game football = new Game(football,3);
		Game tennis = new Game(tennis,1);
		
		testService.createGame(tennis);
		
		Game[] gamesPlayedOnTestDay = {basketball, football, tennis};
		
		Day testDay = new Day("testDay",gamesPlayedOnTestDay );
		assertEquals("Successful adding of Day",testService.createDay(testDay));
	}
	
	
	@Test
	public void addDayWithoutName() {
		
		SchedularService testService = new SchedularService();
		
		Game basketball = new Game(basketball,2);
		Game football = new Game(football,3);
		Game tennis = new Game(tennis,1);
		
		testService.createGame(tennis);
		
		Game[] gamesPlayedOnTestDay = {basketball, football, tennis};
		
		Day testDay = new Day("",gamesPlayedOnTestDay );
		assertEquals("Day name should not be empty",testService.createDay(testDay));
	}
	
	
	
	@Test
	public void addDuplicateDay() {
		
		SchedularService testService = new SchedularService();
		
		Game basketball = new Game(basketball,2);
		Game football = new Game(football,3);
		Game tennis = new Game(tennis,1);
		
		testService.createGame(tennis);
		
		Game[] gamesPlayedOnTestDay = {basketball, football, tennis};
		
		Day testDay = new Day("testDay",gamesPlayedOnTestDay );
		testService.createDay(testDay);
		assertEquals("Day already exist within Day List",testService.createDay(testDay));
	}
	
	
	@Test
	public void addDayWithNoGamesPlayed() {
		
		SchedularService testService = new SchedularService();
		
		Game basketball = new Game("basketball",2);
		Game football = new Game("football",3);
		Game tennis = new Game("tennis",1);
		
		testService.createGame(tennis);
		
		Game[] gamesPlayedOnTestDay = new Game[5];
		
		Day testDay = new Day("testDay",gamesPlayedOnTestDay );
		testService.createDay(testDay);
		assertEquals("Day's game list should not be null",testService.createDay(testDay));
	}
	
	@Test
	public void generateGameWiseReportSuccess() {
		
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
				
				// Create a SchedularService object
				SchedularService testService = new SchedularService();
				
				// Create 5 games
				testService.createGame(basketball);
				testService.createGame(football);
				testService.createGame(tennis);
				testService.createGame(badminton);
				testService.createGame(hockey);
				
				// Create 5 players
				testService.createPlayer(tom);
				testService.createPlayer(john);
				testService.createPlayer(max);
				testService.createPlayer(jane);
				testService.createPlayer(sally);
				
				// Create 5 days
				testService.createDay(day1);
				testService.createDay(day2);
				testService.createDay(day3);
				testService.createDay(day4);
				testService.createDay(day5);
						
		assertEquals("tom john " + "\n" + "day1 day4 ",testService.gameWiseReport("basketball").toString());
	}
	
	@Test
	public void generatePlayerWiseReportSuccess() {
		
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
				
				// Create a SchedularService object
				SchedularService testService = new SchedularService();
				
				// Create 5 games
				testService.createGame(basketball);
				testService.createGame(football);
				testService.createGame(tennis);
				testService.createGame(badminton);
				testService.createGame(hockey);
				
				// Create 5 players
				testService.createPlayer(tom);
				testService.createPlayer(john);
				testService.createPlayer(max);
				testService.createPlayer(jane);
				testService.createPlayer(sally);
				
				// Create 5 days
				testService.createDay(day1);
				testService.createDay(day2);
				testService.createDay(day3);
				testService.createDay(day4);
				testService.createDay(day5);
						
		assertEquals("basketball football tennis " + "\n" + "basketball played on day1" + "\n" + "basketball played on day4" + "\n" 
						+ "football played on day1" + "\n" + "football played on day3" + "\n" + "tennis played on day2" + "\n"
						+ "tennis played on day3" + "\n" + "tennis played on day4" + "\n",testService.playerWiseReport("tom").toString());
	}
	
	@Test
	public void generateDayWiseReportSuccess() {
		
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
				
				// Create a SchedularService object
				SchedularService testService = new SchedularService();
				
				// Create 5 games
				testService.createGame(basketball);
				testService.createGame(football);
				testService.createGame(tennis);
				testService.createGame(badminton);
				testService.createGame(hockey);
				
				// Create 5 players
				testService.createPlayer(tom);
				testService.createPlayer(john);
				testService.createPlayer(max);
				testService.createPlayer(jane);
				testService.createPlayer(sally);
				
				// Create 5 days
				testService.createDay(day1);
				testService.createDay(day2);
				testService.createDay(day3);
				testService.createDay(day4);
				testService.createDay(day5);
						
		assertEquals("tennis badminton " + "\n" + "tennis played by tom" + "\n" + "tennis played by max" + "\n" 
						+ "tennis played by sally" + "\n" + "badminton played by john" + "\n" + "badminton played by max" + "\n"
						+ "badminton played by sally" + "\n",testService.dayWiseReport("day2").toString());
	}
	
	@Test
	public void generateGameWiseReportOfNonExistantGame() {
		
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
				
				// Create a SchedularService object
				SchedularService testService = new SchedularService();
				
				// Create 5 games
				testService.createGame(basketball);
				testService.createGame(football);
				testService.createGame(tennis);
				testService.createGame(badminton);
				testService.createGame(hockey);
				
				// Create 5 players
				testService.createPlayer(tom);
				testService.createPlayer(john);
				testService.createPlayer(max);
				testService.createPlayer(jane);
				testService.createPlayer(sally);
				
				// Create 5 days
				testService.createDay(day1);
				testService.createDay(day2);
				testService.createDay(day3);
				testService.createDay(day4);
				testService.createDay(day5);
						
		assertEquals("Game does not exist in game repository",testService.gameWiseReport("swimming").toString());
	}
	
	@Test
	public void generatePlayerWiseReportOfNonExistantPlayer() {
		
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
				
				// Create a SchedularService object
				SchedularService testService = new SchedularService();
				
				// Create 5 games
				testService.createGame(basketball);
				testService.createGame(football);
				testService.createGame(tennis);
				testService.createGame(badminton);
				testService.createGame(hockey);
				
				// Create 5 players
				testService.createPlayer(tom);
				testService.createPlayer(john);
				testService.createPlayer(max);
				testService.createPlayer(jane);
				testService.createPlayer(sally);
				
				// Create 5 days
				testService.createDay(day1);
				testService.createDay(day2);
				testService.createDay(day3);
				testService.createDay(day4);
				testService.createDay(day5);
						
		assertEquals("Player does not exist in player repository",testService.playerWiseReport("Robert").toString());
	}
	
	@Test
	public void generateDayWiseReportOfNonExistantDay() {
		
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
				
				// Create a SchedularService object
				SchedularService testService = new SchedularService();
				
				// Create 5 games
				testService.createGame(basketball);
				testService.createGame(football);
				testService.createGame(tennis);
				testService.createGame(badminton);
				testService.createGame(hockey);
				
				// Create 5 players
				testService.createPlayer(tom);
				testService.createPlayer(john);
				testService.createPlayer(max);
				testService.createPlayer(jane);
				testService.createPlayer(sally);
				
				// Create 5 days
				testService.createDay(day1);
				testService.createDay(day2);
				testService.createDay(day3);
				testService.createDay(day4);
				testService.createDay(day5);
						
		assertEquals("Day does not exist in day repository",testService.dayWiseReport("day7").toString());
	}
	
	@Test
	public void generateGameWiseReportWithEmptyGame() {
		
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
				
				// Create a SchedularService object
				SchedularService testService = new SchedularService();
				
				// Create 5 games
				testService.createGame(basketball);
				testService.createGame(football);
				testService.createGame(tennis);
				testService.createGame(badminton);
				testService.createGame(hockey);
				
				// Create 5 players
				testService.createPlayer(tom);
				testService.createPlayer(john);
				testService.createPlayer(max);
				testService.createPlayer(jane);
				testService.createPlayer(sally);
				
				// Create 5 days
				testService.createDay(day1);
				testService.createDay(day2);
				testService.createDay(day3);
				testService.createDay(day4);
				testService.createDay(day5);
						
		assertEquals("Game's name should not be empty",testService.gameWiseReport("").toString());
	}
	
	@Test
	public void generatePlayerWiseReportWithEmptyPlayer() {
		
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
				
				// Create a SchedularService object
				SchedularService testService = new SchedularService();
				
				// Create 5 games
				testService.createGame(basketball);
				testService.createGame(football);
				testService.createGame(tennis);
				testService.createGame(badminton);
				testService.createGame(hockey);
				
				// Create 5 players
				testService.createPlayer(tom);
				testService.createPlayer(john);
				testService.createPlayer(max);
				testService.createPlayer(jane);
				testService.createPlayer(sally);
				
				// Create 5 days
				testService.createDay(day1);
				testService.createDay(day2);
				testService.createDay(day3);
				testService.createDay(day4);
				testService.createDay(day5);
						
		assertEquals("Player's name should not be empty",testService.playerWiseReport("").toString());
	}
	
	@Test
	public void generateDayWiseReportWithEmptyDay() {
		
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
				
				// Create a SchedularService object
				SchedularService testService = new SchedularService();
				
				// Create 5 games
				testService.createGame(basketball);
				testService.createGame(football);
				testService.createGame(tennis);
				testService.createGame(badminton);
				testService.createGame(hockey);
				
				// Create 5 players
				testService.createPlayer(tom);
				testService.createPlayer(john);
				testService.createPlayer(max);
				testService.createPlayer(jane);
				testService.createPlayer(sally);
				
				// Create 5 days
				testService.createDay(day1);
				testService.createDay(day2);
				testService.createDay(day3);
				testService.createDay(day4);
				testService.createDay(day5);
						
		assertEquals("Day's name should not be empty",testService.dayWiseReport("").toString());
	}
	
}

