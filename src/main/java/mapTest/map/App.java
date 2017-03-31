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
		play(populate(leaders, users));

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

	public static void play(HashMap<String, UserVO> hashmap) {
		long startTime = System.currentTimeMillis();
		
		HashSet<UserVO> leaders = new HashSet<>();
		//for every entry on the map
		//looks for the assigned leader object and takes the leaders username from his own object.
		StringBuilder SQL = new StringBuilder();
		
		for (Entry<String, UserVO> entry : hashmap.entrySet()) {
			UserVO leader = hashmap.get(entry.getValue().getLeader());
			leaders.add(leader);
			
		}
		long elapsedTime = System.currentTimeMillis() - startTime;
		
		long sqlTime = System.currentTimeMillis();
		
		//SQL generation
		for(UserVO leader : leaders) {
			SQL.append("INSERT INTO USERVO (CODE, USERNAME, LEADER) VALUES (");
			SQL.append(leader.getCode()+ ", ");
			SQL.append(leader.getUserName() + ", ");
			SQL.append(leader.getLeader() + ");\n ");
		}
		String sql = SQL.toString();
		long sqlElapsedTime = System.currentTimeMillis() - sqlTime;
		
		System.out.println("Unique Leaders (w/ employees assigned to them) found: " + leaders.size());
		System.out.println("Time to find all leaders: " + elapsedTime + " ms");
		System.out.println("Time to generate SQL: " + sqlElapsedTime + " ms");
		
	}
	
	
}
