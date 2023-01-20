package com.bumptech.glide.load.data;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import e.b.a.p.j.e;
import java.io.IOException;

/* loaded from: classes.dex */
public final class ParcelFileDescriptorRewinder implements e<ParcelFileDescriptor> {
    private final InternalRewinder a;

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static final class InternalRewinder {
        private final ParcelFileDescriptor a;

        public InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
            this.a = parcelFileDescriptor;
        }

        public ParcelFileDescriptor rewind() throws IOException {
            try {
                Os.lseek(this.a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.a;
            } catch (ErrnoException e2) {
                throw new IOException(e2);
            }
        }
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static final class a implements e.a<ParcelFileDescriptor> {
        @Override // e.b.a.p.j.e.a
        @NonNull
        /* renamed from: b */
        public e<ParcelFileDescriptor> a(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // e.b.a.p.j.e.a
        @NonNull
        public Class<ParcelFileDescriptor> getDataClass() {
            return ParcelFileDescriptor.class;
        }
    }

    @RequiresApi(21)
    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.a = new InternalRewinder(parcelFileDescriptor);
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // e.b.a.p.j.e
    public void a() {
    }

    @Override // e.b.a.p.j.e
    @NonNull
    @RequiresApi(21)
    /* renamed from: d */
    public ParcelFileDescriptor b() throws IOException {
        return this.a.rewind();
    }
}
