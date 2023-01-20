package h.p2.b0.g.t.e.b.x;

import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.e.a.p;
import h.p2.b0.g.t.e.b.m;
import h.p2.b0.g.t.g.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k.e.a.e;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;

/* loaded from: classes3.dex */
public class a implements m.c {

    /* renamed from: i  reason: collision with root package name */
    private static final boolean f15348i = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));

    /* renamed from: j  reason: collision with root package name */
    private static final Map<h.p2.b0.g.t.g.b, KotlinClassHeader.Kind> f15349j;
    private int[] a = null;
    private String b = null;

    /* renamed from: c  reason: collision with root package name */
    private int f15350c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f15351d = null;

    /* renamed from: e  reason: collision with root package name */
    private String[] f15352e = null;

    /* renamed from: f  reason: collision with root package name */
    private String[] f15353f = null;

    /* renamed from: g  reason: collision with root package name */
    private String[] f15354g = null;

    /* renamed from: h  reason: collision with root package name */
    private KotlinClassHeader.Kind f15355h = null;

    /* loaded from: classes3.dex */
    public static abstract class b implements m.b {
        private final List<String> a = new ArrayList();

        private static /* synthetic */ void f(int i2) {
            Object[] objArr = new Object[3];
            if (i2 == 1) {
                objArr[0] = "enumEntryName";
            } else if (i2 == 2) {
                objArr[0] = "classLiteralValue";
            } else if (i2 != 3) {
                objArr[0] = "enumClassId";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i2 == 2) {
                objArr[2] = "visitClassLiteral";
            } else if (i2 != 3) {
                objArr[2] = "visitEnum";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // h.p2.b0.g.t.e.b.m.b
        public void a() {
            g((String[]) this.a.toArray(new String[0]));
        }

        @Override // h.p2.b0.g.t.e.b.m.b
        @e
        public m.a b(@k.e.a.d h.p2.b0.g.t.g.b bVar) {
            if (bVar == null) {
                f(3);
                return null;
            }
            return null;
        }

        @Override // h.p2.b0.g.t.e.b.m.b
        public void c(@e Object obj) {
            if (obj instanceof String) {
                this.a.add((String) obj);
            }
        }

        @Override // h.p2.b0.g.t.e.b.m.b
        public void d(@k.e.a.d h.p2.b0.g.t.g.b bVar, @k.e.a.d f fVar) {
            if (bVar == null) {
                f(0);
            }
            if (fVar == null) {
                f(1);
            }
        }

        @Override // h.p2.b0.g.t.e.b.m.b
        public void e(@k.e.a.d h.p2.b0.g.t.k.n.f fVar) {
            if (fVar == null) {
                f(2);
            }
        }

        public abstract void g(@k.e.a.d String[] strArr);
    }

    /* loaded from: classes3.dex */
    public class c implements m.a {

        /* renamed from: h.p2.b0.g.t.e.b.x.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0452a extends b {
            public C0452a() {
            }

            private static /* synthetic */ void f(int i2) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
            }

            @Override // h.p2.b0.g.t.e.b.x.a.b
            public void g(@k.e.a.d String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                a.this.f15352e = strArr;
            }
        }

        /* loaded from: classes3.dex */
        public class b extends b {
            public b() {
            }

            private static /* synthetic */ void f(int i2) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
            }

            @Override // h.p2.b0.g.t.e.b.x.a.b
            public void g(@k.e.a.d String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                a.this.f15353f = strArr;
            }
        }

        private c() {
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i2 == 7) {
                objArr[0] = "classId";
            } else if (i2 == 4) {
                objArr[0] = "enumClassId";
            } else if (i2 != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            switch (i2) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @k.e.a.d
        private m.b h() {
            return new C0452a();
        }

        @k.e.a.d
        private m.b i() {
            return new b();
        }

        @Override // h.p2.b0.g.t.e.b.m.a
        public void a() {
        }

        @Override // h.p2.b0.g.t.e.b.m.a
        public void b(@k.e.a.d f fVar, @k.e.a.d h.p2.b0.g.t.g.b bVar, @k.e.a.d f fVar2) {
            if (fVar == null) {
                g(3);
            }
            if (bVar == null) {
                g(4);
            }
            if (fVar2 == null) {
                g(5);
            }
        }

        @Override // h.p2.b0.g.t.e.b.m.a
        @e
        public m.a c(@k.e.a.d f fVar, @k.e.a.d h.p2.b0.g.t.g.b bVar) {
            if (fVar == null) {
                g(6);
            }
            if (bVar == null) {
                g(7);
                return null;
            }
            return null;
        }

        @Override // h.p2.b0.g.t.e.b.m.a
        public void d(@k.e.a.d f fVar, @k.e.a.d h.p2.b0.g.t.k.n.f fVar2) {
            if (fVar == null) {
                g(0);
            }
            if (fVar2 == null) {
                g(1);
            }
        }

        @Override // h.p2.b0.g.t.e.b.m.a
        public void e(@e f fVar, @e Object obj) {
            if (fVar == null) {
                return;
            }
            String b2 = fVar.b();
            if ("k".equals(b2)) {
                if (obj instanceof Integer) {
                    a.this.f15355h = KotlinClassHeader.Kind.getById(((Integer) obj).intValue());
                }
            } else if ("mv".equals(b2)) {
                if (obj instanceof int[]) {
                    a.this.a = (int[]) obj;
                }
            } else if ("xs".equals(b2)) {
                if (obj instanceof String) {
                    a.this.b = (String) obj;
                }
            } else if ("xi".equals(b2)) {
                if (obj instanceof Integer) {
                    a.this.f15350c = ((Integer) obj).intValue();
                }
            } else if ("pn".equals(b2) && (obj instanceof String)) {
                a.this.f15351d = (String) obj;
            }
        }

        @Override // h.p2.b0.g.t.e.b.m.a
        @e
        public m.b f(@k.e.a.d f fVar) {
            if (fVar == null) {
                g(2);
            }
            String b2 = fVar.b();
            if ("d1".equals(b2)) {
                return h();
            }
            if ("d2".equals(b2)) {
                return i();
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements m.a {

        /* renamed from: h.p2.b0.g.t.e.b.x.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0453a extends b {
            public C0453a() {
            }

            private static /* synthetic */ void f(int i2) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
            }

            @Override // h.p2.b0.g.t.e.b.x.a.b
            public void g(@k.e.a.d String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                a.this.f15352e = strArr;
            }
        }

        /* loaded from: classes3.dex */
        public class b extends b {
            public b() {
            }

            private static /* synthetic */ void f(int i2) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
            }

            @Override // h.p2.b0.g.t.e.b.x.a.b
            public void g(@k.e.a.d String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                a.this.f15353f = strArr;
            }
        }

        private d() {
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i2 == 7) {
                objArr[0] = "classId";
            } else if (i2 == 4) {
                objArr[0] = "enumClassId";
            } else if (i2 != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            switch (i2) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @k.e.a.d
        private m.b h() {
            return new C0453a();
        }

        @k.e.a.d
        private m.b i() {
            return new b();
        }

        @Override // h.p2.b0.g.t.e.b.m.a
        public void a() {
        }

        @Override // h.p2.b0.g.t.e.b.m.a
        public void b(@k.e.a.d f fVar, @k.e.a.d h.p2.b0.g.t.g.b bVar, @k.e.a.d f fVar2) {
            if (fVar == null) {
                g(3);
            }
            if (bVar == null) {
                g(4);
            }
            if (fVar2 == null) {
                g(5);
            }
        }

        @Override // h.p2.b0.g.t.e.b.m.a
        @e
        public m.a c(@k.e.a.d f fVar, @k.e.a.d h.p2.b0.g.t.g.b bVar) {
            if (fVar == null) {
                g(6);
            }
            if (bVar == null) {
                g(7);
                return null;
            }
            return null;
        }

        @Override // h.p2.b0.g.t.e.b.m.a
        public void d(@k.e.a.d f fVar, @k.e.a.d h.p2.b0.g.t.k.n.f fVar2) {
            if (fVar == null) {
                g(0);
            }
            if (fVar2 == null) {
                g(1);
            }
        }

        @Override // h.p2.b0.g.t.e.b.m.a
        public void e(@e f fVar, @e Object obj) {
            if (fVar == null) {
                return;
            }
            String b2 = fVar.b();
            if ("version".equals(b2)) {
                if (obj instanceof int[]) {
                    a.this.a = (int[]) obj;
                }
            } else if ("multifileClassName".equals(b2)) {
                a.this.b = obj instanceof String ? (String) obj : null;
            }
        }

        @Override // h.p2.b0.g.t.e.b.m.a
        @e
        public m.b f(@k.e.a.d f fVar) {
            if (fVar == null) {
                g(2);
            }
            String b2 = fVar.b();
            if (!"data".equals(b2) && !"filePartClassNames".equals(b2)) {
                if ("strings".equals(b2)) {
                    return i();
                }
                return null;
            }
            return h();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f15349j = hashMap;
        hashMap.put(h.p2.b0.g.t.g.b.m(new h.p2.b0.g.t.g.c("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.Kind.CLASS);
        hashMap.put(h.p2.b0.g.t.g.b.m(new h.p2.b0.g.t.g.c("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.Kind.FILE_FACADE);
        hashMap.put(h.p2.b0.g.t.g.b.m(new h.p2.b0.g.t.g.c("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.Kind.MULTIFILE_CLASS);
        hashMap.put(h.p2.b0.g.t.g.b.m(new h.p2.b0.g.t.g.c("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        hashMap.put(h.p2.b0.g.t.g.b.m(new h.p2.b0.g.t.g.c("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.Kind.SYNTHETIC_CLASS);
    }

    private static /* synthetic */ void d(int i2) {
        Object[] objArr = new Object[3];
        if (i2 != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = MessageKey.MSG_SOURCE;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    private boolean m() {
        KotlinClassHeader.Kind kind = this.f15355h;
        return kind == KotlinClassHeader.Kind.CLASS || kind == KotlinClassHeader.Kind.FILE_FACADE || kind == KotlinClassHeader.Kind.MULTIFILE_CLASS_PART;
    }

    @Override // h.p2.b0.g.t.e.b.m.c
    public void a() {
    }

    @Override // h.p2.b0.g.t.e.b.m.c
    @e
    public m.a c(@k.e.a.d h.p2.b0.g.t.g.b bVar, @k.e.a.d o0 o0Var) {
        KotlinClassHeader.Kind kind;
        if (bVar == null) {
            d(0);
        }
        if (o0Var == null) {
            d(1);
        }
        if (bVar.b().equals(p.a)) {
            return new c();
        }
        if (f15348i || this.f15355h != null || (kind = f15349j.get(bVar)) == null) {
            return null;
        }
        this.f15355h = kind;
        return new d();
    }

    @e
    public KotlinClassHeader l() {
        if (this.f15355h == null || this.a == null) {
            return null;
        }
        h.p2.b0.g.t.f.a0.f.e eVar = new h.p2.b0.g.t.f.a0.f.e(this.a, (this.f15350c & 8) != 0);
        if (!eVar.h()) {
            this.f15354g = this.f15352e;
            this.f15352e = null;
        } else if (m() && this.f15352e == null) {
            return null;
        }
        return new KotlinClassHeader(this.f15355h, eVar, this.f15352e, this.f15354g, this.f15353f, this.b, this.f15350c, this.f15351d);
    }
}
