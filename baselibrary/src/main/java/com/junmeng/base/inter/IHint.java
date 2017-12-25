package com.junmeng.base.inter;

import android.support.annotation.StringRes;

/**
 * 信息提示接口
 */

public interface IHint {
    /**
     * 弹出普通提示
     *
     * @param hint
     */
    void showAlert(String hint);


    /**
     * 弹出普通提示
     *
     * @param hintResId
     */
    void showAlert(@StringRes int hintResId);

    /**
     * 弹出错误提示
     *
     * @param hint
     */
    void showError(String hint);

    /**
     * @param hintResId
     */
    void showError(@StringRes int hintResId);

    /**
     * 弹出告警提示
     *
     * @param hint
     */
    void showWarning(String hint);

    /**
     * 弹出告警提示
     *
     * @param hintResId
     */
    void showWarning(@StringRes int hintResId);
}
