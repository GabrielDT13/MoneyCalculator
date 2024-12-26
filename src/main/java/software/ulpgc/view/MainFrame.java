package software.ulpgc.view;

import software.ulpgc.control.commands.CalculateCommand;
import software.ulpgc.model.Currency;

import javax.swing.*;
import java.util.List;

public class MainFrame extends JFrame {
    private final MoneyCalculatorDisplay display;

    public MainFrame(){
        setTitle("Money Calculator");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        display = new MoneyCalculatorDisplay();

        add(display);
    }


    public void put(List<Currency> currencies) {
        display.display(currencies);
    }
}
