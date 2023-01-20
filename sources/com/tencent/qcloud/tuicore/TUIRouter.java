package com.tencent.qcloud.tuicore;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class TUIRouter {
    private static final String TAG = "TUIRouter";
    private static Context context;
    private static final TUIRouter router = new TUIRouter();
    private static final Map<String, String> routerMap = new HashMap();
    private static boolean initialized = false;

    /* loaded from: classes3.dex */
    public static class Navigation {
        public String destination;
        public Intent intent = new Intent();
        public Bundle options;

        private void startActivity(Context context, int i2) {
            if (context == null) {
                Log.e(TUIRouter.TAG, "StartActivity failed, context is null.Please init");
                return;
            }
            try {
                if ((context instanceof Activity) && i2 >= 0) {
                    ActivityCompat.startActivityForResult((Activity) context, this.intent, i2, this.options);
                    return;
                }
                if (!(context instanceof Activity)) {
                    this.intent.addFlags(268435456);
                }
                ContextCompat.startActivity(context, this.intent, this.options);
            } catch (ActivityNotFoundException e2) {
                e2.printStackTrace();
            }
        }

        public Intent getIntent() {
            return this.intent;
        }

        public void navigate() {
            navigate((Context) null);
        }

        public Navigation putExtra(String str, boolean z) {
            this.intent.putExtra(str, z);
            return this;
        }

        public Navigation putExtras(Bundle bundle) {
            if (bundle != null) {
                this.intent.putExtras(bundle);
            }
            return this;
        }

        public Navigation setDestination(String str) {
            String str2 = (String) TUIRouter.routerMap.get(str);
            this.destination = str2;
            if (str2 == null) {
                Log.e(TUIRouter.TAG, "destination is null.");
                return this;
            }
            this.intent.setComponent(new ComponentName(TUIRouter.context, this.destination));
            return this;
        }

        public Navigation setIntent(Intent intent) {
            this.intent = intent;
            return this;
        }

        public Navigation setOptions(Bundle bundle) {
            this.options = bundle;
            return this;
        }

        public void navigate(Context context) {
            navigate(context, -1);
        }

        public Navigation putExtra(String str, byte b) {
            this.intent.putExtra(str, b);
            return this;
        }

        public Navigation putExtras(Intent intent) {
            if (intent != null) {
                this.intent.putExtras(intent);
            }
            return this;
        }

        public void navigate(Fragment fragment) {
            navigate(fragment, -1);
        }

        public Navigation putExtra(String str, char c2) {
            this.intent.putExtra(str, c2);
            return this;
        }

        public void navigate(Fragment fragment, int i2) {
            if (!TUIRouter.initialized) {
                Log.e(TUIRouter.TAG, "have not initialized.");
                return;
            }
            Intent intent = this.intent;
            if (intent == null) {
                Log.e(TUIRouter.TAG, "intent is null.");
                return;
            }
            try {
                if (fragment == null) {
                    startActivity(null, i2);
                } else if (i2 >= 0) {
                    fragment.startActivityForResult(intent, i2);
                } else {
                    fragment.startActivity(intent, this.options);
                }
            } catch (ActivityNotFoundException e2) {
                e2.printStackTrace();
            }
        }

        public Navigation putExtra(String str, short s) {
            this.intent.putExtra(str, s);
            return this;
        }

        public Navigation putExtra(String str, int i2) {
            this.intent.putExtra(str, i2);
            return this;
        }

        public Navigation putExtra(String str, long j2) {
            this.intent.putExtra(str, j2);
            return this;
        }

        public Navigation putExtra(String str, float f2) {
            this.intent.putExtra(str, f2);
            return this;
        }

        public Navigation putExtra(String str, double d2) {
            this.intent.putExtra(str, d2);
            return this;
        }

        public Navigation putExtra(String str, String str2) {
            if (str2 != null) {
                this.intent.putExtra(str, str2);
            }
            return this;
        }

        public Navigation putExtra(String str, CharSequence charSequence) {
            if (charSequence != null) {
                this.intent.putExtra(str, charSequence);
            }
            return this;
        }

        public Navigation putExtra(String str, Parcelable parcelable) {
            if (parcelable != null) {
                this.intent.putExtra(str, parcelable);
            }
            return this;
        }

        public void navigate(Context context, int i2) {
            if (!TUIRouter.initialized) {
                Log.e(TUIRouter.TAG, "have not initialized.");
            } else if (this.intent == null) {
                Log.e(TUIRouter.TAG, "intent is null.");
            } else {
                if (context == null) {
                    context = TUIRouter.context;
                }
                startActivity(context, i2);
            }
        }

        public Navigation putExtra(String str, Parcelable[] parcelableArr) {
            if (parcelableArr != null) {
                this.intent.putExtra(str, parcelableArr);
            }
            return this;
        }

        public Navigation putExtra(String str, Serializable serializable) {
            if (serializable != null) {
                this.intent.putExtra(str, serializable);
            }
            return this;
        }

        public Navigation putExtra(String str, boolean[] zArr) {
            if (zArr != null) {
                this.intent.putExtra(str, zArr);
            }
            return this;
        }

        public Navigation putExtra(String str, byte[] bArr) {
            if (bArr != null) {
                this.intent.putExtra(str, bArr);
            }
            return this;
        }

        public Navigation putExtra(String str, short[] sArr) {
            if (sArr != null) {
                this.intent.putExtra(str, sArr);
            }
            return this;
        }

        public Navigation putExtra(String str, char[] cArr) {
            if (cArr != null) {
                this.intent.putExtra(str, cArr);
            }
            return this;
        }

        public Navigation putExtra(String str, int[] iArr) {
            if (iArr != null) {
                this.intent.putExtra(str, iArr);
            }
            return this;
        }

        public Navigation putExtra(String str, long[] jArr) {
            if (jArr != null) {
                this.intent.putExtra(str, jArr);
            }
            return this;
        }

        public Navigation putExtra(String str, float[] fArr) {
            if (fArr != null) {
                this.intent.putExtra(str, fArr);
            }
            return this;
        }

        public Navigation putExtra(String str, double[] dArr) {
            if (dArr != null) {
                this.intent.putExtra(str, dArr);
            }
            return this;
        }

        public Navigation putExtra(String str, String[] strArr) {
            if (strArr != null) {
                this.intent.putExtra(str, strArr);
            }
            return this;
        }

        public Navigation putExtra(String str, CharSequence[] charSequenceArr) {
            if (charSequenceArr != null) {
                this.intent.putExtra(str, charSequenceArr);
            }
            return this;
        }

        public Navigation putExtra(String str, Bundle bundle) {
            if (bundle != null) {
                this.intent.putExtra(str, bundle);
            }
            return this;
        }
    }

    private TUIRouter() {
    }

    public static Context getContext() {
        return context;
    }

    public static TUIRouter getInstance() {
        return router;
    }

    public static synchronized void init(Context context2) {
        synchronized (TUIRouter.class) {
            if (initialized) {
                return;
            }
            context = context2;
            if (context2 == null) {
                Log.e(TAG, "init failed, context is null.");
                return;
            }
            initRouter(context2);
            initialized = true;
        }
    }

    public static void initRouter(Context context2) {
        ActivityInfo[] activityInfoArr;
        ArrayList<String> arrayList = new ArrayList();
        try {
            activityInfoArr = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 1).activities;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            activityInfoArr = null;
        }
        if (activityInfoArr != null) {
            for (ActivityInfo activityInfo : activityInfoArr) {
                arrayList.add(activityInfo.name);
            }
        }
        for (String str : arrayList) {
            String[] split = str.split("\\.");
            routerMap.put(split[split.length - 1], str);
        }
    }

    public Navigation setDestination(String str) {
        Navigation navigation = new Navigation();
        navigation.setDestination(str);
        return navigation;
    }
}
