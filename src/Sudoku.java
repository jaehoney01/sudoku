public class Sudoku {
    private String ID;
    private String PW;
    private String Name;
    private int Count = 0;
    private String Level;
    private String Timer;
    private Float Rate;

    // Table - member
    public void setID(String id){
        ID = id;
    }
    public void setPW(String pw){
        PW = pw;
    }
    public void setName(String name){
        Name = name;
    }
    public String getID(){
        return ID;
    }
    public String getPW(){
        return PW;
    }
    public String getName(){
        return Name;
    }

    // Table - gameset
    public int setCount(){
        return Count + 1;
    }
    public void setLevel(String level){
        Level = level;
    }
    public String getLevel(){
        return Level;
    }
    public void setTimer(String timer){
        Timer = timer;
    }
    public String getTimer(){
        return Timer;
    }
    public void setRate(Float win){
        Rate = (win / Count) * 100;
    }
    public Float getRate(){
        return Rate;
    }
}
