package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.caverock.androidsvg.SVG;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class cn implements com.xiaomi.a.a.a.a {

    /* renamed from: h  reason: collision with root package name */
    private static volatile cn f8348h;

    /* renamed from: c  reason: collision with root package name */
    private String f8349c;

    /* renamed from: d  reason: collision with root package name */
    private Context f8350d;

    /* renamed from: e  reason: collision with root package name */
    private String f8351e = "";

    /* renamed from: g  reason: collision with root package name */
    private Handler f8352g;
    private static final SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");
    public static String a = "/MiPushLog";

    /* renamed from: f  reason: collision with root package name */
    private static List<Pair<String, Throwable>> f8347f = Collections.synchronizedList(new ArrayList());

    private cn(Context context) {
        this.f8350d = context;
        if (context.getApplicationContext() != null) {
            this.f8350d = context.getApplicationContext();
        }
        this.f8349c = this.f8350d.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Process.myPid();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.f8352g = new Handler(handlerThread.getLooper());
    }

    public static cn a(Context context) {
        if (f8348h == null) {
            synchronized (cn.class) {
                if (f8348h == null) {
                    f8348h = new cn(context);
                }
            }
        }
        return f8348h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x016e -> B:109:0x0173). Please submit an issue!!! */
    public void c() {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        File file;
        File externalFilesDir;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                if (TextUtils.isEmpty(this.f8351e) && (externalFilesDir = this.f8350d.getExternalFilesDir(null)) != null) {
                    this.f8351e = externalFilesDir.getAbsolutePath() + "";
                }
                file = new File(this.f8351e + a);
            } catch (Exception e2) {
                e = e2;
                fileLock = null;
                randomAccessFile = null;
            } catch (Throwable th) {
                th = th;
                fileLock = null;
                randomAccessFile = null;
            }
        } catch (IOException e3) {
            Log.e(this.f8349c, "", e3);
        }
        if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
            Log.w(this.f8349c, "Create mipushlog directory fail.");
            return;
        }
        File file2 = new File(file, "log.lock");
        if (!file2.exists() || file2.isDirectory()) {
            file2.createNewFile();
        }
        randomAccessFile = new RandomAccessFile(file2, "rw");
        try {
            fileLock = randomAccessFile.getChannel().lock();
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                    while (!f8347f.isEmpty()) {
                        try {
                            Pair<String, Throwable> remove = f8347f.remove(0);
                            String str = (String) remove.first;
                            if (remove.second != null) {
                                str = (str + "\n") + Log.getStackTraceString((Throwable) remove.second);
                            }
                            bufferedWriter2.write(str + "\n");
                        } catch (Exception e4) {
                            e = e4;
                            bufferedWriter = bufferedWriter2;
                            Log.e(this.f8349c, "", e);
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e5) {
                                    Log.e(this.f8349c, "", e5);
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e6) {
                                    Log.e(this.f8349c, "", e6);
                                }
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e7) {
                                    Log.e(this.f8349c, "", e7);
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e8) {
                                    Log.e(this.f8349c, "", e8);
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e9) {
                                    Log.e(this.f8349c, "", e9);
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    File file3 = new File(file, "log1.txt");
                    if (file3.length() >= SVG.H) {
                        File file4 = new File(file, "log0.txt");
                        if (file4.exists() && file4.isFile()) {
                            file4.delete();
                        }
                        file3.renameTo(file4);
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e10) {
                            Log.e(this.f8349c, "", e10);
                        }
                    }
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Exception e12) {
            e = e12;
            fileLock = null;
        } catch (Throwable th4) {
            th = th4;
            fileLock = null;
        }
    }

    @Override // com.xiaomi.a.a.a.a
    public final void a(String str) {
        a(str, null);
    }

    @Override // com.xiaomi.a.a.a.a
    public final void a(String str, Throwable th) {
        this.f8352g.post(new co(this, str, th));
    }
}
