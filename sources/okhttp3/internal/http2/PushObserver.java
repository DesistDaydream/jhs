package okhttp3.internal.http2;

import com.bytedance.msdk.api.reward.RewardItem;
import com.tencent.android.tpush.common.MessageKey;
import h.k2.d;
import h.k2.v.u;
import j.o;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\b\u0010\tJ-\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/http2/PushObserver;", "", "", "streamId", "", "Lokhttp3/internal/http2/Header;", "requestHeaders", "", "onRequest", "(ILjava/util/List;)Z", "responseHeaders", "last", "onHeaders", "(ILjava/util/List;Z)Z", "Lj/o;", MessageKey.MSG_SOURCE, "byteCount", "onData", "(ILj/o;IZ)Z", "Lokhttp3/internal/http2/ErrorCode;", RewardItem.KEY_ERROR_CODE, "Lh/t1;", "onReset", "(ILokhttp3/internal/http2/ErrorCode;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface PushObserver {
    public static final Companion Companion = new Companion(null);
    @d
    @k.e.a.d
    public static final PushObserver CANCEL = new Companion.PushObserverCancel();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001\u0082\u0002\u0007\n\u0005\b\u0091F0\u0001¨\u0006\b"}, d2 = {"Lokhttp3/internal/http2/PushObserver$Companion;", "", "Lokhttp3/internal/http2/PushObserver;", "CANCEL", "Lokhttp3/internal/http2/PushObserver;", "<init>", "()V", "PushObserverCancel", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = null;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/http2/PushObserver$Companion$PushObserverCancel;", "Lokhttp3/internal/http2/PushObserver;", "", "streamId", "", "Lokhttp3/internal/http2/Header;", "requestHeaders", "", "onRequest", "(ILjava/util/List;)Z", "responseHeaders", "last", "onHeaders", "(ILjava/util/List;Z)Z", "Lj/o;", MessageKey.MSG_SOURCE, "byteCount", "onData", "(ILj/o;IZ)Z", "Lokhttp3/internal/http2/ErrorCode;", RewardItem.KEY_ERROR_CODE, "Lh/t1;", "onReset", "(ILokhttp3/internal/http2/ErrorCode;)V", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes4.dex */
        public static final class PushObserverCancel implements PushObserver {
            @Override // okhttp3.internal.http2.PushObserver
            public boolean onData(int i2, @k.e.a.d o oVar, int i3, boolean z) throws IOException {
                oVar.skip(i3);
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onHeaders(int i2, @k.e.a.d List<Header> list, boolean z) {
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onRequest(int i2, @k.e.a.d List<Header> list) {
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public void onReset(int i2, @k.e.a.d ErrorCode errorCode) {
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    boolean onData(int i2, @k.e.a.d o oVar, int i3, boolean z) throws IOException;

    boolean onHeaders(int i2, @k.e.a.d List<Header> list, boolean z);

    boolean onRequest(int i2, @k.e.a.d List<Header> list);

    void onReset(int i2, @k.e.a.d ErrorCode errorCode);
}
