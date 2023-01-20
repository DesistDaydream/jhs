package com.m7.imkfsdk.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import java.util.List;

/* loaded from: classes2.dex */
public class PopupWindowList {
    private View mAnchorView;
    private Context mContext;
    private int mDeviceHeight;
    private int mDeviceWidth;
    private AdapterView.OnItemClickListener mItemClickListener;
    private List<String> mItemData;
    private boolean mModal;
    private int mPopAnimStyle;
    private ListView mPopView;
    private PopupWindow mPopupWindow;
    private int mPopupWindowHeight;
    private int mPopupWindowWidth;

    public PopupWindowList(Context context) {
        if (context != null) {
            this.mContext = context;
            setHeightWidth();
            return;
        }
        throw new IllegalArgumentException("context can not be null");
    }

    public void hide() {
        if (isShowing()) {
            this.mPopupWindow.dismiss();
        }
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.mPopupWindow;
        return popupWindow != null && popupWindow.isShowing();
    }

    public Rect locateView(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            int i2 = iArr[0];
            rect.left = i2;
            rect.top = iArr[1];
            rect.right = i2 + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            return rect;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public void setAnchorView(@Nullable View view) {
        this.mAnchorView = view;
    }

    public void setHeightWidth() {
        Point point = new Point();
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getSize(point);
        int i2 = point.x;
        if (i2 != 0) {
            this.mDeviceWidth = i2;
        }
        int i3 = point.y;
        if (i3 != 0) {
            this.mDeviceHeight = i3;
        }
    }

    public void setItemData(List<String> list) {
        this.mItemData = list;
    }

    public void setModal(boolean z) {
        this.mModal = z;
    }

    public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
        ListView listView = this.mPopView;
        if (listView != null) {
            listView.setOnItemClickListener(onItemClickListener);
        }
    }

    public void setPopAnimStyle(int i2) {
        this.mPopAnimStyle = i2;
    }

    public void setPopupWindowHeight(int i2) {
        this.mPopupWindowHeight = i2;
    }

    public void setPopupWindowWidth(int i2) {
        this.mPopupWindowWidth = i2;
    }

    public void show() {
        if (this.mAnchorView != null) {
            if (this.mItemData != null) {
                ListView listView = new ListView(this.mContext);
                this.mPopView = listView;
                listView.setBackgroundColor(ContextCompat.getColor(this.mContext, 17170443));
                this.mPopView.setVerticalScrollBarEnabled(false);
                this.mPopView.setDivider(null);
                this.mPopView.setAdapter((ListAdapter) new ArrayAdapter(this.mContext, 17367043, this.mItemData));
                AdapterView.OnItemClickListener onItemClickListener = this.mItemClickListener;
                if (onItemClickListener != null) {
                    this.mPopView.setOnItemClickListener(onItemClickListener);
                }
                this.mPopView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                if (this.mPopupWindowWidth == 0) {
                    this.mPopupWindowWidth = this.mDeviceWidth / 3;
                }
                if (this.mPopupWindowHeight == 0) {
                    int size = this.mItemData.size() * this.mPopView.getMeasuredHeight();
                    this.mPopupWindowHeight = size;
                    int i2 = this.mDeviceHeight;
                    if (size > i2 / 2) {
                        this.mPopupWindowHeight = i2 / 2;
                    }
                }
                PopupWindow popupWindow = new PopupWindow(this.mPopView, this.mPopupWindowWidth, this.mPopupWindowHeight);
                this.mPopupWindow = popupWindow;
                int i3 = this.mPopAnimStyle;
                if (i3 != 0) {
                    popupWindow.setAnimationStyle(i3);
                }
                this.mPopupWindow.setOutsideTouchable(true);
                this.mPopupWindow.setFocusable(this.mModal);
                this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), (Bitmap) null));
                Rect locateView = locateView(this.mAnchorView);
                if (locateView != null) {
                    int width = locateView.left + (this.mAnchorView.getWidth() / 2);
                    if (width > this.mDeviceWidth / 2) {
                        width -= this.mPopupWindowWidth;
                    }
                    int height = locateView.top + (this.mAnchorView.getHeight() / 2);
                    if (height > this.mDeviceHeight / 2) {
                        height -= this.mPopupWindowHeight;
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchorView, 0, width, height);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("please fill ListView Data");
        }
        throw new IllegalArgumentException("PopupWindow show location view can  not be null");
    }
}
