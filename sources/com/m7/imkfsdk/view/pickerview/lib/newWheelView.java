package com.m7.imkfsdk.view.pickerview.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.material.timepicker.TimeModel;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.view.pickerview.adapter.WheelAdapter;
import com.m7.imkfsdk.view.pickerview.listener.OnItemSelectedListener;
import com.m7.imkfsdk.view.pickerview.model.IPickerViewData;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class newWheelView extends View {
    private static final float SCALECONTENT = 0.8f;
    private static final int VELOCITYFLING = 5;
    private float CENTERCONTENTOFFSET;
    public WheelAdapter adapter;
    public float centerY;
    public int change;
    public Context context;
    public int dividerColor;
    private DividerType dividerType;
    private int drawCenterContentStart;
    private int drawOutContentStart;
    public float firstLineY;
    private GestureDetector gestureDetector;
    public int halfCircumference;
    public Handler handler;
    public int initPosition;
    private boolean isCenterLabel;
    public boolean isLoop;
    private boolean isOptions;
    public float itemHeight;
    public int itemsVisible;
    private String label;
    public float lineSpacingMultiplier;
    public ScheduledExecutorService mExecutor;
    private ScheduledFuture<?> mFuture;
    private int mGravity;
    private int mOffset;
    public int maxTextHeight;
    public int maxTextWidth;
    public int measuredHeight;
    public int measuredWidth;
    public OnItemSelectedListener onItemSelectedListener;
    public Paint paintCenterText;
    public Paint paintIndicator;
    public Paint paintOuterText;
    public int preCurrentIndex;
    private float previousY;
    public int radius;
    public float secondLineY;
    private int selectedItem;
    public long startTime;
    public int textColorCenter;
    public int textColorOut;
    public int textSize;
    public float totalScrollY;
    public Typeface typeface;
    public int widthMeasureSpec;

    /* loaded from: classes2.dex */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    /* loaded from: classes2.dex */
    public enum DividerType {
        FILL,
        WRAP
    }

    public newWheelView(Context context) {
        this(context, null);
    }

    private String getContentText(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPickerViewData) {
            return ((IPickerViewData) obj).getPickerViewText();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private int getLoopMappingIndex(int i2) {
        if (i2 < 0) {
            return getLoopMappingIndex(i2 + this.adapter.getItemsCount());
        }
        return i2 > this.adapter.getItemsCount() + (-1) ? getLoopMappingIndex(i2 - this.adapter.getItemsCount()) : i2;
    }

    private void initLoopView(Context context) {
        this.context = context;
        this.handler = new newMessageHandler(this);
        GestureDetector gestureDetector = new GestureDetector(context, new newLoopViewGestureListener(this));
        this.gestureDetector = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.isLoop = true;
        this.totalScrollY = 0.0f;
        this.initPosition = -1;
        initPaints();
    }

    private void initPaints() {
        Paint paint = new Paint();
        this.paintOuterText = paint;
        paint.setColor(this.textColorOut);
        this.paintOuterText.setAntiAlias(true);
        this.paintOuterText.setTypeface(this.typeface);
        this.paintOuterText.setTextSize(this.textSize);
        Paint paint2 = new Paint();
        this.paintCenterText = paint2;
        paint2.setColor(this.textColorCenter);
        this.paintCenterText.setAntiAlias(true);
        this.paintCenterText.setTextScaleX(1.1f);
        this.paintCenterText.setTypeface(this.typeface);
        this.paintCenterText.setTextSize(this.textSize);
        Paint paint3 = new Paint();
        this.paintIndicator = paint3;
        paint3.setColor(this.dividerColor);
        this.paintIndicator.setAntiAlias(true);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    private void judgeLineSpae() {
        float f2 = this.lineSpacingMultiplier;
        if (f2 < 1.2f) {
            this.lineSpacingMultiplier = 1.2f;
        } else if (f2 > 2.0f) {
            this.lineSpacingMultiplier = 2.0f;
        }
    }

    private void measureTextWidthHeight() {
        Rect rect = new Rect();
        for (int i2 = 0; i2 < this.adapter.getItemsCount(); i2++) {
            String contentText = getContentText(this.adapter.getItem(i2));
            this.paintCenterText.getTextBounds(contentText, 0, contentText.length(), rect);
            int width = rect.width();
            if (width > this.maxTextWidth) {
                this.maxTextWidth = width;
            }
            this.paintCenterText.getTextBounds("星期", 0, 2, rect);
            this.maxTextHeight = rect.height() + 2;
        }
        this.itemHeight = this.lineSpacingMultiplier * this.maxTextHeight;
    }

    private void measuredCenterContentStart(String str) {
        String str2;
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.mGravity;
        if (i2 == 3) {
            this.drawCenterContentStart = 0;
        } else if (i2 == 5) {
            this.drawCenterContentStart = (this.measuredWidth - rect.width()) - ((int) this.CENTERCONTENTOFFSET);
        } else if (i2 != 17) {
        } else {
            if (!this.isOptions && (str2 = this.label) != null && !str2.equals("") && this.isCenterLabel) {
                this.drawCenterContentStart = (int) ((this.measuredWidth - rect.width()) * 0.25d);
            } else {
                this.drawCenterContentStart = (int) ((this.measuredWidth - rect.width()) * 0.5d);
            }
        }
    }

    private void measuredOutContentStart(String str) {
        String str2;
        Rect rect = new Rect();
        this.paintOuterText.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.mGravity;
        if (i2 == 3) {
            this.drawOutContentStart = 0;
        } else if (i2 == 5) {
            this.drawOutContentStart = (this.measuredWidth - rect.width()) - ((int) this.CENTERCONTENTOFFSET);
        } else if (i2 != 17) {
        } else {
            if (!this.isOptions && (str2 = this.label) != null && !str2.equals("") && this.isCenterLabel) {
                this.drawOutContentStart = (int) ((this.measuredWidth - rect.width()) * 0.25d);
            } else {
                this.drawOutContentStart = (int) ((this.measuredWidth - rect.width()) * 0.5d);
            }
        }
    }

    private void reMeasureTextSize(String str) {
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.textSize;
        for (int width = rect.width(); width > this.measuredWidth; width = rect.width()) {
            i2--;
            this.paintCenterText.setTextSize(i2);
            this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        }
        this.paintOuterText.setTextSize(i2);
    }

    private void remeasure() {
        if (this.adapter == null) {
            return;
        }
        measureTextWidthHeight();
        int i2 = (int) (this.itemHeight * (this.itemsVisible - 1));
        this.halfCircumference = i2;
        this.measuredHeight = (int) ((i2 * 2) / 3.141592653589793d);
        this.radius = (int) (i2 / 3.141592653589793d);
        this.measuredWidth = View.MeasureSpec.getSize(this.widthMeasureSpec);
        int i3 = this.measuredHeight;
        float f2 = this.itemHeight;
        this.firstLineY = (i3 - f2) / 2.0f;
        float f3 = (i3 + f2) / 2.0f;
        this.secondLineY = f3;
        this.centerY = (f3 - ((f2 - this.maxTextHeight) / 2.0f)) - this.CENTERCONTENTOFFSET;
        if (this.initPosition == -1) {
            if (this.isLoop) {
                this.initPosition = (this.adapter.getItemsCount() + 1) / 2;
            } else {
                this.initPosition = 0;
            }
        }
        this.preCurrentIndex = this.initPosition;
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.mFuture;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.mFuture.cancel(true);
        this.mFuture = null;
    }

    public final WheelAdapter getAdapter() {
        return this.adapter;
    }

    public final int getCurrentItem() {
        return this.selectedItem;
    }

    public int getItemsCount() {
        WheelAdapter wheelAdapter = this.adapter;
        if (wheelAdapter != null) {
            return wheelAdapter.getItemsCount();
        }
        return 0;
    }

    public int getTextWidth(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        float[] fArr = new float[length];
        paint.getTextWidths(str, fArr);
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 += (int) Math.ceil(fArr[i3]);
        }
        return i2;
    }

    public void isCenterLabel(Boolean bool) {
        this.isCenterLabel = bool.booleanValue();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        WheelAdapter wheelAdapter = this.adapter;
        if (wheelAdapter == null) {
            return;
        }
        if (this.initPosition < 0) {
            this.initPosition = 0;
        }
        if (this.initPosition >= wheelAdapter.getItemsCount()) {
            this.initPosition = this.adapter.getItemsCount() - 1;
        }
        Object[] objArr = new Object[this.itemsVisible];
        int i3 = (int) (this.totalScrollY / this.itemHeight);
        this.change = i3;
        try {
            this.preCurrentIndex = this.initPosition + (i3 % this.adapter.getItemsCount());
        } catch (ArithmeticException unused) {
        }
        if (!this.isLoop) {
            if (this.preCurrentIndex < 0) {
                this.preCurrentIndex = 0;
            }
            if (this.preCurrentIndex > this.adapter.getItemsCount() - 1) {
                this.preCurrentIndex = this.adapter.getItemsCount() - 1;
            }
        } else {
            if (this.preCurrentIndex < 0) {
                this.preCurrentIndex = this.adapter.getItemsCount() + this.preCurrentIndex;
            }
            if (this.preCurrentIndex > this.adapter.getItemsCount() - 1) {
                this.preCurrentIndex -= this.adapter.getItemsCount();
            }
        }
        float f2 = this.totalScrollY % this.itemHeight;
        int i4 = 0;
        while (true) {
            int i5 = this.itemsVisible;
            if (i4 >= i5) {
                break;
            }
            int i6 = this.preCurrentIndex - ((i5 / 2) - i4);
            if (this.isLoop) {
                objArr[i4] = this.adapter.getItem(getLoopMappingIndex(i6));
            } else if (i6 < 0) {
                objArr[i4] = "";
            } else if (i6 > this.adapter.getItemsCount() - 1) {
                objArr[i4] = "";
            } else {
                objArr[i4] = this.adapter.getItem(i6);
            }
            i4++;
        }
        if (this.dividerType == DividerType.WRAP) {
            if (TextUtils.isEmpty(this.label)) {
                i2 = (this.measuredWidth - this.maxTextWidth) / 2;
            } else {
                i2 = (this.measuredWidth - this.maxTextWidth) / 4;
            }
            float f3 = i2 - 12;
            float f4 = f3 <= 0.0f ? 10.0f : f3;
            float f5 = this.measuredWidth - f4;
            float f6 = this.firstLineY;
            float f7 = f4;
            canvas.drawLine(f7, f6, f5, f6, this.paintIndicator);
            float f8 = this.secondLineY;
            canvas.drawLine(f7, f8, f5, f8, this.paintIndicator);
        } else {
            float f9 = this.firstLineY;
            canvas.drawLine(0.0f, f9, this.measuredWidth, f9, this.paintIndicator);
            float f10 = this.secondLineY;
            canvas.drawLine(0.0f, f10, this.measuredWidth, f10, this.paintIndicator);
        }
        if (!TextUtils.isEmpty(this.label) && this.isCenterLabel) {
            canvas.drawText(this.label, (this.measuredWidth - getTextWidth(this.paintCenterText, this.label)) - this.CENTERCONTENTOFFSET, this.centerY, this.paintCenterText);
        }
        for (int i7 = 0; i7 < this.itemsVisible; i7++) {
            canvas.save();
            double d2 = ((this.itemHeight * i7) - f2) / this.radius;
            float f11 = (float) (90.0d - ((d2 / 3.141592653589793d) * 180.0d));
            if (f11 < 90.0f && f11 > -90.0f) {
                String contentText = (!this.isCenterLabel && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(getContentText(objArr[i7]))) ? getContentText(objArr[i7]) + this.label : getContentText(objArr[i7]);
                reMeasureTextSize(contentText);
                measuredCenterContentStart(contentText);
                measuredOutContentStart(contentText);
                float cos = (float) ((this.radius - (Math.cos(d2) * this.radius)) - ((Math.sin(d2) * this.maxTextHeight) / 2.0d));
                canvas.translate(0.0f, cos);
                canvas.scale(1.0f, (float) Math.sin(d2));
                float f12 = this.firstLineY;
                if (cos <= f12 && this.maxTextHeight + cos >= f12) {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.measuredWidth, this.firstLineY - cos);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * SCALECONTENT);
                    canvas.drawText(contentText, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.firstLineY - cos, this.measuredWidth, (int) this.itemHeight);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                    canvas.drawText(contentText, this.drawCenterContentStart, this.maxTextHeight - this.CENTERCONTENTOFFSET, this.paintCenterText);
                    canvas.restore();
                } else {
                    float f13 = this.secondLineY;
                    if (cos <= f13 && this.maxTextHeight + cos >= f13) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.measuredWidth, this.secondLineY - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                        canvas.drawText(contentText, this.drawCenterContentStart, this.maxTextHeight - this.CENTERCONTENTOFFSET, this.paintCenterText);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.secondLineY - cos, this.measuredWidth, (int) this.itemHeight);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * SCALECONTENT);
                        canvas.drawText(contentText, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                    } else {
                        if (cos >= f12) {
                            int i8 = this.maxTextHeight;
                            if (i8 + cos <= f13) {
                                canvas.drawText(contentText, this.drawCenterContentStart, i8 - this.CENTERCONTENTOFFSET, this.paintCenterText);
                                this.selectedItem = this.adapter.indexOf(objArr[i7]);
                            }
                        }
                        canvas.save();
                        canvas.clipRect(0, 0, this.measuredWidth, (int) this.itemHeight);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * SCALECONTENT);
                        canvas.drawText(contentText, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                    }
                }
                canvas.restore();
                this.paintCenterText.setTextSize(this.textSize);
            } else {
                canvas.restore();
            }
        }
    }

    public final void onItemSelected() {
        if (this.onItemSelectedListener != null) {
            postDelayed(new newOnItemSelectedRunnable(this), 200L);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        this.widthMeasureSpec = i2;
        remeasure();
        setMeasuredDimension(this.measuredWidth, this.measuredHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.startTime = System.currentTimeMillis();
            cancelFuture();
            this.previousY = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.previousY - motionEvent.getRawY();
            this.previousY = motionEvent.getRawY();
            this.totalScrollY += rawY;
            if (!this.isLoop) {
                float f2 = (-this.initPosition) * this.itemHeight;
                float f3 = this.itemHeight;
                float itemsCount = ((this.adapter.getItemsCount() - 1) - this.initPosition) * f3;
                float f4 = this.totalScrollY;
                if (f4 - (f3 * 0.25d) < f2) {
                    f2 = f4 - rawY;
                } else if (f4 + (f3 * 0.25d) > itemsCount) {
                    itemsCount = f4 - rawY;
                }
                if (f4 < f2) {
                    this.totalScrollY = (int) f2;
                } else if (f4 > itemsCount) {
                    this.totalScrollY = (int) itemsCount;
                }
            }
        } else if (!onTouchEvent) {
            float y = motionEvent.getY();
            int i2 = this.radius;
            float f5 = this.itemHeight;
            this.mOffset = (int) (((((int) (((Math.acos((i2 - y) / i2) * this.radius) + (f5 / 2.0f)) / f5)) - (this.itemsVisible / 2)) * f5) - (((this.totalScrollY % f5) + f5) % f5));
            if (System.currentTimeMillis() - this.startTime > 120) {
                smoothScroll(ACTION.DAGGLE);
            } else {
                smoothScroll(ACTION.CLICK);
            }
        }
        invalidate();
        return true;
    }

    public final void scrollBy(float f2) {
        cancelFuture();
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new newInertiaTimerTask(this, f2), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(WheelAdapter wheelAdapter) {
        this.adapter = wheelAdapter;
        remeasure();
        invalidate();
    }

    public final void setCurrentItem(int i2) {
        this.selectedItem = i2;
        this.initPosition = i2;
        this.totalScrollY = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z) {
        this.isLoop = z;
    }

    public void setDividerColor(int i2) {
        if (i2 != 0) {
            this.dividerColor = i2;
            this.paintIndicator.setColor(i2);
        }
    }

    public void setDividerType(DividerType dividerType) {
        this.dividerType = dividerType;
    }

    public void setGravity(int i2) {
        this.mGravity = i2;
    }

    public void setIsOptions(boolean z) {
        this.isOptions = z;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setLineSpacingMultiplier(float f2) {
        if (f2 != 0.0f) {
            this.lineSpacingMultiplier = f2;
            judgeLineSpae();
        }
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public void setTextColorCenter(int i2) {
        if (i2 != 0) {
            this.textColorCenter = i2;
            this.paintCenterText.setColor(i2);
        }
    }

    public void setTextColorOut(int i2) {
        if (i2 != 0) {
            this.textColorOut = i2;
            this.paintOuterText.setColor(i2);
        }
    }

    public final void setTextSize(float f2) {
        if (f2 > 0.0f) {
            int i2 = (int) (this.context.getResources().getDisplayMetrics().density * f2);
            this.textSize = i2;
            this.paintOuterText.setTextSize(i2);
            this.paintCenterText.setTextSize(this.textSize);
        }
    }

    public final void setTypeface(Typeface typeface) {
        this.typeface = typeface;
        this.paintOuterText.setTypeface(typeface);
        this.paintCenterText.setTypeface(this.typeface);
    }

    public void smoothScroll(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f2 = this.totalScrollY;
            float f3 = this.itemHeight;
            int i2 = (int) (((f2 % f3) + f3) % f3);
            this.mOffset = i2;
            if (i2 > f3 / 2.0f) {
                this.mOffset = (int) (f3 - i2);
            } else {
                this.mOffset = -i2;
            }
        }
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new newSmoothScrollTimerTask(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public newWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isOptions = false;
        this.isCenterLabel = true;
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.typeface = Typeface.MONOSPACE;
        this.textColorOut = -5723992;
        this.textColorCenter = -14013910;
        this.dividerColor = -2763307;
        this.lineSpacingMultiplier = 1.6f;
        this.itemsVisible = 11;
        this.mOffset = 0;
        this.previousY = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.drawCenterContentStart = 0;
        this.drawOutContentStart = 0;
        this.textSize = getResources().getDimensionPixelSize(R.dimen.ykfsdk_pickerview_textsize);
        float f2 = getResources().getDisplayMetrics().density;
        if (f2 < 1.0f) {
            this.CENTERCONTENTOFFSET = 2.4f;
        } else {
            int i2 = (1.0f > f2 ? 1 : (1.0f == f2 ? 0 : -1));
            if (i2 <= 0 && f2 < 2.0f) {
                this.CENTERCONTENTOFFSET = 3.6f;
            } else if (i2 <= 0 && f2 < 2.0f) {
                this.CENTERCONTENTOFFSET = 4.5f;
            } else if (2.0f <= f2 && f2 < 3.0f) {
                this.CENTERCONTENTOFFSET = 6.0f;
            } else if (f2 >= 3.0f) {
                this.CENTERCONTENTOFFSET = f2 * 2.5f;
            }
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ykfsdk_pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(R.styleable.ykfsdk_pickerview_ykfsdk_pickerview_gravity, 17);
            this.textColorOut = obtainStyledAttributes.getColor(R.styleable.ykfsdk_pickerview_ykfsdk_pickerview_textColorOut, this.textColorOut);
            this.textColorCenter = obtainStyledAttributes.getColor(R.styleable.ykfsdk_pickerview_ykfsdk_pickerview_textColorCenter, this.textColorCenter);
            this.dividerColor = obtainStyledAttributes.getColor(R.styleable.ykfsdk_pickerview_ykfsdk_pickerview_dividerColor, this.dividerColor);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ykfsdk_pickerview_ykfsdk_pickerview_textSize, this.textSize);
            this.lineSpacingMultiplier = obtainStyledAttributes.getFloat(R.styleable.ykfsdk_pickerview_ykfsdk_pickerview_lineSpacingMultiplier, this.lineSpacingMultiplier);
            obtainStyledAttributes.recycle();
        }
        judgeLineSpae();
        initLoopView(context);
    }
}
