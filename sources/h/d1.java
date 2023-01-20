package h;

import com.tencent.android.tpush.common.MessageKey;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0007\u001a\u001f\u0010\b\u001a\u00020\u00012\n\u0010\t\u001a\u00020\u0001\"\u00020\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"UByteArray", "Lkotlin/UByteArray;", "size", "", "init", "Lkotlin/Function1;", "Lkotlin/UByte;", "(ILkotlin/jvm/functions/Function1;)[B", "ubyteArrayOf", MessageKey.CUSTOM_LAYOUT_ELEMENTS, "ubyteArrayOf-GBYM_sE", "([B)[B", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class d1 {
    @p
    @h.g2.f
    @s0(version = "1.3")
    private static final byte[] a(int i2, h.k2.u.l<? super Integer, b1> lVar) {
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = lVar.invoke(Integer.valueOf(i3)).k0();
        }
        return c1.g(bArr);
    }

    @p
    @h.g2.f
    @s0(version = "1.3")
    private static final byte[] b(byte... bArr) {
        return bArr;
    }
}
