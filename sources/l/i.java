package l;

import j.o0;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import l.e;
import l.i;
import okhttp3.Request;

/* loaded from: classes4.dex */
public final class i extends e.a {
    @Nullable
    private final Executor a;

    /* loaded from: classes4.dex */
    public class a implements e<Object, d<?>> {
        public final /* synthetic */ Type a;
        public final /* synthetic */ Executor b;

        public a(Type type, Executor executor) {
            this.a = type;
            this.b = executor;
        }

        @Override // l.e
        /* renamed from: a */
        public d<Object> adapt(d<Object> dVar) {
            Executor executor = this.b;
            return executor == null ? dVar : new b(executor, dVar);
        }

        @Override // l.e
        public Type responseType() {
            return this.a;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b<T> implements d<T> {
        public final Executor a;
        public final d<T> b;

        /* loaded from: classes4.dex */
        public class a implements f<T> {
            public final /* synthetic */ f a;

            public a(f fVar) {
                this.a = fVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: a */
            public /* synthetic */ void b(f fVar, Throwable th) {
                fVar.onFailure(b.this, th);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: c */
            public /* synthetic */ void d(f fVar, r rVar) {
                if (b.this.b.isCanceled()) {
                    fVar.onFailure(b.this, new IOException("Canceled"));
                } else {
                    fVar.onResponse(b.this, rVar);
                }
            }

            @Override // l.f
            public void onFailure(d<T> dVar, final Throwable th) {
                Executor executor = b.this.a;
                final f fVar = this.a;
                executor.execute(new Runnable() { // from class: l.a
                    {
                        i.b.a.this = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        i.b.a.this.b(fVar, th);
                    }
                });
            }

            @Override // l.f
            public void onResponse(d<T> dVar, final r<T> rVar) {
                Executor executor = b.this.a;
                final f fVar = this.a;
                executor.execute(new Runnable() { // from class: l.b
                    {
                        i.b.a.this = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        i.b.a.this.d(fVar, rVar);
                    }
                });
            }
        }

        public b(Executor executor, d<T> dVar) {
            this.a = executor;
            this.b = dVar;
        }

        @Override // l.d
        public void cancel() {
            this.b.cancel();
        }

        @Override // l.d
        public r<T> execute() throws IOException {
            return this.b.execute();
        }

        @Override // l.d
        public void i(f<T> fVar) {
            Objects.requireNonNull(fVar, "callback == null");
            this.b.i(new a(fVar));
        }

        @Override // l.d
        public boolean isCanceled() {
            return this.b.isCanceled();
        }

        @Override // l.d
        public boolean isExecuted() {
            return this.b.isExecuted();
        }

        @Override // l.d
        public Request request() {
            return this.b.request();
        }

        @Override // l.d
        public o0 timeout() {
            return this.b.timeout();
        }

        @Override // l.d
        public d<T> clone() {
            return new b(this.a, this.b.clone());
        }
    }

    public i(@Nullable Executor executor) {
        this.a = executor;
    }

    @Override // l.e.a
    @Nullable
    public e<?, ?> get(Type type, Annotation[] annotationArr, s sVar) {
        if (e.a.getRawType(type) != d.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(w.g(0, (ParameterizedType) type), w.l(annotationArr, u.class) ? null : this.a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
