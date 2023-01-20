package e.t.r.a.m;

import com.baidu.mobads.sdk.internal.bc;
import e.b.a.p.f;
import e.b.a.p.l.g;
import e.b.a.p.l.n;
import e.b.a.p.l.o;
import e.b.a.p.l.r;
import java.io.InputStream;
import k.e.a.e;
import kotlin.Metadata;
import okhttp3.Call;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/vector/network/image/https/OkHttpUrlLoader;", "Lcom/bumptech/glide/load/model/ModelLoader;", "Lcom/bumptech/glide/load/model/GlideUrl;", "Ljava/io/InputStream;", "client", "Lokhttp3/Call$Factory;", "(Lokhttp3/Call$Factory;)V", "buildLoadData", "Lcom/bumptech/glide/load/model/ModelLoader$LoadData;", bc.f1474i, "width", "", "height", "options", "Lcom/bumptech/glide/load/Options;", "handles", "", "Factory", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class c implements n<g, InputStream> {
    @e
    private Call.Factory a;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/vector/network/image/https/OkHttpUrlLoader$Factory;", "Lcom/bumptech/glide/load/model/ModelLoaderFactory;", "Lcom/bumptech/glide/load/model/GlideUrl;", "Ljava/io/InputStream;", "client", "Lokhttp3/Call$Factory;", "(Lokhttp3/Call$Factory;)V", "build", "Lcom/bumptech/glide/load/model/ModelLoader;", "multiFactory", "Lcom/bumptech/glide/load/model/MultiModelLoaderFactory;", "teardown", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a implements o<g, InputStream> {
        @k.e.a.d
        private final Call.Factory a;

        public a(@k.e.a.d Call.Factory factory) {
            this.a = factory;
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @k.e.a.d
        public n<g, InputStream> c(@k.e.a.d r rVar) {
            return new c(this.a);
        }
    }

    public c(@k.e.a.d Call.Factory factory) {
        this.a = factory;
    }

    @Override // e.b.a.p.l.n
    @e
    /* renamed from: c */
    public n.a<InputStream> b(@k.e.a.d g gVar, int i2, int i3, @k.e.a.d f fVar) {
        return new n.a<>(gVar, new b(this.a, gVar));
    }

    @Override // e.b.a.p.l.n
    /* renamed from: d */
    public boolean a(@k.e.a.d g gVar) {
        return true;
    }
}
