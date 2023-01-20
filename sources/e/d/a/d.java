package e.d.a;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class d extends c {
    private static final String b = "d";

    /* renamed from: c  reason: collision with root package name */
    private static final Set<String> f10009c = new HashSet(8);
    private AssetManager a;

    public d(AssetManager assetManager) {
        Set<String> set = f10009c;
        set.add("image/svg+xml");
        set.add("image/jpeg");
        set.add("image/png");
        set.add("image/pjpeg");
        set.add("image/gif");
        set.add("image/bmp");
        set.add("image/x-windows-bmp");
        if (Build.VERSION.SDK_INT >= 14) {
            set.add("image/webp");
        }
        this.a = assetManager;
    }

    @Override // e.d.a.c
    public boolean a(String str) {
        return f10009c.contains(str);
    }

    @Override // e.d.a.c
    public Typeface b(String str, int i2, String str2) {
        String str3 = b;
        Log.i(str3, "resolveFont(" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + ")");
        try {
            try {
                AssetManager assetManager = this.a;
                return Typeface.createFromAsset(assetManager, String.valueOf(str) + ".ttf");
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception unused2) {
            AssetManager assetManager2 = this.a;
            return Typeface.createFromAsset(assetManager2, String.valueOf(str) + ".otf");
        }
    }

    @Override // e.d.a.c
    public Bitmap c(String str) {
        String str2 = b;
        Log.i(str2, "resolveImage(" + str + ")");
        try {
            return BitmapFactory.decodeStream(this.a.open(str));
        } catch (IOException unused) {
            return null;
        }
    }
}
