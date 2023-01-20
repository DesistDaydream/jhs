package e.l.i;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.databinding.BindingAdapter;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.CardImageView;
import java.util.List;

/* loaded from: classes2.dex */
public final class e {
    @k.e.a.d
    public static final e a = new e();
    @k.e.a.d
    private static final String b = "android:civ_placeholder";
    @k.e.a.d

    /* renamed from: c */
    private static final String f12153c = "android:civ_url";
    @k.e.a.d

    /* renamed from: d */
    private static final String f12154d = "android:civ_uri";
    @k.e.a.d

    /* renamed from: e */
    private static final String f12155e = "android:civ_game";
    @k.e.a.d

    /* renamed from: f */
    private static final String f12156f = "android:civ_interceptors";
    @k.e.a.d

    /* renamed from: g */
    private static final String f12157g = "android:civ_signature";
    @k.e.a.d

    /* renamed from: h */
    private static final String f12158h = "android:civ_error";

    private e() {
    }

    public static /* synthetic */ void a(CardImageView cardImageView) {
        c(cardImageView);
    }

    @BindingAdapter(requireAll = false, value = {f12153c, f12154d, b, f12155e, f12156f, f12157g, f12158h})
    @h.k2.k
    public static final void b(@k.e.a.d final CardImageView cardImageView, @k.e.a.e String str, @k.e.a.e Uri uri, @k.e.a.e Drawable drawable, @k.e.a.e Game game, @k.e.a.e List<? extends e.t.r.a.n.c> list, @k.e.a.e String str2, @k.e.a.e Drawable drawable2) {
        if (game != null) {
            cardImageView.setGame(game);
        }
        cardImageView.u(drawable2);
        if (drawable != null) {
            cardImageView.o(drawable);
        }
        cardImageView.q();
        if (list != null) {
            for (e.t.r.a.n.c cVar : list) {
                cardImageView.k(cVar);
            }
        }
        if (uri != null) {
            cardImageView.n(uri);
        } else if (str != null) {
            cardImageView.url(str);
        }
        cardImageView.m(str2);
        cardImageView.post(new Runnable() { // from class: e.l.i.a
            @Override // java.lang.Runnable
            public final void run() {
                e.a(cardImageView);
            }
        });
    }

    public static final void c(CardImageView cardImageView) {
        Context context = cardImageView.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            cardImageView.e();
            return;
        }
        cardImageView.e();
    }
}
