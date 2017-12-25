package com.junmeng.base.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.junmeng.base.activity.BaseDataBindingActivity;
import com.junmeng.base.fragment.BaseFragment;
import com.junmeng.base.inter.IHint;

/**
 * DataBinding Fragment基类
 *
 * @param <VDB> VDB extends ViewDataBinding
 */

public abstract class BaseDataBindingFragment<VDB extends ViewDataBinding> extends BaseFragment implements IHint {
    private static final String TAG = "BaseDataBindingFragment";
    /**
     * binding对象
     */
    public VDB binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        todoBeforeSetView();
        binding = DataBindingUtil.inflate(inflater, getContentViewResourceId(), container, false);
        initAfterBinding();
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        todoAfterSetView();
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>可覆盖方法>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>start

    public void initAfterBinding() {

    }

    /**
     * 初始化界面之前的操作
     */
    public void todoBeforeSetView() {
    }

    /**
     * 初始化界面之后的操作
     */
    public abstract void todoAfterSetView();
    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<end

    /**
     * 获得相对应的布局layoutID
     *
     * @return
     */
    @CheckResult
    public abstract int getContentViewResourceId();


    /**
     * 弹出普通提示
     *
     * @param hint
     */
    public void showAlert(String hint) {
        if (getActivity() == null) {
            Log.e(TAG, "showAlert: getActivity() is null");
            return;
        }
        if (getActivity() instanceof BaseDataBindingActivity) {
            ((BaseDataBindingActivity) getActivity()).showAlert(hint);
        } else {
            throw new RuntimeException("The Fragment's Activity is not BaseDataBindingActivity,can not use this method.");
        }
    }

    /**
     * 弹出普通提示
     *
     * @param hintResId
     */

    public void showAlert(@StringRes int hintResId) {
        if (getActivity() == null) {
            Log.e(TAG, "showAlert: getActivity() is null");
            return;
        }
        if (getActivity() instanceof BaseDataBindingActivity) {
            ((BaseDataBindingActivity) getActivity()).showAlert(hintResId);
        } else {
            throw new RuntimeException("The Fragment's Activity is not BaseDataBindingActivity,can not use this method.");
        }
    }

    /**
     * 弹出错误提示
     *
     * @param hint
     */
    public void showError(String hint) {
        if (getActivity() == null) {
            Log.e(TAG, "showError: getActivity() is null");
            return;
        }
        if (getActivity() instanceof BaseDataBindingActivity) {
            ((BaseDataBindingActivity) getActivity()).showError(hint);
        } else {
            throw new RuntimeException("The Fragment's Activity is not BaseDataBindingActivity,can not use this method.");
        }
    }

    /**
     * @param hintResId
     */
    public void showError(@StringRes int hintResId) {
        if (getActivity() == null) {
            Log.e(TAG, "showError: getActivity() is null");
            return;
        }
        if (getActivity() instanceof BaseDataBindingActivity) {
            ((BaseDataBindingActivity) getActivity()).showError(hintResId);
        } else {
            throw new RuntimeException("The Fragment's Activity is not BaseDataBindingActivity,can not use this method.");
        }
    }

    /**
     * 弹出告警提示
     *
     * @param hint
     */
    public void showWarning(String hint) {
        if (getActivity() == null) {
            Log.e(TAG, "showWarning: getActivity() is null");
            return;
        }
        if (getActivity() instanceof BaseDataBindingActivity) {
            ((BaseDataBindingActivity) getActivity()).showWarning(hint);
        } else {
            throw new RuntimeException("The Fragment's Activity is not BaseDataBindingActivity,can not use this method.");
        }
    }

    /**
     * 弹出告警提示
     *
     * @param hintResId
     */
    public void showWarning(@StringRes int hintResId) {
        if (getActivity() == null) {
            Log.e(TAG, "showWarning: getActivity() is null");
            return;
        }
        if (getActivity() instanceof BaseDataBindingActivity) {
            ((BaseDataBindingActivity) getActivity()).showWarning(hintResId);
        } else {
            throw new RuntimeException("The Fragment's Activity is not BaseDataBindingActivity,can not use this method.");
        }
    }
}
