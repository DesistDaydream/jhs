package okhttp3.internal.publicsuffix;

import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final /* synthetic */ class PublicSuffixDatabase$findMatchingRule$1 extends MutablePropertyReference0Impl {
    public PublicSuffixDatabase$findMatchingRule$1(PublicSuffixDatabase publicSuffixDatabase) {
        super(publicSuffixDatabase, PublicSuffixDatabase.class, "publicSuffixListBytes", "getPublicSuffixListBytes()[B", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, h.p2.o
    @e
    public Object get() {
        byte[] bArr;
        bArr = ((PublicSuffixDatabase) this.receiver).publicSuffixListBytes;
        return bArr;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, h.p2.k
    public void set(@e Object obj) {
        ((PublicSuffixDatabase) this.receiver).publicSuffixListBytes = (byte[]) obj;
    }
}
