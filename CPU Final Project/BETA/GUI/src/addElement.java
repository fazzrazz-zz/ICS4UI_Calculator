/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gilbe8329
 */
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;

public class addElement {
//add panels to frame, button to grid panel
    private int nPanels = 3, nButtons = 0, nImages = 0;
    private JFrame frame = new JFrame();
    private JPanel[] panels = new JPanel[nPanels];
    private JLabel Label = new JLabel();
    private JButton[][] buttons = new JButton[5][6];
    private String Sfirst = "", Ssecond = "", masterString = "";
    private int nCount = 0;
    String[][] Sfirsts = new String[5][6];
    String[][] Sseconds = new String[5][6];
    Color[][] CColours = new Color[5][6];
    Color bodyColour = Color.decode("#e0e0d1");
    Color mainColour = Color.decode("#cbcbb3");
    Color second1 = Color.decode("#e3e39c");
    Color second2 = Color.decode("#d8d874");
    Color clearColour1 = Color.decode("#ccffcc");
    Color clearColour2 = Color.decode("#ff704d");
    Color numColour = Color.decode("#acac86");
    Color opColour = Color.decode("#989867");
    Color ScrnColour = Color.decode("#717B62");
    Color ScrnColourTxt = Color.decode("#21231C");
    
    public addElement() {
        JFrame frame = new JFrame("Calcultaor");
        frame.setBounds(0, 0, 400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(bodyColour);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(true);
        this.frame = frame;
        addPanels();
        addLabel(0, "bbb");
        setUp();
        frame.pack();
    }
    
    public void addPanels() {
        JPanel pan1 = new JPanel();
        JPanel pan2 = new JPanel();
        pan1.setLayout(new GridLayout(2, 1));
        pan2.setLayout(new GridLayout(7, 5, 5, 5));
        this.panels[1] = pan1;
        this.panels[2] = pan2;
    }
    
    public void addLabel (int i, String sText){
        JLabel Label = new JLabel(sText);
        Label.setForeground(ScrnColourTxt);
        Label.setBackground(ScrnColour);
        this.Label = Label;
        this.panels[1].add(Label);
    }
    
    public void addButton(String first, String second, int x, int y, Color Cpass) {
        Sfirsts[x][y] = first;
        Sseconds[x][y] = second;
        JButton button = new JButton(Sfirsts[x][y]);
        button.setBackground(Cpass);
        button.setOpaque(true);
        ActionListener clickOutput = new addElement.ClickOutput();
        button.addActionListener(clickOutput);
        this.buttons[x][y] = button;
        panels[2].add(button);
        System.out.println(x + ", " + y);
        if (Sfirsts[x][y] == "$") {
            button.setOpaque(false);
            button.setVisible(false);
        }

    }

    public void second() {
        this.buttons[0][0].setBackground(second1);
        this.buttons[4][0].setBackground(clearColour2);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.println(i + ", " + j);
                this.Ssecond = this.Sseconds[i][j];
                this.buttons[i][j].setText(Ssecond);
            }
        }
        reset();
    }

    public void first() {
        this.buttons[0][0].setBackground(second1);
        this.buttons[4][0].setBackground(clearColour1);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                this.Sfirst = this.Sfirsts[i][j];
                this.buttons[i][j].setText(Sfirst);
            }
        }
        reset();
    }

    public void setUp() {
        frame.add(panels[1]);
        addLabel(1, "");
        panels[1].add(panels[2]);
        addButton("2nd", "1st", 0, 0, second1);
        addButton("sin", "sin^-", 1, 0, mainColour);
        addButton("cos", "cos^-", 2, 0, mainColour);
        addButton("tan", "tan^-", 3, 0, mainColour);
        addButton("CLEAR", "OFF", 4, 0, clearColour1);
        addButton("X²", "X^[]", 0, 1, mainColour);
        addButton("√X", "[]√X", 1, 1, mainColour);
        addButton("1/X", "1/[]", 2, 1, mainColour);
        addButton("Y^X", "Y^[]", 3, 1, mainColour);
        addButton("÷", "÷", 4, 1, opColour);
        addButton("π", "π", 0, 2, mainColour);
        addButton("7", "7", 1, 2, numColour);
        addButton("8", "8", 2, 2, numColour);
        addButton("9", "9", 3, 2, numColour);
        addButton("×", "×", 4, 2, opColour);
        addButton("$", "$", 0, 3, numColour);
        addButton("4", "4", 1, 3, numColour);
        addButton("5", "5", 2, 3, numColour);
        addButton("6", "6", 3, 3, numColour);
        addButton("-", "-", 4, 3, opColour);
        addButton("$", "$", 0, 4, numColour);
        addButton("1", "1", 1, 4, numColour);
        addButton("2", "2", 2, 4, numColour);
        addButton("3", "3", 3, 4, numColour);
        addButton("+", "+", 4, 4, opColour);
        addButton("$", "$", 0, 5, numColour);
        addButton("0", "0", 1, 5, numColour);
        addButton(".", ".", 2, 5, numColour);
        addButton("-", "-", 3, 5, numColour);
        addButton("=", "=", 4, 5, opColour);
    }
    
    public void outAnswer(){
        this.Label.setText(masterString);
        reset();
    }

    class ClickOutput implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            reset();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    if (event.getSource() == buttons[i][j]) {
                        if (nCount % 2 != 0) {
                            System.out.println(Sseconds[i][j]);
                            masterString = masterString + Sseconds[i][j];
                            outAnswer();
                        } else {
                            System.out.println(Sfirsts[i][j]);
                            masterString = masterString + Sfirsts[i][j];
                            outAnswer();
                        }
                        if (event.getSource() == buttons[0][0]) {
                            nCount++;
                            if (nCount % 2 != 0) {
                                second();
                            } else {
                                first();
                            }
                        }
                    }
                }
            }
        }
    }

    public void reset() {
        frame.repaint();
    }
}
