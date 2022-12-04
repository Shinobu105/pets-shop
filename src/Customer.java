import java.time.LocalDate;

public class Customer {
    private String name;
    private int times=0;
    private LocalDate clock;
    public void setName(String name){
        this.name = name;
    }
    public void setTimes(int times){
        this.times = times;
    }
    public void setClock(LocalDate clock){
        this.clock=clock;
    }
    public int getTimes(){
        return this.times;
    }
    public String toString(){
        return this.name +"来店次数" + this.times + "时间" + this.clock;
    }

}
