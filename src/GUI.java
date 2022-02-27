import Classes.Control_Button;
import Classes.File_Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

public class GUI extends JFrame {

    private final String ssdText = "SSD";
    private final String saveFileText = "Files To Save";
    private final String whereText = "Export";

    private File_Button backUpSSD; //this will allow the user to find the external ssd to be copied
    private File_Button saveFiles; //this will allow user to find the files to be saved
    private File_Button where; //this will allow the user to choose where to make the copies //default C:\
    private Control_Button makeCopies; //this will initiate the copying mechanic that makes a local backup of ssd and files
    private Control_Button execute; //this will initiate all program actions
    private Control_Button clear;
    private JPanel fileButtonPanel; //contains file buttons
    private JPanel controlPanel; //contains Control buttons

    GUI(){
        buildGUI();
        buttonActions(this);
    }

    private void buildGUI(){
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        backUpSSD = new File_Button("SSD");
        saveFiles = new File_Button("Files To Save");
        where = new File_Button("Export");
        makeCopies = new Control_Button("Make Copies");
        execute = new Control_Button("Execute");
        clear = new Control_Button("Clear");
        fileButtonPanel = new JPanel();
        controlPanel = new JPanel();

        fileButtonPanel.add(backUpSSD);
        fileButtonPanel.add(saveFiles);
        fileButtonPanel.add(where);

        controlPanel.add(makeCopies);
        controlPanel.add(execute);
        controlPanel.add(clear);

        this.add(fileButtonPanel);
        this.add(controlPanel);

        setSize(new Dimension(1100,125));
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void buttonActions(Component parent){
        backUpSSD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //open a JFilechoose to find the files
                backUpSSD.setText(getFolder(parent));
            }
        });

        saveFiles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //open a JFilechoose to find the files
                saveFiles.setText(getFolder(parent));
            }
        });

        where.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //open a JFilechoose to find the files
                where.setText(getFolder(parent));
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backUpSSD.setText(ssdText);
                saveFiles.setText(saveFileText);
                where.setText(whereText);
            }
        });
        execute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(backUpSSD.getText().equals(ssdText) || saveFiles.getText().equals(saveFileText) || where.getText().equals(whereText)){
                    JOptionPane.showMessageDialog(parent, "Enter Paths To All Variables");
                }else{
                    FolderProcessor.copyFolder(Path.of(backUpSSD.getText()), Path.of(where.getText()));
                }
            }
        });
    }

    private String getFolder(Component parent){
        JFileChooser jfc = new JFileChooser("Find SSD");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.showOpenDialog(parent);

        return jfc.getSelectedFile().toString();
    }

}
