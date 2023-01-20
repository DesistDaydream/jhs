package com.jihuanshe.utils;

import androidx.fragment.app.FragmentManager;
import com.jihuanshe.R;
import com.jihuanshe.model.GlobalConfig;
import com.jihuanshe.ui.dialog.NoticeDialog;
import com.vector.util.Res;
import e.l.m.c;
import e.l.r.o0;
import e.n.i;
import e.t.u.t;
import h.k2.u.a;
import h.t1;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class UpdateManager {
    @d
    public static final UpdateManager a = new UpdateManager();

    private UpdateManager() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean d(UpdateManager updateManager, FragmentManager fragmentManager, a aVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return updateManager.c(fragmentManager, aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x006f, code lost:
        if ((r0 == null ? false : h.k2.v.f0.g(r0.getUpdateType(), 2)) != false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x002b A[Catch: all -> 0x0079, TryCatch #0 {all -> 0x0079, blocks: (B:49:0x0008, B:56:0x0021, B:58:0x002b, B:66:0x0040, B:73:0x0054, B:75:0x005a, B:78:0x0062, B:69:0x0049, B:72:0x0050, B:61:0x0033, B:64:0x003a, B:81:0x0073, B:52:0x0016, B:55:0x001d), top: B:86:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0040 A[Catch: all -> 0x0079, TryCatch #0 {all -> 0x0079, blocks: (B:49:0x0008, B:56:0x0021, B:58:0x002b, B:66:0x0040, B:73:0x0054, B:75:0x005a, B:78:0x0062, B:69:0x0049, B:72:0x0050, B:61:0x0033, B:64:0x003a, B:81:0x0073, B:52:0x0016, B:55:0x001d), top: B:86:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a() {
        /*
            r9 = this;
            boolean r0 = r9.f()
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            kotlin.Result$a r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L79
            e.l.r.o0 r0 = e.l.r.o0.f14291c     // Catch: java.lang.Throwable -> L79
            com.jihuanshe.model.GlobalConfig r2 = r0.u()     // Catch: java.lang.Throwable -> L79
            r3 = 0
            if (r2 != 0) goto L16
        L14:
            r5 = r3
            goto L21
        L16:
            java.lang.String r2 = r2.getNewestVersion()     // Catch: java.lang.Throwable -> L79
            if (r2 != 0) goto L1d
            goto L14
        L1d:
            long r5 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> L79
        L21:
            e.t.u.t r2 = e.t.u.t.a     // Catch: java.lang.Throwable -> L79
            long r7 = r2.d()     // Catch: java.lang.Throwable -> L79
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L73
            com.jihuanshe.model.GlobalConfig r2 = r0.u()     // Catch: java.lang.Throwable -> L79
            if (r2 != 0) goto L33
        L31:
            r2 = 0
            goto L3e
        L33:
            java.lang.Integer r2 = r2.getUpdateType()     // Catch: java.lang.Throwable -> L79
            if (r2 != 0) goto L3a
            goto L31
        L3a:
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L79
        L3e:
            if (r2 <= 0) goto L73
            e.l.m.c r2 = e.l.m.c.f14093c     // Catch: java.lang.Throwable -> L79
            com.jihuanshe.model.GlobalConfig r5 = r0.u()     // Catch: java.lang.Throwable -> L79
            if (r5 != 0) goto L49
            goto L54
        L49:
            java.lang.String r5 = r5.getNewestVersion()     // Catch: java.lang.Throwable -> L79
            if (r5 != 0) goto L50
            goto L54
        L50:
            long r3 = java.lang.Long.parseLong(r5)     // Catch: java.lang.Throwable -> L79
        L54:
            boolean r2 = r2.t(r3)     // Catch: java.lang.Throwable -> L79
            if (r2 == 0) goto L71
            com.jihuanshe.model.GlobalConfig r0 = r0.u()     // Catch: java.lang.Throwable -> L79
            if (r0 != 0) goto L62
            r0 = 0
            goto L6f
        L62:
            java.lang.Integer r0 = r0.getUpdateType()     // Catch: java.lang.Throwable -> L79
            r2 = 2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L79
            boolean r0 = h.k2.v.f0.g(r0, r2)     // Catch: java.lang.Throwable -> L79
        L6f:
            if (r0 == 0) goto L73
        L71:
            r0 = 1
            r1 = 1
        L73:
            h.t1 r0 = h.t1.a     // Catch: java.lang.Throwable -> L79
            kotlin.Result.m106constructorimpl(r0)     // Catch: java.lang.Throwable -> L79
            goto L83
        L79:
            r0 = move-exception
            kotlin.Result$a r2 = kotlin.Result.Companion
            java.lang.Object r0 = h.r0.a(r0)
            kotlin.Result.m106constructorimpl(r0)
        L83:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.utils.UpdateManager.a():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0038 A[Catch: all -> 0x0056, TryCatch #0 {all -> 0x0056, blocks: (B:36:0x0001, B:43:0x0019, B:45:0x0023, B:53:0x0038, B:56:0x0040, B:48:0x002b, B:51:0x0032, B:59:0x0050, B:39:0x000e, B:42:0x0015), top: B:64:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b() {
        /*
            r7 = this;
            r0 = 0
            kotlin.Result$a r1 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L56
            e.l.r.o0 r1 = e.l.r.o0.f14291c     // Catch: java.lang.Throwable -> L56
            com.jihuanshe.model.GlobalConfig r2 = r1.u()     // Catch: java.lang.Throwable -> L56
            r3 = 0
            if (r2 != 0) goto Le
            goto L19
        Le:
            java.lang.String r2 = r2.getNewestVersion()     // Catch: java.lang.Throwable -> L56
            if (r2 != 0) goto L15
            goto L19
        L15:
            long r3 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> L56
        L19:
            e.t.u.t r2 = e.t.u.t.a     // Catch: java.lang.Throwable -> L56
            long r5 = r2.d()     // Catch: java.lang.Throwable -> L56
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 <= 0) goto L50
            com.jihuanshe.model.GlobalConfig r2 = r1.u()     // Catch: java.lang.Throwable -> L56
            if (r2 != 0) goto L2b
        L29:
            r2 = 0
            goto L36
        L2b:
            java.lang.Integer r2 = r2.getUpdateType()     // Catch: java.lang.Throwable -> L56
            if (r2 != 0) goto L32
            goto L29
        L32:
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L56
        L36:
            if (r2 <= 0) goto L50
            com.jihuanshe.model.GlobalConfig r1 = r1.u()     // Catch: java.lang.Throwable -> L56
            if (r1 != 0) goto L40
            r1 = 0
            goto L4d
        L40:
            java.lang.Integer r1 = r1.getUpdateType()     // Catch: java.lang.Throwable -> L56
            r2 = 2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L56
            boolean r1 = h.k2.v.f0.g(r1, r2)     // Catch: java.lang.Throwable -> L56
        L4d:
            if (r1 == 0) goto L50
            r0 = 1
        L50:
            h.t1 r1 = h.t1.a     // Catch: java.lang.Throwable -> L56
            kotlin.Result.m106constructorimpl(r1)     // Catch: java.lang.Throwable -> L56
            goto L60
        L56:
            r1 = move-exception
            kotlin.Result$a r2 = kotlin.Result.Companion
            java.lang.Object r1 = h.r0.a(r1)
            kotlin.Result.m106constructorimpl(r1)
        L60:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.utils.UpdateManager.b():boolean");
    }

    public final boolean c(@d FragmentManager fragmentManager, @e a<t1> aVar) {
        GlobalConfig u = o0.f14291c.u();
        if (u == null) {
            return false;
        }
        c cVar = c.f14093c;
        long r = cVar.r();
        t tVar = t.a;
        if (r < tVar.d()) {
            cVar.w(tVar.d());
            Integer showUpdateContentType = u.getShowUpdateContentType();
            if ((showUpdateContentType == null ? 0 : showUpdateContentType.intValue()) > 0) {
                NoticeDialog noticeDialog = new NoticeDialog();
                noticeDialog.I().setValue(Res.w(Res.a, R.string.update_notice, null, 2, null));
                noticeDialog.B().setValue(u.getUpdateContent());
                noticeDialog.D().setValue(Boolean.TRUE);
                noticeDialog.setCancelable(false);
                noticeDialog.z(aVar);
                noticeDialog.show(fragmentManager, "update_content");
                return true;
            }
        }
        return false;
    }

    public final boolean e(@d FragmentManager fragmentManager, @d a<t1> aVar) {
        String newestVersion;
        o0 o0Var = o0.f14291c;
        GlobalConfig u = o0Var.u();
        if (u != null && a()) {
            c cVar = c.f14093c;
            GlobalConfig u2 = o0Var.u();
            long j2 = 0;
            if (u2 != null && (newestVersion = u2.getNewestVersion()) != null) {
                j2 = Long.parseLong(newestVersion);
            }
            cVar.z(j2);
            NoticeDialog noticeDialog = new NoticeDialog();
            noticeDialog.I().setValue(Res.w(Res.a, R.string.update_has_new_version, null, 2, null));
            noticeDialog.B().setValue(u.getUpdateRequestContent());
            noticeDialog.K(e.t.j.h.d.a.a(UpdateManager$showUpdateDialog$1$1.INSTANCE));
            i C = noticeDialog.C();
            Integer updateType = u.getUpdateType();
            C.setValue(Boolean.valueOf(updateType != null && updateType.intValue() == 2));
            noticeDialog.setCancelable(false);
            noticeDialog.z(aVar);
            noticeDialog.show(fragmentManager, "update");
            return true;
        }
        return false;
    }

    public final boolean f() {
        String newestVersion;
        GlobalConfig u = o0.f14291c.u();
        Long l2 = null;
        if (u != null && (newestVersion = u.getNewestVersion()) != null) {
            l2 = Long.valueOf(Long.parseLong(newestVersion));
        }
        return l2 == null || l2.longValue() < 2010200;
    }
}
