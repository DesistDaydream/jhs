package h.h2;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.k2.v.f0;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0013HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013J\t\u0010\u001f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lkotlin/io/FilePathComponents;", "", "root", "Ljava/io/File;", "segments", "", "(Ljava/io/File;Ljava/util/List;)V", "isRooted", "", "()Z", "getRoot", "()Ljava/io/File;", "rootName", "", "getRootName", "()Ljava/lang/String;", "getSegments", "()Ljava/util/List;", "size", "", "getSize", "()I", "component1", "component2", "copy", "equals", "other", TTDownloadField.TT_HASHCODE, "subPath", "beginIndex", "endIndex", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class g {
    @k.e.a.d
    private final File a;
    @k.e.a.d
    private final List<File> b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@k.e.a.d File file, @k.e.a.d List<? extends File> list) {
        this.a = file;
        this.b = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ g d(g gVar, File file, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            file = gVar.a;
        }
        if ((i2 & 2) != 0) {
            list = gVar.b;
        }
        return gVar.c(file, list);
    }

    @k.e.a.d
    public final File a() {
        return this.a;
    }

    @k.e.a.d
    public final List<File> b() {
        return this.b;
    }

    @k.e.a.d
    public final g c(@k.e.a.d File file, @k.e.a.d List<? extends File> list) {
        return new g(file, list);
    }

    @k.e.a.d
    public final File e() {
        return this.a;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                return f0.g(this.a, gVar.a) && f0.g(this.b, gVar.b);
            }
            return false;
        }
        return true;
    }

    @k.e.a.d
    public final String f() {
        return this.a.getPath();
    }

    @k.e.a.d
    public final List<File> g() {
        return this.b;
    }

    public final int h() {
        return this.b.size();
    }

    public int hashCode() {
        File file = this.a;
        int hashCode = (file != null ? file.hashCode() : 0) * 31;
        List<File> list = this.b;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public final boolean i() {
        return this.a.getPath().length() > 0;
    }

    @k.e.a.d
    public final File j(int i2, int i3) {
        if (i2 >= 0 && i2 <= i3 && i3 <= h()) {
            return new File(CollectionsKt___CollectionsKt.Z2(this.b.subList(i2, i3), File.separator, null, null, 0, null, null, 62, null));
        }
        throw new IllegalArgumentException();
    }

    @k.e.a.d
    public String toString() {
        return "FilePathComponents(root=" + this.a + ", segments=" + this.b + ")";
    }
}
