package com.bytedance.pangle.res;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.j;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import java.io.File;
import java.util.HashSet;
import java.util.List;

@Keep
/* loaded from: classes.dex */
public class PluginResources extends Resources {
    public String pluginPkg;

    public PluginResources(Resources resources, String str) {
        super(appendHostRes(resources), resources.getDisplayMetrics(), Zeus.getAppApplication().getResources().getConfiguration());
        this.pluginPkg = str;
    }

    public static AssetManager appendHostRes(Resources resources) {
        File parentFile;
        Application appApplication = Zeus.getAppApplication();
        if (g.a == null && (parentFile = appApplication.getCacheDir().getParentFile()) != null) {
            g.a = parentFile.getAbsolutePath();
        }
        String str = g.a;
        String a = g.a(Zeus.getAppApplication());
        List<String> b = j.b();
        a aVar = new a();
        AssetManager assets = resources.getAssets();
        AssetManager assets2 = Zeus.getAppApplication().getAssets();
        HashSet hashSet = new HashSet(j.a(assets));
        List<String> a2 = j.a(assets2);
        for (String str2 : b) {
            if (!hashSet.contains(str2)) {
                assets = aVar.a(assets, str2, true);
            }
        }
        for (String str3 : a2) {
            if (!isOtherPlugin(str3, str, a) && !hashSet.contains(str3) && !b.contains(str3)) {
                assets = aVar.a(assets, str3, false);
            }
        }
        return assets;
    }

    private static boolean isOtherPlugin(String str, String str2, String str3) {
        String packageResourcePath = Zeus.getAppApplication().getPackageResourcePath();
        if (!TextUtils.isEmpty(str3)) {
            packageResourcePath = packageResourcePath.replaceFirst(str2, str3);
            str = str.replaceFirst(str2, str3);
        }
        ZeusLogger.d(ZeusLogger.TAG_RESOURCES, str + ExpandableTextView.N + packageResourcePath + ExpandableTextView.N + str2 + ExpandableTextView.N + str3);
        if (TextUtils.equals(str, packageResourcePath) || str.contains("/tinker/patch-")) {
            return false;
        }
        if (TextUtils.isEmpty(str2) || !str.contains(str2)) {
            return !TextUtils.isEmpty(str3) && str.contains(str3);
        }
        return true;
    }
}
