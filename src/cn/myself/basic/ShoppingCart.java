package cn.myself.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * 购物车类
 */
public class ShoppingCart {
    private Map<Integer,Integer> map = new HashMap<Integer, Integer>();   //编号id和数量number

    public Map<Integer,Integer> getMap() {
        return map;
    }

    //往购物车添加东西
    public void add(int i,int number){
        map.put(i,number);
    }

    //清空购物车
    public void delete() {
        map.clear();
    }

}
