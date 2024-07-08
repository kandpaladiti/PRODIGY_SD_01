import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature Converter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        JLabel inputLabel = new JLabel("Enter Temperature:");
        inputLabel.setBounds(30, 30, 150, 25);
        frame.add(inputLabel);

        JLabel unitLabel = new JLabel("Select Unit:");
        unitLabel.setBounds(30, 70, 150, 25);
        frame.add(unitLabel);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(150, 110, 100, 25);
        frame.add(convertButton);

        JLabel resultLabel = new JLabel("Converted Temperatures:");
        resultLabel.setBounds(30, 150, 150, 25);
        frame.add(resultLabel);

        JTextField tempField = new JTextField();
        tempField.setBounds(200, 30, 150, 25);
        frame.add(tempField);

        String[] units = {"°C", "°F", "°K"};
        JComboBox<String> unitBox = new JComboBox<>(units);
        unitBox.setBounds(200, 70, 150, 25);
        frame.add(unitBox);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(30, 180, 320, 70);
        resultArea.setEditable(false);
        frame.add(resultArea);


        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double inputTemp = Double.parseDouble(tempField.getText());
                    String selectedUnit = (String) unitBox.getSelectedItem();
                    String resultText = "";

                    switch (selectedUnit) {
                        case "°C":
                            double fahrenheitFromCelsius = (inputTemp * 9/5) + 32;
                            double kelvinFromCelsius = inputTemp + 273.15;
                            resultText = String.format("Fahrenheit: %.2f °F\nKelvin: %.2f °K", fahrenheitFromCelsius, kelvinFromCelsius);
                            break;
                        case "°F":
                            double celsiusFromFahrenheit = (inputTemp - 32) * 5/9;
                            double kelvinFromFahrenheit = (inputTemp - 32) * 5/9 + 273.15;
                            resultText = String.format("Celsius: %.2f °C\nKelvin: %.2f °K", celsiusFromFahrenheit, kelvinFromFahrenheit);
                            break;
                        case "°K":
                            double celsiusFromKelvin = inputTemp - 273.15;
                            double fahrenheitFromKelvin = (inputTemp - 273.15) * 9/5 + 32;
                            resultText = String.format("Celsius: %.2f °C\nFahrenheit: %.2f °F", celsiusFromKelvin, fahrenheitFromKelvin);
                            break;
                    }

                    resultArea.setText(resultText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid temperature.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
