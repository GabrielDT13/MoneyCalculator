package software.ulpgc.view;

import software.ulpgc.control.commands.CalculateCommand;
import software.ulpgc.model.Currency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class MoneyCalculatorDisplay extends JPanel implements CalculatorDisplay{
    private JButton button;
    private JLabel result;


    public void display(List<Currency> currencies) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(displayComponents(currencies));
        add(panel);
    }

    private JPanel displayComponents(List<Currency> currencies) {
        JLabel fromLabel = CreateCenterLabel("From Currency: ");
        JLabel toLabel = CreateCenterLabel("To Currency: ");
        result = CreateCenterLabel("Result: ");

        JTextField amount = new JTextField();

        JComboBox<Currency> fromCurrency = createSelector(currencies);
        JComboBox<Currency> toCurrency = createSelector(currencies);

        result.setFont(new Font("Arial", Font.BOLD, 20));

        button = new JButton("Calculate");

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.add(amount);
        jPanel.add(fromLabel);
        jPanel.add(fromCurrency);
        jPanel.add(toLabel);
        jPanel.add(toCurrency);
        jPanel.add(button);
        jPanel.add(result);

        return jPanel;
    }

    private JComboBox<Currency> createSelector(List<Currency> currencies) {
        JComboBox<Currency> selector = new JComboBox<>();
        for (Currency currency : currencies) selector.addItem(currency);
        return selector;
    }

    private JLabel CreateCenterLabel(String value) {
        JLabel jLabel = new JLabel(value);
        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return jLabel;
    }

    public void calculate(ActionListener listener){
        button.addActionListener(listener);
    }
}
