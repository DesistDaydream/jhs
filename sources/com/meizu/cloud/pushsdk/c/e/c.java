package com.meizu.cloud.pushsdk.c.e;

import com.baidu.mobads.sdk.internal.bp;
import com.meizu.cloud.pushsdk.c.a.e;
import com.meizu.cloud.pushsdk.c.c.k;

/* loaded from: classes2.dex */
public final class c {
    public static <T> com.meizu.cloud.pushsdk.c.a.c<T> a(com.meizu.cloud.pushsdk.c.a.b bVar) {
        int g2 = bVar.g();
        return g2 != 0 ? g2 != 1 ? g2 != 2 ? new com.meizu.cloud.pushsdk.c.a.c<>(new com.meizu.cloud.pushsdk.c.b.a()) : d(bVar) : c(bVar) : b(bVar);
    }

    private static <T> com.meizu.cloud.pushsdk.c.a.c<T> b(com.meizu.cloud.pushsdk.c.a.b bVar) {
        try {
            try {
                k a = a.a(bVar);
                if (a == null) {
                    com.meizu.cloud.pushsdk.c.a.c<T> cVar = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a()));
                    com.meizu.cloud.pushsdk.c.h.a.a(a, bVar);
                    return cVar;
                } else if (bVar.f() == e.OK_HTTP_RESPONSE) {
                    com.meizu.cloud.pushsdk.c.a.c<T> cVar2 = new com.meizu.cloud.pushsdk.c.a.c<>(a);
                    cVar2.a(a);
                    com.meizu.cloud.pushsdk.c.h.a.a(a, bVar);
                    return cVar2;
                } else if (a.a() >= 400) {
                    com.meizu.cloud.pushsdk.c.a.c<T> cVar3 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a(a), bVar, a.a()));
                    cVar3.a(a);
                    com.meizu.cloud.pushsdk.c.h.a.a(a, bVar);
                    return cVar3;
                } else {
                    com.meizu.cloud.pushsdk.c.a.c<T> a2 = bVar.a(a);
                    a2.a(a);
                    com.meizu.cloud.pushsdk.c.h.a.a(a, bVar);
                    return a2;
                }
            } catch (com.meizu.cloud.pushsdk.c.b.a e2) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar4 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a(e2)));
                com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
                return cVar4;
            } catch (Exception e3) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar5 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(e3));
                com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
                return cVar5;
            }
        } catch (Throwable th) {
            com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
            throw th;
        }
    }

    private static <T> com.meizu.cloud.pushsdk.c.a.c<T> c(com.meizu.cloud.pushsdk.c.a.b bVar) {
        try {
            k b = a.b(bVar);
            if (b == null) {
                return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a()));
            }
            if (b.a() >= 400) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a(b), bVar, b.a()));
                cVar.a(b);
                return cVar;
            }
            com.meizu.cloud.pushsdk.c.a.c<T> cVar2 = new com.meizu.cloud.pushsdk.c.a.c<>(bp.o);
            cVar2.a(b);
            return cVar2;
        } catch (com.meizu.cloud.pushsdk.c.b.a e2) {
            return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a(e2)));
        } catch (Exception e3) {
            return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(e3));
        }
    }

    private static <T> com.meizu.cloud.pushsdk.c.a.c<T> d(com.meizu.cloud.pushsdk.c.a.b bVar) {
        try {
            try {
                k c2 = a.c(bVar);
                if (c2 == null) {
                    com.meizu.cloud.pushsdk.c.a.c<T> cVar = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a()));
                    com.meizu.cloud.pushsdk.c.h.a.a(c2, bVar);
                    return cVar;
                } else if (bVar.f() == e.OK_HTTP_RESPONSE) {
                    com.meizu.cloud.pushsdk.c.a.c<T> cVar2 = new com.meizu.cloud.pushsdk.c.a.c<>(c2);
                    cVar2.a(c2);
                    com.meizu.cloud.pushsdk.c.h.a.a(c2, bVar);
                    return cVar2;
                } else if (c2.a() >= 400) {
                    com.meizu.cloud.pushsdk.c.a.c<T> cVar3 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a(c2), bVar, c2.a()));
                    cVar3.a(c2);
                    com.meizu.cloud.pushsdk.c.h.a.a(c2, bVar);
                    return cVar3;
                } else {
                    com.meizu.cloud.pushsdk.c.a.c<T> a = bVar.a(c2);
                    a.a(c2);
                    com.meizu.cloud.pushsdk.c.h.a.a(c2, bVar);
                    return a;
                }
            } catch (com.meizu.cloud.pushsdk.c.b.a e2) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar4 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(e2));
                com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
                return cVar4;
            } catch (Exception e3) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar5 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(e3));
                com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
                return cVar5;
            }
        } catch (Throwable th) {
            com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
            throw th;
        }
    }
}
