package kotlinx.coroutines.android;

import android.os.Looper;
import i.b.l2;
import i.b.s3.b;
import i.b.w3.v;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/android/AndroidDispatcherFactory;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "", "allFactories", "Lkotlinx/coroutines/android/HandlerContext;", "createDispatcher", "(Ljava/util/List;)Lkotlinx/coroutines/android/HandlerContext;", "", "hintOnError", "()Ljava/lang/String;", "", "getLoadPriority", "()I", "loadPriority", "<init>", "()V", "kotlinx-coroutines-android"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class AndroidDispatcherFactory implements MainDispatcherFactory {
    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public /* bridge */ /* synthetic */ l2 createDispatcher(List list) {
        return createDispatcher((List<? extends MainDispatcherFactory>) list);
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public int getLoadPriority() {
        return v.f15906i;
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    @e
    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    @d
    public HandlerContext createDispatcher(@d List<? extends MainDispatcherFactory> list) {
        return new HandlerContext(b.c(Looper.getMainLooper(), true), null, 2, null);
    }
}
