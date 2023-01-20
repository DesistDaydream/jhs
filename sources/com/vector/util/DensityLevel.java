package com.vector.util;

import h.k2.v.u;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/vector/util/DensityLevel;", "", "density", "", "dpi", "", "(Ljava/lang/String;IFI)V", "getDensity", "()F", "getDpi", "()I", "UN_KNOW", "L", "M", "H", "XH", "XXH", "XXXH", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public enum DensityLevel {
    UN_KNOW(0.0f, 0),
    L(0.75f, 120),
    M(1.0f, 160),
    H(1.5f, 240),
    XH(2.0f, 320),
    XXH(3.0f, 480),
    XXXH(4.0f, 640);
    
    @d
    public static final a Companion = new a(null);
    private final float density;
    private final int dpi;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/vector/util/DensityLevel$Companion;", "", "()V", "match", "Lcom/vector/util/DensityLevel;", "dpi", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final DensityLevel a(int i2) {
            DensityLevel densityLevel = DensityLevel.L;
            if (i2 <= densityLevel.getDpi()) {
                return densityLevel;
            }
            DensityLevel densityLevel2 = DensityLevel.M;
            if (i2 <= densityLevel2.getDpi()) {
                return densityLevel2;
            }
            DensityLevel densityLevel3 = DensityLevel.H;
            if (i2 <= densityLevel3.getDpi()) {
                return densityLevel3;
            }
            DensityLevel densityLevel4 = DensityLevel.XH;
            if (i2 <= densityLevel4.getDpi()) {
                return densityLevel4;
            }
            DensityLevel densityLevel5 = DensityLevel.XXH;
            if (i2 <= densityLevel5.getDpi()) {
                return densityLevel5;
            }
            DensityLevel densityLevel6 = DensityLevel.XXXH;
            return i2 <= densityLevel6.getDpi() ? densityLevel6 : DensityLevel.UN_KNOW;
        }
    }

    DensityLevel(float f2, int i2) {
        this.density = f2;
        this.dpi = i2;
    }

    public final float getDensity() {
        return this.density;
    }

    public final int getDpi() {
        return this.dpi;
    }
}
