package com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.bean.BaseIndexPinyinBean;
import com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.helper.IIndexBarDataHelper;
import com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.helper.IndexBarDataHelperImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class IndexBar extends View {
    private boolean isNeedRealIndex;
    private boolean isSourceDatasAlreadySorted;
    private IIndexBarDataHelper mDataHelper;
    private int mGapHeight;
    private int mHeaderViewCount;
    private int mHeight;
    private List<String> mIndexDatas;
    private CustomLinearLayoutManager mLayoutManager;
    private onIndexPressedListener mOnIndexPressedListener;
    private Paint mPaint;
    private int mPressedBackground;
    private TextView mPressedShowTextView;
    private List<? extends BaseIndexPinyinBean> mSourceDatas;
    private int mWidth;
    private static final String TAG = IndexBar.class.getSimpleName();
    public static String[] INDEX_STRING = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", ExpandableTextView.P, "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", MqttTopic.MULTI_LEVEL_WILDCARD};

    /* loaded from: classes3.dex */
    public interface onIndexPressedListener {
        void onIndexPressed(int i2, String str);

        void onMotionEventEnd();
    }

    public IndexBar(Context context) {
        this(context, null);
    }

    private void computeGapHeight() {
        this.mGapHeight = ((this.mHeight - getPaddingTop()) - getPaddingBottom()) / this.mIndexDatas.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPosByTag(String str) {
        List<? extends BaseIndexPinyinBean> list = this.mSourceDatas;
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return -1;
        }
        for (int i2 = 0; i2 < this.mSourceDatas.size(); i2++) {
            if (str.equals(this.mSourceDatas.get(i2).getBaseIndexTag())) {
                return i2 + getHeaderViewCount();
            }
        }
        return -1;
    }

    private void init(Context context, AttributeSet attributeSet, int i2) {
        int applyDimension = (int) TypedValue.applyDimension(2, 12.0f, getResources().getDisplayMetrics());
        this.mPressedBackground = ViewCompat.MEASURED_STATE_MASK;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.IndexBar, i2, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R.styleable.IndexBar_indexBarTextSize) {
                applyDimension = obtainStyledAttributes.getDimensionPixelSize(index, applyDimension);
            } else if (index == R.styleable.IndexBar_indexBarPressBackground) {
                this.mPressedBackground = obtainStyledAttributes.getColor(index, this.mPressedBackground);
            }
        }
        obtainStyledAttributes.recycle();
        initIndexDatas();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setTextSize(applyDimension);
        this.mPaint.setColor(-7829368);
        setOnIndexPressedListener(new onIndexPressedListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.widget.IndexBar.1
            @Override // com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.widget.IndexBar.onIndexPressedListener
            public void onIndexPressed(int i4, String str) {
                int posByTag;
                if (IndexBar.this.mPressedShowTextView != null) {
                    IndexBar.this.mPressedShowTextView.setVisibility(0);
                    IndexBar.this.mPressedShowTextView.setText(str);
                }
                if (IndexBar.this.mLayoutManager == null || (posByTag = IndexBar.this.getPosByTag(str)) == -1) {
                    return;
                }
                IndexBar.this.mLayoutManager.scrollToPositionWithOffset(posByTag, 0);
            }

            @Override // com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.widget.IndexBar.onIndexPressedListener
            public void onMotionEventEnd() {
                if (IndexBar.this.mPressedShowTextView != null) {
                    IndexBar.this.mPressedShowTextView.setVisibility(8);
                }
            }
        });
        this.mDataHelper = new IndexBarDataHelperImpl();
    }

    private void initIndexDatas() {
        if (this.isNeedRealIndex) {
            this.mIndexDatas = new ArrayList();
        } else {
            this.mIndexDatas = Arrays.asList(INDEX_STRING);
        }
    }

    private void initSourceDatas() {
        List<? extends BaseIndexPinyinBean> list = this.mSourceDatas;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (!this.isSourceDatasAlreadySorted) {
            this.mDataHelper.sortSourceDatas(this.mSourceDatas);
        } else {
            this.mDataHelper.convert(this.mSourceDatas);
            this.mDataHelper.fillInexTag(this.mSourceDatas);
        }
        if (this.isNeedRealIndex) {
            this.mDataHelper.getSortedIndexDatas(this.mSourceDatas, this.mIndexDatas);
            computeGapHeight();
        }
    }

    private void sortData() {
    }

    public IIndexBarDataHelper getDataHelper() {
        return this.mDataHelper;
    }

    public int getHeaderViewCount() {
        return this.mHeaderViewCount;
    }

    public onIndexPressedListener getOnIndexPressedListener() {
        return this.mOnIndexPressedListener;
    }

    public boolean isSourceDatasAlreadySorted() {
        return this.isSourceDatasAlreadySorted;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int paddingTop = getPaddingTop();
        for (int i2 = 0; i2 < this.mIndexDatas.size(); i2++) {
            String str = this.mIndexDatas.get(i2);
            Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
            canvas.drawText(str, (this.mWidth / 2) - (this.mPaint.measureText(str) / 2.0f), (this.mGapHeight * i2) + paddingTop + ((int) (((this.mGapHeight - fontMetrics.bottom) - fontMetrics.top) / 2.0f)), this.mPaint);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        Rect rect = new Rect();
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < this.mIndexDatas.size(); i6++) {
            String str = this.mIndexDatas.get(i6);
            this.mPaint.getTextBounds(str, 0, str.length(), rect);
            i5 = Math.max(rect.width(), i5);
            i4 = Math.max(rect.height(), i4);
        }
        int size3 = i4 * this.mIndexDatas.size();
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(i5, size);
        } else if (mode != 1073741824) {
            size = i5;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size3, size2);
        } else if (mode2 != 1073741824) {
            size2 = size3;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.mWidth = i2;
        this.mHeight = i3;
        List<String> list = this.mIndexDatas;
        if (list == null || list.isEmpty()) {
            return;
        }
        computeGapHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            setBackgroundColor(this.mPressedBackground);
        } else if (action != 2) {
            setBackgroundResource(17170445);
            onIndexPressedListener onindexpressedlistener = this.mOnIndexPressedListener;
            if (onindexpressedlistener != null) {
                onindexpressedlistener.onMotionEventEnd();
            }
            return true;
        }
        int y = (int) ((motionEvent.getY() - getPaddingTop()) / this.mGapHeight);
        if (y < 0) {
            y = 0;
        } else if (y >= this.mIndexDatas.size()) {
            y = this.mIndexDatas.size() - 1;
        }
        if (this.mOnIndexPressedListener != null && y > -1 && y < this.mIndexDatas.size()) {
            this.mOnIndexPressedListener.onIndexPressed(y, this.mIndexDatas.get(y));
        }
        return true;
    }

    public IndexBar setDataHelper(IIndexBarDataHelper iIndexBarDataHelper) {
        this.mDataHelper = iIndexBarDataHelper;
        return this;
    }

    public IndexBar setHeaderViewCount(int i2) {
        this.mHeaderViewCount = i2;
        return this;
    }

    public IndexBar setLayoutManager(CustomLinearLayoutManager customLinearLayoutManager) {
        this.mLayoutManager = customLinearLayoutManager;
        return this;
    }

    public IndexBar setNeedRealIndex(boolean z) {
        this.isNeedRealIndex = z;
        initIndexDatas();
        return this;
    }

    public void setOnIndexPressedListener(onIndexPressedListener onindexpressedlistener) {
        this.mOnIndexPressedListener = onindexpressedlistener;
    }

    public IndexBar setPressedShowTextView(TextView textView) {
        this.mPressedShowTextView = textView;
        return this;
    }

    public IndexBar setSourceDatas(List<? extends BaseIndexPinyinBean> list) {
        this.mSourceDatas = list;
        initSourceDatas();
        return this;
    }

    public IndexBar setSourceDatasAlreadySorted(boolean z) {
        this.isSourceDatasAlreadySorted = z;
        return this;
    }

    public IndexBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndexBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mHeaderViewCount = 0;
        init(context, attributeSet, i2);
    }
}
