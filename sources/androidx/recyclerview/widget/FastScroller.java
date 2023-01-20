package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

@VisibleForTesting
/* loaded from: classes.dex */
public class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    private static final int ANIMATION_STATE_FADING_IN = 1;
    private static final int ANIMATION_STATE_FADING_OUT = 3;
    private static final int ANIMATION_STATE_IN = 2;
    private static final int ANIMATION_STATE_OUT = 0;
    private static final int DRAG_NONE = 0;
    private static final int DRAG_X = 1;
    private static final int DRAG_Y = 2;
    private static final int HIDE_DELAY_AFTER_DRAGGING_MS = 1200;
    private static final int HIDE_DELAY_AFTER_VISIBLE_MS = 1500;
    private static final int HIDE_DURATION_MS = 500;
    private static final int SCROLLBAR_FULL_OPAQUE = 255;
    private static final int SHOW_DURATION_MS = 500;
    private static final int STATE_DRAGGING = 2;
    private static final int STATE_HIDDEN = 0;
    private static final int STATE_VISIBLE = 1;
    public int mAnimationState;
    private final Runnable mHideRunnable;
    @VisibleForTesting
    public float mHorizontalDragX;
    @VisibleForTesting
    public int mHorizontalThumbCenterX;
    private final StateListDrawable mHorizontalThumbDrawable;
    private final int mHorizontalThumbHeight;
    @VisibleForTesting
    public int mHorizontalThumbWidth;
    private final Drawable mHorizontalTrackDrawable;
    private final int mHorizontalTrackHeight;
    private final int mMargin;
    private final RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;
    private final int mScrollbarMinimumRange;
    public final ValueAnimator mShowHideAnimator;
    @VisibleForTesting
    public float mVerticalDragY;
    @VisibleForTesting
    public int mVerticalThumbCenterY;
    public final StateListDrawable mVerticalThumbDrawable;
    @VisibleForTesting
    public int mVerticalThumbHeight;
    private final int mVerticalThumbWidth;
    public final Drawable mVerticalTrackDrawable;
    private final int mVerticalTrackWidth;
    private static final int[] PRESSED_STATE_SET = {16842919};
    private static final int[] EMPTY_STATE_SET = new int[0];
    private int mRecyclerViewWidth = 0;
    private int mRecyclerViewHeight = 0;
    private boolean mNeedVerticalScrollbar = false;
    private boolean mNeedHorizontalScrollbar = false;
    private int mState = 0;
    private int mDragState = 0;
    private final int[] mVerticalRange = new int[2];
    private final int[] mHorizontalRange = new int[2];

    /* loaded from: classes.dex */
    public class AnimatorListener extends AnimatorListenerAdapter {
        private boolean mCanceled = false;

        public AnimatorListener() {
            FastScroller.this = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.mCanceled) {
                this.mCanceled = false;
            } else if (((Float) FastScroller.this.mShowHideAnimator.getAnimatedValue()).floatValue() == 0.0f) {
                FastScroller fastScroller = FastScroller.this;
                fastScroller.mAnimationState = 0;
                fastScroller.setState(0);
            } else {
                FastScroller fastScroller2 = FastScroller.this;
                fastScroller2.mAnimationState = 2;
                fastScroller2.requestRedraw();
            }
        }
    }

    /* loaded from: classes.dex */
    public class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        public AnimatorUpdater() {
            FastScroller.this = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.mVerticalThumbDrawable.setAlpha(floatValue);
            FastScroller.this.mVerticalTrackDrawable.setAlpha(floatValue);
            FastScroller.this.requestRedraw();
        }
    }

    public FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mShowHideAnimator = ofFloat;
        this.mAnimationState = 0;
        this.mHideRunnable = new Runnable() { // from class: androidx.recyclerview.widget.FastScroller.1
            {
                FastScroller.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                FastScroller.this.hide(500);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.FastScroller.2
            {
                FastScroller.this = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i5, int i6) {
                FastScroller.this.updateScrollPosition(recyclerView2.computeHorizontalScrollOffset(), recyclerView2.computeVerticalScrollOffset());
            }
        };
        this.mVerticalThumbDrawable = stateListDrawable;
        this.mVerticalTrackDrawable = drawable;
        this.mHorizontalThumbDrawable = stateListDrawable2;
        this.mHorizontalTrackDrawable = drawable2;
        this.mVerticalThumbWidth = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.mVerticalTrackWidth = Math.max(i2, drawable.getIntrinsicWidth());
        this.mHorizontalThumbHeight = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.mHorizontalTrackHeight = Math.max(i2, drawable2.getIntrinsicWidth());
        this.mScrollbarMinimumRange = i3;
        this.mMargin = i4;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new AnimatorListener());
        ofFloat.addUpdateListener(new AnimatorUpdater());
        attachToRecyclerView(recyclerView);
    }

    private void cancelHide() {
        this.mRecyclerView.removeCallbacks(this.mHideRunnable);
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this);
        this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
        cancelHide();
    }

    private void drawHorizontalScrollbar(Canvas canvas) {
        int i2 = this.mRecyclerViewHeight;
        int i3 = this.mHorizontalThumbHeight;
        int i4 = i2 - i3;
        int i5 = this.mHorizontalThumbCenterX;
        int i6 = this.mHorizontalThumbWidth;
        int i7 = i5 - (i6 / 2);
        this.mHorizontalThumbDrawable.setBounds(0, 0, i6, i3);
        this.mHorizontalTrackDrawable.setBounds(0, 0, this.mRecyclerViewWidth, this.mHorizontalTrackHeight);
        canvas.translate(0.0f, i4);
        this.mHorizontalTrackDrawable.draw(canvas);
        canvas.translate(i7, 0.0f);
        this.mHorizontalThumbDrawable.draw(canvas);
        canvas.translate(-i7, -i4);
    }

    private void drawVerticalScrollbar(Canvas canvas) {
        int i2 = this.mRecyclerViewWidth;
        int i3 = this.mVerticalThumbWidth;
        int i4 = i2 - i3;
        int i5 = this.mVerticalThumbCenterY;
        int i6 = this.mVerticalThumbHeight;
        int i7 = i5 - (i6 / 2);
        this.mVerticalThumbDrawable.setBounds(0, 0, i3, i6);
        this.mVerticalTrackDrawable.setBounds(0, 0, this.mVerticalTrackWidth, this.mRecyclerViewHeight);
        if (isLayoutRTL()) {
            this.mVerticalTrackDrawable.draw(canvas);
            canvas.translate(this.mVerticalThumbWidth, i7);
            canvas.scale(-1.0f, 1.0f);
            this.mVerticalThumbDrawable.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            canvas.translate(-this.mVerticalThumbWidth, -i7);
            return;
        }
        canvas.translate(i4, 0.0f);
        this.mVerticalTrackDrawable.draw(canvas);
        canvas.translate(0.0f, i7);
        this.mVerticalThumbDrawable.draw(canvas);
        canvas.translate(-i4, -i7);
    }

    private int[] getHorizontalRange() {
        int[] iArr = this.mHorizontalRange;
        int i2 = this.mMargin;
        iArr[0] = i2;
        iArr[1] = this.mRecyclerViewWidth - i2;
        return iArr;
    }

    private int[] getVerticalRange() {
        int[] iArr = this.mVerticalRange;
        int i2 = this.mMargin;
        iArr[0] = i2;
        iArr[1] = this.mRecyclerViewHeight - i2;
        return iArr;
    }

    private void horizontalScrollTo(float f2) {
        int[] horizontalRange = getHorizontalRange();
        float max = Math.max(horizontalRange[0], Math.min(horizontalRange[1], f2));
        if (Math.abs(this.mHorizontalThumbCenterX - max) < 2.0f) {
            return;
        }
        int scrollTo = scrollTo(this.mHorizontalDragX, max, horizontalRange, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.mRecyclerViewWidth);
        if (scrollTo != 0) {
            this.mRecyclerView.scrollBy(scrollTo, 0);
        }
        this.mHorizontalDragX = max;
    }

    private boolean isLayoutRTL() {
        return ViewCompat.getLayoutDirection(this.mRecyclerView) == 1;
    }

    private void resetHideDelay(int i2) {
        cancelHide();
        this.mRecyclerView.postDelayed(this.mHideRunnable, i2);
    }

    private int scrollTo(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / i5) * i6);
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    private void setupCallbacks() {
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this);
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
    }

    private void verticalScrollTo(float f2) {
        int[] verticalRange = getVerticalRange();
        float max = Math.max(verticalRange[0], Math.min(verticalRange[1], f2));
        if (Math.abs(this.mVerticalThumbCenterY - max) < 2.0f) {
            return;
        }
        int scrollTo = scrollTo(this.mVerticalDragY, max, verticalRange, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.mRecyclerViewHeight);
        if (scrollTo != 0) {
            this.mRecyclerView.scrollBy(0, scrollTo);
        }
        this.mVerticalDragY = max;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            setupCallbacks();
        }
    }

    @VisibleForTesting
    public Drawable getHorizontalThumbDrawable() {
        return this.mHorizontalThumbDrawable;
    }

    @VisibleForTesting
    public Drawable getHorizontalTrackDrawable() {
        return this.mHorizontalTrackDrawable;
    }

    @VisibleForTesting
    public Drawable getVerticalThumbDrawable() {
        return this.mVerticalThumbDrawable;
    }

    @VisibleForTesting
    public Drawable getVerticalTrackDrawable() {
        return this.mVerticalTrackDrawable;
    }

    @VisibleForTesting
    public void hide(int i2) {
        int i3 = this.mAnimationState;
        if (i3 == 1) {
            this.mShowHideAnimator.cancel();
        } else if (i3 != 2) {
            return;
        }
        this.mAnimationState = 3;
        ValueAnimator valueAnimator = this.mShowHideAnimator;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.mShowHideAnimator.setDuration(i2);
        this.mShowHideAnimator.start();
    }

    public boolean isDragging() {
        return this.mState == 2;
    }

    @VisibleForTesting
    public boolean isPointInsideHorizontalThumb(float f2, float f3) {
        if (f3 >= this.mRecyclerViewHeight - this.mHorizontalThumbHeight) {
            int i2 = this.mHorizontalThumbCenterX;
            int i3 = this.mHorizontalThumbWidth;
            if (f2 >= i2 - (i3 / 2) && f2 <= i2 + (i3 / 2)) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    public boolean isPointInsideVerticalThumb(float f2, float f3) {
        if (!isLayoutRTL() ? f2 >= this.mRecyclerViewWidth - this.mVerticalThumbWidth : f2 <= this.mVerticalThumbWidth) {
            int i2 = this.mVerticalThumbCenterY;
            int i3 = this.mVerticalThumbHeight;
            if (f3 >= i2 - (i3 / 2) && f3 <= i2 + (i3 / 2)) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    public boolean isVisible() {
        return this.mState == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.mRecyclerViewWidth == this.mRecyclerView.getWidth() && this.mRecyclerViewHeight == this.mRecyclerView.getHeight()) {
            if (this.mAnimationState != 0) {
                if (this.mNeedVerticalScrollbar) {
                    drawVerticalScrollbar(canvas);
                }
                if (this.mNeedHorizontalScrollbar) {
                    drawHorizontalScrollbar(canvas);
                    return;
                }
                return;
            }
            return;
        }
        this.mRecyclerViewWidth = this.mRecyclerView.getWidth();
        this.mRecyclerViewHeight = this.mRecyclerView.getHeight();
        setState(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        int i2 = this.mState;
        if (i2 == 1) {
            boolean isPointInsideVerticalThumb = isPointInsideVerticalThumb(motionEvent.getX(), motionEvent.getY());
            boolean isPointInsideHorizontalThumb = isPointInsideHorizontalThumb(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!isPointInsideVerticalThumb && !isPointInsideHorizontalThumb) {
                return false;
            }
            if (isPointInsideHorizontalThumb) {
                this.mDragState = 1;
                this.mHorizontalDragX = (int) motionEvent.getX();
            } else if (isPointInsideVerticalThumb) {
                this.mDragState = 2;
                this.mVerticalDragY = (int) motionEvent.getY();
            }
            setState(2);
        } else if (i2 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        if (this.mState == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean isPointInsideVerticalThumb = isPointInsideVerticalThumb(motionEvent.getX(), motionEvent.getY());
            boolean isPointInsideHorizontalThumb = isPointInsideHorizontalThumb(motionEvent.getX(), motionEvent.getY());
            if (isPointInsideVerticalThumb || isPointInsideHorizontalThumb) {
                if (isPointInsideHorizontalThumb) {
                    this.mDragState = 1;
                    this.mHorizontalDragX = (int) motionEvent.getX();
                } else if (isPointInsideVerticalThumb) {
                    this.mDragState = 2;
                    this.mVerticalDragY = (int) motionEvent.getY();
                }
                setState(2);
            }
        } else if (motionEvent.getAction() == 1 && this.mState == 2) {
            this.mVerticalDragY = 0.0f;
            this.mHorizontalDragX = 0.0f;
            setState(1);
            this.mDragState = 0;
        } else if (motionEvent.getAction() == 2 && this.mState == 2) {
            show();
            if (this.mDragState == 1) {
                horizontalScrollTo(motionEvent.getX());
            }
            if (this.mDragState == 2) {
                verticalScrollTo(motionEvent.getY());
            }
        }
    }

    public void requestRedraw() {
        this.mRecyclerView.invalidate();
    }

    public void setState(int i2) {
        if (i2 == 2 && this.mState != 2) {
            this.mVerticalThumbDrawable.setState(PRESSED_STATE_SET);
            cancelHide();
        }
        if (i2 == 0) {
            requestRedraw();
        } else {
            show();
        }
        if (this.mState == 2 && i2 != 2) {
            this.mVerticalThumbDrawable.setState(EMPTY_STATE_SET);
            resetHideDelay(HIDE_DELAY_AFTER_DRAGGING_MS);
        } else if (i2 == 1) {
            resetHideDelay(1500);
        }
        this.mState = i2;
    }

    public void show() {
        int i2 = this.mAnimationState;
        if (i2 != 0) {
            if (i2 != 3) {
                return;
            }
            this.mShowHideAnimator.cancel();
        }
        this.mAnimationState = 1;
        ValueAnimator valueAnimator = this.mShowHideAnimator;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.mShowHideAnimator.setDuration(500L);
        this.mShowHideAnimator.setStartDelay(0L);
        this.mShowHideAnimator.start();
    }

    public void updateScrollPosition(int i2, int i3) {
        int computeVerticalScrollRange = this.mRecyclerView.computeVerticalScrollRange();
        int i4 = this.mRecyclerViewHeight;
        this.mNeedVerticalScrollbar = computeVerticalScrollRange - i4 > 0 && i4 >= this.mScrollbarMinimumRange;
        int computeHorizontalScrollRange = this.mRecyclerView.computeHorizontalScrollRange();
        int i5 = this.mRecyclerViewWidth;
        boolean z = computeHorizontalScrollRange - i5 > 0 && i5 >= this.mScrollbarMinimumRange;
        this.mNeedHorizontalScrollbar = z;
        boolean z2 = this.mNeedVerticalScrollbar;
        if (!z2 && !z) {
            if (this.mState != 0) {
                setState(0);
                return;
            }
            return;
        }
        if (z2) {
            float f2 = i4;
            this.mVerticalThumbCenterY = (int) ((f2 * (i3 + (f2 / 2.0f))) / computeVerticalScrollRange);
            this.mVerticalThumbHeight = Math.min(i4, (i4 * i4) / computeVerticalScrollRange);
        }
        if (this.mNeedHorizontalScrollbar) {
            float f3 = i5;
            this.mHorizontalThumbCenterX = (int) ((f3 * (i2 + (f3 / 2.0f))) / computeHorizontalScrollRange);
            this.mHorizontalThumbWidth = Math.min(i5, (i5 * i5) / computeHorizontalScrollRange);
        }
        int i6 = this.mState;
        if (i6 == 0 || i6 == 1) {
            setState(1);
        }
    }
}
