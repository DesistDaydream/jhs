package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiresApi(21)
/* loaded from: classes.dex */
public abstract class MultiValueSet<C> {
    private Set<C> mSet = new HashSet();

    public void addAll(@NonNull List<C> list) {
        this.mSet.addAll(list);
    }

    @NonNull
    /* renamed from: clone */
    public abstract MultiValueSet<C> m0clone();

    @NonNull
    public List<C> getAllItems() {
        return Collections.unmodifiableList(new ArrayList(this.mSet));
    }
}
