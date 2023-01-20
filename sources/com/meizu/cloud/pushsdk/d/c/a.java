package com.meizu.cloud.pushsdk.d.c;

import com.meizu.cloud.pushsdk.d.a.c;
import com.meizu.cloud.pushsdk.d.f.d;
import com.meizu.cloud.pushsdk.d.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class a {
    private final List<com.meizu.cloud.pushsdk.d.a.b> a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4832c;

    /* renamed from: com.meizu.cloud.pushsdk.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0159a<T extends AbstractC0159a<T>> {
        private List<com.meizu.cloud.pushsdk.d.a.b> a = new LinkedList();
        private long b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        private String f4833c = e.b();

        public abstract T a();

        public T a(long j2) {
            this.b = j2;
            return a();
        }
    }

    public a(AbstractC0159a<?> abstractC0159a) {
        d.a(((AbstractC0159a) abstractC0159a).a);
        d.a(((AbstractC0159a) abstractC0159a).f4833c);
        d.a(!((AbstractC0159a) abstractC0159a).f4833c.isEmpty(), "eventId cannot be empty");
        this.a = ((AbstractC0159a) abstractC0159a).a;
        this.b = ((AbstractC0159a) abstractC0159a).b;
        this.f4832c = ((AbstractC0159a) abstractC0159a).f4833c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.d.a.b> a() {
        return new ArrayList(this.a);
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.f4832c;
    }
}
