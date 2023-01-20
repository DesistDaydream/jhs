package e.t.m;

import android.content.Context;
import java.io.File;
import java.io.InputStream;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000bH&J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\u0013J\u001a\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u0016"}, d2 = {"Lcom/vector/filecompat/CompatFile;", "", "copy", "", "file", "Ljava/io/File;", "context", "Landroid/content/Context;", "exists", "", "getAbsolutePath", "", "rootDir", "getInputStream", "Ljava/io/InputStream;", "getName", "parent", "readString", "saveToAlbum", "(Landroid/content/Context;)Ljava/lang/Boolean;", "write", k.b.a.a.n.n.c.b, "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface b {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, File file, Context context, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
            }
            if ((i2 & 2) != 0) {
                context = e.t.a.b();
            }
            bVar.c(file, context);
        }

        public static /* synthetic */ InputStream b(b bVar, Context context, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    context = e.t.a.b();
                }
                return bVar.h(context);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInputStream");
        }

        public static /* synthetic */ String c(b bVar, Context context, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    context = e.t.a.b();
                }
                return bVar.b(context);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getName");
        }

        public static /* synthetic */ Boolean d(b bVar, Context context, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    context = e.t.a.b();
                }
                return bVar.a(context);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveToAlbum");
        }

        public static /* synthetic */ void e(b bVar, Object obj, Context context, int i2, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
            }
            if ((i2 & 2) != 0) {
                context = e.t.a.b();
            }
            bVar.e(obj, context);
        }
    }

    @k.e.a.e
    Boolean a(@k.e.a.d Context context);

    @k.e.a.e
    String b(@k.e.a.d Context context);

    void c(@k.e.a.d File file, @k.e.a.d Context context);

    boolean d();

    void e(@k.e.a.d Object obj, @k.e.a.d Context context);

    @k.e.a.e
    b f(@k.e.a.e String str);

    @k.e.a.e
    String g(@k.e.a.e String str);

    @k.e.a.e
    InputStream h(@k.e.a.d Context context);

    @k.e.a.e
    String i();
}
