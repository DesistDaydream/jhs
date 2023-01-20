package com.m7.imkfsdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class ChatListView extends ListView implements AbsListView.OnScrollListener {
    private static final int DONE = 1;
    private static final int PULL_TO_REFRESH = 3;
    private static final int RATIO = 3;
    private static final int REFRESHING = 4;
    private static final int RELEASE_TO_REFRESH = 2;
    public static int firstItemIndex;
    private Animation cycleAnim;
    private int headContentHeight;
    private int headContentWidth;
    private LinearLayout headView;
    private boolean isBack;
    private boolean isHasHeadView;
    private boolean isRecored;
    private int lessDisPadding;
    private LessPaddingSetRunnable lessPaddingSetRunnable;
    private int moreDisPadding;
    private MorePaddingSetRunnable morePaddingSetRunnable;
    private OnRefreshListener refreshListener;
    private int refreshState;
    private int startY;

    /* loaded from: classes2.dex */
    public class LessPaddingSetRunnable implements Runnable {
        private int disP;
        private long startTime = -1;
        private int currentPadding = -1;
        private boolean canRunning = true;
        private Interpolator interpolator = new DecelerateInterpolator();

        public LessPaddingSetRunnable(int i2) {
            this.disP = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.startTime == -1) {
                this.startTime = System.currentTimeMillis();
            } else {
                this.currentPadding = this.disP - Math.round((this.disP + ChatListView.this.headContentHeight) * this.interpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / 200, 1000L), 0L)) / 1000.0f));
                ChatListView.this.headView.setPadding(0, this.currentPadding, 0, 0);
            }
            if (this.canRunning && this.currentPadding > (-ChatListView.this.headContentHeight)) {
                ChatListView.this.postDelayed(this, 16L);
            } else {
                stop();
            }
        }

        public void stop() {
            this.canRunning = false;
            ChatListView.this.removeCallbacks(this);
        }
    }

    /* loaded from: classes2.dex */
    public class MorePaddingSetRunnable implements Runnable {
        private int disP;
        private long startTime = -1;
        private int currentPadding = 1;
        private boolean canRunning = true;
        private Interpolator interpolator = new DecelerateInterpolator();

        public MorePaddingSetRunnable(int i2) {
            this.disP = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.startTime == -1) {
                this.startTime = System.currentTimeMillis();
            } else {
                this.currentPadding = this.disP - Math.round(this.disP * this.interpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / 200, 1000L), 0L)) / 1000.0f));
                ChatListView.this.headView.setPadding(0, this.currentPadding, 0, 0);
            }
            if (this.canRunning && this.currentPadding > 0) {
                ChatListView.this.postDelayed(this, 16L);
            } else {
                stop();
            }
        }

        public void stop() {
            this.canRunning = false;
            ChatListView.this.removeCallbacks(this);
        }
    }

    /* loaded from: classes2.dex */
    public interface OnRefreshListener {
        void toRefresh();
    }

    public ChatListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isRecored = false;
        this.isBack = false;
        this.isHasHeadView = true;
        init(context);
    }

    private void changeHeadView() {
        int i2 = this.refreshState;
        if (i2 != 1) {
            if (i2 != 3) {
                return;
            }
            boolean z = this.isBack;
            return;
        }
        if (this.isRecored) {
            this.isRecored = false;
        } else if (this.lessDisPadding >= 0) {
            this.lessDisPadding = 0;
        }
        this.isBack = false;
        LessPaddingSetRunnable lessPaddingSetRunnable = this.lessPaddingSetRunnable;
        if (lessPaddingSetRunnable != null) {
            lessPaddingSetRunnable.stop();
        }
        MorePaddingSetRunnable morePaddingSetRunnable = this.morePaddingSetRunnable;
        if (morePaddingSetRunnable != null) {
            morePaddingSetRunnable.stop();
        }
        LessPaddingSetRunnable lessPaddingSetRunnable2 = new LessPaddingSetRunnable(this.lessDisPadding);
        this.lessPaddingSetRunnable = lessPaddingSetRunnable2;
        post(lessPaddingSetRunnable2);
    }

    private void init(Context context) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.ykfsdk_kf_head_private_letter, (ViewGroup) null);
        this.headView = linearLayout;
        measureView(linearLayout);
        this.headContentWidth = this.headView.getMeasuredWidth();
        int measuredHeight = this.headView.getMeasuredHeight();
        this.headContentHeight = measuredHeight;
        this.headView.setPadding(0, -measuredHeight, 0, 0);
        this.headView.invalidate();
        addHeaderView(this.headView, null, false);
        setOnScrollListener(this);
        this.cycleAnim = AnimationUtils.loadAnimation(context, R.anim.ykfsdk_anim_chat_cycle);
        this.refreshState = 1;
    }

    private void measureView(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i2 = layoutParams.height;
        if (i2 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private void onRefreshing() {
        OnRefreshListener onRefreshListener = this.refreshListener;
        if (onRefreshListener != null) {
            onRefreshListener.toRefresh();
        }
    }

    public void dismiss() {
        if (this.isHasHeadView) {
            removeHeaderView(this.headView);
        }
        this.isHasHeadView = false;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void onRefreshFinished() {
        this.refreshState = 1;
        changeHeadView();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        firstItemIndex = i2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.isRecored = false;
                int i2 = this.refreshState;
                if (i2 == 3) {
                    this.refreshState = 1;
                    changeHeadView();
                } else if (i2 == 2) {
                    this.refreshState = 4;
                    changeHeadView();
                    MorePaddingSetRunnable morePaddingSetRunnable = this.morePaddingSetRunnable;
                    if (morePaddingSetRunnable != null) {
                        morePaddingSetRunnable.stop();
                    }
                    MorePaddingSetRunnable morePaddingSetRunnable2 = new MorePaddingSetRunnable(this.moreDisPadding);
                    this.morePaddingSetRunnable = morePaddingSetRunnable2;
                    post(morePaddingSetRunnable2);
                    onRefreshing();
                } else if (i2 == 4 && firstItemIndex == 0) {
                    MorePaddingSetRunnable morePaddingSetRunnable3 = this.morePaddingSetRunnable;
                    if (morePaddingSetRunnable3 != null) {
                        morePaddingSetRunnable3.stop();
                    }
                    LessPaddingSetRunnable lessPaddingSetRunnable = this.lessPaddingSetRunnable;
                    if (lessPaddingSetRunnable != null) {
                        lessPaddingSetRunnable.stop();
                    }
                    MorePaddingSetRunnable morePaddingSetRunnable4 = new MorePaddingSetRunnable(this.moreDisPadding);
                    this.morePaddingSetRunnable = morePaddingSetRunnable4;
                    post(morePaddingSetRunnable4);
                }
            } else if (action == 2) {
                int y = (int) motionEvent.getY();
                if (!this.isRecored && firstItemIndex == 0) {
                    this.isRecored = true;
                    this.startY = y;
                }
                if (this.isRecored) {
                    if (this.refreshState == 1 && y - this.startY > 0) {
                        this.refreshState = 3;
                        changeHeadView();
                    }
                    if (this.refreshState == 3) {
                        this.headView.setPadding(0, ((y - this.startY) / 3) - this.headContentHeight, 0, 0);
                        int i3 = this.startY;
                        int i4 = this.headContentHeight;
                        int i5 = ((y - i3) / 3) - i4;
                        this.lessDisPadding = i5;
                        if (i5 <= (-i4)) {
                            this.lessDisPadding = -i4;
                        }
                        if ((y - i3) / 3 >= i4) {
                            this.refreshState = 2;
                            this.isBack = true;
                            changeHeadView();
                        } else if (y - i3 <= 0) {
                            this.refreshState = 1;
                            changeHeadView();
                        }
                    }
                    if (this.refreshState == 2) {
                        this.headView.setPadding(0, ((y - this.startY) / 3) - this.headContentHeight, 0, 0);
                        int i6 = this.startY;
                        int i7 = this.headContentHeight;
                        int i8 = ((y - i6) / 3) - i7;
                        this.lessDisPadding = i8;
                        if (i8 <= (-i7)) {
                            this.lessDisPadding = -i7;
                        }
                        int i9 = ((y - i6) / 3) - i7;
                        this.moreDisPadding = i9;
                        if (i9 <= 0) {
                            this.moreDisPadding = 0;
                        }
                        if ((y - i6) / 3 < i7) {
                            this.refreshState = 3;
                            changeHeadView();
                        }
                    }
                    if (this.refreshState == 4) {
                        int i10 = this.startY;
                        if (y - i10 > 0) {
                            this.headView.setPadding(0, (y - i10) / 3, 0, 0);
                            int i11 = this.startY;
                            int i12 = (y - i11) / 3;
                            this.lessDisPadding = i12;
                            int i13 = this.headContentHeight;
                            if (i12 <= (-i13)) {
                                this.lessDisPadding = -i13;
                            }
                            int i14 = (y - i11) / 3;
                            this.moreDisPadding = i14;
                            if (i14 <= 0) {
                                this.moreDisPadding = 0;
                            }
                        }
                    }
                }
            }
        } else if (firstItemIndex == 0) {
            this.isRecored = true;
            this.startY = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.refreshListener = onRefreshListener;
    }

    public void visible() {
        if (!this.isHasHeadView) {
            addHeaderView(this.headView);
        }
        this.isHasHeadView = true;
    }
}
