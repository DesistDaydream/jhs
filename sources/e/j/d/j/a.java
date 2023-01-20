package e.j.d.j;

import java.util.Objects;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
public final class a extends e {
    private final String a;
    private final String b;

    public a(String str, String str2) {
        Objects.requireNonNull(str, "Null libraryName");
        this.a = str;
        Objects.requireNonNull(str2, "Null version");
        this.b = str2;
    }

    @Override // e.j.d.j.e
    @Nonnull
    public String b() {
        return this.a;
    }

    @Override // e.j.d.j.e
    @Nonnull
    public String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.a.equals(eVar.b()) && this.b.equals(eVar.c());
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.a + ", version=" + this.b + "}";
    }
}
