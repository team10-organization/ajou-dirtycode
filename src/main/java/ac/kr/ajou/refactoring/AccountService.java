package ac.kr.ajou.refactoring;

import java.util.List;

public class AccountService {
    private final LoginService loginService;

    public AccountService(LoginService loginService) {
        this.loginService = loginService;
    }

    public String getUserNameById(String id) {
        if (loginService.getDataBaseService().userExists(id)) {
            Player player = loginService.getDataBaseService().getPlayerById(id);
            return player.getUserName();
        } else {
            return null;
        }
    }

    public List<Player> getAge(int a) {
        return loginService.getDataBaseService().getAllPlayers();
    }
}