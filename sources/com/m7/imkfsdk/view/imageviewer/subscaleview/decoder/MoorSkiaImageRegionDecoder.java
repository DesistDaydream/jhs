package com.m7.imkfsdk.view.imageviewer.subscaleview.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes2.dex */
public class MoorSkiaImageRegionDecoder implements IMoorImageRegionDecoder {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private final Bitmap.Config bitmapConfig;
    private BitmapRegionDecoder decoder;
    private final ReadWriteLock decoderLock;

    @Keep
    public MoorSkiaImageRegionDecoder() {
        this(null);
    }

    private Lock getDecodeLock() {
        if (Build.VERSION.SDK_INT < 21) {
            return this.decoderLock.writeLock();
        }
        return this.decoderLock.readLock();
    }

    @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.decoder.IMoorImageRegionDecoder
    @NonNull
    public Bitmap decodeRegion(@NonNull Rect rect, int i2) {
        getDecodeLock().lock();
        try {
            BitmapRegionDecoder bitmapRegionDecoder = this.decoder;
            if (bitmapRegionDecoder != null && !bitmapRegionDecoder.isRecycled()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = i2;
                options.inPreferredConfig = this.bitmapConfig;
                Bitmap decodeRegion = this.decoder.decodeRegion(rect, options);
                if (decodeRegion != null) {
                    return decodeRegion;
                }
                throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            }
            throw new IllegalStateException("Cannot decode region after decoder has been recycled");
        } finally {
            getDecodeLock().unlock();
        }
    }

    @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.decoder.IMoorImageRegionDecoder
    @NonNull
    public Point init(Context context, @NonNull Uri uri) throws Exception {
        Resources resourcesForApplication;
        int i2;
        String uri2 = uri.toString();
        if (uri2.startsWith(RESOURCE_PREFIX)) {
            String authority = uri.getAuthority();
            if (context.getPackageName().equals(authority)) {
                resourcesForApplication = context.getResources();
            } else {
                resourcesForApplication = context.getPackageManager().getResourcesForApplication(authority);
            }
            List<String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                i2 = resourcesForApplication.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else {
                if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                    try {
                        i2 = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException unused) {
                    }
                }
                i2 = 0;
            }
            this.decoder = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(i2), false);
        } else if (uri2.startsWith("file:///android_asset/")) {
            this.decoder = BitmapRegionDecoder.newInstance(context.getAssets().open(uri2.substring(22), 1), false);
        } else if (uri2.startsWith(FILE_PREFIX)) {
            this.decoder = BitmapRegionDecoder.newInstance(uri2.substring(7), false);
        } else {
            InputStream inputStream = null;
            try {
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                if (openInputStream != null) {
                    this.decoder = BitmapRegionDecoder.newInstance(openInputStream, false);
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                } else {
                    throw new Exception("Content resolver returned null stream. Unable to initialise with uri.");
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        }
        return new Point(this.decoder.getWidth(), this.decoder.getHeight());
    }

    @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.decoder.IMoorImageRegionDecoder
    public synchronized boolean isReady() {
        boolean z;
        BitmapRegionDecoder bitmapRegionDecoder = this.decoder;
        if (bitmapRegionDecoder != null) {
            z = bitmapRegionDecoder.isRecycled() ? false : true;
        }
        return z;
    }

    @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.decoder.IMoorImageRegionDecoder
    public synchronized void recycle() {
        this.decoderLock.writeLock().lock();
        this.decoder.recycle();
        this.decoder = null;
        this.decoderLock.writeLock().unlock();
    }

    public MoorSkiaImageRegionDecoder(@Nullable Bitmap.Config config) {
        this.decoderLock = new ReentrantReadWriteLock(true);
        Bitmap.Config preferredBitmapConfig = MoorSubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.bitmapConfig = config;
        } else if (preferredBitmapConfig != null) {
            this.bitmapConfig = preferredBitmapConfig;
        } else {
            this.bitmapConfig = Bitmap.Config.RGB_565;
        }
    }
}
