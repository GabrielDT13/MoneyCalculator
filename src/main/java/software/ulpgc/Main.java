package software.ulpgc;

import software.ulpgc.control.CalculatorController;
import software.ulpgc.control.ExchangeRateService;
import software.ulpgc.model.Currency;
import software.ulpgc.view.MainFrame;

import java.util.List;

public class Main {
    private static final MainFrame mainFrame = new MainFrame();

    public static void main(String[] args) {
        List<Currency> currencies = new ExchangeRateService().load();
        new CalculatorController(mainFrame.display);
        display(currencies);
    }

    private static void display(List<Currency> currencies) {
        mainFrame.put(currencies);
        mainFrame.setVisible(true);
    }
}
