package e.l.q.b.h;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.github.chrisbanes.photoview.PhotoView;
import com.jihuanshe.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class l extends RecyclerView.Adapter<c> {

    /* renamed from: e  reason: collision with root package name */
    public static List<PhotoView> f14162e = new ArrayList();
    public List<String> a;
    public View.OnClickListener b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnLongClickListener f14163c;

    /* renamed from: d  reason: collision with root package name */
    public b f14164d;

    /* loaded from: classes2.dex */
    public class a extends e.b.a.t.k.e<Bitmap> {
        public final /* synthetic */ c a;
        public final /* synthetic */ int b;

        public a(c cVar, int i2) {
            this.a = cVar;
            this.b = i2;
        }

        @Override // e.b.a.t.k.p
        public void onLoadCleared(@Nullable Drawable drawable) {
        }

        @Override // e.b.a.t.k.p
        public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable e.b.a.t.l.f fVar) {
            onResourceReady((Bitmap) obj, (e.b.a.t.l.f<? super Bitmap>) fVar);
        }

        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable e.b.a.t.l.f<? super Bitmap> fVar) {
            this.a.a.setImageBitmap(bitmap);
            l.this.f14164d.a(this.b, bitmap);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(int i2, Bitmap bitmap);
    }

    /* loaded from: classes2.dex */
    public static class c extends RecyclerView.ViewHolder {
        public PhotoView a;

        public c(@NonNull View view) {
            super(view);
            PhotoView photoView = (PhotoView) view.findViewById(R.id.thumb);
            this.a = photoView;
            l.f14162e.add(photoView);
        }
    }

    public l(List<String> list) {
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull c cVar, int i2) {
        cVar.a.setTag(Integer.valueOf(i2));
        e.b.a.c.E(cVar.a).m().k(this.a.get(i2)).j1(new a(cVar, i2));
        cVar.a.setOnClickListener(this.b);
        cVar.a.setOnLongClickListener(this.f14163c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: b */
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_preview, viewGroup, false);
        e.b.a.c.E(viewGroup).p().k("http://images.ylwx365.com/images/mini/73371620977260966.gif").m1((ImageView) inflate.findViewById(R.id.loading));
        return new c(inflate);
    }

    public void c() {
        for (PhotoView photoView : f14162e) {
            photoView.setScale(1.0f, true);
        }
    }

    public l d(b bVar) {
        this.f14164d = bVar;
        return this;
    }

    public l e(View.OnLongClickListener onLongClickListener) {
        this.f14163c = onLongClickListener;
        return this;
    }

    public l f(View.OnClickListener onClickListener) {
        this.b = onClickListener;
        return this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
