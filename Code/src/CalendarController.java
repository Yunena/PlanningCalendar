import Calendars.Calendar;
import Events.Date;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class CalendarController {
    Calendar calendar;
    ActionListener [][] es = new ActionListener[6][7];
    public CalendarController(Calendar calendar){
        this.calendar = calendar;
    }

    public void calendar2GUI(int year, int month, GUI gui){
        int[][] calendarArray = calendar.getCalendar(year,month);
        int k = 0;
        List<JButton> buttonList = gui.buttonList;
        for(JButton jb:buttonList){
            int i = k/7,j=k%7;
            jb.removeActionListener(this.es[i][j]);
            if(calendarArray[i][j]==0){
                //jb = new JButton("");
                jb.setBorderPainted(false);
                jb.setIcon(new ImageIcon(""));
                jb.setText("");
                jb.setContentAreaFilled(false);
                jb.setEnabled(false);
            }
            else{
                //jb.setIcon(new ImageIcon("D:\\JavaProjects\\PlanningCalendar\\img\\pic1.png"));
                //jb.setPressedIcon(new ImageIcon("D:\\JavaProjects\\PlanningCalendar\\img\\pic2.png"));
                //jb.setText(String.valueOf(calendarArray[i][j]));
                jb.setContentAreaFilled(false);
                String path = "src\\img\\NotPress\\"+calendarArray[i][j]+".png";
                //System.out.println(path);
                jb.setIcon(new ImageIcon(path));
                jb.setPressedIcon(new ImageIcon(path));
                jb.setEnabled(true);
                this.es[i][j] = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //System.out.println(month+" "+calendarArray[i][j]);
                        gui.dateLabel.setText(month+"月"+calendarArray[i][j]+"日");
                        gui.date = new Date(year,month,calendarArray[i][j]);
                        gui.eventLabel.setText(EventController.showPlaningType(gui.date.toString()));
                    }
                };
                jb.addActionListener(this.es[i][j]);
            }
            jb.setBorderPainted(false);
            k++;
        }
    }



}
