package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.view.constant.InputMessage.INPUT_ORDER;
import static christmas.view.constant.InputMessage.VISIT_DATE;

public class InputView {
    private InputView() {}

    private static class InputViewHelper {
        private static final InputView INPUT_VIEW = new InputView();
    }

    public static InputView getInstance(){
        return InputViewHelper.INPUT_VIEW;
    }

    public String visitDate() {
        System.out.println(VISIT_DATE.getMessage());
        return readLine();
    }

    public String getOrders() {
        System.out.println(INPUT_ORDER.getMessage());
        return readLine();
    }
}
