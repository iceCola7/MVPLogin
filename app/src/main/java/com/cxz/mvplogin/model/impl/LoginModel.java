package com.cxz.mvplogin.model.impl;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.cxz.mvplogin.listener.ILoginCallBack;
import com.cxz.mvplogin.model.ILoginModel;

/**
 * Created by chenxiaozhen on 2015/11/14.
 *
 * 实现类，真正的数据访问操作
 */
public class LoginModel implements ILoginModel {

    private int status = ILoginModel.STATUS_LOGIN_ING;
    private String msg = "";

    @Override
    public void login(final String account, final String psw, final ILoginCallBack callBack) {
        new AsyncTask<String , Void , ILoginModel>(){


            @Override
            protected ILoginModel doInBackground(String... params) {
                if(varify(account,psw)){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if("Change".equals(account)&&"123".equals(psw)){
                        status = ILoginModel.STATUS_LOGIN_SUCCESS;
                        msg = "登录成功";
                    }else {
                        status = ILoginModel.STATUS_LOGIN_FAIL;
                        msg = "登录失败";
                    }
                }
                return LoginModel.this;
            }

            @Override
            protected void onPreExecute() {
                callBack.onLogin(LoginModel.this);
            }

            @Override
            protected void onPostExecute(ILoginModel loginModel) {
                callBack.onLogin(loginModel);
            }
        }.execute();
    }

    /**
     * 本地校验
     *
     * @param account
     * @param psw
     * @return
     */
    private boolean varify(String account, String psw) {
        if(TextUtils.isEmpty(account)){
            status = ILoginModel.STATUS_VERIFY_FAIL;
            msg = "用户名不能为空！";
            return false;
        }else if(TextUtils.isEmpty(psw)){
            status = ILoginModel.STATUS_VERIFY_FAIL;
            msg = "密码不能为空！";
            return false;
        }
        return true;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
