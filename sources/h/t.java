package h;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkotlin/KotlinVersion;", "", "major", "", "minor", "(II)V", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "version", "compareTo", "other", "equals", "", "", TTDownloadField.TT_HASHCODE, "isAtLeast", "toString", "", "versionOf", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.1")
/* loaded from: classes3.dex */
public final class t implements Comparable<t> {

    /* renamed from: e  reason: collision with root package name */
    public static final int f15671e = 255;
    private final int a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15674c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15675d;
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    public static final a f15673g = new a(null);
    @h.k2.d
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    public static final t f15672f = u.a();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/KotlinVersion$Companion;", "", "()V", "CURRENT", "Lkotlin/KotlinVersion;", "MAX_COMPONENT_VALUE", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public t(int i2, int i3, int i4) {
        this.b = i2;
        this.f15674c = i3;
        this.f15675d = i4;
        this.a = h(i2, i3, i4);
    }

    private final int h(int i2, int i3, int i4) {
        if (i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3 && i4 >= 0 && 255 >= i4) {
            return (i2 << 16) + (i3 << 8) + i4;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i2 + '.' + i3 + '.' + i4).toString());
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@k.e.a.d t tVar) {
        return this.a - tVar.a;
    }

    public final int b() {
        return this.b;
    }

    public final int d() {
        return this.f15674c;
    }

    public final int e() {
        return this.f15675d;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            obj = null;
        }
        t tVar = (t) obj;
        return tVar != null && this.a == tVar.a;
    }

    public final boolean f(int i2, int i3) {
        int i4 = this.b;
        return i4 > i2 || (i4 == i2 && this.f15674c >= i3);
    }

    public final boolean g(int i2, int i3, int i4) {
        int i5;
        int i6 = this.b;
        return i6 > i2 || (i6 == i2 && ((i5 = this.f15674c) > i3 || (i5 == i3 && this.f15675d >= i4)));
    }

    public int hashCode() {
        return this.a;
    }

    @k.e.a.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append('.');
        sb.append(this.f15674c);
        sb.append('.');
        sb.append(this.f15675d);
        return sb.toString();
    }

    public t(int i2, int i3) {
        this(i2, i3, 0);
    }
}
