package com.bytedance.pangle.plugin;

import android.text.TextUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import java.io.File;
import java.io.FileFilter;

/* loaded from: classes.dex */
public final class d implements Runnable {
    private void a(File file) {
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusScanRunnable listPluginDownloadDir, dir = ".concat(String.valueOf(file)));
        file.listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.d.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                if (file2 != null && (file2.getName().endsWith(".apk") || file2.getName().endsWith(".jar"))) {
                    PluginManager.getInstance().asyncInstall(null, file2);
                    return true;
                } else if (file2.getAbsolutePath().endsWith(".temp") && System.currentTimeMillis() - file2.lastModified() < 259200000) {
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir find : ".concat(String.valueOf(file2)));
                    return false;
                } else {
                    g.a(file2);
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir deleted : ".concat(String.valueOf(file2)));
                    return false;
                }
            }
        });
    }

    @Override // java.lang.Runnable
    public final void run() {
        a(new File(com.bytedance.pangle.c.c.a()));
        String c2 = com.bytedance.pangle.c.c.c();
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        a(new File(c2));
    }
}
