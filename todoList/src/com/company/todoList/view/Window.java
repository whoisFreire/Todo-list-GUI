package com.company.todoList.view;

import com.company.todoList.model.Todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Window extends JFrame implements WindowListener, ActionListener {
    protected Dimension dFrame, dTextArea, dTextField, dLabel, dButton;
    protected Label lTodo;
    protected TextField tTodo;
    protected Button bCreate, bExit, bDone;
    protected TextArea taTodos;

    protected Todo todo;
    public Window() {
        todo = new Todo();

        dFrame = new Dimension(350, 400);
        dLabel = new Dimension(40, 20);
        dTextField = new Dimension(150, 20);
        dButton = new Dimension(95,20);
        dTextArea = new Dimension(300, 140);

        setTitle("Todo List");
        setResizable(false);
        setSize(dFrame);
        setLocation(700, 200);
        setLayout(null);

        lTodo = new Label("Todo:");
        lTodo.setSize(dLabel);
        lTodo.setLocation(25, 30);
        add(lTodo);

        tTodo = new TextField(null);
        tTodo.setSize(dTextField);
        tTodo.setLocation(75, 30);
        add(tTodo);

        bCreate = new Button("Create");
        bCreate.setSize(dButton);
        bCreate.addActionListener(this);
        bCreate.setLocation(25, 150);
        add(bCreate);

        bDone = new Button("Done");
        bDone.setSize(dButton);
        bDone.addActionListener(this);
        bDone.setLocation(25, 185);
        add(bDone);

        bExit = new Button("Exit");
        bExit.setSize(dButton);
        bExit.addActionListener(this);
        bExit.setLocation(180,150);
        add(bExit);

        taTodos = new TextArea(null);
        taTodos.setSize(dTextArea);
        taTodos.setLocation(25,220);
        add(taTodos);

        addWindowListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bExit){
            System.exit(0);
            return;
        }
        if(e.getSource() == bCreate){
            String description = tTodo.getText();
            todo.create(description);
            taTodos.append(description + "\n");
            tTodo.setText(null);
            tTodo.requestFocus();
            return;
        }
        if(e.getSource() == bDone) {
            String description = tTodo.getText();
            JOptionPane.showMessageDialog(null,
                    description+" Done",
                    "Done",
                    JOptionPane.INFORMATION_MESSAGE);
            taTodos.append(description + " done!\n");
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
