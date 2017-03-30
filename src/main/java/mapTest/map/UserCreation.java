package mapTest.map;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserCreation {

	List<UserVO> leaders = new ArrayList<UserVO>();
	List<UserVO> users = new ArrayList<UserVO>();

	public UserCreation(int numLeaders, int numUsers) {
		
		
		for (int i = 0; i < numUsers; i++) {
			//Creates a big hash to use as username (All unique)
			String name = new BigInteger(512, new Random()).toString(32);
			//Creates an integer code
			UserVO user = new UserVO(random(100000000), name);
			users.add(user);
		}
		
		while(leaders.size() < numLeaders) {
			//selects random users to be leaders
			leaders.add(users.get(random(users.size())));
		}
		
		for(UserVO u : users) {
			//selects a random leader for each user
			u.setLeader(leaders.get(random(numLeaders)).getUserName());
		}
	}
	
	private int random (int max) {
		Random rand = new Random();
		 
        int numero = rand.nextInt(max);
        return numero;
	}
	
	

}
