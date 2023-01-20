package com.bytedance.pangle.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.multidex.MultiDexExtractor;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.n;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* loaded from: classes.dex */
public final class a implements Closeable {
    private final File a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final File f2229c;

    /* renamed from: d  reason: collision with root package name */
    private final RandomAccessFile f2230d;

    /* renamed from: e  reason: collision with root package name */
    private final FileChannel f2231e;

    /* renamed from: f  reason: collision with root package name */
    private final FileLock f2232f;

    /* renamed from: com.bytedance.pangle.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0074a extends File {
        public long a;

        public C0074a(File file, String str) {
            super(file, str);
            this.a = -1L;
        }
    }

    public a(File file, File file2) {
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.a = file;
        this.f2229c = file2;
        this.b = b(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f2230d = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f2231e = channel;
            try {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Blocking on lock " + file3.getPath());
                this.f2232f = channel.lock();
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex " + file3.getPath() + " locked");
            } catch (IOException e2) {
                e = e2;
                a(this.f2231e);
                throw e;
            } catch (Error e3) {
                e = e3;
                a(this.f2231e);
                throw e;
            } catch (RuntimeException e4) {
                e = e4;
                a(this.f2231e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e5) {
            a(this.f2230d);
            throw e5;
        }
    }

    private static long b(File file) {
        long a = n.a(file);
        return a == -1 ? a - 1 : a;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<? extends java.io.File> a(android.content.Context r13, java.lang.String r14, boolean r15) {
        /*
            r12 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "PluginMultiDex MultiDexExtractor.load("
            r0.<init>(r1)
            java.io.File r1 = r12.a
            java.lang.String r1 = r1.getPath()
            r0.append(r1)
            java.lang.String r1 = ", "
            r0.append(r1)
            r0.append(r15)
            r0.append(r1)
            r0.append(r14)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Zeus/load"
            com.bytedance.pangle.log.ZeusLogger.i(r1, r0)
            java.nio.channels.FileLock r0 = r12.f2232f
            boolean r0 = r0.isValid()
            if (r0 == 0) goto Lc3
            if (r15 != 0) goto L88
            java.io.File r0 = r12.a
            long r2 = r12.b
            android.content.SharedPreferences r4 = a(r13)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r14)
            java.lang.String r6 = "timestamp"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r6 = -1
            long r8 = r4.getLong(r5, r6)
            long r10 = a(r0)
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 != 0) goto L79
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r14)
            java.lang.String r5 = "crc"
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            long r4 = r4.getLong(r0, r6)
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 == 0) goto L77
            goto L79
        L77:
            r0 = 0
            goto L7a
        L79:
            r0 = 1
        L7a:
            if (r0 != 0) goto L88
            java.util.List r13 = r12.a(r13, r14)     // Catch: java.io.IOException -> L81
            goto La8
        L81:
            r15 = move-exception
            java.lang.String r0 = "PluginMultiDex Failed to reload existing extracted secondary dex files, falling back to fresh extraction"
            com.bytedance.pangle.log.ZeusLogger.errReport(r1, r0, r15)
            goto L95
        L88:
            if (r15 == 0) goto L90
            java.lang.String r15 = "PluginMultiDex Forced extraction must be performed."
            com.bytedance.pangle.log.ZeusLogger.i(r1, r15)
            goto L95
        L90:
            java.lang.String r15 = "PluginMultiDex Detected that extraction must be performed."
            com.bytedance.pangle.log.ZeusLogger.i(r1, r15)
        L95:
            java.util.List r15 = r12.a()
            java.io.File r0 = r12.a
            long r4 = a(r0)
            long r6 = r12.b
            r2 = r13
            r3 = r14
            r8 = r15
            a(r2, r3, r4, r6, r8)
            r13 = r15
        La8:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = "PluginMultiDex load found "
            r14.<init>(r15)
            int r15 = r13.size()
            r14.append(r15)
            java.lang.String r15 = " secondary dex files"
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            com.bytedance.pangle.log.ZeusLogger.i(r1, r14)
            return r13
        Lc3:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "MultiDexExtractor was closed"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.d.a.a(android.content.Context, java.lang.String, boolean):java.util.List");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f2232f.release();
        this.f2231e.close();
        this.f2230d.close();
    }

    private void b() {
        File[] listFiles = this.f2229c.listFiles(new FileFilter() { // from class: com.bytedance.pangle.d.a.1
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return !file.getName().equals("MultiDex.lock");
            }
        });
        if (listFiles == null) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to list secondary dex dir content (" + this.f2229c.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (file.delete()) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Deleted old file " + file.getPath());
            } else {
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to delete old file " + file.getPath());
            }
        }
    }

    private List<C0074a> a(Context context, String str) {
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex loading existing secondary dex files");
        String str2 = this.a.getName() + ".classes";
        SharedPreferences a = a(context);
        int i2 = a.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i2 + (-1));
        int i3 = 2;
        while (i3 <= i2) {
            C0074a c0074a = new C0074a(this.f2229c, str2 + i3 + MultiDexExtractor.EXTRACTED_SUFFIX);
            if (c0074a.isFile()) {
                c0074a.a = b(c0074a);
                long j2 = a.getLong(str + "dex.crc." + i3, -1L);
                long j3 = a.getLong(str + "dex.time." + i3, -1L);
                long lastModified = c0074a.lastModified();
                if (j3 == lastModified) {
                    String str3 = str2;
                    SharedPreferences sharedPreferences = a;
                    if (j2 == c0074a.a) {
                        arrayList.add(c0074a);
                        i3++;
                        a = sharedPreferences;
                        str2 = str3;
                    }
                }
                throw new IOException("Invalid extracted dex: " + c0074a + " (key \"" + str + "\"), expected modification time: " + j3 + ", modification time: " + lastModified + ", expected crc: " + j2 + ", file crc: " + c0074a.a);
            }
            throw new IOException("Missing extracted secondary dex file '" + c0074a.getPath() + "'");
        }
        return arrayList;
    }

    private static long a(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0128, code lost:
        throw new java.io.IOException("Could not create zip file " + r8.getAbsolutePath() + " for secondary dex (" + r5 + ")");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.bytedance.pangle.d.a.C0074a> a() {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.d.a.a():java.util.List");
    }

    private static void a(Context context, String str, long j2, long j3, List<C0074a> list) {
        SharedPreferences.Editor edit = a(context).edit();
        edit.putLong(str + "timestamp", j2);
        edit.putLong(str + "crc", j3);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i2 = 2;
        for (C0074a c0074a : list) {
            edit.putLong(str + "dex.crc." + i2, c0074a.a);
            edit.putLong(str + "dex.time." + i2, c0074a.lastModified());
            i2++;
        }
        edit.commit();
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-".concat(String.valueOf(str)), MultiDexExtractor.EXTRACTED_SUFFIX, file.getParentFile());
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Extracting " + createTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } finally {
            a(inputStream);
            createTempFile.delete();
        }
    }

    private static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to close resource", e2);
        }
    }
}
