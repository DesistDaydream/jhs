package kotlin.io;

import h.h2.m;
import java.nio.charset.CharsetDecoder;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final /* synthetic */ class LineReader$readLine$1 extends MutablePropertyReference0Impl {
    public LineReader$readLine$1(m mVar) {
        super(mVar, m.class, "decoder", "getDecoder()Ljava/nio/charset/CharsetDecoder;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, h.p2.o
    @e
    public Object get() {
        CharsetDecoder charsetDecoder;
        m mVar = (m) this.receiver;
        charsetDecoder = m.b;
        return charsetDecoder;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, h.p2.k
    public void set(@e Object obj) {
        m mVar = (m) this.receiver;
        m.b = (CharsetDecoder) obj;
    }
}
