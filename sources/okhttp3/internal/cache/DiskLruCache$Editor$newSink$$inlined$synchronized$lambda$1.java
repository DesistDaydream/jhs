package okhttp3.internal.cache;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import h.t1;
import java.io.IOException;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.cache.DiskLruCache;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ljava/io/IOException;", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "invoke", "(Ljava/io/IOException;)V", "okhttp3/internal/cache/DiskLruCache$Editor$newSink$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1 extends Lambda implements l<IOException, t1> {
    public final /* synthetic */ int $index$inlined;
    public final /* synthetic */ DiskLruCache.Editor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(DiskLruCache.Editor editor, int i2) {
        super(1);
        this.this$0 = editor;
        this.$index$inlined = i2;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(IOException iOException) {
        invoke2(iOException);
        return t1.a;
    }

    /* renamed from: invoke */
    public final void invoke2(@d IOException iOException) {
        synchronized (DiskLruCache.this) {
            this.this$0.detach$okhttp();
            t1 t1Var = t1.a;
        }
    }
}
