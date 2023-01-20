package com.tencent.qcloud.tuicore.component;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.List;

/* loaded from: classes3.dex */
public class PopupList {
    public static final int DEFAULT_BACKGROUND_RADIUS_DP = 8;
    public static final int DEFAULT_DIVIDER_COLOR = -1694498817;
    public static final float DEFAULT_DIVIDER_HEIGHT_DP = 40.0f;
    public static final float DEFAULT_DIVIDER_WIDTH_DP = 0.5f;
    public static final int DEFAULT_NORMAL_BACKGROUND_COLOR = -872415232;
    public static final int DEFAULT_NORMAL_TEXT_COLOR = -1;
    public static final int DEFAULT_PRESSED_BACKGROUND_COLOR = -411601033;
    public static final int DEFAULT_PRESSED_TEXT_COLOR = -1;
    public static final float DEFAULT_TEXT_PADDING_BOTTOM_DP = 5.0f;
    public static final float DEFAULT_TEXT_PADDING_LEFT_DP = 10.0f;
    public static final float DEFAULT_TEXT_PADDING_RIGHT_DP = 10.0f;
    public static final float DEFAULT_TEXT_PADDING_TOP_DP = 5.0f;
    public static final float DEFAULT_TEXT_SIZE_DP = 14.0f;
    private View mAdapterView;
    private View mAnchorView;
    private Context mContext;
    private int mContextPosition;
    private View mContextView;
    private GradientDrawable mCornerBackground;
    private StateListDrawable mCornerItemBackground;
    private int mIndicatorHeight;
    private View mIndicatorView;
    private int mIndicatorWidth;
    private StateListDrawable mLeftItemBackground;
    private float mOffsetX;
    private float mOffsetY;
    private List<String> mPopupItemList;
    private PopupListListener mPopupListListener;
    private PopupWindow mPopupWindow;
    private int mPopupWindowHeight;
    private int mPopupWindowWidth;
    private StateListDrawable mRightItemBackground;
    private ColorStateList mTextColorStateList;
    private int mNormalTextColor = -1;
    private int mPressedTextColor = -1;
    private float mTextSize = dp2px(14.0f);
    private int mTextPaddingLeft = dp2px(10.0f);
    private int mTextPaddingTop = dp2px(5.0f);
    private int mTextPaddingRight = dp2px(10.0f);
    private int mTextPaddingBottom = dp2px(5.0f);
    private int mNormalBackgroundColor = DEFAULT_NORMAL_BACKGROUND_COLOR;
    private int mPressedBackgroundColor = DEFAULT_PRESSED_BACKGROUND_COLOR;
    private int mBackgroundCornerRadius = dp2px(8.0f);
    private int mDividerColor = DEFAULT_DIVIDER_COLOR;
    private int mDividerWidth = dp2px(0.5f);
    private int mDividerHeight = dp2px(40.0f);

    /* loaded from: classes3.dex */
    public interface AdapterPopupListListener extends PopupListListener {
        String formatText(View view, View view2, int i2, int i3, String str);
    }

    /* loaded from: classes3.dex */
    public interface PopupListListener {
        void onPopupListClick(View view, int i2, int i3);

        boolean showPopupList(View view, View view2, int i2);
    }

    public PopupList(Context context) {
        this.mContext = context;
        this.mIndicatorView = getDefaultIndicatorView(this.mContext);
        refreshBackgroundOrRadiusStateList();
        refreshTextColorStateList(this.mPressedTextColor, this.mNormalTextColor);
    }

    private StateListDrawable getCenterItemBackground() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.mPressedBackgroundColor);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(0);
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable);
        stateListDrawable.addState(new int[0], gradientDrawable2);
        return stateListDrawable;
    }

    private int getViewHeight(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    private int getViewWidth(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredWidth();
    }

    private void refreshBackgroundOrRadiusStateList() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.mPressedBackgroundColor);
        int i2 = this.mBackgroundCornerRadius;
        gradientDrawable.setCornerRadii(new float[]{i2, i2, 0.0f, 0.0f, 0.0f, 0.0f, i2, i2});
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(0);
        int i3 = this.mBackgroundCornerRadius;
        gradientDrawable2.setCornerRadii(new float[]{i3, i3, 0.0f, 0.0f, 0.0f, 0.0f, i3, i3});
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.mLeftItemBackground = stateListDrawable;
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable);
        this.mLeftItemBackground.addState(new int[0], gradientDrawable2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(this.mPressedBackgroundColor);
        int i4 = this.mBackgroundCornerRadius;
        gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, i4, i4, i4, i4, 0.0f, 0.0f});
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setColor(0);
        int i5 = this.mBackgroundCornerRadius;
        gradientDrawable4.setCornerRadii(new float[]{0.0f, 0.0f, i5, i5, i5, i5, 0.0f, 0.0f});
        StateListDrawable stateListDrawable2 = new StateListDrawable();
        this.mRightItemBackground = stateListDrawable2;
        stateListDrawable2.addState(new int[]{16842919}, gradientDrawable3);
        this.mRightItemBackground.addState(new int[0], gradientDrawable4);
        GradientDrawable gradientDrawable5 = new GradientDrawable();
        gradientDrawable5.setColor(this.mPressedBackgroundColor);
        gradientDrawable5.setCornerRadius(this.mBackgroundCornerRadius);
        GradientDrawable gradientDrawable6 = new GradientDrawable();
        gradientDrawable6.setColor(0);
        gradientDrawable6.setCornerRadius(this.mBackgroundCornerRadius);
        StateListDrawable stateListDrawable3 = new StateListDrawable();
        this.mCornerItemBackground = stateListDrawable3;
        stateListDrawable3.addState(new int[]{16842919}, gradientDrawable5);
        this.mCornerItemBackground.addState(new int[0], gradientDrawable6);
        GradientDrawable gradientDrawable7 = new GradientDrawable();
        this.mCornerBackground = gradientDrawable7;
        gradientDrawable7.setColor(this.mNormalBackgroundColor);
        this.mCornerBackground.setCornerRadius(this.mBackgroundCornerRadius);
    }

    private void refreshTextColorStateList(int i2, int i3) {
        this.mTextColorStateList = new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{i2, i3});
    }

    public int dp2px(float f2) {
        return (int) TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }

    public int getBackgroundCornerRadius() {
        return this.mBackgroundCornerRadius;
    }

    public View getDefaultIndicatorView(Context context) {
        return getTriangleIndicatorView(context, dp2px(16.0f), dp2px(8.0f), DEFAULT_NORMAL_BACKGROUND_COLOR);
    }

    public int getDividerColor() {
        return this.mDividerColor;
    }

    public int getDividerHeight() {
        return this.mDividerHeight;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public View getIndicatorView() {
        return this.mIndicatorView;
    }

    public int getNormalBackgroundColor() {
        return this.mNormalBackgroundColor;
    }

    public int getNormalTextColor() {
        return this.mNormalTextColor;
    }

    public int getPressedBackgroundColor() {
        return this.mPressedBackgroundColor;
    }

    public int getPressedTextColor() {
        return this.mPressedTextColor;
    }

    public Resources getResources() {
        Context context = this.mContext;
        if (context == null) {
            return Resources.getSystem();
        }
        return context.getResources();
    }

    public int getTextPaddingBottom() {
        return this.mTextPaddingBottom;
    }

    public int getTextPaddingLeft() {
        return this.mTextPaddingLeft;
    }

    public int getTextPaddingRight() {
        return this.mTextPaddingRight;
    }

    public int getTextPaddingTop() {
        return this.mTextPaddingTop;
    }

    public float getTextSize() {
        return this.mTextSize;
    }

    public View getTriangleIndicatorView(Context context, final float f2, final float f3, final int i2) {
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(new Drawable() { // from class: com.tencent.qcloud.tuicore.component.PopupList.2
            @Override // android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Path path = new Path();
                Paint paint = new Paint();
                paint.setColor(i2);
                paint.setStyle(Paint.Style.FILL);
                path.moveTo(0.0f, 0.0f);
                path.lineTo(f2, 0.0f);
                path.lineTo(f2 / 2.0f, f3);
                path.close();
                canvas.drawPath(path, paint);
            }

            @Override // android.graphics.drawable.Drawable
            public int getIntrinsicHeight() {
                return (int) f3;
            }

            @Override // android.graphics.drawable.Drawable
            public int getIntrinsicWidth() {
                return (int) f2;
            }

            @Override // android.graphics.drawable.Drawable
            public int getOpacity() {
                return -3;
            }

            @Override // android.graphics.drawable.Drawable
            public void setAlpha(int i3) {
            }

            @Override // android.graphics.drawable.Drawable
            public void setColorFilter(ColorFilter colorFilter) {
            }
        });
        return imageView;
    }

    public void hidePopupListWindow() {
        PopupWindow popupWindow;
        Context context = this.mContext;
        if (((context instanceof Activity) && ((Activity) context).isFinishing()) || (popupWindow = this.mPopupWindow) == null || !popupWindow.isShowing()) {
            return;
        }
        this.mPopupWindow.dismiss();
    }

    public void setBackgroundCornerRadius(int i2) {
        this.mBackgroundCornerRadius = i2;
        refreshBackgroundOrRadiusStateList();
    }

    public void setDividerColor(int i2) {
        this.mDividerColor = i2;
    }

    public void setDividerHeight(int i2) {
        this.mDividerHeight = i2;
    }

    public void setDividerWidth(int i2) {
        this.mDividerWidth = i2;
    }

    public void setIndicatorSize(int i2, int i3) {
        this.mIndicatorWidth = i2;
        this.mIndicatorHeight = i3;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mIndicatorWidth, this.mIndicatorHeight);
        layoutParams.gravity = 17;
        View view = this.mIndicatorView;
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
    }

    public void setIndicatorView(View view) {
        this.mIndicatorView = view;
    }

    public void setNormalBackgroundColor(int i2) {
        this.mNormalBackgroundColor = i2;
        refreshBackgroundOrRadiusStateList();
    }

    public void setNormalTextColor(int i2) {
        this.mNormalTextColor = i2;
        refreshTextColorStateList(this.mPressedTextColor, i2);
    }

    public void setPressedBackgroundColor(int i2) {
        this.mPressedBackgroundColor = i2;
        refreshBackgroundOrRadiusStateList();
    }

    public void setPressedTextColor(int i2) {
        this.mPressedTextColor = i2;
        refreshTextColorStateList(i2, this.mNormalTextColor);
    }

    public void setTextPadding(int i2, int i3, int i4, int i5) {
        this.mTextPaddingLeft = i2;
        this.mTextPaddingTop = i3;
        this.mTextPaddingRight = i4;
        this.mTextPaddingBottom = i5;
    }

    public void setTextPaddingBottom(int i2) {
        this.mTextPaddingBottom = i2;
    }

    public void setTextPaddingLeft(int i2) {
        this.mTextPaddingLeft = i2;
    }

    public void setTextPaddingRight(int i2) {
        this.mTextPaddingRight = i2;
    }

    public void setTextPaddingTop(int i2) {
        this.mTextPaddingTop = i2;
    }

    public void setTextSize(float f2) {
        this.mTextSize = f2;
    }

    public void show(View view, List<String> list, PopupListListener popupListListener) {
        this.mAnchorView = view;
        this.mPopupItemList = list;
        this.mPopupListListener = popupListListener;
        this.mPopupWindow = null;
        this.mOffsetX = view.getX() + (view.getWidth() / 2);
        this.mOffsetY = view.getY();
        PopupListListener popupListListener2 = this.mPopupListListener;
        if (popupListListener2 == null || popupListListener2.showPopupList(view, view, 0)) {
            this.mContextView = view;
            this.mContextPosition = 0;
            showPopupListWindow(this.mOffsetX, this.mOffsetY);
        }
    }

    public void showPopupListWindow(View view, int i2, float f2, float f3, List<String> list, PopupListListener popupListListener) {
        this.mAnchorView = view;
        this.mContextPosition = i2;
        this.mPopupItemList = list;
        this.mPopupListListener = popupListListener;
        this.mPopupWindow = null;
        this.mContextView = view;
        if (popupListListener == null || popupListListener.showPopupList(view, view, i2)) {
            int[] iArr = new int[2];
            this.mAnchorView.getLocationOnScreen(iArr);
            showPopupListWindow(f2 - iArr[0], f3 - iArr[1]);
        }
    }

    public int sp2px(float f2) {
        return (int) TypedValue.applyDimension(2, f2, getResources().getDisplayMetrics());
    }

    private void showPopupListWindow(float f2, float f3) {
        LinearLayout.LayoutParams layoutParams;
        int[] iArr;
        Context context = this.mContext;
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        if (this.mPopupWindow == null || (this.mPopupListListener instanceof AdapterPopupListListener)) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            linearLayout.setOrientation(1);
            LinearLayout linearLayout2 = new LinearLayout(this.mContext);
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            linearLayout2.setOrientation(0);
            linearLayout2.setBackgroundDrawable(this.mCornerBackground);
            linearLayout.addView(linearLayout2);
            View view = this.mIndicatorView;
            if (view != null) {
                if (view.getLayoutParams() == null) {
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                } else {
                    layoutParams = (LinearLayout.LayoutParams) this.mIndicatorView.getLayoutParams();
                }
                layoutParams.gravity = 17;
                this.mIndicatorView.setLayoutParams(layoutParams);
                ViewParent parent = this.mIndicatorView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.mIndicatorView);
                }
                linearLayout.addView(this.mIndicatorView);
            }
            for (final int i2 = 0; i2 < this.mPopupItemList.size(); i2++) {
                TextView textView = new TextView(this.mContext);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, this.mDividerHeight);
                layoutParams2.gravity = 17;
                textView.setLayoutParams(layoutParams2);
                textView.setTextColor(this.mTextColorStateList);
                textView.setGravity(16);
                textView.setTextSize(0, this.mTextSize);
                textView.setPadding(this.mTextPaddingLeft, this.mTextPaddingTop, this.mTextPaddingRight, this.mTextPaddingBottom);
                textView.setClickable(true);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuicore.component.PopupList.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (PopupList.this.mPopupListListener != null) {
                            PopupList.this.mPopupListListener.onPopupListClick(PopupList.this.mContextView, PopupList.this.mContextPosition, i2);
                            PopupList.this.hidePopupListWindow();
                        }
                    }
                });
                PopupListListener popupListListener = this.mPopupListListener;
                if (popupListListener instanceof AdapterPopupListListener) {
                    textView.setText(((AdapterPopupListListener) popupListListener).formatText(this.mAdapterView, this.mContextView, this.mContextPosition, i2, this.mPopupItemList.get(i2)));
                } else {
                    textView.setText(this.mPopupItemList.get(i2));
                }
                if (this.mPopupItemList.size() > 1 && i2 == 0) {
                    textView.setBackgroundDrawable(this.mLeftItemBackground);
                } else if (this.mPopupItemList.size() > 1 && i2 == this.mPopupItemList.size() - 1) {
                    textView.setBackgroundDrawable(this.mRightItemBackground);
                } else if (this.mPopupItemList.size() == 1) {
                    textView.setBackgroundDrawable(this.mCornerItemBackground);
                } else {
                    textView.setBackgroundDrawable(getCenterItemBackground());
                }
                linearLayout2.addView(textView);
                if (this.mPopupItemList.size() > 1 && i2 != this.mPopupItemList.size() - 1) {
                    View view2 = new View(this.mContext);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.mDividerWidth, this.mDividerHeight);
                    layoutParams3.gravity = 17;
                    view2.setLayoutParams(layoutParams3);
                    view2.setBackgroundColor(this.mDividerColor);
                    linearLayout2.addView(view2);
                }
            }
            if (this.mPopupWindowWidth == 0) {
                this.mPopupWindowWidth = getViewWidth(linearLayout2);
            }
            View view3 = this.mIndicatorView;
            if (view3 != null && this.mIndicatorWidth == 0) {
                if (view3.getLayoutParams().width > 0) {
                    this.mIndicatorWidth = this.mIndicatorView.getLayoutParams().width;
                } else {
                    this.mIndicatorWidth = getViewWidth(this.mIndicatorView);
                }
            }
            View view4 = this.mIndicatorView;
            if (view4 != null && this.mIndicatorHeight == 0) {
                if (view4.getLayoutParams().height > 0) {
                    this.mIndicatorHeight = this.mIndicatorView.getLayoutParams().height;
                } else {
                    this.mIndicatorHeight = getViewHeight(this.mIndicatorView);
                }
            }
            if (this.mPopupWindowHeight == 0) {
                this.mPopupWindowHeight = getViewHeight(linearLayout2) + this.mIndicatorHeight;
            }
            PopupWindow popupWindow = new PopupWindow((View) linearLayout, this.mPopupWindowWidth, this.mPopupWindowHeight, false);
            this.mPopupWindow = popupWindow;
            popupWindow.setTouchable(true);
            this.mPopupWindow.setOutsideTouchable(true);
            this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        }
        this.mAnchorView.getLocationOnScreen(new int[2]);
        if (this.mIndicatorView != null) {
            int i3 = this.mIndicatorWidth;
            int i4 = this.mBackgroundCornerRadius;
            int i5 = this.mPopupWindowWidth;
            float f4 = ((i3 / 2.0f) + i4) - (i5 / 2.0f);
            float f5 = ((i5 / 2.0f) - (i3 / 2.0f)) - i4;
            float f6 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            int i6 = this.mPopupWindowWidth;
            if (iArr[0] + f2 < i6 / 2.0f) {
                this.mIndicatorView.setTranslationX(Math.max((iArr[0] + f2) - (i6 / 2.0f), f4));
            } else if (iArr[0] + f2 + (i6 / 2.0f) > f6) {
                this.mIndicatorView.setTranslationX(Math.min(((iArr[0] + f2) + (i6 / 2.0f)) - f6, f5));
            } else {
                this.mIndicatorView.setTranslationX(0.0f);
            }
        }
        if (this.mPopupWindow.isShowing()) {
            return;
        }
        this.mPopupWindow.showAtLocation(this.mAnchorView, 0, (int) (((iArr[0] + f2) - (this.mPopupWindowWidth / 2.0f)) + 0.5f), (int) (((iArr[1] + f3) - this.mPopupWindowHeight) + 0.5f));
    }
}
