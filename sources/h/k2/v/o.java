package h.k2.v;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0002J\f\u0010\f\u001a\u00020\u0004*\u00020\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/jvm/internal/ByteSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", "value", "", "toArray", "getSize", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class o extends m0<byte[]> {

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f14914d;

    public o(int i2) {
        super(i2);
        this.f14914d = new byte[i2];
    }

    public final void h(byte b) {
        byte[] bArr = this.f14914d;
        int b2 = b();
        e(b2 + 1);
        bArr[b2] = b;
    }

    @Override // h.k2.v.m0
    /* renamed from: i */
    public int c(@k.e.a.d byte[] bArr) {
        return bArr.length;
    }

    @k.e.a.d
    public final byte[] j() {
        return g(this.f14914d, new byte[f()]);
    }
}