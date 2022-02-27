package Classes;

import javax.swing.*;
import java.awt.*;

public class File_Button extends JButton {
    String buttonText;
    Dimension size;

    public File_Button(String buttonText) {
        this.buttonText = buttonText;
        size = new Dimension(333, 25);

        setPreferredSize(size);
        setText(buttonText);

    }
}
