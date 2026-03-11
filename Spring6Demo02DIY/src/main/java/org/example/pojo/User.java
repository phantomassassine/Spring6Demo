package org.example.pojo;

/**
 * @Date: 2026/3/11 17:02
 * @Description:
 */

public class User {
    private String uname;
    private String pwd;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User() {
        System.out.println("User空构造器");
    }

    public User(String uname, String pwd) {
        System.out.println("User有参构造器");
        this.uname = uname;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public void sleep(){
        System.out.println("User.sleep");
    }
}
