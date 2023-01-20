package okhttp3.internal.io;

import com.moor.imkf.lib.jsoup.nodes.DocumentType;
import com.tencent.android.tpush.common.MessageKey;
import h.k2.d;
import h.k2.v.u;
import j.a0;
import j.k0;
import j.m0;
import j.z;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\bf\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\r¨\u0006\u001b"}, d2 = {"Lokhttp3/internal/io/FileSystem;", "", "Ljava/io/File;", "file", "Lj/m0;", MessageKey.MSG_SOURCE, "(Ljava/io/File;)Lj/m0;", "Lj/k0;", "sink", "(Ljava/io/File;)Lj/k0;", "appendingSink", "Lh/t1;", "delete", "(Ljava/io/File;)V", "", "exists", "(Ljava/io/File;)Z", "", "size", "(Ljava/io/File;)J", "from", "to", "rename", "(Ljava/io/File;Ljava/io/File;)V", "directory", "deleteContents", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface FileSystem {
    public static final Companion Companion = new Companion(null);
    @d
    @k.e.a.d
    public static final FileSystem SYSTEM = new Companion.SystemFileSystem();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001\u0082\u0002\u0007\n\u0005\b\u0091F0\u0001¨\u0006\b"}, d2 = {"Lokhttp3/internal/io/FileSystem$Companion;", "", "Lokhttp3/internal/io/FileSystem;", DocumentType.SYSTEM_KEY, "Lokhttp3/internal/io/FileSystem;", "<init>", "()V", "SystemFileSystem", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = null;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\rJ\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/io/FileSystem$Companion$SystemFileSystem;", "Lokhttp3/internal/io/FileSystem;", "Ljava/io/File;", "file", "Lj/m0;", MessageKey.MSG_SOURCE, "(Ljava/io/File;)Lj/m0;", "Lj/k0;", "sink", "(Ljava/io/File;)Lj/k0;", "appendingSink", "Lh/t1;", "delete", "(Ljava/io/File;)V", "", "exists", "(Ljava/io/File;)Z", "", "size", "(Ljava/io/File;)J", "from", "to", "rename", "(Ljava/io/File;Ljava/io/File;)V", "directory", "deleteContents", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes4.dex */
        public static final class SystemFileSystem implements FileSystem {
            @Override // okhttp3.internal.io.FileSystem
            @k.e.a.d
            public k0 appendingSink(@k.e.a.d File file) throws FileNotFoundException {
                try {
                    return z.a(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return z.a(file);
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public void delete(@k.e.a.d File file) throws IOException {
                if (file.delete() || !file.exists()) {
                    return;
                }
                throw new IOException("failed to delete " + file);
            }

            @Override // okhttp3.internal.io.FileSystem
            public void deleteContents(@k.e.a.d File file) throws IOException {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            deleteContents(file2);
                        }
                        if (!file2.delete()) {
                            throw new IOException("failed to delete " + file2);
                        }
                    }
                    return;
                }
                throw new IOException("not a readable directory: " + file);
            }

            @Override // okhttp3.internal.io.FileSystem
            public boolean exists(@k.e.a.d File file) {
                return file.exists();
            }

            @Override // okhttp3.internal.io.FileSystem
            public void rename(@k.e.a.d File file, @k.e.a.d File file2) throws IOException {
                delete(file2);
                if (file.renameTo(file2)) {
                    return;
                }
                throw new IOException("failed to rename " + file + " to " + file2);
            }

            @Override // okhttp3.internal.io.FileSystem
            @k.e.a.d
            public k0 sink(@k.e.a.d File file) throws FileNotFoundException {
                try {
                    return a0.j(file, false, 1, null);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return a0.j(file, false, 1, null);
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public long size(@k.e.a.d File file) {
                return file.length();
            }

            @Override // okhttp3.internal.io.FileSystem
            @k.e.a.d
            public m0 source(@k.e.a.d File file) throws FileNotFoundException {
                return z.l(file);
            }

            @k.e.a.d
            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    @k.e.a.d
    k0 appendingSink(@k.e.a.d File file) throws FileNotFoundException;

    void delete(@k.e.a.d File file) throws IOException;

    void deleteContents(@k.e.a.d File file) throws IOException;

    boolean exists(@k.e.a.d File file);

    void rename(@k.e.a.d File file, @k.e.a.d File file2) throws IOException;

    @k.e.a.d
    k0 sink(@k.e.a.d File file) throws FileNotFoundException;

    long size(@k.e.a.d File file);

    @k.e.a.d
    m0 source(@k.e.a.d File file) throws FileNotFoundException;
}
