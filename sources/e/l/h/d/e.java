package e.l.h.d;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.jihuanshe.base.bus.LiveBusUtil;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.umeng.analytics.pro.am;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0007H\u0016J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016RB\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/jihuanshe/base/bus/BusMutableLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "()V", "mObservers", "Ljava/util/HashMap;", "", "Landroidx/lifecycle/Observer;", "Lkotlin/collections/HashMap;", "getMObservers", "()Ljava/util/HashMap;", "setMObservers", "(Ljava/util/HashMap;)V", "mVersion", "observe", "", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "observer", "observeForever", "postValue", "value", "(Ljava/lang/Object;)V", "setValue", "CustomObserver", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public class e<T> extends MutableLiveData<T> {
    private int a = -1;
    @k.e.a.d
    private HashMap<Integer, Observer<T>> b = new HashMap<>();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0002\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000fR\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010\t\u001a \u0012\u001c\u0012\u001a\u0012\u0006\b\u0000\u0012\u00028\u0001 \u000b*\f\u0012\u0006\b\u0000\u0012\u00028\u0001\u0018\u00010\u00020\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/jihuanshe/base/bus/BusMutableLiveData$CustomObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/Observer;", "mObserver", "live", "Lcom/jihuanshe/base/bus/BusMutableLiveData;", "(Landroidx/lifecycle/Observer;Lcom/jihuanshe/base/bus/BusMutableLiveData;)V", "mLastVersion", "", "ref", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onChanged", "", am.aI, "(Ljava/lang/Object;)V", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class a<T> implements Observer<T> {
        @k.e.a.d
        private final e<?> a;
        @k.e.a.d
        private final WeakReference<Observer<? super T>> b;

        /* renamed from: c  reason: collision with root package name */
        private int f12085c;

        public a(@k.e.a.d Observer<? super T> observer, @k.e.a.d e<?> eVar) {
            this.a = eVar;
            this.b = new WeakReference<>(observer);
            this.f12085c = ((e) eVar).a;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(T t) {
            if (this.f12085c < ((e) this.a).a) {
                Observer<? super T> observer = this.b.get();
                if (observer != null) {
                    observer.onChanged(t);
                }
                this.f12085c = ((e) this.a).a;
            }
        }
    }

    @k.e.a.d
    public final HashMap<Integer, Observer<T>> b() {
        return this.b;
    }

    public final void c(@k.e.a.d HashMap<Integer, Observer<T>> hashMap) {
        this.b = hashMap;
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(@k.e.a.d LifecycleOwner lifecycleOwner, @k.e.a.d Observer<? super T> observer) {
        this.b.put(Integer.valueOf(observer.hashCode()), new a(observer, this));
        super.observe(lifecycleOwner, observer);
    }

    @Override // androidx.lifecycle.LiveData
    public void observeForever(@k.e.a.d Observer<? super T> observer) {
        a aVar = new a(observer, this);
        this.b.put(Integer.valueOf(observer.hashCode()), aVar);
        super.observeForever(aVar);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(T t) {
        this.a++;
        LiveBusUtil.a.e(this, t);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T t) {
        this.a++;
        super.setValue(t);
    }
}
