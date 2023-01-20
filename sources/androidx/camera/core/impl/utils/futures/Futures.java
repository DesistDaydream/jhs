package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.utils.futures.ImmediateFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.xiaomi.mipush.sdk.Constants;
import e.j.c.a.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class Futures {
    private static final Function<?, ?> IDENTITY_FUNCTION = new Function<Object, Object>() { // from class: androidx.camera.core.impl.utils.futures.Futures.2
        @Override // androidx.arch.core.util.Function
        public Object apply(Object obj) {
            return obj;
        }
    };

    /* loaded from: classes.dex */
    public static final class CallbackListener<V> implements Runnable {
        public final FutureCallback<? super V> mCallback;
        public final Future<V> mFuture;

        public CallbackListener(Future<V> future, FutureCallback<? super V> futureCallback) {
            this.mFuture = future;
            this.mCallback = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mCallback.onSuccess(Futures.getDone(this.mFuture));
            } catch (Error e2) {
                e = e2;
                this.mCallback.onFailure(e);
            } catch (RuntimeException e3) {
                e = e3;
                this.mCallback.onFailure(e);
            } catch (ExecutionException e4) {
                this.mCallback.onFailure(e4.getCause());
            }
        }

        public String toString() {
            return CallbackListener.class.getSimpleName() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.mCallback;
        }
    }

    private Futures() {
    }

    public static /* synthetic */ Object a(a aVar, CallbackToFutureAdapter.Completer completer) throws Exception {
        propagateTransform(false, aVar, IDENTITY_FUNCTION, completer, CameraXExecutors.directExecutor());
        return "nonCancellationPropagating[" + aVar + "]";
    }

    public static <V> void addCallback(@NonNull a<V> aVar, @NonNull FutureCallback<? super V> futureCallback, @NonNull Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        aVar.addListener(new CallbackListener(aVar, futureCallback), executor);
    }

    @NonNull
    public static <V> a<List<V>> allAsList(@NonNull Collection<? extends a<? extends V>> collection) {
        return new ListFuture(new ArrayList(collection), true, CameraXExecutors.directExecutor());
    }

    @Nullable
    public static <V> V getDone(@NonNull Future<V> future) throws ExecutionException {
        boolean isDone = future.isDone();
        Preconditions.checkState(isDone, "Future was expected to be done, " + future);
        return (V) getUninterruptibly(future);
    }

    @Nullable
    public static <V> V getUninterruptibly(@NonNull Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    @NonNull
    public static <V> a<V> immediateFailedFuture(@NonNull Throwable th) {
        return new ImmediateFuture.ImmediateFailedFuture(th);
    }

    @NonNull
    public static <V> ScheduledFuture<V> immediateFailedScheduledFuture(@NonNull Throwable th) {
        return new ImmediateFuture.ImmediateFailedScheduledFuture(th);
    }

    @NonNull
    public static <V> a<V> immediateFuture(@Nullable V v) {
        if (v == null) {
            return ImmediateFuture.nullFuture();
        }
        return new ImmediateFuture.ImmediateSuccessfulFuture(v);
    }

    @NonNull
    public static <V> a<V> nonCancellationPropagating(@NonNull final a<V> aVar) {
        Preconditions.checkNotNull(aVar);
        return aVar.isDone() ? aVar : CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.b.b2.h0.a.a
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return Futures.a(e.j.c.a.a.a.this, completer);
            }
        });
    }

    public static <V> void propagate(@NonNull a<V> aVar, @NonNull CallbackToFutureAdapter.Completer<V> completer) {
        propagateTransform(aVar, IDENTITY_FUNCTION, completer, CameraXExecutors.directExecutor());
    }

    public static <I, O> void propagateTransform(@NonNull a<I> aVar, @NonNull Function<? super I, ? extends O> function, @NonNull CallbackToFutureAdapter.Completer<O> completer, @NonNull Executor executor) {
        propagateTransform(true, aVar, function, completer, executor);
    }

    @NonNull
    public static <V> a<List<V>> successfulAsList(@NonNull Collection<? extends a<? extends V>> collection) {
        return new ListFuture(new ArrayList(collection), false, CameraXExecutors.directExecutor());
    }

    @NonNull
    public static <I, O> a<O> transform(@NonNull a<I> aVar, @NonNull final Function<? super I, ? extends O> function, @NonNull Executor executor) {
        Preconditions.checkNotNull(function);
        return transformAsync(aVar, new AsyncFunction<I, O>() { // from class: androidx.camera.core.impl.utils.futures.Futures.1
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public a<O> apply(I i2) {
                return Futures.immediateFuture(function.apply(i2));
            }
        }, executor);
    }

    @NonNull
    public static <I, O> a<O> transformAsync(@NonNull a<I> aVar, @NonNull AsyncFunction<? super I, ? extends O> asyncFunction, @NonNull Executor executor) {
        ChainingListenableFuture chainingListenableFuture = new ChainingListenableFuture(asyncFunction, aVar);
        aVar.addListener(chainingListenableFuture, executor);
        return chainingListenableFuture;
    }

    public static <I, O> void propagateTransform(boolean z, @NonNull final a<I> aVar, @NonNull final Function<? super I, ? extends O> function, @NonNull final CallbackToFutureAdapter.Completer<O> completer, @NonNull Executor executor) {
        Preconditions.checkNotNull(aVar);
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(completer);
        Preconditions.checkNotNull(executor);
        addCallback(aVar, new FutureCallback<I>() { // from class: androidx.camera.core.impl.utils.futures.Futures.3
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                completer.setException(th);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable I i2) {
                try {
                    completer.set(function.apply(i2));
                } catch (Throwable th) {
                    completer.setException(th);
                }
            }
        }, executor);
        if (z) {
            completer.addCancellationListener(new Runnable() { // from class: androidx.camera.core.impl.utils.futures.Futures.4
                @Override // java.lang.Runnable
                public void run() {
                    aVar.cancel(true);
                }
            }, CameraXExecutors.directExecutor());
        }
    }
}
