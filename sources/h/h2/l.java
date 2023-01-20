package h.h2;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.FileWalkDirection;
import kotlin.io.FilesKt__FileReadWriteKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0007"}, d2 = {"walk", "Lkotlin/io/FileTreeWalk;", "Ljava/io/File;", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "Lkotlin/io/FileWalkDirection;", "walkBottomUp", "walkTopDown", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/io/FilesKt")
/* loaded from: classes3.dex */
public class l extends FilesKt__FileReadWriteKt {
    @k.e.a.d
    public static final h J(@k.e.a.d File file, @k.e.a.d FileWalkDirection fileWalkDirection) {
        return new h(file, fileWalkDirection);
    }

    public static /* synthetic */ h K(File file, FileWalkDirection fileWalkDirection, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        return J(file, fileWalkDirection);
    }

    @k.e.a.d
    public static final h L(@k.e.a.d File file) {
        return J(file, FileWalkDirection.BOTTOM_UP);
    }

    @k.e.a.d
    public static final h M(@k.e.a.d File file) {
        return J(file, FileWalkDirection.TOP_DOWN);
    }
}
