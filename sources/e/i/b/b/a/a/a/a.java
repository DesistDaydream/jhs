package e.i.b.b.a.a.a;

import e.i.b.a.i;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class a extends i {
    public static volatile a b;
    public final Map<String, String[]> a = new HashMap();

    private a() {
        e();
    }

    public static a d() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    private void e() {
        BufferedReader bufferedReader;
        IOException e2;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("tinypinyin/cncity.txt")));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            String[] split = readLine.split("\\s+");
                            if (split != null && split.length == 2) {
                                this.a.put(split[1], split[0].split("'"));
                            }
                        } catch (IOException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return;
                        }
                    }
                    bufferedReader.close();
                } catch (IOException e4) {
                    bufferedReader = null;
                    e2 = e4;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // e.i.b.a.i
    public Map<String, String[]> c() {
        return this.a;
    }
}
