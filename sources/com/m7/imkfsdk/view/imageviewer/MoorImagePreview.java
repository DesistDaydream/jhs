package com.m7.imkfsdk.view.imageviewer;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.model.MoorImageInfoBean;
import com.m7.imkfsdk.view.imageviewer.listener.OnBigImageClickListener;
import com.m7.imkfsdk.view.imageviewer.listener.OnBigImageLongClickListener;
import com.m7.imkfsdk.view.imageviewer.listener.OnBigImagePageChangeListener;
import com.m7.imkfsdk.view.imageviewer.listener.OnDownloadClickListener;
import com.m7.imkfsdk.view.imageviewer.listener.OnOriginProgressListener;
import com.moor.imkf.lib.utils.MoorLogUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class MoorImagePreview {
    private static final int MIN_DOUBLE_CLICK_TIME = 1500;
    private OnBigImageClickListener bigImageClickListener;
    private OnBigImageLongClickListener bigImageLongClickListener;
    private OnBigImagePageChangeListener bigImagePageChangeListener;
    @DrawableRes
    private int closeIconResId;
    private WeakReference<Context> contextWeakReference;
    @DrawableRes
    private int downIconResId;
    private OnDownloadClickListener downloadClickListener;
    @DrawableRes
    private int errorPlaceHolder;
    private List<MoorImageInfoBean> imageInfoList;
    private long lastClickTime;
    private OnOriginProgressListener onOriginProgressListener;
    @LayoutRes
    private int progressLayoutId;
    private int index = 0;
    private String folderName = "";
    private float minScale = 1.0f;
    private float mediumScale = 3.0f;
    private float maxScale = 5.0f;
    private boolean isShowIndicator = true;
    private boolean isShowCloseButton = false;
    private boolean isShowDownButton = true;
    private int zoomTransitionDuration = 200;
    private boolean isEnableDragClose = true;
    private boolean isEnableUpDragClose = true;
    private boolean isEnableDragCloseIgnoreScale = true;
    private boolean isEnableClickClose = true;
    private boolean isShowErrorToast = false;
    private LoadStrategy loadStrategy = LoadStrategy.Default;
    @DrawableRes
    private int indicatorShapeResId = R.drawable.ykfsdk_moor_shape_indicator_bg;

    /* loaded from: classes2.dex */
    public static class InnerClass {
        private static final MoorImagePreview instance = new MoorImagePreview();

        private InnerClass() {
        }
    }

    /* loaded from: classes2.dex */
    public enum LoadStrategy {
        AlwaysOrigin,
        AlwaysThumb,
        NetworkAuto,
        Default
    }

    public MoorImagePreview() {
        int i2 = R.drawable.ykfsdk_icon_chat_pic;
        this.closeIconResId = i2;
        this.downIconResId = i2;
        this.errorPlaceHolder = i2;
        this.progressLayoutId = -1;
        this.lastClickTime = 0L;
    }

    public static MoorImagePreview getInstance() {
        return InnerClass.instance;
    }

    private MoorImagePreview setOnOriginProgressListener(OnOriginProgressListener onOriginProgressListener) {
        this.onOriginProgressListener = onOriginProgressListener;
        return this;
    }

    public OnBigImageClickListener getBigImageClickListener() {
        return this.bigImageClickListener;
    }

    public OnBigImageLongClickListener getBigImageLongClickListener() {
        return this.bigImageLongClickListener;
    }

    public OnBigImagePageChangeListener getBigImagePageChangeListener() {
        return this.bigImagePageChangeListener;
    }

    public int getCloseIconResId() {
        return this.closeIconResId;
    }

    public int getDownIconResId() {
        return this.downIconResId;
    }

    public OnDownloadClickListener getDownloadClickListener() {
        return this.downloadClickListener;
    }

    public int getErrorPlaceHolder() {
        return this.errorPlaceHolder;
    }

    public String getFolderName() {
        if (TextUtils.isEmpty(this.folderName)) {
            this.folderName = "Download";
        }
        return this.folderName;
    }

    public List<MoorImageInfoBean> getImageInfoList() {
        return this.imageInfoList;
    }

    public int getIndex() {
        return this.index;
    }

    public int getIndicatorShapeResId() {
        return this.indicatorShapeResId;
    }

    public LoadStrategy getLoadStrategy() {
        return this.loadStrategy;
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public float getMediumScale() {
        return this.mediumScale;
    }

    public float getMinScale() {
        return this.minScale;
    }

    public OnOriginProgressListener getOnOriginProgressListener() {
        return this.onOriginProgressListener;
    }

    public int getProgressLayoutId() {
        return this.progressLayoutId;
    }

    public int getZoomTransitionDuration() {
        return this.zoomTransitionDuration;
    }

    public boolean isEnableClickClose() {
        return this.isEnableClickClose;
    }

    public boolean isEnableDragClose() {
        return this.isEnableDragClose;
    }

    public boolean isEnableDragCloseIgnoreScale() {
        return this.isEnableDragCloseIgnoreScale;
    }

    public boolean isEnableUpDragClose() {
        return this.isEnableUpDragClose;
    }

    public boolean isShowCloseButton() {
        return this.isShowCloseButton;
    }

    public boolean isShowDownButton() {
        return this.isShowDownButton;
    }

    public boolean isShowErrorToast() {
        return this.isShowErrorToast;
    }

    public boolean isShowIndicator() {
        return this.isShowIndicator;
    }

    public boolean isShowOriginButton(int i2) {
        List<MoorImageInfoBean> imageInfoList = getImageInfoList();
        if (imageInfoList == null || imageInfoList.size() == 0 || imageInfoList.get(i2).getPath().equalsIgnoreCase(imageInfoList.get(i2).getPath())) {
            return false;
        }
        LoadStrategy loadStrategy = this.loadStrategy;
        if (loadStrategy == LoadStrategy.Default) {
            return true;
        }
        if (loadStrategy != LoadStrategy.NetworkAuto && loadStrategy != LoadStrategy.AlwaysThumb && loadStrategy == LoadStrategy.AlwaysOrigin) {
        }
        return false;
    }

    public void reset() {
        this.imageInfoList = null;
        this.index = 0;
        this.minScale = 1.0f;
        this.mediumScale = 3.0f;
        this.maxScale = 5.0f;
        this.zoomTransitionDuration = 200;
        this.isShowDownButton = true;
        this.isShowCloseButton = false;
        this.isEnableDragClose = true;
        this.isEnableClickClose = true;
        this.isShowIndicator = true;
        this.isShowErrorToast = false;
        int i2 = R.drawable.ykfsdk_icon_chat_pic;
        this.closeIconResId = i2;
        this.downIconResId = i2;
        this.errorPlaceHolder = i2;
        this.loadStrategy = LoadStrategy.Default;
        this.folderName = "Download";
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference != null) {
            weakReference.clear();
            this.contextWeakReference = null;
        }
        this.bigImageClickListener = null;
        this.bigImageLongClickListener = null;
        this.bigImagePageChangeListener = null;
        this.progressLayoutId = -1;
        this.lastClickTime = 0L;
    }

    public MoorImagePreview setBigImageClickListener(OnBigImageClickListener onBigImageClickListener) {
        this.bigImageClickListener = onBigImageClickListener;
        return this;
    }

    public MoorImagePreview setBigImageLongClickListener(OnBigImageLongClickListener onBigImageLongClickListener) {
        this.bigImageLongClickListener = onBigImageLongClickListener;
        return this;
    }

    public MoorImagePreview setBigImagePageChangeListener(OnBigImagePageChangeListener onBigImagePageChangeListener) {
        this.bigImagePageChangeListener = onBigImagePageChangeListener;
        return this;
    }

    public MoorImagePreview setCloseIconResId(@DrawableRes int i2) {
        this.closeIconResId = i2;
        return this;
    }

    public MoorImagePreview setContext(@NonNull Context context) {
        this.contextWeakReference = new WeakReference<>(context);
        return this;
    }

    public MoorImagePreview setDownIconResId(@DrawableRes int i2) {
        this.downIconResId = i2;
        return this;
    }

    public MoorImagePreview setDownloadClickListener(OnDownloadClickListener onDownloadClickListener) {
        this.downloadClickListener = onDownloadClickListener;
        return this;
    }

    public MoorImagePreview setEnableClickClose(boolean z) {
        this.isEnableClickClose = z;
        return this;
    }

    public MoorImagePreview setEnableDragClose(boolean z) {
        this.isEnableDragClose = z;
        return this;
    }

    public MoorImagePreview setEnableDragCloseIgnoreScale(boolean z) {
        this.isEnableDragCloseIgnoreScale = z;
        return this;
    }

    public MoorImagePreview setEnableUpDragClose(boolean z) {
        this.isEnableUpDragClose = z;
        return this;
    }

    public MoorImagePreview setErrorPlaceHolder(int i2) {
        this.errorPlaceHolder = i2;
        return this;
    }

    public MoorImagePreview setFolderName(@NonNull String str) {
        this.folderName = str;
        return this;
    }

    public MoorImagePreview setImage(@NonNull MoorImageInfoBean moorImageInfoBean) {
        ArrayList arrayList = new ArrayList();
        this.imageInfoList = arrayList;
        arrayList.add(moorImageInfoBean);
        return this;
    }

    public MoorImagePreview setImageList(@NonNull List<MoorImageInfoBean> list) {
        this.imageInfoList = new ArrayList();
        this.imageInfoList = list;
        return this;
    }

    public MoorImagePreview setIndex(int i2) {
        this.index = i2;
        return this;
    }

    public MoorImagePreview setIndicatorShapeResId(int i2) {
        this.indicatorShapeResId = i2;
        return this;
    }

    public MoorImagePreview setLoadStrategy(LoadStrategy loadStrategy) {
        this.loadStrategy = loadStrategy;
        return this;
    }

    public MoorImagePreview setProgressLayoutId(int i2, OnOriginProgressListener onOriginProgressListener) {
        setOnOriginProgressListener(onOriginProgressListener);
        this.progressLayoutId = i2;
        return this;
    }

    @Deprecated
    public MoorImagePreview setScaleLevel(int i2, int i3, int i4) {
        if (i4 > i3 && i3 > i2 && i2 > 0) {
            this.minScale = i2;
            this.mediumScale = i3;
            this.maxScale = i4;
            return this;
        }
        throw new IllegalArgumentException("max must greater to medium, medium must greater to min!");
    }

    @Deprecated
    public MoorImagePreview setScaleMode(int i2) {
        return this;
    }

    public MoorImagePreview setShowCloseButton(boolean z) {
        this.isShowCloseButton = z;
        return this;
    }

    public MoorImagePreview setShowDownButton(boolean z) {
        this.isShowDownButton = z;
        return this;
    }

    public MoorImagePreview setShowErrorToast(boolean z) {
        this.isShowErrorToast = z;
        return this;
    }

    public MoorImagePreview setShowIndicator(boolean z) {
        this.isShowIndicator = z;
        return this;
    }

    @Deprecated
    public MoorImagePreview setShowOriginButton(boolean z) {
        return this;
    }

    public MoorImagePreview setZoomTransitionDuration(int i2) {
        if (i2 >= 0) {
            this.zoomTransitionDuration = i2;
            return this;
        }
        throw new IllegalArgumentException("zoomTransitionDuration must greater 0");
    }

    public void start() {
        if (System.currentTimeMillis() - this.lastClickTime <= 1500) {
            MoorLogUtils.d("MoorImagePreview", "---忽略多次快速点击---");
            return;
        }
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference != null) {
            Context context = weakReference.get();
            if (context != null) {
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (!activity.isFinishing() && !activity.isDestroyed()) {
                        List<MoorImageInfoBean> list = this.imageInfoList;
                        if (list != null && list.size() != 0) {
                            if (this.index < this.imageInfoList.size()) {
                                this.lastClickTime = System.currentTimeMillis();
                                MoorImagePreviewActivity.activityStart(context);
                                return;
                            }
                            throw new IllegalArgumentException("index out of range!");
                        }
                        throw new IllegalArgumentException("Do you forget to call 'setImageInfoList(List<MoorImageInfoBean> imageInfoList)' ?");
                    }
                    reset();
                    return;
                }
                throw new IllegalArgumentException("context must be a Activity!");
            }
            throw new IllegalArgumentException("You must call 'setContext(Context context)' first!");
        }
        throw new IllegalArgumentException("You must call 'setContext(Context context)' first!");
    }
}
