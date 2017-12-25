package com.junmeng.base.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.junmeng.base.BuildConfig;


public abstract class BaseFragment extends Fragment {

    private ProgressDialog progressDialog;
    /**
     * 显示加载对话框
     */
    public void showLoadingDialog() {
        showLoadingDialog("请稍候...");

    }

    /**
     * 显示加载对话框
     *
     * @param hint 提示信息
     */
    public void showLoadingDialog(final String hint) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (progressDialog != null && !progressDialog.isShowing()) {
                        progressDialog.setMessage(hint);
                        progressDialog.show();
                    } else {
                        progressDialog = new ProgressDialog(getActivity());
                        progressDialog.setCanceledOnTouchOutside(false);
                        progressDialog.setMessage(hint);
                        progressDialog.show();
                    }
                }
            });
        }

    }

    /**
     * 隐藏加载对话框
     */
    public void cancelLoadingDialog() {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (progressDialog != null && progressDialog.isShowing()) {
                        progressDialog.cancel();
                    }
                }
            });
        }
    }

    public void showLongToast(final String msg) {
        if (!TextUtils.isEmpty(msg)) {
            if (getActivity() != null) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
                    }
                });
            }
        }

    }

    public void showLongToast(@StringRes  final int resId) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getActivity(), resId, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void showShortToast(final String msg) {
        if (!TextUtils.isEmpty(msg)) {
            if (getActivity() != null) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

    public void showShortToast(@StringRes final int resId) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getActivity(), resId, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    /**
     * 显示测试Toast,只在debug下生效
     *
     * @param msg
     */
    public void showDebugToast(final String msg) {
        if (BuildConfig.DEBUG) {
            showShortToast(msg);
        }
    }

    /**
     * 显示测试Toast,只在debug下生效
     *
     * @param resId
     */
    public void showDebugToast(@StringRes final int resId) {
        if (BuildConfig.DEBUG) {
            showShortToast(resId);
        }
    }

    /**
     * 获得屏幕宽度
     * @return
     */
    public int getScreenWidth(){
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        return  dm.widthPixels;
    }

    /**
     * 获得屏幕高度
     * @return
     */
    public int getScreenHeight(){
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        return  dm.heightPixels;
    }

    @Override
    public void onAttach(Context context) {
        Log.i("fragment_lifecycle", getClass() + "   onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("fragment_lifecycle", getClass() + "   onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("fragment_lifecycle", getClass() + "   onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i("fragment_lifecycle", getClass() + "   onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i("fragment_lifecycle", getClass() + "   onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i("fragment_lifecycle", getClass() + "   onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i("fragment_lifecycle", getClass() + "   onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i("fragment_lifecycle", getClass() + "   onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.i("fragment_lifecycle", getClass() + "   onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.i("fragment_lifecycle", getClass() + "   onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Log.i("fragment_lifecycle", getClass() + "   onDetach");
        super.onDetach();
    }
}
