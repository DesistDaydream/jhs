package i.b.a4;

import com.tencent.qcloud.tuicore.TUIConstants;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.t1;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H&¢\u0006\u0004\b\t\u0010\u0005J\u001b\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR$\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00000\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Li/b/a4/c;", "", TUIConstants.TUIChat.OWNER, "", am.av, "(Ljava/lang/Object;)Z", "Lh/t1;", "c", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", com.huawei.hms.push.e.a, f.f10128d, "(Ljava/lang/Object;)V", "b", "()Z", "isLocked", "Li/b/z3/e;", "f", "()Li/b/z3/e;", "onLock", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface c {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Object a(c cVar, Object obj, h.e2.c cVar2, int i2, Object obj2) {
            if (obj2 == null) {
                if ((i2 & 1) != 0) {
                    obj = null;
                }
                return cVar.c(obj, cVar2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
        }

        public static /* synthetic */ boolean b(c cVar, Object obj, int i2, Object obj2) {
            if (obj2 == null) {
                if ((i2 & 1) != 0) {
                    obj = null;
                }
                return cVar.a(obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
        }

        public static /* synthetic */ void c(c cVar, Object obj, int i2, Object obj2) {
            if (obj2 == null) {
                if ((i2 & 1) != 0) {
                    obj = null;
                }
                cVar.d(obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
        }
    }

    boolean a(@k.e.a.e Object obj);

    boolean b();

    @k.e.a.e
    Object c(@k.e.a.e Object obj, @k.e.a.d h.e2.c<? super t1> cVar);

    void d(@k.e.a.e Object obj);

    boolean e(@k.e.a.d Object obj);

    @k.e.a.d
    i.b.z3.e<Object, c> f();
}
