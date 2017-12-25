package com.junmeng.base.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.CheckResult;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityOptionsCompat;
import android.text.TextUtils;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.junmeng.base.inter.IHint;


/**
 * DataBindingActivity基类
 *
 * @param <T> T extends ViewDataBinding
 */
public abstract class BaseDataBindingActivity<T extends ViewDataBinding> extends BaseActivity implements IHint {
    private static final String TAG = "BaseDataBindingActivity";
    public T binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isFullScreen()) {
            setFullScreen();
        }
        todoBeforeSetContentView();
        binding = DataBindingUtil.setContentView(this, getContentViewResourceId());
        initAfterBinding();
        todoAfterSetContentView();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.i("activity_lifecycle", this.getClass() + "  onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);// 在处理extra之前一定要调用,如果没有调用此句，在getIntent时可能拿不到数据
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>可覆盖方法>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>start

    /**
     * setContentView之前的操作
     */
    public void todoBeforeSetContentView() {
    }

    /**
     * setContentView后的操作
     */
    public void todoAfterSetContentView() {
    }

    /**
     * 是否全屏,默认false
     * 可覆盖此方法改写返回值
     *
     * @return
     */
    public boolean isFullScreen() {
        return false;
    }
    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<end

    /**
     * 获得相对应的布局layoutID
     *
     * @return
     */
    @CheckResult
    public abstract int getContentViewResourceId();

    /**
     * 绑定之后的初始化操作
     */
    @CallSuper
    public void initAfterBinding() {
        //添加动画效果
        binding.addOnRebindCallback(new OnRebindCallback() {
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    ViewGroup view = (ViewGroup) binding.getRoot();
                    TransitionManager.beginDelayedTransition(view);
                    return true;
                }
                return false;
            }
        });
    }


    /**
     * 设置转场动画效果
     *
     * @param activity
     * @param view
     * @param xmlName  需要在第二个activity中xml 中设置view 的  android:transitionName=""
     */

    public void gotoActivity(Class activity, View view, String xmlName) {
        // ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeScaleUpAnimation(view, 100, 20, 100, 350);
        //ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeClipRevealAnimation(view, 60, 60, 30, 30);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, xmlName);
        Intent intent = new Intent(this, activity);
        startActivity(intent, optionsCompat.toBundle());
    }

    /**
     * 弹出普通提示
     *
     * @param hint
     */
    @Override
    public void showAlert(final String hint) {
        if (TextUtils.isEmpty(hint)) {
            return;
        }

        if (getHintManagerInstance() != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    getHintManagerInstance().showAlert(hint);
                }
            });
        } else {
            Log.e(TAG, "showAlert: getHintManagerInstance() is null");
            throw new RuntimeException("If you want to use this,please implements the method named \"getHintManagerInstance\"");
        }
    }

    @Override
    public void showAlert(final @StringRes int hintResId) {
        if (getHintManagerInstance() != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    getHintManagerInstance().showAlert(hintResId);
                }
            });
        } else {
            Log.e(TAG, "showAlert: getHintManagerInstance() is null");
            throw new RuntimeException("If you want to use this,please implements the method named \"getHintManagerInstance\"");
        }
    }

    /**
     * 弹出错误提示
     *
     * @param hint
     */
    @Override
    public void showError(final String hint) {
        if (TextUtils.isEmpty(hint)) {
            return;
        }

        if (getHintManagerInstance() != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    getHintManagerInstance().showError(hint);
                }
            });
        } else {
            Log.e(TAG, "showError: getHintManagerInstance() is null");
            throw new RuntimeException("If you want to use this,please implements the method named \"getHintManagerInstance\"");
        }
    }

    @Override
    public void showError(final @StringRes int hintResId) {

        if (getHintManagerInstance() != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    getHintManagerInstance().showError(hintResId);
                }
            });
        } else {
            Log.e(TAG, "showError: getHintManagerInstance() is null");
            throw new RuntimeException("If you want to use this,please implements the method named \"getHintManagerInstance\"");
        }
    }

    /**
     * 弹出告警提示
     *
     * @param hint
     */
    @Override
    public void showWarning(final String hint) {
        if (TextUtils.isEmpty(hint)) {
            return;
        }

        if (getHintManagerInstance() != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    getHintManagerInstance().showWarning(hint);
                }
            });
        } else {
            Log.e(TAG, "showWarning: getHintManagerInstance() is null");
            throw new RuntimeException("If you want to use this,please implements the method named \"getHintManagerInstance\"");
        }
    }

    @Override
    public void showWarning(final @StringRes int hintResId) {
        if (getHintManagerInstance() != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    getHintManagerInstance().showWarning(hintResId);
                }
            });
        } else {
            Log.e(TAG, "showWarning: getHintManagerInstance() is null");
            throw new RuntimeException("If you want to use this,please implements the method named \"getHintManagerInstance\"");
        }
    }

    /**
     * 返回一个HintManagerInstance(单例模式)
     * <br/>用户可在此实现自定义提示样式，如自定义Toast或自定义对话框或自定义Snackbar等
     *
     * @return
     */
    public IHint getHintManagerInstance() {
        return null;
    }

}
