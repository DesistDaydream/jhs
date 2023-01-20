package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import e.b.a.p.e;
import e.b.a.p.k.s;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class VideoDecoder<T> implements e.b.a.p.g<T, Bitmap> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f1724d = "VideoDecoder";

    /* renamed from: e  reason: collision with root package name */
    public static final long f1725e = -1;
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    public static final int f1726f = 2;

    /* renamed from: g  reason: collision with root package name */
    public static final e.b.a.p.e<Long> f1727g = e.b.a.p.e.b("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* renamed from: h  reason: collision with root package name */
    public static final e.b.a.p.e<Integer> f1728h = e.b.a.p.e.b("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: i  reason: collision with root package name */
    private static final e f1729i = new e();
    private final f<T> a;
    private final e.b.a.p.k.x.e b;

    /* renamed from: c  reason: collision with root package name */
    private final e f1730c;

    /* loaded from: classes.dex */
    public static final class VideoDecoderException extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        public VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    /* loaded from: classes.dex */
    public class a implements e.b<Long> {
        private final ByteBuffer a = ByteBuffer.allocate(8);

        @Override // e.b.a.p.e.b
        public void update(@NonNull byte[] bArr, @NonNull Long l2, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putLong(l2.longValue()).array());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements e.b<Integer> {
        private final ByteBuffer a = ByteBuffer.allocate(4);

        @Override // e.b.a.p.e.b
        public void update(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putInt(num.intValue()).array());
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements f<AssetFileDescriptor> {
        private c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    @RequiresApi(23)
    /* loaded from: classes.dex */
    public static final class d implements f<ByteBuffer> {

        /* loaded from: classes.dex */
        public class a extends MediaDataSource {
            public final /* synthetic */ ByteBuffer a;

            public a(ByteBuffer byteBuffer) {
                this.a = byteBuffer;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.a.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j2, byte[] bArr, int i2, int i3) {
                if (j2 >= this.a.limit()) {
                    return -1;
                }
                this.a.position((int) j2);
                int min = Math.min(i3, this.a.remaining());
                this.a.get(bArr, i2, min);
                return min;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new a(byteBuffer));
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class e {
        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* loaded from: classes.dex */
    public static final class g implements f<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    public VideoDecoder(e.b.a.p.k.x.e eVar, f<T> fVar) {
        this(eVar, fVar, f1729i);
    }

    public static e.b.a.p.g<AssetFileDescriptor, Bitmap> c(e.b.a.p.k.x.e eVar) {
        return new VideoDecoder(eVar, new c(null));
    }

    @RequiresApi(api = 23)
    public static e.b.a.p.g<ByteBuffer, Bitmap> d(e.b.a.p.k.x.e eVar) {
        return new VideoDecoder(eVar, new d());
    }

    @Nullable
    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, DownsampleStrategy downsampleStrategy) {
        Bitmap g2 = (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f1716f) ? null : g(mediaMetadataRetriever, j2, i2, i3, i4, downsampleStrategy);
        if (g2 == null) {
            g2 = f(mediaMetadataRetriever, j2, i2);
        }
        if (g2 != null) {
            return g2;
        }
        throw new VideoDecoderException();
    }

    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j2, i2);
    }

    @Nullable
    @TargetApi(27)
    private static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float b2 = downsampleStrategy.b(parseInt, parseInt2, i3, i4);
            return mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(parseInt * b2), Math.round(b2 * parseInt2));
        } catch (Throwable th) {
            if (Log.isLoggable(f1724d, 3)) {
                Log.d(f1724d, "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
                return null;
            }
            return null;
        }
    }

    public static e.b.a.p.g<ParcelFileDescriptor, Bitmap> h(e.b.a.p.k.x.e eVar) {
        return new VideoDecoder(eVar, new g());
    }

    @Override // e.b.a.p.g
    public boolean a(@NonNull T t, @NonNull e.b.a.p.f fVar) {
        return true;
    }

    @Override // e.b.a.p.g
    public s<Bitmap> b(@NonNull T t, int i2, int i3, @NonNull e.b.a.p.f fVar) throws IOException {
        long longValue = ((Long) fVar.a(f1727g)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) fVar.a(f1728h);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) fVar.a(DownsampleStrategy.f1718h);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.f1717g;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever a2 = this.f1730c.a();
        try {
            this.a.a(a2, t);
            Bitmap e2 = e(a2, longValue, num.intValue(), i2, i3, downsampleStrategy2);
            a2.release();
            return e.b.a.p.m.d.g.d(e2, this.b);
        } catch (Throwable th) {
            a2.release();
            throw th;
        }
    }

    @VisibleForTesting
    public VideoDecoder(e.b.a.p.k.x.e eVar, f<T> fVar, e eVar2) {
        this.b = eVar;
        this.a = fVar;
        this.f1730c = eVar2;
    }
}
