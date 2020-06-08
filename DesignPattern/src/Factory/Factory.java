package Factory;

interface IDragon {
	public String getName();
}

class FireDragon implements IDragon {

	@Override
	public String getName() {
		return "Fire Dragon";
	}
	
}

class WindDragon implements IDragon {

	@Override
	public String getName() {
		return "Wind Dragon";
	}
	
}

enum DragonType {
	Fire, Wind
}

class GameFactory {
	public IDragon getDragon(DragonType dragonType) throws Exception {
		switch(dragonType) {
			case Fire:
				return new FireDragon();
			case Wind:
				return new WindDragon();
			default:
				throw new Exception();
		}
	}
}

public class Factory {
	public static void main(String[] args) throws Exception {
		GameFactory gameFactory = new GameFactory();
		IDragon fireDragon = gameFactory.getDragon(DragonType.Fire);
		System.out.println(fireDragon.getName());
	}
}
