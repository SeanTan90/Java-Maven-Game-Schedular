package demo.project;

public class PlayerRepo implements IPlayerRepo {
	Player[] players = new Player[5];
	
	
	
	public String save(Player p) {
		StringBuilder sb = new StringBuilder(40);
		
		for(int i=0; i<players.length; i++) {
			if(players[i] == null) {
				break;
			}
			if(p.getName().equals(players[i].getName())) {
				sb.append("Player already exist within Player List"); // Check if player object already exist in players array
				return sb.toString();
			}
				
		}
		
		for(int j=0; j<players.length; j++) { //Adding player object to the players array
			if(players[j] == null) { 
				players[j] = p;
				sb.append("Successful adding of Player");
				break;
			}
		}
		return sb.toString();
	}
		
		
		
	
	

	
	public Player findOne(String name) {
		
		for(int i=0; i<players.length; i++) {
			if(players[i].getName().equals(name)) {
				return players[i]; // returns a Player object if Player name from parameter matches a player from Player repository
			}
		}
		return null;
	}

	
	public Player[] findAll() {
		return players;
	}

}
