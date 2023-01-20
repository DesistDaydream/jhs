package com.ss.android.socialbase.downloader.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.i.i;

/* loaded from: classes3.dex */
public class g {
    private final SQLiteDatabase a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f5550c;

    /* renamed from: d  reason: collision with root package name */
    private final String[] f5551d;

    /* renamed from: e  reason: collision with root package name */
    private SQLiteStatement f5552e;

    /* renamed from: f  reason: collision with root package name */
    private SQLiteStatement f5553f;

    /* renamed from: g  reason: collision with root package name */
    private SQLiteStatement f5554g;

    /* renamed from: h  reason: collision with root package name */
    private SQLiteStatement f5555h;

    public g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.a = sQLiteDatabase;
        this.b = str;
        this.f5550c = strArr;
        this.f5551d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f5552e == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a("INSERT INTO ", this.b, this.f5550c));
            synchronized (this) {
                if (this.f5552e == null) {
                    this.f5552e = compileStatement;
                }
            }
            if (this.f5552e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f5552e;
    }

    public SQLiteStatement b() {
        if (this.f5554g == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.b, this.f5551d));
            synchronized (this) {
                if (this.f5554g == null) {
                    this.f5554g = compileStatement;
                }
            }
            if (this.f5554g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f5554g;
    }

    public SQLiteStatement c() {
        if (this.f5553f == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.b, this.f5550c, this.f5551d));
            synchronized (this) {
                if (this.f5553f == null) {
                    this.f5553f = compileStatement;
                }
            }
            if (this.f5553f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f5553f;
    }

    public SQLiteStatement d() {
        if (this.f5555h == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.b(this.b, this.f5550c, this.f5551d));
            synchronized (this) {
                if (this.f5555h == null) {
                    this.f5555h = compileStatement;
                }
            }
            if (this.f5555h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f5555h;
    }
}
