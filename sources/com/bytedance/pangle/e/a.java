package com.bytedance.pangle.e;

import com.bytedance.pangle.c.e;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes.dex */
public final class a {
    public static boolean a(String[] strArr) {
        if (strArr.length <= 0) {
            return false;
        }
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            InputStream errorStream = exec.getErrorStream();
            InputStream inputStream = exec.getInputStream();
            a(errorStream);
            a(inputStream);
            if (exec.waitFor() != 0) {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "exec dex2oat failed : " + strArr.toString());
                return false;
            }
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        } catch (InterruptedException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    private static void a(final InputStream inputStream) {
        e.a.execute(new Runnable() { // from class: com.bytedance.pangle.e.a.1
            @Override // java.lang.Runnable
            public final void run() {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            return;
                        }
                        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "exec cmd info : ".concat(String.valueOf(readLine)));
                    } catch (IOException e2) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "execCmd consumeInputStream failed : ".concat(String.valueOf(e2)));
                        return;
                    } finally {
                        g.a(bufferedReader);
                    }
                }
            }
        });
    }
}
