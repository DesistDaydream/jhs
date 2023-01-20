package com.ss.android.downloadlib.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;

/* loaded from: classes3.dex */
public class g extends com.ss.android.socialbase.appdownloader.c.a {
    private static String a = "g";

    /* loaded from: classes3.dex */
    public static class a implements k {
        private Dialog a;

        public a(Dialog dialog) {
            if (dialog != null) {
                this.a = dialog;
                a();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public void a() {
            Dialog dialog = this.a;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public boolean b() {
            Dialog dialog = this.a;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public l a(Context context) {
        return new l(context) { // from class: com.ss.android.downloadlib.c.g.1
            public final /* synthetic */ Context a;

            /* renamed from: c  reason: collision with root package name */
            private b.a f5356c;

            /* renamed from: d  reason: collision with root package name */
            private DialogInterface.OnClickListener f5357d;

            /* renamed from: e  reason: collision with root package name */
            private DialogInterface.OnClickListener f5358e;

            /* renamed from: f  reason: collision with root package name */
            private DialogInterface.OnCancelListener f5359f;

            {
                this.a = context;
                this.f5356c = new b.a(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i2) {
                this.f5356c.a(this.a.getResources().getString(i2));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l b(int i2, DialogInterface.OnClickListener onClickListener) {
                this.f5356c.d(this.a.getResources().getString(i2));
                this.f5358e = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(String str) {
                this.f5356c.b(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i2, DialogInterface.OnClickListener onClickListener) {
                this.f5356c.c(this.a.getResources().getString(i2));
                this.f5357d = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(DialogInterface.OnCancelListener onCancelListener) {
                this.f5359f = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(boolean z) {
                this.f5356c.a(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public k a() {
                this.f5356c.a(new b.InterfaceC0170b() { // from class: com.ss.android.downloadlib.c.g.1.1
                    @Override // com.ss.android.download.api.model.b.InterfaceC0170b
                    public void a(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f5357d != null) {
                            AnonymousClass1.this.f5357d.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC0170b
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f5358e != null) {
                            AnonymousClass1.this.f5358e.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC0170b
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f5359f == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.f5359f.onCancel(dialogInterface);
                    }
                });
                com.ss.android.downloadlib.g.k.a(g.a, "getThemedAlertDlgBuilder", null);
                this.f5356c.a(3);
                return new a(j.c().b(this.f5356c.a()));
            }
        };
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public boolean a() {
        return true;
    }
}
