package e.l.n.f;

import com.google.gson.Gson;
import com.jihuanshe.model.CityCodeSet;
import com.jihuanshe.model.SellCalendar;
import com.jihuanshe.net.converter.CityCodeConverter;
import com.jihuanshe.net.converter.SellCalendarConverter;
import h.k2.v.u;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import l.h;
import l.s;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* loaded from: classes2.dex */
public final class a extends h.a {
    @d
    public static final C0391a b = new C0391a(null);
    @d
    private final Gson a;

    /* renamed from: e.l.n.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0391a {

        /* renamed from: e.l.n.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0392a extends e.j.e.t.a<CityCodeSet> {
        }

        /* renamed from: e.l.n.f.a$a$b */
        /* loaded from: classes2.dex */
        public static final class b extends e.j.e.t.a<SellCalendar> {
        }

        private C0391a() {
        }

        public /* synthetic */ C0391a(u uVar) {
            this();
        }

        @d
        public final a a() {
            return b(new e.j.e.d().l(new C0392a().getType(), new CityCodeConverter()).l(new b().getType(), new SellCalendarConverter()).d());
        }

        @d
        public final a b(@e Gson gson) {
            Objects.requireNonNull(gson, "gson == null");
            return new a(gson, null);
        }
    }

    private a(Gson gson) {
        this.a = gson;
    }

    public /* synthetic */ a(Gson gson, u uVar) {
        this(gson);
    }

    @Override // l.h.a
    @d
    public h<?, RequestBody> c(@e Type type, @e Annotation[] annotationArr, @e Annotation[] annotationArr2, @e s sVar) {
        return new b(this.a, this.a.p(e.j.e.t.a.get(type)));
    }

    @Override // l.h.a
    @d
    public h<ResponseBody, ?> d(@e Type type, @e Annotation[] annotationArr, @e s sVar) {
        return new c(this.a, this.a.p(e.j.e.t.a.get(type)));
    }
}
