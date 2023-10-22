package baseball.game;

import baseball.computer.ComputerGenerate;
import baseball.user.input.UserInput;
import baseball.user.UserGenerate;
import java.util.List;

public class BaseballGame {
    /**
     * 야구게임 시작
     */
    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            ComputerGenerate computerGenerate = new ComputerGenerate();

            // 컴퓨터 랜덤 수 생성
            List<Integer> target = computerGenerate.getTarget();

            // 플레이어 입력 및 게임 로직
            play(target);

            // 끝낼 것인지
            if (isEnd()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    /**
     * 플레이어 입력 및 게임 로직
     * @param target 컴퓨터가 만든 랜덤 3개의 숫자
     */
    private void play(List<Integer> target) {
        while (true) {
            UserGenerate userGenerate = new UserGenerate();
            GameRule gameRule = new GameRule();

            // 사용자 3개의 숫자 입력
            List<Integer> attempt = userGenerate.getAttempt();

            // 사용자 입력 마다의 결과
            if (gameRule.gameLogic(attempt, target)) {
                break;
            }
        }
    }

    /**
     * 종료할 것인지 사용자 입력을 받고 1이면 계속 진행, 아니면 게임 종료
     * @return 종료할 것이면 true, 종료하지 않을 것이면 false
     */
    private boolean isEnd() {
        String input;
        UserInput userInput = new UserInput();
        input = userInput.getEndGameInput();
        if (input.equals("1")) {
            return false;
        }
        return true;
    }
}