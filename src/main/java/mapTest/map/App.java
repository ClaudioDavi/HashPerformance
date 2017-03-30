package mapTest.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class App {

	public static void main(String[] args) {
		
		//Parameters
		int leaders = 200;
		int users = 100000;
		
		//Screen log
		System.out.println("Leaders inserted: " + leaders);
		System.out.println("Users inserted: " + users);
		System.out.println( "Search Time: " + play(populate(leaders, users)) + " ms");

	}

	public static HashMap<String, UserVO> populate(int leaders, int users) {

		//Map that will be searched
		HashMap<String, UserVO> map = new HashMap<String, UserVO>();
		UserCreation uc = new UserCreation(leaders, users);
		for (UserVO u : uc.users) {
			map.put(u.getUserName(), u);
		}
		System.out.println("Sample object: \n" + uc.users.get(5).toString());
		System.out.println("HashMap final Size: " + map.size());
		return map;
	}

	public static long play(HashMap<String, UserVO> hashmap) {
		long startTime = System.currentTimeMillis();
		
		HashSet<String> leaders = new HashSet<>();
		//for every entry on the map
		//looks for the assigned leader object and takes the leaders username from his own object.
		for (Entry<String, UserVO> entry : hashmap.entrySet()) {
			leaders.add(hashmap.get(entry.getValue().getLeader()).getUserName());
		}
		
		System.out.println("Unique Leaders found: " + leaders.size());
		return System.currentTimeMillis() - startTime;
	}
	
	
}
