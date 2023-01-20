package okhttp3.internal.cache2;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import h.k2.d;
import h.k2.v.f0;
import h.k2.v.u;
import h.t1;
import j.m;
import j.m0;
import j.o0;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import k.e.a.e;
import kotlin.Metadata;
import okhttp3.internal.Util;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 E2\u00020\u0001:\u0002EFB5\b\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\u00104\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\bC\u0010DJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015\"\u0004\b\u0018\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0019\u0010\"\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00104\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0019\u0010@\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010#\u001a\u0004\bA\u0010%R\u0013\u0010B\u001a\u00020&8F@\u0006¢\u0006\u0006\u001a\u0004\bB\u0010*¨\u0006G"}, d2 = {"Lokhttp3/internal/cache2/Relay;", "", "Lokio/ByteString;", "prefix", "", "upstreamSize", "metadataSize", "Lh/t1;", "writeHeader", "(Lokio/ByteString;JJ)V", "writeMetadata", "(J)V", "commit", "metadata", "()Lokio/ByteString;", "Lj/m0;", "newSource", "()Lj/m0;", "bufferMaxSize", "J", "getBufferMaxSize", "()J", "upstreamPos", "getUpstreamPos", "setUpstreamPos", "Lokio/ByteString;", "Ljava/io/RandomAccessFile;", "file", "Ljava/io/RandomAccessFile;", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "Lj/m;", "upstreamBuffer", "Lj/m;", "getUpstreamBuffer", "()Lj/m;", "", "complete", "Z", "getComplete", "()Z", "setComplete", "(Z)V", "Ljava/lang/Thread;", "upstreamReader", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", "upstream", "Lj/m0;", "getUpstream", "setUpstream", "(Lj/m0;)V", "", "sourceCount", ExpandableTextView.P, "getSourceCount", "()I", "setSourceCount", "(I)V", "buffer", "getBuffer", "isClosed", "<init>", "(Ljava/io/RandomAccessFile;Lj/m0;JLokio/ByteString;J)V", "Companion", "RelaySource", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class Relay {
    public static final Companion Companion = new Companion(null);
    private static final long FILE_HEADER_SIZE = 32;
    @d
    @k.e.a.d
    public static final ByteString PREFIX_CLEAN;
    @d
    @k.e.a.d
    public static final ByteString PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    @k.e.a.d
    private final m buffer;
    private final long bufferMaxSize;
    private boolean complete;
    @e
    private RandomAccessFile file;
    private final ByteString metadata;
    private int sourceCount;
    @e
    private m0 upstream;
    @k.e.a.d
    private final m upstreamBuffer;
    private long upstreamPos;
    @e
    private Thread upstreamReader;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/cache2/Relay$Companion;", "", "Ljava/io/File;", "file", "Lj/m0;", "upstream", "Lokio/ByteString;", "metadata", "", "bufferMaxSize", "Lokhttp3/internal/cache2/Relay;", "edit", "(Ljava/io/File;Lj/m0;Lokio/ByteString;J)Lokhttp3/internal/cache2/Relay;", "read", "(Ljava/io/File;)Lokhttp3/internal/cache2/Relay;", "FILE_HEADER_SIZE", "J", "PREFIX_CLEAN", "Lokio/ByteString;", "PREFIX_DIRTY", "", "SOURCE_FILE", ExpandableTextView.P, "SOURCE_UPSTREAM", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        @k.e.a.d
        public final Relay edit(@k.e.a.d File file, @k.e.a.d m0 m0Var, @k.e.a.d ByteString byteString, long j2) throws IOException {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, m0Var, 0L, byteString, j2, null);
            randomAccessFile.setLength(0L);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1L, -1L);
            return relay;
        }

        @k.e.a.d
        public final Relay read(@k.e.a.d File file) throws IOException {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
            m mVar = new m();
            fileOperator.read(0L, mVar, 32L);
            ByteString byteString = Relay.PREFIX_CLEAN;
            if (!(!f0.g(mVar.V(byteString.size()), byteString))) {
                long readLong = mVar.readLong();
                long readLong2 = mVar.readLong();
                m mVar2 = new m();
                fileOperator.read(readLong + 32, mVar2, readLong2);
                return new Relay(randomAccessFile, null, readLong, mVar2.j0(), 0L, null);
            }
            throw new IOException("unreadable cache file");
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/cache2/Relay$RelaySource;", "Lj/m0;", "Lj/m;", "sink", "", "byteCount", "read", "(Lj/m;J)J", "Lj/o0;", "timeout", "()Lj/o0;", "Lh/t1;", "close", "()V", "sourcePos", "J", "Lokhttp3/internal/cache2/FileOperator;", "fileOperator", "Lokhttp3/internal/cache2/FileOperator;", "Lj/o0;", "<init>", "(Lokhttp3/internal/cache2/Relay;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class RelaySource implements m0 {
        private FileOperator fileOperator;
        private long sourcePos;
        private final o0 timeout = new o0();

        public RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.getFile().getChannel());
        }

        @Override // j.m0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                Relay relay = Relay.this;
                relay.setSourceCount(relay.getSourceCount() - 1);
                if (Relay.this.getSourceCount() == 0) {
                    RandomAccessFile file = Relay.this.getFile();
                    Relay.this.setFile(null);
                    randomAccessFile = file;
                }
                t1 t1Var = t1.a;
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0083, code lost:
            if (r4 != 2) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0085, code lost:
            r2 = java.lang.Math.min(r20, r18.this$0.getUpstreamPos() - r18.sourcePos);
            r18.fileOperator.read(r18.sourcePos + 32, r19, r2);
            r18.sourcePos += r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a5, code lost:
            r7 = r18.this$0.getUpstream().read(r18.this$0.getUpstreamBuffer(), r18.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00bd, code lost:
            if (r7 != (-1)) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00bf, code lost:
            r0 = r18.this$0;
            r0.commit(r0.getUpstreamPos());
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00c8, code lost:
            r2 = r18.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00ca, code lost:
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00cb, code lost:
            r18.this$0.setUpstreamReader(null);
            r0 = r18.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00d2, code lost:
            if (r0 == null) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00d4, code lost:
            r0.notifyAll();
            r0 = h.t1.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00d9, code lost:
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00da, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00e2, code lost:
            throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00e6, code lost:
            r2 = java.lang.Math.min(r7, r20);
            r18.this$0.getUpstreamBuffer().H(r19, 0, r2);
            r18.sourcePos += r2;
            r18.fileOperator.write(r18.this$0.getUpstreamPos() + 32, r18.this$0.getUpstreamBuffer().clone(), r7);
            r5 = r18.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0118, code lost:
            monitor-enter(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0119, code lost:
            r18.this$0.getBuffer().write(r18.this$0.getUpstreamBuffer(), r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x013a, code lost:
            if (r18.this$0.getBuffer().O0() <= r18.this$0.getBufferMaxSize()) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x013c, code lost:
            r18.this$0.getBuffer().skip(r18.this$0.getBuffer().O0() - r18.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0156, code lost:
            r0 = r18.this$0;
            r0.setUpstreamPos(r0.getUpstreamPos() + r7);
            r0 = h.t1.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0162, code lost:
            monitor-exit(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0163, code lost:
            r5 = r18.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0165, code lost:
            monitor-enter(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0166, code lost:
            r18.this$0.setUpstreamReader(null);
            r0 = r18.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x016d, code lost:
            if (r0 == null) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x016f, code lost:
            r0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0172, code lost:
            monitor-exit(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0173, code lost:
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x017b, code lost:
            throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0182, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0185, code lost:
            monitor-enter(r18.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0186, code lost:
            r18.this$0.setUpstreamReader(null);
            r3 = r18.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x018d, code lost:
            if (r3 == null) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0196, code lost:
            throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0197, code lost:
            r3.notifyAll();
            r3 = h.t1.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x019d, code lost:
            throw r0;
         */
        @Override // j.m0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(@k.e.a.d j.m r19, long r20) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 432
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(j.m, long):long");
        }

        @Override // j.m0
        @k.e.a.d
        public o0 timeout() {
            return this.timeout;
        }
    }

    static {
        ByteString.a aVar = ByteString.Companion;
        PREFIX_CLEAN = aVar.l("OkHttp cache v1\n");
        PREFIX_DIRTY = aVar.l("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile randomAccessFile, m0 m0Var, long j2, ByteString byteString, long j3) {
        this.file = randomAccessFile;
        this.upstream = m0Var;
        this.upstreamPos = j2;
        this.metadata = byteString;
        this.bufferMaxSize = j3;
        this.upstreamBuffer = new m();
        this.complete = this.upstream == null;
        this.buffer = new m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeHeader(ByteString byteString, long j2, long j3) throws IOException {
        m mVar = new m();
        mVar.r0(byteString);
        mVar.t0(j2);
        mVar.t0(j3);
        if (mVar.O0() == 32) {
            new FileOperator(this.file.getChannel()).write(0L, mVar, 32L);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final void writeMetadata(long j2) throws IOException {
        m mVar = new m();
        mVar.r0(this.metadata);
        new FileOperator(this.file.getChannel()).write(32 + j2, mVar, this.metadata.size());
    }

    public final void commit(long j2) throws IOException {
        writeMetadata(j2);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j2, this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
            t1 t1Var = t1.a;
        }
        m0 m0Var = this.upstream;
        if (m0Var != null) {
            Util.closeQuietly(m0Var);
        }
        this.upstream = null;
    }

    @k.e.a.d
    public final m getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    @e
    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    @e
    public final m0 getUpstream() {
        return this.upstream;
    }

    @k.e.a.d
    public final m getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    @e
    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    @k.e.a.d
    public final ByteString metadata() {
        return this.metadata;
    }

    @e
    public final m0 newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    public final void setComplete(boolean z) {
        this.complete = z;
    }

    public final void setFile(@e RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i2) {
        this.sourceCount = i2;
    }

    public final void setUpstream(@e m0 m0Var) {
        this.upstream = m0Var;
    }

    public final void setUpstreamPos(long j2) {
        this.upstreamPos = j2;
    }

    public final void setUpstreamReader(@e Thread thread) {
        this.upstreamReader = thread;
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, m0 m0Var, long j2, ByteString byteString, long j3, u uVar) {
        this(randomAccessFile, m0Var, j2, byteString, j3);
    }
}
