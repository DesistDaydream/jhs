package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import com.qiniu.android.collect.ReportItem;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.f;
import h.k2.u.a;
import h.k2.v.c0;
import h.p0;
import h.r0;
import i.b.b1;
import i.b.l2;
import i.b.n;
import i.b.o;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\n\u0010\t\u001a-\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\t\u001a5\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\r\u001a-\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\b\u0010\u000e\u001a-\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000e\u001a-\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u000e\u001a5\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0081Hø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0007\u001aC\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0081@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"R", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle$State;", "state", "Lkotlin/Function0;", ReportItem.LogTypeBlock, "withStateAtLeast", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lh/k2/u/a;Lh/e2/c;)Ljava/lang/Object;", "withCreated", "(Landroidx/lifecycle/Lifecycle;Lh/k2/u/a;Lh/e2/c;)Ljava/lang/Object;", "withStarted", "withResumed", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lh/k2/u/a;Lh/e2/c;)Ljava/lang/Object;", "(Landroidx/lifecycle/LifecycleOwner;Lh/k2/u/a;Lh/e2/c;)Ljava/lang/Object;", "withStateAtLeastUnchecked", "", "dispatchNeeded", "Lkotlinx/coroutines/CoroutineDispatcher;", "lifecycleDispatcher", "suspendWithStateAtLeastUnchecked", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;ZLkotlinx/coroutines/CoroutineDispatcher;Lh/k2/u/a;Lh/e2/c;)Ljava/lang/Object;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class WithLifecycleStateKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1, androidx.lifecycle.LifecycleObserver] */
    @p0
    @e
    public static final <R> Object suspendWithStateAtLeastUnchecked(@d final Lifecycle lifecycle, @d final Lifecycle.State state, final boolean z, @d final CoroutineDispatcher coroutineDispatcher, @d final a<? extends R> aVar, @d c<? super R> cVar) {
        final o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        oVar.G();
        final ?? r15 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@d LifecycleOwner lifecycleOwner, @d Lifecycle.Event event) {
                Object m106constructorimpl;
                if (event == Lifecycle.Event.upTo(state)) {
                    lifecycle.removeObserver(this);
                    n nVar = n.this;
                    a aVar2 = aVar;
                    try {
                        Result.a aVar3 = Result.Companion;
                        m106constructorimpl = Result.m106constructorimpl(aVar2.invoke());
                    } catch (Throwable th) {
                        Result.a aVar4 = Result.Companion;
                        m106constructorimpl = Result.m106constructorimpl(r0.a(th));
                    }
                    nVar.resumeWith(m106constructorimpl);
                } else if (event == Lifecycle.Event.ON_DESTROY) {
                    lifecycle.removeObserver(this);
                    n nVar2 = n.this;
                    LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
                    Result.a aVar5 = Result.Companion;
                    nVar2.resumeWith(Result.m106constructorimpl(r0.a(lifecycleDestroyedException)));
                }
            }
        };
        if (z) {
            coroutineDispatcher.dispatch(EmptyCoroutineContext.INSTANCE, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$2
                @Override // java.lang.Runnable
                public final void run() {
                    lifecycle.addObserver(WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1.this);
                }
            });
        } else {
            lifecycle.addObserver(r15);
        }
        oVar.p(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3(r15, lifecycle, state, aVar, z, coroutineDispatcher));
        Object B = oVar.B();
        if (B == b.h()) {
            f.c(cVar);
        }
        return B;
    }

    @e
    public static final <R> Object withCreated(@d Lifecycle lifecycle, @d a<? extends R> aVar, @d c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        l2 z0 = b1.e().z0();
        boolean isDispatchNeeded = z0.isDispatchNeeded(cVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    @e
    private static final Object withCreated$$forInline(@d Lifecycle lifecycle, @d a aVar, @d c cVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        l2 z0 = b1.e().z0();
        c0.e(3);
        c cVar2 = null;
        boolean isDispatchNeeded = z0.isDispatchNeeded(cVar2.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
        c0.e(0);
        Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, withLifecycleStateKt$withStateAtLeastUnchecked$2, cVar);
        c0.e(1);
        return suspendWithStateAtLeastUnchecked;
    }

    @e
    public static final <R> Object withResumed(@d Lifecycle lifecycle, @d a<? extends R> aVar, @d c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        l2 z0 = b1.e().z0();
        boolean isDispatchNeeded = z0.isDispatchNeeded(cVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    @e
    private static final Object withResumed$$forInline(@d Lifecycle lifecycle, @d a aVar, @d c cVar) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        l2 z0 = b1.e().z0();
        c0.e(3);
        c cVar2 = null;
        boolean isDispatchNeeded = z0.isDispatchNeeded(cVar2.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
        c0.e(0);
        Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, withLifecycleStateKt$withStateAtLeastUnchecked$2, cVar);
        c0.e(1);
        return suspendWithStateAtLeastUnchecked;
    }

    @e
    public static final <R> Object withStarted(@d Lifecycle lifecycle, @d a<? extends R> aVar, @d c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        l2 z0 = b1.e().z0();
        boolean isDispatchNeeded = z0.isDispatchNeeded(cVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    @e
    private static final Object withStarted$$forInline(@d Lifecycle lifecycle, @d a aVar, @d c cVar) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        l2 z0 = b1.e().z0();
        c0.e(3);
        c cVar2 = null;
        boolean isDispatchNeeded = z0.isDispatchNeeded(cVar2.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
        c0.e(0);
        Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, withLifecycleStateKt$withStateAtLeastUnchecked$2, cVar);
        c0.e(1);
        return suspendWithStateAtLeastUnchecked;
    }

    @e
    public static final <R> Object withStateAtLeast(@d Lifecycle lifecycle, @d Lifecycle.State state, @d a<? extends R> aVar, @d c<? super R> cVar) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            l2 z0 = b1.e().z0();
            boolean isDispatchNeeded = z0.isDispatchNeeded(cVar.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return aVar.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    @e
    private static final Object withStateAtLeast$$forInline(@d Lifecycle lifecycle, @d Lifecycle.State state, @d a aVar, @d c cVar) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            l2 z0 = b1.e().z0();
            c0.e(3);
            c cVar2 = null;
            boolean isDispatchNeeded = z0.isDispatchNeeded(cVar2.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return aVar.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
            c0.e(0);
            Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, withLifecycleStateKt$withStateAtLeastUnchecked$2, cVar);
            c0.e(1);
            return suspendWithStateAtLeastUnchecked;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    @p0
    @e
    public static final <R> Object withStateAtLeastUnchecked(@d Lifecycle lifecycle, @d Lifecycle.State state, @d a<? extends R> aVar, @d c<? super R> cVar) {
        l2 z0 = b1.e().z0();
        boolean isDispatchNeeded = z0.isDispatchNeeded(cVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    @p0
    @e
    private static final Object withStateAtLeastUnchecked$$forInline(@d Lifecycle lifecycle, @d Lifecycle.State state, @d a aVar, @d c cVar) {
        l2 z0 = b1.e().z0();
        c0.e(3);
        c cVar2 = null;
        boolean isDispatchNeeded = z0.isDispatchNeeded(cVar2.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
        c0.e(0);
        Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, withLifecycleStateKt$withStateAtLeastUnchecked$2, cVar);
        c0.e(1);
        return suspendWithStateAtLeastUnchecked;
    }

    @e
    public static final <R> Object withCreated(@d LifecycleOwner lifecycleOwner, @d a<? extends R> aVar, @d c<? super R> cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        l2 z0 = b1.e().z0();
        boolean isDispatchNeeded = z0.isDispatchNeeded(cVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    @e
    private static final Object withCreated$$forInline(@d LifecycleOwner lifecycleOwner, @d a aVar, @d c cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        l2 z0 = b1.e().z0();
        c0.e(3);
        c cVar2 = null;
        boolean isDispatchNeeded = z0.isDispatchNeeded(cVar2.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
        c0.e(0);
        Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, withLifecycleStateKt$withStateAtLeastUnchecked$2, cVar);
        c0.e(1);
        return suspendWithStateAtLeastUnchecked;
    }

    @e
    public static final <R> Object withResumed(@d LifecycleOwner lifecycleOwner, @d a<? extends R> aVar, @d c<? super R> cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        l2 z0 = b1.e().z0();
        boolean isDispatchNeeded = z0.isDispatchNeeded(cVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    @e
    private static final Object withResumed$$forInline(@d LifecycleOwner lifecycleOwner, @d a aVar, @d c cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        l2 z0 = b1.e().z0();
        c0.e(3);
        c cVar2 = null;
        boolean isDispatchNeeded = z0.isDispatchNeeded(cVar2.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
        c0.e(0);
        Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, withLifecycleStateKt$withStateAtLeastUnchecked$2, cVar);
        c0.e(1);
        return suspendWithStateAtLeastUnchecked;
    }

    @e
    public static final <R> Object withStarted(@d LifecycleOwner lifecycleOwner, @d a<? extends R> aVar, @d c<? super R> cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        l2 z0 = b1.e().z0();
        boolean isDispatchNeeded = z0.isDispatchNeeded(cVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    @e
    private static final Object withStarted$$forInline(@d LifecycleOwner lifecycleOwner, @d a aVar, @d c cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        l2 z0 = b1.e().z0();
        c0.e(3);
        c cVar2 = null;
        boolean isDispatchNeeded = z0.isDispatchNeeded(cVar2.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
        c0.e(0);
        Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, withLifecycleStateKt$withStateAtLeastUnchecked$2, cVar);
        c0.e(1);
        return suspendWithStateAtLeastUnchecked;
    }

    @e
    public static final <R> Object withStateAtLeast(@d LifecycleOwner lifecycleOwner, @d Lifecycle.State state, @d a<? extends R> aVar, @d c<? super R> cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            l2 z0 = b1.e().z0();
            boolean isDispatchNeeded = z0.isDispatchNeeded(cVar.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return aVar.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    @e
    private static final Object withStateAtLeast$$forInline(@d LifecycleOwner lifecycleOwner, @d Lifecycle.State state, @d a aVar, @d c cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            l2 z0 = b1.e().z0();
            c0.e(3);
            c cVar2 = null;
            boolean isDispatchNeeded = z0.isDispatchNeeded(cVar2.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return aVar.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
            c0.e(0);
            Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z0, withLifecycleStateKt$withStateAtLeastUnchecked$2, cVar);
            c0.e(1);
            return suspendWithStateAtLeastUnchecked;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }
}
