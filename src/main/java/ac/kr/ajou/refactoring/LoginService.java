package ac.kr.ajou.refactoring;

import java.util.List;

public class LoginService {

    private final DataBaseService dataBaseService;
    private final AccountService accountService = new AccountService(this);

    public LoginService() {
        this.dataBaseService = new DataBaseService();
    }

    public boolean login(String userId, String password) {
        if (isValidUserId(userId)) {
            if (dataBaseService.userExists(userId)) {
                Player player = dataBaseService.getPlayerById(userId);
                return player.getPassword().equals(password);
            }
        }
        return false;
    }

    private boolean isValidUserId(String userId) {
        return userId != null && !userId.isEmpty();
    }

    public String getUserNameById(String id) {
        return accountService.getUserNameById(id);
    }

    public List<Player> getAge(int a) {
        return accountService.getAge(a);
    }

    public DataBaseService getDataBaseService() {
        return dataBaseService;
    }
}
