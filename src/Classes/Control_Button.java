package Classes;

import javax.swing.*;
import java.awt.*;

public class Control_Button extends JButton {
    String buttonText;
    Dimension size;

    public Control_Button(String buttonText) {
        this.buttonText = buttonText;
        size = new Dimension(125, 25);

        setPreferredSize(size);
        setText(buttonText);

    }
}
