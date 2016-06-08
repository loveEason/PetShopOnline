package cn.myself.basic;

/**
 * 宠物类
 */
public class Pet {
    private int id; //编号
    private String name;    //姓名
    private String eat; //吃的东西
    private String drink;   //喝的东西
    private String live;    //生活的地方
    private String hobby;   //爱好习惯

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setEat(String eat) {
        this.eat = eat;
    }
    public String getEat() {
        return eat;
    }
    public void setDrink(String drink){
        this.drink = drink;
    }
    public String getDrink() {
        return drink;
    }
    public void setLive(String live){
        this.live = live;
    }
    public String getLive() {
        return live;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    public String getHobby() {
        return hobby;
    }
}
