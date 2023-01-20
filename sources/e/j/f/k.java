package e.j.f;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class k {
    private final String a;
    private final byte[] b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11341c;

    /* renamed from: d  reason: collision with root package name */
    private l[] f11342d;

    /* renamed from: e  reason: collision with root package name */
    private final BarcodeFormat f11343e;

    /* renamed from: f  reason: collision with root package name */
    private Map<ResultMetadataType, Object> f11344f;

    /* renamed from: g  reason: collision with root package name */
    private final long f11345g;

    public k(String str, byte[] bArr, l[] lVarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, lVarArr, barcodeFormat, System.currentTimeMillis());
    }

    public void a(l[] lVarArr) {
        l[] lVarArr2 = this.f11342d;
        if (lVarArr2 == null) {
            this.f11342d = lVarArr;
        } else if (lVarArr == null || lVarArr.length <= 0) {
        } else {
            l[] lVarArr3 = new l[lVarArr2.length + lVarArr.length];
            System.arraycopy(lVarArr2, 0, lVarArr3, 0, lVarArr2.length);
            System.arraycopy(lVarArr, 0, lVarArr3, lVarArr2.length, lVarArr.length);
            this.f11342d = lVarArr3;
        }
    }

    public BarcodeFormat b() {
        return this.f11343e;
    }

    public int c() {
        return this.f11341c;
    }

    public byte[] d() {
        return this.b;
    }

    public Map<ResultMetadataType, Object> e() {
        return this.f11344f;
    }

    public l[] f() {
        return this.f11342d;
    }

    public String g() {
        return this.a;
    }

    public long h() {
        return this.f11345g;
    }

    public void i(Map<ResultMetadataType, Object> map) {
        if (map != null) {
            Map<ResultMetadataType, Object> map2 = this.f11344f;
            if (map2 == null) {
                this.f11344f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void j(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f11344f == null) {
            this.f11344f = new EnumMap(ResultMetadataType.class);
        }
        this.f11344f.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.a;
    }

    public k(String str, byte[] bArr, l[] lVarArr, BarcodeFormat barcodeFormat, long j2) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, lVarArr, barcodeFormat, j2);
    }

    public k(String str, byte[] bArr, int i2, l[] lVarArr, BarcodeFormat barcodeFormat, long j2) {
        this.a = str;
        this.b = bArr;
        this.f11341c = i2;
        this.f11342d = lVarArr;
        this.f11343e = barcodeFormat;
        this.f11344f = null;
        this.f11345g = j2;
    }
}
