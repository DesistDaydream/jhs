package kotlinx.coroutines.internal;

import i.b.l2;
import i.b.x1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@x1
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherFactory;", "", "", "allFactories", "Li/b/l2;", "createDispatcher", "(Ljava/util/List;)Li/b/l2;", "", "hintOnError", "()Ljava/lang/String;", "", "getLoadPriority", "()I", "loadPriority", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface MainDispatcherFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        @e
        public static String a(@d MainDispatcherFactory mainDispatcherFactory) {
            return null;
        }
    }

    @d
    l2 createDispatcher(@d List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    @e
    String hintOnError();
}
