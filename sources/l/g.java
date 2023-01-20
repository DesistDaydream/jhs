package l;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import l.e;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.HttpException;

@IgnoreJRERequirement
/* loaded from: classes4.dex */
public final class g extends e.a {
    public static final e.a a = new g();

    @IgnoreJRERequirement
    /* loaded from: classes4.dex */
    public static final class a<R> implements e<R, CompletableFuture<R>> {
        private final Type a;

        @IgnoreJRERequirement
        /* renamed from: l.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0505a implements f<R> {
            private final CompletableFuture<R> a;

            public C0505a(CompletableFuture<R> completableFuture) {
                this.a = completableFuture;
            }

            @Override // l.f
            public void onFailure(d<R> dVar, Throwable th) {
                this.a.completeExceptionally(th);
            }

            @Override // l.f
            public void onResponse(d<R> dVar, r<R> rVar) {
                if (rVar.g()) {
                    this.a.complete(rVar.a());
                } else {
                    this.a.completeExceptionally(new HttpException(rVar));
                }
            }
        }

        public a(Type type) {
            this.a = type;
        }

        @Override // l.e
        /* renamed from: a */
        public CompletableFuture<R> adapt(d<R> dVar) {
            b bVar = new b(dVar);
            dVar.i(new C0505a(bVar));
            return bVar;
        }

        @Override // l.e
        public Type responseType() {
            return this.a;
        }
    }

    @IgnoreJRERequirement
    /* loaded from: classes4.dex */
    public static final class b<T> extends CompletableFuture<T> {
        private final d<?> a;

        public b(d<?> dVar) {
            this.a = dVar;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            if (z) {
                this.a.cancel();
            }
            return super.cancel(z);
        }
    }

    @IgnoreJRERequirement
    /* loaded from: classes4.dex */
    public static final class c<R> implements e<R, CompletableFuture<r<R>>> {
        private final Type a;

        @IgnoreJRERequirement
        /* loaded from: classes4.dex */
        public class a implements f<R> {
            private final CompletableFuture<r<R>> a;

            public a(CompletableFuture<r<R>> completableFuture) {
                this.a = completableFuture;
            }

            @Override // l.f
            public void onFailure(d<R> dVar, Throwable th) {
                this.a.completeExceptionally(th);
            }

            @Override // l.f
            public void onResponse(d<R> dVar, r<R> rVar) {
                this.a.complete(rVar);
            }
        }

        public c(Type type) {
            this.a = type;
        }

        @Override // l.e
        /* renamed from: a */
        public CompletableFuture<r<R>> adapt(d<R> dVar) {
            b bVar = new b(dVar);
            dVar.i(new a(bVar));
            return bVar;
        }

        @Override // l.e
        public Type responseType() {
            return this.a;
        }
    }

    @Override // l.e.a
    @Nullable
    public e<?, ?> get(Type type, Annotation[] annotationArr, s sVar) {
        if (e.a.getRawType(type) != CompletableFuture.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type parameterUpperBound = e.a.getParameterUpperBound(0, (ParameterizedType) type);
            if (e.a.getRawType(parameterUpperBound) != r.class) {
                return new a(parameterUpperBound);
            }
            if (parameterUpperBound instanceof ParameterizedType) {
                return new c(e.a.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }
}
