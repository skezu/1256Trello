package Views;

import Models.CarteModel;

import javax.swing.*;
import java.awt.*;
public class CarteView extends JPanel {
    private CarteModel carteModel;
    private JFrame frame;
    private JLabel titleLabel;
    private JTextArea descriptionTextArea;

    public CarteView(CarteModel carteModel) {
        this.carteModel = carteModel;

        // Create the frame
        frame = new JFrame("Carte Details");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the title label
        titleLabel = new JLabel(carteModel.getTitreCarte());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create the description text area
        descriptionTextArea = new JTextArea(carteModel.getDescription());
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(descriptionTextArea);

        // Add components to the frame
        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Show the frame
        frame.setVisible(true);
    }

    public void updateTitle(String newTitle) {
        carteModel.setTitreCarte(newTitle);
        titleLabel.setText(carteModel.getTitreCarte());
    }

    public void updateDescription(String newDescription) {
        carteModel.setDescription(newDescription);
        descriptionTextArea.setText(carteModel.getDescription());
    }
}
