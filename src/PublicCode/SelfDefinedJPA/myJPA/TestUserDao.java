package PublicCode.SelfDefinedJPA.myJPA;

public class TestUserDao {
    public static void main(String[] args) {
		UserDao userDao = new UserDao();
		User user = new User(3,"hst", 20);
		userDao.add(user);
	}
}
