package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes3.dex */
public class b {
    public Context a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f5136c;

    /* renamed from: d  reason: collision with root package name */
    public String f5137d;

    /* renamed from: e  reason: collision with root package name */
    public String f5138e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5139f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f5140g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC0170b f5141h;

    /* renamed from: i  reason: collision with root package name */
    public View f5142i;

    /* renamed from: j  reason: collision with root package name */
    public int f5143j;

    /* loaded from: classes3.dex */
    public static final class a {
        public View a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        private Context f5144c;

        /* renamed from: d  reason: collision with root package name */
        private String f5145d;

        /* renamed from: e  reason: collision with root package name */
        private String f5146e;

        /* renamed from: f  reason: collision with root package name */
        private String f5147f;

        /* renamed from: g  reason: collision with root package name */
        private String f5148g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f5149h;

        /* renamed from: i  reason: collision with root package name */
        private Drawable f5150i;

        /* renamed from: j  reason: collision with root package name */
        private InterfaceC0170b f5151j;

        public a(Context context) {
            this.f5144c = context;
        }

        public a a(String str) {
            this.f5145d = str;
            return this;
        }

        public a b(String str) {
            this.f5146e = str;
            return this;
        }

        public a c(String str) {
            this.f5147f = str;
            return this;
        }

        public a d(String str) {
            this.f5148g = str;
            return this;
        }

        public a a(boolean z) {
            this.f5149h = z;
            return this;
        }

        public a a(Drawable drawable) {
            this.f5150i = drawable;
            return this;
        }

        public a a(InterfaceC0170b interfaceC0170b) {
            this.f5151j = interfaceC0170b;
            return this;
        }

        public a a(int i2) {
            this.b = i2;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.ss.android.download.api.model.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0170b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    private b(a aVar) {
        this.f5139f = true;
        this.a = aVar.f5144c;
        this.b = aVar.f5145d;
        this.f5136c = aVar.f5146e;
        this.f5137d = aVar.f5147f;
        this.f5138e = aVar.f5148g;
        this.f5139f = aVar.f5149h;
        this.f5140g = aVar.f5150i;
        this.f5141h = aVar.f5151j;
        this.f5142i = aVar.a;
        this.f5143j = aVar.b;
    }
}
