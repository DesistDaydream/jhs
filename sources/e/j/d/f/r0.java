package e.j.d.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import com.google.firebase.iid.zzs;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

/* loaded from: classes2.dex */
public final class r0 {
    @Nullable
    private final t0 b(Context context, String str, t0 t0Var, boolean z) {
        long j2;
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing ID to properties file");
        }
        Properties properties = new Properties();
        properties.setProperty("id", t0Var.b());
        j2 = t0Var.b;
        properties.setProperty("cre", String.valueOf(j2));
        File q = q(context, str);
        try {
            q.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(q, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            try {
                channel.lock();
                if (z && channel.size() > 0) {
                    try {
                        channel.position(0L);
                        t0 e2 = e(channel);
                        if (channel != null) {
                            k(null, channel);
                        }
                        j(null, randomAccessFile);
                        return e2;
                    } catch (zzs | IOException e3) {
                        if (Log.isLoggable("FirebaseInstanceId", 3)) {
                            String valueOf = String.valueOf(e3);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 58);
                            sb.append("Tried reading ID before writing new one, but failed with: ");
                            sb.append(valueOf);
                            Log.d("FirebaseInstanceId", sb.toString());
                        }
                    }
                }
                channel.truncate(0L);
                properties.store(Channels.newOutputStream(channel), (String) null);
                if (channel != null) {
                    k(null, channel);
                }
                j(null, randomAccessFile);
                return t0Var;
            } finally {
            }
        } catch (IOException e4) {
            String valueOf2 = String.valueOf(e4);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 21);
            sb2.append("Failed to write key: ");
            sb2.append(valueOf2);
            Log.w("FirebaseInstanceId", sb2.toString());
            return null;
        }
    }

    @Nullable
    private static t0 c(SharedPreferences sharedPreferences, String str) throws zzs {
        long l2 = l(sharedPreferences, str);
        String string = sharedPreferences.getString(u.c(str, "id"), null);
        if (string == null) {
            String string2 = sharedPreferences.getString(u.c(str, "|P|"), null);
            if (string2 == null) {
                return null;
            }
            string = j.d(f(string2));
        }
        return new t0(string, l2);
    }

    private final t0 d(File file) throws zzs, IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            channel.lock(0L, Long.MAX_VALUE, true);
            t0 e2 = e(channel);
            if (channel != null) {
                k(null, channel);
            }
            i(null, fileInputStream);
            return e2;
        } finally {
        }
    }

    private static t0 e(FileChannel fileChannel) throws zzs, IOException {
        Properties properties = new Properties();
        properties.load(Channels.newInputStream(fileChannel));
        try {
            long parseLong = Long.parseLong(properties.getProperty("cre"));
            String property = properties.getProperty("id");
            if (property == null) {
                String property2 = properties.getProperty("pub");
                if (property2 != null) {
                    property = j.d(f(property2));
                } else {
                    throw new zzs("Invalid properties file");
                }
            }
            return new t0(property, parseLong);
        } catch (NumberFormatException e2) {
            throw new zzs(e2);
        }
    }

    private static PublicKey f(String str) throws zzs {
        try {
            try {
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Invalid key stored ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                throw new zzs(e2);
            }
        } catch (IllegalArgumentException e3) {
            throw new zzs(e3);
        }
    }

    public static void g(Context context) {
        File[] listFiles;
        for (File file : n(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    private final void h(Context context, String str, t0 t0Var) {
        long j2;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (t0Var.equals(c(sharedPreferences, str))) {
                return;
            }
        } catch (zzs unused) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing key to shared preferences");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(u.c(str, "id"), t0Var.b());
        String c2 = u.c(str, "cre");
        j2 = t0Var.b;
        edit.putString(c2, String.valueOf(j2));
        edit.commit();
    }

    private static /* synthetic */ void i(Throwable th, FileInputStream fileInputStream) {
        if (th == null) {
            fileInputStream.close();
            return;
        }
        try {
            fileInputStream.close();
        } catch (Throwable th2) {
            e.j.a.b.f.c.n.b(th, th2);
        }
    }

    private static /* synthetic */ void j(Throwable th, RandomAccessFile randomAccessFile) {
        if (th == null) {
            randomAccessFile.close();
            return;
        }
        try {
            randomAccessFile.close();
        } catch (Throwable th2) {
            e.j.a.b.f.c.n.b(th, th2);
        }
    }

    private static /* synthetic */ void k(Throwable th, FileChannel fileChannel) {
        if (th == null) {
            fileChannel.close();
            return;
        }
        try {
            fileChannel.close();
        } catch (Throwable th2) {
            e.j.a.b.f.c.n.b(th, th2);
        }
    }

    private static long l(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(u.c(str, "cre"), null);
        if (string != null) {
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return 0L;
    }

    private static File n(Context context) {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(context);
        if (noBackupFilesDir == null || !noBackupFilesDir.isDirectory()) {
            Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
            return context.getFilesDir();
        }
        return noBackupFilesDir;
    }

    @Nullable
    private final t0 o(Context context, String str) throws zzs {
        t0 p;
        try {
            p = p(context, str);
        } catch (zzs e2) {
            e = e2;
        }
        if (p != null) {
            h(context, str, p);
            return p;
        }
        e = null;
        try {
            t0 c2 = c(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
            if (c2 != null) {
                b(context, str, c2, false);
                return c2;
            }
        } catch (zzs e3) {
            e = e3;
        }
        if (e == null) {
            return null;
        }
        throw e;
    }

    @Nullable
    private final t0 p(Context context, String str) throws zzs {
        File q = q(context, str);
        if (q.exists()) {
            try {
                return d(q);
            } catch (zzs | IOException e2) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
                    sb.append("Failed to read ID from file, retrying: ");
                    sb.append(valueOf);
                    Log.d("FirebaseInstanceId", sb.toString());
                }
                try {
                    return d(q);
                } catch (IOException e3) {
                    String valueOf2 = String.valueOf(e3);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 45);
                    sb2.append("IID file exists, but failed to read from it: ");
                    sb2.append(valueOf2);
                    Log.w("FirebaseInstanceId", sb2.toString());
                    throw new zzs(e3);
                }
            }
        }
        return null;
    }

    private static File q(Context context, String str) {
        String sb;
        if (TextUtils.isEmpty(str)) {
            sb = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb2 = new StringBuilder(String.valueOf(encodeToString).length() + 33);
                sb2.append("com.google.InstanceId_");
                sb2.append(encodeToString);
                sb2.append(".properties");
                sb = sb2.toString();
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
        return new File(n(context), sb);
    }

    @WorkerThread
    public final t0 a(Context context, String str) throws zzs {
        t0 o = o(context, str);
        return o != null ? o : m(context, str);
    }

    @WorkerThread
    public final t0 m(Context context, String str) {
        t0 t0Var = new t0(j.d(e.a().getPublic()), System.currentTimeMillis());
        t0 b = b(context, str, t0Var, true);
        if (b != null && !b.equals(t0Var)) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one");
            }
            return b;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Generated new key");
        }
        h(context, str, t0Var);
        return t0Var;
    }
}
