package com.cxz.mvplogin.model;

import com.cxz.mvplogin.base.model.IModel;
import com.cxz.mvplogin.listener.ILoginCallBack;

/**
 * Created by chenxiaozhen on 2015/11/14.
 *
 * 3. 建立model（处理业务逻辑，这里指数据读写），先写接口，后写实现
 */
public interface ILoginModel extends IModel {

    /**
     * 验证失败
     */
    public static final int STATUS_VERIFY_FAIL = -1;

    /**
     * 登录失败
     */
    public static final int STATUS_LOGIN_FAIL = -2;

    /**
     * 登录成功
     */
    public static final int STATUS_LOGIN_SUCCESS = 0;

    /**
     * 登录中
     */
    public static final int STATUS_LOGIN_ING = 1;


    /**
     * 登录状态
     *
     * @param account
     * @param psw
     * @param callBack
     */
    public void login(String account,String psw,ILoginCallBack callBack);

}
