package kotlinx.coroutines;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.umeng.analytics.pro.am;
import h.e2.b;
import h.k2.u.l;
import h.k2.v.u;
import h.o;
import java.io.Closeable;
import java.util.concurrent.Executor;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/io/Closeable;", "Lh/t1;", "close", "()V", "Ljava/util/concurrent/Executor;", "z0", "()Ljava/util/concurrent/Executor;", "executor", "<init>", am.av, "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {
    public static final Key a = new Key(null);

    @o
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcher$Key;", "Lh/e2/b;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Key extends b<CoroutineDispatcher, ExecutorCoroutineDispatcher> {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/coroutines/CoroutineContext$a;", AdvanceSetting.NETWORK_TYPE, "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "invoke", "(Lkotlin/coroutines/CoroutineContext$a;)Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.ExecutorCoroutineDispatcher$Key$1  reason: invalid class name */
        /* loaded from: classes4.dex */
        public static final class AnonymousClass1 extends Lambda implements l<CoroutineContext.a, ExecutorCoroutineDispatcher> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // h.k2.u.l
            @e
            public final ExecutorCoroutineDispatcher invoke(@d CoroutineContext.a aVar) {
                if (!(aVar instanceof ExecutorCoroutineDispatcher)) {
                    aVar = null;
                }
                return (ExecutorCoroutineDispatcher) aVar;
            }
        }

        public /* synthetic */ Key(u uVar) {
            this();
        }

        private Key() {
            super(CoroutineDispatcher.Key, AnonymousClass1.INSTANCE);
        }
    }

    public abstract void close();

    @d
    public abstract Executor z0();
}
