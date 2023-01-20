package androidx.databinding;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.Observable;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import androidx.databinding.library.R;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewbinding.ViewBinding;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class ViewDataBinding extends BaseObservable implements ViewBinding {
    private static final int BINDING_NUMBER_START = 8;
    public static final String BINDING_TAG_PREFIX = "binding_";
    private static final CreateWeakListener CREATE_LIST_LISTENER;
    private static final CreateWeakListener CREATE_LIVE_DATA_LISTENER;
    private static final CreateWeakListener CREATE_MAP_LISTENER;
    private static final CreateWeakListener CREATE_PROPERTY_LISTENER;
    private static final int HALTED = 2;
    private static final int REBIND = 1;
    private static final CallbackRegistry.NotifierCallback<OnRebindCallback, ViewDataBinding, Void> REBIND_NOTIFIER;
    private static final int REBOUND = 3;
    private static final View.OnAttachStateChangeListener ROOT_REATTACHED_LISTENER;
    public static int SDK_INT;
    private static final boolean USE_CHOREOGRAPHER;
    private static final ReferenceQueue<ViewDataBinding> sReferenceQueue;
    public final DataBindingComponent mBindingComponent;
    private Choreographer mChoreographer;
    private ViewDataBinding mContainingBinding;
    private final Choreographer.FrameCallback mFrameCallback;
    private boolean mInLiveDataRegisterObserver;
    private boolean mIsExecutingPendingBindings;
    private LifecycleOwner mLifecycleOwner;
    private WeakListener[] mLocalFieldObservers;
    private OnStartListener mOnStartListener;
    private boolean mPendingRebind;
    private CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> mRebindCallbacks;
    private boolean mRebindHalted;
    private final Runnable mRebindRunnable;
    private final View mRoot;
    private Handler mUIThreadHandler;

    /* loaded from: classes.dex */
    public interface CreateWeakListener {
        WeakListener create(ViewDataBinding viewDataBinding, int i2);
    }

    /* loaded from: classes.dex */
    public static class IncludedLayouts {
        public final int[][] indexes;
        public final int[][] layoutIds;
        public final String[][] layouts;

        public IncludedLayouts(int i2) {
            this.layouts = new String[i2];
            this.indexes = new int[i2];
            this.layoutIds = new int[i2];
        }

        public void setIncludes(int i2, String[] strArr, int[] iArr, int[] iArr2) {
            this.layouts[i2] = strArr;
            this.indexes[i2] = iArr;
            this.layoutIds[i2] = iArr2;
        }
    }

    /* loaded from: classes.dex */
    public static class LiveDataListener implements Observer, ObservableReference<LiveData<?>> {
        public LifecycleOwner mLifecycleOwner;
        public final WeakListener<LiveData<?>> mListener;

        public LiveDataListener(ViewDataBinding viewDataBinding, int i2) {
            this.mListener = new WeakListener<>(viewDataBinding, i2, this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public WeakListener<LiveData<?>> getListener() {
            return this.mListener;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable Object obj) {
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null) {
                WeakListener<LiveData<?>> weakListener = this.mListener;
                binder.handleFieldChange(weakListener.mLocalFieldId, weakListener.getTarget(), 0);
            }
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
            LiveData<?> target = this.mListener.getTarget();
            if (target != null) {
                if (this.mLifecycleOwner != null) {
                    target.removeObserver(this);
                }
                if (lifecycleOwner != null) {
                    target.observe(lifecycleOwner, this);
                }
            }
            this.mLifecycleOwner = lifecycleOwner;
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void addListener(LiveData<?> liveData) {
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            if (lifecycleOwner != null) {
                liveData.observe(lifecycleOwner, this);
            }
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void removeListener(LiveData<?> liveData) {
            liveData.removeObserver(this);
        }
    }

    /* loaded from: classes.dex */
    public interface ObservableReference<T> {
        void addListener(T t);

        WeakListener<T> getListener();

        void removeListener(T t);

        void setLifecycleOwner(LifecycleOwner lifecycleOwner);
    }

    /* loaded from: classes.dex */
    public static class OnStartListener implements LifecycleObserver {
        public final WeakReference<ViewDataBinding> mBinding;

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = this.mBinding.get();
            if (viewDataBinding != null) {
                viewDataBinding.executePendingBindings();
            }
        }

        private OnStartListener(ViewDataBinding viewDataBinding) {
            this.mBinding = new WeakReference<>(viewDataBinding);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class PropertyChangedInverseListener extends Observable.OnPropertyChangedCallback implements InverseBindingListener {
        public final int mPropertyId;

        public PropertyChangedInverseListener(int i2) {
            this.mPropertyId = i2;
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i2) {
            if (i2 == this.mPropertyId || i2 == 0) {
                onChange();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class WeakListListener extends ObservableList.OnListChangedCallback implements ObservableReference<ObservableList> {
        public final WeakListener<ObservableList> mListener;

        public WeakListListener(ViewDataBinding viewDataBinding, int i2) {
            this.mListener = new WeakListener<>(viewDataBinding, i2, this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public WeakListener<ObservableList> getListener() {
            return this.mListener;
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onChanged(ObservableList observableList) {
            ObservableList target;
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null && (target = this.mListener.getTarget()) == observableList) {
                binder.handleFieldChange(this.mListener.mLocalFieldId, target, 0);
            }
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeChanged(ObservableList observableList, int i2, int i3) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeInserted(ObservableList observableList, int i2, int i3) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeMoved(ObservableList observableList, int i2, int i3, int i4) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeRemoved(ObservableList observableList, int i2, int i3) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void addListener(ObservableList observableList) {
            observableList.addOnListChangedCallback(this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void removeListener(ObservableList observableList) {
            observableList.removeOnListChangedCallback(this);
        }
    }

    /* loaded from: classes.dex */
    public static class WeakListener<T> extends WeakReference<ViewDataBinding> {
        public final int mLocalFieldId;
        private final ObservableReference<T> mObservable;
        private T mTarget;

        public WeakListener(ViewDataBinding viewDataBinding, int i2, ObservableReference<T> observableReference) {
            super(viewDataBinding, ViewDataBinding.sReferenceQueue);
            this.mLocalFieldId = i2;
            this.mObservable = observableReference;
        }

        public ViewDataBinding getBinder() {
            ViewDataBinding viewDataBinding = (ViewDataBinding) get();
            if (viewDataBinding == null) {
                unregister();
            }
            return viewDataBinding;
        }

        public T getTarget() {
            return this.mTarget;
        }

        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
            this.mObservable.setLifecycleOwner(lifecycleOwner);
        }

        public void setTarget(T t) {
            unregister();
            this.mTarget = t;
            if (t != null) {
                this.mObservable.addListener(t);
            }
        }

        public boolean unregister() {
            boolean z;
            T t = this.mTarget;
            if (t != null) {
                this.mObservable.removeListener(t);
                z = true;
            } else {
                z = false;
            }
            this.mTarget = null;
            return z;
        }
    }

    /* loaded from: classes.dex */
    public static class WeakMapListener extends ObservableMap.OnMapChangedCallback implements ObservableReference<ObservableMap> {
        public final WeakListener<ObservableMap> mListener;

        public WeakMapListener(ViewDataBinding viewDataBinding, int i2) {
            this.mListener = new WeakListener<>(viewDataBinding, i2, this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public WeakListener<ObservableMap> getListener() {
            return this.mListener;
        }

        @Override // androidx.databinding.ObservableMap.OnMapChangedCallback
        public void onMapChanged(ObservableMap observableMap, Object obj) {
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder == null || observableMap != this.mListener.getTarget()) {
                return;
            }
            binder.handleFieldChange(this.mListener.mLocalFieldId, observableMap, 0);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void addListener(ObservableMap observableMap) {
            observableMap.addOnMapChangedCallback(this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void removeListener(ObservableMap observableMap) {
            observableMap.removeOnMapChangedCallback(this);
        }
    }

    /* loaded from: classes.dex */
    public static class WeakPropertyListener extends Observable.OnPropertyChangedCallback implements ObservableReference<Observable> {
        public final WeakListener<Observable> mListener;

        public WeakPropertyListener(ViewDataBinding viewDataBinding, int i2) {
            this.mListener = new WeakListener<>(viewDataBinding, i2, this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public WeakListener<Observable> getListener() {
            return this.mListener;
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i2) {
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null && this.mListener.getTarget() == observable) {
                binder.handleFieldChange(this.mListener.mLocalFieldId, observable, i2);
            }
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void addListener(Observable observable) {
            observable.addOnPropertyChangedCallback(this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void removeListener(Observable observable) {
            observable.removeOnPropertyChangedCallback(this);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        SDK_INT = i2;
        USE_CHOREOGRAPHER = i2 >= 16;
        CREATE_PROPERTY_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.1
            @Override // androidx.databinding.ViewDataBinding.CreateWeakListener
            public WeakListener create(ViewDataBinding viewDataBinding, int i3) {
                return new WeakPropertyListener(viewDataBinding, i3).getListener();
            }
        };
        CREATE_LIST_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.2
            @Override // androidx.databinding.ViewDataBinding.CreateWeakListener
            public WeakListener create(ViewDataBinding viewDataBinding, int i3) {
                return new WeakListListener(viewDataBinding, i3).getListener();
            }
        };
        CREATE_MAP_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.3
            @Override // androidx.databinding.ViewDataBinding.CreateWeakListener
            public WeakListener create(ViewDataBinding viewDataBinding, int i3) {
                return new WeakMapListener(viewDataBinding, i3).getListener();
            }
        };
        CREATE_LIVE_DATA_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.4
            @Override // androidx.databinding.ViewDataBinding.CreateWeakListener
            public WeakListener create(ViewDataBinding viewDataBinding, int i3) {
                return new LiveDataListener(viewDataBinding, i3).getListener();
            }
        };
        REBIND_NOTIFIER = new CallbackRegistry.NotifierCallback<OnRebindCallback, ViewDataBinding, Void>() { // from class: androidx.databinding.ViewDataBinding.5
            @Override // androidx.databinding.CallbackRegistry.NotifierCallback
            public void onNotifyCallback(OnRebindCallback onRebindCallback, ViewDataBinding viewDataBinding, int i3, Void r4) {
                if (i3 == 1) {
                    if (onRebindCallback.onPreBind(viewDataBinding)) {
                        return;
                    }
                    viewDataBinding.mRebindHalted = true;
                } else if (i3 == 2) {
                    onRebindCallback.onCanceled(viewDataBinding);
                } else if (i3 != 3) {
                } else {
                    onRebindCallback.onBound(viewDataBinding);
                }
            }
        };
        sReferenceQueue = new ReferenceQueue<>();
        if (i2 < 19) {
            ROOT_REATTACHED_LISTENER = null;
        } else {
            ROOT_REATTACHED_LISTENER = new View.OnAttachStateChangeListener() { // from class: androidx.databinding.ViewDataBinding.6
                @Override // android.view.View.OnAttachStateChangeListener
                @TargetApi(19)
                public void onViewAttachedToWindow(View view) {
                    ViewDataBinding.getBinding(view).mRebindRunnable.run();
                    view.removeOnAttachStateChangeListener(this);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            };
        }
    }

    public ViewDataBinding(DataBindingComponent dataBindingComponent, View view, int i2) {
        this.mRebindRunnable = new Runnable() { // from class: androidx.databinding.ViewDataBinding.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    ViewDataBinding.this.mPendingRebind = false;
                }
                ViewDataBinding.processReferenceQueue();
                if (Build.VERSION.SDK_INT >= 19 && !ViewDataBinding.this.mRoot.isAttachedToWindow()) {
                    ViewDataBinding.this.mRoot.removeOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
                    ViewDataBinding.this.mRoot.addOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
                    return;
                }
                ViewDataBinding.this.executePendingBindings();
            }
        };
        this.mPendingRebind = false;
        this.mRebindHalted = false;
        this.mBindingComponent = dataBindingComponent;
        this.mLocalFieldObservers = new WeakListener[i2];
        this.mRoot = view;
        if (Looper.myLooper() != null) {
            if (USE_CHOREOGRAPHER) {
                this.mChoreographer = Choreographer.getInstance();
                this.mFrameCallback = new Choreographer.FrameCallback() { // from class: androidx.databinding.ViewDataBinding.8
                    @Override // android.view.Choreographer.FrameCallback
                    public void doFrame(long j2) {
                        ViewDataBinding.this.mRebindRunnable.run();
                    }
                };
                return;
            }
            this.mFrameCallback = null;
            this.mUIThreadHandler = new Handler(Looper.myLooper());
            return;
        }
        throw new IllegalStateException("DataBinding must be created in view's UI Thread");
    }

    public static ViewDataBinding bind(Object obj, View view, int i2) {
        return DataBindingUtil.bind(checkAndCastToBindingComponent(obj), view, i2);
    }

    private static DataBindingComponent checkAndCastToBindingComponent(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof DataBindingComponent) {
            return (DataBindingComponent) obj;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    private void executeBindingsInternal() {
        if (this.mIsExecutingPendingBindings) {
            requestRebind();
        } else if (hasPendingBindings()) {
            this.mIsExecutingPendingBindings = true;
            this.mRebindHalted = false;
            CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> callbackRegistry = this.mRebindCallbacks;
            if (callbackRegistry != null) {
                callbackRegistry.notifyCallbacks(this, 1, null);
                if (this.mRebindHalted) {
                    this.mRebindCallbacks.notifyCallbacks(this, 2, null);
                }
            }
            if (!this.mRebindHalted) {
                executeBindings();
                CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> callbackRegistry2 = this.mRebindCallbacks;
                if (callbackRegistry2 != null) {
                    callbackRegistry2.notifyCallbacks(this, 3, null);
                }
            }
            this.mIsExecutingPendingBindings = false;
        }
    }

    public static void executeBindingsOn(ViewDataBinding viewDataBinding) {
        viewDataBinding.executeBindingsInternal();
    }

    private static int findIncludeIndex(String str, int i2, IncludedLayouts includedLayouts, int i3) {
        CharSequence subSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = includedLayouts.layouts[i3];
        int length = strArr.length;
        while (i2 < length) {
            if (TextUtils.equals(subSequence, strArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private static int findLastMatching(ViewGroup viewGroup, int i2) {
        String str = (String) viewGroup.getChildAt(i2).getTag();
        String substring = str.substring(0, str.length() - 1);
        int length = substring.length();
        int childCount = viewGroup.getChildCount();
        for (int i3 = i2 + 1; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            String str2 = childAt.getTag() instanceof String ? (String) childAt.getTag() : null;
            if (str2 != null && str2.startsWith(substring)) {
                if (str2.length() == str.length() && str2.charAt(str2.length() - 1) == '0') {
                    return i2;
                }
                if (isNumeric(str2, length)) {
                    i2 = i3;
                }
            }
        }
        return i2;
    }

    public static ViewDataBinding getBinding(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(R.id.dataBinding);
        }
        return null;
    }

    public static int getBuildSdkInt() {
        return SDK_INT;
    }

    public static int getColorFromResource(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return view.getContext().getColor(i2);
        }
        return view.getResources().getColor(i2);
    }

    public static ColorStateList getColorStateListFromResource(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return view.getContext().getColorStateList(i2);
        }
        return view.getResources().getColorStateList(i2);
    }

    public static Drawable getDrawableFromResource(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getContext().getDrawable(i2);
        }
        return view.getResources().getDrawable(i2);
    }

    public static <K, T> T getFrom(Map<K, T> map, K k2) {
        if (map == null) {
            return null;
        }
        return map.get(k2);
    }

    public static <T> T getFromArray(T[] tArr, int i2) {
        if (tArr == null || i2 < 0 || i2 >= tArr.length) {
            return null;
        }
        return tArr[i2];
    }

    public static <T> T getFromList(List<T> list, int i2) {
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return list.get(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFieldChange(int i2, Object obj, int i3) {
        if (!this.mInLiveDataRegisterObserver && onFieldChange(i2, obj, i3)) {
            requestRebind();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static <T extends ViewDataBinding> T inflateInternal(@NonNull LayoutInflater layoutInflater, int i2, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (T) DataBindingUtil.inflate(layoutInflater, i2, viewGroup, z, checkAndCastToBindingComponent(obj));
    }

    private static boolean isNumeric(String str, int i2) {
        int length = str.length();
        if (length == i2) {
            return false;
        }
        while (i2 < length) {
            if (!Character.isDigit(str.charAt(i2))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public static Object[] mapBindings(DataBindingComponent dataBindingComponent, View view, int i2, IncludedLayouts includedLayouts, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i2];
        mapBindings(dataBindingComponent, view, objArr, includedLayouts, sparseIntArray, true);
        return objArr;
    }

    public static boolean parse(String str, boolean z) {
        return str == null ? z : Boolean.parseBoolean(str);
    }

    private static int parseTagInt(String str, int i2) {
        int length = str.length();
        int i3 = 0;
        while (i2 < length) {
            i3 = (i3 * 10) + (str.charAt(i2) - '0');
            i2++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processReferenceQueue() {
        while (true) {
            Reference<? extends ViewDataBinding> poll = sReferenceQueue.poll();
            if (poll == null) {
                return;
            }
            if (poll instanceof WeakListener) {
                ((WeakListener) poll).unregister();
            }
        }
    }

    public static int safeUnbox(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static void setBindingInverseListener(ViewDataBinding viewDataBinding, InverseBindingListener inverseBindingListener, PropertyChangedInverseListener propertyChangedInverseListener) {
        if (inverseBindingListener != propertyChangedInverseListener) {
            if (inverseBindingListener != null) {
                viewDataBinding.removeOnPropertyChangedCallback((PropertyChangedInverseListener) inverseBindingListener);
            }
            if (propertyChangedInverseListener != null) {
                viewDataBinding.addOnPropertyChangedCallback(propertyChangedInverseListener);
            }
        }
    }

    public static <T> void setTo(T[] tArr, int i2, T t) {
        if (tArr == null || i2 < 0 || i2 >= tArr.length) {
            return;
        }
        tArr[i2] = t;
    }

    private boolean updateRegistration(int i2, Object obj, CreateWeakListener createWeakListener) {
        if (obj == null) {
            return unregisterFrom(i2);
        }
        WeakListener weakListener = this.mLocalFieldObservers[i2];
        if (weakListener == null) {
            registerTo(i2, obj, createWeakListener);
            return true;
        } else if (weakListener.getTarget() == obj) {
            return false;
        } else {
            unregisterFrom(i2);
            registerTo(i2, obj, createWeakListener);
            return true;
        }
    }

    public void addOnRebindCallback(@NonNull OnRebindCallback onRebindCallback) {
        if (this.mRebindCallbacks == null) {
            this.mRebindCallbacks = new CallbackRegistry<>(REBIND_NOTIFIER);
        }
        this.mRebindCallbacks.add(onRebindCallback);
    }

    public void ensureBindingComponentIsNotNull(Class<?> cls) {
        if (this.mBindingComponent != null) {
            return;
        }
        throw new IllegalStateException("Required DataBindingComponent is null in class " + getClass().getSimpleName() + ". A BindingAdapter in " + cls.getCanonicalName() + " is not static and requires an object to use, retrieved from the DataBindingComponent. If you don't use an inflation method taking a DataBindingComponent, use DataBindingUtil.setDefaultComponent or make all BindingAdapter methods static.");
    }

    public abstract void executeBindings();

    public void executePendingBindings() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding == null) {
            executeBindingsInternal();
        } else {
            viewDataBinding.executePendingBindings();
        }
    }

    public void forceExecuteBindings() {
        executeBindings();
    }

    @Nullable
    public LifecycleOwner getLifecycleOwner() {
        return this.mLifecycleOwner;
    }

    public Object getObservedField(int i2) {
        WeakListener weakListener = this.mLocalFieldObservers[i2];
        if (weakListener == null) {
            return null;
        }
        return weakListener.getTarget();
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.mRoot;
    }

    public abstract boolean hasPendingBindings();

    public abstract void invalidateAll();

    public abstract boolean onFieldChange(int i2, Object obj, int i3);

    public void registerTo(int i2, Object obj, CreateWeakListener createWeakListener) {
        if (obj == null) {
            return;
        }
        WeakListener weakListener = this.mLocalFieldObservers[i2];
        if (weakListener == null) {
            weakListener = createWeakListener.create(this, i2);
            this.mLocalFieldObservers[i2] = weakListener;
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            if (lifecycleOwner != null) {
                weakListener.setLifecycleOwner(lifecycleOwner);
            }
        }
        weakListener.setTarget(obj);
    }

    public void removeOnRebindCallback(@NonNull OnRebindCallback onRebindCallback) {
        CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> callbackRegistry = this.mRebindCallbacks;
        if (callbackRegistry != null) {
            callbackRegistry.remove(onRebindCallback);
        }
    }

    public void requestRebind() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding != null) {
            viewDataBinding.requestRebind();
            return;
        }
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
        if (lifecycleOwner == null || lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            synchronized (this) {
                if (this.mPendingRebind) {
                    return;
                }
                this.mPendingRebind = true;
                if (USE_CHOREOGRAPHER) {
                    this.mChoreographer.postFrameCallback(this.mFrameCallback);
                } else {
                    this.mUIThreadHandler.post(this.mRebindRunnable);
                }
            }
        }
    }

    public void setContainedBinding(ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.mContainingBinding = this;
        }
    }

    @MainThread
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        WeakListener[] weakListenerArr;
        LifecycleOwner lifecycleOwner2 = this.mLifecycleOwner;
        if (lifecycleOwner2 == lifecycleOwner) {
            return;
        }
        if (lifecycleOwner2 != null) {
            lifecycleOwner2.getLifecycle().removeObserver(this.mOnStartListener);
        }
        this.mLifecycleOwner = lifecycleOwner;
        if (lifecycleOwner != null) {
            if (this.mOnStartListener == null) {
                this.mOnStartListener = new OnStartListener();
            }
            lifecycleOwner.getLifecycle().addObserver(this.mOnStartListener);
        }
        for (WeakListener weakListener : this.mLocalFieldObservers) {
            if (weakListener != null) {
                weakListener.setLifecycleOwner(lifecycleOwner);
            }
        }
    }

    public void setRootTag(View view) {
        view.setTag(R.id.dataBinding, this);
    }

    public abstract boolean setVariable(int i2, @Nullable Object obj);

    public void unbind() {
        WeakListener[] weakListenerArr;
        for (WeakListener weakListener : this.mLocalFieldObservers) {
            if (weakListener != null) {
                weakListener.unregister();
            }
        }
    }

    public boolean unregisterFrom(int i2) {
        WeakListener weakListener = this.mLocalFieldObservers[i2];
        if (weakListener != null) {
            return weakListener.unregister();
        }
        return false;
    }

    public boolean updateLiveDataRegistration(int i2, LiveData<?> liveData) {
        this.mInLiveDataRegisterObserver = true;
        try {
            return updateRegistration(i2, liveData, CREATE_LIVE_DATA_LISTENER);
        } finally {
            this.mInLiveDataRegisterObserver = false;
        }
    }

    public static byte parse(String str, byte b) {
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b;
        }
    }

    public static long safeUnbox(Long l2) {
        if (l2 == null) {
            return 0L;
        }
        return l2.longValue();
    }

    public void setRootTag(View[] viewArr) {
        for (View view : viewArr) {
            view.setTag(R.id.dataBinding, this);
        }
    }

    public static boolean getFromArray(boolean[] zArr, int i2) {
        if (zArr == null || i2 < 0 || i2 >= zArr.length) {
            return false;
        }
        return zArr[i2];
    }

    public static <T> T getFromList(SparseArray<T> sparseArray, int i2) {
        if (sparseArray == null || i2 < 0) {
            return null;
        }
        return sparseArray.get(i2);
    }

    public static Object[] mapBindings(DataBindingComponent dataBindingComponent, View[] viewArr, int i2, IncludedLayouts includedLayouts, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i2];
        for (View view : viewArr) {
            mapBindings(dataBindingComponent, view, objArr, includedLayouts, sparseIntArray, true);
        }
        return objArr;
    }

    public static short parse(String str, short s) {
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s;
        }
    }

    public static short safeUnbox(Short sh) {
        if (sh == null) {
            return (short) 0;
        }
        return sh.shortValue();
    }

    public static void setTo(boolean[] zArr, int i2, boolean z) {
        if (zArr == null || i2 < 0 || i2 >= zArr.length) {
            return;
        }
        zArr[i2] = z;
    }

    @TargetApi(16)
    public static <T> T getFromList(LongSparseArray<T> longSparseArray, int i2) {
        if (longSparseArray == null || i2 < 0) {
            return null;
        }
        return longSparseArray.get(i2);
    }

    public static int parse(String str, int i2) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public static byte safeUnbox(Byte b) {
        if (b == null) {
            return (byte) 0;
        }
        return b.byteValue();
    }

    public static byte getFromArray(byte[] bArr, int i2) {
        if (bArr == null || i2 < 0 || i2 >= bArr.length) {
            return (byte) 0;
        }
        return bArr[i2];
    }

    public static <T> T getFromList(androidx.collection.LongSparseArray<T> longSparseArray, int i2) {
        if (longSparseArray == null || i2 < 0) {
            return null;
        }
        return longSparseArray.get(i2);
    }

    public static long parse(String str, long j2) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j2;
        }
    }

    public static char safeUnbox(Character ch) {
        if (ch == null) {
            return (char) 0;
        }
        return ch.charValue();
    }

    public static void setTo(byte[] bArr, int i2, byte b) {
        if (bArr == null || i2 < 0 || i2 >= bArr.length) {
            return;
        }
        bArr[i2] = b;
    }

    public static boolean getFromList(SparseBooleanArray sparseBooleanArray, int i2) {
        if (sparseBooleanArray == null || i2 < 0) {
            return false;
        }
        return sparseBooleanArray.get(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void mapBindings(androidx.databinding.DataBindingComponent r16, android.view.View r17, java.lang.Object[] r18, androidx.databinding.ViewDataBinding.IncludedLayouts r19, android.util.SparseIntArray r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.mapBindings(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[], androidx.databinding.ViewDataBinding$IncludedLayouts, android.util.SparseIntArray, boolean):void");
    }

    public static float parse(String str, float f2) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f2;
        }
    }

    public static double safeUnbox(Double d2) {
        if (d2 == null) {
            return 0.0d;
        }
        return d2.doubleValue();
    }

    public static short getFromArray(short[] sArr, int i2) {
        if (sArr == null || i2 < 0 || i2 >= sArr.length) {
            return (short) 0;
        }
        return sArr[i2];
    }

    public static int getFromList(SparseIntArray sparseIntArray, int i2) {
        if (sparseIntArray == null || i2 < 0) {
            return 0;
        }
        return sparseIntArray.get(i2);
    }

    public static double parse(String str, double d2) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d2;
        }
    }

    public static float safeUnbox(Float f2) {
        if (f2 == null) {
            return 0.0f;
        }
        return f2.floatValue();
    }

    public static void setTo(short[] sArr, int i2, short s) {
        if (sArr == null || i2 < 0 || i2 >= sArr.length) {
            return;
        }
        sArr[i2] = s;
    }

    public boolean updateRegistration(int i2, Observable observable) {
        return updateRegistration(i2, observable, CREATE_PROPERTY_LISTENER);
    }

    @TargetApi(18)
    public static long getFromList(SparseLongArray sparseLongArray, int i2) {
        if (sparseLongArray == null || i2 < 0) {
            return 0L;
        }
        return sparseLongArray.get(i2);
    }

    public static char parse(String str, char c2) {
        return (str == null || str.isEmpty()) ? c2 : str.charAt(0);
    }

    public static boolean safeUnbox(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean updateRegistration(int i2, ObservableList observableList) {
        return updateRegistration(i2, observableList, CREATE_LIST_LISTENER);
    }

    public static char getFromArray(char[] cArr, int i2) {
        if (cArr == null || i2 < 0 || i2 >= cArr.length) {
            return (char) 0;
        }
        return cArr[i2];
    }

    public static void setTo(char[] cArr, int i2, char c2) {
        if (cArr == null || i2 < 0 || i2 >= cArr.length) {
            return;
        }
        cArr[i2] = c2;
    }

    public boolean updateRegistration(int i2, ObservableMap observableMap) {
        return updateRegistration(i2, observableMap, CREATE_MAP_LISTENER);
    }

    public static int getFromArray(int[] iArr, int i2) {
        if (iArr == null || i2 < 0 || i2 >= iArr.length) {
            return 0;
        }
        return iArr[i2];
    }

    public static void setTo(int[] iArr, int i2, int i3) {
        if (iArr == null || i2 < 0 || i2 >= iArr.length) {
            return;
        }
        iArr[i2] = i3;
    }

    public static long getFromArray(long[] jArr, int i2) {
        if (jArr == null || i2 < 0 || i2 >= jArr.length) {
            return 0L;
        }
        return jArr[i2];
    }

    public static void setTo(long[] jArr, int i2, long j2) {
        if (jArr == null || i2 < 0 || i2 >= jArr.length) {
            return;
        }
        jArr[i2] = j2;
    }

    public ViewDataBinding(Object obj, View view, int i2) {
        this(checkAndCastToBindingComponent(obj), view, i2);
    }

    public static float getFromArray(float[] fArr, int i2) {
        if (fArr == null || i2 < 0 || i2 >= fArr.length) {
            return 0.0f;
        }
        return fArr[i2];
    }

    public static void setTo(float[] fArr, int i2, float f2) {
        if (fArr == null || i2 < 0 || i2 >= fArr.length) {
            return;
        }
        fArr[i2] = f2;
    }

    public static double getFromArray(double[] dArr, int i2) {
        if (dArr == null || i2 < 0 || i2 >= dArr.length) {
            return 0.0d;
        }
        return dArr[i2];
    }

    public static void setTo(double[] dArr, int i2, double d2) {
        if (dArr == null || i2 < 0 || i2 >= dArr.length) {
            return;
        }
        dArr[i2] = d2;
    }

    public static <T> void setTo(List<T> list, int i2, T t) {
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return;
        }
        list.set(i2, t);
    }

    public static <T> void setTo(SparseArray<T> sparseArray, int i2, T t) {
        if (sparseArray == null || i2 < 0 || i2 >= sparseArray.size()) {
            return;
        }
        sparseArray.put(i2, t);
    }

    @TargetApi(16)
    public static <T> void setTo(LongSparseArray<T> longSparseArray, int i2, T t) {
        if (longSparseArray == null || i2 < 0 || i2 >= longSparseArray.size()) {
            return;
        }
        longSparseArray.put(i2, t);
    }

    public static <T> void setTo(androidx.collection.LongSparseArray<T> longSparseArray, int i2, T t) {
        if (longSparseArray == null || i2 < 0 || i2 >= longSparseArray.size()) {
            return;
        }
        longSparseArray.put(i2, t);
    }

    public static void setTo(SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        if (sparseBooleanArray == null || i2 < 0 || i2 >= sparseBooleanArray.size()) {
            return;
        }
        sparseBooleanArray.put(i2, z);
    }

    public static void setTo(SparseIntArray sparseIntArray, int i2, int i3) {
        if (sparseIntArray == null || i2 < 0 || i2 >= sparseIntArray.size()) {
            return;
        }
        sparseIntArray.put(i2, i3);
    }

    @TargetApi(18)
    public static void setTo(SparseLongArray sparseLongArray, int i2, long j2) {
        if (sparseLongArray == null || i2 < 0 || i2 >= sparseLongArray.size()) {
            return;
        }
        sparseLongArray.put(i2, j2);
    }

    public static <K, T> void setTo(Map<K, T> map, K k2, T t) {
        if (map == null) {
            return;
        }
        map.put(k2, t);
    }
}
