package e.t.p;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.vector.gson.EnumTypeAdapterFactory;
import com.vector.gson.LiveTypeAdapterFactory;
import e.j.e.q;
import h.k2.k;
import h.k2.v.u;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import k.b.a.a.n.n.c;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J+\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0012¢\u0006\u0002\u0010\u0013J%\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/vector/gson/DecorGson;", "", "()V", "escapeHtmlChars", "", "factories", "", "Lcom/google/gson/TypeAdapterFactory;", "gson", "Lcom/google/gson/Gson;", "addDefaultFactories", "", "build", "fromJson", ExifInterface.GPS_DIRECTION_TRUE, "json", "", "classOfT", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "toJson", c.b, "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    @d

    /* renamed from: d */
    public static final C0416a f14605d = new C0416a(null);
    @d
    private final List<q> a;
    private boolean b;

    /* renamed from: c */
    private Gson f14606c;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/vector/gson/DecorGson$Companion;", "", "()V", "create", "Lcom/vector/gson/DecorGson;", "fs", "", "Lcom/google/gson/TypeAdapterFactory;", "escapeHtmlChars", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: e.t.p.a$a */
    /* loaded from: classes3.dex */
    public static final class C0416a {
        private C0416a() {
        }

        public /* synthetic */ C0416a(u uVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ a b(C0416a c0416a, List list, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = null;
            }
            if ((i2 & 2) != 0) {
                z = true;
            }
            return c0416a.a(list, z);
        }

        @k
        @d
        public final a a(@e List<? extends q> list, boolean z) {
            a aVar = new a(null);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    q qVar = (q) obj;
                    if (((qVar instanceof EnumTypeAdapterFactory) || (qVar instanceof LiveTypeAdapterFactory)) ? false : true) {
                        arrayList.add(obj);
                    }
                }
                aVar.a.addAll(arrayList);
            }
            aVar.b = z;
            aVar.e();
            return aVar;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/vector/gson/DecorGson$build$builder$1", "Lcom/google/gson/ExclusionStrategy;", "shouldSkipClass", "", "clazz", "Ljava/lang/Class;", "shouldSkipField", "f", "Lcom/google/gson/FieldAttributes;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b implements e.j.e.a {
        @Override // e.j.e.a
        public boolean a(@e e.j.e.b bVar) {
            return (bVar == null ? null : (e.t.p.b) bVar.b(e.t.p.b.class)) != null;
        }

        @Override // e.j.e.a
        public boolean b(@e Class<?> cls) {
            return false;
        }
    }

    private a() {
        this.a = new ArrayList();
    }

    public /* synthetic */ a(u uVar) {
        this();
    }

    private final void d() {
        this.a.add(new EnumTypeAdapterFactory());
        this.a.add(new LiveTypeAdapterFactory());
    }

    public final void e() {
        e.j.e.d t = new e.j.e.d().t(new b());
        if (this.b) {
            t.e();
        }
        d();
        for (q qVar : this.a) {
            t.m(qVar);
        }
        this.f14606c = t.d();
    }

    @k
    @d
    public static final a f(@e List<? extends q> list, boolean z) {
        return f14605d.a(list, z);
    }

    @e
    public final <T> T g(@e String str, @d Class<T> cls) throws JsonSyntaxException {
        Gson gson = this.f14606c;
        Objects.requireNonNull(gson);
        return (T) gson.n(str, cls);
    }

    @e
    public final <T> T h(@e String str, @d Type type) throws JsonSyntaxException {
        Gson gson = this.f14606c;
        Objects.requireNonNull(gson);
        return (T) gson.o(str, type);
    }

    @d
    public final String i(@e Object obj) {
        Gson gson = this.f14606c;
        Objects.requireNonNull(gson);
        return gson.z(obj);
    }
}
