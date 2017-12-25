package com.hwj.dab;


import android.view.View;

import com.hwj.dab.databinding.ActivityMainBinding;
import com.junmeng.base.activity.BaseDataBindingActivity;
import com.junmeng.base.inter.IHint;

public class MainActivity extends BaseDataBindingActivity<ActivityMainBinding> {

    @Override
    public int getContentViewResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public IHint getHintManagerInstance() {
        return HintManager.getInstance(binding.getRoot());
    }

    /**
     * 是否全屏
     * @return
     */
    @Override
    public boolean isFullScreen() {
        return true;
    }

    /**
     * 绑定之后的初始化操作,此步之前使用binding对象会为null
     */
    @Override
    public void initAfterBinding() {
        super.initAfterBinding();
    }

    @Override
    public void todoBeforeSetContentView() {
    }

    @Override
    public void todoAfterSetContentView() {
    }

    public void onClickAlert(View view) {
        showAlert("（最多显示两行）很长很长一段提示很长很长一段提示很长很长一段提示很长很长一段提示很长很长一段提示很长很长一段提示很长很长一段提示很长很长一段提示很长很长一段提示很长很长一段提示很长很长一段提示很长很长一段提示很长很长一段提示很长很长一段提示很长很长一段提示");
    }

    public void onClickWarning(View view) {
        showWarning("（最多显示两行）警告：如需指定颜色，请在colors.xml添加如下：\n" +
                " * <color name=\"j_snack_alert\">#129BFF</color>\n" +
                " * <color name=\"j_snack_warning\">#FEB500</color>\n" +
                " * <color name=\"j_snack_error\">#FF5B3B</color>");
    }

    public void onClickError(View view) {
        showError("严重错误");
    }

    public void onClickLoading(View view) {
        showLoadingDialog("正在加载。。。");
    }
}
