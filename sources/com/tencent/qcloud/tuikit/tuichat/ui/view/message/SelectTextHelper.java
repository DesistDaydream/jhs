package com.tencent.qcloud.tuikit.tuichat.ui.view.message;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.URLSpan;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Magnifier;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.effective.android.panel.Constants;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class SelectTextHelper {
    private static int DEFAULT_SELECTION_LENGTH = 2;
    private static int DEFAULT_SHOW_DURATION = 100;
    private static int STATUS_HEIGHT = 0;
    private static final String TAG = "SelectTextHelper";
    private boolean isHideWhenScroll;
    private List<Builder.onSeparateItemClickListener> itemListenerList;
    private List<Pair<Integer, String>> itemTextList;
    private Context mContext;
    private int mCursorHandleColor;
    private int mCursorHandleSize;
    private CursorHandle mEndHandle;
    private boolean mIsEmoji;
    private Magnifier mMagnifier;
    private boolean mMagnifierShow;
    private ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    private ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener;
    private int mPopArrowImg;
    private int mPopBgResource;
    private int mPopSpanCount;
    private View.OnTouchListener mRootTouchListener;
    private boolean mScrollShow;
    private boolean mSelectAll;
    private OnSelectListener mSelectListener;
    private boolean mSelectedAllNoPop;
    private int mSelectedColor;
    private BackgroundColorSpan mSpan;
    private Spannable mSpannable;
    private CursorHandle mStartHandle;
    private TextView mTextView;
    private int mTouchX;
    private int mTouchY;
    private SelectionInfo mSelectionInfo = new SelectionInfo();
    private int mTextViewMarginStart = 0;
    private boolean isHide = true;
    private boolean usedClickListener = false;
    private final Runnable mShowSelectViewRunnable = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.5
        @Override // java.lang.Runnable
        public void run() {
            if (SelectTextHelper.this.isHide) {
                return;
            }
            if (SelectTextHelper.this.mStartHandle != null) {
                SelectTextHelper selectTextHelper = SelectTextHelper.this;
                selectTextHelper.showCursorHandle(selectTextHelper.mStartHandle);
            }
            if (SelectTextHelper.this.mEndHandle != null) {
                SelectTextHelper selectTextHelper2 = SelectTextHelper.this;
                selectTextHelper2.showCursorHandle(selectTextHelper2.mEndHandle);
            }
        }
    };

    /* loaded from: classes3.dex */
    public class CursorHandle extends View {
        private boolean isLeft;
        private int mAdjustX;
        private int mAdjustY;
        private int mBeforeDragEnd;
        private int mBeforeDragStart;
        private int mCircleRadius;
        private int mHeight;
        private int mPadding;
        private Paint mPaint;
        private PopupWindow mPopupWindow;
        private int[] mTempCoors;
        private int mWidth;

        public CursorHandle(boolean z) {
            super(SelectTextHelper.this.mContext);
            this.mCircleRadius = SelectTextHelper.this.mCursorHandleSize / 2;
            this.mWidth = SelectTextHelper.this.mCursorHandleSize;
            this.mHeight = SelectTextHelper.this.mCursorHandleSize;
            this.mPadding = 32;
            this.mTempCoors = new int[2];
            this.isLeft = z;
            Paint paint = new Paint(1);
            this.mPaint = paint;
            paint.setColor(SelectTextHelper.this.mCursorHandleColor);
            PopupWindow popupWindow = new PopupWindow(this);
            this.mPopupWindow = popupWindow;
            popupWindow.setClippingEnabled(false);
            this.mPopupWindow.setWidth(this.mWidth + (this.mPadding * 2));
            this.mPopupWindow.setHeight(this.mHeight + (this.mPadding / 2));
            invalidate();
        }

        private void changeDirection() {
            this.isLeft = !this.isLeft;
            invalidate();
        }

        private void updateCursorHandle() {
            SelectTextHelper.this.mTextView.getLocationInWindow(this.mTempCoors);
            Layout layout = SelectTextHelper.this.mTextView.getLayout();
            if (this.isLeft) {
                this.mPopupWindow.update((((int) layout.getPrimaryHorizontal(SelectTextHelper.this.mSelectionInfo.mStart)) - this.mWidth) + getExtraX(), layout.getLineBottom(layout.getLineForOffset(SelectTextHelper.this.mSelectionInfo.mStart)) + getExtraY(), -1, -1);
            } else {
                this.mPopupWindow.update(((int) layout.getPrimaryHorizontal(SelectTextHelper.this.mSelectionInfo.mEnd)) + getExtraX(), layout.getLineBottom(layout.getLineForOffset(SelectTextHelper.this.mSelectionInfo.mEnd)) + getExtraY(), -1, -1);
            }
        }

        public void dismiss() {
            this.mPopupWindow.dismiss();
        }

        public int getExtraX() {
            return (this.mTempCoors[0] - this.mPadding) + SelectTextHelper.this.mTextView.getPaddingLeft();
        }

        public int getExtraY() {
            return this.mTempCoors[1] + SelectTextHelper.this.mTextView.getPaddingTop();
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            int i2 = this.mCircleRadius;
            canvas.drawCircle(this.mPadding + i2, i2, i2, this.mPaint);
            if (this.isLeft) {
                int i3 = this.mCircleRadius;
                int i4 = this.mPadding;
                canvas.drawRect(i3 + i4, 0.0f, (i3 * 2) + i4, i3, this.mPaint);
                return;
            }
            int i5 = this.mPadding;
            int i6 = this.mCircleRadius;
            canvas.drawRect(i5, 0.0f, i5 + i6, i6, this.mPaint);
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r1 != 3) goto L9;
         */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouchEvent(android.view.MotionEvent r9) {
            /*
                r8 = this;
                int r0 = android.os.Build.VERSION.SDK_INT
                int r1 = r9.getAction()
                r2 = 1
                if (r1 == 0) goto Lc2
                r3 = 28
                if (r1 == r2) goto La6
                r4 = 2
                if (r1 == r4) goto L15
                r9 = 3
                if (r1 == r9) goto La6
                goto Le4
            L15:
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper r1 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.this
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper$OnSelectListener r1 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.access$2700(r1)
                if (r1 == 0) goto L26
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper r1 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.this
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper$OnSelectListener r1 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.access$2700(r1)
                r1.onDismissCustomPop()
            L26:
                float r1 = r9.getRawX()
                int r1 = (int) r1
                float r9 = r9.getRawY()
                int r9 = (int) r9
                int r5 = r8.mAdjustX
                int r5 = r5 + r1
                int r6 = r8.mWidth
                int r5 = r5 - r6
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper r6 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.this
                int r6 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.access$2800(r6)
                int r5 = r5 - r6
                int r6 = r8.mAdjustY
                int r6 = r6 + r9
                int r7 = r8.mHeight
                int r6 = r6 - r7
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper r7 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.this
                android.widget.TextView r7 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.access$2900(r7)
                float r7 = r7.getTextSize()
                int r7 = (int) r7
                int r6 = r6 - r7
                r8.update(r5, r6)
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper r5 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.this
                boolean r5 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.access$2500(r5)
                if (r5 == 0) goto Le4
                if (r0 < r3) goto Le4
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper r0 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.this
                android.widget.Magnifier r0 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.access$2600(r0)
                if (r0 != 0) goto L7d
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper r0 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.this
                android.widget.Magnifier r3 = new android.widget.Magnifier
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper r5 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.this
                android.widget.TextView r5 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.access$2900(r5)
                r3.<init>(r5)
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.access$2602(r0, r3)
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper r0 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.this
                android.widget.Magnifier r0 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.access$2600(r0)
                r0.getWidth()
            L7d:
                int[] r0 = new int[r4]
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper r3 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.this
                android.widget.TextView r3 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.access$2900(r3)
                r3.getLocationOnScreen(r0)
                r3 = 0
                r4 = r0[r3]
                int r1 = r1 - r4
                r0 = r0[r2]
                int r9 = r9 - r0
                r0 = 1107296256(0x42000000, float:32.0)
                int r0 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.dp2px(r0)
                int r9 = r9 - r0
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper r0 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.this
                android.widget.Magnifier r0 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.access$2600(r0)
                float r1 = (float) r1
                int r9 = java.lang.Math.max(r9, r3)
                float r9 = (float) r9
                r0.show(r1, r9)
                goto Le4
            La6:
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper r9 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.this
                boolean r9 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.access$2500(r9)
                if (r9 == 0) goto Le4
                if (r0 < r3) goto Le4
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper r9 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.this
                android.widget.Magnifier r9 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.access$2600(r9)
                if (r9 == 0) goto Le4
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper r9 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.this
                android.widget.Magnifier r9 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.access$2600(r9)
                r9.dismiss()
                goto Le4
            Lc2:
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper r0 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.this
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper$SelectionInfo r0 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.access$2400(r0)
                int r0 = r0.mStart
                r8.mBeforeDragStart = r0
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper r0 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.this
                com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper$SelectionInfo r0 = com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.access$2400(r0)
                int r0 = r0.mEnd
                r8.mBeforeDragEnd = r0
                float r0 = r9.getX()
                int r0 = (int) r0
                r8.mAdjustX = r0
                float r9 = r9.getY()
                int r9 = (int) r9
                r8.mAdjustY = r9
            Le4:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.CursorHandle.onTouchEvent(android.view.MotionEvent):boolean");
        }

        public void show(int i2, int i3) {
            SelectTextHelper.this.mTextView.getLocationInWindow(this.mTempCoors);
            this.mPopupWindow.showAtLocation(SelectTextHelper.this.mTextView, 0, (i2 - (this.isLeft ? this.mWidth : 0)) + getExtraX(), i3 + getExtraY());
        }

        public void update(int i2, int i3) {
            SelectTextHelper.this.mTextView.getLocationInWindow(this.mTempCoors);
            int i4 = this.isLeft ? SelectTextHelper.this.mSelectionInfo.mStart : SelectTextHelper.this.mSelectionInfo.mEnd;
            int hysteresisOffset = SelectTextHelper.getHysteresisOffset(SelectTextHelper.this.mTextView, i2, i3 - this.mTempCoors[1], i4);
            if (hysteresisOffset != i4) {
                SelectTextHelper.this.resetSelectionInfo();
                if (this.isLeft) {
                    if (hysteresisOffset > this.mBeforeDragEnd) {
                        CursorHandle cursorHandle = SelectTextHelper.this.getCursorHandle(false);
                        changeDirection();
                        cursorHandle.changeDirection();
                        int i5 = this.mBeforeDragEnd;
                        this.mBeforeDragStart = i5;
                        SelectTextHelper.this.selectText(i5, hysteresisOffset);
                        cursorHandle.updateCursorHandle();
                    } else {
                        SelectTextHelper.this.selectText(hysteresisOffset, -1);
                    }
                    updateCursorHandle();
                    return;
                }
                int i6 = this.mBeforeDragStart;
                if (hysteresisOffset < i6) {
                    CursorHandle cursorHandle2 = SelectTextHelper.this.getCursorHandle(true);
                    cursorHandle2.changeDirection();
                    changeDirection();
                    int i7 = this.mBeforeDragStart;
                    this.mBeforeDragEnd = i7;
                    SelectTextHelper.this.selectText(hysteresisOffset, i7);
                    cursorHandle2.updateCursorHandle();
                } else {
                    SelectTextHelper.this.selectText(i6, hysteresisOffset);
                }
                updateCursorHandle();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class LinkMovementMethodInterceptor extends LinkMovementMethod {
        private long downLinkTime;

        private LinkMovementMethodInterceptor() {
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 0) {
                int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
                int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
                int scrollX = x + textView.getScrollX();
                int scrollY = y + textView.getScrollY();
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                Object[] objArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (objArr.length != 0) {
                    if (action == 1) {
                        if (this.downLinkTime + ViewConfiguration.getLongPressTimeout() < System.currentTimeMillis()) {
                            return false;
                        }
                        if (objArr[0] instanceof URLSpan) {
                            URLSpan uRLSpan = (URLSpan) objArr[0];
                            if (!TextUtils.isEmpty(uRLSpan.getURL())) {
                                if (SelectTextHelper.this.mSelectListener != null) {
                                    SelectTextHelper.this.usedClickListener = true;
                                    SelectTextHelper.this.mSelectListener.onClickUrl(uRLSpan.getURL());
                                }
                                return true;
                            }
                            objArr[0].onClick(textView);
                        }
                    } else if (action == 0) {
                        this.downLinkTime = System.currentTimeMillis();
                        Selection.setSelection(spannable, spannable.getSpanStart(objArr[0]), spannable.getSpanEnd(objArr[0]));
                    }
                    return true;
                }
                Selection.removeSelection(spannable);
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
    }

    /* loaded from: classes3.dex */
    public interface OnSelectListener {
        void onClick(View view);

        void onClickUrl(String str);

        void onDismiss();

        void onDismissCustomPop();

        void onLongClick(View view);

        void onReset();

        void onScrolling();

        void onSelectAllShowCustomPop();

        void onTextSelected(CharSequence charSequence);
    }

    /* loaded from: classes3.dex */
    public class SelectionInfo {
        public int mEnd;
        public String mSelectionContent;
        public int mStart;

        private SelectionInfo() {
        }
    }

    public SelectTextHelper(Builder builder) {
        this.mIsEmoji = false;
        this.itemListenerList = new LinkedList();
        TextView textView = builder.mTextView;
        this.mTextView = textView;
        this.mContext = textView.getContext();
        this.mSelectedColor = builder.mSelectedColor;
        this.mCursorHandleColor = builder.mCursorHandleColor;
        this.mSelectAll = builder.mSelectAll;
        this.mIsEmoji = builder.mIsEmoji;
        this.mScrollShow = builder.mScrollShow;
        this.mMagnifierShow = builder.mMagnifierShow;
        this.mPopSpanCount = builder.mPopSpanCount;
        this.mPopBgResource = builder.mPopBgResource;
        this.mPopArrowImg = builder.mPopArrowImg;
        this.mSelectedAllNoPop = builder.mSelectedAllNoPop;
        this.itemTextList = builder.itemTextList;
        this.itemListenerList = builder.itemListenerList;
        this.mCursorHandleSize = dp2px(builder.mCursorHandleSizeInDp);
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean b(View view, MotionEvent motionEvent) {
        this.mTouchX = (int) motionEvent.getX();
        this.mTouchY = (int) motionEvent.getY();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(View view) {
        if (this.usedClickListener) {
            this.usedClickListener = false;
            return;
        }
        OnSelectListener onSelectListener = this.mSelectListener;
        if (onSelectListener != null) {
            onSelectListener.onDismiss();
        }
        reset();
        OnSelectListener onSelectListener2 = this.mSelectListener;
        if (onSelectListener2 != null) {
            onSelectListener2.onClick(this.mTextView);
        }
    }

    public static int dp2px(float f2) {
        return (int) ((f2 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ boolean f(View view) {
        this.mTextView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                SelectTextHelper.this.destroy();
            }
        });
        this.mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.2
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (SelectTextHelper.this.isHideWhenScroll) {
                    SelectTextHelper.this.isHideWhenScroll = false;
                    SelectTextHelper.this.postShowSelectView(SelectTextHelper.DEFAULT_SHOW_DURATION);
                }
                if (SelectTextHelper.this.mTextViewMarginStart == 0) {
                    int[] iArr = new int[2];
                    SelectTextHelper.this.mTextView.getLocationInWindow(iArr);
                    SelectTextHelper.this.mTextViewMarginStart = iArr[0];
                    return true;
                }
                return true;
            }
        };
        this.mTextView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        this.mRootTouchListener = new View.OnTouchListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                SelectTextHelper.this.reset();
                SelectTextHelper.this.mTextView.getRootView().setOnTouchListener(null);
                return false;
            }
        };
        this.mTextView.getRootView().setOnTouchListener(this.mRootTouchListener);
        this.mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.4
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (SelectTextHelper.this.mScrollShow) {
                    if (!SelectTextHelper.this.isHideWhenScroll && !SelectTextHelper.this.isHide) {
                        SelectTextHelper.this.isHideWhenScroll = true;
                        if (SelectTextHelper.this.mStartHandle != null) {
                            SelectTextHelper.this.mStartHandle.dismiss();
                        }
                        if (SelectTextHelper.this.mEndHandle != null) {
                            SelectTextHelper.this.mEndHandle.dismiss();
                        }
                    }
                    if (SelectTextHelper.this.mSelectListener != null) {
                        SelectTextHelper.this.mSelectListener.onScrolling();
                        return;
                    }
                    return;
                }
                SelectTextHelper.this.reset();
            }
        };
        this.mTextView.getViewTreeObserver().addOnScrollChangedListener(this.mOnScrollChangedListener);
        if (this.mSelectAll) {
            showAllView();
        } else {
            showSelectView(this.mTouchX, this.mTouchY);
        }
        OnSelectListener onSelectListener = this.mSelectListener;
        if (onSelectListener != null) {
            onSelectListener.onLongClick(this.mTextView);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CursorHandle getCursorHandle(boolean z) {
        if (this.mStartHandle.isLeft == z) {
            return this.mStartHandle;
        }
        return this.mEndHandle;
    }

    public static int getDisplayHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int getDisplayWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getHysteresisOffset(TextView textView, int i2, int i3, int i4) {
        Layout layout = textView.getLayout();
        if (layout == null) {
            return -1;
        }
        int lineForVertical = layout.getLineForVertical(i3);
        if (isEndOfLineOffset(layout, i4)) {
            int lineRight = (int) layout.getLineRight(lineForVertical);
            if (i2 > lineRight - ((lineRight - ((int) layout.getPrimaryHorizontal(i4 - 1))) / 2)) {
                i4--;
            }
        }
        int lineForOffset = layout.getLineForOffset(i4);
        int lineTop = layout.getLineTop(lineForOffset);
        int lineBottom = layout.getLineBottom(lineForOffset);
        int i5 = (lineBottom - lineTop) / 2;
        if ((lineForVertical == lineForOffset + 1 && i3 - lineBottom < i5) || (lineForVertical == lineForOffset - 1 && lineTop - i3 < i5)) {
            lineForVertical = lineForOffset;
        }
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, i2);
        if (offsetForHorizontal < textView.getText().length() - 1) {
            int i6 = offsetForHorizontal + 1;
            if (isEndOfLineOffset(layout, i6)) {
                int lineRight2 = (int) layout.getLineRight(lineForVertical);
                return i2 > lineRight2 - ((lineRight2 - ((int) layout.getPrimaryHorizontal(offsetForHorizontal))) / 2) ? i6 : offsetForHorizontal;
            }
            return offsetForHorizontal;
        }
        return offsetForHorizontal;
    }

    public static int getPreciseOffset(TextView textView, int i2, int i3) {
        Layout layout = textView.getLayout();
        if (layout != null) {
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(i3), i2);
            return ((int) layout.getPrimaryHorizontal(offsetForHorizontal)) > i2 ? layout.getOffsetToLeftOf(offsetForHorizontal) : offsetForHorizontal;
        }
        return -1;
    }

    public static int getStatusHeight() {
        int i2 = STATUS_HEIGHT;
        if (i2 != 0) {
            return i2;
        }
        int identifier = Resources.getSystem().getIdentifier(Constants.STATUS_BAR_HEIGHT_RES_NAME, Constants.DIMEN, Constants.ANDROID);
        if (identifier > 0) {
            int dimensionPixelSize = Resources.getSystem().getDimensionPixelSize(identifier);
            STATUS_HEIGHT = dimensionPixelSize;
            return dimensionPixelSize;
        }
        return -1;
    }

    private void handlerEmojiSelectText() {
        Matcher matcher = Pattern.compile("\\[(\\S+?)\\]").matcher(this.mSelectionInfo.mSelectionContent);
        while (matcher.find()) {
            Bitmap emoji = FaceManager.getEmoji(matcher.group());
            if (emoji != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(emoji);
                ShapeDrawable shapeDrawable = new ShapeDrawable();
                shapeDrawable.getPaint().setColor(this.mTextView.getContext().getResources().getColor(R.color.text_select_color));
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, bitmapDrawable});
                layerDrawable.setBounds(0, 0, 64, 64);
                ImageSpan imageSpan = new ImageSpan(layerDrawable, 1);
                Spannable spannable = this.mSpannable;
                SelectionInfo selectionInfo = this.mSelectionInfo;
                spannable.setSpan(imageSpan, selectionInfo.mStart, selectionInfo.mEnd, 17);
            }
        }
    }

    private void hideSelectView() {
        this.isHide = true;
        this.usedClickListener = false;
        if (this.mStartHandle != null) {
            TUIChatLog.d(TAG, "mStartHandle.dismiss();");
            this.mStartHandle.dismiss();
        }
        if (this.mEndHandle != null) {
            TUIChatLog.d(TAG, "mEndHandle.dismiss();");
            this.mEndHandle.dismiss();
        }
    }

    private void init() {
        TextView textView = this.mTextView;
        textView.setText(textView.getText(), TextView.BufferType.SPANNABLE);
        this.mTextView.setOnTouchListener(new View.OnTouchListener() { // from class: e.s.a.b.a.b.b.b.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return SelectTextHelper.this.b(view, motionEvent);
            }
        });
        this.mTextView.setOnClickListener(new View.OnClickListener() { // from class: e.s.a.b.a.b.b.b.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectTextHelper.this.d(view);
            }
        });
        this.mTextView.setOnLongClickListener(new View.OnLongClickListener() { // from class: e.s.a.b.a.b.b.b.g
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return SelectTextHelper.this.f(view);
            }
        });
        this.mTextView.setMovementMethod(new LinkMovementMethodInterceptor());
    }

    private static boolean isEndOfLineOffset(Layout layout, int i2) {
        return i2 > 0 && layout.getLineForOffset(i2) == layout.getLineForOffset(i2 - 1) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postShowSelectView(int i2) {
        this.mTextView.removeCallbacks(this.mShowSelectViewRunnable);
        if (i2 <= 0) {
            this.mShowSelectViewRunnable.run();
        } else {
            this.mTextView.postDelayed(this.mShowSelectViewRunnable, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetSelectionInfo() {
        this.mSelectionInfo.mSelectionContent = null;
        if (this.mSpannable == null || this.mSpan == null) {
            return;
        }
        TUIChatLog.d(TAG, "mSpannable.removeSpan(mSpan);");
        this.mSpannable.removeSpan(this.mSpan);
        this.mSpan = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectText(int i2, int i3) {
        if (i2 != -1) {
            this.mSelectionInfo.mStart = i2;
        }
        if (i3 != -1) {
            this.mSelectionInfo.mEnd = i3;
        }
        SelectionInfo selectionInfo = this.mSelectionInfo;
        int i4 = selectionInfo.mStart;
        int i5 = selectionInfo.mEnd;
        if (i4 > i5) {
            selectionInfo.mStart = i5;
            selectionInfo.mEnd = i4;
        }
        if (this.mSpannable != null) {
            if (this.mSpan == null) {
                this.mSpan = new BackgroundColorSpan(this.mSelectedColor);
            }
            SelectionInfo selectionInfo2 = this.mSelectionInfo;
            selectionInfo2.mSelectionContent = this.mSpannable.subSequence(selectionInfo2.mStart, selectionInfo2.mEnd).toString();
            Spannable spannable = this.mSpannable;
            BackgroundColorSpan backgroundColorSpan = this.mSpan;
            SelectionInfo selectionInfo3 = this.mSelectionInfo;
            spannable.setSpan(backgroundColorSpan, selectionInfo3.mStart, selectionInfo3.mEnd, 17);
            OnSelectListener onSelectListener = this.mSelectListener;
            if (onSelectListener != null) {
                onSelectListener.onTextSelected(this.mSelectionInfo.mSelectionContent);
            }
        }
    }

    public static void setWidthHeight(View view, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i3;
        view.setLayoutParams(layoutParams);
    }

    private void showAllView() {
        reset();
        this.isHide = false;
        if (this.mStartHandle == null) {
            this.mStartHandle = new CursorHandle(true);
        }
        if (this.mEndHandle == null) {
            this.mEndHandle = new CursorHandle(false);
        }
        if (this.mTextView.getText() instanceof Spannable) {
            this.mSpannable = (Spannable) this.mTextView.getText();
        }
        if (this.mSpannable == null) {
            return;
        }
        selectText(0, this.mTextView.getText().length());
        showCursorHandle(this.mStartHandle);
        showCursorHandle(this.mEndHandle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCursorHandle(CursorHandle cursorHandle) {
        Layout layout = this.mTextView.getLayout();
        if (layout == null) {
            return;
        }
        int i2 = cursorHandle.isLeft ? this.mSelectionInfo.mStart : this.mSelectionInfo.mEnd;
        cursorHandle.show((int) layout.getPrimaryHorizontal(i2), layout.getLineBottom(layout.getLineForOffset(i2)));
    }

    private void showSelectView(int i2, int i3) {
        reset();
        this.isHide = false;
        if (this.mStartHandle == null) {
            this.mStartHandle = new CursorHandle(true);
        }
        if (this.mEndHandle == null) {
            this.mEndHandle = new CursorHandle(false);
        }
        int preciseOffset = getPreciseOffset(this.mTextView, i2, i3);
        int i4 = DEFAULT_SELECTION_LENGTH + preciseOffset;
        if (this.mTextView.getText() instanceof Spannable) {
            this.mSpannable = (Spannable) this.mTextView.getText();
        }
        if (this.mSpannable == null || i4 - 1 >= this.mTextView.getText().length()) {
            return;
        }
        selectText(preciseOffset, i4);
        showCursorHandle(this.mStartHandle);
        showCursorHandle(this.mEndHandle);
    }

    public void destroy() {
        this.mTextView.getViewTreeObserver().removeOnScrollChangedListener(this.mOnScrollChangedListener);
        this.mTextView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        this.mTextView.getRootView().setOnTouchListener(null);
        reset();
        this.mStartHandle = null;
        this.mEndHandle = null;
    }

    public void reset() {
        TUIChatLog.d(TAG, "reset");
        hideSelectView();
        resetSelectionInfo();
        OnSelectListener onSelectListener = this.mSelectListener;
        if (onSelectListener != null) {
            onSelectListener.onReset();
        }
    }

    public void selectAll() {
        hideSelectView();
        selectText(0, this.mTextView.getText().length());
        this.isHide = false;
        showCursorHandle(this.mStartHandle);
        showCursorHandle(this.mEndHandle);
    }

    public void setSelectListener(OnSelectListener onSelectListener) {
        this.mSelectListener = onSelectListener;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private TextView mTextView;
        private int mCursorHandleColor = -15500842;
        private int mSelectedColor = -5250572;
        private float mCursorHandleSizeInDp = 24.0f;
        private boolean mSelectAll = true;
        private boolean mSelectedAllNoPop = false;
        private boolean mScrollShow = true;
        private boolean mMagnifierShow = true;
        private int mPopSpanCount = 5;
        private int mPopBgResource = 0;
        private int mPopArrowImg = 0;
        private boolean mIsEmoji = false;
        private List<Pair<Integer, String>> itemTextList = new LinkedList();
        private List<onSeparateItemClickListener> itemListenerList = new LinkedList();

        /* loaded from: classes3.dex */
        public interface onSeparateItemClickListener {
            void onClick();
        }

        public Builder(TextView textView) {
            this.mTextView = textView;
        }

        public Builder addItem(@DrawableRes int i2, @StringRes int i3, onSeparateItemClickListener onseparateitemclicklistener) {
            this.itemTextList.add(new Pair<>(Integer.valueOf(i2), this.mTextView.getContext().getResources().getString(i3)));
            this.itemListenerList.add(onseparateitemclicklistener);
            return this;
        }

        public SelectTextHelper build() {
            return new SelectTextHelper(this);
        }

        public Builder setCursorHandleColor(@ColorInt int i2) {
            this.mCursorHandleColor = i2;
            return this;
        }

        public Builder setCursorHandleSizeInDp(float f2) {
            this.mCursorHandleSizeInDp = f2;
            return this;
        }

        public Builder setIsEmoji(boolean z) {
            this.mIsEmoji = z;
            return this;
        }

        public Builder setMagnifierShow(boolean z) {
            this.mMagnifierShow = z;
            return this;
        }

        public Builder setPopSpanCount(int i2) {
            this.mPopSpanCount = i2;
            return this;
        }

        public Builder setPopStyle(int i2, int i3) {
            this.mPopBgResource = i2;
            this.mPopArrowImg = i3;
            return this;
        }

        public Builder setScrollShow(boolean z) {
            this.mScrollShow = z;
            return this;
        }

        public Builder setSelectAll(boolean z) {
            this.mSelectAll = z;
            return this;
        }

        public Builder setSelectedAllNoPop(boolean z) {
            this.mSelectedAllNoPop = z;
            return this;
        }

        public Builder setSelectedColor(@ColorInt int i2) {
            this.mSelectedColor = i2;
            return this;
        }

        public Builder addItem(@DrawableRes int i2, String str, onSeparateItemClickListener onseparateitemclicklistener) {
            this.itemTextList.add(new Pair<>(Integer.valueOf(i2), str));
            this.itemListenerList.add(onseparateitemclicklistener);
            return this;
        }
    }
}
