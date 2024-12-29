package software.ulpgc.control;

import software.ulpgc.control.commands.CalculateCommand;
import software.ulpgc.view.MoneyCalculatorDisplay;

public class CalculatorController {
    private final MoneyCalculatorDisplay view;

    public CalculatorController(MoneyCalculatorDisplay view) {
        this.view = view;

        view.calculate(e -> calculate());
    }

    private void calculate() {
        CalculateCommand command = new CalculateCommand(view);
        command.execute();
    }
}
