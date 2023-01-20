package com.m7.imkfsdk.view.imageviewer.subscaleview.decoder;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.caverock.androidsvg.SVG;
import com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView;
import com.moor.imkf.lib.utils.MoorLogUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class MoorSkiaPooledImageRegionDecoder implements IMoorImageRegionDecoder {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private static final String TAG = "MoorSkiaPooledImageRegionDecoder";
    private static boolean debug = false;
    private final Bitmap.Config bitmapConfig;
    private Context context;
    private final ReadWriteLock decoderLock;
    private DecoderPool decoderPool;
    private long fileLength;
    private final Point imageDimensions;
    private final AtomicBoolean lazyInited;
    private Uri uri;

    /* loaded from: classes2.dex */
    public static class DecoderPool {
        private final Semaphore available;
        private final Map<BitmapRegionDecoder, Boolean> decoders;

        private DecoderPool() {
            this.available = new Semaphore(0, true);
            this.decoders = new ConcurrentHashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BitmapRegionDecoder acquire() {
            this.available.acquireUninterruptibly();
            return getNextAvailable();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void add(BitmapRegionDecoder bitmapRegionDecoder) {
            this.decoders.put(bitmapRegionDecoder, Boolean.FALSE);
            this.available.release();
        }

        private synchronized BitmapRegionDecoder getNextAvailable() {
            for (Map.Entry<BitmapRegionDecoder, Boolean> entry : this.decoders.entrySet()) {
                if (!entry.getValue().booleanValue()) {
                    entry.setValue(Boolean.TRUE);
                    return entry.getKey();
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean isEmpty() {
            return this.decoders.isEmpty();
        }

        private synchronized boolean markAsUnused(BitmapRegionDecoder bitmapRegionDecoder) {
            for (Map.Entry<BitmapRegionDecoder, Boolean> entry : this.decoders.entrySet()) {
                if (bitmapRegionDecoder == entry.getKey()) {
                    if (entry.getValue().booleanValue()) {
                        entry.setValue(Boolean.FALSE);
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void recycle() {
            while (!this.decoders.isEmpty()) {
                BitmapRegionDecoder acquire = acquire();
                acquire.recycle();
                this.decoders.remove(acquire);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release(BitmapRegionDecoder bitmapRegionDecoder) {
            if (markAsUnused(bitmapRegionDecoder)) {
                this.available.release();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized int size() {
            return this.decoders.size();
        }
    }

    @Keep
    public MoorSkiaPooledImageRegionDecoder() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void debug(String str) {
        if (debug) {
            MoorLogUtils.d(TAG, str);
        }
    }

    private int getNumCoresOldPhones() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.m7.imkfsdk.view.imageviewer.subscaleview.decoder.MoorSkiaPooledImageRegionDecoder.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    private int getNumberOfCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialiseDecoder() throws Exception {
        BitmapRegionDecoder bitmapRegionDecoder;
        Resources resourcesForApplication;
        int i2;
        String uri = this.uri.toString();
        long j2 = Long.MAX_VALUE;
        if (uri.startsWith(RESOURCE_PREFIX)) {
            String authority = this.uri.getAuthority();
            if (this.context.getPackageName().equals(authority)) {
                resourcesForApplication = this.context.getResources();
            } else {
                resourcesForApplication = this.context.getPackageManager().getResourcesForApplication(authority);
            }
            List<String> pathSegments = this.uri.getPathSegments();
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
            try {
                j2 = this.context.getResources().openRawResourceFd(i2).getLength();
            } catch (Exception unused2) {
            }
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(this.context.getResources().openRawResource(i2), false);
        } else if (uri.startsWith("file:///android_asset/")) {
            String substring = uri.substring(22);
            try {
                j2 = this.context.getAssets().openFd(substring).getLength();
            } catch (Exception unused3) {
            }
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(this.context.getAssets().open(substring, 1), false);
        } else if (uri.startsWith(FILE_PREFIX)) {
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(uri.substring(7), false);
            try {
                File file = new File(uri);
                if (file.exists()) {
                    j2 = file.length();
                }
            } catch (Exception unused4) {
            }
            bitmapRegionDecoder = newInstance;
        } else {
            InputStream inputStream = null;
            try {
                ContentResolver contentResolver = this.context.getContentResolver();
                inputStream = contentResolver.openInputStream(this.uri);
                BitmapRegionDecoder newInstance2 = BitmapRegionDecoder.newInstance(inputStream, false);
                try {
                    AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.uri, "r");
                    if (openAssetFileDescriptor != null) {
                        j2 = openAssetFileDescriptor.getLength();
                    }
                } catch (Exception unused5) {
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused6) {
                    }
                }
                bitmapRegionDecoder = newInstance2;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused7) {
                    }
                }
                throw th;
            }
        }
        this.fileLength = j2;
        this.imageDimensions.set(bitmapRegionDecoder.getWidth(), bitmapRegionDecoder.getHeight());
        this.decoderLock.writeLock().lock();
        try {
            DecoderPool decoderPool = this.decoderPool;
            if (decoderPool != null) {
                decoderPool.add(bitmapRegionDecoder);
            }
        } finally {
            this.decoderLock.writeLock().unlock();
        }
    }

    private boolean isLowMemory() {
        ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
        if (activityManager != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.lowMemory;
        }
        return true;
    }

    private void lazyInit() {
        if (!this.lazyInited.compareAndSet(false, true) || this.fileLength >= Long.MAX_VALUE) {
            return;
        }
        debug("Starting lazy init of additional decoders");
        new Thread() { // from class: com.m7.imkfsdk.view.imageviewer.subscaleview.decoder.MoorSkiaPooledImageRegionDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (MoorSkiaPooledImageRegionDecoder.this.decoderPool != null) {
                    MoorSkiaPooledImageRegionDecoder moorSkiaPooledImageRegionDecoder = MoorSkiaPooledImageRegionDecoder.this;
                    if (!moorSkiaPooledImageRegionDecoder.allowAdditionalDecoder(moorSkiaPooledImageRegionDecoder.decoderPool.size(), MoorSkiaPooledImageRegionDecoder.this.fileLength)) {
                        return;
                    }
                    try {
                        if (MoorSkiaPooledImageRegionDecoder.this.decoderPool != null) {
                            long currentTimeMillis = System.currentTimeMillis();
                            MoorSkiaPooledImageRegionDecoder.this.debug("Starting decoder");
                            MoorSkiaPooledImageRegionDecoder.this.initialiseDecoder();
                            long currentTimeMillis2 = System.currentTimeMillis();
                            MoorSkiaPooledImageRegionDecoder moorSkiaPooledImageRegionDecoder2 = MoorSkiaPooledImageRegionDecoder.this;
                            moorSkiaPooledImageRegionDecoder2.debug("Started decoder, took " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                        }
                    } catch (Exception e2) {
                        MoorSkiaPooledImageRegionDecoder moorSkiaPooledImageRegionDecoder3 = MoorSkiaPooledImageRegionDecoder.this;
                        moorSkiaPooledImageRegionDecoder3.debug("Failed to start decoder: " + e2.getMessage());
                    }
                }
            }
        }.start();
    }

    @Keep
    public static void setDebug(boolean z) {
        debug = z;
    }

    public boolean allowAdditionalDecoder(int i2, long j2) {
        if (i2 >= 4) {
            debug("No additional decoders allowed, reached hard limit (4)");
            return false;
        }
        long j3 = i2 * j2;
        if (j3 > 20971520) {
            debug("No additional encoders allowed, reached hard memory limit (20Mb)");
            return false;
        } else if (i2 >= getNumberOfCores()) {
            debug("No additional encoders allowed, limited by CPU cores (" + getNumberOfCores() + ")");
            return false;
        } else if (isLowMemory()) {
            debug("No additional encoders allowed, memory is low");
            return false;
        } else {
            debug("Additional decoder allowed, current count is " + i2 + ", estimated native memory " + (j3 / SVG.H) + "Mb");
            return true;
        }
    }

    @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.decoder.IMoorImageRegionDecoder
    @NonNull
    public Bitmap decodeRegion(@NonNull Rect rect, int i2) {
        debug("Decode region " + rect + " on thread " + Thread.currentThread().getName());
        if (rect.width() < this.imageDimensions.x || rect.height() < this.imageDimensions.y) {
            lazyInit();
        }
        this.decoderLock.readLock().lock();
        try {
            DecoderPool decoderPool = this.decoderPool;
            if (decoderPool != null) {
                BitmapRegionDecoder acquire = decoderPool.acquire();
                if (acquire != null && !acquire.isRecycled()) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = i2;
                    options.inPreferredConfig = this.bitmapConfig;
                    Bitmap decodeRegion = acquire.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        if (acquire != null) {
                            this.decoderPool.release(acquire);
                        }
                        return decodeRegion;
                    }
                    throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
                } else if (acquire != null) {
                    this.decoderPool.release(acquire);
                }
            }
            throw new IllegalStateException("Cannot decode region after decoder has been recycled");
        } finally {
            this.decoderLock.readLock().unlock();
        }
    }

    @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.decoder.IMoorImageRegionDecoder
    @NonNull
    public Point init(Context context, @NonNull Uri uri) throws Exception {
        this.context = context;
        this.uri = uri;
        initialiseDecoder();
        return this.imageDimensions;
    }

    @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.decoder.IMoorImageRegionDecoder
    public synchronized boolean isReady() {
        boolean z;
        DecoderPool decoderPool = this.decoderPool;
        if (decoderPool != null) {
            z = decoderPool.isEmpty() ? false : true;
        }
        return z;
    }

    @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.decoder.IMoorImageRegionDecoder
    public synchronized void recycle() {
        this.decoderLock.writeLock().lock();
        DecoderPool decoderPool = this.decoderPool;
        if (decoderPool != null) {
            decoderPool.recycle();
            this.decoderPool = null;
            this.context = null;
            this.uri = null;
        }
        this.decoderLock.writeLock().unlock();
    }

    public MoorSkiaPooledImageRegionDecoder(@Nullable Bitmap.Config config) {
        this.decoderPool = new DecoderPool();
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.fileLength = Long.MAX_VALUE;
        this.imageDimensions = new Point(0, 0);
        this.lazyInited = new AtomicBoolean(false);
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
