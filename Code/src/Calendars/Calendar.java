package Calendars;

import Events.Date;

import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Calendar {
    private Date currentDate;
    private Date searchDate;
    private int currentWeek;
    private int searchWeek;
    private int[] monthdays = {31,31,28,31,30,31,30,31,31,30,31,30,31};

    public void getCurrentDate(){
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy");
        int year = Integer.parseInt(sdf.format(date));
        sdf.applyPattern("MM");
        int month = Integer.parseInt(sdf.format(date));
        sdf.applyPattern("dd");
        int day = Integer.parseInt(sdf.format(date));
        this.currentDate = new Date(year,month,day);
    }

    public int[][] getCalendar(int year, int month){//1900.1.1 Mon
        int rows=6,cols=7;
        int[][] monthCalendar = new int[rows][cols];
        int startDay = 0;
        for (int i = 1900;i<year;i++){
            startDay=(startDay+365)%7;
            if(i%4==0&&i/100!=0||i%400==0){
                startDay=(startDay+1)%7;
            }
        }
        for (int i = 1;i<month;i++){
            startDay=(startDay+this.monthdays[i])%7;
            if(i==2&&(year%4==0&&year/100!=0||year%400==0)){
                startDay=(startDay+1)%7;
            }
        }
        int monthday=this.monthdays[month];
        if(month==2&&(year%4==0&&year/100!=0||year%400==0)){
            monthday+=1;
        }
        int k = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0&&j<startDay) continue;
                monthCalendar[i][j]=++k;
                if(k==monthday) break;
            }
            if(k==monthday) break;
        }
        /*for(int[] nums:monthCalendar){
            System.out.println(Arrays.toString(nums));
        }*/
        return monthCalendar;
    }

    public static void main(String[] args) {
        Calendar ca = new Calendar();
        //ca.getCurrentDate();
        ca.getCalendar(2020,2);
    }

}
