package com.cxz.mvplogin.bean;

/**
 * Created by chenxiaozhen on 2015/11/14.
 *
 * 2. 建立bean
 */
public class UserBean {

    private int id;
    private String account;
    private String psw;

    public UserBean() {
    }

    public UserBean(int id, String psw, String account) {
        this.id = id;
        this.psw = psw;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
