package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import e.j.d.d.e;
import e.j.d.d.i;
import e.j.d.d.o;
import e.j.d.e.d;
import e.j.d.f.l;
import e.j.d.f.m;
import e.j.d.j.f;
import e.j.d.j.g;
import java.util.Arrays;
import java.util.List;

@e.j.a.b.c.m.a
@Keep
/* loaded from: classes2.dex */
public final class Registrar implements i {

    /* loaded from: classes2.dex */
    public static class a implements e.j.d.f.d.a {
        private final FirebaseInstanceId a;

        public a(FirebaseInstanceId firebaseInstanceId) {
            this.a = firebaseInstanceId;
        }

        @Override // e.j.d.f.d.a
        public final String getId() {
            return this.a.d();
        }

        @Override // e.j.d.f.d.a
        public final String getToken() {
            return this.a.g();
        }
    }

    @Override // e.j.d.d.i
    @Keep
    public final List<e<?>> getComponents() {
        return Arrays.asList(e.a(FirebaseInstanceId.class).b(o.g(FirebaseApp.class)).b(o.g(d.class)).b(o.g(g.class)).f(l.a).c().d(), e.a(e.j.d.f.d.a.class).b(o.g(FirebaseInstanceId.class)).f(m.a).d(), f.a("fire-iid", "19.0.1"));
    }
}
