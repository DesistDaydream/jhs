package com.m7.imkfsdk.view.pickerview.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.view.pickerview.listener.OnDismissListener;
import com.m7.imkfsdk.view.pickerview.utils.PickerViewAnimateUtil;

/* loaded from: classes2.dex */
public class BasePickerView {
    public ViewGroup contentContainer;
    private Context context;
    private ViewGroup decorView;
    private boolean dismissing;
    private Animation inAnim;
    private boolean isShowing;
    private OnDismissListener onDismissListener;
    private Animation outAnim;
    private ViewGroup rootView;
    private final FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -2, 80);
    private int gravity = 80;
    private final View.OnTouchListener onCancelableTouchListener = new View.OnTouchListener() { // from class: com.m7.imkfsdk.view.pickerview.view.BasePickerView.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                BasePickerView.this.dismiss();
                return false;
            }
            return false;
        }
    };

    public BasePickerView(Context context) {
        this.context = context;
        initViews();
        init();
        initEvents();
    }

    private void onAttached(View view) {
        this.decorView.addView(view);
        this.contentContainer.startAnimation(this.inAnim);
    }

    public void dismiss() {
        if (this.dismissing) {
            return;
        }
        this.dismissing = true;
        this.outAnim.setAnimationListener(new Animation.AnimationListener() { // from class: com.m7.imkfsdk.view.pickerview.view.BasePickerView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                BasePickerView.this.decorView.post(new Runnable() { // from class: com.m7.imkfsdk.view.pickerview.view.BasePickerView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BasePickerView.this.dismissImmediately();
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.contentContainer.startAnimation(this.outAnim);
    }

    public void dismissImmediately() {
        this.decorView.removeView(this.rootView);
        this.isShowing = false;
        this.dismissing = false;
        OnDismissListener onDismissListener = this.onDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
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

    public void initViews() {
        LayoutInflater from = LayoutInflater.from(this.context);
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.context).getWindow().getDecorView().findViewById(16908290);
        this.decorView = viewGroup;
        ViewGroup viewGroup2 = (ViewGroup) from.inflate(R.layout.ykfsdk_kf_layout_basepickerview, viewGroup, false);
        this.rootView = viewGroup2;
        viewGroup2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewGroup viewGroup3 = (ViewGroup) this.rootView.findViewById(R.id.content_container);
        this.contentContainer = viewGroup3;
        viewGroup3.setLayoutParams(this.params);
    }

    public boolean isShowing() {
        return this.rootView.getParent() != null || this.isShowing;
    }

    public BasePickerView setCancelable(boolean z) {
        View findViewById = this.rootView.findViewById(R.id.outmost_container);
        if (z) {
            findViewById.setOnTouchListener(this.onCancelableTouchListener);
        } else {
            findViewById.setOnTouchListener(null);
        }
        return this;
    }

    public BasePickerView setOnDismissListener(OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
        return this;
    }

    public void show() {
        if (isShowing()) {
            return;
        }
        this.isShowing = true;
        onAttached(this.rootView);
    }
}
