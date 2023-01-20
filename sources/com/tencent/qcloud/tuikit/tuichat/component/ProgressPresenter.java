package com.tencent.qcloud.tuikit.tuichat.component;

import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class ProgressPresenter {
    private static final String TAG = "ProgressPresenter";
    private final int REMOVE_THRESHOLD;
    private final Map<String, List<WeakReference<ProgressListener>>> progressListenerMap;
    private int removeCount;

    /* loaded from: classes3.dex */
    public interface ProgressListener {
        void onProgress(int i2);
    }

    /* loaded from: classes3.dex */
    public static final class ProgressPresenterHolder {
        private static final ProgressPresenter instance = new ProgressPresenter();

        private ProgressPresenterHolder() {
        }
    }

    public static ProgressPresenter getInstance() {
        return ProgressPresenterHolder.instance;
    }

    private void removeEmptyReference() {
        Iterator<Map.Entry<String, List<WeakReference<ProgressListener>>>> it = this.progressListenerMap.entrySet().iterator();
        while (it.hasNext()) {
            List<WeakReference<ProgressListener>> value = it.next().getValue();
            if (value == null) {
                it.remove();
            } else {
                ArrayList arrayList = new ArrayList();
                for (WeakReference<ProgressListener> weakReference : value) {
                    if (weakReference.get() == null) {
                        arrayList.add(weakReference);
                    }
                }
                value.removeAll(arrayList);
            }
        }
    }

    public void registerProgressListener(String str, ProgressListener progressListener) {
        String str2 = TAG;
        Log.i(str2, "registerProgressListener id : " + str + ", listener : " + progressListener);
        if (TextUtils.isEmpty(str) || progressListener == null) {
            return;
        }
        int i2 = this.removeCount + 1;
        this.removeCount = i2;
        if (i2 > 30) {
            removeEmptyReference();
            this.removeCount = 0;
        }
        List<WeakReference<ProgressListener>> list = this.progressListenerMap.get(str);
        if (list == null) {
            list = new CopyOnWriteArrayList<>();
            this.progressListenerMap.put(str, list);
        }
        list.add(new WeakReference<>(progressListener));
    }

    public void unregisterProgressListener(String str, ProgressListener progressListener) {
        List<WeakReference<ProgressListener>> list;
        String str2 = TAG;
        Log.i(str2, "unregisterProgressListener id : " + str + ", listener : " + progressListener);
        if (TextUtils.isEmpty(str) || progressListener == null || (list = this.progressListenerMap.get(str)) != null) {
            return;
        }
        WeakReference<ProgressListener> weakReference = null;
        Iterator<WeakReference<ProgressListener>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WeakReference<ProgressListener> next = it.next();
            if (next.get() == progressListener) {
                weakReference = next;
                break;
            }
        }
        list.remove(weakReference);
    }

    public void updateProgress(String str, int i2) {
        int i3 = this.removeCount + 1;
        this.removeCount = i3;
        if (i3 > 30) {
            removeEmptyReference();
            this.removeCount = 0;
        }
        List<WeakReference<ProgressListener>> list = this.progressListenerMap.get(str);
        if (list != null) {
            for (WeakReference<ProgressListener> weakReference : list) {
                ProgressListener progressListener = weakReference.get();
                if (progressListener != null) {
                    progressListener.onProgress(i2);
                }
            }
        }
    }

    private ProgressPresenter() {
        this.REMOVE_THRESHOLD = 30;
        this.progressListenerMap = new ConcurrentHashMap();
        this.removeCount = 0;
    }
}
