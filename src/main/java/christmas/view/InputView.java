package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.view.constant.InputMessage.INPUT_ORDER;
import static christmas.view.constant.InputMessage.VISIT_DATE;

public class InputView {
    public String visitDate() {
        System.out.println(VISIT_DATE.getMessage());
        return readLine();
    }

    public String getOrders() {
        System.out.println(INPUT_ORDER);
        return readLine();
    }
}
