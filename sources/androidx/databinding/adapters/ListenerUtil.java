package androidx.databinding.adapters;

import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ListenerUtil {
    private static final SparseArray<WeakHashMap<View, WeakReference<?>>> sListeners = new SparseArray<>();

    public static <T> T getListener(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 14) {
            return (T) view.getTag(i2);
        }
        SparseArray<WeakHashMap<View, WeakReference<?>>> sparseArray = sListeners;
        synchronized (sparseArray) {
            WeakHashMap<View, WeakReference<?>> weakHashMap = sparseArray.get(i2);
            if (weakHashMap == null) {
                return null;
            }
            WeakReference<?> weakReference = weakHashMap.get(view);
            if (weakReference == null) {
                return null;
            }
            return (T) weakReference.get();
        }
    }

    public static <T> T trackListener(View view, T t, int i2) {
        WeakReference<?> put;
        if (Build.VERSION.SDK_INT >= 14) {
            T t2 = (T) view.getTag(i2);
            view.setTag(i2, t);
            return t2;
        }
        SparseArray<WeakHashMap<View, WeakReference<?>>> sparseArray = sListeners;
        synchronized (sparseArray) {
            WeakHashMap<View, WeakReference<?>> weakHashMap = sparseArray.get(i2);
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap<>();
                sparseArray.put(i2, weakHashMap);
            }
            if (t == null) {
                put = weakHashMap.remove(view);
            } else {
                put = weakHashMap.put(view, new WeakReference<>(t));
            }
            if (put == null) {
                return null;
            }
            return (T) put.get();
        }
    }
}
