package com.m7.imkfsdk.view.imageviewer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.view.imageviewer.photoview.MoorPhotoView;

/* loaded from: classes2.dex */
public class MoorFingerDragHelper extends LinearLayout {
    private static final long DURATION = 200;
    private static final int MAX_EXIT_Y = 500;
    private static final int MAX_TRANSLATE_Y = 500;
    private static final String TAG = MoorFingerDragHelper.class.getSimpleName();
    private final int fadeIn;
    private final int fadeOut;
    private MoorPhotoView imageGif;
    private MoorSubsamplingScaleImageViewDragClose imageView;
    private boolean isAnimate;
    private float mDownY;
    private float mLastTranslationY;
    private onAlphaChangedListener mOnAlphaChangedListener;
    private int mTouchslop;
    private float mTranslationY;

    /* loaded from: classes2.dex */
    public interface onAlphaChangedListener {
        void onTranslationYChanged(MotionEvent motionEvent, float f2);
    }

    public MoorFingerDragHelper(Context context) {
        this(context, null);
    }

    private void initViews() {
        this.mTouchslop = ViewConfiguration.getTouchSlop();
    }

    private void onActionUp() {
        if (MoorImagePreview.getInstance().isEnableUpDragClose()) {
            if (Math.abs(this.mTranslationY) > 500.0f) {
                exitWithTranslation(this.mTranslationY);
                return;
            } else {
                resetCallBackAnimation();
                return;
            }
        }
        float f2 = this.mTranslationY;
        if (f2 > 500.0f) {
            exitWithTranslation(f2);
        } else {
            resetCallBackAnimation();
        }
    }

    private void onOneFingerPanActionMove(MotionEvent motionEvent) {
        float rawY = (motionEvent.getRawY() - this.mDownY) + this.mLastTranslationY;
        this.mTranslationY = rawY;
        onAlphaChangedListener onalphachangedlistener = this.mOnAlphaChangedListener;
        if (onalphachangedlistener != null) {
            onalphachangedlistener.onTranslationYChanged(motionEvent, rawY);
        }
        MoorViewHelper.setScrollY(this, -((int) this.mTranslationY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        onAlphaChangedListener onalphachangedlistener = this.mOnAlphaChangedListener;
        if (onalphachangedlistener != null) {
            onalphachangedlistener.onTranslationYChanged(null, this.mTranslationY);
        }
    }

    private void resetCallBackAnimation() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.mTranslationY, 0.0f);
        ofFloat.setDuration(DURATION);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.m7.imkfsdk.view.imageviewer.MoorFingerDragHelper.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (MoorFingerDragHelper.this.isAnimate) {
                    MoorFingerDragHelper.this.mTranslationY = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    MoorFingerDragHelper moorFingerDragHelper = MoorFingerDragHelper.this;
                    moorFingerDragHelper.mLastTranslationY = moorFingerDragHelper.mTranslationY;
                    MoorFingerDragHelper moorFingerDragHelper2 = MoorFingerDragHelper.this;
                    MoorViewHelper.setScrollY(moorFingerDragHelper2, -((int) moorFingerDragHelper2.mTranslationY));
                }
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.m7.imkfsdk.view.imageviewer.MoorFingerDragHelper.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (MoorFingerDragHelper.this.isAnimate) {
                    MoorFingerDragHelper.this.mTranslationY = 0.0f;
                    MoorFingerDragHelper.this.invalidate();
                    MoorFingerDragHelper.this.reset();
                }
                MoorFingerDragHelper.this.isAnimate = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                MoorFingerDragHelper.this.isAnimate = true;
            }
        });
        ofFloat.start();
    }

    public void exitWithTranslation(float f2) {
        if (f2 > 0.0f) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.mTranslationY, getHeight());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.m7.imkfsdk.view.imageviewer.MoorFingerDragHelper.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MoorViewHelper.setScrollY(MoorFingerDragHelper.this, -((int) ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                }
            });
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.m7.imkfsdk.view.imageviewer.MoorFingerDragHelper.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    MoorFingerDragHelper.this.reset();
                    Activity activity = (Activity) MoorFingerDragHelper.this.getContext();
                    activity.finish();
                    activity.overridePendingTransition(MoorFingerDragHelper.this.fadeIn, MoorFingerDragHelper.this.fadeOut);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            ofFloat.setDuration(DURATION);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.start();
            return;
        }
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(this.mTranslationY, -getHeight());
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.m7.imkfsdk.view.imageviewer.MoorFingerDragHelper.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MoorViewHelper.setScrollY(MoorFingerDragHelper.this, -((int) ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            }
        });
        ofFloat2.addListener(new Animator.AnimatorListener() { // from class: com.m7.imkfsdk.view.imageviewer.MoorFingerDragHelper.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MoorFingerDragHelper.this.reset();
                ((Activity) MoorFingerDragHelper.this.getContext()).finish();
                ((Activity) MoorFingerDragHelper.this.getContext()).overridePendingTransition(MoorFingerDragHelper.this.fadeIn, MoorFingerDragHelper.this.fadeOut);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat2.setDuration(DURATION);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.start();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.imageView = (MoorSubsamplingScaleImageViewDragClose) getChildAt(0);
        this.imageGif = (MoorPhotoView) getChildAt(1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & motionEvent.getActionMasked();
        if (action == 0) {
            this.mDownY = motionEvent.getRawY();
        } else if (action != 2) {
            return false;
        }
        if (MoorImagePreview.getInstance().isEnableDragClose()) {
            MoorPhotoView moorPhotoView = this.imageGif;
            if (moorPhotoView != null && moorPhotoView.getVisibility() == 0) {
                if (this.imageGif.getScale() > this.imageGif.getMinimumScale() + 0.001f) {
                    return false;
                }
                if ((this.imageGif.getMaxTouchCount() != 0 && this.imageGif.getMaxTouchCount() != 1) || Math.abs(motionEvent.getRawY() - this.mDownY) <= this.mTouchslop * 2) {
                    return false;
                }
            } else {
                MoorSubsamplingScaleImageViewDragClose moorSubsamplingScaleImageViewDragClose = this.imageView;
                if (moorSubsamplingScaleImageViewDragClose == null || moorSubsamplingScaleImageViewDragClose.getVisibility() != 0) {
                    return false;
                }
                if (MoorImagePreview.getInstance().isEnableDragCloseIgnoreScale()) {
                    if (this.imageView.getScale() > this.imageView.getMinScale() + 0.001f && !this.imageView.atYEdge) {
                        return false;
                    }
                    if ((this.imageView.getMaxTouchCount() != 0 && this.imageView.getMaxTouchCount() != 1) || Math.abs(motionEvent.getRawY() - this.mDownY) <= this.mTouchslop * 2) {
                        return false;
                    }
                } else if (this.imageView.getScale() > this.imageView.getMinScale() + 0.001f) {
                    return false;
                } else {
                    if ((this.imageView.getMaxTouchCount() != 0 && this.imageView.getMaxTouchCount() != 1) || Math.abs(motionEvent.getRawY() - this.mDownY) <= this.mTouchslop * 2 || !this.imageView.atYEdge) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r0 != 2) goto L18;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            int r1 = r4.getActionMasked()
            r0 = r0 & r1
            r1 = 1
            if (r0 == 0) goto L16
            if (r0 == r1) goto L12
            r2 = 2
            if (r0 == r2) goto L1c
            goto L41
        L12:
            r3.onActionUp()
            goto L41
        L16:
            float r0 = r4.getRawY()
            r3.mDownY = r0
        L1c:
            com.m7.imkfsdk.view.imageviewer.MoorImagePreview r0 = com.m7.imkfsdk.view.imageviewer.MoorImagePreview.getInstance()
            boolean r0 = r0.isEnableDragClose()
            if (r0 == 0) goto L41
            com.m7.imkfsdk.view.imageviewer.photoview.MoorPhotoView r0 = r3.imageGif
            if (r0 == 0) goto L34
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L34
            r3.onOneFingerPanActionMove(r4)
            goto L41
        L34:
            com.m7.imkfsdk.view.imageviewer.MoorSubsamplingScaleImageViewDragClose r0 = r3.imageView
            if (r0 == 0) goto L41
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L41
            r3.onOneFingerPanActionMove(r4)
        L41:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m7.imkfsdk.view.imageviewer.MoorFingerDragHelper.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnAlphaChangeListener(onAlphaChangedListener onalphachangedlistener) {
        this.mOnAlphaChangedListener = onalphachangedlistener;
    }

    public MoorFingerDragHelper(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MoorFingerDragHelper(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.isAnimate = false;
        this.fadeIn = R.anim.ykfsdk_drag_fade_in_150;
        this.fadeOut = R.anim.ykfsdk_drag_fade_out_150;
        initViews();
    }
}
