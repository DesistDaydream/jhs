package com.qq.e.ads.nativ;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class NativeUnifiedAD extends NativeAbstractAD<NUADI> {

    /* renamed from: g  reason: collision with root package name */
    private AdListenerAdapter f5034g;

    /* renamed from: h  reason: collision with root package name */
    private NativeADUnifiedListener f5035h;

    /* renamed from: i  reason: collision with root package name */
    private List<Integer> f5036i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private List<String> f5037j;

    /* renamed from: k  reason: collision with root package name */
    private volatile int f5038k;

    /* renamed from: l  reason: collision with root package name */
    private volatile int f5039l;

    /* renamed from: m  reason: collision with root package name */
    private String f5040m;
    private LoadAdParams n;

    /* loaded from: classes3.dex */
    public static class AdListenerAdapter implements ADListener {
        private NativeADUnifiedListener a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Integer num;
            if (this.a != null) {
                int type = aDEvent.getType();
                if (type != 100) {
                    if (type == 101 && (num = (Integer) aDEvent.getParam(Integer.class)) != null) {
                        this.a.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                }
                List<NativeUnifiedADData> list = (List) aDEvent.getParam(List.class);
                if (list == null || list.size() <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (NativeUnifiedADData nativeUnifiedADData : list) {
                    arrayList.add(new NativeUnifiedADDataAdapter(nativeUnifiedADData));
                }
                this.a.onADLoaded(arrayList);
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        this.f5035h = nativeADUnifiedListener;
        this.f5034g = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str);
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener, String str2) {
        this.f5035h = nativeADUnifiedListener;
        this.f5034g = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str, str2);
    }

    private void d(int i2, boolean z) {
        if (a()) {
            if (!b()) {
                if (z) {
                    this.f5036i.add(Integer.valueOf(i2));
                    return;
                }
                return;
            }
            T t = this.a;
            if (t != 0) {
                LoadAdParams loadAdParams = this.n;
                NUADI nuadi = (NUADI) t;
                if (loadAdParams != null) {
                    nuadi.loadData(i2, loadAdParams);
                } else {
                    nuadi.loadData(i2);
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, str3, this.f5034g);
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NUADI nuadi) {
        super.a((NativeUnifiedAD) nuadi);
        nuadi.setMinVideoDuration(this.f5038k);
        nuadi.setMaxVideoDuration(this.f5039l);
        nuadi.setVastClassName(this.f5040m);
        List<String> list = this.f5037j;
        if (list != null) {
            setCategories(list);
        }
        for (Integer num : this.f5036i) {
            d(num.intValue(), false);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        NativeADUnifiedListener nativeADUnifiedListener = this.f5035h;
        if (nativeADUnifiedListener != null) {
            nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((NUADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadData(int i2) {
        d(i2, true);
    }

    public void loadData(int i2, LoadAdParams loadAdParams) {
        this.n = loadAdParams;
        loadData(i2);
    }

    public void setCategories(List<String> list) {
        this.f5037j = list;
        T t = this.a;
        if (t == 0 || list == null) {
            return;
        }
        ((NUADI) t).setCategories(list);
    }

    public void setMaxVideoDuration(int i2) {
        this.f5039l = i2;
        if (this.f5039l > 0 && this.f5038k > this.f5039l) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((NUADI) t).setMaxVideoDuration(this.f5039l);
        }
    }

    public void setMinVideoDuration(int i2) {
        this.f5038k = i2;
        if (this.f5039l > 0 && this.f5038k > this.f5039l) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((NUADI) t).setMinVideoDuration(this.f5038k);
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Vast class name 不能为空");
            return;
        }
        this.f5040m = str;
        T t = this.a;
        if (t != 0) {
            ((NUADI) t).setVastClassName(str);
        }
    }
}
