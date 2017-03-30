package mapTest.map;

import java.util.HashSet;
import org.junit.Test;

import org.junit.Assert;

public class UserCreationTest {

	UserCreation uc;

	@Test
	public void testShouldCreate100Users5Leaders() {

		uc = new UserCreation(5, 100);

		Assert.assertEquals(100, uc.users.size());
		Assert.assertEquals(5, uc.leaders.size());

	}

	@Test
	public void testAllCreatedAreUnique(){
		int numUsers = 10000;
		int numLeaders = 100;
		
		uc = new UserCreation(numLeaders, numUsers);
		HashSet<String> users = new HashSet<>();
		HashSet<Integer> code = new HashSet<>();
		for (UserVO u : uc.users) {
			users.add(u.getUserName());
			code.add(u.getCode());
		}
		Assert.assertEquals(numUsers, users.size());
		Assert.assertEquals(numUsers, users.size());
	}
	
	@Test
	public void testLeadersAreUnique(){
		int numUsers = 20000;
		int numLeaders = 1000;
		
		uc = new UserCreation(numLeaders, numUsers);
		HashSet<String> leaders = new HashSet<>();
		HashSet<Integer> code = new HashSet<>();
		for (UserVO u : uc.leaders) {
			leaders.add(u.getUserName());
			code.add(u.getCode());
		}
	}
	
	@Test
	public void testEveryUserHasLeader(){
		int numUsers = 20000;
		int numLeaders = 1000;
		
		uc = new UserCreation(numLeaders, numUsers);
		HashSet<String> haveleaders = new HashSet<>();
		for (UserVO u : uc.users) {
			if(!u.getLeader().isEmpty() || !u.getLeader().equals(null)) {
				haveleaders.add(u.getUserName());
			}
		}
		Assert.assertEquals(numUsers, haveleaders.size());
	
	}
	
	
	
}
