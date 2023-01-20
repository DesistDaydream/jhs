package com.m7.imkfsdk.view.imageviewer.helper;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import androidx.annotation.FloatRange;
import com.effective.android.panel.Constants;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class MoorDragCloseHelper {
    private static final long DURATION = 100;
    private static final int MAX_EXIT_Y = 500;
    private static final float MIN_SCALE = 0.4f;
    private View childV;
    private ClickListener clickListener;
    private DragCloseListener dragCloseListener;
    private boolean isSwipingToClose;
    private int lastPointerId;
    private LongClickRunnable longClickRunnable;
    private final Context mContext;
    private float mCurrentTranslationX;
    private float mCurrentTranslationY;
    private float mLastTranslationX;
    private float mLastTranslationY;
    private View parentV;
    private final int screenDpi;
    private final int statusBarHeight;
    private final ViewConfiguration viewConfiguration;
    private int maxExitY = 500;
    private float minScale = 0.4f;
    private float mLastY = -1.0f;
    private float mLastRawY = -1.0f;
    private float mLastX = -1.0f;
    private float mLastRawX = -1.0f;
    private boolean isResetingAnimate = false;
    private boolean isShareElementMode = false;
    private boolean isDebug = false;
    private boolean isPress = false;
    private boolean longClickPerform = false;

    /* loaded from: classes2.dex */
    public interface ClickListener {
        void onClick(View view, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface DragCloseListener {
        void dragCancel();

        void dragClose(boolean z);

        void dragStart();

        void dragging(float f2);

        boolean intercept();
    }

    /* loaded from: classes2.dex */
    public final class LongClickRunnable implements Runnable {
        private LongClickRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!MoorDragCloseHelper.this.isPress || MoorDragCloseHelper.this.clickListener == null) {
                return;
            }
            MoorDragCloseHelper.this.clickListener.onClick(MoorDragCloseHelper.this.childV, true);
            MoorDragCloseHelper.this.longClickPerform = true;
        }
    }

    public MoorDragCloseHelper(Context context) {
        this.mContext = context;
        this.viewConfiguration = ViewConfiguration.get(context);
        this.statusBarHeight = getStatusBarHeight(context);
        this.screenDpi = getDpi(context);
    }

    private void checkForLongClick() {
        this.longClickPerform = false;
        if (this.longClickRunnable == null) {
            this.longClickRunnable = new LongClickRunnable();
        }
        this.parentV.postDelayed(this.longClickRunnable, ViewConfiguration.getLongPressTimeout());
    }

    private void dealClickEvent() {
        if (this.isPress) {
            if (!this.longClickPerform) {
                this.parentV.removeCallbacks(this.longClickRunnable);
                ClickListener clickListener = this.clickListener;
                if (clickListener != null) {
                    clickListener.onClick(this.childV, false);
                }
            }
            this.isPress = false;
        }
    }

    private int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(Constants.STATUS_BAR_HEIGHT_RES_NAME, Constants.DIMEN, Constants.ANDROID);
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private boolean isInvalidTouch() {
        float f2 = this.mLastRawY;
        int i2 = this.statusBarHeight;
        return f2 < ((float) i2) || f2 > ((float) (this.screenDpi - (i2 * 2)));
    }

    private void log(String str) {
    }

    private void reset(MotionEvent motionEvent) {
        this.isSwipingToClose = false;
        this.mLastY = -1.0f;
        this.mLastX = -1.0f;
        this.mLastRawY = -1.0f;
        this.mLastRawX = -1.0f;
        this.mLastTranslationY = 0.0f;
        this.mLastTranslationX = 0.0f;
    }

    private void resetCallBackAnimation() {
        if (this.isResetingAnimate) {
            return;
        }
        float f2 = this.mCurrentTranslationY;
        if (f2 == 0.0f) {
            return;
        }
        final float f3 = this.mCurrentTranslationX / f2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.m7.imkfsdk.view.imageviewer.helper.MoorDragCloseHelper.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (MoorDragCloseHelper.this.isResetingAnimate) {
                    MoorDragCloseHelper.this.mCurrentTranslationY = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    MoorDragCloseHelper moorDragCloseHelper = MoorDragCloseHelper.this;
                    moorDragCloseHelper.mCurrentTranslationX = f3 * moorDragCloseHelper.mCurrentTranslationY;
                    MoorDragCloseHelper moorDragCloseHelper2 = MoorDragCloseHelper.this;
                    moorDragCloseHelper2.mLastTranslationY = moorDragCloseHelper2.mCurrentTranslationY;
                    MoorDragCloseHelper moorDragCloseHelper3 = MoorDragCloseHelper.this;
                    moorDragCloseHelper3.mLastTranslationX = moorDragCloseHelper3.mCurrentTranslationX;
                    MoorDragCloseHelper moorDragCloseHelper4 = MoorDragCloseHelper.this;
                    moorDragCloseHelper4.updateChildView(moorDragCloseHelper4.mLastTranslationX, MoorDragCloseHelper.this.mCurrentTranslationY);
                }
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.m7.imkfsdk.view.imageviewer.helper.MoorDragCloseHelper.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (MoorDragCloseHelper.this.isResetingAnimate) {
                    MoorDragCloseHelper.this.parentV.getBackground().mutate().setAlpha(255);
                    MoorDragCloseHelper.this.mCurrentTranslationY = 0.0f;
                    MoorDragCloseHelper.this.mCurrentTranslationX = 0.0f;
                    MoorDragCloseHelper.this.isResetingAnimate = false;
                    if (MoorDragCloseHelper.this.dragCloseListener != null) {
                        MoorDragCloseHelper.this.dragCloseListener.dragCancel();
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                MoorDragCloseHelper.this.isResetingAnimate = true;
            }
        });
        ofFloat.setDuration(100L).start();
    }

    private void resetClickEvent() {
        this.parentV.removeCallbacks(this.longClickRunnable);
        this.isPress = false;
        this.longClickPerform = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChildView(float f2, float f3) {
        float abs = 1.0f - Math.abs(f3 / this.childV.getHeight());
        float f4 = this.minScale;
        if (abs < f4) {
            abs = f4;
        }
        if (f3 > 0.0f) {
            View view = this.childV;
            view.setTranslationY(f3 - (((view.getHeight() - this.maxExitY) * (1.0f - abs)) / 2.0f));
        } else {
            View view2 = this.childV;
            view2.setTranslationY(f3 + (((view2.getHeight() - this.maxExitY) * (1.0f - abs)) / 2.0f));
        }
        this.childV.setTranslationX(f2);
        this.childV.setScaleX(abs);
        this.childV.setScaleY(abs);
    }

    public void exitWithTranslation(float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.mCurrentTranslationY, f2 > 0.0f ? this.childV.getHeight() : -this.childV.getHeight());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.m7.imkfsdk.view.imageviewer.helper.MoorDragCloseHelper.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MoorDragCloseHelper moorDragCloseHelper = MoorDragCloseHelper.this;
                moorDragCloseHelper.updateChildView(moorDragCloseHelper.mCurrentTranslationX, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.m7.imkfsdk.view.imageviewer.helper.MoorDragCloseHelper.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (MoorDragCloseHelper.this.dragCloseListener != null) {
                    MoorDragCloseHelper.this.dragCloseListener.dragClose(false);
                }
                ((Activity) MoorDragCloseHelper.this.mContext).finish();
                ((Activity) MoorDragCloseHelper.this.mContext).overridePendingTransition(R.anim.ykfsdk_dchlib_anim_empty, R.anim.ykfsdk_dchlib_anim_alpha_out_long_time);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat.setDuration(100L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.start();
    }

    public int getDpi(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public boolean handleEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            if (this.isSwipingToClose) {
                this.isSwipingToClose = false;
                resetCallBackAnimation();
                return true;
            }
            reset(motionEvent);
            resetClickEvent();
            return false;
        }
        DragCloseListener dragCloseListener = this.dragCloseListener;
        if (dragCloseListener != null && dragCloseListener.intercept()) {
            log("action dispatch--->");
            if (this.clickListener != null) {
                if (motionEvent.getAction() == 0) {
                    this.isPress = true;
                    checkForLongClick();
                } else if (motionEvent.getAction() == 1) {
                    dealClickEvent();
                } else if (motionEvent.getAction() == 3) {
                    resetClickEvent();
                }
            }
            this.isSwipingToClose = false;
            return false;
        }
        if (motionEvent.getAction() == 0) {
            log("action down--->");
            reset(motionEvent);
            this.mLastY = motionEvent.getY();
            this.mLastX = motionEvent.getX();
            this.mLastRawY = motionEvent.getRawY();
            this.mLastRawX = motionEvent.getRawX();
            if (isInvalidTouch()) {
                return true;
            }
            this.isPress = true;
            checkForLongClick();
            this.lastPointerId = motionEvent.getPointerId(0);
        } else if (motionEvent.getAction() == 2) {
            log("action move--->" + this.isSwipingToClose + "---" + this.mLastRawY + "---" + isInvalidTouch());
            if (isInvalidTouch() || this.mLastRawY == -1.0f) {
                return true;
            }
            if (this.lastPointerId != motionEvent.getPointerId(0)) {
                if (this.isSwipingToClose) {
                    resetCallBackAnimation();
                }
                reset(motionEvent);
                return true;
            }
            float y = motionEvent.getY();
            float x = motionEvent.getX();
            if (this.isSwipingToClose || (Math.abs(y - this.mLastY) > this.viewConfiguration.getScaledTouchSlop() * 2 && Math.abs(y - this.mLastY) > Math.abs(x - this.mLastX) * 1.5d)) {
                this.mLastY = y;
                this.mLastX = x;
                log("action move---> start close");
                resetClickEvent();
                float rawY = motionEvent.getRawY();
                float rawX = motionEvent.getRawX();
                if (!this.isSwipingToClose) {
                    this.isSwipingToClose = true;
                    DragCloseListener dragCloseListener2 = this.dragCloseListener;
                    if (dragCloseListener2 != null) {
                        dragCloseListener2.dragStart();
                    }
                }
                float f2 = (rawY - this.mLastRawY) + this.mLastTranslationY;
                this.mCurrentTranslationY = f2;
                this.mCurrentTranslationX = (rawX - this.mLastRawX) + this.mLastTranslationX;
                float abs = 1.0f - Math.abs(f2 / this.childV.getHeight());
                if (abs > 1.0f) {
                    abs = 1.0f;
                } else if (abs < 0.0f) {
                    abs = 0.0f;
                }
                this.parentV.getBackground().mutate().setAlpha((int) (255.0f * abs));
                DragCloseListener dragCloseListener3 = this.dragCloseListener;
                if (dragCloseListener3 != null) {
                    dragCloseListener3.dragging(abs);
                }
                float f3 = this.minScale;
                if (abs < f3) {
                    abs = f3;
                }
                float f4 = this.mCurrentTranslationY;
                if (f4 > 0.0f) {
                    View view = this.childV;
                    view.setTranslationY(f4 - (((view.getHeight() - this.maxExitY) * (1.0f - abs)) / 2.0f));
                } else {
                    View view2 = this.childV;
                    view2.setTranslationY(f4 + (((view2.getHeight() - this.maxExitY) * (1.0f - abs)) / 2.0f));
                }
                this.childV.setTranslationX(this.mCurrentTranslationX);
                this.childV.setScaleX(abs);
                this.childV.setScaleY(abs);
                return true;
            }
        } else if (motionEvent.getAction() == 1) {
            log("action up--->" + this.isSwipingToClose);
            if (isInvalidTouch()) {
                return true;
            }
            this.mLastRawY = -1.0f;
            dealClickEvent();
            if (this.isSwipingToClose) {
                float f5 = this.mCurrentTranslationY;
                if (f5 > this.maxExitY) {
                    if (this.isShareElementMode) {
                        DragCloseListener dragCloseListener4 = this.dragCloseListener;
                        if (dragCloseListener4 != null) {
                            dragCloseListener4.dragClose(true);
                        }
                    } else {
                        exitWithTranslation(f5);
                    }
                } else {
                    resetCallBackAnimation();
                }
                this.isSwipingToClose = false;
                return true;
            }
        } else if (motionEvent.getAction() == 3) {
            resetClickEvent();
            this.mLastRawY = -1.0f;
            if (this.isSwipingToClose) {
                resetCallBackAnimation();
                this.isSwipingToClose = false;
                return true;
            }
        }
        return false;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setDebug(boolean z) {
        this.isDebug = z;
    }

    public void setDragCloseListener(DragCloseListener dragCloseListener) {
        this.dragCloseListener = dragCloseListener;
    }

    public void setDragCloseViews(View view, View view2) {
        this.parentV = view;
        this.childV = view2;
    }

    public void setMaxExitY(int i2) {
        this.maxExitY = i2;
    }

    public void setMinScale(@FloatRange(from = 0.10000000149011612d, to = 1.0d) float f2) {
        this.minScale = f2;
    }

    public void setShareElementMode(boolean z) {
        this.isShareElementMode = z;
    }
}
