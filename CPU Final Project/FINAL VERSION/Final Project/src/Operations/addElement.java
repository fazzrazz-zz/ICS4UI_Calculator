package Operations;

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
import java.awt.Font;

/**
 *
 * @author gilbe8329
 */
public class addElement extends MainString {

    private int nPanels = 6, nButtons = 0, nImages = 0;
    private JFrame frame = new JFrame();
    private JPanel[] panels = new JPanel[nPanels];
    private JLabel Label, LabelAnswer = new JLabel();
    private JButton[][] buttons = new JButton[5][6];
    private String Sfirst = "", Ssecond = "", masterString = "", curentAnswer = "";
    private int nCount = 0;
    // Font labelFont = Label.getFont();
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

    /**
     *
     */
    public addElement() {
        JFrame frame = new JFrame("Calcultaor");
        frame.setBounds(0, 0, 400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        this.frame = frame;
        addPanels();
        addLabel(0, "");
        setUp();
        frame.pack();
    }

    /**
     *
     */
    public void addPanels() {
        JPanel pan1 = new JPanel();
        JPanel pan2 = new JPanel();
        pan2.setBackground(bodyColour);
        JPanel pan3 = new JPanel();
        pan3.setBackground(bodyColour);
        JPanel pan4 = new JPanel();
        pan4.setBackground(bodyColour);
        JPanel pan5 = new JPanel();
        pan5.setBackground(bodyColour);

        pan1.setLayout(new GridLayout(2, 1));
        pan2.setLayout(new GridLayout(7, 5, 5, 5));
        pan3.setLayout(new GridLayout(2, 1));
        pan4.setLayout(new BoxLayout(pan4, BoxLayout.LINE_AXIS));
        pan5.setLayout(new BoxLayout(pan5, BoxLayout.PAGE_AXIS));

        this.panels[1] = pan1;
        this.panels[2] = pan2;
        this.panels[3] = pan3;
        this.panels[4] = pan4;
        this.panels[5] = pan5;

        frame.add(panels[1]);
        panels[1].add(panels[3]);
        panels[3].add(panels[4]);
        panels[3].add(panels[5]);
        addLabel(1, "");
        panels[1].add(panels[2]);

    }

    /**
     * makes a label with passes parameters 
     * @param i
     * @param sText
     */
    public void addLabel(int i, String sText) {
        JLabel Label = new JLabel(sText);
        Label.setForeground(ScrnColourTxt);
        Label.setBackground(ScrnColour);
        Label.setFont(new Font("Courier New", Font.ITALIC, 50));

        JLabel LabelAnswer = new JLabel(sText);
        LabelAnswer.setForeground(ScrnColourTxt);
        LabelAnswer.setBackground(ScrnColour);
        LabelAnswer.setFont(new Font("Courier New", Font.ITALIC, 30));

        this.Label = Label;
        this.LabelAnswer = LabelAnswer;
        this.panels[4].add(Label);
        this.panels[5].add(LabelAnswer);
    }

    /**
     * makes a general button with passed parameters 
     * @param first
     * @param second
     * @param x
     * @param y
     * @param Cpass
     */
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
        if (Sfirsts[x][y] == "$") {
            button.setOpaque(false);
            button.setVisible(false);
        }

    }

    /**
     * changes button text to their "second" function
     */
    public void second() {
        this.buttons[0][0].setBackground(second1);
        this.buttons[4][0].setBackground(clearColour2);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                this.Ssecond = this.Sseconds[i][j];
                this.buttons[i][j].setText(Ssecond);
            }
        }
        reset();
    }

    /**
     * changes button text to their "first" function
     */
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

    /**
     * calls on the addButton method and makes the array of buttons
     */
    public void setUp() {
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

    /**
     * displays the calculation
     */
    public void outAnswer() {
        //System.out.println(masterString);
        this.Label.setText(masterString);
        this.LabelAnswer.setText(curentAnswer);
        reset();
    }

    /**
     * clears the screen
     */
    public void clear() {
        this.Label.setText("");
        this.LabelAnswer.setText("");
        curentAnswer = "";
        reset();
    }

    class ClickOutput implements ActionListener {

        public void actionPerformed(ActionEvent event) { // sorts through the button presses and does what the individual buttons are meant to do
            reset();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    if (event.getSource() == buttons[i][j]) {
                        if (event.getSource() == buttons[0][0]) { // 2nd
                            nCount++;
                            if (nCount % 2 != 0) {
                                second();
                            } else {
                                first();
                            }
                        } else if (event.getSource() == buttons[4][5]) { // =
                            first();
                            calculate();
                            curentAnswer = Double.toString(result);
                            clearMaster();
                            outAnswer();
                            masterString = "";

                        } else if (event.getSource() == buttons[0][1]) { // X²
                            first();
                            if (nCount % 2 != 0) {
                                addToMaster("^");
                                masterString = masterString + "^";
                                outAnswer();
                            } else {
                                addToMaster("^2");
                                masterString = masterString + "^2";
                                outAnswer();
                            }
                        } else if (event.getSource() == buttons[0][2]) { // Pi
                            first();
                            if (nCount % 2 != 0) {
                                addToMaster("3.14159265359");
                                masterString = masterString + "π";
                                outAnswer();
                            } else {
                                addToMaster("3.14159265359");
                                masterString = masterString + "π";
                                outAnswer();
                            }                            
                        } else if (event.getSource() == buttons[4][0]) { // CLEAR 
                            first();
                            if (nCount % 2 != 0) {
                                frame.dispose();
                            } else {
                                masterString = "";
                                clearMaster();
                                clear();
                            }
                        } else if (nCount % 2 != 0) {
                            addToMaster(Sseconds[i][j]);
                            if ((event.getSource() != buttons[1][0]) && (event.getSource() != buttons[2][0]) && (event.getSource() != buttons[3][0]) && (event.getSource() != buttons[1][1]) && (event.getSource() != buttons[2][1]) && (event.getSource() != buttons[3][1])) {
                                masterString = masterString + Sseconds[i][j];
                            }
                            outAnswer();
                            first();
                            nCount++;
                        } else {
                            addToMaster(Sfirsts[i][j]);
                            if ((event.getSource() != buttons[1][0]) && (event.getSource() != buttons[2][0]) && (event.getSource() != buttons[3][0]) && (event.getSource() != buttons[1][1]) && (event.getSource() != buttons[2][1]) && (event.getSource() != buttons[3][1])) {
                                masterString = masterString + Sfirsts[i][j];
                            }
                            outAnswer();
                        }
                    }
                }
            }
        }
    }

    /**
     * resets the GUI
     */
    public void reset() {
        frame.repaint();
    }
}
