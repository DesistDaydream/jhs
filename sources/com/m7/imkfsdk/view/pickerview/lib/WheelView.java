package com.m7.imkfsdk.view.pickerview.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.view.pickerview.adapter.WheelAdapter;
import com.m7.imkfsdk.view.pickerview.listener.OnItemSelectedListener;
import com.m7.imkfsdk.view.pickerview.model.IPickerViewData;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class WheelView extends View {
    private static final float CENTERCONTENTOFFSET = 6.0f;
    private static final float SCALECONTENT = 0.8f;
    private static final int VELOCITYFLING = 5;
    public static final float lineSpacingMultiplier = 1.4f;
    public WheelAdapter adapter;
    public float centerY;
    public int change;
    public Context context;
    public boolean customTextSize;
    public int dividerColor;
    private int drawCenterContentStart;
    private int drawOutContentStart;
    public float firstLineY;
    private GestureDetector gestureDetector;
    public int halfCircumference;
    public Handler handler;
    public int initPosition;
    public boolean isLoop;
    public float itemHeight;
    public int itemsVisible;
    private String label;
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
    public int totalScrollY;
    public int widthMeasureSpec;

    /* loaded from: classes2.dex */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    public WheelView(Context context) {
        this(context, null);
    }

    private String getContentText(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPickerViewData) {
            return ((IPickerViewData) obj).getPickerViewText();
        }
        return obj.toString();
    }

    private int getLoopMappingIndex(int i2) {
        if (i2 < 0) {
            return getLoopMappingIndex(i2 + this.adapter.getItemsCount());
        }
        return i2 > this.adapter.getItemsCount() + (-1) ? getLoopMappingIndex(i2 - this.adapter.getItemsCount()) : i2;
    }

    private void initLoopView(Context context) {
        this.context = context;
        this.handler = new MessageHandler(this);
        GestureDetector gestureDetector = new GestureDetector(context, new LoopViewGestureListener(this));
        this.gestureDetector = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.isLoop = true;
        this.totalScrollY = 0;
        this.initPosition = -1;
        initPaints();
    }

    private void initPaints() {
        Paint paint = new Paint();
        this.paintOuterText = paint;
        paint.setColor(this.textColorOut);
        this.paintOuterText.setAntiAlias(true);
        this.paintOuterText.setTypeface(Typeface.MONOSPACE);
        this.paintOuterText.setTextSize(this.textSize);
        Paint paint2 = new Paint();
        this.paintCenterText = paint2;
        paint2.setColor(this.textColorCenter);
        this.paintCenterText.setAntiAlias(true);
        this.paintCenterText.setTextScaleX(1.1f);
        this.paintCenterText.setTypeface(Typeface.MONOSPACE);
        this.paintCenterText.setTextSize(this.textSize);
        Paint paint3 = new Paint();
        this.paintIndicator = paint3;
        paint3.setColor(this.dividerColor);
        this.paintIndicator.setAntiAlias(true);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
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
            int height = rect.height();
            if (height > this.maxTextHeight) {
                this.maxTextHeight = height;
            }
        }
        this.itemHeight = this.maxTextHeight * 1.4f;
    }

    private void measuredCenterContentStart(String str) {
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.mGravity;
        if (i2 == 3) {
            this.drawCenterContentStart = 0;
        } else if (i2 == 5) {
            this.drawCenterContentStart = this.measuredWidth - rect.width();
        } else if (i2 != 17) {
        } else {
            this.drawCenterContentStart = (int) ((this.measuredWidth - rect.width()) * 0.5d);
        }
    }

    private void measuredOutContentStart(String str) {
        Rect rect = new Rect();
        this.paintOuterText.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.mGravity;
        if (i2 == 3) {
            this.drawOutContentStart = 0;
        } else if (i2 == 5) {
            this.drawOutContentStart = this.measuredWidth - rect.width();
        } else if (i2 != 17) {
        } else {
            this.drawOutContentStart = (int) ((this.measuredWidth - rect.width()) * 0.5d);
        }
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
        this.secondLineY = (i3 + f2) / 2.0f;
        this.centerY = ((i3 + this.maxTextHeight) / 2.0f) - CENTERCONTENTOFFSET;
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

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        String str;
        int i2;
        WheelAdapter wheelAdapter = this.adapter;
        if (wheelAdapter == null) {
            return;
        }
        Object[] objArr = new Object[this.itemsVisible];
        int i3 = (int) (this.totalScrollY / this.itemHeight);
        this.change = i3;
        try {
            this.preCurrentIndex = this.initPosition + (i3 % wheelAdapter.getItemsCount());
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
        int i4 = (int) (this.totalScrollY % this.itemHeight);
        int i5 = 0;
        while (true) {
            int i6 = this.itemsVisible;
            if (i5 >= i6) {
                break;
            }
            int i7 = this.preCurrentIndex - ((i6 / 2) - i5);
            if (this.isLoop) {
                objArr[i5] = this.adapter.getItem(getLoopMappingIndex(i7));
            } else if (i7 < 0) {
                objArr[i5] = "";
            } else if (i7 > this.adapter.getItemsCount() - 1) {
                objArr[i5] = "";
            } else {
                objArr[i5] = this.adapter.getItem(i7);
            }
            i5++;
        }
        float f2 = this.firstLineY;
        canvas.drawLine(0.0f, f2, this.measuredWidth, f2, this.paintIndicator);
        float f3 = this.secondLineY;
        canvas.drawLine(0.0f, f3, this.measuredWidth, f3, this.paintIndicator);
        if (this.label != null) {
            canvas.drawText(this.label, (this.measuredWidth - getTextWidth(this.paintCenterText, str)) - CENTERCONTENTOFFSET, this.centerY, this.paintCenterText);
        }
        int i8 = 0;
        while (i8 < this.itemsVisible) {
            canvas.save();
            float f4 = this.maxTextHeight * 1.4f;
            double d2 = (((i8 * f4) - i4) * 3.141592653589793d) / this.halfCircumference;
            float f5 = (float) (90.0d - ((d2 / 3.141592653589793d) * 180.0d));
            if (f5 < 90.0f && f5 > -90.0f) {
                String contentText = getContentText(objArr[i8]);
                measuredCenterContentStart(contentText);
                measuredOutContentStart(contentText);
                i2 = i4;
                float cos = (float) ((this.radius - (Math.cos(d2) * this.radius)) - ((Math.sin(d2) * this.maxTextHeight) / 2.0d));
                canvas.translate(0.0f, cos);
                canvas.scale(1.0f, (float) Math.sin(d2));
                float f6 = this.firstLineY;
                if (cos <= f6 && this.maxTextHeight + cos >= f6) {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.measuredWidth, this.firstLineY - cos);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * SCALECONTENT);
                    canvas.drawText(contentText, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.firstLineY - cos, this.measuredWidth, (int) f4);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                    canvas.drawText(contentText, this.drawCenterContentStart, this.maxTextHeight - CENTERCONTENTOFFSET, this.paintCenterText);
                    canvas.restore();
                } else {
                    float f7 = this.secondLineY;
                    if (cos <= f7 && this.maxTextHeight + cos >= f7) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.measuredWidth, this.secondLineY - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                        canvas.drawText(contentText, this.drawCenterContentStart, this.maxTextHeight - CENTERCONTENTOFFSET, this.paintCenterText);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.secondLineY - cos, this.measuredWidth, (int) f4);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * SCALECONTENT);
                        canvas.drawText(contentText, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                    } else if (cos >= f6 && this.maxTextHeight + cos <= f7) {
                        canvas.clipRect(0, 0, this.measuredWidth, (int) f4);
                        canvas.drawText(contentText, this.drawCenterContentStart, this.maxTextHeight - CENTERCONTENTOFFSET, this.paintCenterText);
                        int indexOf = this.adapter.indexOf(objArr[i8]);
                        if (indexOf != -1) {
                            this.selectedItem = indexOf;
                        }
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.measuredWidth, (int) f4);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * SCALECONTENT);
                        canvas.drawText(contentText, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                        canvas.restore();
                    }
                }
                canvas.restore();
            } else {
                i2 = i4;
                canvas.restore();
            }
            i8++;
            i4 = i2;
        }
    }

    public final void onItemSelected() {
        if (this.onItemSelectedListener != null) {
            postDelayed(new OnItemSelectedRunnable(this), 200L);
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
            this.totalScrollY = (int) (this.totalScrollY + rawY);
            if (!this.isLoop) {
                float f2 = (-this.initPosition) * this.itemHeight;
                float f3 = this.itemHeight;
                float itemsCount = ((this.adapter.getItemsCount() - 1) - this.initPosition) * f3;
                int i2 = this.totalScrollY;
                if (i2 - (f3 * 0.3d) < f2) {
                    f2 = i2 - rawY;
                } else if (i2 + (f3 * 0.3d) > itemsCount) {
                    itemsCount = i2 - rawY;
                }
                if (i2 < f2) {
                    this.totalScrollY = (int) f2;
                } else if (i2 > itemsCount) {
                    this.totalScrollY = (int) itemsCount;
                }
            }
        } else if (!onTouchEvent) {
            float y = motionEvent.getY();
            int i3 = this.radius;
            float f4 = this.itemHeight;
            this.mOffset = (int) (((((int) (((Math.acos((i3 - y) / i3) * this.radius) + (f4 / 2.0f)) / f4)) - (this.itemsVisible / 2)) * f4) - (((this.totalScrollY % f4) + f4) % f4));
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
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new InertiaTimerTask(this, f2), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(WheelAdapter wheelAdapter) {
        this.adapter = wheelAdapter;
        remeasure();
        invalidate();
    }

    public final void setCurrentItem(int i2) {
        this.initPosition = i2;
        this.totalScrollY = 0;
        invalidate();
    }

    public final void setCyclic(boolean z) {
        this.isLoop = z;
    }

    public void setGravity(int i2) {
        this.mGravity = i2;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public final void setTextSize(float f2) {
        if (f2 <= 0.0f || this.customTextSize) {
            return;
        }
        int i2 = (int) (this.context.getResources().getDisplayMetrics().density * f2);
        this.textSize = i2;
        this.paintOuterText.setTextSize(i2);
        this.paintCenterText.setTextSize(this.textSize);
    }

    public void smoothScroll(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f2 = this.itemHeight;
            int i2 = (int) (((this.totalScrollY % f2) + f2) % f2);
            this.mOffset = i2;
            if (i2 > f2 / 2.0f) {
                this.mOffset = (int) (f2 - i2);
            } else {
                this.mOffset = -i2;
            }
        }
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new SmoothScrollTimerTask(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.itemsVisible = 11;
        this.mOffset = 0;
        this.previousY = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.drawCenterContentStart = 0;
        this.drawOutContentStart = 0;
        this.textColorOut = getResources().getColor(R.color.ykfsdk_pickerview_wheelview_textcolor_out);
        this.textColorCenter = getResources().getColor(R.color.ykfsdk_pickerview_wheelview_textcolor_center);
        this.dividerColor = getResources().getColor(R.color.ykfsdk_pickerview_wheelview_textcolor_divider);
        this.textSize = getResources().getDimensionPixelSize(R.dimen.ykfsdk_pickerview_textsize);
        this.customTextSize = getResources().getBoolean(R.bool.ykfsdk_pickerview_customTextSize);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ykfsdk_pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(R.styleable.ykfsdk_pickerview_ykfsdk_pickerview_gravity, 17);
            this.textColorOut = obtainStyledAttributes.getColor(R.styleable.ykfsdk_pickerview_ykfsdk_pickerview_textColorOut, this.textColorOut);
            this.textColorCenter = obtainStyledAttributes.getColor(R.styleable.ykfsdk_pickerview_ykfsdk_pickerview_textColorCenter, this.textColorCenter);
            this.dividerColor = obtainStyledAttributes.getColor(R.styleable.ykfsdk_pickerview_ykfsdk_pickerview_dividerColor, this.dividerColor);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ykfsdk_pickerview_ykfsdk_pickerview_textSize, this.textSize);
        }
        initLoopView(context);
    }
}
