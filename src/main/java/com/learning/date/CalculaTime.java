package com.learning.date;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CalculaTime extends JFrame {

    private JPanel contentPane;
    private JTextField txtHour;
    private JTextField txtMinute;
    private JTextField txtSecond;
    private JLabel lblTime;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CalculaTime frame = new CalculaTime();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CalculaTime() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 490, 302);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(219, 12, 240, 199);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("");
        label.setBounds(12, 30, 70, 15);
        panel.add(label);

        JLabel lblHora = new JLabel("Hora");
        lblHora.setBounds(12, 30, 70, 15);
        panel.add(lblHora);

        JLabel lblMinuto = new JLabel("minuto");
        lblMinuto.setBounds(12, 75, 70, 15);
        panel.add(lblMinuto);

        JLabel lblSegundo = new JLabel("Segundo");
        lblSegundo.setBounds(12, 116, 70, 15);
        panel.add(lblSegundo);

        txtHour = new JTextField();
        txtHour.setBounds(100, 26, 114, 19);
        panel.add(txtHour);
        txtHour.setColumns(10);

        txtMinute = new JTextField();
        txtMinute.setBounds(100, 73, 114, 19);
        panel.add(txtMinute);
        txtMinute.setColumns(10);

        txtSecond = new JTextField();
        txtSecond.setBounds(100, 114, 114, 19);
        panel.add(txtSecond);
        txtSecond.setColumns(10);

        lblTime = new JLabel("");
        lblTime.setBounds(12, 172, 70, 15);
        panel.add(lblTime);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(30, 12, 151, 199);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(CalculaTime.class
                .getResource("/com/learning/images/horas.png")));

        lblNewLabel_1.setBounds(12, 12, 139, 150);
        panel_1.add(lblNewLabel_1);

        JButton btnCalculate = new JButton("Calcular");
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int timeInSecond;
                TimeToSecond timesecond = new TimeToSecond();
                validation();
                try {
                    int hour = Integer.parseInt(txtHour.getText());
                    int minute = Integer.parseInt(txtMinute.getText());
                    int second = Integer.parseInt(txtSecond.getText());
                    if (hour > 24 || minute > 60 || second > 60 || hour < 0
                            || minute < 0 || second < 0) {

                        JOptionPane.showMessageDialog(null, "por favor ingrese "
                                + "datos validos", "alert", 
                                JOptionPane.ERROR_MESSAGE);

                    } else {
                        timeInSecond = timesecond.calculateTime(hour, minute,
                                second);
                        lblTime.setText(timeInSecond + " sg");
                        clean();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Solo se admiten "
                            + "numeros", "alert", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btnCalculate.setBounds(37, 235, 422, 25);
        contentPane.add(btnCalculate);
    }

    public void validation() {
        if (txtHour.getText().isEmpty() || txtMinute.getText().isEmpty()
                || txtSecond.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Porfavor llenar "
                    + "todos los campos", "alert",
                    JOptionPane.ERROR_MESSAGE);
            clean();
        }
    }

    public void clean() {
        txtHour.setText("");
        txtMinute.setText("");
        txtSecond.setText("");
    }

}
