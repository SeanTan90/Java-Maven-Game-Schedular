package demo.project;

public class GameRepo implements IGameRepo {
	public Game[] games = new Game[5];

	
	public String save(Game g) {
		StringBuilder sb = new StringBuilder(40);
		
		for(int i=0; i<games.length; i++) {
			if(games[i] == null) {
				break;
			}
			if(g.getName().equals(games[i].getName())) {
				sb.append("Game already exist within Game List"); // Check if game object already exist in games array
				return sb.toString();
			}
		
		}
				
			
		for(int j=0; j<games.length; j++) { //Adding game object to the games array
		if(games[j] == null) {
			games[j] = g;
			sb.append("Successful adding of Game");
			break; //Previously I didn't put break hence the loop keep running and the text keep printing
				}
			}
		return sb.toString();
		}

	
	public Game[] findAll() {
		return games;
	}

	
	public Game findOne(String name) {
		
		
		for(int i=0; i<games.length; i++) {
			
			if(games[i] == null) {
				break;
			}
			
			if(games[i].getName().equals(name)) {
				return games[i]; // returns a Game object if Game name from parameter matches a game from Game repository
			}
		}
		
		return null;
	}

}
