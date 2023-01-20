package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00112\u000e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012J\b\u0010\u0014\u001a\u00020\u0015H\u0004R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Landroidx/lifecycle/ExternalLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "()V", "fieldObservers", "", "getFieldObservers", "()Ljava/lang/Object;", "callMethodIsAttachedTo", "", "caller", TUIConstants.TUIChat.OWNER, "callMethodPutIfAbsent", "observer", "wrapper", "observe", "", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/Observer;", "observeSticky", "observerActiveLevel", "Landroidx/lifecycle/Lifecycle$State;", "ExternalLifecycleBoundObserver", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ExternalLiveData<T> extends MutableLiveData<T> {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0080\u0004\u0018\u00002\u00140\u0001R\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00018\u00008\u00000\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0000\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, d2 = {"Landroidx/lifecycle/ExternalLiveData$ExternalLifecycleBoundObserver;", "Landroidx/lifecycle/LiveData$LifecycleBoundObserver;", "Landroidx/lifecycle/LiveData;", "kotlin.jvm.PlatformType", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "(Landroidx/lifecycle/ExternalLiveData;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V", "shouldBeActive", "", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public final class ExternalLifecycleBoundObserver extends LiveData<T>.LifecycleBoundObserver {
        public ExternalLifecycleBoundObserver(@d LifecycleOwner lifecycleOwner, @e Observer<? super T> observer) {
            super(lifecycleOwner, observer);
        }

        @Override // androidx.lifecycle.LiveData.LifecycleBoundObserver, androidx.lifecycle.LiveData.ObserverWrapper
        public boolean shouldBeActive() {
            return this.mOwner.getLifecycle().getCurrentState().isAtLeast(ExternalLiveData.this.observerActiveLevel());
        }
    }

    private final boolean callMethodIsAttachedTo(Object obj, Object obj2) throws Exception {
        Method declaredMethod = obj.getClass().getSuperclass().getDeclaredMethod("isAttachedTo", LifecycleOwner.class);
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(obj, obj2);
        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) invoke).booleanValue();
    }

    private final Object callMethodPutIfAbsent(Object obj, Object obj2) throws Exception {
        Object fieldObservers = getFieldObservers();
        Method declaredMethod = fieldObservers.getClass().getDeclaredMethod("putIfAbsent", Object.class, Object.class);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(fieldObservers, obj, obj2);
    }

    private final Object getFieldObservers() throws Exception {
        Field declaredField = LiveData.class.getDeclaredField("mObservers");
        declaredField.setAccessible(true);
        return declaredField.get(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034 A[Catch: Exception -> 0x0040, TryCatch #0 {Exception -> 0x0040, blocks: (B:4:0x000c, B:6:0x001d, B:14:0x002c, B:15:0x0034, B:16:0x003f), top: B:20:0x000c }] */
    @Override // androidx.lifecycle.LiveData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void observe(@k.e.a.d androidx.lifecycle.LifecycleOwner r3, @k.e.a.d androidx.lifecycle.Observer<? super T> r4) {
        /*
            r2 = this;
            androidx.lifecycle.Lifecycle r0 = r3.getLifecycle()
            androidx.lifecycle.Lifecycle$State r0 = r0.getCurrentState()
            androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.DESTROYED
            if (r0 == r1) goto L44
            androidx.lifecycle.ExternalLiveData$ExternalLifecycleBoundObserver r0 = new androidx.lifecycle.ExternalLiveData$ExternalLifecycleBoundObserver     // Catch: java.lang.Exception -> L40
            r0.<init>(r3, r4)     // Catch: java.lang.Exception -> L40
            int r1 = r2.getVersion()     // Catch: java.lang.Exception -> L40
            r0.mLastVersion = r1     // Catch: java.lang.Exception -> L40
            java.lang.Object r4 = r2.callMethodPutIfAbsent(r4, r0)     // Catch: java.lang.Exception -> L40
            if (r4 == 0) goto L26
            boolean r1 = r2.callMethodIsAttachedTo(r4, r3)     // Catch: java.lang.Exception -> L40
            if (r1 == 0) goto L24
            goto L26
        L24:
            r1 = 0
            goto L27
        L26:
            r1 = 1
        L27:
            if (r1 == 0) goto L34
            if (r4 == 0) goto L2c
            return
        L2c:
            androidx.lifecycle.Lifecycle r3 = r3.getLifecycle()     // Catch: java.lang.Exception -> L40
            r3.addObserver(r0)     // Catch: java.lang.Exception -> L40
            goto L44
        L34:
            java.lang.String r3 = "Cannot add the same observer with different lifecycles"
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch: java.lang.Exception -> L40
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L40
            r4.<init>(r3)     // Catch: java.lang.Exception -> L40
            throw r4     // Catch: java.lang.Exception -> L40
        L40:
            r3 = move-exception
            r3.printStackTrace()
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ExternalLiveData.observe(androidx.lifecycle.LifecycleOwner, androidx.lifecycle.Observer):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void observeSticky(@d LifecycleOwner lifecycleOwner, @d Observer<T> observer) {
        super.observe(lifecycleOwner, observer);
    }

    @d
    public final Lifecycle.State observerActiveLevel() {
        return Lifecycle.State.CREATED;
    }
}
