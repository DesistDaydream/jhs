package com.jihuanshe.base.ext;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.vector.design.ui.activity.SimpleActivityEx;
import com.vector.design.ui.frag.SimpleFragEx;
import com.vector.view.scrollable.ListView;
import e.g.d.a;
import e.l.h.i.b;
import e.l.h.i.e;
import e.n.f;
import e.t.l.d0.h;
import e.t.v.j.g;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aP\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0007\"\u0016\b\u0001\u0010\u0006*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\t\u0018\u00010\b*\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e\u001aJ\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0007\"\u0010\b\u0001\u0010\u0006*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\t*\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e\u001a*\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002\u001a:\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0006\u0010\u0012\u001a\u00020\u00132\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u001a$\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0006\u0010\u001b\u001a\u00020\u001c\u001a.\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e\u001a.\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e\u001a:\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\"\u001a\u00020\u000eH\u0002\u001a$\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0006\u0010\u001b\u001a\u00020\u001c\u001a$\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0006\u0010 \u001a\u00020!\u001a$\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0006\u0010\u001d\u001a\u00020$\u001a\u001c\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u0005\u001a8\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0006\u0010 \u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e\u001a.\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0006\u0010\u001d\u001a\u00020$2\b\b\u0002\u0010\u001f\u001a\u00020\u000e\u001a$\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0006\u0010 \u001a\u00020$\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"NET_ERROR_CODE", "", "TOKEN_ERROR_CODE", "TOKEN_EXPIRE_CODE", "handleEncodeListWrapper", "Lcom/eth/binder/Binder;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LONGITUDE_EAST, "Lcom/jihuanshe/base/model/EncodeData;", "Lcom/jihuanshe/base/model/ListWrapper;", "live", "Lcom/live/Live;", "", "refresh", "", "handleListWrapper", "withAllListState", "", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "hostView", "Landroid/view/View;", "withListState", "view", "Lcom/vector/view/scrollable/ScrollableView;", "isLoadMore", "withLoading", "context", "Landroid/content/Context;", "frag", "Landroidx/fragment/app/Fragment;", "noList", "act", "Landroidx/fragment/app/FragmentActivity;", "isCanCancel", "withLoadingAndToast", "Lcom/vector/design/ui/frag/SimpleFragEx;", "withToast", "withViewState", "Lcom/vector/design/ui/activity/SimpleActivityEx;", "needToast", "withViewStateNoError", "lib-base_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class BinderKt {
    @d
    public static final String a = "401";
    @d
    public static final String b = "112";
    @d

    /* renamed from: c */
    public static final String f3779c = "400";

    @d
    public static final <E, T extends b<e<E>>> a<T> a(@d a<T> aVar, @d f<List<E>> fVar, boolean z) {
        a.j(aVar, null, new BinderKt$handleEncodeListWrapper$1$1(z, fVar), 1, null);
        return aVar;
    }

    @d
    public static final <E, T extends e<E>> a<T> b(@d a<T> aVar, @d f<List<E>> fVar, boolean z) {
        a.j(aVar, null, new BinderKt$handleListWrapper$1$1(z, fVar), 1, null);
        return aVar;
    }

    private static final <T> void c(a<T> aVar, LifecycleOwner lifecycleOwner, View view) {
        ArrayList<ListView> arrayList;
        if (view == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.addLast(view);
            while (!arrayDeque.isEmpty()) {
                View view2 = (View) arrayDeque.getFirst();
                if (view2 instanceof ViewGroup) {
                    h.a((ViewGroup) view2, new BinderKt$withAllListState$$inlined$findAll$1(arrayDeque));
                }
                if (view2 instanceof ListView) {
                    arrayList2.add(view2);
                }
                arrayDeque.pollFirst();
            }
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            return;
        }
        for (ListView listView : arrayList) {
            e(aVar, lifecycleOwner, listView, false, 4, null);
        }
    }

    @d
    public static final <T> a<T> d(@d a<T> aVar, @d LifecycleOwner lifecycleOwner, @d g<?> gVar, boolean z) {
        aVar.k(lifecycleOwner, new BinderKt$withListState$1$1(gVar));
        aVar.p(lifecycleOwner, new BinderKt$withListState$1$2(gVar));
        aVar.n(lifecycleOwner, new BinderKt$withListState$1$3(gVar, z));
        return aVar;
    }

    public static /* synthetic */ a e(a aVar, LifecycleOwner lifecycleOwner, g gVar, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return d(aVar, lifecycleOwner, gVar, z);
    }

    @d
    public static final <T> a<T> f(@d a<T> aVar, @d Context context) {
        if (context instanceof FragmentActivity) {
            k(aVar, (FragmentActivity) context, false, 2, null);
        }
        return aVar;
    }

    @d
    public static final <T> a<T> g(@d a<T> aVar, @d Fragment fragment, boolean z) {
        if (!z) {
            if (fragment instanceof e.t.k.a.a) {
                c(aVar, fragment, ((e.t.k.a.a) fragment).l());
            }
            new e.t.l.h();
        }
        l(aVar, fragment, fragment.getActivity(), false, 4, null);
        return aVar;
    }

    @d
    public static final <T> a<T> h(@d a<T> aVar, @d FragmentActivity fragmentActivity, boolean z) {
        if (fragmentActivity instanceof e.t.k.a.a) {
            c(aVar, fragmentActivity, ((e.t.k.a.a) fragmentActivity).l());
        }
        new e.t.l.h();
        i(aVar, fragmentActivity, fragmentActivity, z);
        return aVar;
    }

    private static final <T> a<T> i(a<T> aVar, LifecycleOwner lifecycleOwner, Context context, boolean z) {
        if (context != null) {
            e.t.k.a.f.h hVar = new e.t.k.a.f.h(context, z);
            hVar.J(new BinderKt$withLoading$4$1(aVar));
            aVar.p(lifecycleOwner, new BinderKt$withLoading$4$2(hVar));
        }
        return aVar;
    }

    public static /* synthetic */ a j(a aVar, Fragment fragment, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return g(aVar, fragment, z);
    }

    public static /* synthetic */ a k(a aVar, FragmentActivity fragmentActivity, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return h(aVar, fragmentActivity, z);
    }

    public static /* synthetic */ a l(a aVar, LifecycleOwner lifecycleOwner, Context context, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        return i(aVar, lifecycleOwner, context, z);
    }

    @d
    public static final <T> a<T> m(@d a<T> aVar, @d Context context) {
        return p(f(aVar, context));
    }

    @d
    public static final <T> a<T> n(@d a<T> aVar, @d FragmentActivity fragmentActivity) {
        return p(k(aVar, fragmentActivity, false, 2, null));
    }

    @d
    public static final <T> a<T> o(@d a<T> aVar, @d SimpleFragEx simpleFragEx) {
        return p(j(aVar, simpleFragEx, false, 2, null));
    }

    @d
    public static final <T> a<T> p(@d a<T> aVar) {
        a.o(aVar, null, new BinderKt$withToast$1$1(aVar), 1, null);
        return aVar;
    }

    @d
    public static final <T> a<T> q(@d a<T> aVar, @d SimpleActivityEx simpleActivityEx, boolean z, boolean z2) {
        aVar.p(simpleActivityEx, new BinderKt$withViewState$1$1(simpleActivityEx));
        if (z) {
            p(aVar);
        }
        if (!z2) {
            c(aVar, simpleActivityEx, simpleActivityEx.l());
        }
        return aVar;
    }

    @d
    public static final <T> a<T> r(@d a<T> aVar, @d SimpleFragEx simpleFragEx, boolean z) {
        aVar.p(simpleFragEx, new BinderKt$withViewState$2$1(simpleFragEx));
        p(aVar);
        if (!z) {
            c(aVar, simpleFragEx, simpleFragEx.l());
        }
        return aVar;
    }

    public static /* synthetic */ a s(a aVar, SimpleActivityEx simpleActivityEx, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return q(aVar, simpleActivityEx, z, z2);
    }

    public static /* synthetic */ a t(a aVar, SimpleFragEx simpleFragEx, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return r(aVar, simpleFragEx, z);
    }

    @d
    public static final <T> a<T> u(@d a<T> aVar, @d SimpleFragEx simpleFragEx) {
        aVar.p(simpleFragEx, new BinderKt$withViewStateNoError$1$1(simpleFragEx));
        c(aVar, simpleFragEx, simpleFragEx.l());
        return aVar;
    }
}
