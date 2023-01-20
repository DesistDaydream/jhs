package androidx.databinding;

/* loaded from: classes.dex */
public interface Observable {

    /* loaded from: classes.dex */
    public static abstract class OnPropertyChangedCallback {
        public abstract void onPropertyChanged(Observable observable, int i2);
    }

    void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback);

    void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback);
}
