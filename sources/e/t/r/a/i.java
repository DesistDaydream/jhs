package e.t.r.a;

import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import com.tencent.android.tpush.common.MessageKey;
import e.b.a.p.k.s;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J2\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000f"}, d2 = {"Lcom/vector/network/image/SvgDecoder;", "Lcom/bumptech/glide/load/ResourceDecoder;", "Ljava/io/InputStream;", "Lcom/caverock/androidsvg/SVG;", "()V", "decode", "Lcom/bumptech/glide/load/engine/Resource;", MessageKey.MSG_SOURCE, "width", "", "height", "options", "Lcom/bumptech/glide/load/Options;", "handles", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class i implements e.b.a.p.g<InputStream, SVG> {
    @Override // e.b.a.p.g
    @k.e.a.e
    /* renamed from: c */
    public s<SVG> b(@k.e.a.d InputStream inputStream, int i2, int i3, @k.e.a.d e.b.a.p.f fVar) {
        try {
            SVG s = SVG.s(inputStream);
            if (i2 != Integer.MIN_VALUE) {
                s.P(i2);
            }
            if (i3 != Integer.MIN_VALUE) {
                s.L(i3);
            }
            return new e.b.a.p.m.b(s);
        } catch (SVGParseException e2) {
            throw new IOException("Cannot load SVG from stream", e2);
        }
    }

    @Override // e.b.a.p.g
    /* renamed from: d */
    public boolean a(@k.e.a.d InputStream inputStream, @k.e.a.d e.b.a.p.f fVar) {
        return true;
    }
}
