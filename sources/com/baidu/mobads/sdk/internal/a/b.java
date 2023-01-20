package com.baidu.mobads.sdk.internal.a;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.internal.bj;
import com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate;
import com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class b implements com.baidu.mobads.sdk.internal.a.a {
    public static final String a = "ViewPager2";
    public static final String b = "RVAdapter";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1409c = "RVViewHolder";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1410d = "ViewCompat";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1411e = "p_e";

    /* renamed from: f  reason: collision with root package name */
    private static final String f1412f = "p_init";

    /* renamed from: g  reason: collision with root package name */
    private static final String f1413g = "p_set_class";

    /* renamed from: h  reason: collision with root package name */
    private static final String f1414h = "e_t";

    /* renamed from: i  reason: collision with root package name */
    private static final String f1415i = "e_n";

    /* renamed from: j  reason: collision with root package name */
    private static final String f1416j = "e_a";

    /* renamed from: k  reason: collision with root package name */
    private static final String f1417k = "e_r";

    /* renamed from: l  reason: collision with root package name */
    private static final String f1418l = "e_d";

    /* renamed from: m  reason: collision with root package name */
    private final IAdInterListener f1419m;

    /* loaded from: classes.dex */
    public static class a implements IOAdEventListener {
        private com.baidu.mobads.sdk.internal.a.a a(String str, @NonNull IAdInterListener iAdInterListener, Object[] objArr) {
            if (b.a.equals(str) && b.a(objArr, Context.class)) {
                return new ViewPager2Delegate(iAdInterListener, (Context) objArr[0]);
            }
            if (b.b.equals(str)) {
                return new RVAdapterDelegate(iAdInterListener);
            }
            if (b.f1409c.equals(str) && b.a(objArr, View.class)) {
                return new RVViewHolderDelegate(iAdInterListener, (View) objArr[0]);
            }
            if (b.f1410d.equals(str)) {
                return new ViewCompatDelegate(iAdInterListener);
            }
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            com.baidu.mobads.sdk.internal.a.a a;
            if (iOAdEvent != null) {
                try {
                    if (b.f1411e.equals(iOAdEvent.getType()) && (data = iOAdEvent.getData()) != null && !data.isEmpty()) {
                        Object obj = data.get(b.f1414h);
                        Object obj2 = data.get(b.f1415i);
                        Object obj3 = data.get(b.f1416j);
                        Object[] objArr = obj3 instanceof Object[] ? (Object[]) obj3 : null;
                        if ((obj2 instanceof String) && (obj instanceof String)) {
                            if (b.f1412f.equals((String) obj2)) {
                                Object obj4 = data.get(b.f1418l);
                                if (!(obj4 instanceof IAdInterListener) || (a = a((String) obj, (IAdInterListener) obj4, objArr)) == null) {
                                    return;
                                }
                                data.put(b.f1417k, a);
                            } else if (b.f1413g.equals((String) obj2) && (obj3 instanceof Map)) {
                                Map map = (Map) obj3;
                                map.put(b.a, ViewPager2.class);
                                map.put(b.b, RecyclerView.Adapter.class);
                                map.put(b.f1409c, RecyclerView.ViewHolder.class);
                            }
                        }
                    }
                } catch (Throwable th) {
                    bj.a().b(th.getMessage());
                }
            }
        }
    }

    private b(@NonNull IAdInterListener iAdInterListener, @NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        this.f1419m = iAdInterListener;
        iAdInterListener.addEventListener(f1411e, new c(this, aVar));
    }

    public static b a(@NonNull IAdInterListener iAdInterListener, @NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        return new b(iAdInterListener, aVar);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f1419m;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f1419m;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public final Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
    }

    public final void a(String str) {
        this.f1419m.onAdTaskProcess(str);
    }

    public final Object a(String str, Object... objArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(f1416j, objArr);
        this.f1419m.onAdTaskProcess(str, hashMap);
        return hashMap.get(f1417k);
    }

    public static boolean a(Object[] objArr, Class<?>... clsArr) {
        boolean z = objArr == null || objArr.length == 0;
        boolean z2 = clsArr == null || clsArr.length == 0;
        if (z && z2) {
            return true;
        }
        if (z || z2 || clsArr == null || objArr == null || clsArr.length != objArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (!clsArr[i2].isInstance(objArr[i2])) {
                return false;
            }
        }
        return true;
    }
}
