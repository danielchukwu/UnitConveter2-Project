import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class UnitConverter {

    // first page
    void convertInchToFoot () {

        // create frame
        JFrame frame = new JFrame("Inches to Foot");

        frame.setSize(500, 1000);            // set size of frame (width and height)
        frame.setLayout(new GridLayout(3, 1)); // set layout of frame (row and columns)

        // create label for inches
        JLabel inchLabel = new JLabel("Convert Inches to Feet  ");
        frame.add(inchLabel);

        // create inch input field
        JTextField inch = new JTextField();
        frame.add(inch);

        // create button to submit
        JButton button = new JButton("convert");
        frame.add(button);

        // make frame visible
        frame.setVisible(true);

        // add button listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = inch.getText();   // get text from the textfield inch(in line19)
                int valueInInteger = Integer.parseInt(value);   // convert to integer value
                int result = valueInInteger / 12;     // this gives you inches converted to Feet

                System.out.println(value + " inches in feet is " + result);   // print out

                // write to file
                try {
                    // create filewriter
                    FileWriter newFile = new FileWriter("conversionfile.txt");

                    newFile.write("RESULT: " + result + " feet");   // write to file
                    newFile.close();   // close file

                } catch (Exception ee) {
                    System.out.println(ee);
                }

                frame.setVisible(false);   // set frame visibility to false
                donePage();    // function call
            }
        });
    }

    // second page
    void donePage () {

        // create 2nd page frame
        JFrame frame = new JFrame("Inches to Foot");

        frame.setSize(500, 1000);              // set size of frame (width and height)
        frame.setLayout(new GridLayout(1, 1));   // set layout of frame (row and columns)

        // create button that displays
        JButton button = new JButton("CONVERSION SUCCESSFUL. CHECK FILE 'conversionfile.txt' TO SEE RESULT");
        frame.add(button);       // add button to frame

        // make frame visible
        frame.setVisible(true);

        // add action listener to button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // close page
                frame.setVisible(false);   // set frame visibility to false
            }
        });

    }
}
