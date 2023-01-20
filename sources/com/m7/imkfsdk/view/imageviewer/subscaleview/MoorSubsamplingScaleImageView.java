package com.m7.imkfsdk.view.imageviewer.subscaleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.view.imageviewer.MoorImageSource;
import com.m7.imkfsdk.view.imageviewer.subscaleview.decoder.IMoorDecoderFactory;
import com.m7.imkfsdk.view.imageviewer.subscaleview.decoder.IMoorImageDecoder;
import com.m7.imkfsdk.view.imageviewer.subscaleview.decoder.IMoorImageRegionDecoder;
import com.m7.imkfsdk.view.imageviewer.subscaleview.decoder.MoorCompatDecoderFactory;
import com.m7.imkfsdk.view.imageviewer.subscaleview.decoder.MoorSkiaImageDecoder;
import com.m7.imkfsdk.view.imageviewer.subscaleview.decoder.MoorSkiaImageRegionDecoder;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes2.dex */
public class MoorSubsamplingScaleImageView extends View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int ORIGIN_ANIM = 1;
    public static final int ORIGIN_DOUBLE_TAP_ZOOM = 4;
    public static final int ORIGIN_FLING = 3;
    public static final int ORIGIN_TOUCH = 2;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    public static final int SCALE_TYPE_START = 4;
    public static final int TILE_SIZE_AUTO = Integer.MAX_VALUE;
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private static Bitmap.Config preferredBitmapConfig;
    private Anim anim;
    private Bitmap bitmap;
    private IMoorDecoderFactory<? extends IMoorImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private Paint bitmapPaint;
    private boolean debug;
    private Paint debugLinePaint;
    private Paint debugTextPaint;
    private IMoorImageRegionDecoder decoder;
    private final ReadWriteLock decoderLock;
    private final float density;
    private GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private final float[] dstArray;
    private boolean eagerLoadingEnabled;
    private Executor executor;
    private int fullImageSampleSize;
    private final Handler handler;
    private boolean imageLoadedSent;
    private boolean isPanning;
    private boolean isQuickScaling;
    private boolean isZooming;
    private Matrix matrix;
    private float maxScale;
    private int maxTileHeight;
    private int maxTileWidth;
    private int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    private OnImageEventListener onImageEventListener;
    private View.OnLongClickListener onLongClickListener;
    private OnStateChangedListener onStateChangedListener;
    private int orientation;
    private Rect pRegion;
    private boolean panEnabled;
    private int panLimit;
    private Float pendingScale;
    private boolean quickScaleEnabled;
    private float quickScaleLastDistance;
    private boolean quickScaleMoved;
    private PointF quickScaleSCenter;
    private final float quickScaleThreshold;
    private PointF quickScaleVLastPoint;
    private PointF quickScaleVStart;
    private boolean readySent;
    private IMoorDecoderFactory<? extends IMoorImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    private Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private ScaleAndTranslate satTemp;
    private float scale;
    private float scaleStart;
    private GestureDetector singleDetector;
    private final float[] srcArray;
    private Paint tileBgPaint;
    private Map<Integer, List<Tile>> tileMap;
    private Uri uri;
    private PointF vCenterStart;
    private float vDistStart;
    private PointF vTranslate;
    private PointF vTranslateBefore;
    private PointF vTranslateStart;
    private boolean zoomEnabled;
    private static final String TAG = MoorSubsamplingScaleImageView.class.getSimpleName();
    private static final List<Integer> VALID_ORIENTATIONS = Arrays.asList(0, 90, 180, 270, -1);
    private static final List<Integer> VALID_ZOOM_STYLES = Arrays.asList(1, 2, 3);
    private static final List<Integer> VALID_EASING_STYLES = Arrays.asList(2, 1);
    private static final List<Integer> VALID_PAN_LIMITS = Arrays.asList(1, 2, 3);
    private static final List<Integer> VALID_SCALE_TYPES = Arrays.asList(2, 1, 3, 4);

    /* loaded from: classes2.dex */
    public static class Anim {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private PointF sCenterEnd;
        private PointF sCenterEndRequested;
        private PointF sCenterStart;
        private float scaleEnd;
        private float scaleStart;
        private long time;
        private PointF vFocusEnd;
        private PointF vFocusStart;

        private Anim() {
            this.duration = 500L;
            this.interruptible = true;
            this.easing = 2;
            this.origin = 1;
            this.time = System.currentTimeMillis();
        }
    }

    /* loaded from: classes2.dex */
    public static class BitmapLoadTask extends AsyncTask<Void, Void, Integer> {
        private Bitmap bitmap;
        private final WeakReference<Context> contextRef;
        private final WeakReference<IMoorDecoderFactory<? extends IMoorImageDecoder>> decoderFactoryRef;
        private Exception exception;
        private final boolean preview;
        private final Uri source;
        private final WeakReference<MoorSubsamplingScaleImageView> viewRef;

        public BitmapLoadTask(MoorSubsamplingScaleImageView moorSubsamplingScaleImageView, Context context, IMoorDecoderFactory<? extends IMoorImageDecoder> iMoorDecoderFactory, Uri uri, boolean z) {
            this.viewRef = new WeakReference<>(moorSubsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(iMoorDecoderFactory);
            this.source = uri;
            this.preview = z;
        }

        @Override // android.os.AsyncTask
        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = this.contextRef.get();
                IMoorDecoderFactory<? extends IMoorImageDecoder> iMoorDecoderFactory = this.decoderFactoryRef.get();
                MoorSubsamplingScaleImageView moorSubsamplingScaleImageView = this.viewRef.get();
                if (context == null || iMoorDecoderFactory == null || moorSubsamplingScaleImageView == null) {
                    return null;
                }
                moorSubsamplingScaleImageView.debug("BitmapLoadTask.doInBackground", new Object[0]);
                this.bitmap = iMoorDecoderFactory.make().decode(context, this.source);
                return Integer.valueOf(moorSubsamplingScaleImageView.getExifOrientation(context, uri));
            } catch (Exception e2) {
                Log.e(MoorSubsamplingScaleImageView.TAG, "Failed to load bitmap", e2);
                this.exception = e2;
                return null;
            } catch (OutOfMemoryError e3) {
                Log.e(MoorSubsamplingScaleImageView.TAG, "Failed to load bitmap - OutOfMemoryError", e3);
                this.exception = new RuntimeException(e3);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Integer num) {
            MoorSubsamplingScaleImageView moorSubsamplingScaleImageView = this.viewRef.get();
            if (moorSubsamplingScaleImageView != null) {
                Bitmap bitmap = this.bitmap;
                if (bitmap != null && num != null) {
                    if (this.preview) {
                        moorSubsamplingScaleImageView.onPreviewLoaded(bitmap);
                    } else {
                        moorSubsamplingScaleImageView.onImageLoaded(bitmap, num.intValue(), false);
                    }
                } else if (this.exception == null || moorSubsamplingScaleImageView.onImageEventListener == null) {
                } else {
                    if (this.preview) {
                        moorSubsamplingScaleImageView.onImageEventListener.onPreviewLoadError(this.exception);
                    } else {
                        moorSubsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class DefaultOnAnimationEventListener implements OnAnimationEventListener {
        @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.OnAnimationEventListener
        public void onComplete() {
        }

        @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByNewAnim() {
        }

        @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByUser() {
        }
    }

    /* loaded from: classes2.dex */
    public static class DefaultOnImageEventListener implements OnImageEventListener {
        @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.OnImageEventListener
        public void onImageLoadError(Exception exc) {
        }

        @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.OnImageEventListener
        public void onImageLoaded() {
        }

        @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.OnImageEventListener
        public void onPreviewLoadError(Exception exc) {
        }

        @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.OnImageEventListener
        public void onPreviewReleased() {
        }

        @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.OnImageEventListener
        public void onReady() {
        }

        @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.OnImageEventListener
        public void onTileLoadError(Exception exc) {
        }
    }

    /* loaded from: classes2.dex */
    public static class DefaultOnStateChangedListener implements OnStateChangedListener {
        @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.OnStateChangedListener
        public void onCenterChanged(PointF pointF, int i2) {
        }

        @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.OnStateChangedListener
        public void onScaleChanged(float f2, int i2) {
        }
    }

    /* loaded from: classes2.dex */
    public interface OnAnimationEventListener {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    /* loaded from: classes2.dex */
    public interface OnImageEventListener {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onPreviewReleased();

        void onReady();

        void onTileLoadError(Exception exc);
    }

    /* loaded from: classes2.dex */
    public interface OnStateChangedListener {
        void onCenterChanged(PointF pointF, int i2);

        void onScaleChanged(float f2, int i2);
    }

    /* loaded from: classes2.dex */
    public static class ScaleAndTranslate {
        private float scale;
        private final PointF vTranslate;

        private ScaleAndTranslate(float f2, PointF pointF) {
            this.scale = f2;
            this.vTranslate = pointF;
        }
    }

    /* loaded from: classes2.dex */
    public static class Tile {
        private Bitmap bitmap;
        private Rect fileSRect;
        private boolean loading;
        private Rect sRect;
        private int sampleSize;
        private Rect vRect;
        private boolean visible;

        private Tile() {
        }
    }

    /* loaded from: classes2.dex */
    public static class TileLoadTask extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<IMoorImageRegionDecoder> decoderRef;
        private Exception exception;
        private final WeakReference<Tile> tileRef;
        private final WeakReference<MoorSubsamplingScaleImageView> viewRef;

        public TileLoadTask(MoorSubsamplingScaleImageView moorSubsamplingScaleImageView, IMoorImageRegionDecoder iMoorImageRegionDecoder, Tile tile) {
            this.viewRef = new WeakReference<>(moorSubsamplingScaleImageView);
            this.decoderRef = new WeakReference<>(iMoorImageRegionDecoder);
            this.tileRef = new WeakReference<>(tile);
            tile.loading = true;
        }

        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            try {
                MoorSubsamplingScaleImageView moorSubsamplingScaleImageView = this.viewRef.get();
                IMoorImageRegionDecoder iMoorImageRegionDecoder = this.decoderRef.get();
                Tile tile = this.tileRef.get();
                if (iMoorImageRegionDecoder == null || tile == null || moorSubsamplingScaleImageView == null || !iMoorImageRegionDecoder.isReady() || !tile.visible) {
                    if (tile != null) {
                        tile.loading = false;
                        return null;
                    }
                    return null;
                }
                moorSubsamplingScaleImageView.debug("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", tile.sRect, Integer.valueOf(tile.sampleSize));
                moorSubsamplingScaleImageView.decoderLock.readLock().lock();
                try {
                    if (iMoorImageRegionDecoder.isReady()) {
                        moorSubsamplingScaleImageView.fileSRect(tile.sRect, tile.fileSRect);
                        if (moorSubsamplingScaleImageView.sRegion != null) {
                            tile.fileSRect.offset(moorSubsamplingScaleImageView.sRegion.left, moorSubsamplingScaleImageView.sRegion.top);
                        }
                        return iMoorImageRegionDecoder.decodeRegion(tile.fileSRect, tile.sampleSize);
                    }
                    tile.loading = false;
                    moorSubsamplingScaleImageView.decoderLock.readLock().unlock();
                    return null;
                } finally {
                    moorSubsamplingScaleImageView.decoderLock.readLock().unlock();
                }
            } catch (Exception e2) {
                Log.e(MoorSubsamplingScaleImageView.TAG, "Failed to decode tile", e2);
                this.exception = e2;
                return null;
            } catch (OutOfMemoryError e3) {
                Log.e(MoorSubsamplingScaleImageView.TAG, "Failed to decode tile - OutOfMemoryError", e3);
                this.exception = new RuntimeException(e3);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            MoorSubsamplingScaleImageView moorSubsamplingScaleImageView = this.viewRef.get();
            Tile tile = this.tileRef.get();
            if (moorSubsamplingScaleImageView == null || tile == null) {
                return;
            }
            if (bitmap != null) {
                tile.bitmap = bitmap;
                tile.loading = false;
                moorSubsamplingScaleImageView.onTileLoaded();
            } else if (this.exception == null || moorSubsamplingScaleImageView.onImageEventListener == null) {
            } else {
                moorSubsamplingScaleImageView.onImageEventListener.onTileLoadError(this.exception);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class TilesInitTask extends AsyncTask<Void, Void, int[]> {
        private final WeakReference<Context> contextRef;
        private IMoorImageRegionDecoder decoder;
        private final WeakReference<IMoorDecoderFactory<? extends IMoorImageRegionDecoder>> decoderFactoryRef;
        private Exception exception;
        private final Uri source;
        private final WeakReference<MoorSubsamplingScaleImageView> viewRef;

        public TilesInitTask(MoorSubsamplingScaleImageView moorSubsamplingScaleImageView, Context context, IMoorDecoderFactory<? extends IMoorImageRegionDecoder> iMoorDecoderFactory, Uri uri) {
            this.viewRef = new WeakReference<>(moorSubsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(iMoorDecoderFactory);
            this.source = uri;
        }

        @Override // android.os.AsyncTask
        public int[] doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = this.contextRef.get();
                IMoorDecoderFactory<? extends IMoorImageRegionDecoder> iMoorDecoderFactory = this.decoderFactoryRef.get();
                MoorSubsamplingScaleImageView moorSubsamplingScaleImageView = this.viewRef.get();
                if (context == null || iMoorDecoderFactory == null || moorSubsamplingScaleImageView == null) {
                    return null;
                }
                moorSubsamplingScaleImageView.debug("TilesInitTask.doInBackground", new Object[0]);
                IMoorImageRegionDecoder make = iMoorDecoderFactory.make();
                this.decoder = make;
                Point init = make.init(context, this.source);
                int i2 = init.x;
                int i3 = init.y;
                int exifOrientation = moorSubsamplingScaleImageView.getExifOrientation(context, uri);
                if (moorSubsamplingScaleImageView.sRegion != null) {
                    moorSubsamplingScaleImageView.sRegion.left = Math.max(0, moorSubsamplingScaleImageView.sRegion.left);
                    moorSubsamplingScaleImageView.sRegion.top = Math.max(0, moorSubsamplingScaleImageView.sRegion.top);
                    moorSubsamplingScaleImageView.sRegion.right = Math.min(i2, moorSubsamplingScaleImageView.sRegion.right);
                    moorSubsamplingScaleImageView.sRegion.bottom = Math.min(i3, moorSubsamplingScaleImageView.sRegion.bottom);
                    i2 = moorSubsamplingScaleImageView.sRegion.width();
                    i3 = moorSubsamplingScaleImageView.sRegion.height();
                }
                return new int[]{i2, i3, exifOrientation};
            } catch (Exception e2) {
                Log.e(MoorSubsamplingScaleImageView.TAG, "Failed to initialise bitmap decoder", e2);
                this.exception = e2;
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(int[] iArr) {
            MoorSubsamplingScaleImageView moorSubsamplingScaleImageView = this.viewRef.get();
            if (moorSubsamplingScaleImageView != null) {
                IMoorImageRegionDecoder iMoorImageRegionDecoder = this.decoder;
                if (iMoorImageRegionDecoder != null && iArr != null && iArr.length == 3) {
                    moorSubsamplingScaleImageView.onTilesInited(iMoorImageRegionDecoder, iArr[0], iArr[1], iArr[2]);
                } else if (this.exception == null || moorSubsamplingScaleImageView.onImageEventListener == null) {
                } else {
                    moorSubsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    public MoorSubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        this.orientation = 0;
        this.maxScale = 2.0f;
        this.minScale = minScale();
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 1;
        this.maxTileWidth = Integer.MAX_VALUE;
        this.maxTileHeight = Integer.MAX_VALUE;
        this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
        this.eagerLoadingEnabled = true;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = 500;
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.bitmapDecoderFactory = new MoorCompatDecoderFactory(MoorSkiaImageDecoder.class);
        this.regionDecoderFactory = new MoorCompatDecoderFactory(MoorSkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        this.density = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.handler = new Handler(new Handler.Callback() { // from class: com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == 1 && MoorSubsamplingScaleImageView.this.onLongClickListener != null) {
                    MoorSubsamplingScaleImageView.this.maxTouchCount = 0;
                    MoorSubsamplingScaleImageView moorSubsamplingScaleImageView = MoorSubsamplingScaleImageView.this;
                    MoorSubsamplingScaleImageView.super.setOnLongClickListener(moorSubsamplingScaleImageView.onLongClickListener);
                    MoorSubsamplingScaleImageView.this.performLongClick();
                    MoorSubsamplingScaleImageView.super.setOnLongClickListener(null);
                }
                return true;
            }
        });
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ykfsdk_SubsamplingScaleImageView);
            int i2 = R.styleable.ykfsdk_SubsamplingScaleImageView_ykfsdk_assetName;
            if (obtainStyledAttributes.hasValue(i2) && (string = obtainStyledAttributes.getString(i2)) != null && string.length() > 0) {
                setImage(MoorImageSource.asset(string).tilingEnabled());
            }
            int i3 = R.styleable.ykfsdk_SubsamplingScaleImageView_ykfsdk_src;
            if (obtainStyledAttributes.hasValue(i3) && (resourceId = obtainStyledAttributes.getResourceId(i3, 0)) > 0) {
                setImage(MoorImageSource.resource(resourceId).tilingEnabled());
            }
            int i4 = R.styleable.ykfsdk_SubsamplingScaleImageView_ykfsdk_panEnabled;
            if (obtainStyledAttributes.hasValue(i4)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(i4, true));
            }
            int i5 = R.styleable.ykfsdk_SubsamplingScaleImageView_ykfsdk_zoomEnabled;
            if (obtainStyledAttributes.hasValue(i5)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(i5, true));
            }
            int i6 = R.styleable.ykfsdk_SubsamplingScaleImageView_ykfsdk_quickScaleEnabled;
            if (obtainStyledAttributes.hasValue(i6)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(i6, true));
            }
            int i7 = R.styleable.ykfsdk_SubsamplingScaleImageView_ykfsdk_tileBackgroundColor;
            if (obtainStyledAttributes.hasValue(i7)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(i7, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private int calculateInSampleSize(float f2) {
        int round;
        if (this.minimumTileDpi > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f2 *= this.minimumTileDpi / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int sWidth = (int) (sWidth() * f2);
        int sHeight = (int) (sHeight() * f2);
        if (sWidth == 0 || sHeight == 0) {
            return 32;
        }
        int i2 = 1;
        if (sHeight() > sHeight || sWidth() > sWidth) {
            round = Math.round(sHeight() / sHeight);
            int round2 = Math.round(sWidth() / sWidth);
            if (round >= round2) {
                round = round2;
            }
        } else {
            round = 1;
        }
        while (true) {
            int i3 = i2 * 2;
            if (i3 >= round) {
                return i2;
            }
            i2 = i3;
        }
    }

    private boolean checkImageLoaded() {
        boolean isBaseLayerReady = isBaseLayerReady();
        if (!this.imageLoadedSent && isBaseLayerReady) {
            preDraw();
            this.imageLoadedSent = true;
            onImageLoaded();
            OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null) {
                onImageEventListener.onImageLoaded();
            }
        }
        return isBaseLayerReady;
    }

    private boolean checkReady() {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.sWidth > 0 && this.sHeight > 0 && (this.bitmap != null || isBaseLayerReady());
        if (!this.readySent && z) {
            preDraw();
            this.readySent = true;
            onReady();
            OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null) {
                onImageEventListener.onReady();
            }
        }
        return z;
    }

    private void createPaints() {
        if (this.bitmapPaint == null) {
            Paint paint = new Paint();
            this.bitmapPaint = paint;
            paint.setAntiAlias(true);
            this.bitmapPaint.setFilterBitmap(true);
            this.bitmapPaint.setDither(true);
        }
        if ((this.debugTextPaint == null || this.debugLinePaint == null) && this.debug) {
            Paint paint2 = new Paint();
            this.debugTextPaint = paint2;
            paint2.setTextSize(px(12));
            this.debugTextPaint.setColor(-65281);
            this.debugTextPaint.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.debugLinePaint = paint3;
            paint3.setColor(-65281);
            this.debugLinePaint.setStyle(Paint.Style.STROKE);
            this.debugLinePaint.setStrokeWidth(px(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void debug(String str, Object... objArr) {
        if (this.debug) {
            Log.d(TAG, String.format(str, objArr));
        }
    }

    private float distance(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f3;
        float f7 = f4 - f5;
        return (float) Math.sqrt((f6 * f6) + (f7 * f7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doubleTapZoom(PointF pointF, PointF pointF2) {
        if (!this.panEnabled) {
            PointF pointF3 = this.sRequestedCenter;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = pointF3.y;
            } else {
                pointF.x = sWidth() / 2;
                pointF.y = sHeight() / 2;
            }
        }
        float min = Math.min(this.maxScale, this.doubleTapZoomScale);
        float f2 = this.scale;
        boolean z = ((double) f2) <= ((double) min) * 0.9d || f2 == this.minScale;
        if (!z) {
            min = minScale();
        }
        float f3 = min;
        int i2 = this.doubleTapZoomStyle;
        if (i2 == 3) {
            setScaleAndCenter(f3, pointF);
        } else if (i2 == 2 || !z || !this.panEnabled) {
            new AnimationBuilder(f3, pointF).withInterruptible(false).withDuration(this.doubleTapZoomDuration).withOrigin(4).start();
        } else if (i2 == 1) {
            new AnimationBuilder(f3, pointF, pointF2).withInterruptible(false).withDuration(this.doubleTapZoomDuration).withOrigin(4).start();
        }
        invalidate();
    }

    private float ease(int i2, long j2, float f2, float f3, long j3) {
        if (i2 != 1) {
            if (i2 == 2) {
                return easeInOutQuad(j2, f2, f3, j3);
            }
            throw new IllegalStateException("Unexpected easing type: " + i2);
        }
        return easeOutQuad(j2, f2, f3, j3);
    }

    private float easeInOutQuad(long j2, float f2, float f3, long j3) {
        float f4;
        float f5 = ((float) j2) / (((float) j3) / 2.0f);
        if (f5 < 1.0f) {
            f4 = (f3 / 2.0f) * f5;
        } else {
            float f6 = f5 - 1.0f;
            f4 = (-f3) / 2.0f;
            f5 = (f6 * (f6 - 2.0f)) - 1.0f;
        }
        return (f4 * f5) + f2;
    }

    private float easeOutQuad(long j2, float f2, float f3, long j3) {
        float f4 = ((float) j2) / ((float) j3);
        return ((-f3) * f4 * (f4 - 2.0f)) + f2;
    }

    private void execute(AsyncTask<Void, Void, ?> asyncTask) {
        asyncTask.executeOnExecutor(this.executor, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void fileSRect(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
        } else if (getRequiredRotation() == 90) {
            int i2 = rect.top;
            int i3 = this.sHeight;
            rect2.set(i2, i3 - rect.right, rect.bottom, i3 - rect.left);
        } else if (getRequiredRotation() == 180) {
            int i4 = this.sWidth;
            int i5 = this.sHeight;
            rect2.set(i4 - rect.right, i5 - rect.bottom, i4 - rect.left, i5 - rect.top);
        } else {
            int i6 = this.sWidth;
            rect2.set(i6 - rect.bottom, rect.left, i6 - rect.top, rect.right);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fitToBounds(boolean z, ScaleAndTranslate scaleAndTranslate) {
        float max;
        int max2;
        float max3;
        if (this.panLimit == 2 && isReady()) {
            z = false;
        }
        PointF pointF = scaleAndTranslate.vTranslate;
        float limitedScale = limitedScale(scaleAndTranslate.scale);
        float sWidth = sWidth() * limitedScale;
        float sHeight = sHeight() * limitedScale;
        if (this.panLimit == 3 && isReady()) {
            pointF.x = Math.max(pointF.x, (getWidth() / 2) - sWidth);
            pointF.y = Math.max(pointF.y, (getHeight() / 2) - sHeight);
        } else if (z) {
            pointF.x = Math.max(pointF.x, getWidth() - sWidth);
            pointF.y = Math.max(pointF.y, getHeight() - sHeight);
        } else {
            pointF.x = Math.max(pointF.x, -sWidth);
            pointF.y = Math.max(pointF.y, -sHeight);
        }
        float f2 = 0.5f;
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? getPaddingLeft() / (getPaddingLeft() + getPaddingRight()) : 0.5f;
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f2 = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
        }
        if (this.panLimit == 3 && isReady()) {
            max = Math.max(0, getWidth() / 2);
            max2 = Math.max(0, getHeight() / 2);
        } else if (z) {
            max = Math.max(0.0f, (getWidth() - sWidth) * paddingLeft);
            max3 = Math.max(0.0f, (getHeight() - sHeight) * f2);
            pointF.x = Math.min(pointF.x, max);
            pointF.y = Math.min(pointF.y, max3);
            scaleAndTranslate.scale = limitedScale;
        } else {
            max = Math.max(0, getWidth());
            max2 = Math.max(0, getHeight());
        }
        max3 = max2;
        pointF.x = Math.min(pointF.x, max);
        pointF.y = Math.min(pointF.y, max3);
        scaleAndTranslate.scale = limitedScale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public int getExifOrientation(Context context, String str) {
        int i2 = 0;
        if (str.startsWith("content")) {
            Cursor cursor = null;
            try {
                try {
                    cursor = context.getContentResolver().query(Uri.parse(str), new String[]{"orientation"}, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        int i3 = cursor.getInt(0);
                        if (!VALID_ORIENTATIONS.contains(Integer.valueOf(i3)) || i3 == -1) {
                            String str2 = TAG;
                            Log.w(str2, "Unsupported orientation: " + i3);
                        } else {
                            i2 = i3;
                        }
                    }
                    if (cursor == null) {
                        return i2;
                    }
                } catch (Exception unused) {
                    Log.w(TAG, "Could not get orientation of image from media store");
                    if (cursor == null) {
                        return 0;
                    }
                }
                cursor.close();
                return i2;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } else if (!str.startsWith(MoorImageSource.FILE_SCHEME) || str.startsWith(MoorImageSource.ASSET_SCHEME)) {
            return 0;
        } else {
            try {
                int attributeInt = new ExifInterface(str.substring(7)).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
                if (attributeInt != 1 && attributeInt != 0) {
                    if (attributeInt == 6) {
                        return 90;
                    }
                    if (attributeInt == 3) {
                        return 180;
                    }
                    if (attributeInt == 8) {
                        return 270;
                    }
                    String str3 = TAG;
                    Log.w(str3, "Unsupported EXIF orientation: " + attributeInt);
                    return 0;
                }
                return 0;
            } catch (Exception unused2) {
                Log.w(TAG, "Could not get EXIF orientation of image");
                return 0;
            }
        }
    }

    @NonNull
    private Point getMaxBitmapDimensions(Canvas canvas) {
        return new Point(Math.min(canvas.getMaximumBitmapWidth(), this.maxTileWidth), Math.min(canvas.getMaximumBitmapHeight(), this.maxTileHeight));
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return preferredBitmapConfig;
    }

    @AnyThread
    private int getRequiredRotation() {
        int i2 = this.orientation;
        return i2 == -1 ? this.sOrientation : i2;
    }

    private synchronized void initialiseBaseLayer(@NonNull Point point) {
        debug("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        this.satTemp = scaleAndTranslate;
        fitToBounds(true, scaleAndTranslate);
        int calculateInSampleSize = calculateInSampleSize(this.satTemp.scale);
        this.fullImageSampleSize = calculateInSampleSize;
        if (calculateInSampleSize > 1) {
            this.fullImageSampleSize = calculateInSampleSize / 2;
        }
        if (this.fullImageSampleSize == 1 && this.sRegion == null && sWidth() < point.x && sHeight() < point.y) {
            this.decoder.recycle();
            this.decoder = null;
            execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
        } else {
            initialiseTileMap(point);
            for (Tile tile : this.tileMap.get(Integer.valueOf(this.fullImageSampleSize))) {
                execute(new TileLoadTask(this, this.decoder, tile));
            }
            refreshRequiredTiles(true);
        }
    }

    private void initialiseTileMap(Point point) {
        int i2 = 1;
        debug("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.tileMap = new LinkedHashMap();
        int i3 = this.fullImageSampleSize;
        int i4 = 1;
        int i5 = 1;
        while (true) {
            int sWidth = sWidth() / i4;
            int sHeight = sHeight() / i5;
            int i6 = sWidth / i3;
            int i7 = sHeight / i3;
            while (true) {
                if (i6 + i4 + i2 > point.x || (i6 > getWidth() * 1.25d && i3 < this.fullImageSampleSize)) {
                    i4++;
                    sWidth = sWidth() / i4;
                    i6 = sWidth / i3;
                    i2 = 1;
                }
            }
            while (true) {
                if (i7 + i5 + i2 > point.y || (i7 > getHeight() * 1.25d && i3 < this.fullImageSampleSize)) {
                    i5++;
                    sHeight = sHeight() / i5;
                    i7 = sHeight / i3;
                    i2 = 1;
                }
            }
            ArrayList arrayList = new ArrayList(i4 * i5);
            int i8 = 0;
            while (i8 < i4) {
                int i9 = 0;
                while (i9 < i5) {
                    Tile tile = new Tile();
                    tile.sampleSize = i3;
                    tile.visible = i3 == this.fullImageSampleSize;
                    tile.sRect = new Rect(i8 * sWidth, i9 * sHeight, i8 == i4 + (-1) ? sWidth() : (i8 + 1) * sWidth, i9 == i5 + (-1) ? sHeight() : (i9 + 1) * sHeight);
                    tile.vRect = new Rect(0, 0, 0, 0);
                    tile.fileSRect = new Rect(tile.sRect);
                    arrayList.add(tile);
                    i9++;
                }
                i8++;
            }
            this.tileMap.put(Integer.valueOf(i3), arrayList);
            if (i3 == 1) {
                return;
            }
            i3 /= 2;
            i2 = 1;
        }
    }

    private boolean isBaseLayerReady() {
        boolean z = true;
        if (this.bitmap == null || this.bitmapIsPreview) {
            Map<Integer, List<Tile>> map = this.tileMap;
            if (map != null) {
                for (Map.Entry<Integer, List<Tile>> entry : map.entrySet()) {
                    if (entry.getKey().intValue() == this.fullImageSampleSize) {
                        for (Tile tile : entry.getValue()) {
                            if (tile.loading || tile.bitmap == null) {
                                z = false;
                            }
                        }
                    }
                }
                return z;
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public PointF limitedSCenter(float f2, float f3, float f4, @NonNull PointF pointF) {
        PointF vTranslateForSCenter = vTranslateForSCenter(f2, f3, f4);
        pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - vTranslateForSCenter.x) / f4, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - vTranslateForSCenter.y) / f4);
        return pointF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float limitedScale(float f2) {
        return Math.min(this.maxScale, Math.max(minScale(), f2));
    }

    private float minScale() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i2 = this.minimumScaleType;
        if (i2 != 2 && i2 != 4) {
            if (i2 == 3) {
                float f2 = this.minScale;
                if (f2 > 0.0f) {
                    return f2;
                }
            }
            return Math.min((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
        }
        return Math.max((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onImageLoaded(Bitmap bitmap, int i2, boolean z) {
        OnImageEventListener onImageEventListener;
        debug("onImageLoaded", new Object[0]);
        int i3 = this.sWidth;
        if (i3 > 0 && this.sHeight > 0 && (i3 != bitmap.getWidth() || this.sHeight != bitmap.getHeight())) {
            reset(false);
        }
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null && !this.bitmapIsCached) {
            bitmap2.recycle();
        }
        if (this.bitmap != null && this.bitmapIsCached && (onImageEventListener = this.onImageEventListener) != null) {
            onImageEventListener.onPreviewReleased();
        }
        this.bitmapIsPreview = false;
        this.bitmapIsCached = z;
        this.bitmap = bitmap;
        this.sWidth = bitmap.getWidth();
        this.sHeight = bitmap.getHeight();
        this.sOrientation = i2;
        boolean checkReady = checkReady();
        boolean checkImageLoaded = checkImageLoaded();
        if (checkReady || checkImageLoaded) {
            invalidate();
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onPreviewLoaded(Bitmap bitmap) {
        debug("onPreviewLoaded", new Object[0]);
        if (this.bitmap == null && !this.imageLoadedSent) {
            Rect rect = this.pRegion;
            if (rect != null) {
                this.bitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), this.pRegion.height());
            } else {
                this.bitmap = bitmap;
            }
            this.bitmapIsPreview = true;
            if (checkReady()) {
                invalidate();
                requestLayout();
            }
            return;
        }
        bitmap.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTileLoaded() {
        Bitmap bitmap;
        debug("onTileLoaded", new Object[0]);
        checkReady();
        checkImageLoaded();
        if (isBaseLayerReady() && (bitmap = this.bitmap) != null) {
            if (!this.bitmapIsCached) {
                bitmap.recycle();
            }
            this.bitmap = null;
            OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null && this.bitmapIsCached) {
                onImageEventListener.onPreviewReleased();
            }
            this.bitmapIsPreview = false;
            this.bitmapIsCached = false;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTilesInited(IMoorImageRegionDecoder iMoorImageRegionDecoder, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        debug("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.orientation));
        int i8 = this.sWidth;
        if (i8 > 0 && (i7 = this.sHeight) > 0 && (i8 != i2 || i7 != i3)) {
            reset(false);
            Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                if (!this.bitmapIsCached) {
                    bitmap.recycle();
                }
                this.bitmap = null;
                OnImageEventListener onImageEventListener = this.onImageEventListener;
                if (onImageEventListener != null && this.bitmapIsCached) {
                    onImageEventListener.onPreviewReleased();
                }
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            }
        }
        this.decoder = iMoorImageRegionDecoder;
        this.sWidth = i2;
        this.sHeight = i3;
        this.sOrientation = i4;
        checkReady();
        if (!checkImageLoaded() && (i5 = this.maxTileWidth) > 0 && i5 != Integer.MAX_VALUE && (i6 = this.maxTileHeight) > 0 && i6 != Integer.MAX_VALUE && getWidth() > 0 && getHeight() > 0) {
            initialiseBaseLayer(new Point(this.maxTileWidth, this.maxTileHeight));
        }
        invalidate();
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if (r1 != 262) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean onTouchEventInternal(@androidx.annotation.NonNull android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 1202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.onTouchEventInternal(android.view.MotionEvent):boolean");
    }

    private void preDraw() {
        Float f2;
        if (getWidth() == 0 || getHeight() == 0 || this.sWidth <= 0 || this.sHeight <= 0) {
            return;
        }
        if (this.sPendingCenter != null && (f2 = this.pendingScale) != null) {
            this.scale = f2.floatValue();
            if (this.vTranslate == null) {
                this.vTranslate = new PointF();
            }
            this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sPendingCenter.x);
            this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sPendingCenter.y);
            this.sPendingCenter = null;
            this.pendingScale = null;
            fitToBounds(true);
            refreshRequiredTiles(true);
        }
        fitToBounds(false);
    }

    private int px(int i2) {
        return (int) (this.density * i2);
    }

    private void refreshRequiredTiles(boolean z) {
        if (this.decoder == null || this.tileMap == null) {
            return;
        }
        int min = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
        for (Map.Entry<Integer, List<Tile>> entry : this.tileMap.entrySet()) {
            for (Tile tile : entry.getValue()) {
                if (tile.sampleSize < min || (tile.sampleSize > min && tile.sampleSize != this.fullImageSampleSize)) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
                if (tile.sampleSize != min) {
                    if (tile.sampleSize == this.fullImageSampleSize) {
                        tile.visible = true;
                    }
                } else if (tileVisible(tile)) {
                    tile.visible = true;
                    if (!tile.loading && tile.bitmap == null && z) {
                        execute(new TileLoadTask(this, this.decoder, tile));
                    }
                } else if (tile.sampleSize != this.fullImageSampleSize) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
            }
        }
    }

    private void requestDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private void reset(boolean z) {
        OnImageEventListener onImageEventListener;
        debug("reset newImage=" + z, new Object[0]);
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.vTranslateBefore = null;
        this.pendingScale = Float.valueOf(0.0f);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleMoved = false;
        this.quickScaleSCenter = null;
        this.quickScaleVLastPoint = null;
        this.quickScaleVStart = null;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (z) {
            this.uri = null;
            this.decoderLock.writeLock().lock();
            try {
                IMoorImageRegionDecoder iMoorImageRegionDecoder = this.decoder;
                if (iMoorImageRegionDecoder != null) {
                    iMoorImageRegionDecoder.recycle();
                    this.decoder = null;
                }
                this.decoderLock.writeLock().unlock();
                Bitmap bitmap = this.bitmap;
                if (bitmap != null && !this.bitmapIsCached) {
                    bitmap.recycle();
                }
                if (this.bitmap != null && this.bitmapIsCached && (onImageEventListener = this.onImageEventListener) != null) {
                    onImageEventListener.onPreviewReleased();
                }
                this.sWidth = 0;
                this.sHeight = 0;
                this.sOrientation = 0;
                this.sRegion = null;
                this.pRegion = null;
                this.readySent = false;
                this.imageLoadedSent = false;
                this.bitmap = null;
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            } catch (Throwable th) {
                this.decoderLock.writeLock().unlock();
                throw th;
            }
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map != null) {
            for (Map.Entry<Integer, List<Tile>> entry : map.entrySet()) {
                for (Tile tile : entry.getValue()) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
            }
            this.tileMap = null;
        }
        setGestureDetector(getContext());
    }

    private void restoreState(MoorImageViewState moorImageViewState) {
        if (moorImageViewState == null || !VALID_ORIENTATIONS.contains(Integer.valueOf(moorImageViewState.getOrientation()))) {
            return;
        }
        this.orientation = moorImageViewState.getOrientation();
        this.pendingScale = Float.valueOf(moorImageViewState.getScale());
        this.sPendingCenter = moorImageViewState.getCenter();
        invalidate();
    }

    private int sHeight() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation != 90 && requiredRotation != 270) {
            return this.sHeight;
        }
        return this.sWidth;
    }

    private int sWidth() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation != 90 && requiredRotation != 270) {
            return this.sWidth;
        }
        return this.sHeight;
    }

    private void sendStateChanged(float f2, PointF pointF, int i2) {
        OnStateChangedListener onStateChangedListener = this.onStateChangedListener;
        if (onStateChangedListener != null) {
            float f3 = this.scale;
            if (f3 != f2) {
                onStateChangedListener.onScaleChanged(f3, i2);
            }
        }
        if (this.onStateChangedListener == null || this.vTranslate.equals(pointF)) {
            return;
        }
        this.onStateChangedListener.onCenterChanged(getCenter(), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(final Context context) {
        this.detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (MoorSubsamplingScaleImageView.this.zoomEnabled && MoorSubsamplingScaleImageView.this.readySent && MoorSubsamplingScaleImageView.this.vTranslate != null) {
                    MoorSubsamplingScaleImageView.this.setGestureDetector(context);
                    if (MoorSubsamplingScaleImageView.this.quickScaleEnabled) {
                        MoorSubsamplingScaleImageView.this.vCenterStart = new PointF(motionEvent.getX(), motionEvent.getY());
                        MoorSubsamplingScaleImageView.this.vTranslateStart = new PointF(MoorSubsamplingScaleImageView.this.vTranslate.x, MoorSubsamplingScaleImageView.this.vTranslate.y);
                        MoorSubsamplingScaleImageView moorSubsamplingScaleImageView = MoorSubsamplingScaleImageView.this;
                        moorSubsamplingScaleImageView.scaleStart = moorSubsamplingScaleImageView.scale;
                        MoorSubsamplingScaleImageView.this.isQuickScaling = true;
                        MoorSubsamplingScaleImageView.this.isZooming = true;
                        MoorSubsamplingScaleImageView.this.quickScaleLastDistance = -1.0f;
                        MoorSubsamplingScaleImageView moorSubsamplingScaleImageView2 = MoorSubsamplingScaleImageView.this;
                        moorSubsamplingScaleImageView2.quickScaleSCenter = moorSubsamplingScaleImageView2.viewToSourceCoord(moorSubsamplingScaleImageView2.vCenterStart);
                        MoorSubsamplingScaleImageView.this.quickScaleVStart = new PointF(motionEvent.getX(), motionEvent.getY());
                        MoorSubsamplingScaleImageView.this.quickScaleVLastPoint = new PointF(MoorSubsamplingScaleImageView.this.quickScaleSCenter.x, MoorSubsamplingScaleImageView.this.quickScaleSCenter.y);
                        MoorSubsamplingScaleImageView.this.quickScaleMoved = false;
                        return false;
                    }
                    MoorSubsamplingScaleImageView moorSubsamplingScaleImageView3 = MoorSubsamplingScaleImageView.this;
                    moorSubsamplingScaleImageView3.doubleTapZoom(moorSubsamplingScaleImageView3.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                    return true;
                }
                return super.onDoubleTapEvent(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (MoorSubsamplingScaleImageView.this.panEnabled && MoorSubsamplingScaleImageView.this.readySent && MoorSubsamplingScaleImageView.this.vTranslate != null && motionEvent != null && motionEvent2 != null && ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 50.0f || Math.abs(motionEvent.getY() - motionEvent2.getY()) > 50.0f) && ((Math.abs(f2) > 500.0f || Math.abs(f3) > 500.0f) && !MoorSubsamplingScaleImageView.this.isZooming))) {
                    PointF pointF = new PointF(MoorSubsamplingScaleImageView.this.vTranslate.x + (f2 * 0.25f), MoorSubsamplingScaleImageView.this.vTranslate.y + (f3 * 0.25f));
                    new AnimationBuilder(new PointF(((MoorSubsamplingScaleImageView.this.getWidth() / 2) - pointF.x) / MoorSubsamplingScaleImageView.this.scale, ((MoorSubsamplingScaleImageView.this.getHeight() / 2) - pointF.y) / MoorSubsamplingScaleImageView.this.scale)).withEasing(1).withPanLimited(false).withOrigin(3).start();
                    return true;
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                MoorSubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
        this.singleDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                MoorSubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
    }

    private void setMatrixArray(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        fArr[3] = f5;
        fArr[4] = f6;
        fArr[5] = f7;
        fArr[6] = f8;
        fArr[7] = f9;
    }

    public static void setPreferredBitmapConfig(Bitmap.Config config) {
        preferredBitmapConfig = config;
    }

    private void sourceToViewRect(@NonNull Rect rect, @NonNull Rect rect2) {
        rect2.set((int) sourceToViewX(rect.left), (int) sourceToViewY(rect.top), (int) sourceToViewX(rect.right), (int) sourceToViewY(rect.bottom));
    }

    private float sourceToViewX(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.scale) + pointF.x;
    }

    private float sourceToViewY(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.scale) + pointF.y;
    }

    private boolean tileVisible(Tile tile) {
        return viewToSourceX(0.0f) <= ((float) tile.sRect.right) && ((float) tile.sRect.left) <= viewToSourceX((float) getWidth()) && viewToSourceY(0.0f) <= ((float) tile.sRect.bottom) && ((float) tile.sRect.top) <= viewToSourceY((float) getHeight());
    }

    @NonNull
    private PointF vTranslateForSCenter(float f2, float f3, float f4) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        this.satTemp.scale = f4;
        this.satTemp.vTranslate.set(paddingLeft - (f2 * f4), paddingTop - (f3 * f4));
        fitToBounds(true, this.satTemp);
        return this.satTemp.vTranslate;
    }

    private float viewToSourceX(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.x) / this.scale;
    }

    private float viewToSourceY(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.y) / this.scale;
    }

    @Nullable
    public AnimationBuilder animateCenter(PointF pointF) {
        if (isReady()) {
            return new AnimationBuilder(pointF);
        }
        return null;
    }

    @Nullable
    public AnimationBuilder animateScale(float f2) {
        if (isReady()) {
            return new AnimationBuilder(f2);
        }
        return null;
    }

    @Nullable
    public AnimationBuilder animateScaleAndCenter(float f2, PointF pointF) {
        if (isReady()) {
            return new AnimationBuilder(f2, pointF);
        }
        return null;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    @Nullable
    public final PointF getCenter() {
        return viewToSourceCoord(getWidth() / 2, getHeight() / 2);
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return minScale();
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final void getPanRemaining(RectF rectF) {
        if (isReady()) {
            float sWidth = this.scale * sWidth();
            float sHeight = this.scale * sHeight();
            int i2 = this.panLimit;
            if (i2 == 3) {
                rectF.top = Math.max(0.0f, -(this.vTranslate.y - (getHeight() / 2)));
                rectF.left = Math.max(0.0f, -(this.vTranslate.x - (getWidth() / 2)));
                rectF.bottom = Math.max(0.0f, this.vTranslate.y - ((getHeight() / 2) - sHeight));
                rectF.right = Math.max(0.0f, this.vTranslate.x - ((getWidth() / 2) - sWidth));
            } else if (i2 == 2) {
                rectF.top = Math.max(0.0f, -(this.vTranslate.y - getHeight()));
                rectF.left = Math.max(0.0f, -(this.vTranslate.x - getWidth()));
                rectF.bottom = Math.max(0.0f, this.vTranslate.y + sHeight);
                rectF.right = Math.max(0.0f, this.vTranslate.x + sWidth);
            } else {
                rectF.top = Math.max(0.0f, -this.vTranslate.y);
                rectF.left = Math.max(0.0f, -this.vTranslate.x);
                rectF.bottom = Math.max(0.0f, (sHeight + this.vTranslate.y) - getHeight());
                rectF.right = Math.max(0.0f, (sWidth + this.vTranslate.x) - getWidth());
            }
        }
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final float getScale() {
        return this.scale;
    }

    @Nullable
    public final MoorImageViewState getState() {
        if (this.vTranslate == null || this.sWidth <= 0 || this.sHeight <= 0) {
            return null;
        }
        return new MoorImageViewState(getScale(), getCenter(), getOrientation());
    }

    public boolean hasImage() {
        return (this.uri == null && this.bitmap == null) ? false : true;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        int i3;
        float f2;
        super.onDraw(canvas);
        createPaints();
        if (this.sWidth == 0 || this.sHeight == 0 || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (this.tileMap == null && this.decoder != null) {
            initialiseBaseLayer(getMaxBitmapDimensions(canvas));
        }
        if (checkReady()) {
            preDraw();
            Anim anim = this.anim;
            if (anim != null && anim.vFocusStart != null) {
                float f3 = this.scale;
                if (this.vTranslateBefore == null) {
                    this.vTranslateBefore = new PointF(0.0f, 0.0f);
                }
                this.vTranslateBefore.set(this.vTranslate);
                long currentTimeMillis = System.currentTimeMillis() - this.anim.time;
                boolean z = currentTimeMillis > this.anim.duration;
                long min = Math.min(currentTimeMillis, this.anim.duration);
                this.scale = ease(this.anim.easing, min, this.anim.scaleStart, this.anim.scaleEnd - this.anim.scaleStart, this.anim.duration);
                float ease = ease(this.anim.easing, min, this.anim.vFocusStart.x, this.anim.vFocusEnd.x - this.anim.vFocusStart.x, this.anim.duration);
                float ease2 = ease(this.anim.easing, min, this.anim.vFocusStart.y, this.anim.vFocusEnd.y - this.anim.vFocusStart.y, this.anim.duration);
                this.vTranslate.x -= sourceToViewX(this.anim.sCenterEnd.x) - ease;
                this.vTranslate.y -= sourceToViewY(this.anim.sCenterEnd.y) - ease2;
                fitToBounds(z || this.anim.scaleStart == this.anim.scaleEnd);
                sendStateChanged(f3, this.vTranslateBefore, this.anim.origin);
                refreshRequiredTiles(z);
                if (z) {
                    if (this.anim.listener != null) {
                        try {
                            this.anim.listener.onComplete();
                        } catch (Exception e2) {
                            Log.w(TAG, "Error thrown by animation listener", e2);
                        }
                    }
                    this.anim = null;
                }
                invalidate();
            }
            if (this.tileMap != null && isBaseLayerReady()) {
                int min2 = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
                boolean z2 = false;
                for (Map.Entry<Integer, List<Tile>> entry : this.tileMap.entrySet()) {
                    if (entry.getKey().intValue() == min2) {
                        for (Tile tile : entry.getValue()) {
                            if (tile.visible && (tile.loading || tile.bitmap == null)) {
                                z2 = true;
                            }
                        }
                    }
                }
                for (Map.Entry<Integer, List<Tile>> entry2 : this.tileMap.entrySet()) {
                    if (entry2.getKey().intValue() == min2 || z2) {
                        for (Tile tile2 : entry2.getValue()) {
                            sourceToViewRect(tile2.sRect, tile2.vRect);
                            if (tile2.loading || tile2.bitmap == null) {
                                if (tile2.loading && this.debug) {
                                    canvas.drawText("LOADING", tile2.vRect.left + px(5), tile2.vRect.top + px(35), this.debugTextPaint);
                                    if (!tile2.visible && this.debug) {
                                        canvas.drawText("ISS " + tile2.sampleSize + " RECT " + tile2.sRect.top + Constants.ACCEPT_TIME_SEPARATOR_SP + tile2.sRect.left + Constants.ACCEPT_TIME_SEPARATOR_SP + tile2.sRect.bottom + Constants.ACCEPT_TIME_SEPARATOR_SP + tile2.sRect.right, tile2.vRect.left + px(5), tile2.vRect.top + px(15), this.debugTextPaint);
                                    }
                                }
                            } else {
                                if (this.tileBgPaint != null) {
                                    canvas.drawRect(tile2.vRect, this.tileBgPaint);
                                }
                                if (this.matrix == null) {
                                    this.matrix = new Matrix();
                                }
                                this.matrix.reset();
                                setMatrixArray(this.srcArray, 0.0f, 0.0f, tile2.bitmap.getWidth(), 0.0f, tile2.bitmap.getWidth(), tile2.bitmap.getHeight(), 0.0f, tile2.bitmap.getHeight());
                                if (getRequiredRotation() == 0) {
                                    setMatrixArray(this.dstArray, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom);
                                } else if (getRequiredRotation() == 90) {
                                    setMatrixArray(this.dstArray, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top);
                                } else if (getRequiredRotation() == 180) {
                                    setMatrixArray(this.dstArray, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top);
                                } else if (getRequiredRotation() == 270) {
                                    setMatrixArray(this.dstArray, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom);
                                }
                                this.matrix.setPolyToPoly(this.srcArray, 0, this.dstArray, 0, 4);
                                canvas.drawBitmap(tile2.bitmap, this.matrix, this.bitmapPaint);
                                if (this.debug) {
                                    canvas.drawRect(tile2.vRect, this.debugLinePaint);
                                }
                            }
                            if (!tile2.visible) {
                            }
                        }
                    }
                }
                i2 = 35;
                i3 = 15;
            } else {
                i2 = 35;
                i3 = 15;
                Bitmap bitmap = this.bitmap;
                if (bitmap != null && !bitmap.isRecycled()) {
                    float f4 = this.scale;
                    if (this.bitmapIsPreview) {
                        f4 *= this.sWidth / this.bitmap.getWidth();
                        f2 = this.scale * (this.sHeight / this.bitmap.getHeight());
                    } else {
                        f2 = f4;
                    }
                    if (this.matrix == null) {
                        this.matrix = new Matrix();
                    }
                    this.matrix.reset();
                    this.matrix.postScale(f4, f2);
                    this.matrix.postRotate(getRequiredRotation());
                    Matrix matrix = this.matrix;
                    PointF pointF = this.vTranslate;
                    matrix.postTranslate(pointF.x, pointF.y);
                    if (getRequiredRotation() == 180) {
                        Matrix matrix2 = this.matrix;
                        float f5 = this.scale;
                        matrix2.postTranslate(this.sWidth * f5, f5 * this.sHeight);
                    } else if (getRequiredRotation() == 90) {
                        this.matrix.postTranslate(this.scale * this.sHeight, 0.0f);
                    } else if (getRequiredRotation() == 270) {
                        this.matrix.postTranslate(0.0f, this.scale * this.sWidth);
                    }
                    if (this.tileBgPaint != null) {
                        if (this.sRect == null) {
                            this.sRect = new RectF();
                        }
                        this.sRect.set(0.0f, 0.0f, this.bitmapIsPreview ? this.bitmap.getWidth() : this.sWidth, this.bitmapIsPreview ? this.bitmap.getHeight() : this.sHeight);
                        this.matrix.mapRect(this.sRect);
                        canvas.drawRect(this.sRect, this.tileBgPaint);
                    }
                    canvas.drawBitmap(this.bitmap, this.matrix, this.bitmapPaint);
                }
            }
            if (this.debug) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scale: ");
                Locale locale = Locale.ENGLISH;
                sb.append(String.format(locale, "%.2f", Float.valueOf(this.scale)));
                sb.append(" (");
                sb.append(String.format(locale, "%.2f", Float.valueOf(minScale())));
                sb.append(" - ");
                sb.append(String.format(locale, "%.2f", Float.valueOf(this.maxScale)));
                sb.append(")");
                canvas.drawText(sb.toString(), px(5), px(i3), this.debugTextPaint);
                canvas.drawText("Translate: " + String.format(locale, "%.2f", Float.valueOf(this.vTranslate.x)) + Constants.COLON_SEPARATOR + String.format(locale, "%.2f", Float.valueOf(this.vTranslate.y)), px(5), px(30), this.debugTextPaint);
                PointF center = getCenter();
                canvas.drawText("Source center: " + String.format(locale, "%.2f", Float.valueOf(center.x)) + Constants.COLON_SEPARATOR + String.format(locale, "%.2f", Float.valueOf(center.y)), px(5), px(45), this.debugTextPaint);
                Anim anim2 = this.anim;
                if (anim2 != null) {
                    PointF sourceToViewCoord = sourceToViewCoord(anim2.sCenterStart);
                    PointF sourceToViewCoord2 = sourceToViewCoord(this.anim.sCenterEndRequested);
                    PointF sourceToViewCoord3 = sourceToViewCoord(this.anim.sCenterEnd);
                    canvas.drawCircle(sourceToViewCoord.x, sourceToViewCoord.y, px(10), this.debugLinePaint);
                    this.debugLinePaint.setColor(-65536);
                    canvas.drawCircle(sourceToViewCoord2.x, sourceToViewCoord2.y, px(20), this.debugLinePaint);
                    this.debugLinePaint.setColor(-16776961);
                    canvas.drawCircle(sourceToViewCoord3.x, sourceToViewCoord3.y, px(25), this.debugLinePaint);
                    this.debugLinePaint.setColor(-16711681);
                    canvas.drawCircle(getWidth() / 2, getHeight() / 2, px(30), this.debugLinePaint);
                }
                if (this.vCenterStart != null) {
                    this.debugLinePaint.setColor(-65536);
                    PointF pointF2 = this.vCenterStart;
                    canvas.drawCircle(pointF2.x, pointF2.y, px(20), this.debugLinePaint);
                }
                if (this.quickScaleSCenter != null) {
                    this.debugLinePaint.setColor(-16776961);
                    canvas.drawCircle(sourceToViewX(this.quickScaleSCenter.x), sourceToViewY(this.quickScaleSCenter.y), px(i2), this.debugLinePaint);
                }
                if (this.quickScaleVStart != null && this.isQuickScaling) {
                    this.debugLinePaint.setColor(-16711681);
                    PointF pointF3 = this.quickScaleVStart;
                    canvas.drawCircle(pointF3.x, pointF3.y, px(30), this.debugLinePaint);
                }
                this.debugLinePaint.setColor(-65281);
            }
        }
    }

    public void onImageLoaded() {
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        boolean z = mode != 1073741824;
        boolean z2 = mode2 != 1073741824;
        if (this.sWidth > 0 && this.sHeight > 0) {
            if (z && z2) {
                size = sWidth();
                size2 = sHeight();
            } else if (z2) {
                size2 = (int) ((sHeight() / sWidth()) * size);
            } else if (z) {
                size = (int) ((sWidth() / sHeight()) * size2);
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    public void onReady() {
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        debug("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3));
        PointF center = getCenter();
        if (!this.readySent || center == null) {
            return;
        }
        this.anim = null;
        this.pendingScale = Float.valueOf(this.scale);
        this.sPendingCenter = center;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        Anim anim = this.anim;
        if (anim != null && !anim.interruptible) {
            requestDisallowInterceptTouchEvent(true);
            return true;
        }
        Anim anim2 = this.anim;
        if (anim2 != null && anim2.listener != null) {
            try {
                this.anim.listener.onInterruptedByUser();
            } catch (Exception e2) {
                Log.w(TAG, "Error thrown by animation listener", e2);
            }
        }
        this.anim = null;
        if (this.vTranslate == null) {
            GestureDetector gestureDetector2 = this.singleDetector;
            if (gestureDetector2 != null) {
                gestureDetector2.onTouchEvent(motionEvent);
            }
            return true;
        } else if (!this.isQuickScaling && ((gestureDetector = this.detector) == null || gestureDetector.onTouchEvent(motionEvent))) {
            this.isZooming = false;
            this.isPanning = false;
            this.maxTouchCount = 0;
            return true;
        } else {
            if (this.vTranslateStart == null) {
                this.vTranslateStart = new PointF(0.0f, 0.0f);
            }
            if (this.vTranslateBefore == null) {
                this.vTranslateBefore = new PointF(0.0f, 0.0f);
            }
            if (this.vCenterStart == null) {
                this.vCenterStart = new PointF(0.0f, 0.0f);
            }
            float f2 = this.scale;
            this.vTranslateBefore.set(this.vTranslate);
            boolean onTouchEventInternal = onTouchEventInternal(motionEvent);
            sendStateChanged(f2, this.vTranslateBefore, 2);
            return onTouchEventInternal || super.onTouchEvent(motionEvent);
        }
    }

    public void recycle() {
        reset(true);
        this.bitmapPaint = null;
        this.debugTextPaint = null;
        this.debugLinePaint = null;
        this.tileBgPaint = null;
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = Float.valueOf(limitedScale(0.0f));
        if (isReady()) {
            this.sPendingCenter = new PointF(sWidth() / 2, sHeight() / 2);
        } else {
            this.sPendingCenter = new PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final void setBitmapDecoderClass(@NonNull Class<? extends IMoorImageDecoder> cls) {
        if (cls != null) {
            this.bitmapDecoderFactory = new MoorCompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(@NonNull IMoorDecoderFactory<? extends IMoorImageDecoder> iMoorDecoderFactory) {
        if (iMoorDecoderFactory != null) {
            this.bitmapDecoderFactory = iMoorDecoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setDebug(boolean z) {
        this.debug = z;
    }

    public final void setDoubleTapZoomDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
    }

    public final void setDoubleTapZoomDuration(int i2) {
        this.doubleTapZoomDuration = Math.max(0, i2);
    }

    public final void setDoubleTapZoomScale(float f2) {
        this.doubleTapZoomScale = f2;
    }

    public final void setDoubleTapZoomStyle(int i2) {
        if (VALID_ZOOM_STYLES.contains(Integer.valueOf(i2))) {
            this.doubleTapZoomStyle = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i2);
    }

    public void setEagerLoadingEnabled(boolean z) {
        this.eagerLoadingEnabled = z;
    }

    public void setExecutor(@NonNull Executor executor) {
        Objects.requireNonNull(executor, "Executor must not be null");
        this.executor = executor;
    }

    public final void setImage(@NonNull MoorImageSource moorImageSource) {
        setImage(moorImageSource, null, null);
    }

    public final void setMaxScale(float f2) {
        this.maxScale = f2;
    }

    public void setMaxTileSize(int i2) {
        this.maxTileWidth = i2;
        this.maxTileHeight = i2;
    }

    public final void setMaximumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
    }

    public final void setMinScale(float f2) {
        this.minScale = f2;
    }

    public final void setMinimumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
    }

    public final void setMinimumScaleType(int i2) {
        if (VALID_SCALE_TYPES.contains(Integer.valueOf(i2))) {
            this.minimumScaleType = i2;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid scale type: " + i2);
    }

    public void setMinimumTileDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.minimumTileDpi = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i2);
        if (isReady()) {
            reset(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener) {
        this.onImageEventListener = onImageEventListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.onStateChangedListener = onStateChangedListener;
    }

    public final void setOrientation(int i2) {
        if (VALID_ORIENTATIONS.contains(Integer.valueOf(i2))) {
            this.orientation = i2;
            reset(false);
            invalidate();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i2);
    }

    public final void setPanEnabled(boolean z) {
        PointF pointF;
        this.panEnabled = z;
        if (z || (pointF = this.vTranslate) == null) {
            return;
        }
        pointF.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
        this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
        if (isReady()) {
            refreshRequiredTiles(true);
            invalidate();
        }
    }

    public final void setPanLimit(int i2) {
        if (VALID_PAN_LIMITS.contains(Integer.valueOf(i2))) {
            this.panLimit = i2;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid pan limit: " + i2);
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.quickScaleEnabled = z;
    }

    public final void setRegionDecoderClass(@NonNull Class<? extends IMoorImageRegionDecoder> cls) {
        if (cls != null) {
            this.regionDecoderFactory = new MoorCompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(@NonNull IMoorDecoderFactory<? extends IMoorImageRegionDecoder> iMoorDecoderFactory) {
        if (iMoorDecoderFactory != null) {
            this.regionDecoderFactory = iMoorDecoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setScaleAndCenter(float f2, @Nullable PointF pointF) {
        this.anim = null;
        this.pendingScale = Float.valueOf(f2);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        invalidate();
    }

    public final void setTileBackgroundColor(int i2) {
        if (Color.alpha(i2) == 0) {
            this.tileBgPaint = null;
        } else {
            Paint paint = new Paint();
            this.tileBgPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.tileBgPaint.setColor(i2);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z) {
        this.zoomEnabled = z;
    }

    @Nullable
    public final PointF sourceToViewCoord(PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public void viewToFileRect(Rect rect, Rect rect2) {
        if (this.vTranslate == null || !this.readySent) {
            return;
        }
        rect2.set((int) viewToSourceX(rect.left), (int) viewToSourceY(rect.top), (int) viewToSourceX(rect.right), (int) viewToSourceY(rect.bottom));
        fileSRect(rect2, rect2);
        rect2.set(Math.max(0, rect2.left), Math.max(0, rect2.top), Math.min(this.sWidth, rect2.right), Math.min(this.sHeight, rect2.bottom));
        Rect rect3 = this.sRegion;
        if (rect3 != null) {
            rect2.offset(rect3.left, rect3.top);
        }
    }

    @Nullable
    public final PointF viewToSourceCoord(PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    public void visibleFileRect(Rect rect) {
        if (this.vTranslate == null || !this.readySent) {
            return;
        }
        rect.set(0, 0, getWidth(), getHeight());
        viewToFileRect(rect, rect);
    }

    public final void setImage(@NonNull MoorImageSource moorImageSource, MoorImageViewState moorImageViewState) {
        setImage(moorImageSource, null, moorImageViewState);
    }

    @Nullable
    public final PointF sourceToViewCoord(float f2, float f3) {
        return sourceToViewCoord(f2, f3, new PointF());
    }

    @Nullable
    public final PointF viewToSourceCoord(float f2, float f3) {
        return viewToSourceCoord(f2, f3, new PointF());
    }

    public final void setImage(@NonNull MoorImageSource moorImageSource, MoorImageSource moorImageSource2) {
        setImage(moorImageSource, moorImageSource2, null);
    }

    public void setMaxTileSize(int i2, int i3) {
        this.maxTileWidth = i2;
        this.maxTileHeight = i3;
    }

    @Nullable
    public final PointF sourceToViewCoord(PointF pointF, @NonNull PointF pointF2) {
        return sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    @Nullable
    public final PointF viewToSourceCoord(PointF pointF, @NonNull PointF pointF2) {
        return viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }

    /* loaded from: classes2.dex */
    public final class AnimationBuilder {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private boolean panLimited;
        private final PointF targetSCenter;
        private final float targetScale;
        private final PointF vFocus;

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public AnimationBuilder withOrigin(int i2) {
            this.origin = i2;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public AnimationBuilder withPanLimited(boolean z) {
            this.panLimited = z;
            return this;
        }

        public void start() {
            PointF pointF;
            if (MoorSubsamplingScaleImageView.this.anim != null && MoorSubsamplingScaleImageView.this.anim.listener != null) {
                try {
                    MoorSubsamplingScaleImageView.this.anim.listener.onInterruptedByNewAnim();
                } catch (Exception e2) {
                    Log.w(MoorSubsamplingScaleImageView.TAG, "Error thrown by animation listener", e2);
                }
            }
            int paddingLeft = MoorSubsamplingScaleImageView.this.getPaddingLeft() + (((MoorSubsamplingScaleImageView.this.getWidth() - MoorSubsamplingScaleImageView.this.getPaddingRight()) - MoorSubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = MoorSubsamplingScaleImageView.this.getPaddingTop() + (((MoorSubsamplingScaleImageView.this.getHeight() - MoorSubsamplingScaleImageView.this.getPaddingBottom()) - MoorSubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float limitedScale = MoorSubsamplingScaleImageView.this.limitedScale(this.targetScale);
            if (this.panLimited) {
                MoorSubsamplingScaleImageView moorSubsamplingScaleImageView = MoorSubsamplingScaleImageView.this;
                PointF pointF2 = this.targetSCenter;
                pointF = moorSubsamplingScaleImageView.limitedSCenter(pointF2.x, pointF2.y, limitedScale, new PointF());
            } else {
                pointF = this.targetSCenter;
            }
            MoorSubsamplingScaleImageView.this.anim = new Anim();
            MoorSubsamplingScaleImageView.this.anim.scaleStart = MoorSubsamplingScaleImageView.this.scale;
            MoorSubsamplingScaleImageView.this.anim.scaleEnd = limitedScale;
            MoorSubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            MoorSubsamplingScaleImageView.this.anim.sCenterEndRequested = pointF;
            MoorSubsamplingScaleImageView.this.anim.sCenterStart = MoorSubsamplingScaleImageView.this.getCenter();
            MoorSubsamplingScaleImageView.this.anim.sCenterEnd = pointF;
            MoorSubsamplingScaleImageView.this.anim.vFocusStart = MoorSubsamplingScaleImageView.this.sourceToViewCoord(pointF);
            MoorSubsamplingScaleImageView.this.anim.vFocusEnd = new PointF(paddingLeft, paddingTop);
            MoorSubsamplingScaleImageView.this.anim.duration = this.duration;
            MoorSubsamplingScaleImageView.this.anim.interruptible = this.interruptible;
            MoorSubsamplingScaleImageView.this.anim.easing = this.easing;
            MoorSubsamplingScaleImageView.this.anim.origin = this.origin;
            MoorSubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            MoorSubsamplingScaleImageView.this.anim.listener = this.listener;
            PointF pointF3 = this.vFocus;
            if (pointF3 != null) {
                float f2 = pointF3.x - (MoorSubsamplingScaleImageView.this.anim.sCenterStart.x * limitedScale);
                float f3 = this.vFocus.y - (MoorSubsamplingScaleImageView.this.anim.sCenterStart.y * limitedScale);
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(limitedScale, new PointF(f2, f3));
                MoorSubsamplingScaleImageView.this.fitToBounds(true, scaleAndTranslate);
                MoorSubsamplingScaleImageView.this.anim.vFocusEnd = new PointF(this.vFocus.x + (scaleAndTranslate.vTranslate.x - f2), this.vFocus.y + (scaleAndTranslate.vTranslate.y - f3));
            }
            MoorSubsamplingScaleImageView.this.invalidate();
        }

        @NonNull
        public AnimationBuilder withDuration(long j2) {
            this.duration = j2;
            return this;
        }

        @NonNull
        public AnimationBuilder withEasing(int i2) {
            if (MoorSubsamplingScaleImageView.VALID_EASING_STYLES.contains(Integer.valueOf(i2))) {
                this.easing = i2;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i2);
        }

        @NonNull
        public AnimationBuilder withInterruptible(boolean z) {
            this.interruptible = z;
            return this;
        }

        @NonNull
        public AnimationBuilder withOnAnimationEventListener(OnAnimationEventListener onAnimationEventListener) {
            this.listener = onAnimationEventListener;
            return this;
        }

        private AnimationBuilder(PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = MoorSubsamplingScaleImageView.this.scale;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f2) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f2;
            this.targetSCenter = MoorSubsamplingScaleImageView.this.getCenter();
            this.vFocus = null;
        }

        private AnimationBuilder(float f2, PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f2;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f2, PointF pointF, PointF pointF2) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f2;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }
    }

    public final void setImage(@NonNull MoorImageSource moorImageSource, MoorImageSource moorImageSource2, MoorImageViewState moorImageViewState) {
        Objects.requireNonNull(moorImageSource, "imageSource must not be null");
        reset(true);
        if (moorImageViewState != null) {
            restoreState(moorImageViewState);
        }
        if (moorImageSource2 != null) {
            if (moorImageSource.getBitmap() == null) {
                if (moorImageSource.getSWidth() > 0 && moorImageSource.getSHeight() > 0) {
                    this.sWidth = moorImageSource.getSWidth();
                    this.sHeight = moorImageSource.getSHeight();
                    this.pRegion = moorImageSource2.getSRegion();
                    if (moorImageSource2.getBitmap() != null) {
                        this.bitmapIsCached = moorImageSource2.isCached();
                        onPreviewLoaded(moorImageSource2.getBitmap());
                    } else {
                        Uri uri = moorImageSource2.getUri();
                        if (uri == null && moorImageSource2.getResource() != null) {
                            uri = Uri.parse("android.resource://" + getContext().getPackageName() + MqttTopic.TOPIC_LEVEL_SEPARATOR + moorImageSource2.getResource());
                        }
                        execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, uri, true));
                    }
                } else {
                    throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                }
            } else {
                throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
            }
        }
        if (moorImageSource.getBitmap() != null && moorImageSource.getSRegion() != null) {
            onImageLoaded(Bitmap.createBitmap(moorImageSource.getBitmap(), moorImageSource.getSRegion().left, moorImageSource.getSRegion().top, moorImageSource.getSRegion().width(), moorImageSource.getSRegion().height()), 0, false);
        } else if (moorImageSource.getBitmap() != null) {
            onImageLoaded(moorImageSource.getBitmap(), 0, moorImageSource.isCached());
        } else {
            this.sRegion = moorImageSource.getSRegion();
            Uri uri2 = moorImageSource.getUri();
            this.uri = uri2;
            if (uri2 == null && moorImageSource.getResource() != null) {
                this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + MqttTopic.TOPIC_LEVEL_SEPARATOR + moorImageSource.getResource());
            }
            if (!moorImageSource.getTile() && this.sRegion == null) {
                execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
            } else {
                execute(new TilesInitTask(this, getContext(), this.regionDecoderFactory, this.uri));
            }
        }
    }

    @Nullable
    public final PointF sourceToViewCoord(float f2, float f3, @NonNull PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(sourceToViewX(f2), sourceToViewY(f3));
        return pointF;
    }

    @Nullable
    public final PointF viewToSourceCoord(float f2, float f3, @NonNull PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(viewToSourceX(f2), viewToSourceY(f3));
        return pointF;
    }

    private void fitToBounds(boolean z) {
        boolean z2;
        if (this.vTranslate == null) {
            z2 = true;
            this.vTranslate = new PointF(0.0f, 0.0f);
        } else {
            z2 = false;
        }
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        this.satTemp.scale = this.scale;
        this.satTemp.vTranslate.set(this.vTranslate);
        fitToBounds(z, this.satTemp);
        this.scale = this.satTemp.scale;
        this.vTranslate.set(this.satTemp.vTranslate);
        if (!z2 || this.minimumScaleType == 4) {
            return;
        }
        this.vTranslate.set(vTranslateForSCenter(sWidth() / 2, sHeight() / 2, this.scale));
    }

    public MoorSubsamplingScaleImageView(Context context) {
        this(context, null);
    }
}
