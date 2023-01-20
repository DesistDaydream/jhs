package h.p2.b0.g.t.f.z;

import h.k2.v.f0;
import h.k2.v.u;
import h.p2.b0.g.t.i.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes3.dex */
public final class h {
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    public static final a f15398f = new a(null);
    @k.e.a.d
    private final b a;
    @k.e.a.d
    private final ProtoBuf.VersionRequirement.VersionKind b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final DeprecationLevel f15399c;
    @k.e.a.e

    /* renamed from: d  reason: collision with root package name */
    private final Integer f15400d;
    @k.e.a.e

    /* renamed from: e  reason: collision with root package name */
    private final String f15401e;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: h.p2.b0.g.t.f.z.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public /* synthetic */ class C0457a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[ProtoBuf.VersionRequirement.Level.values().length];
                iArr[ProtoBuf.VersionRequirement.Level.WARNING.ordinal()] = 1;
                iArr[ProtoBuf.VersionRequirement.Level.ERROR.ordinal()] = 2;
                iArr[ProtoBuf.VersionRequirement.Level.HIDDEN.ordinal()] = 3;
                a = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k.e.a.d
        public final List<h> a(@k.e.a.d n nVar, @k.e.a.d c cVar, @k.e.a.d i iVar) {
            List<Integer> versionRequirementList;
            if (nVar instanceof ProtoBuf.Class) {
                versionRequirementList = ((ProtoBuf.Class) nVar).getVersionRequirementList();
            } else if (nVar instanceof ProtoBuf.Constructor) {
                versionRequirementList = ((ProtoBuf.Constructor) nVar).getVersionRequirementList();
            } else if (nVar instanceof ProtoBuf.Function) {
                versionRequirementList = ((ProtoBuf.Function) nVar).getVersionRequirementList();
            } else if (nVar instanceof ProtoBuf.Property) {
                versionRequirementList = ((ProtoBuf.Property) nVar).getVersionRequirementList();
            } else if (!(nVar instanceof ProtoBuf.TypeAlias)) {
                throw new IllegalStateException(f0.C("Unexpected declaration: ", nVar.getClass()));
            } else {
                versionRequirementList = ((ProtoBuf.TypeAlias) nVar).getVersionRequirementList();
            }
            ArrayList arrayList = new ArrayList();
            for (Integer num : versionRequirementList) {
                h b = h.f15398f.b(num.intValue(), cVar, iVar);
                if (b != null) {
                    arrayList.add(b);
                }
            }
            return arrayList;
        }

        @k.e.a.e
        public final h b(int i2, @k.e.a.d c cVar, @k.e.a.d i iVar) {
            DeprecationLevel deprecationLevel;
            ProtoBuf.VersionRequirement b = iVar.b(i2);
            if (b == null) {
                return null;
            }
            b a = b.f15402d.a(b.hasVersion() ? Integer.valueOf(b.getVersion()) : null, b.hasVersionFull() ? Integer.valueOf(b.getVersionFull()) : null);
            int i3 = C0457a.a[b.getLevel().ordinal()];
            if (i3 == 1) {
                deprecationLevel = DeprecationLevel.WARNING;
            } else if (i3 == 2) {
                deprecationLevel = DeprecationLevel.ERROR;
            } else if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                deprecationLevel = DeprecationLevel.HIDDEN;
            }
            return new h(a, b.getVersionKind(), deprecationLevel, b.hasErrorCode() ? Integer.valueOf(b.getErrorCode()) : null, b.hasMessage() ? cVar.getString(b.getMessage()) : null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        @k.e.a.d

        /* renamed from: d  reason: collision with root package name */
        public static final a f15402d = new a(null);
        @h.k2.d
        @k.e.a.d

        /* renamed from: e  reason: collision with root package name */
        public static final b f15403e = new b(256, 256, 256);
        private final int a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f15404c;

        /* loaded from: classes3.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(u uVar) {
                this();
            }

            @k.e.a.d
            public final b a(@k.e.a.e Integer num, @k.e.a.e Integer num2) {
                if (num2 != null) {
                    return new b(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255);
                }
                if (num != null) {
                    return new b(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & 127);
                }
                return b.f15403e;
            }
        }

        public b(int i2, int i3, int i4) {
            this.a = i2;
            this.b = i3;
            this.f15404c = i4;
        }

        @k.e.a.d
        public final String a() {
            StringBuilder sb;
            int i2;
            if (this.f15404c == 0) {
                sb = new StringBuilder();
                sb.append(this.a);
                sb.append('.');
                i2 = this.b;
            } else {
                sb = new StringBuilder();
                sb.append(this.a);
                sb.append('.');
                sb.append(this.b);
                sb.append('.');
                i2 = this.f15404c;
            }
            sb.append(i2);
            return sb.toString();
        }

        public boolean equals(@k.e.a.e Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.a == bVar.a && this.b == bVar.b && this.f15404c == bVar.f15404c;
            }
            return false;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.f15404c;
        }

        @k.e.a.d
        public String toString() {
            return a();
        }

        public /* synthetic */ b(int i2, int i3, int i4, int i5, u uVar) {
            this(i2, i3, (i5 & 4) != 0 ? 0 : i4);
        }
    }

    public h(@k.e.a.d b bVar, @k.e.a.d ProtoBuf.VersionRequirement.VersionKind versionKind, @k.e.a.d DeprecationLevel deprecationLevel, @k.e.a.e Integer num, @k.e.a.e String str) {
        this.a = bVar;
        this.b = versionKind;
        this.f15399c = deprecationLevel;
        this.f15400d = num;
        this.f15401e = str;
    }

    @k.e.a.d
    public final ProtoBuf.VersionRequirement.VersionKind a() {
        return this.b;
    }

    @k.e.a.d
    public final b b() {
        return this.a;
    }

    @k.e.a.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("since ");
        sb.append(this.a);
        sb.append(' ');
        sb.append(this.f15399c);
        Integer num = this.f15400d;
        sb.append(num != null ? f0.C(" error ", num) : "");
        String str = this.f15401e;
        sb.append(str != null ? f0.C(": ", str) : "");
        return sb.toString();
    }
}
