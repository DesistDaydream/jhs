package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public class Quirks {
    @NonNull
    private final List<Quirk> mQuirks;

    public Quirks(@NonNull List<Quirk> list) {
        this.mQuirks = new ArrayList(list);
    }

    public boolean contains(@NonNull Class<? extends Quirk> cls) {
        for (Quirk quirk : this.mQuirks) {
            if (cls.isAssignableFrom(quirk.getClass())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public <T extends Quirk> T get(@NonNull Class<T> cls) {
        Iterator<Quirk> it = this.mQuirks.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }
}
