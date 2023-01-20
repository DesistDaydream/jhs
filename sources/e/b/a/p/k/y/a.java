package e.b.a.p.k.y;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* loaded from: classes.dex */
public interface a {

    /* renamed from: e.b.a.p.k.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0310a {
        public static final int a = 262144000;
        public static final String b = "image_manager_disk_cache";

        @Nullable
        a build();
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(@NonNull File file);
    }

    void a(e.b.a.p.c cVar, b bVar);

    @Nullable
    File b(e.b.a.p.c cVar);

    void clear();

    void delete(e.b.a.p.c cVar);
}
