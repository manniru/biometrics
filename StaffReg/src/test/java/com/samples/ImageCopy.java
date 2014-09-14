package com.samples;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ImageCopy extends JFrame implements ActionListener {
    JMenuItem fMenuOpen = null;
    JMenuItem fMenuSave = null;
    JMenuItem fMenuClose = null;
    JTextArea fTextArea;
    static JLabel label;
    static BufferedImage icon;
    static File oldfile;
    JFileChooser fc;
    ImageFilter1 fJavaFilter = new ImageFilter1();
    static File fFile;

    public ImageCopy(String title) {
        // TODO Auto-generated constructor stub

        super(title);
        Container content_pane = getContentPane();
        content_pane.setLayout(new BorderLayout());

        JMenu m = new JMenu("File");
        m.add(fMenuOpen = makeMenuItem("Open"));
        m.add(fMenuOpen = makeMenuItem("Save"));
        m.add(fMenuClose = makeMenuItem("Quit"));
        JMenuBar mb = new JMenuBar();
        mb.add(m);
        setJMenuBar(mb);
        setSize(400, 400);
    }

    public void actionPerformed(ActionEvent e) {
        boolean status = false;
        String command = e.getActionCommand();
        if (command.equals("Open")) {
            try {
                status = openFile();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if (!status)
                JOptionPane.showMessageDialog(null, "Error opening file!",
                        "File Open Error", JOptionPane.ERROR_MESSAGE);
        } else if (command.equals("Save")) {
            status = saveFile();
            if (!status)
                JOptionPane.showMessageDialog(null,
                        "IO error in saving file!!", "File Save Error",
                        JOptionPane.ERROR_MESSAGE);
        } else if (command.equals("Quit")) {
            dispose();
        }
    }

    private JMenuItem makeMenuItem(String name) {
        JMenuItem m = new JMenuItem(name);
        m.addActionListener(this);
        return m;
    }

    boolean openFile() throws IOException {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Open File");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.setCurrentDirectory(new File("."));
        fc.setFileFilter(fJavaFilter);
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.CANCEL_OPTION) {
            return true;
        } else if (result == JFileChooser.APPROVE_OPTION) {

            fFile = fc.getSelectedFile();
            oldfile = fFile;
            System.out.println(fFile);
            FileInputStream fileInputStream = new FileInputStream(fFile);
            System.out.println(fileInputStream);
            System.out.println(fFile.getAbsolutePath());
            icon = ImageIO.read(fileInputStream);
            label = new JLabel(new ImageIcon(icon));
            label.setBounds(0, 0, 500, 500);
            label.setVisible(true);
            getContentPane().add(label);
            // Set the position of its text, relative to its icon:
            label.setVerticalTextPosition(JLabel.BOTTOM);
            label.setHorizontalTextPosition(JLabel.CENTER);
        } else {
            return false;
        }
        return true;
    }

    boolean saveFile() {
        File file = null;
        fc = new JFileChooser();
        javax.swing.filechooser.FileFilter filter = null;
        fc.setCurrentDirectory(new File("."));
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.addChoosableFileFilter(filter);
        filter = fc.getFileFilter();
        fc.setFileFilter(fJavaFilter);
        fc.setSelectedFile(fFile);
        int result = fc.showSaveDialog(this);
        if (result == JFileChooser.CANCEL_OPTION) {
            return true;
        } else if (result == JFileChooser.APPROVE_OPTION) {
            fFile = fc.getSelectedFile();
            if (fFile.exists()) {
                int response = JOptionPane.showConfirmDialog(null,
                        "Overwrite existing file?", "Confirm Overwrite",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.CANCEL_OPTION)
                    return false;
            }
            return writeFile(fFile, label);
        } else {
            return false;
        }
    }

    public static boolean writeFile(File file, Object component) {
        try {

            BufferedImage i1 = ImageIO.read(oldfile);
            BufferedImage bi = new BufferedImage(i1.getWidth(), i1.getHeight(),
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.createGraphics();
            ImageIO.write(i1, "png", fFile);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String title = "Frame Test";
        if (args.length != 0)
            title = args[0];
        ImageCopy f = new ImageCopy(title);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }

}

class ImageFilter1 extends javax.swing.filechooser.FileFilter {
    public boolean accept(File f) {
        return f.getName().toLowerCase().endsWith(".png")
                || f.getName().toLowerCase().endsWith(".jpg")
                || f.getName().toLowerCase().endsWith(".jif")
                || f.isDirectory();
    }

    public String getDescription() {
        return "Image files (*.png)";
    }

}