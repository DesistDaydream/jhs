package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class j0 {
    public static <T extends Comparable<? super T>> void a(List<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        try {
            Collections.sort(list);
        } catch (Throwable unused) {
            List asList = Arrays.asList(list.toArray());
            Collections.sort(asList);
            list.clear();
            list.addAll(asList);
        }
    }

    public static <T> void a(List<T> list, @NonNull Comparator<T> comparator) {
        if (list == null || list.size() <= 1) {
            return;
        }
        try {
            Collections.sort(list, comparator);
        } catch (Throwable unused) {
            List asList = Arrays.asList(list.toArray());
            Collections.sort(asList, comparator);
            list.clear();
            list.addAll(asList);
        }
    }
}
