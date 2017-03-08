package com.cxz.mvplogin.listener;

import com.cxz.mvplogin.base.model.IModel;
import com.cxz.mvplogin.model.ILoginModel;

/**
 * Created by chenxiaozhen on 2015/11/14.
 *
 * 登录的回调接口
 */
public interface ILoginCallBack {

    void onLogin(IModel model);

}
