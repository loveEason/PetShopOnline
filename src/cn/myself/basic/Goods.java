package cn.myself.basic;

/**
 * 宠物商品类
 */
public class Goods extends Pet {
    private float price;    //价格
    private int inventory;  //库存

    public void setPrice(float price){
        this.price = price;
    }
    public float getPrice(){
        return price;
    }
    public void setInventory(int inventory){
        this.inventory = inventory;
    }
    public int getInventory(){
        return inventory;
    }


}
