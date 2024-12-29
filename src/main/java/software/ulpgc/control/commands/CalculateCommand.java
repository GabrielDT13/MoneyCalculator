package software.ulpgc.control.commands;

import software.ulpgc.model.Currency;
import software.ulpgc.model.ExchangeRate;
import software.ulpgc.model.Money;
import software.ulpgc.view.MoneyCalculatorDisplay;

import java.util.Arrays;

public class CalculateCommand implements Command {
    private final MoneyCalculatorDisplay view;

    public CalculateCommand(MoneyCalculatorDisplay view) {
        this.view = view;
    }

    @Override
    public void execute() {
        String toCurrency = view.getToCurrency();
        String fromCurrency = view.getFromCurrency();

        double amount = Double.parseDouble(view.getAmount());
        Currency from = new Currency(getCurrencyName(fromCurrency), getCurrencyCode(fromCurrency));
        Currency to = new Currency(getCurrencyName(toCurrency), getCurrencyCode(toCurrency));

        ExchangeRate exchangeRate = new ExchangeRate(from, to, Double.parseDouble(getCurrencyCode(toCurrency)));
        Money money = new Money(amount, from);

        String result = calculate(money, exchangeRate);
        view.setResult(result);
    }

    private String calculate(Money money, ExchangeRate exchangeRate) {
        return String.valueOf(money.getAmount() * exchangeRate.getRate());
    }

    private String getCurrencyCode(String currency) {
        String[] result = (currency.split("-"));
        return result[1];
    }
    private String getCurrencyName(String currency) {
        String[] result = (currency.split("-"));
        return result[0];
    }
}
