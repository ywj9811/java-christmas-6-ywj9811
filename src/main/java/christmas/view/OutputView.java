package christmas.view;


import static christmas.view.constant.OutputMessage.GREETING;

public class OutputView {
    public void greeting() {
        System.out.println(GREETING.getMessage());
    }
}
