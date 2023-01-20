package e.j.a.b.c.t;

import java.util.concurrent.ScheduledExecutorService;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class a {
    private static InterfaceC0344a a;

    /* renamed from: e.j.a.b.c.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0344a {
        @e.j.a.b.c.m.a
        ScheduledExecutorService a();
    }

    private a() {
    }

    @e.j.a.b.c.m.a
    public static synchronized InterfaceC0344a a() {
        InterfaceC0344a interfaceC0344a;
        synchronized (a.class) {
            if (a == null) {
                a = new b();
            }
            interfaceC0344a = a;
        }
        return interfaceC0344a;
    }
}
