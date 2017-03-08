package com.cxz.mvplogin.view;

import com.cxz.mvplogin.base.view.IView;

/**
 * Created by chenxiaozhen on 2015/11/14.
 *
 * 4. 建立view（更新ui中的view状态），这里列出需要操作当前view的方法，也是接口
 */
public interface ILoginView extends IView {

    /**
     * 弹出提示信息
     *
     * @param msg
     */
    public void showMsg(String msg);

    /**
     * 加载中，显示dialog
     */
    public void showLoading();

    /**
     * 隐藏dialog
     */
    public void hideLoading();

    /**
     * 成功登录跳转主页面
     */
    public void moveTo();


}
