package okhttp3.internal.cache;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import h.t1;
import java.io.IOException;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.Util;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/io/IOException;", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "invoke", "(Ljava/io/IOException;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class DiskLruCache$newJournalWriter$faultHidingSink$1 extends Lambda implements l<IOException, t1> {
    public final /* synthetic */ DiskLruCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache$newJournalWriter$faultHidingSink$1(DiskLruCache diskLruCache) {
        super(1);
        this.this$0 = diskLruCache;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(IOException iOException) {
        invoke2(iOException);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d IOException iOException) {
        DiskLruCache diskLruCache = this.this$0;
        if (!Util.assertionsEnabled || Thread.holdsLock(diskLruCache)) {
            this.this$0.hasJournalErrors = true;
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + diskLruCache);
    }
}
