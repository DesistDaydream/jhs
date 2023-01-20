package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import e.j.c.a.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class DeferrableSurfaces {
    private DeferrableSurfaces() {
    }

    public static /* synthetic */ void a(a aVar, CallbackToFutureAdapter.Completer completer, long j2) {
        if (aVar.isDone()) {
            return;
        }
        completer.setException(new TimeoutException("Cannot complete surfaceList within " + j2));
        aVar.cancel(true);
    }

    public static /* synthetic */ void b(Executor executor, final a aVar, final CallbackToFutureAdapter.Completer completer, final long j2) {
        executor.execute(new Runnable() { // from class: c.b.b.b2.k
            @Override // java.lang.Runnable
            public final void run() {
                DeferrableSurfaces.a(e.j.c.a.a.a.this, completer, j2);
            }
        });
    }

    public static /* synthetic */ void c(a aVar) {
        aVar.cancel(true);
    }

    public static /* synthetic */ Object d(List list, ScheduledExecutorService scheduledExecutorService, final Executor executor, final long j2, final boolean z, final CallbackToFutureAdapter.Completer completer) throws Exception {
        final a successfulAsList = Futures.successfulAsList(list);
        final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable() { // from class: c.b.b.b2.m
            @Override // java.lang.Runnable
            public final void run() {
                DeferrableSurfaces.b(executor, successfulAsList, completer, j2);
            }
        }, j2, TimeUnit.MILLISECONDS);
        completer.addCancellationListener(new Runnable() { // from class: c.b.b.b2.j
            @Override // java.lang.Runnable
            public final void run() {
                DeferrableSurfaces.c(e.j.c.a.a.a.this);
            }
        }, executor);
        Futures.addCallback(successfulAsList, new FutureCallback<List<Surface>>() { // from class: androidx.camera.core.impl.DeferrableSurfaces.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                completer.set(Collections.unmodifiableList(Collections.emptyList()));
                schedule.cancel(true);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable List<Surface> list2) {
                ArrayList arrayList = new ArrayList(list2);
                if (z) {
                    arrayList.removeAll(Collections.singleton(null));
                }
                completer.set(arrayList);
                schedule.cancel(true);
            }
        }, executor);
        return "surfaceList";
    }

    public static void decrementAll(@NonNull List<DeferrableSurface> list) {
        for (DeferrableSurface deferrableSurface : list) {
            deferrableSurface.decrementUseCount();
        }
    }

    public static void incrementAll(@NonNull List<DeferrableSurface> list) throws DeferrableSurface.SurfaceClosedException {
        if (list.isEmpty()) {
            return;
        }
        int i2 = 0;
        do {
            try {
                list.get(i2).incrementUseCount();
                i2++;
            } catch (DeferrableSurface.SurfaceClosedException e2) {
                for (int i3 = i2 - 1; i3 >= 0; i3--) {
                    list.get(i3).decrementUseCount();
                }
                throw e2;
            }
        } while (i2 < list.size());
    }

    @NonNull
    public static a<List<Surface>> surfaceListWithTimeout(@NonNull Collection<DeferrableSurface> collection, final boolean z, final long j2, @NonNull final Executor executor, @NonNull final ScheduledExecutorService scheduledExecutorService) {
        final ArrayList arrayList = new ArrayList();
        for (DeferrableSurface deferrableSurface : collection) {
            arrayList.add(Futures.nonCancellationPropagating(deferrableSurface.getSurface()));
        }
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.b.b2.l
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return DeferrableSurfaces.d(arrayList, scheduledExecutorService, executor, j2, z, completer);
            }
        });
    }

    public static boolean tryIncrementAll(@NonNull List<DeferrableSurface> list) {
        try {
            incrementAll(list);
            return true;
        } catch (DeferrableSurface.SurfaceClosedException unused) {
            return false;
        }
    }
}
