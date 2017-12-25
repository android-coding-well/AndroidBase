package com.hwj.dab;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.junmeng.base.inter.IHint;
import com.junmeng.snackbar.ColorSnackbar;

/**
 * 信息提示接口示例，可直接参考此类实现自定义提示效果
 * Created by HuWeiJian on 2017/12/25.
 */

public class HintManager implements IHint {
    private View rootView;

    private HintManager(View rootView) {
        this.rootView = rootView;
    }

    private static HintManager hintManager;

    public static HintManager getInstance(View rootView) {
        if (hintManager == null) {
            hintManager = new HintManager(rootView);
        }

        return hintManager;
    }

    @Override
    public void showAlert(String hint) {
        ColorSnackbar.alert(Snackbar.make(rootView, hint, Snackbar.LENGTH_SHORT), getIconResId());
    }

    @Override
    public void showAlert(int hintResId) {
        ColorSnackbar.alert(Snackbar.make(rootView, hintResId, Snackbar.LENGTH_SHORT), getIconResId());
    }

    @Override
    public void showError(String hint) {
        ColorSnackbar.error(Snackbar.make(rootView, hint, Snackbar.LENGTH_SHORT), getIconResId());
    }

    @Override
    public void showError(int hintResId) {
        ColorSnackbar.error(Snackbar.make(rootView, hintResId, Snackbar.LENGTH_SHORT), getIconResId());
    }

    @Override
    public void showWarning(String hint) {
        ColorSnackbar.warning(Snackbar.make(rootView, hint, Snackbar.LENGTH_SHORT), getIconResId());
    }

    @Override
    public void showWarning(int hintResId) {
        ColorSnackbar.warning(Snackbar.make(rootView, hintResId, Snackbar.LENGTH_SHORT), getIconResId());
    }

    public int getIconResId() {
        return R.mipmap.ic_launcher;
    }
}
