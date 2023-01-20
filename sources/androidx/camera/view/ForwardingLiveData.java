package androidx.camera.view;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.view.ForwardingLiveData;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class ForwardingLiveData<T> extends MediatorLiveData<T> {
    private LiveData<T> mLiveDataSource;

    @Override // androidx.lifecycle.LiveData
    public T getValue() {
        LiveData<T> liveData = this.mLiveDataSource;
        if (liveData == null) {
            return null;
        }
        return liveData.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSource(@NonNull LiveData<T> liveData) {
        LiveData liveData2 = (LiveData<T>) this.mLiveDataSource;
        if (liveData2 != null) {
            super.removeSource(liveData2);
        }
        this.mLiveDataSource = liveData;
        super.addSource(liveData, new Observer() { // from class: c.b.d.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ForwardingLiveData.this.setValue(obj);
            }
        });
    }
}
