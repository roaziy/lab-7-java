// B241940029 - Erkhemtur
// Object-oriented programming - Laboratory >> 7 | 3-2th

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chrome {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        JFrame frame = new JFrame("Chrome Browser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.WHITE);

        JTextField addressBar = new JTextField("https://www.google.com");
        addressBar.setFont(new Font("Arial", Font.PLAIN, 16));
        addressBar.setBackground(Color.WHITE);
        addressBar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        addressBar.setCaretColor(Color.BLACK);

        JButton backButton = new JButton("<");
        JButton forwardButton = new JButton(">");
        JButton goButton = new JButton("Go");

        backButton.setPreferredSize(new Dimension(50, 30));
        forwardButton.setPreferredSize(new Dimension(50, 30));
        goButton.setBackground(new Color(0x4CAF50));
        goButton.setForeground(Color.WHITE);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        buttonsPanel.add(backButton);
        buttonsPanel.add(forwardButton);
        buttonsPanel.add(goButton);

        topPanel.add(addressBar, BorderLayout.CENTER);
        topPanel.add(buttonsPanel, BorderLayout.WEST);

        JPanel tabPanel = new JPanel();
        tabPanel.setBackground(new Color(0xF5F5F5));
        tabPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        JButton tab1 = new JButton("Tab 1");
        tab1.setFont(new Font("Arial", Font.PLAIN, 14));
        tab1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        tab1.setOpaque(true);
        tab1.setBackground(new Color(0xE0E0E0));
        tab1.setPreferredSize(new Dimension(100, 30));

        JButton tab2 = new JButton("Tab 2");
        tab2.setFont(new Font("Arial", Font.PLAIN, 14));
        tab2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        tab2.setOpaque(true);
        tab2.setBackground(new Color(0xE0E0E0));
        tab2.setPreferredSize(new Dimension(100, 30));

        tabPanel.add(tab1);
        tabPanel.add(tab2);

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        JLabel contentLabel = new JLabel("Welcome to Chrome Browser!");
        contentLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        contentPanel.add(contentLabel);

        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(tabPanel, BorderLayout.CENTER);
        frame.add(contentPanel, BorderLayout.SOUTH);

        tab1.addActionListener(e -> System.out.println("Tab 1 clicked"));
        tab2.addActionListener(e -> System.out.println("Tab 2 clicked"));
        backButton.addActionListener(e -> System.out.println("Going back..."));
        forwardButton.addActionListener(e -> System.out.println("Going forward..."));
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = addressBar.getText();
                contentLabel.setText("You searched for: " + url);
                System.out.println("Navigating to: " + url);
            }
        });

        frame.setVisible(true);
    }
}
