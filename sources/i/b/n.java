package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002J%\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\u0006\u0010\u0007JH\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\tH'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0004H'¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\rH'¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u001a\u0010\u001bJ8\u0010\u001e\u001a\u00020\r2'\u0010\u001d\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bj\u0002`\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010!\u001a\u00020\r*\u00020 2\u0006\u0010\u0003\u001a\u00028\u0000H'¢\u0006\u0004\b!\u0010\"J\u001b\u0010#\u001a\u00020\r*\u00020 2\u0006\u0010\u0011\u001a\u00020\tH'¢\u0006\u0004\b#\u0010$J<\u0010%\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH'¢\u0006\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00198&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00198&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(R\u0016\u0010,\u001a\u00020\u00198&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010(¨\u0006-"}, d2 = {"Li/b/n;", ExifInterface.GPS_DIRECTION_TRUE, "Lh/e2/c;", "value", "", "idempotent", "m", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lh/k0;", "name", "cause", "Lh/t1;", "onCancellation", "D", "(Ljava/lang/Object;Ljava/lang/Object;Lh/k2/u/l;)Ljava/lang/Object;", "exception", am.aI, "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "P", "(Ljava/lang/Object;)V", "G", "()V", "", am.av, "(Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/CompletionHandler;", "handler", am.ax, "(Lh/k2/u/l;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", ExifInterface.LONGITUDE_EAST, "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", am.aH, "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", IAdInterListener.AdReqParam.WIDTH, "(Ljava/lang/Object;Lh/k2/u/l;)V", "j", "()Z", "isActive", NotifyType.LIGHTS, "isCompleted", "isCancelled", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface n<T> extends h.e2.c<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ boolean a(n nVar, Throwable th, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    th = null;
                }
                return nVar.a(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ Object b(n nVar, Object obj, Object obj2, int i2, Object obj3) {
            if (obj3 == null) {
                if ((i2 & 2) != 0) {
                    obj2 = null;
                }
                return nVar.m(obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
        }
    }

    @x1
    @k.e.a.e
    Object D(T t, @k.e.a.e Object obj, @k.e.a.e h.k2.u.l<? super Throwable, h.t1> lVar);

    @r1
    void E(@k.e.a.d CoroutineDispatcher coroutineDispatcher, T t);

    @x1
    void G();

    @x1
    void P(@k.e.a.d Object obj);

    boolean a(@k.e.a.e Throwable th);

    boolean isCancelled();

    boolean j();

    boolean l();

    @x1
    @k.e.a.e
    Object m(T t, @k.e.a.e Object obj);

    void p(@k.e.a.d h.k2.u.l<? super Throwable, h.t1> lVar);

    @x1
    @k.e.a.e
    Object t(@k.e.a.d Throwable th);

    @r1
    void u(@k.e.a.d CoroutineDispatcher coroutineDispatcher, @k.e.a.d Throwable th);

    @r1
    void w(T t, @k.e.a.e h.k2.u.l<? super Throwable, h.t1> lVar);
}
