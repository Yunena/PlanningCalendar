package Events;

public class Cycle {
    int month;
    int day;
    Date lastDate;
    private int[] monthdays = {31,31,28,31,30,31,30,31,31,30,31,30,31};

/*    public Cycle(int month,int day,Date lastDate){
        this.month = month;
        this.day = day;
        this.lastDate = lastDate;
    }

    public boolean checkCycle(Date currentDate){
        int cmonth = currentDate.month;
        if(month!=0&&day==0){
            if(currentDate.year>this.lastDate.year){
                cmonth+=12*(currentDate.year-this.lastDate.year);
            }
            if(cmonth-this.lastDate.month>this.month){
                return true;
            }
            else if(cmonth-this.lastDate.month<this.month){
                return false;
            }
            else{
                if(currentDate.day-this.lastDate.day<this.day){
                    return false;
                }
                else{
                    return true;
                }
            }
        }
        else if(month==0&&day!=0){
            if(currentDate.month == this.lastDate.month){
                return currentDate.day- this.lastDate.day>=day;
            }
            else{
                if(currentDate.year > this.lastDate.year){
                    cmonth+=12*(currentDate.year-this.lastDate.year);
                }
                int days = 0;
                for(int i = this.lastDate.month;i<cmonth;i++){
                    days+=this.monthdays[i%12];
                    if(i%12==2&&((lastDate.year+i/12)/4==0&&(lastDate.year+i/12)/100!=0||(lastDate.year+i/12)/400==0)) {
                        days++;
                    }
                }
                days+=currentDate.day;
                return days-this.lastDate.day>=day;
            }
        }
        return false;
    }

    public void updateCycle(){
        if(month!=0){
            if(this.lastDate.month+month>12){
                this.lastDate.year+=(this.lastDate.month+month-1)/12;
                this.lastDate.month=(this.lastDate.month+month)%12;
            }
            else{
                this.lastDate.month=this.lastDate.month+month;
            }
        }
        else if(day!=0){
            int updateDay = this.lastDate.day+day;
            if(updateDay>this.monthdays[this.lastDate.current])
        }
    }*/

}
