package androidx.camera.core;

import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import e.j.c.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class SettableImageProxyBundle implements ImageProxyBundle {
    private final List<Integer> mCaptureIdList;
    private String mTagBundleKey;
    public final Object mLock = new Object();
    @GuardedBy("mLock")
    public final SparseArray<CallbackToFutureAdapter.Completer<ImageProxy>> mCompleters = new SparseArray<>();
    @GuardedBy("mLock")
    private final SparseArray<a<ImageProxy>> mFutureResults = new SparseArray<>();
    @GuardedBy("mLock")
    private final List<ImageProxy> mOwnedImageProxies = new ArrayList();
    @GuardedBy("mLock")
    private boolean mClosed = false;

    public SettableImageProxyBundle(List<Integer> list, String str) {
        this.mTagBundleKey = null;
        this.mCaptureIdList = list;
        this.mTagBundleKey = str;
        setup();
    }

    private void setup() {
        synchronized (this.mLock) {
            for (Integer num : this.mCaptureIdList) {
                final int intValue = num.intValue();
                this.mFutureResults.put(intValue, CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<ImageProxy>() { // from class: androidx.camera.core.SettableImageProxyBundle.1
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public Object attachCompleter(@NonNull CallbackToFutureAdapter.Completer<ImageProxy> completer) {
                        synchronized (SettableImageProxyBundle.this.mLock) {
                            SettableImageProxyBundle.this.mCompleters.put(intValue, completer);
                        }
                        return "getImageProxy(id: " + intValue + ")";
                    }
                }));
            }
        }
    }

    public void addImageProxy(ImageProxy imageProxy) {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            Integer num = (Integer) imageProxy.getImageInfo().getTagBundle().getTag(this.mTagBundleKey);
            if (num != null) {
                CallbackToFutureAdapter.Completer<ImageProxy> completer = this.mCompleters.get(num.intValue());
                if (completer != null) {
                    this.mOwnedImageProxies.add(imageProxy);
                    completer.set(imageProxy);
                    return;
                }
                throw new IllegalArgumentException("ImageProxyBundle does not contain this id: " + num);
            }
            throw new IllegalArgumentException("CaptureId is null.");
        }
    }

    public void close() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            for (ImageProxy imageProxy : this.mOwnedImageProxies) {
                imageProxy.close();
            }
            this.mOwnedImageProxies.clear();
            this.mFutureResults.clear();
            this.mCompleters.clear();
            this.mClosed = true;
        }
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    @NonNull
    public List<Integer> getCaptureIds() {
        return Collections.unmodifiableList(this.mCaptureIdList);
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    @NonNull
    public a<ImageProxy> getImageProxy(int i2) {
        a<ImageProxy> aVar;
        synchronized (this.mLock) {
            if (!this.mClosed) {
                aVar = this.mFutureResults.get(i2);
                if (aVar == null) {
                    throw new IllegalArgumentException("ImageProxyBundle does not contain this id: " + i2);
                }
            } else {
                throw new IllegalStateException("ImageProxyBundle already closed.");
            }
        }
        return aVar;
    }

    public void reset() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            for (ImageProxy imageProxy : this.mOwnedImageProxies) {
                imageProxy.close();
            }
            this.mOwnedImageProxies.clear();
            this.mFutureResults.clear();
            this.mCompleters.clear();
            setup();
        }
    }
}
