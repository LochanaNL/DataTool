import javax.swing.*;
import java.awt.*;

public class DataTool extends JFrame {

    JTextField txtInput;
    JComboBox<String> comboInputType, comboOutputType;
    JButton btnConvert, btnCheckTypes;
    JTextArea txtOutput;

    String types[] = {"Byte", "Short", "Int", "Long", "Float", "Double"};

    public DataTool() {

        setTitle("Data Converter + Type Checker");
        setSize(550, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        Font titleFont = new Font("Arial", Font.BOLD, 22);
        Font normal = new Font("Arial", Font.BOLD, 18);

        // ---- TITLE ----
        JLabel title = new JLabel("DATA CONVERTER & TYPE CHECKER");
        title.setFont(titleFont);
        add(title);

        add(new JLabel(" "));
	add(new JLabel(" ")); // spacing

        // ---- INPUT ----
        JLabel lblInput = new JLabel("Enter Number:");
        lblInput.setFont(normal);
        add(lblInput);

        txtInput = new JTextField(15);
        txtInput.setFont(normal);
        add(txtInput);
	add(new JLabel(" "));
	add(new JLabel(" "));
        
	// ---- INPUT TYPE ----
        JLabel lblInputType = new JLabel("Input Type:");
        lblInputType.setFont(normal);
        add(lblInputType);

        comboInputType = new JComboBox<>(types);
        comboInputType.setFont(normal);
        add(comboInputType);

        // ---- OUTPUT TYPE ----
        JLabel lblOutputType = new JLabel("Output Type:");
        lblOutputType.setFont(normal);
        add(lblOutputType);

        comboOutputType = new JComboBox<>(types);
        comboOutputType.setFont(normal);
        add(comboOutputType);
	add(new JLabel(" "));
	add(new JLabel(" "));
          add(new JLabel(" "));
	// ---- CONVERT BUTTON ----
        btnConvert = new JButton("CONVERT");
        btnConvert.setFont(normal);
        add(btnConvert);

        // ---- CHECK TYPE BUTTON ----
        btnCheckTypes = new JButton("CHECK COMPATIBILITY");
        btnCheckTypes.setFont(normal);
        add(btnCheckTypes);

        // ---- OUTPUT AREA ----
        txtOutput = new JTextArea(18, 40);
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font("Monospaced", Font.PLAIN, 15));

        JScrollPane scroll = new JScrollPane(txtOutput);
        add(scroll);

        // Add listeners
        btnConvert.addActionListener(e -> convertValue());
        btnCheckTypes.addActionListener(e -> checkCompatibility());
    }

    // ----------------- CONVERSION LOGIC -----------------
    void convertValue() {
        txtOutput.setText("");

        try {
            double value = Double.parseDouble(txtInput.getText());
            String in = comboInputType.getSelectedItem().toString();
            String out = comboOutputType.getSelectedItem().toString();

            double converted = convertPrimitive(value, in, out);

            txtOutput.setText("Conversion Result:\n\n");
            txtOutput.append("Input Type : " + in + "\n");
            txtOutput.append("Output Type: " + out + "\n\n");
            txtOutput.append("Converted Value = " + converted);

        } catch (Exception ex) {
            txtOutput.setText("Invalid Input! Please enter a valid number.");
        }
    }

    double convertPrimitive(double value, String inputType, String outputType) {

        switch (outputType) {
            case "Byte":
                return (byte) value;
            case "Short":
                return (short) value;
            case "Int":
                return (int) value;
            case "Long":
                return (long) value;
            case "Float":
                return (float) value;
            case "Double":
                return value;
        }
        return value;
    }

    // ----------------- TYPE CHECKER LOGIC -----------------
    void checkCompatibility() {
        txtOutput.setText("");
        String input = txtInput.getText();

        StringBuilder sb = new StringBuilder();
        sb.append("Data Type Compatibility:\n\n");

        try {
            long val = Long.parseLong(input);

            check(sb, "byte", val, Byte.MIN_VALUE, Byte.MAX_VALUE);
            check(sb, "short", val, Short.MIN_VALUE, Short.MAX_VALUE);
            check(sb, "int", val, Integer.MIN_VALUE, Integer.MAX_VALUE);

            sb.append("✔ Fits in: long\n\n");

        } catch (NumberFormatException ex) {
            sb.append("✘ Not a valid integer.\n\n");
        }

        // FLOAT / DOUBLE CHECK
        try {
            double v = Double.parseDouble(input);

            sb.append("---- Floating Types ----\n");

            if (v <= Float.MAX_VALUE && v >= -Float.MAX_VALUE)
                sb.append("✔ Fits in: float\n");
            else
                sb.append("✘ Does NOT fit in: float\n   Range: ")
                  .append(-Float.MAX_VALUE).append(" to ").append(Float.MAX_VALUE).append("\n");

            sb.append("✔ Fits in: double\n");

        } catch (Exception e) {
            sb.append("✘ Not valid float/double.\n");
        }

        txtOutput.setText(sb.toString());
    }

    void check(StringBuilder sb, String type, long value, long min, long max) {
        if (value >= min && value <= max)
            sb.append("✔ Fits in: ").append(type).append("\n");
        else {
            sb.append("✘ Does NOT fit in: ").append(type).append("\n");
            sb.append("   Range: ").append(min).append(" to ").append(max).append("\n");
        }
    }

    public static void main(String[] args) {
        new DataTool().setVisible(true);
    }
}

