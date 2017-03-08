package com.cxz.mvplogin.presenter;

import com.cxz.mvplogin.base.model.IModel;
import com.cxz.mvplogin.listener.ILoginCallBack;
import com.cxz.mvplogin.model.ILoginModel;
import com.cxz.mvplogin.model.impl.LoginModel;
import com.cxz.mvplogin.view.ILoginView;

/**
 * Created by chenxiaozhen on 2015/11/14.
 *
 * 5. 建立presenter（主导器，通过iView和iModel接口操作model和view），
 *    activity可以把所有逻辑给presenter处理，这样java逻辑就从手机的activity中分离出来。
 */
public class LoginPresenter {

    private ILoginModel mLoginModel;//模型
    private ILoginView mLoginView;//视图对象

    public LoginPresenter(){
        mLoginModel = new LoginModel();
    }

    public void setLoginView(ILoginView mLoginView) {
        this.mLoginView = mLoginView;
    }

    public ILoginView getLoginView() {
        return mLoginView;
    }

    public void didLogin(String account , String psw){
        mLoginModel.login(account, psw, new ILoginCallBack() {
            @Override
            public void onLogin(IModel model) {
                LoginModel loginModel = (LoginModel) model;
                switch (loginModel.getStatus()){
                    case ILoginModel.STATUS_VERIFY_FAIL://验证失败
                    case ILoginModel.STATUS_LOGIN_FAIL://登录失败
                        mLoginView.hideLoading();
                        mLoginView.showMsg(loginModel.getMsg());
                        break;
                    case ILoginModel.STATUS_LOGIN_ING://登录中
                        mLoginView.showLoading();
                    case ILoginModel.STATUS_LOGIN_SUCCESS://登录成功
                        mLoginView.hideLoading();
                        mLoginView.moveTo();
                        break;
                }
            }
        });
    }

}
