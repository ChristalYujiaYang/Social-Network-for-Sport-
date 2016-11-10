/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


/**
 *
 * @author wyh1
 */
public class Customer{
    
    private int userid;
    private String name;
    private String password;
    private String email;
    private String age;
    private String phone;
    private int login;
    private int basketball;
    private int baseball;
    private int swimming;
    private int football;
    private int jogging;
    private int soccer;
    
    public Customer() {
        super();
    }

    public Customer(int userid, String name, String password, String email, String age, String phone, int login, int basketball, int baseball, int swimming, int jogging, int football, int soccer) {
        super();
        this.userid = userid;
        this.name = name;
        this.password = password;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.login = login;
        this.basketball = basketball;
        this.baseball = baseball;
        this.soccer = soccer;
        this.football = football;
        this.swimming = swimming;
        this.jogging = jogging;
    }
    public int getUserId() {
        return getUserid();
    }   
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return password;
    }   
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }   
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getAge() {
        return age;
    }   
    public void setAge(String age){
        this.age = age;
    }
    
    public String getPhone() {
        return phone;
    }   
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public int getBasketball() {
        return basketball;
    }   
    public void setBasketball(int basketball){
        this.basketball = basketball;
    }
    
   public int getBaseball() {
        return baseball;
    }   
    public void setBaseball(int baseball){
        this.baseball = baseball;
    }
    
    public int getSwimming(){
        return swimming;
    }   
    public void setSwimming(int swimming){
        this.swimming = swimming;
    }
    
    public int getFootball() {
        return football;
    }   
    public void setFootball(int football){
        this.football = football;
    }
    
    public int getJogging() {
        return jogging;
    }   
    public void setJogging(int jogging){
        this.jogging = jogging;
    }
    
    public int getSoccer() {
        return soccer;
    }   
    public void setSoccer(int soccer){
        this.soccer = soccer;
    }

    /**
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    /**
     * @return the login
     */
    public int getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(int login) {
        this.login = login;
    }
}