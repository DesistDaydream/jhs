package com.m7.imkfsdk.view.pickerview.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.view.pickerview.listener.OnDismissListener;
import com.m7.imkfsdk.view.pickerview.utils.PickerViewAnimateUtil;

/* loaded from: classes2.dex */
public class newBasePickerView {
    private boolean cancelable;
    public View clickView;
    public ViewGroup contentContainer;
    private Context context;
    public ViewGroup decorView;
    private View dialogView;
    private boolean dismissing;
    private Animation inAnim;
    private boolean isShowing;
    private Dialog mDialog;
    private OnDismissListener onDismissListener;
    private Animation outAnim;
    private ViewGroup rootView;
    private final FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -2, 80);
    public int pickerview_timebtn_nor = -16417281;
    public int pickerview_timebtn_pre = -4007179;
    public int pickerview_bg_topbar = -657931;
    public int pickerview_topbar_title = ViewCompat.MEASURED_STATE_MASK;
    public int bgColor_default = -1;
    private int gravity = 80;
    private boolean isAnim = true;
    private View.OnKeyListener onKeyBackListener = new View.OnKeyListener() { // from class: com.m7.imkfsdk.view.pickerview.view.newBasePickerView.2
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 == 4 && keyEvent.getAction() == 0 && newBasePickerView.this.isShowing()) {
                newBasePickerView.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener onCancelableTouchListener = new View.OnTouchListener() { // from class: com.m7.imkfsdk.view.pickerview.view.newBasePickerView.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                newBasePickerView.this.dismiss();
                return false;
            }
            return false;
        }
    };

    public newBasePickerView(Context context) {
        this.context = context;
    }

    private void onAttached(View view) {
        this.decorView.addView(view);
        if (this.isAnim) {
            this.contentContainer.startAnimation(this.inAnim);
        }
    }

    public void createDialog() {
        if (this.dialogView != null) {
            Dialog dialog = new Dialog(this.context, R.style.ykfsdk_BottomDialog);
            this.mDialog = dialog;
            dialog.setContentView(this.dialogView);
            this.mDialog.getWindow().setGravity(80);
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.m7.imkfsdk.view.pickerview.view.newBasePickerView.4
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (newBasePickerView.this.onDismissListener != null) {
                        newBasePickerView.this.onDismissListener.onDismiss(newBasePickerView.this);
                    }
                }
            });
            this.dialogView.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.view.pickerview.view.newBasePickerView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    newBasePickerView.this.dismiss();
                }
            });
        }
    }

    public void dismiss() {
        dismissDialog();
    }

    public void dismissDialog() {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void dismissImmediately() {
        this.decorView.post(new Runnable() { // from class: com.m7.imkfsdk.view.pickerview.view.newBasePickerView.1
            @Override // java.lang.Runnable
            public void run() {
                newBasePickerView newbasepickerview = newBasePickerView.this;
                newbasepickerview.decorView.removeView(newbasepickerview.rootView);
                newBasePickerView.this.isShowing = false;
                newBasePickerView.this.dismissing = false;
                if (newBasePickerView.this.onDismissListener != null) {
                    newBasePickerView.this.onDismissListener.onDismiss(newBasePickerView.this);
                }
            }
        });
    }

    public View findViewById(int i2) {
        return this.contentContainer.findViewById(i2);
    }

    public Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, PickerViewAnimateUtil.getAnimationResource(this.gravity, true));
    }

    public Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, PickerViewAnimateUtil.getAnimationResource(this.gravity, false));
    }

    public void init() {
        this.inAnim = getInAnimation();
        this.outAnim = getOutAnimation();
    }

    public void initEvents() {
    }

    public void initViews(int i2) {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.ykfsdk_kf_layout_basepickerview, (ViewGroup) null);
        this.dialogView = inflate;
        this.contentContainer = (ViewGroup) inflate.findViewById(R.id.content_container);
        setKeyBackCancelable(true);
    }

    public boolean isShowing() {
        return false;
    }

    public void setDialogOutSideCancelable(boolean z) {
        this.cancelable = z;
    }

    public void setKeyBackCancelable(boolean z) {
        View view = this.dialogView;
        view.setFocusable(z);
        view.setFocusableInTouchMode(z);
        if (z) {
            view.setOnKeyListener(this.onKeyBackListener);
        } else {
            view.setOnKeyListener(null);
        }
    }

    public newBasePickerView setOnDismissListener(OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
        return this;
    }

    public newBasePickerView setOutSideCancelable(boolean z) {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            View findViewById = viewGroup.findViewById(R.id.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.onCancelableTouchListener);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void show(View view, boolean z) {
        this.clickView = view;
        this.isAnim = z;
        show();
    }

    public void showDialog() {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.show();
        }
    }

    public void show(boolean z) {
        this.isAnim = z;
        show();
    }

    public void show(View view) {
        this.clickView = view;
        show();
    }

    public void show() {
        showDialog();
    }
}
