package kotlin.io;

import com.huawei.hms.push.e;
import h.k2.u.p;
import h.t1;
import java.io.File;
import java.io.IOException;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "f", "Ljava/io/File;", e.a, "Ljava/io/IOException;", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class FilesKt__UtilsKt$copyRecursively$2 extends Lambda implements p<File, IOException, t1> {
    public final /* synthetic */ p $onError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesKt__UtilsKt$copyRecursively$2(p pVar) {
        super(2);
        this.$onError = pVar;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(File file, IOException iOException) {
        invoke2(file, iOException);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d File file, @d IOException iOException) {
        if (((OnErrorAction) this.$onError.invoke(file, iOException)) == OnErrorAction.TERMINATE) {
            throw new TerminateException(file);
        }
    }
}
