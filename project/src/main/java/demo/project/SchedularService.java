package demo.project;

public class SchedularService implements ISchedularService {
	private GameRepo gameR = new GameRepo();
	private DayRepo dayR = new DayRepo();
	private PlayerRepo playerR = new PlayerRepo();

	
	public String createGame(Game g) {
		StringBuilder sb = new StringBuilder(40);

		if (g == null) {
			sb.append("Game should not be null"); // Check if game object passed is null
			return sb.toString();
		}

		if (g.getNoOfPlayers() == 0) {
			sb.append("No. of players should not be zero"); // Check if game object passed does not have any players
			return sb.toString();
		}

		if (g.getName().isEmpty()) {
			sb.append("Game name should not be empty"); // Check if game object passed does not have a game name
			return sb.toString();
		}

		return gameR.save(g);
	}

	
	public String createPlayer(Player p) {
		StringBuilder sb1 = new StringBuilder(40);
		boolean playerGameExistInGameList = false;

		if (p == null) {
			sb1.append("Player object should not be null"); // Checking if player object passed is null
			return sb1.toString();
		}

		if (p.getGames()[0] == null) {
			sb1.append("Player's game list should not be null"); // Checking if game list of Player is null
			return sb1.toString();
		}

		if (p.getName().isEmpty()) {
			sb1.append("Player name should not be empty"); // Check if player object passed does not have a player name
			return sb1.toString();
		}

		for (int i = 0; i < p.getGames().length; i++) { // Check if the game exist in the game repository
			if (p.getGames()[i] == null) {
				break;
			}
			if (gameR.findOne(p.getGames()[i].getName()) != null) { // if findOne finds a match, it returns a game object which is non-null
				playerGameExistInGameList = true;
			}

		}

		if (!playerGameExistInGameList) {
			sb1.append("Player's games cannot be found in game list");
			return sb1.toString();
		}

		return playerR.save(p);
	}

	
	public String createDay(Day d) {
		StringBuilder sb2 = new StringBuilder(40);
		boolean dayGameExistInGameList = false;

		if (d == null) {
			sb2.append("Day object should not be null"); // Check if the day object passed is null
			return sb2.toString();
		}

		if (d.getGames()[0] == null) {
			sb2.append("Day's game list should not be null"); // Check if game list of Day is null
			return sb2.toString();
		}

		if (d.getName().isEmpty()) {
			sb2.append("Day name should not be empty"); // Check if day object passed does not have a day name
			return sb2.toString();
		}

		for (int i = 0; i < d.getGames().length; i++) { // Check if the game exist in the game repository
			if (d.getGames()[i] == null) {
				break;
			}
			if (gameR.findOne(d.getGames()[i].getName()) != null) { // if findOne finds a match, it returns a game object which is non-null
				dayGameExistInGameList = true;
			}

		}

		if (!dayGameExistInGameList) {
			sb2.append("Day's games cannot be found in game list");
			return sb2.toString();
		}

		return dayR.save(d);
	}

	
	public StringBuffer gameWiseReport(String gameName) {
		StringBuffer sb3 = new StringBuffer(40);
		Player[] playerList = playerR.findAll();
		Day[] dayList = dayR.findAll();
		
		if(gameName.equals("")) {
			sb3.append("Game's name should not be empty");
			return sb3;
		}	
		
		
		if(gameR.findOne(gameName) == null) {
			sb3.append("Game does not exist in game repository");
			return sb3;
		}
		
		


		for (int i = 0; i < playerList.length; i++) {
			if(playerList[i] == null) {
				break;
			}
			Game[] gameListOfPlayer = playerList[i].getGames(); // accessing each game array of each player
			for (int j = 0; j < gameListOfPlayer.length; j++) {
				if (playerList[i].getGames()[j].getName().equals(gameName)) {
					sb3.append(playerList[i].getName() + " ");
				}

			}

		}
		
		sb3.append("\n");

		for (int k = 0; k < dayList.length; k++) {
			if(dayList[k] == null) {
				break;
			}
			Game[] gameListOfDay = dayList[k].getGames(); // accessing each game array of each day
			for (int l = 0; l < gameListOfDay.length; l++) {
				if (dayList[k].getGames()[l].getName().equals(gameName)) {
					sb3.append(dayList[k].getName() + " ");
				}
			}
		}
	

	return sb3;

	}

	
	public StringBuffer playerWiseReport(String playerName) {
		StringBuffer sb4 = new StringBuffer(40);
		Player playerObject = playerR.findOne(playerName);
		Day[] dayList = dayR.findAll();
		
		if(playerName.equals("")) {
			sb4.append("Player's name should not be empty");
			return sb4;
		}	
		
		
		if(playerR.findOne(playerName) == null) {
			sb4.append("Player does not exist in player repository");
			return sb4;
		}
		
		
		Game[] gameListOfPlayer = playerObject.getGames();
		
		for(int i=0; i< gameListOfPlayer.length; i++) {
			sb4.append(gameListOfPlayer[i].getName() + " ");
				}
			

		sb4.append("\n");
		
		for (int j = 0; j < gameListOfPlayer.length; j++) {
			for (int k = 0; k < dayList.length; k++) {
				Game[] gameListOfDay = dayList[k].getGames();
				for (int l = 0; l < gameListOfDay.length; l++) {
					if (gameListOfPlayer[j].getName().equals(gameListOfDay[l].getName())) {
						sb4.append(gameListOfPlayer[j].getName() + " played on " +  dayList[k].getName() + "\n");
					}
				}
			}
		}
		return sb4;
	}

	
	public StringBuffer dayWiseReport(String dayName) {
		StringBuffer sb5 = new StringBuffer(40);
		Day dayObject = dayR.findOne(dayName);
		Player[] playerList = playerR.findAll();
		
		if(dayName.equals("")) {
			sb5.append("Day's name should not be empty");
			return sb5;
		}		
		
		if(dayR.findOne(dayName) == null) {
			sb5.append("Day does not exist in day repository");
			return sb5;
		}
		
		

		Game[] gameListOfDay = dayObject.getGames();

		for (int i = 0; i < gameListOfDay.length; i++) {
			sb5.append(gameListOfDay[i].getName() + " ");
		}

		sb5.append("\n");

		for (int j = 0; j < gameListOfDay.length; j++) {
			for (int k = 0; k < playerList.length; k++) {
				Game[] gameListOfPlayer = playerList[k].getGames();
				for (int l = 0; l < gameListOfPlayer.length; l++) {
					if (gameListOfDay[j].getName().equals(gameListOfPlayer[l].getName())) {
						sb5.append(gameListOfDay[j].getName() + " played by " + playerList[k].getName() + "\n");
					}
				}

			}
		}
		return sb5;

	}

}
