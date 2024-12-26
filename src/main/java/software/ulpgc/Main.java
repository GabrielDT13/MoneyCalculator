package software.ulpgc;

import software.ulpgc.control.ExchangeRateService;
import software.ulpgc.model.Currency;
import software.ulpgc.view.MainFrame;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Currency> currencies = new ExchangeRateService().load();
        display(currencies);
    }

    private static void display(List<Currency> currencies) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.put(currencies);
        mainFrame.setVisible(true);
    }
}
