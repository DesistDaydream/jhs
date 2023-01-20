package com.caverock.androidsvg;

/* loaded from: classes.dex */
public class PreserveAspectRatio {

    /* renamed from: c  reason: collision with root package name */
    public static final PreserveAspectRatio f2463c = new PreserveAspectRatio(null, null);

    /* renamed from: d  reason: collision with root package name */
    public static final PreserveAspectRatio f2464d = new PreserveAspectRatio(Alignment.None, null);

    /* renamed from: e  reason: collision with root package name */
    public static final PreserveAspectRatio f2465e;

    /* renamed from: f  reason: collision with root package name */
    public static final PreserveAspectRatio f2466f;

    /* renamed from: g  reason: collision with root package name */
    public static final PreserveAspectRatio f2467g;

    /* renamed from: h  reason: collision with root package name */
    public static final PreserveAspectRatio f2468h;

    /* renamed from: i  reason: collision with root package name */
    public static final PreserveAspectRatio f2469i;

    /* renamed from: j  reason: collision with root package name */
    public static final PreserveAspectRatio f2470j;

    /* renamed from: k  reason: collision with root package name */
    public static final PreserveAspectRatio f2471k;
    private Alignment a;
    private Scale b;

    /* loaded from: classes.dex */
    public enum Alignment {
        None,
        XMinYMin,
        XMidYMin,
        XMaxYMin,
        XMinYMid,
        XMidYMid,
        XMaxYMid,
        XMinYMax,
        XMidYMax,
        XMaxYMax;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Alignment[] valuesCustom() {
            Alignment[] valuesCustom = values();
            int length = valuesCustom.length;
            Alignment[] alignmentArr = new Alignment[length];
            System.arraycopy(valuesCustom, 0, alignmentArr, 0, length);
            return alignmentArr;
        }
    }

    /* loaded from: classes.dex */
    public enum Scale {
        Meet,
        Slice;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Scale[] valuesCustom() {
            Scale[] valuesCustom = values();
            int length = valuesCustom.length;
            Scale[] scaleArr = new Scale[length];
            System.arraycopy(valuesCustom, 0, scaleArr, 0, length);
            return scaleArr;
        }
    }

    static {
        Alignment alignment = Alignment.XMidYMid;
        Scale scale = Scale.Meet;
        f2465e = new PreserveAspectRatio(alignment, scale);
        Alignment alignment2 = Alignment.XMinYMin;
        f2466f = new PreserveAspectRatio(alignment2, scale);
        f2467g = new PreserveAspectRatio(Alignment.XMaxYMax, scale);
        f2468h = new PreserveAspectRatio(Alignment.XMidYMin, scale);
        f2469i = new PreserveAspectRatio(Alignment.XMidYMax, scale);
        Scale scale2 = Scale.Slice;
        f2470j = new PreserveAspectRatio(alignment, scale2);
        f2471k = new PreserveAspectRatio(alignment2, scale2);
    }

    public PreserveAspectRatio(Alignment alignment, Scale scale) {
        this.a = alignment;
        this.b = scale;
    }

    public Alignment a() {
        return this.a;
    }

    public Scale b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
            return this.a == preserveAspectRatio.a && this.b == preserveAspectRatio.b;
        }
        return false;
    }
}
