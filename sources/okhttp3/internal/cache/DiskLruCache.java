package okhttp3.internal.cache;

import com.baidu.mobads.sdk.internal.aj;
import com.baidu.mobads.sdk.internal.bp;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import e.b.a.m.a;
import h.h2.b;
import h.k2.h;
import h.k2.v.f0;
import h.k2.v.u;
import h.t1;
import h.t2.y;
import j.k0;
import j.m0;
import j.n;
import j.o;
import j.r;
import j.z;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b*\u0001S\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0004mnopB9\b\u0000\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010X\u001a\u00020K\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010b\u001a\u00020\u001b\u0012\u0006\u0010j\u001a\u00020i¢\u0006\u0004\bk\u0010lJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\fJ\r\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0016\u0010\u0005J\u001e\u0010\u0019\u001a\b\u0018\u00010\u0018R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001e\u001a\b\u0018\u00010\u001dR\u00020\u00002\u0006\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u001b¢\u0006\u0004\b \u0010!J#\u0010&\u001a\u00020\u00032\n\u0010\"\u001a\u00060\u001dR\u00020\u00002\u0006\u0010#\u001a\u00020\u000eH\u0000¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b'\u0010(J\u001b\u0010-\u001a\u00020\u000e2\n\u0010*\u001a\u00060)R\u00020\u0000H\u0000¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020\u0003H\u0016¢\u0006\u0004\b.\u0010\u0005J\r\u0010/\u001a\u00020\u000e¢\u0006\u0004\b/\u0010\u0010J\u000f\u00100\u001a\u00020\u0003H\u0016¢\u0006\u0004\b0\u0010\u0005J\r\u00101\u001a\u00020\u0003¢\u0006\u0004\b1\u0010\u0005J\r\u00102\u001a\u00020\u0003¢\u0006\u0004\b2\u0010\u0005J\r\u00103\u001a\u00020\u0003¢\u0006\u0004\b3\u0010\u0005J\u0017\u00105\u001a\f\u0012\b\u0012\u00060\u0018R\u00020\u000004¢\u0006\u0004\b5\u00106R,\u00108\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u00060)R\u00020\u0000078\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\"\u0010<\u001a\u00020\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\u0010\"\u0004\b?\u0010@R\u001c\u0010B\u001a\u00020A8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0019\u0010G\u001a\u00020F8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u001c\u0010L\u001a\u00020K8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010=R\u0016\u0010Q\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010=R\u0016\u0010R\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010=R\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010MR\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010HR\u0016\u0010]\u001a\u00020K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010MR\u0016\u0010^\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010=R\u0016\u0010 \u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010WR\u0018\u0010_\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R*\u0010b\u001a\u00020\u001b2\u0006\u0010a\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010W\u001a\u0004\bc\u0010!\"\u0004\bd\u0010eR\u0016\u0010f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010=R\u0016\u0010g\u001a\u00020F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010HR\u0016\u0010h\u001a\u00020F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010H¨\u0006q"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lh/t1;", "readJournal", "()V", "Lj/n;", "newJournalWriter", "()Lj/n;", "", "line", "readJournalLine", "(Ljava/lang/String;)V", "processJournal", "", "journalRebuildRequired", "()Z", "checkNotClosed", "removeOldestEntry", "key", "validateKey", "initialize", "rebuildJournal$okhttp", "rebuildJournal", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "get", "(Ljava/lang/String;)Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "", "expectedSequenceNumber", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "edit", "(Ljava/lang/String;J)Lokhttp3/internal/cache/DiskLruCache$Editor;", "size", "()J", "editor", bp.o, "completeEdit$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;Z)V", "completeEdit", "remove", "(Ljava/lang/String;)Z", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "entry", "removeEntry$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Entry;)Z", "removeEntry", "flush", "isClosed", "close", "trimToSize", "delete", "evictAll", "", "snapshots", "()Ljava/util/Iterator;", "Ljava/util/LinkedHashMap;", "lruEntries", "Ljava/util/LinkedHashMap;", "getLruEntries$okhttp", "()Ljava/util/LinkedHashMap;", "closed", "Z", "getClosed$okhttp", "setClosed$okhttp", "(Z)V", "Lokhttp3/internal/io/FileSystem;", "fileSystem", "Lokhttp3/internal/io/FileSystem;", "getFileSystem$okhttp", "()Lokhttp3/internal/io/FileSystem;", "Ljava/io/File;", "directory", "Ljava/io/File;", "getDirectory", "()Ljava/io/File;", "", "valueCount", ExpandableTextView.P, "getValueCount$okhttp", "()I", "initialized", "mostRecentTrimFailed", "civilizedFileSystem", "okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "cleanupTask", "Lokhttp3/internal/cache/DiskLruCache$cleanupTask$1;", "nextSequenceNumber", "J", "appVersion", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "journalFile", "redundantOpCount", "mostRecentRebuildFailed", "journalWriter", "Lj/n;", "value", "maxSize", "getMaxSize", "setMaxSize", "(J)V", "hasJournalErrors", "journalFileTmp", "journalFileBackup", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "<init>", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;IIJLokhttp3/internal/concurrent/TaskRunner;)V", "Companion", "Editor", "Entry", "Snapshot", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class DiskLruCache implements Closeable, Flushable {
    private final int appVersion;
    private boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private boolean closed;
    @d
    private final File directory;
    @d
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private n journalWriter;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;
    public static final Companion Companion = new Companion(null);
    @h.k2.d
    @d
    public static final String JOURNAL_FILE = a.o;
    @h.k2.d
    @d
    public static final String JOURNAL_FILE_TEMP = a.p;
    @h.k2.d
    @d
    public static final String JOURNAL_FILE_BACKUP = a.q;
    @h.k2.d
    @d
    public static final String MAGIC = a.r;
    @h.k2.d
    @d
    public static final String VERSION_1 = "1";
    @h.k2.d
    public static final long ANY_SEQUENCE_NUMBER = -1;
    @h.k2.d
    @d
    public static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    @h.k2.d
    @d
    public static final String CLEAN = "CLEAN";
    @h.k2.d
    @d
    public static final String DIRTY = "DIRTY";
    @h.k2.d
    @d
    public static final String REMOVE = "REMOVE";
    @h.k2.d
    @d
    public static final String READ = "READ";
    @d
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private final DiskLruCache$cleanupTask$1 cleanupTask = new Task(Util.okHttpName + " Cache") { // from class: okhttp3.internal.cache.DiskLruCache$cleanupTask$1
        {
            DiskLruCache.this = this;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            synchronized (DiskLruCache.this) {
                if (!DiskLruCache.access$getInitialized$p(DiskLruCache.this) || DiskLruCache.this.getClosed$okhttp()) {
                    return -1L;
                }
                try {
                    DiskLruCache.this.trimToSize();
                } catch (IOException unused) {
                    DiskLruCache.access$setMostRecentTrimFailed$p(DiskLruCache.this, true);
                }
                try {
                    if (DiskLruCache.access$journalRebuildRequired(DiskLruCache.this)) {
                        DiskLruCache.this.rebuildJournal$okhttp();
                        DiskLruCache.access$setRedundantOpCount$p(DiskLruCache.this, 0);
                    }
                } catch (IOException unused2) {
                    DiskLruCache.access$setMostRecentRebuildFailed$p(DiskLruCache.this, true);
                    DiskLruCache.access$setJournalWriter$p(DiskLruCache.this, z.c(z.b()));
                }
                return -1L;
            }
        }
    };

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0016\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0016\u0010\u0010\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0016\u0010\u0011\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0012\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Companion;", "", "", "ANY_SEQUENCE_NUMBER", "J", "", "CLEAN", "Ljava/lang/String;", "DIRTY", "JOURNAL_FILE", "JOURNAL_FILE_BACKUP", "JOURNAL_FILE_TEMP", "Lkotlin/text/Regex;", "LEGAL_KEY_PATTERN", "Lkotlin/text/Regex;", "MAGIC", "READ", "REMOVE", "VERSION_1", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u001a\u001a\u00060\u0018R\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\r\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0004R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001a\u001a\u00060\u0018R\u00020\u00198\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "Lh/t1;", "detach$okhttp", "()V", "detach", "", "index", "Lj/m0;", "newSource", "(I)Lj/m0;", "Lj/k0;", "newSink", "(I)Lj/k0;", "commit", "abort", "", "written", "[Z", "getWritten$okhttp", "()[Z", "", "done", "Z", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "Lokhttp3/internal/cache/DiskLruCache;", "entry", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "getEntry$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Entry;", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$Entry;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class Editor {
        private boolean done;
        @d
        private final Entry entry;
        @e
        private final boolean[] written;

        public Editor(@d Entry entry) {
            DiskLruCache.this = r1;
            this.entry = entry;
            this.written = entry.getReadable$okhttp() ? null : new boolean[r1.getValueCount$okhttp()];
        }

        public final void abort() throws IOException {
            synchronized (DiskLruCache.this) {
                if (!this.done) {
                    if (f0.g(this.entry.getCurrentEditor$okhttp(), this)) {
                        DiskLruCache.this.completeEdit$okhttp(this, false);
                    }
                    this.done = true;
                    t1 t1Var = t1.a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void commit() throws IOException {
            synchronized (DiskLruCache.this) {
                if (!this.done) {
                    if (f0.g(this.entry.getCurrentEditor$okhttp(), this)) {
                        DiskLruCache.this.completeEdit$okhttp(this, true);
                    }
                    this.done = true;
                    t1 t1Var = t1.a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void detach$okhttp() {
            if (f0.g(this.entry.getCurrentEditor$okhttp(), this)) {
                if (DiskLruCache.this.civilizedFileSystem) {
                    DiskLruCache.this.completeEdit$okhttp(this, false);
                } else {
                    this.entry.setZombie$okhttp(true);
                }
            }
        }

        @d
        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        @e
        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        @d
        public final k0 newSink(int i2) {
            synchronized (DiskLruCache.this) {
                if (!this.done) {
                    if (!f0.g(this.entry.getCurrentEditor$okhttp(), this)) {
                        return z.b();
                    }
                    if (!this.entry.getReadable$okhttp()) {
                        this.written[i2] = true;
                    }
                    try {
                        return new FaultHidingSink(DiskLruCache.this.getFileSystem$okhttp().sink(this.entry.getDirtyFiles$okhttp().get(i2)), new DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(this, i2));
                    } catch (FileNotFoundException unused) {
                        return z.b();
                    }
                }
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        @e
        public final m0 newSource(int i2) {
            synchronized (DiskLruCache.this) {
                if (!this.done) {
                    m0 m0Var = null;
                    if (!this.entry.getReadable$okhttp() || (!f0.g(this.entry.getCurrentEditor$okhttp(), this)) || this.entry.getZombie$okhttp()) {
                        return null;
                    }
                    try {
                        m0Var = DiskLruCache.this.getFileSystem$okhttp().source(this.entry.getCleanFiles$okhttp().get(i2));
                    } catch (FileNotFoundException unused) {
                    }
                    return m0Var;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010F\u001a\u00020\u0003¢\u0006\u0004\bJ\u0010KJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u001a\u001a\b\u0018\u00010\u0016R\u00020\u0017H\u0000¢\u0006\u0004\b\u0018\u0010\u0019R(\u0010\u001c\u001a\b\u0018\u00010\u001bR\u00020\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010#\u001a\u00020\"8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00100\u001a\b\u0012\u0004\u0012\u00020/0.8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010;\u001a\u0002048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b;\u00106\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R\"\u0010>\u001a\b\u0012\u0004\u0012\u00020/0.8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b>\u00101\u001a\u0004\b?\u00103R\"\u0010@\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u00020\u00038\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I¨\u0006L"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "", "", "strings", "", "invalidLengths", "(Ljava/util/List;)Ljava/lang/Void;", "", "index", "Lj/m0;", "newSource", "(I)Lj/m0;", "Lh/t1;", "setLengths$okhttp", "(Ljava/util/List;)V", "setLengths", "Lj/n;", "writer", "writeLengths$okhttp", "(Lj/n;)V", "writeLengths", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "snapshot$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "currentEditor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "getCurrentEditor$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "setCurrentEditor$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "", "lengths", "[J", "getLengths$okhttp", "()[J", "", "sequenceNumber", "J", "getSequenceNumber$okhttp", "()J", "setSequenceNumber$okhttp", "(J)V", "", "Ljava/io/File;", "cleanFiles", "Ljava/util/List;", "getCleanFiles$okhttp", "()Ljava/util/List;", "", "readable", "Z", "getReadable$okhttp", "()Z", "setReadable$okhttp", "(Z)V", "zombie", "getZombie$okhttp", "setZombie$okhttp", "dirtyFiles", "getDirtyFiles$okhttp", "lockingSourceCount", ExpandableTextView.P, "getLockingSourceCount$okhttp", "()I", "setLockingSourceCount$okhttp", "(I)V", "key", "Ljava/lang/String;", "getKey$okhttp", "()Ljava/lang/String;", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class Entry {
        @e
        private Editor currentEditor;
        @d
        private final String key;
        @d
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        private boolean zombie;
        @d
        private final List<File> cleanFiles = new ArrayList();
        @d
        private final List<File> dirtyFiles = new ArrayList();

        public Entry(@d String str) {
            DiskLruCache.this = r8;
            this.key = str;
            this.lengths = new long[r8.getValueCount$okhttp()];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            int valueCount$okhttp = r8.getValueCount$okhttp();
            for (int i2 = 0; i2 < valueCount$okhttp; i2++) {
                sb.append(i2);
                this.cleanFiles.add(new File(r8.getDirectory(), sb.toString()));
                sb.append(aj.f1423k);
                this.dirtyFiles.add(new File(r8.getDirectory(), sb.toString()));
                sb.setLength(length);
            }
        }

        private final Void invalidLengths(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        private final m0 newSource(int i2) {
            final m0 source = DiskLruCache.this.getFileSystem$okhttp().source(this.cleanFiles.get(i2));
            if (DiskLruCache.this.civilizedFileSystem) {
                return source;
            }
            this.lockingSourceCount++;
            return new r(source) { // from class: okhttp3.internal.cache.DiskLruCache$Entry$newSource$1
                private boolean closed;

                {
                    DiskLruCache.Entry.this = this;
                }

                @Override // j.r, j.m0, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    super.close();
                    if (this.closed) {
                        return;
                    }
                    this.closed = true;
                    synchronized (DiskLruCache.this) {
                        DiskLruCache.Entry entry = DiskLruCache.Entry.this;
                        entry.setLockingSourceCount$okhttp(entry.getLockingSourceCount$okhttp() - 1);
                        if (DiskLruCache.Entry.this.getLockingSourceCount$okhttp() == 0 && DiskLruCache.Entry.this.getZombie$okhttp()) {
                            DiskLruCache.Entry entry2 = DiskLruCache.Entry.this;
                            DiskLruCache.this.removeEntry$okhttp(entry2);
                        }
                        t1 t1Var = t1.a;
                    }
                }
            };
        }

        @d
        public final List<File> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        @e
        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        @d
        public final List<File> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        @d
        public final String getKey$okhttp() {
            return this.key;
        }

        @d
        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setCurrentEditor$okhttp(@e Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths$okhttp(@d List<String> list) throws IOException {
            if (list.size() == DiskLruCache.this.getValueCount$okhttp()) {
                try {
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.lengths[i2] = Long.parseLong(list.get(i2));
                    }
                    return;
                } catch (NumberFormatException unused) {
                    invalidLengths(list);
                    throw new KotlinNothingValueException();
                }
            }
            invalidLengths(list);
            throw new KotlinNothingValueException();
        }

        public final void setLockingSourceCount$okhttp(int i2) {
            this.lockingSourceCount = i2;
        }

        public final void setReadable$okhttp(boolean z) {
            this.readable = z;
        }

        public final void setSequenceNumber$okhttp(long j2) {
            this.sequenceNumber = j2;
        }

        public final void setZombie$okhttp(boolean z) {
            this.zombie = z;
        }

        @e
        public final Snapshot snapshot$okhttp() {
            DiskLruCache diskLruCache = DiskLruCache.this;
            if (Util.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + diskLruCache);
            } else if (this.readable) {
                if (DiskLruCache.this.civilizedFileSystem || (this.currentEditor == null && !this.zombie)) {
                    ArrayList<m0> arrayList = new ArrayList();
                    long[] jArr = (long[]) this.lengths.clone();
                    try {
                        int valueCount$okhttp = DiskLruCache.this.getValueCount$okhttp();
                        for (int i2 = 0; i2 < valueCount$okhttp; i2++) {
                            arrayList.add(newSource(i2));
                        }
                        return new Snapshot(this.key, this.sequenceNumber, arrayList, jArr);
                    } catch (FileNotFoundException unused) {
                        for (m0 m0Var : arrayList) {
                            Util.closeQuietly(m0Var);
                        }
                        try {
                            DiskLruCache.this.removeEntry$okhttp(this);
                        } catch (IOException unused2) {
                        }
                        return null;
                    }
                }
                return null;
            } else {
                return null;
            }
        }

        public final void writeLengths$okhttp(@d n nVar) throws IOException {
            for (long j2 : this.lengths) {
                nVar.writeByte(32).S(j2);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u000e\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0007\u001a\b\u0018\u00010\u0005R\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", "", "key", "()Ljava/lang/String;", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "edit", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "index", "Lj/m0;", "getSource", "(I)Lj/m0;", "", "getLength", "(I)J", "Lh/t1;", "close", "()V", "", "lengths", "[J", "Ljava/lang/String;", "sequenceNumber", "J", "", "sources", "Ljava/util/List;", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;JLjava/util/List;[J)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<m0> sources;

        /* JADX WARN: Multi-variable type inference failed */
        public Snapshot(@d String str, long j2, @d List<? extends m0> list, @d long[] jArr) {
            DiskLruCache.this = r1;
            this.key = str;
            this.sequenceNumber = j2;
            this.sources = list;
            this.lengths = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (m0 m0Var : this.sources) {
                Util.closeQuietly(m0Var);
            }
        }

        @e
        public final Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int i2) {
            return this.lengths[i2];
        }

        @d
        public final m0 getSource(int i2) {
            return this.sources.get(i2);
        }

        @d
        public final String key() {
            return this.key;
        }
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [okhttp3.internal.cache.DiskLruCache$cleanupTask$1] */
    public DiskLruCache(@d FileSystem fileSystem, @d File file, int i2, int i3, long j2, @d TaskRunner taskRunner) {
        this.fileSystem = fileSystem;
        this.directory = file;
        this.appVersion = i2;
        this.valueCount = i3;
        this.maxSize = j2;
        this.cleanupQueue = taskRunner.newQueue();
        if (!(j2 > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        if (i3 > 0) {
            this.journalFile = new File(file, JOURNAL_FILE);
            this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
            this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
            return;
        }
        throw new IllegalArgumentException("valueCount <= 0".toString());
    }

    public static final /* synthetic */ boolean access$getInitialized$p(DiskLruCache diskLruCache) {
        return diskLruCache.initialized;
    }

    public static final /* synthetic */ boolean access$journalRebuildRequired(DiskLruCache diskLruCache) {
        return diskLruCache.journalRebuildRequired();
    }

    public static final /* synthetic */ void access$setJournalWriter$p(DiskLruCache diskLruCache, n nVar) {
        diskLruCache.journalWriter = nVar;
    }

    public static final /* synthetic */ void access$setMostRecentRebuildFailed$p(DiskLruCache diskLruCache, boolean z) {
        diskLruCache.mostRecentRebuildFailed = z;
    }

    public static final /* synthetic */ void access$setMostRecentTrimFailed$p(DiskLruCache diskLruCache, boolean z) {
        diskLruCache.mostRecentTrimFailed = z;
    }

    public static final /* synthetic */ void access$setRedundantOpCount$p(DiskLruCache diskLruCache, int i2) {
        diskLruCache.redundantOpCount = i2;
    }

    private final synchronized void checkNotClosed() {
        if (!(!this.closed)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j2, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            j2 = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j2);
    }

    public final boolean journalRebuildRequired() {
        int i2 = this.redundantOpCount;
        return i2 >= 2000 && i2 >= this.lruEntries.size();
    }

    private final n newJournalWriter() throws FileNotFoundException {
        return z.c(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new DiskLruCache$newJournalWriter$faultHidingSink$1(this)));
    }

    private final void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i2 = 0;
            if (next.getCurrentEditor$okhttp() == null) {
                int i3 = this.valueCount;
                while (i2 < i3) {
                    this.size += next.getLengths$okhttp()[i2];
                    i2++;
                }
            } else {
                next.setCurrentEditor$okhttp(null);
                int i4 = this.valueCount;
                while (i2 < i4) {
                    this.fileSystem.delete(next.getCleanFiles$okhttp().get(i2));
                    this.fileSystem.delete(next.getDirtyFiles$okhttp().get(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    private final void readJournal() throws IOException {
        o d2 = z.d(this.fileSystem.source(this.journalFile));
        try {
            String I = d2.I();
            String I2 = d2.I();
            String I3 = d2.I();
            String I4 = d2.I();
            String I5 = d2.I();
            if (!(!f0.g(MAGIC, I)) && !(!f0.g(VERSION_1, I2)) && !(!f0.g(String.valueOf(this.appVersion), I3)) && !(!f0.g(String.valueOf(this.valueCount), I4))) {
                int i2 = 0;
                if (!(I5.length() > 0)) {
                    while (true) {
                        try {
                            readJournalLine(d2.I());
                            i2++;
                        } catch (EOFException unused) {
                            this.redundantOpCount = i2 - this.lruEntries.size();
                            if (!d2.b0()) {
                                rebuildJournal$okhttp();
                            } else {
                                this.journalWriter = newJournalWriter();
                            }
                            t1 t1Var = t1.a;
                            b.a(d2, null);
                            return;
                        }
                    }
                }
            }
            throw new IOException("unexpected journal header: [" + I + ", " + I2 + ", " + I4 + ", " + I5 + ']');
        } finally {
        }
    }

    private final void readJournalLine(String str) throws IOException {
        String substring;
        int q3 = StringsKt__StringsKt.q3(str, ' ', 0, false, 6, null);
        if (q3 != -1) {
            int i2 = q3 + 1;
            int q32 = StringsKt__StringsKt.q3(str, ' ', i2, false, 4, null);
            if (q32 == -1) {
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                substring = str.substring(i2);
                String str2 = REMOVE;
                if (q3 == str2.length() && h.t2.u.u2(str, str2, false, 2, null)) {
                    this.lruEntries.remove(substring);
                    return;
                }
            } else {
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                substring = str.substring(i2, q32);
            }
            Entry entry = this.lruEntries.get(substring);
            if (entry == null) {
                entry = new Entry(substring);
                this.lruEntries.put(substring, entry);
            }
            if (q32 != -1) {
                String str3 = CLEAN;
                if (q3 == str3.length() && h.t2.u.u2(str, str3, false, 2, null)) {
                    Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                    List<String> R4 = StringsKt__StringsKt.R4(str.substring(q32 + 1), new char[]{' '}, false, 0, 6, null);
                    entry.setReadable$okhttp(true);
                    entry.setCurrentEditor$okhttp(null);
                    entry.setLengths$okhttp(R4);
                    return;
                }
            }
            if (q32 == -1) {
                String str4 = DIRTY;
                if (q3 == str4.length() && h.t2.u.u2(str, str4, false, 2, null)) {
                    entry.setCurrentEditor$okhttp(new Editor(entry));
                    return;
                }
            }
            if (q32 == -1) {
                String str5 = READ;
                if (q3 == str5.length() && h.t2.u.u2(str, str5, false, 2, null)) {
                    return;
                }
            }
            throw new IOException("unexpected journal line: " + str);
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private final boolean removeOldestEntry() {
        for (Entry entry : this.lruEntries.values()) {
            if (!entry.getZombie$okhttp()) {
                removeEntry$okhttp(entry);
                return true;
            }
        }
        return false;
    }

    private final void validateKey(String str) {
        if (LEGAL_KEY_PATTERN.matches(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + y.a).toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Entry[] entryArr;
        Editor currentEditor$okhttp;
        if (this.initialized && !this.closed) {
            Object[] array = this.lruEntries.values().toArray(new Entry[0]);
            if (array != null) {
                for (Entry entry : (Entry[]) array) {
                    if (entry.getCurrentEditor$okhttp() != null && (currentEditor$okhttp = entry.getCurrentEditor$okhttp()) != null) {
                        currentEditor$okhttp.detach$okhttp();
                    }
                }
                trimToSize();
                this.journalWriter.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        this.closed = true;
    }

    public final synchronized void completeEdit$okhttp(@d Editor editor, boolean z) throws IOException {
        Entry entry$okhttp = editor.getEntry$okhttp();
        if (f0.g(entry$okhttp.getCurrentEditor$okhttp(), editor)) {
            if (z && !entry$okhttp.getReadable$okhttp()) {
                int i2 = this.valueCount;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (editor.getWritten$okhttp()[i3]) {
                        if (!this.fileSystem.exists(entry$okhttp.getDirtyFiles$okhttp().get(i3))) {
                            editor.abort();
                            return;
                        }
                    } else {
                        editor.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i3);
                    }
                }
            }
            int i4 = this.valueCount;
            for (int i5 = 0; i5 < i4; i5++) {
                File file = entry$okhttp.getDirtyFiles$okhttp().get(i5);
                if (z && !entry$okhttp.getZombie$okhttp()) {
                    if (this.fileSystem.exists(file)) {
                        File file2 = entry$okhttp.getCleanFiles$okhttp().get(i5);
                        this.fileSystem.rename(file, file2);
                        long j2 = entry$okhttp.getLengths$okhttp()[i5];
                        long size = this.fileSystem.size(file2);
                        entry$okhttp.getLengths$okhttp()[i5] = size;
                        this.size = (this.size - j2) + size;
                    }
                } else {
                    this.fileSystem.delete(file);
                }
            }
            entry$okhttp.setCurrentEditor$okhttp(null);
            if (entry$okhttp.getZombie$okhttp()) {
                removeEntry$okhttp(entry$okhttp);
                return;
            }
            this.redundantOpCount++;
            n nVar = this.journalWriter;
            if (!entry$okhttp.getReadable$okhttp() && !z) {
                this.lruEntries.remove(entry$okhttp.getKey$okhttp());
                nVar.B(REMOVE).writeByte(32);
                nVar.B(entry$okhttp.getKey$okhttp());
                nVar.writeByte(10);
                nVar.flush();
                if (this.size <= this.maxSize || journalRebuildRequired()) {
                    TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
                }
                return;
            }
            entry$okhttp.setReadable$okhttp(true);
            nVar.B(CLEAN).writeByte(32);
            nVar.B(entry$okhttp.getKey$okhttp());
            entry$okhttp.writeLengths$okhttp(nVar);
            nVar.writeByte(10);
            if (z) {
                long j3 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j3;
                entry$okhttp.setSequenceNumber$okhttp(j3);
            }
            nVar.flush();
            if (this.size <= this.maxSize) {
            }
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    @h
    @e
    public final Editor edit(@d String str) throws IOException {
        return edit$default(this, str, 0L, 2, null);
    }

    @h
    @e
    public final synchronized Editor edit(@d String str, long j2) throws IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (j2 == ANY_SEQUENCE_NUMBER || (entry != null && entry.getSequenceNumber$okhttp() == j2)) {
            if ((entry != null ? entry.getCurrentEditor$okhttp() : null) != null) {
                return null;
            }
            if (entry == null || entry.getLockingSourceCount$okhttp() == 0) {
                if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
                    n nVar = this.journalWriter;
                    nVar.B(DIRTY).writeByte(32).B(str).writeByte(10);
                    nVar.flush();
                    if (this.hasJournalErrors) {
                        return null;
                    }
                    if (entry == null) {
                        entry = new Entry(str);
                        this.lruEntries.put(str, entry);
                    }
                    Editor editor = new Editor(entry);
                    entry.setCurrentEditor$okhttp(editor);
                    return editor;
                }
                TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
                return null;
            }
            return null;
        }
        return null;
    }

    public final synchronized void evictAll() throws IOException {
        initialize();
        Object[] array = this.lruEntries.values().toArray(new Entry[0]);
        if (array != null) {
            for (Entry entry : (Entry[]) array) {
                removeEntry$okhttp(entry);
            }
            this.mostRecentTrimFailed = false;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            this.journalWriter.flush();
        }
    }

    @e
    public final synchronized Snapshot get(@d String str) throws IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry != null) {
            Snapshot snapshot$okhttp = entry.snapshot$okhttp();
            if (snapshot$okhttp != null) {
                this.redundantOpCount++;
                this.journalWriter.B(READ).writeByte(32).B(str).writeByte(10);
                if (journalRebuildRequired()) {
                    TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
                }
                return snapshot$okhttp;
            }
            return null;
        }
        return null;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    @d
    public final File getDirectory() {
        return this.directory;
    }

    @d
    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    @d
    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized void initialize() throws IOException {
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (this.initialized) {
            return;
        }
        if (this.fileSystem.exists(this.journalFileBackup)) {
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.delete(this.journalFileBackup);
            } else {
                this.fileSystem.rename(this.journalFileBackup, this.journalFile);
            }
        }
        this.civilizedFileSystem = Util.isCivilized(this.fileSystem, this.journalFileBackup);
        if (this.fileSystem.exists(this.journalFile)) {
            try {
                readJournal();
                processJournal();
                this.initialized = true;
                return;
            } catch (IOException e2) {
                Platform platform = Platform.Companion.get();
                platform.log("DiskLruCache " + this.directory + " is corrupt: " + e2.getMessage() + ", removing", 5, e2);
                delete();
                this.closed = false;
            }
        }
        rebuildJournal$okhttp();
        this.initialized = true;
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    public final synchronized void rebuildJournal$okhttp() throws IOException {
        n nVar = this.journalWriter;
        if (nVar != null) {
            nVar.close();
        }
        n c2 = z.c(this.fileSystem.sink(this.journalFileTmp));
        c2.B(MAGIC).writeByte(10);
        c2.B(VERSION_1).writeByte(10);
        c2.S(this.appVersion).writeByte(10);
        c2.S(this.valueCount).writeByte(10);
        c2.writeByte(10);
        for (Entry entry : this.lruEntries.values()) {
            if (entry.getCurrentEditor$okhttp() != null) {
                c2.B(DIRTY).writeByte(32);
                c2.B(entry.getKey$okhttp());
                c2.writeByte(10);
            } else {
                c2.B(CLEAN).writeByte(32);
                c2.B(entry.getKey$okhttp());
                entry.writeLengths$okhttp(c2);
                c2.writeByte(10);
            }
        }
        t1 t1Var = t1.a;
        b.a(c2, null);
        if (this.fileSystem.exists(this.journalFile)) {
            this.fileSystem.rename(this.journalFile, this.journalFileBackup);
        }
        this.fileSystem.rename(this.journalFileTmp, this.journalFile);
        this.fileSystem.delete(this.journalFileBackup);
        this.journalWriter = newJournalWriter();
        this.hasJournalErrors = false;
        this.mostRecentRebuildFailed = false;
    }

    public final synchronized boolean remove(@d String str) throws IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry != null) {
            boolean removeEntry$okhttp = removeEntry$okhttp(entry);
            if (removeEntry$okhttp && this.size <= this.maxSize) {
                this.mostRecentTrimFailed = false;
            }
            return removeEntry$okhttp;
        }
        return false;
    }

    public final boolean removeEntry$okhttp(@d Entry entry) throws IOException {
        n nVar;
        if (!this.civilizedFileSystem) {
            if (entry.getLockingSourceCount$okhttp() > 0 && (nVar = this.journalWriter) != null) {
                nVar.B(DIRTY);
                nVar.writeByte(32);
                nVar.B(entry.getKey$okhttp());
                nVar.writeByte(10);
                nVar.flush();
            }
            if (entry.getLockingSourceCount$okhttp() > 0 || entry.getCurrentEditor$okhttp() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i2 = this.valueCount;
        for (int i3 = 0; i3 < i2; i3++) {
            this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i3));
            this.size -= entry.getLengths$okhttp()[i3];
            entry.getLengths$okhttp()[i3] = 0;
        }
        this.redundantOpCount++;
        n nVar2 = this.journalWriter;
        if (nVar2 != null) {
            nVar2.B(REMOVE);
            nVar2.writeByte(32);
            nVar2.B(entry.getKey$okhttp());
            nVar2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return true;
    }

    public final void setClosed$okhttp(boolean z) {
        this.closed = z;
    }

    public final synchronized void setMaxSize(long j2) {
        this.maxSize = j2;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    @d
    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new DiskLruCache$snapshots$1(this);
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }
}
