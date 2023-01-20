package com.meizu.cloud.pushsdk.b;

import android.util.Log;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import e.t.u.b0;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/* loaded from: classes2.dex */
public class e {
    private final SimpleDateFormat a = new SimpleDateFormat(b0.a.b);
    private final d b = new d("lo");

    /* renamed from: c  reason: collision with root package name */
    private BufferedWriter f4657c;

    /* loaded from: classes2.dex */
    public class a implements Comparator<File> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            int i2 = ((file.lastModified() - file2.lastModified()) > 0L ? 1 : ((file.lastModified() - file2.lastModified()) == 0L ? 0 : -1));
            if (i2 > 0) {
                return -1;
            }
            return i2 == 0 ? 0 : 1;
        }
    }

    public void a() {
        BufferedWriter bufferedWriter = this.f4657c;
        if (bufferedWriter != null) {
            bufferedWriter.flush();
            this.f4657c.close();
            this.f4657c = null;
        }
    }

    public void a(File file) {
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.meizu.cloud.pushsdk.b.e.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.getName().endsWith(".log.txt");
            }
        });
        if (listFiles != null) {
            if (listFiles.length > 7) {
                Arrays.sort(listFiles, new a());
                for (int i2 = 7; i2 < listFiles.length; i2++) {
                    listFiles[i2].delete();
                }
            }
        }
    }

    public void a(String str) {
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("create " + str + " dir failed!!!");
        }
        String format = this.a.format(new Date());
        File file2 = new File(str, format + ".log.txt");
        if (!file2.exists()) {
            if (file2.createNewFile()) {
                a(file);
            } else {
                Log.e("EncryptionWriter", "create new file " + format + " failed !!!");
            }
        }
        this.f4657c = new BufferedWriter(new FileWriter(file2, true));
    }

    public void a(String str, String str2, String str3) {
        if (this.f4657c != null) {
            this.f4657c.write(this.b.a((str + str2 + ExpandableTextView.N + str3).getBytes()));
            this.f4657c.write("\r\n");
        }
    }
}
