package okhttp3.internal.concurrent;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.qiniu.android.collect.ReportItem;
import h.k2.u.a;
import h.k2.v.c0;
import h.k2.v.s0;
import h.u2.e;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import k.e.a.d;
import kotlin.Metadata;
import okhttp3.internal.http2.Http2Connection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\u001a1\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0080\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a7\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0080\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0015\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/concurrent/Task;", "task", "Lokhttp3/internal/concurrent/TaskQueue;", "queue", "Lkotlin/Function0;", "", "messageBlock", "Lh/t1;", "taskLog", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lh/k2/u/a;)V", ExifInterface.GPS_DIRECTION_TRUE, ReportItem.LogTypeBlock, "logElapsed", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lh/k2/u/a;)Ljava/lang/Object;", "message", "log", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Ljava/lang/String;)V", "", NotificationStyle.NOTIFICATION_STYLE, "formatDuration", "(J)Ljava/lang/String;", "okhttp"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class TaskLoggerKt {
    public static final /* synthetic */ void access$log(Task task, TaskQueue taskQueue, String str) {
        log(task, taskQueue, str);
    }

    @d
    public static final String formatDuration(long j2) {
        String str;
        if (j2 <= -999500000) {
            str = ((j2 - 500000000) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        } else if (j2 <= -999500) {
            str = ((j2 - 500000) / ((long) e.a)) + " ms";
        } else if (j2 <= 0) {
            str = ((j2 - 500) / 1000) + " µs";
        } else if (j2 < 999500) {
            str = ((j2 + 500) / 1000) + " µs";
        } else if (j2 < 999500000) {
            str = ((j2 + 500000) / ((long) e.a)) + " ms";
        } else {
            str = ((j2 + 500000000) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        }
        s0 s0Var = s0.a;
        return String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(Task task, TaskQueue taskQueue, String str) {
        Logger logger = TaskRunner.Companion.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(taskQueue.getName$okhttp());
        sb.append(' ');
        s0 s0Var = s0.a;
        sb.append(String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)));
        sb.append(": ");
        sb.append(task.getName());
        logger.fine(sb.toString());
    }

    public static final <T> T logElapsed(@d Task task, @d TaskQueue taskQueue, @d a<? extends T> aVar) {
        long j2;
        boolean isLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (isLoggable) {
            j2 = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(task, taskQueue, "starting");
        } else {
            j2 = -1;
        }
        try {
            T invoke = aVar.invoke();
            c0.d(1);
            if (isLoggable) {
                log(task, taskQueue, "finished run in " + formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - j2));
            }
            c0.c(1);
            return invoke;
        } catch (Throwable th) {
            c0.d(1);
            if (isLoggable) {
                log(task, taskQueue, "failed a run in " + formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - j2));
            }
            c0.c(1);
            throw th;
        }
    }

    public static final void taskLog(@d Task task, @d TaskQueue taskQueue, @d a<String> aVar) {
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            log(task, taskQueue, aVar.invoke());
        }
    }
}
