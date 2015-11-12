/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 



/*
 * Swing version
 */

/*
 * https://docs.oracle.com/javase/tutorial/uiswing/events/intro.html
 * 
 * The event model, which you saw at its simplest in the preceding example, 
 * is quite powerful and flexible. Any number of event listener objects can 
 * listen for all kinds of events from any number of event source objects. 
 * For example, a program might create one listener per event source. Or a 
 * program might have a single listener for all events from all sources. A 
 * program can even have more than one listener for a single kind of event 
 * from a single event source.
 * 
 * Event source with multiple listeners
 *
 * Multiple listeners can register to be notified of events of a particular 
 * type from a particular source. Also, the same listener can listen to 
 * notifications from different objects.
 * 
 * Each event is represented by an object that gives information about the 
 * event and identifies the event source. Event sources are often components 
 * or models, but other kinds of objects can also be event sources.
 * 
 * Whenever you want to detect events from a particular component, first check 
 * the how-to section for that component. A list of the component how-to sections 
 * is here. The how-to sections give examples of handling the events that you are 
 * most likely to care about. In How to Use Color Choosers, for instance, you will 
 * find an example of writing a change listener to track when the color changes in 
 * the color chooser.
 * 
 * The following example demonstrates that event listeners can be registered on 
 * multiple objects and that the same event can be sent to multiple listeners. The 
 * example contains two event sources (JButton instances) and two event listeners. 
 * One of the event listeners (an instance of a class called MultiListener) listens 
 * for events from both buttons. When it receives an event, it adds the event's 
 * "action command" (which is set to the text on the button's label) to the top text 
 * area. The second event listener (an instance of a class called Eavesdropper) listens 
 * for events on only one of the buttons. When it receives an event, it adds the action 
 * command to the bottom text area.
 */

import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MultiListener extends JPanel 
                           implements ActionListener {
    JTextArea topTextArea;
    JTextArea bottomTextArea;
    JButton button1, button2;
    final static String newline = "\n";

    public MultiListener() {
        super(new GridBagLayout());
        GridBagLayout gridbag = (GridBagLayout)getLayout();
        GridBagConstraints c = new GridBagConstraints();

        JLabel l = null;

        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = GridBagConstraints.REMAINDER;
        l = new JLabel("What MultiListener hears:");
        gridbag.setConstraints(l, c);
        add(l);

        c.weighty = 1.0;
        topTextArea = new JTextArea();
        topTextArea.setEditable(false);
        JScrollPane topScrollPane = new JScrollPane(topTextArea);
        Dimension preferredSize = new Dimension(200, 75);
        topScrollPane.setPreferredSize(preferredSize);
        gridbag.setConstraints(topScrollPane, c);
        add(topScrollPane);

        c.weightx = 0.0;
        c.weighty = 0.0;
        l = new JLabel("What Eavesdropper hears:");
        gridbag.setConstraints(l, c);
        add(l);

        c.weighty = 1.0;
        bottomTextArea = new JTextArea();
        bottomTextArea.setEditable(false);
        JScrollPane bottomScrollPane = new JScrollPane(bottomTextArea);
        bottomScrollPane.setPreferredSize(preferredSize);
        gridbag.setConstraints(bottomScrollPane, c);
        add(bottomScrollPane);

        c.weightx = 1.0;
        c.weighty = 0.0;
        c.gridwidth = 1;
        c.insets = new Insets(10, 10, 0, 10);
        button1 = new JButton("Blah blah blah");
        gridbag.setConstraints(button1, c);
        add(button1);

        c.gridwidth = GridBagConstraints.REMAINDER;
        button2 = new JButton("You don't say!");
        gridbag.setConstraints(button2, c);
        add(button2);

        button1.addActionListener(this);
        button2.addActionListener(this);

        button2.addActionListener(new Eavesdropper(bottomTextArea));

        setPreferredSize(new Dimension(450, 450));
        setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createMatteBorder(
                                                1,1,2,2,Color.black),
                                BorderFactory.createEmptyBorder(5,5,5,5)));
    }

    public void actionPerformed(ActionEvent e) {
        topTextArea.append(e.getActionCommand() + newline);
        topTextArea.setCaretPosition(topTextArea.getDocument().getLength());
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("MultiListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new MultiListener();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

class Eavesdropper implements ActionListener {
    JTextArea myTextArea;
    public Eavesdropper(JTextArea ta) {
        myTextArea = ta;
    }

    public void actionPerformed(ActionEvent e) {
        myTextArea.append(e.getActionCommand()
                        + MultiListener.newline);
        myTextArea.setCaretPosition(myTextArea.getDocument().getLength());
    }
}