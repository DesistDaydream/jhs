package okhttp3.internal.concurrent;

import h.k2.u.a;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$schedule$2", "Lokhttp3/internal/concurrent/Task;", "", "runOnce", "()J", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class TaskQueue$schedule$2 extends Task {
    public final /* synthetic */ a $block;
    public final /* synthetic */ String $name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue$schedule$2(a aVar, String str, String str2) {
        super(str2, false, 2, null);
        this.$block = aVar;
        this.$name = str;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        return ((Number) this.$block.invoke()).longValue();
    }
}
