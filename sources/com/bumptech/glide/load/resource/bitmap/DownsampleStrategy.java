package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;

/* loaded from: classes.dex */
public abstract class DownsampleStrategy {
    public static final DownsampleStrategy a = new a();
    public static final DownsampleStrategy b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final DownsampleStrategy f1713c = new e();

    /* renamed from: d  reason: collision with root package name */
    public static final DownsampleStrategy f1714d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final DownsampleStrategy f1715e;

    /* renamed from: f  reason: collision with root package name */
    public static final DownsampleStrategy f1716f;

    /* renamed from: g  reason: collision with root package name */
    public static final DownsampleStrategy f1717g;

    /* renamed from: h  reason: collision with root package name */
    public static final e.b.a.p.e<DownsampleStrategy> f1718h;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f1719i;

    /* loaded from: classes.dex */
    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    /* loaded from: classes.dex */
    public static class a extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i2, int i3, int i4, int i5) {
            int min = Math.min(i3 / i5, i2 / i4);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(min);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i2, int i3, int i4, int i5) {
            int ceil = (int) Math.ceil(Math.max(i3 / i5, i2 / i4));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            return 1.0f / (max << (max >= ceil ? 0 : 1));
        }
    }

    /* loaded from: classes.dex */
    public static class c extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            if (b(i2, i3, i4, i5) == 1.0f) {
                return SampleSizeRounding.QUALITY;
            }
            return DownsampleStrategy.f1713c.a(i2, i3, i4, i5);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i2, int i3, int i4, int i5) {
            return Math.min(1.0f, DownsampleStrategy.f1713c.b(i2, i3, i4, i5));
        }
    }

    /* loaded from: classes.dex */
    public static class d extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i2, int i3, int i4, int i5) {
            return Math.max(i4 / i2, i5 / i3);
        }
    }

    /* loaded from: classes.dex */
    public static class e extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            if (DownsampleStrategy.f1719i) {
                return SampleSizeRounding.QUALITY;
            }
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i2, int i3, int i4, int i5) {
            if (DownsampleStrategy.f1719i) {
                return Math.min(i4 / i2, i5 / i3);
            }
            int max = Math.max(i3 / i5, i2 / i4);
            if (max == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(max);
        }
    }

    /* loaded from: classes.dex */
    public static class f extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }
    }

    static {
        d dVar = new d();
        f1715e = dVar;
        f1716f = new f();
        f1717g = dVar;
        f1718h = e.b.a.p.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
        f1719i = Build.VERSION.SDK_INT >= 19;
    }

    public abstract SampleSizeRounding a(int i2, int i3, int i4, int i5);

    public abstract float b(int i2, int i3, int i4, int i5);
}
