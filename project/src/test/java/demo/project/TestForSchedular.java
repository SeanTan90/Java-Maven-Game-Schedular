package demo.project;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestForSchedular {
	String basketballStr = "basketball";
	String footballStr = "football";
	String tennisStr = "tennis";
	String badmintonStr = "badminton";
	String hockeyStr = "hockey";
	String tomStr = "tom";
	String johnStr = "john";
	String maxStr = "max";
	String janeStr = "jane";
	String sallyStr = "sally";
	String testDayStr = "testDay";
	
	@Test
	public void addGameSuccess() {

		Game testGame = new Game(basketballStr,2);
		SchedularService testService = new SchedularService();
		assertEquals("Successful adding of Game",testService.createGame(testGame));
	}
	
	
	@Test
	public void addDuplicateGame() {
		Game testGame = new Game(basketballStr,2);
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
		Game testGame = new Game(basketballStr,0);
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
		
		Game basketballTest = new Game(basketballStr,2);
		Game footballTest = new Game(footballStr,3);
		Game tennisTest = new Game(tennisStr,1);

		
		testService.createGame(tennisTest);
		
		Game[] gamesTestPlayerPlay = {basketballTest, footballTest, tennisTest};
		Player testPlayer = new Player("tom", gamesTestPlayerPlay);
		assertEquals("Successful adding of Player",testService.createPlayer(testPlayer));
	}
	
	
	@Test
	public void addPlayerWhoDoNotPlayGame() {
		
		SchedularService testService = new SchedularService();
		

		Game tennis = new Game(tennisStr,1);

		
		testService.createGame(tennis);
		
		Game[] gamesTestPlayerPlay = new Game[5]; //Initialize an array of nulls, no games added under Tom
		Player testPlayer = new Player("tom", gamesTestPlayerPlay);
		assertEquals("Player's game list should not be null",testService.createPlayer(testPlayer));
	}
	
	
	@Test
	public void addPlayerWithoutName() {
		
		SchedularService testService = new SchedularService();
		
		Game testBasketball = new Game(basketballStr,2);
		Game testFootball = new Game(footballStr,3);
		Game testTennis = new Game(tennisStr,1);

		
		testService.createGame(testTennis);
		
		Game[] gamesTestPlayerPlay = {testBasketball, testFootball, testTennis};
		
		Player testPlayer = new Player("", gamesTestPlayerPlay);
		assertEquals("Player name should not be empty",testService.createPlayer(testPlayer));
	}
	
	
	@Test
	public void addDuplicatePlayer() {
		
		SchedularService testService = new SchedularService();
		
		Game basketball_test = new Game(basketballStr,2);
		Game football_test = new Game(footballStr,3);
		Game tennis_test = new Game(tennisStr,1);

		
		testService.createGame(tennis_test);
		
		Game[] gamesTestPlayerPlay = {basketball_test, football_test, tennis_test};
		
		Player testPlayer = new Player(tomStr, gamesTestPlayerPlay);
		
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
		
		Game basketball_Test = new Game(basketballStr,2);
		Game football_Test = new Game(footballStr,3);
		Game tennis_Test = new Game(tennisStr,1);
		
		testService.createGame(tennis_Test);
		
		Game[] gamesPlayedOnTestDay = {basketball_Test, football_Test, tennis_Test};
		
		Day testDay = new Day(testDayStr,gamesPlayedOnTestDay );
		assertEquals("Successful adding of Day",testService.createDay(testDay));
	}
	
	
	@Test
	public void addDayWithoutName() {
		
		SchedularService testService = new SchedularService();
		
		Game basketball_TesT = new Game(basketballStr,2);
		Game football_TesT = new Game(footballStr,3);
		Game tennis_TesT = new Game(tennisStr,1);
		
		testService.createGame(tennis_TesT);
		
		Game[] gamesPlayedOnTestDay = {basketball_TesT, football_TesT, tennis_TesT};
		
		Day testDay = new Day("",gamesPlayedOnTestDay );
		assertEquals("Day name should not be empty",testService.createDay(testDay));
	}
	
	
	
	@Test
	public void addDuplicateDay() {
		
		SchedularService testService = new SchedularService();
		
		Game basketballTesting = new Game(basketballStr,2);
		Game footballTesting = new Game(footballStr,3);
		Game tennisTesting = new Game(tennisStr,1);
		
		testService.createGame(tennisTesting);
		
		Game[] gamesPlayedOnTestDay = {basketballTesting, footballTesting, tennisTesting};
		
		Day testDay = new Day(testDayStr,gamesPlayedOnTestDay );
		testService.createDay(testDay);
		assertEquals("Day already exist within Day List",testService.createDay(testDay));
	}
	
	
	@Test
	public void addDayWithNoGamesPlayed() {
		
		SchedularService testService = new SchedularService();
		
		Game tennis = new Game(tennisStr,1);
		
		testService.createGame(tennis);
		
		Game[] gamesPlayedOnTestDay = new Game[5]; // create a game array filled with null since uninitialized
		
		Day testDay = new Day(testDayStr,gamesPlayedOnTestDay );
		testService.createDay(testDay);
		assertEquals("Day's game list should not be null",testService.createDay(testDay));
	}
	
	@Test
	public void generateGameWiseReportSuccess() {
		
				// Create 5 Game objects
				Game basketball = new Game(basketballStr,2);
				Game football = new Game(footballStr,3);
				Game tennis = new Game(tennisStr,1);
				Game badminton = new Game(badmintonStr,2);
				Game hockey = new Game(hockeyStr,1);
				
				
				
				//Declare the games that each player plays
				Game[] gamesTomPlay = {basketball, football, tennis};
				Game[] gamesJohnPlay = {basketball, badminton, hockey};
				Game[] gamesMaxPlay = {tennis, badminton};
				Game[] gamesJanePlay = {football, hockey};
				Game[] gamesSallyPlay = {tennis, badminton, hockey}; 
				
				
				// Create 5 Player objects
				Player tom = new Player(tomStr, gamesTomPlay);
				Player john = new Player(johnStr, gamesJohnPlay);
				Player max = new Player(maxStr, gamesMaxPlay);
				Player jane = new Player(janeStr,gamesJanePlay);
				Player sally = new Player(sallyStr, gamesSallyPlay);
				
				
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
				Game basketball1 = new Game(basketballStr,2);
				Game football1 = new Game(footballStr,3);
				Game tennis1 = new Game(tennisStr,1);
				Game badminton1 = new Game(badmintonStr,2);
				Game hockey1 = new Game(hockeyStr,1);
				
				
				
				//Declare the games that each player plays
				Game[] gamesTomPlay1 = {basketball1, football1, tennis1};
				Game[] gamesJohnPlay1 = {basketball1, badminton1, hockey1};
				Game[] gamesMaxPlay1 = {tennis1, badminton1};
				Game[] gamesJanePlay1 = {football1, hockey1};
				Game[] gamesSallyPlay1 = {tennis1, badminton1, hockey1}; 
				
				
				// Create 5 Player objects
				Player tom1 = new Player(tomStr, gamesTomPlay1);
				Player john1 = new Player(johnStr, gamesJohnPlay1);
				Player max1 = new Player(maxStr, gamesMaxPlay1);
				Player jane1 = new Player(janeStr,gamesJanePlay1);
				Player sally1 = new Player(sallyStr, gamesSallyPlay1);
				
				
				//Declare the games of each day
				Game[] gamesPlayedOnDay1 = {basketball1, football1};
				Game[] gamesPlayedOnDay2 = {tennis1, badminton1};
				Game[] gamesPlayedOnDay3 = {football1, tennis1, hockey1};
				Game[] gamesPlayedOnDay4 = {basketball1,tennis1, hockey1};
				Game[] gamesPlayedOnDay5 = {badminton1, hockey1};
				
				// Create 5 Day objects
				Day day1 = new Day("day1", gamesPlayedOnDay1);
				Day day2 = new Day("day2", gamesPlayedOnDay2);
				Day day3 = new Day("day3", gamesPlayedOnDay3);
				Day day4 = new Day("day4", gamesPlayedOnDay4);
				Day day5 = new Day("day5", gamesPlayedOnDay5);
				
				// Create a SchedularService object
				SchedularService testService = new SchedularService();
				
				// Create 5 games
				testService.createGame(basketball1);
				testService.createGame(football1);
				testService.createGame(tennis1);
				testService.createGame(badminton1);
				testService.createGame(hockey1);
				
				// Create 5 players
				testService.createPlayer(tom1);
				testService.createPlayer(john1);
				testService.createPlayer(max1);
				testService.createPlayer(jane1);
				testService.createPlayer(sally1);
				
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
				Game basketball2 = new Game(basketballStr,2);
				Game football2 = new Game(footballStr,3);
				Game tennis2 = new Game(tennisStr,1);
				Game badminton2 = new Game(badmintonStr,2);
				Game hockey2 = new Game(hockeyStr,1);
				
				
				
				//Declare the games that each player plays
				Game[] gamesTomPlay2 = {basketball2, football2, tennis2};
				Game[] gamesJohnPlay2 = {basketball2, badminton2, hockey2};
				Game[] gamesMaxPlay2 = {tennis2, badminton2};
				Game[] gamesJanePlay2 = {football2, hockey2};
				Game[] gamesSallyPlay2 = {tennis2, badminton2, hockey2}; 
				
				
				// Create 5 Player objects
				Player tom2 = new Player(tomStr, gamesTomPlay2);
				Player john2 = new Player(johnStr, gamesJohnPlay2);
				Player max2 = new Player(maxStr, gamesMaxPlay2);
				Player jane2 = new Player(janeStr,gamesJanePlay2);
				Player sally2 = new Player(sallyStr, gamesSallyPlay2);
				
				
				//Declare the games of each day
				Game[] gamesPlayedOnDay1 = {basketball2, football2};
				Game[] gamesPlayedOnDay2 = {tennis2, badminton2};
				Game[] gamesPlayedOnDay3 = {football2, tennis2, hockey2};
				Game[] gamesPlayedOnDay4 = {basketball2,tennis2, hockey2};
				Game[] gamesPlayedOnDay5 = {badminton2, hockey2};
				
				// Create 5 Day objects
				Day day1 = new Day("day1", gamesPlayedOnDay1);
				Day day2 = new Day("day2", gamesPlayedOnDay2);
				Day day3 = new Day("day3", gamesPlayedOnDay3);
				Day day4 = new Day("day4", gamesPlayedOnDay4);
				Day day5 = new Day("day5", gamesPlayedOnDay5);
				
				// Create a SchedularService object
				SchedularService testService = new SchedularService();
				
				// Create 5 games
				testService.createGame(basketball2);
				testService.createGame(football2);
				testService.createGame(tennis2);
				testService.createGame(badminton2);
				testService.createGame(hockey2);
				
				// Create 5 players
				testService.createPlayer(tom2);
				testService.createPlayer(john2);
				testService.createPlayer(max2);
				testService.createPlayer(jane2);
				testService.createPlayer(sally2);
				
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
				Game basketball3 = new Game(basketballStr,2);
				Game football3 = new Game(footballStr,3);
				Game tennis3 = new Game(tennisStr,1);
				Game badminton3 = new Game(badmintonStr,2);
				Game hockey3 = new Game(hockeyStr,1);
				
				
				
				//Declare the games that each player plays
				Game[] gamesTomPlay3 = {basketball3, football3, tennis3};
				Game[] gamesJohnPlay3 = {basketball3, badminton3, hockey3};
				Game[] gamesMaxPlay3 = {tennis3, badminton3};
				Game[] gamesJanePlay3 = {football3, hockey3};
				Game[] gamesSallyPlay3 = {tennis3, badminton3, hockey3}; 
				
				
				// Create 5 Player objects
				Player tom3 = new Player(tomStr, gamesTomPlay3);
				Player john3 = new Player(johnStr, gamesJohnPlay3);
				Player max3 = new Player(maxStr, gamesMaxPlay3);
				Player jane3 = new Player(janeStr,gamesJanePlay3);
				Player sally3 = new Player(sallyStr, gamesSallyPlay3);
				
				
				//Declare the games of each day
				Game[] gamesPlayedOnDay1 = {basketball3, football3};
				Game[] gamesPlayedOnDay2 = {tennis3, badminton3};
				Game[] gamesPlayedOnDay3 = {football3, tennis3, hockey3};
				Game[] gamesPlayedOnDay4 = {basketball3,tennis3, hockey3};
				Game[] gamesPlayedOnDay5 = {badminton3, hockey3};
				
				// Create 5 Day objects
				Day day1 = new Day("day1", gamesPlayedOnDay1);
				Day day2 = new Day("day2", gamesPlayedOnDay2);
				Day day3 = new Day("day3", gamesPlayedOnDay3);
				Day day4 = new Day("day4", gamesPlayedOnDay4);
				Day day5 = new Day("day5", gamesPlayedOnDay5);
				
				// Create a SchedularService object
				SchedularService testService = new SchedularService();
				
				// Create 5 games
				testService.createGame(basketball3);
				testService.createGame(football3);
				testService.createGame(tennis3);
				testService.createGame(badminton3);
				testService.createGame(hockey3);
				
				// Create 5 players
				testService.createPlayer(tom3);
				testService.createPlayer(john3);
				testService.createPlayer(max3);
				testService.createPlayer(jane3);
				testService.createPlayer(sally3);
				
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
				Game basketball4 = new Game(basketballStr,2);
				Game football4 = new Game(footballStr,3);
				Game tennis4 = new Game(tennisStr,1);
				Game badminton4 = new Game(badmintonStr,2);
				Game hockey4 = new Game(hockeyStr,1);
				
				
				
				//Declare the games that each player plays
				Game[] gamesTomPlay4 = {basketball4, football4, tennis4};
				Game[] gamesJohnPlay4 = {basketball4, badminton4, hockey4};
				Game[] gamesMaxPlay4 = {tennis4, badminton4};
				Game[] gamesJanePlay4 = {football4, hockey4};
				Game[] gamesSallyPlay4 = {tennis4, badminton4, hockey4}; 
				
				
				// Create 5 Player objects
				Player tom4 = new Player(tomStr, gamesTomPlay4);
				Player john4 = new Player(johnStr, gamesJohnPlay4);
				Player max4 = new Player(maxStr, gamesMaxPlay4);
				Player jane4 = new Player(janeStr,gamesJanePlay4);
				Player sally4 = new Player(sallyStr, gamesSallyPlay4);
				
				
				//Declare the games of each day
				Game[] gamesPlayedOnDay1 = {basketball4, football4};
				Game[] gamesPlayedOnDay2 = {tennis4, badminton4};
				Game[] gamesPlayedOnDay3 = {football4, tennis4, hockey4};
				Game[] gamesPlayedOnDay4 = {basketball4,tennis4, hockey4};
				Game[] gamesPlayedOnDay5 = {badminton4, hockey4};
				
				// Create 5 Day objects
				Day day1 = new Day("day1", gamesPlayedOnDay1);
				Day day2 = new Day("day2", gamesPlayedOnDay2);
				Day day3 = new Day("day3", gamesPlayedOnDay3);
				Day day4 = new Day("day4", gamesPlayedOnDay4);
				Day day5 = new Day("day5", gamesPlayedOnDay5);
				
				// Create a SchedularService object
				SchedularService testService = new SchedularService();
				
				// Create 5 games
				testService.createGame(basketball4);
				testService.createGame(football4);
				testService.createGame(tennis4);
				testService.createGame(badminton4);
				testService.createGame(hockey4);
				
				// Create 5 players
				testService.createPlayer(tom4);
				testService.createPlayer(john4);
				testService.createPlayer(max4);
				testService.createPlayer(jane4);
				testService.createPlayer(sally4);
				
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
				Game basketball5 = new Game(basketballStr,2);
				Game football5 = new Game(footballStr,3);
				Game tennis5 = new Game(tennisStr,1);
				Game badminton5 = new Game(badmintonStr,2);
				Game hockey5 = new Game(hockeyStr,1);
				
				
				
				//Declare the games that each player plays
				Game[] gamesTomPlay5 = {basketball5, football5, tennis5};
				Game[] gamesJohnPlay5 = {basketball5, badminton5, hockey5};
				Game[] gamesMaxPlay5 = {tennis5, badminton5};
				Game[] gamesJanePlay5 = {football5, hockey5};
				Game[] gamesSallyPlay5 = {tennis5, badminton5, hockey5}; 
				
				
				// Create 5 Player objects
				Player tom5 = new Player(tomStr, gamesTomPlay5);
				Player john5 = new Player(johnStr, gamesJohnPlay5);
				Player max5 = new Player(maxStr, gamesMaxPlay5);
				Player jane5= new Player(janeStr,gamesJanePlay5);
				Player sally5 = new Player(sallyStr, gamesSallyPlay5);
				
				
				//Declare the games of each day
				Game[] gamesPlayedOnDay1 = {basketball5, football5};
				Game[] gamesPlayedOnDay2 = {tennis5, badminton5};
				Game[] gamesPlayedOnDay3 = {football5, tennis5, hockey5};
				Game[] gamesPlayedOnDay4 = {basketball5,tennis5, hockey5};
				Game[] gamesPlayedOnDay5 = {badminton5, hockey5};
				
				// Create 5 Day objects
				Day day1 = new Day("day1", gamesPlayedOnDay1);
				Day day2 = new Day("day2", gamesPlayedOnDay2);
				Day day3 = new Day("day3", gamesPlayedOnDay3);
				Day day4 = new Day("day4", gamesPlayedOnDay4);
				Day day5 = new Day("day5", gamesPlayedOnDay5);
				
				// Create a SchedularService object
				SchedularService testService = new SchedularService();
				
				// Create 5 games
				testService.createGame(basketball5);
				testService.createGame(football5);
				testService.createGame(tennis5);
				testService.createGame(badminton5);
				testService.createGame(hockey5);
				
				// Create 5 players
				testService.createPlayer(tom5);
				testService.createPlayer(john5);
				testService.createPlayer(max5);
				testService.createPlayer(jane5);
				testService.createPlayer(sally5);
				
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
				Game basketball6 = new Game(basketballStr,2);
				Game football6 = new Game(footballStr,3);
				Game tennis6 = new Game(tennisStr,1);
				Game badminton6 = new Game(badmintonStr,2);
				Game hockey6 = new Game(hockeyStr,1);
				
				
				
				//Declare the games that each player plays
				Game[] gamesTomPlay6 = {basketball6, football6, tennis6};
				Game[] gamesJohnPlay6 = {basketball6, badminton6, hockey6};
				Game[] gamesMaxPlay6 = {tennis6, badminton6};
				Game[] gamesJanePlay6 = {football6, hockey6};
				Game[] gamesSallyPlay6 = {tennis6, badminton6, hockey6}; 
				
				
				// Create 5 Player objects
				Player tom6 = new Player(tomStr, gamesTomPlay6);
				Player john6 = new Player(johnStr, gamesJohnPlay6);
				Player max6 = new Player(maxStr, gamesMaxPlay6);
				Player jane6 = new Player(janeStr,gamesJanePlay6);
				Player sally6 = new Player(sallyStr, gamesSallyPlay6);
				
				
				//Declare the games of each day
				Game[] gamesPlayedOnDay1 = {basketball6, football6};
				Game[] gamesPlayedOnDay2 = {tennis6, badminton6};
				Game[] gamesPlayedOnDay3 = {football6, tennis6, hockey6};
				Game[] gamesPlayedOnDay4 = {basketball6,tennis6, hockey6};
				Game[] gamesPlayedOnDay5 = {badminton6, hockey6};
				
				// Create 5 Day objects
				Day day1 = new Day("day1", gamesPlayedOnDay1);
				Day day2 = new Day("day2", gamesPlayedOnDay2);
				Day day3 = new Day("day3", gamesPlayedOnDay3);
				Day day4 = new Day("day4", gamesPlayedOnDay4);
				Day day5 = new Day("day5", gamesPlayedOnDay5);
				
				// Create a SchedularService object
				SchedularService testService = new SchedularService();
				
				// Create 5 games
				testService.createGame(basketball6);
				testService.createGame(football6);
				testService.createGame(tennis6);
				testService.createGame(badminton6);
				testService.createGame(hockey6);
				
				// Create 5 players
				testService.createPlayer(tom6);
				testService.createPlayer(john6);
				testService.createPlayer(max6);
				testService.createPlayer(jane6);
				testService.createPlayer(sally6);
				
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
				Game basketball7 = new Game(basketballStr,2);
				Game football7 = new Game(footballStr,3);
				Game tennis7 = new Game(tennisStr,1);
				Game badminton7 = new Game(badmintonStr,2);
				Game hockey7 = new Game(hockeyStr,1);
				
				
				
				//Declare the games that each player plays
				Game[] gamesTomPlay7 = {basketball7, football7, tennis7};
				Game[] gamesJohnPlay7 = {basketball7, badminton7, hockey7};
				Game[] gamesMaxPlay7 = {tennis7, badminton7};
				Game[] gamesJanePlay7 = {football7, hockey7};
				Game[] gamesSallyPlay7 = {tennis7, badminton7, hockey7}; 
				
				
				// Create 5 Player objects
				Player tom7 = new Player(tomStr, gamesTomPlay7);
				Player john7 = new Player(johnStr, gamesJohnPlay7);
				Player max7 = new Player(maxStr, gamesMaxPlay7);
				Player jane7 = new Player(janeStr,gamesJanePlay7);
				Player sally7 = new Player(sallyStr, gamesSallyPlay7);
				
				
				//Declare the games of each day
				Game[] gamesPlayedOnDay1 = {basketball7, football7};
				Game[] gamesPlayedOnDay2 = {tennis7, badminton7};
				Game[] gamesPlayedOnDay3 = {football7, tennis7, hockey7};
				Game[] gamesPlayedOnDay4 = {basketball7,tennis7, hockey7};
				Game[] gamesPlayedOnDay5 = {badminton7, hockey7};
				
				// Create 5 Day objects
				Day day1 = new Day("day1", gamesPlayedOnDay1);
				Day day2 = new Day("day2", gamesPlayedOnDay2);
				Day day3 = new Day("day3", gamesPlayedOnDay3);
				Day day4 = new Day("day4", gamesPlayedOnDay4);
				Day day5 = new Day("day5", gamesPlayedOnDay5);
				
				// Create a SchedularService object
				SchedularService testService = new SchedularService();
				
				// Create 5 games
				testService.createGame(basketball7);
				testService.createGame(football7);
				testService.createGame(tennis7);
				testService.createGame(badminton7);
				testService.createGame(hockey7);
				
				// Create 5 players
				testService.createPlayer(tom7);
				testService.createPlayer(john7);
				testService.createPlayer(max7);
				testService.createPlayer(jane7);
				testService.createPlayer(sally7);
				
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
				Game basketball8 = new Game(basketballStr,2);
				Game football8 = new Game(footballStr,3);
				Game tennis8 = new Game(tennisStr,1);
				Game badminton8 = new Game(badmintonStr,2);
				Game hockey8 = new Game(hockeyStr,1);
				
				
				
				//Declare the games that each player plays
				Game[] gamesTomPlay8 = {basketball8, football8, tennis8};
				Game[] gamesJohnPlay8 = {basketball8, badminton8, hockey8};
				Game[] gamesMaxPlay8 = {tennis8, badminton8};
				Game[] gamesJanePlay8 = {football8, hockey8};
				Game[] gamesSallyPlay8 = {tennis8, badminton8, hockey8}; 
				
				
				// Create 5 Player objects
				Player tom8 = new Player(tomStr, gamesTomPlay8);
				Player john8 = new Player(johnStr, gamesJohnPlay8);
				Player max8 = new Player(maxStr, gamesMaxPlay8);
				Player jane8 = new Player(janeStr,gamesJanePlay8);
				Player sally8 = new Player(sallyStr, gamesSallyPlay8);
				
				
				//Declare the games of each day
				Game[] gamesPlayedOnDay1 = {basketball8, football8};
				Game[] gamesPlayedOnDay2 = {tennis8, badminton8};
				Game[] gamesPlayedOnDay3 = {football8, tennis8, hockey8};
				Game[] gamesPlayedOnDay4 = {basketball8,tennis8, hockey8};
				Game[] gamesPlayedOnDay5 = {badminton8, hockey8};
				
				// Create 5 Day objects
				Day day1 = new Day("day1", gamesPlayedOnDay1);
				Day day2 = new Day("day2", gamesPlayedOnDay2);
				Day day3 = new Day("day3", gamesPlayedOnDay3);
				Day day4 = new Day("day4", gamesPlayedOnDay4);
				Day day5 = new Day("day5", gamesPlayedOnDay5);
				
				// Create a SchedularService object
				SchedularService testService = new SchedularService();
				
				// Create 5 games
				testService.createGame(basketball8);
				testService.createGame(football8);
				testService.createGame(tennis8);
				testService.createGame(badminton8);
				testService.createGame(hockey8);
				
				// Create 5 players
				testService.createPlayer(tom8);
				testService.createPlayer(john8);
				testService.createPlayer(max8);
				testService.createPlayer(jane8);
				testService.createPlayer(sally8);
				
				// Create 5 days
				testService.createDay(day1);
				testService.createDay(day2);
				testService.createDay(day3);
				testService.createDay(day4);
				testService.createDay(day5);
						
		assertEquals("Day's name should not be empty",testService.dayWiseReport("").toString());
	}
	
}

