package androidx.databinding;

import androidx.annotation.NonNull;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.Observable;

/* loaded from: classes.dex */
public class PropertyChangeRegistry extends CallbackRegistry<Observable.OnPropertyChangedCallback, Observable, Void> {
    private static final CallbackRegistry.NotifierCallback<Observable.OnPropertyChangedCallback, Observable, Void> NOTIFIER_CALLBACK = new CallbackRegistry.NotifierCallback<Observable.OnPropertyChangedCallback, Observable, Void>() { // from class: androidx.databinding.PropertyChangeRegistry.1
        @Override // androidx.databinding.CallbackRegistry.NotifierCallback
        public void onNotifyCallback(Observable.OnPropertyChangedCallback onPropertyChangedCallback, Observable observable, int i2, Void r4) {
            onPropertyChangedCallback.onPropertyChanged(observable, i2);
        }
    };

    public PropertyChangeRegistry() {
        super(NOTIFIER_CALLBACK);
    }

    public void notifyChange(@NonNull Observable observable, int i2) {
        notifyCallbacks(observable, i2, null);
    }
}
