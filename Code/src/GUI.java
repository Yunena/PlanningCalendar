import Calendars.Calendar;
import Events.Date;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUI {
    public JPanel panel;
    public JButton button1;
    public JButton button2;
    public JButton button3;
    public JButton button4;
    public JButton button5;
    public JButton button6;
    public JButton button7;
    public JButton button8;
    public JButton button9;
    public JButton button10;
    public JButton button11;
    public JButton button12;
    public JButton button13;
    public JButton button14;
    public JButton button15;
    public JButton button16;
    public JButton button17;
    public JButton button18;
    public JButton button19;
    public JButton button20;
    public JButton button21;
    public JButton button22;
    public JButton button23;
    public JButton button24;
    public JButton button25;
    public JButton button26;
    public JButton button27;
    public JButton button28;
    public JButton button29;
    public JButton button30;
    public JButton button31;
    public JButton button32;
    public JButton button33;
    public JButton button34;
    public JButton button35;
    public JButton button36;
    public JButton button37;
    public JButton button38;
    public JButton button39;
    public JButton button40;
    public JButton button41;
    public JButton button42;
    public JTextField textField2;
    public JTextField textField1;
    public JButton searchButton;
    public JLabel eventLabel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton addButton;
    public JLabel dateLabel;
    public List<JButton> buttonList = new ArrayList<>(){{
        add(button1);add(button2);add(button3);add(button4);add(button5);add(button6);add(button7);
        add(button8);add(button9);add(button10);add(button11);add(button12);add(button13);add(button14);
        add(button15);add(button16);add(button17);add(button18);add(button19);add(button20);add(button21);
        add(button22);add(button23);add(button24);add(button25);add(button26);add(button27);add(button28);
        add(button29);add(button30);add(button31);add(button32);add(button33);add(button34);add(button35);
        add(button36);add(button37);add(button38);add(button39);add(button40);add(button41);add(button42);
    }
    };
    public Date date;



    public void searchForCalendar(GUI gui,CalendarController calc){

        JButton jb = gui.searchButton;
        JComboBox jc = gui.comboBox2;
        jc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int year = Integer.parseInt(String.valueOf(gui.comboBox1.getSelectedItem()));
                int month = Integer.parseInt(String.valueOf(gui.comboBox2.getSelectedItem()));
                System.out.println(year+" "+month);
                calc.calendar2GUI(year,month,gui);
            }
        });
        jc = gui.comboBox1;
        jc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int year = Integer.parseInt(String.valueOf(gui.comboBox1.getSelectedItem()));
                int month = Integer.parseInt(String.valueOf(gui.comboBox2.getSelectedItem()));
                System.out.println(year+" "+month);
                calc.calendar2GUI(year,month,gui);
            }
        });

        /*jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int year = Integer.parseInt(String.valueOf(gui.comboBox1.getSelectedItem()));
                int month = Integer.parseInt(String.valueOf(gui.comboBox2.getSelectedItem()));
                System.out.println(year+" "+month);
                calc.calendar2GUI(year,month,gui);
            }
        });*/

    }

    public void addPlanning(GUI gui){
        JButton addjb = gui.addButton;
        addjb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = gui.textField1.getText();
                EventController.savePlanningType(EventController.updatePlanningType(EventController.getPlanningType(),gui.date.toString(),str));
                //gui.eventLabel.setText(gui.textField1.getText());
                gui.eventLabel.setText(EventController.showPlaningType(gui.date.toString()));
                gui.textField1.setText("");
            }
        });
    }

    public static void main(String[] args) {
        CalendarController calc = new CalendarController(new Calendar());
        GUI gui=new GUI();
        Date cd = calc.calendar.getCurrentDate();
        gui.comboBox1.setSelectedIndex(cd.year-Integer.parseInt(String.valueOf(gui.comboBox1.getItemAt(0))));
        gui.comboBox2.setSelectedIndex(cd.month-1);
        calc.calendar2GUI(cd.year,cd.month,gui);
        gui.searchForCalendar(gui,calc);
        gui.dateLabel.setText(cd.month+"月"+cd.day+"日");
        gui.eventLabel.setText(EventController.showPlaningType(cd.toString()));
        gui.date = cd;
        gui.addPlanning(gui);


        //calc.calendar2GUI(2022,3,gui);
        JFrame frame = new JFrame("PlanningCalendar");
        //frame.setSize(300, 300);
        frame.setContentPane(gui.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(10000, 8000);
        frame.pack();
        frame.setVisible(true);
    }

}
