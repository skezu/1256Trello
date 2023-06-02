package Controller;

import EspaceDeTravail.*;
import Views.ListeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class EditableLabel extends JLabel {

    private JPanel parentPanel;
    //private Membre model;

    ///////////////////////////////////
    // Un constructeur par type      //
    ///////////////////////////////////

    public EditableLabel(String text, JPanel panel, Membre model) {
        super(text);
        this.parentPanel = panel;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTextField textField = new JTextField(getText());
                textField.setPreferredSize(new Dimension(100, 20));
                parentPanel.remove(EditableLabel.this);
                parentPanel.add(textField);
                textField.requestFocus();
                parentPanel.revalidate();
                parentPanel.repaint();

                textField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String newText = textField.getText();
                        setText(newText);
                        // Update the model with the new value
                        model.setNomMembre(newText);
                        parentPanel.remove(textField);
                        parentPanel.add(EditableLabel.this);
                        parentPanel.revalidate();
                        parentPanel.repaint();
                    }
                });
            }
        });
    }

    public EditableLabel(String text, JPanel panel, Carte model) {
        super(text);
        this.parentPanel = panel;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTextField textField = new JTextField(getText());
                textField.setPreferredSize(new Dimension(100, 20));
                parentPanel.remove(EditableLabel.this);
                parentPanel.add(textField);
                textField.requestFocus();
                parentPanel.revalidate();
                parentPanel.repaint();

                textField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String newText = textField.getText();
                        setText(newText);
                        // Update the model with the new value
                        model.setTitreCarte(newText);
                        parentPanel.remove(textField);
                        parentPanel.add(EditableLabel.this);
                        parentPanel.revalidate();
                        parentPanel.repaint();
                    }
                });
            }
        });
    }

    public EditableLabel(String text, JPanel panel, EspaceTravail model) {
        super(text);
        this.parentPanel = panel;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTextField textField = new JTextField(getText());
                textField.setPreferredSize(new Dimension(100, 20));
                parentPanel.remove(EditableLabel.this);
                parentPanel.add(textField);
                textField.requestFocus();
                parentPanel.revalidate();
                parentPanel.repaint();

                textField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String newText = textField.getText();
                        setText(newText);
                        // Update the model with the new value
                        model.setNomEspaceDeTravail(newText);
                        parentPanel.remove(textField);
                        parentPanel.add(EditableLabel.this);
                        parentPanel.revalidate();
                        parentPanel.repaint();
                    }
                });
            }
        });
    }

    public EditableLabel(String text, JPanel panel, Liste model) {
        super(text);
        this.parentPanel = panel;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTextField textField = new JTextField(getText());
                textField.setPreferredSize(new Dimension(100, 20));
                //parentPanel.remove(EditableLabel.this);
                parentPanel.removeAll();
                parentPanel.add(textField);
                textField.requestFocus();
                parentPanel.revalidate();
                parentPanel.repaint();

                textField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String newText = textField.getText();
                        setText(newText);
                        // Update the model with the new value
                        model.setNomListe(newText);
                        parentPanel.remove(textField);
                        parentPanel.add(EditableLabel.this);
                        parentPanel.revalidate();
                        parentPanel.repaint();
                    }
                });
            }
        });
    }

    public EditableLabel(String text, JPanel panel, Tableau model) {
        super(text);
        this.parentPanel = panel;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTextField textField = new JTextField(getText());
                textField.setPreferredSize(new Dimension(100, 20));
                parentPanel.remove(EditableLabel.this);
                parentPanel.add(textField);
                textField.requestFocus();
                parentPanel.revalidate();
                parentPanel.repaint();

                textField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String newText = textField.getText();
                        setText(newText);
                        // Update the model with the new value
                        model.setNomTableau(newText);
                        parentPanel.remove(textField);
                        parentPanel.add(EditableLabel.this);
                        parentPanel.revalidate();
                        parentPanel.repaint();
                    }
                });
            }
        });
    }

    //////////////////////////
    //      Methodes        //
    //////////////////////////
}
