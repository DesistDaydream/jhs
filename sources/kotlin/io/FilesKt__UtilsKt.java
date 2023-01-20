package kotlin.io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.m7.imkfsdk.utils.MimeTypeParser;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import h.h2.a;
import h.h2.b;
import h.h2.g;
import h.h2.k;
import h.h2.l;
import h.i;
import h.k2.u.p;
import h.k2.v.f0;
import h.t2.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007\u001a*\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007\u001a8\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u001a&\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u000f*\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u0002*\u00020\u0002\u001a\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0002¢\u0006\u0002\b\u001e\u001a\u0011\u0010\u001c\u001a\u00020\u001f*\u00020\u001fH\u0002¢\u0006\u0002\b\u001e\u001a\u0012\u0010 \u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0014\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u001b\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0002\b*\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006+"}, d2 = {MimeTypeParser.ATTR_EXTENSION, "", "Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "createTempDir", "prefix", "suffix", "directory", "createTempFile", "copyRecursively", "", TypedValues.Attributes.S_TARGET, "overwrite", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "copyTo", "bufferSize", "", "deleteRecursively", "endsWith", "other", "normalize", "", "normalize$FilesKt__UtilsKt", "Lkotlin/io/FilePathComponents;", "relativeTo", "base", "relativeToOrNull", "relativeToOrSelf", "resolve", "relative", "resolveSibling", "startsWith", "toRelativeString", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/io/FilesKt")
/* loaded from: classes3.dex */
public class FilesKt__UtilsKt extends l {
    /* JADX WARN: Removed duplicated region for block: B:124:0x00a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0091 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean N(@k.e.a.d java.io.File r11, @k.e.a.d java.io.File r12, boolean r13, @k.e.a.d h.k2.u.p<? super java.io.File, ? super java.io.IOException, ? extends kotlin.io.OnErrorAction> r14) {
        /*
            boolean r0 = r11.exists()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L21
            kotlin.io.NoSuchFileException r12 = new kotlin.io.NoSuchFileException
            r5 = 0
            r7 = 2
            r8 = 0
            java.lang.String r6 = "The source file doesn't exist."
            r3 = r12
            r4 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            java.lang.Object r11 = r14.invoke(r11, r12)
            kotlin.io.OnErrorAction r11 = (kotlin.io.OnErrorAction) r11
            kotlin.io.OnErrorAction r12 = kotlin.io.OnErrorAction.TERMINATE
            if (r11 == r12) goto L1f
            goto L20
        L1f:
            r1 = 0
        L20:
            return r1
        L21:
            h.h2.h r0 = h.h2.l.M(r11)     // Catch: kotlin.io.TerminateException -> Ld5
            kotlin.io.FilesKt__UtilsKt$copyRecursively$2 r3 = new kotlin.io.FilesKt__UtilsKt$copyRecursively$2     // Catch: kotlin.io.TerminateException -> Ld5
            r3.<init>(r14)     // Catch: kotlin.io.TerminateException -> Ld5
            h.h2.h r0 = r0.k(r3)     // Catch: kotlin.io.TerminateException -> Ld5
            java.util.Iterator r0 = r0.iterator()     // Catch: kotlin.io.TerminateException -> Ld5
        L32:
            boolean r3 = r0.hasNext()     // Catch: kotlin.io.TerminateException -> Ld5
            if (r3 == 0) goto Ld4
            java.lang.Object r3 = r0.next()     // Catch: kotlin.io.TerminateException -> Ld5
            java.io.File r3 = (java.io.File) r3     // Catch: kotlin.io.TerminateException -> Ld5
            boolean r4 = r3.exists()     // Catch: kotlin.io.TerminateException -> Ld5
            if (r4 != 0) goto L5b
            kotlin.io.NoSuchFileException r10 = new kotlin.io.NoSuchFileException     // Catch: kotlin.io.TerminateException -> Ld5
            r6 = 0
            java.lang.String r7 = "The source file doesn't exist."
            r8 = 2
            r9 = 0
            r4 = r10
            r5 = r3
            r4.<init>(r5, r6, r7, r8, r9)     // Catch: kotlin.io.TerminateException -> Ld5
            java.lang.Object r3 = r14.invoke(r3, r10)     // Catch: kotlin.io.TerminateException -> Ld5
            kotlin.io.OnErrorAction r3 = (kotlin.io.OnErrorAction) r3     // Catch: kotlin.io.TerminateException -> Ld5
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch: kotlin.io.TerminateException -> Ld5
            if (r3 != r4) goto L32
            return r2
        L5b:
            java.lang.String r4 = n0(r3, r11)     // Catch: kotlin.io.TerminateException -> Ld5
            java.io.File r5 = new java.io.File     // Catch: kotlin.io.TerminateException -> Ld5
            r5.<init>(r12, r4)     // Catch: kotlin.io.TerminateException -> Ld5
            boolean r4 = r5.exists()     // Catch: kotlin.io.TerminateException -> Ld5
            if (r4 == 0) goto La3
            boolean r4 = r3.isDirectory()     // Catch: kotlin.io.TerminateException -> Ld5
            if (r4 == 0) goto L76
            boolean r4 = r5.isDirectory()     // Catch: kotlin.io.TerminateException -> Ld5
            if (r4 != 0) goto La3
        L76:
            if (r13 != 0) goto L7a
        L78:
            r4 = 1
            goto L8f
        L7a:
            boolean r4 = r5.isDirectory()     // Catch: kotlin.io.TerminateException -> Ld5
            if (r4 == 0) goto L87
            boolean r4 = V(r5)     // Catch: kotlin.io.TerminateException -> Ld5
            if (r4 != 0) goto L8e
            goto L78
        L87:
            boolean r4 = r5.delete()     // Catch: kotlin.io.TerminateException -> Ld5
            if (r4 != 0) goto L8e
            goto L78
        L8e:
            r4 = 0
        L8f:
            if (r4 == 0) goto La3
            kotlin.io.FileAlreadyExistsException r4 = new kotlin.io.FileAlreadyExistsException     // Catch: kotlin.io.TerminateException -> Ld5
            java.lang.String r6 = "The destination file already exists."
            r4.<init>(r3, r5, r6)     // Catch: kotlin.io.TerminateException -> Ld5
            java.lang.Object r3 = r14.invoke(r5, r4)     // Catch: kotlin.io.TerminateException -> Ld5
            kotlin.io.OnErrorAction r3 = (kotlin.io.OnErrorAction) r3     // Catch: kotlin.io.TerminateException -> Ld5
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch: kotlin.io.TerminateException -> Ld5
            if (r3 != r4) goto L32
            return r2
        La3:
            boolean r4 = r3.isDirectory()     // Catch: kotlin.io.TerminateException -> Ld5
            if (r4 == 0) goto Lad
            r5.mkdirs()     // Catch: kotlin.io.TerminateException -> Ld5
            goto L32
        Lad:
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r3
            r6 = r13
            java.io.File r4 = Q(r4, r5, r6, r7, r8, r9)     // Catch: kotlin.io.TerminateException -> Ld5
            long r4 = r4.length()     // Catch: kotlin.io.TerminateException -> Ld5
            long r6 = r3.length()     // Catch: kotlin.io.TerminateException -> Ld5
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L32
            java.io.IOException r4 = new java.io.IOException     // Catch: kotlin.io.TerminateException -> Ld5
            java.lang.String r5 = "Source file wasn't copied completely, length of destination file differs."
            r4.<init>(r5)     // Catch: kotlin.io.TerminateException -> Ld5
            java.lang.Object r3 = r14.invoke(r3, r4)     // Catch: kotlin.io.TerminateException -> Ld5
            kotlin.io.OnErrorAction r3 = (kotlin.io.OnErrorAction) r3     // Catch: kotlin.io.TerminateException -> Ld5
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch: kotlin.io.TerminateException -> Ld5
            if (r3 != r4) goto L32
            return r2
        Ld4:
            return r1
        Ld5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__UtilsKt.N(java.io.File, java.io.File, boolean, h.k2.u.p):boolean");
    }

    public static /* synthetic */ boolean O(File file, File file2, boolean z, p pVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            pVar = FilesKt__UtilsKt$copyRecursively$1.INSTANCE;
        }
        return N(file, file2, z, pVar);
    }

    @d
    public static final File P(@d File file, @d File file2, boolean z, int i2) {
        if (file.exists()) {
            if (file2.exists()) {
                if (z) {
                    if (!file2.delete()) {
                        throw new FileAlreadyExistsException(file, file2, "Tried to overwrite the destination, but failed to delete it.");
                    }
                } else {
                    throw new FileAlreadyExistsException(file, file2, "The destination file already exists.");
                }
            }
            if (file.isDirectory()) {
                if (!file2.mkdirs()) {
                    throw new FileSystemException(file, file2, "Failed to create target directory.");
                }
            } else {
                File parentFile = file2.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    a.k(fileInputStream, fileOutputStream, i2);
                    b.a(fileOutputStream, null);
                    b.a(fileInputStream, null);
                } finally {
                }
            }
            return file2;
        }
        throw new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null);
    }

    public static /* synthetic */ File Q(File file, File file2, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 8192;
        }
        return P(file, file2, z, i2);
    }

    @i(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    @d
    public static final File R(@d String str, @e String str2, @e File file) {
        File createTempFile = File.createTempFile(str, str2, file);
        createTempFile.delete();
        if (createTempFile.mkdir()) {
            return createTempFile;
        }
        throw new IOException("Unable to create temporary directory " + createTempFile + '.');
    }

    public static /* synthetic */ File S(String str, String str2, File file, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "tmp";
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            file = null;
        }
        return R(str, str2, file);
    }

    @i(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    @d
    public static final File T(@d String str, @e String str2, @e File file) {
        return File.createTempFile(str, str2, file);
    }

    public static /* synthetic */ File U(String str, String str2, File file, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "tmp";
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            file = null;
        }
        return T(str, str2, file);
    }

    public static final boolean V(@d File file) {
        while (true) {
            boolean z = true;
            for (File file2 : l.L(file)) {
                if (file2.delete() || !file2.exists()) {
                    if (z) {
                        break;
                    }
                }
                z = false;
            }
            return z;
        }
    }

    public static final boolean W(@d File file, @d File file2) {
        g f2 = k.f(file);
        g f3 = k.f(file2);
        if (f3.i()) {
            return f0.g(file, file2);
        }
        int h2 = f2.h() - f3.h();
        if (h2 < 0) {
            return false;
        }
        return f2.g().subList(h2, f2.h()).equals(f3.g());
    }

    public static final boolean X(@d File file, @d String str) {
        return W(file, new File(str));
    }

    @d
    public static final String Y(@d File file) {
        return StringsKt__StringsKt.n5(file.getName(), '.', "");
    }

    @d
    public static final String Z(@d File file) {
        return File.separatorChar != '/' ? u.j2(file.getPath(), File.separatorChar, Attributes.InternalPrefix, false, 4, null) : file.getPath();
    }

    @d
    public static final String a0(@d File file) {
        return StringsKt__StringsKt.y5(file.getName(), ".", null, 2, null);
    }

    @d
    public static final File b0(@d File file) {
        g f2 = k.f(file);
        return i0(f2.e(), CollectionsKt___CollectionsKt.Z2(c0(f2.g()), File.separator, null, null, 0, null, null, 62, null));
    }

    private static final List<File> c0(List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (name != null) {
                int hashCode = name.hashCode();
                if (hashCode != 46) {
                    if (hashCode == 1472 && name.equals("..")) {
                        if (arrayList.isEmpty() || !(!f0.g(((File) CollectionsKt___CollectionsKt.c3(arrayList)).getName(), ".."))) {
                            arrayList.add(file);
                        } else {
                            arrayList.remove(arrayList.size() - 1);
                        }
                    }
                } else if (name.equals(".")) {
                }
            }
            arrayList.add(file);
        }
        return arrayList;
    }

    private static final g d0(g gVar) {
        return new g(gVar.e(), c0(gVar.g()));
    }

    @d
    public static final File e0(@d File file, @d File file2) {
        return new File(n0(file, file2));
    }

    @e
    public static final File f0(@d File file, @d File file2) {
        String o0 = o0(file, file2);
        if (o0 != null) {
            return new File(o0);
        }
        return null;
    }

    @d
    public static final File g0(@d File file, @d File file2) {
        String o0 = o0(file, file2);
        return o0 != null ? new File(o0) : file;
    }

    @d
    public static final File h0(@d File file, @d File file2) {
        if (k.d(file2)) {
            return file2;
        }
        String file3 = file.toString();
        if ((file3.length() == 0) || StringsKt__StringsKt.a3(file3, File.separatorChar, false, 2, null)) {
            return new File(file3 + file2);
        }
        return new File(file3 + File.separatorChar + file2);
    }

    @d
    public static final File i0(@d File file, @d String str) {
        return h0(file, new File(str));
    }

    @d
    public static final File j0(@d File file, @d File file2) {
        g f2 = k.f(file);
        return h0(h0(f2.e(), f2.h() == 0 ? new File("..") : f2.j(0, f2.h() - 1)), file2);
    }

    @d
    public static final File k0(@d File file, @d String str) {
        return j0(file, new File(str));
    }

    public static final boolean l0(@d File file, @d File file2) {
        g f2 = k.f(file);
        g f3 = k.f(file2);
        if (!(!f0.g(f2.e(), f3.e())) && f2.h() >= f3.h()) {
            return f2.g().subList(0, f3.h()).equals(f3.g());
        }
        return false;
    }

    public static final boolean m0(@d File file, @d String str) {
        return l0(file, new File(str));
    }

    @d
    public static final String n0(@d File file, @d File file2) {
        String o0 = o0(file, file2);
        if (o0 != null) {
            return o0;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + file2 + '.');
    }

    private static final String o0(File file, File file2) {
        g d0 = d0(k.f(file));
        g d02 = d0(k.f(file2));
        if (!f0.g(d0.e(), d02.e())) {
            return null;
        }
        int h2 = d02.h();
        int h3 = d0.h();
        int i2 = 0;
        int min = Math.min(h3, h2);
        while (i2 < min && f0.g(d0.g().get(i2), d02.g().get(i2))) {
            i2++;
        }
        StringBuilder sb = new StringBuilder();
        int i3 = h2 - 1;
        if (i3 >= i2) {
            while (!f0.g(d02.g().get(i3).getName(), "..")) {
                sb.append("..");
                if (i3 != i2) {
                    sb.append(File.separatorChar);
                }
                if (i3 != i2) {
                    i3--;
                }
            }
            return null;
        }
        if (i2 < h3) {
            if (i2 < h2) {
                sb.append(File.separatorChar);
            }
            CollectionsKt___CollectionsKt.W2(CollectionsKt___CollectionsKt.P1(d0.g(), i2), sb, (r14 & 2) != 0 ? ", " : File.separator, (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
        }
        return sb.toString();
    }
}
