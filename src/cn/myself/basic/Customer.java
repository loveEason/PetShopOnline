package cn.myself.basic;

/**
 * 用户类
 */
public class Customer {
    private String name;    //姓名
    private String sex;     //性别
    private String accountNumber;   //账号
    private String password;    //密码
    private ShoppingCart cart = new ShoppingCart();     //购物车


    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public String getSex(){
        return sex;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setCart(ShoppingCart shoppingCart){
        this.cart = shoppingCart;
    }
    public ShoppingCart getCart() {
        return cart;
    }

}
