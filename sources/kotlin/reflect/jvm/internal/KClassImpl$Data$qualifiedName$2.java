package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import h.p2.b0.g.t.g.b;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KClassImpl$Data$qualifiedName$2 extends Lambda implements a<String> {
    public final /* synthetic */ KClassImpl.Data this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$qualifiedName$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // h.k2.u.a
    @e
    public final String invoke() {
        b X;
        if (KClassImpl.this.d().isAnonymousClass()) {
            return null;
        }
        X = KClassImpl.this.X();
        if (X.k()) {
            return null;
        }
        return X.b().b();
    }
}
