package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import com.baidu.mobads.sdk.internal.aj;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.c.m.a;
import e.j.a.b.c.p.m;
import e.j.a.b.c.r.d0;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

@SafeParcelable.a(creator = "BitmapTeleporterCreator")
@a
@d0
/* loaded from: classes2.dex */
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
    @a
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new m();
    @SafeParcelable.c(id = 3)
    private final int mType;
    @SafeParcelable.g(id = 1)
    private final int zalf;
    @SafeParcelable.c(id = 2)
    private ParcelFileDescriptor zalg;
    private Bitmap zalh;
    private boolean zali;
    private File zalj;

    @SafeParcelable.b
    public BitmapTeleporter(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.e(id = 3) int i3) {
        this.zalf = i2;
        this.zalg = parcelFileDescriptor;
        this.mType = i3;
        this.zalh = null;
        this.zali = false;
    }

    private static void zaa(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            Log.w("BitmapTeleporter", "Could not close stream", e2);
        }
    }

    private final FileOutputStream zabz() {
        File file = this.zalj;
        if (file != null) {
            try {
                File createTempFile = File.createTempFile("teleporter", aj.f1423k, file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                    this.zalg = ParcelFileDescriptor.open(createTempFile, 268435456);
                    createTempFile.delete();
                    return fileOutputStream;
                } catch (FileNotFoundException unused) {
                    throw new IllegalStateException("Temporary file is somehow already deleted");
                }
            } catch (IOException e2) {
                throw new IllegalStateException("Could not create temporary file", e2);
            }
        }
        throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
    }

    @a
    public Bitmap get() {
        if (!this.zali) {
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zalg));
            try {
                try {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    int readInt = dataInputStream.readInt();
                    int readInt2 = dataInputStream.readInt();
                    Bitmap.Config valueOf = Bitmap.Config.valueOf(dataInputStream.readUTF());
                    dataInputStream.read(bArr);
                    zaa(dataInputStream);
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    Bitmap createBitmap = Bitmap.createBitmap(readInt, readInt2, valueOf);
                    createBitmap.copyPixelsFromBuffer(wrap);
                    this.zalh = createBitmap;
                    this.zali = true;
                } catch (IOException e2) {
                    throw new IllegalStateException("Could not read from parcel file descriptor", e2);
                }
            } catch (Throwable th) {
                zaa(dataInputStream);
                throw th;
            }
        }
        return this.zalh;
    }

    @a
    public void release() {
        if (this.zali) {
            return;
        }
        try {
            this.zalg.close();
        } catch (IOException e2) {
            Log.w("BitmapTeleporter", "Could not close PFD", e2);
        }
    }

    @a
    public void setTempDir(File file) {
        Objects.requireNonNull(file, "Cannot set null temp directory");
        this.zalj = file;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        if (this.zalg == null) {
            Bitmap bitmap = this.zalh;
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(zabz()));
            try {
                try {
                    dataOutputStream.writeInt(array.length);
                    dataOutputStream.writeInt(bitmap.getWidth());
                    dataOutputStream.writeInt(bitmap.getHeight());
                    dataOutputStream.writeUTF(bitmap.getConfig().toString());
                    dataOutputStream.write(array);
                } catch (IOException e2) {
                    throw new IllegalStateException("Could not write into unlinked file", e2);
                }
            } finally {
                zaa(dataOutputStream);
            }
        }
        int a = e.j.a.b.c.r.i0.a.a(parcel);
        e.j.a.b.c.r.i0.a.F(parcel, 1, this.zalf);
        e.j.a.b.c.r.i0.a.S(parcel, 2, this.zalg, i2 | 1, false);
        e.j.a.b.c.r.i0.a.F(parcel, 3, this.mType);
        e.j.a.b.c.r.i0.a.b(parcel, a);
        this.zalg = null;
    }

    @a
    public BitmapTeleporter(Bitmap bitmap) {
        this.zalf = 1;
        this.zalg = null;
        this.mType = 0;
        this.zalh = bitmap;
        this.zali = true;
    }
}
