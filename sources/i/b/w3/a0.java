package i.b.w3;

import i.b.l2;
import i.b.x1;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@x1
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Li/b/w3/a0;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "", "allFactories", "Li/b/l2;", "createDispatcher", "(Ljava/util/List;)Li/b/l2;", "", "getLoadPriority", "()I", "loadPriority", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class a0 implements MainDispatcherFactory {
    public static final a0 a = new a0();

    private a0() {
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    @k.e.a.d
    public l2 createDispatcher(@k.e.a.d List<? extends MainDispatcherFactory> list) {
        return new z(null, null, 2, null);
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public int getLoadPriority() {
        return -1;
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    @k.e.a.e
    public String hintOnError() {
        return MainDispatcherFactory.a.a(this);
    }
}
