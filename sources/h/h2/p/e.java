package h.h2.p;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.m7.imkfsdk.utils.MimeTypeParser;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpns.mqtt.MqttTopic;
import h.g2.f;
import h.i;
import h.k2.u.l;
import h.k2.v.c0;
import h.k2.v.f0;
import h.p0;
import h.q0;
import h.q2.m;
import h.s0;
import h.t1;
import h.t2.u;
import h.x1;
import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000²\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a*\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00012\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001a\"\u00020\u0001H\u0087\b¢\u0006\u0002\u0010\u001b\u001a?\u0010\u001c\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010!\u001a6\u0010\u001c\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010\"\u001aK\u0010#\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010%\u001aB\u0010#\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010&\u001a\u001c\u0010'\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u00022\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0001\u001a\r\u0010+\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010,\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a.\u0010-\u001a\u00020\u0002*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u0002000\u001a\"\u000200H\u0087\b¢\u0006\u0002\u00101\u001a\u001f\u0010-\u001a\u00020\u0002*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u00102\u001a\u000203H\u0087\b\u001a.\u00104\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u00105\u001a.\u00106\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u00105\u001a.\u00107\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u00105\u001a\u0015\u00108\u001a\u00020\u0002*\u00020\u00022\u0006\u0010.\u001a\u00020\u0002H\u0087\b\u001a6\u00109\u001a\u00020\u0002*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010:\u001a\r\u0010;\u001a\u00020<*\u00020\u0002H\u0087\b\u001a\r\u0010=\u001a\u000203*\u00020\u0002H\u0087\b\u001a\u0015\u0010>\u001a\u00020\u0002*\u00020\u00022\u0006\u0010?\u001a\u00020\u0002H\u0087\n\u001a\u0015\u0010>\u001a\u00020\u0002*\u00020\u00022\u0006\u0010?\u001a\u00020\u0001H\u0087\n\u001a&\u0010@\u001a\u000203*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b¢\u0006\u0002\u0010B\u001a2\u0010C\u001a\u0002HD\"\n\b\u0000\u0010D\u0018\u0001*\u00020E*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b¢\u0006\u0002\u0010F\u001a4\u0010G\u001a\u0004\u0018\u0001HD\"\n\b\u0000\u0010D\u0018\u0001*\u00020E*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b¢\u0006\u0002\u0010F\u001a\r\u0010H\u001a\u00020I*\u00020\u0002H\u0087\b\u001a\r\u0010J\u001a\u00020K*\u00020\u0002H\u0087\b\u001a.\u0010L\u001a\u00020<*\u00020\u00022\b\b\u0002\u0010M\u001a\u00020\u00012\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020<0OH\u0087\bø\u0001\u0000\u001a0\u0010P\u001a\u0004\u0018\u00010Q*\u00020\u00022\u0006\u0010R\u001a\u00020\u00012\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b¢\u0006\u0002\u0010S\u001a&\u0010T\u001a\u00020U*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b¢\u0006\u0002\u0010V\u001a(\u0010W\u001a\u0004\u0018\u00010X*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b¢\u0006\u0002\u0010Y\u001a,\u0010Z\u001a\b\u0012\u0004\u0012\u00020\\0[*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b¢\u0006\u0002\u0010]\u001a&\u0010^\u001a\u000203*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b¢\u0006\u0002\u0010B\u001a\r\u0010_\u001a\u000203*\u00020\u0002H\u0087\b\u001a\r\u0010`\u001a\u000203*\u00020\u0002H\u0087\b\u001a\r\u0010a\u001a\u000203*\u00020\u0002H\u0087\b\u001a&\u0010b\u001a\u000203*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b¢\u0006\u0002\u0010B\u001a\u0015\u0010c\u001a\u000203*\u00020\u00022\u0006\u0010?\u001a\u00020\u0002H\u0087\b\u001a\r\u0010d\u001a\u000203*\u00020\u0002H\u0087\b\u001a\r\u0010e\u001a\u000203*\u00020\u0002H\u0087\b\u001a\u001c\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00020g*\u00020\u00022\b\b\u0002\u0010M\u001a\u00020\u0001H\u0007\u001a.\u0010h\u001a\u00020\u0002*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u0002000\u001a\"\u000200H\u0087\b¢\u0006\u0002\u00101\u001a\u001f\u0010h\u001a\u00020\u0002*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u00102\u001a\u000203H\u0087\b\u001a&\u0010i\u001a\u000203*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b¢\u0006\u0002\u0010B\u001a2\u0010j\u001a\u0002Hk\"\n\b\u0000\u0010k\u0018\u0001*\u00020l*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b¢\u0006\u0002\u0010m\u001a<\u0010j\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010Q0n*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00012\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b¢\u0006\u0002\u0010o\u001a\r\u0010p\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0016\u0010r\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0014\u0010s\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a8\u0010t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010R\u001a\u00020\u00012\b\u0010u\u001a\u0004\u0018\u00010Q2\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b¢\u0006\u0002\u0010v\u001a\u0015\u0010w\u001a\u00020\u0002*\u00020\u00022\u0006\u0010u\u001a\u00020UH\u0087\b\u001a\u0015\u0010x\u001a\u00020\u0002*\u00020\u00022\u0006\u0010u\u001a\u00020XH\u0087\b\u001a\u001b\u0010y\u001a\u00020\u0002*\u00020\u00022\f\u0010u\u001a\b\u0012\u0004\u0012\u00020\\0[H\u0087\b\u001a\r\u0010z\u001a\u00020\u0002*\u00020{H\u0087\b\u001a@\u0010|\u001a\u0002H}\"\u0004\b\u0000\u0010}*\u00020\u00022\b\b\u0002\u0010M\u001a\u00020\u00012\u0018\u0010~\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u007f\u0012\u0004\u0012\u0002H}0OH\u0087\bø\u0001\u0000¢\u0006\u0003\u0010\u0080\u0001\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u001e\u0010\u0010\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0081\u0001"}, d2 = {MimeTypeParser.ATTR_EXTENSION, "", "Ljava/nio/file/Path;", "getExtension$annotations", "(Ljava/nio/file/Path;)V", "getExtension", "(Ljava/nio/file/Path;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath$annotations", "getInvariantSeparatorsPath", "invariantSeparatorsPathString", "getInvariantSeparatorsPathString$annotations", "getInvariantSeparatorsPathString", "name", "getName$annotations", "getName", "nameWithoutExtension", "getNameWithoutExtension$annotations", "getNameWithoutExtension", "pathString", "getPathString$annotations", "getPathString", "Path", "path", "base", "subpaths", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "createTempDirectory", "directory", "prefix", "attributes", "Ljava/nio/file/attribute/FileAttribute;", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createTempFile", "suffix", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "fileAttributeViewNotAvailable", "", "attributeViewClass", "Ljava/lang/Class;", "absolute", "absolutePathString", "copyTo", TypedValues.Attributes.S_TARGET, "options", "Ljava/nio/file/CopyOption;", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "overwrite", "", "createDirectories", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createDirectory", "createFile", "createLinkPointingTo", "createSymbolicLinkPointingTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "deleteExisting", "", "deleteIfExists", "div", "other", "exists", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "fileAttributesView", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/nio/file/attribute/FileAttributeView;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "fileAttributesViewOrNull", "fileSize", "", "fileStore", "Ljava/nio/file/FileStore;", "forEachDirectoryEntry", "glob", "action", "Lkotlin/Function1;", "getAttribute", "", "attribute", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "getLastModifiedTime", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "getOwner", "Ljava/nio/file/attribute/UserPrincipal;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "getPosixFilePermissions", "", "Ljava/nio/file/attribute/PosixFilePermission;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "isDirectory", "isExecutable", "isHidden", "isReadable", "isRegularFile", "isSameFileAs", "isSymbolicLink", "isWritable", "listDirectoryEntries", "", "moveTo", "notExists", "readAttributes", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/nio/file/attribute/BasicFileAttributes;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", "", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "readSymbolicLink", "relativeTo", "relativeToOrNull", "relativeToOrSelf", "setAttribute", "value", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "setLastModifiedTime", "setOwner", "setPosixFilePermissions", "toPath", "Ljava/net/URI;", "useDirectoryEntries", ExifInterface.GPS_DIRECTION_TRUE, ReportItem.LogTypeBlock, "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/io/path/PathsKt")
/* loaded from: classes3.dex */
public class e extends d {
    private static final String A0(Path path) {
        return path.toString();
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    public static /* synthetic */ void B0(Path path) {
    }

    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final Set<PosixFilePermission> C0(Path path, LinkOption... linkOptionArr) throws IOException {
        return Files.getPosixFilePermissions(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final boolean D0(Path path, LinkOption... linkOptionArr) {
        return Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final boolean E0(Path path) {
        return Files.isExecutable(path);
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final boolean F0(Path path) throws IOException {
        return Files.isHidden(path);
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final boolean G0(Path path) {
        return Files.isReadable(path);
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final Path H(String str) {
        return Paths.get(str, new String[0]);
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final boolean H0(Path path, LinkOption... linkOptionArr) {
        return Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final Path I(String str, String... strArr) {
        return Paths.get(str, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final boolean I0(Path path, Path path2) throws IOException {
        return Files.isSameFile(path, path2);
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final Path J(Path path) {
        return path.toAbsolutePath();
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final boolean J0(Path path) {
        return Files.isSymbolicLink(path);
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final String K(Path path) {
        return path.toAbsolutePath().toString();
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final boolean K0(Path path) {
        return Files.isWritable(path);
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final Path L(Path path, Path path2, boolean z) throws IOException {
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        return Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
    }

    @s0(version = "1.5")
    @x1(markerClass = {a.class})
    @k.e.a.d
    public static final List<Path> L0(@k.e.a.d Path path, @k.e.a.d String str) throws IOException {
        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            List<Path> I5 = CollectionsKt___CollectionsKt.I5(newDirectoryStream);
            h.h2.b.a(newDirectoryStream, null);
            return I5;
        } finally {
        }
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final Path M(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        return Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
    }

    public static /* synthetic */ List M0(Path path, String str, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            str = "*";
        }
        return L0(path, str);
    }

    public static /* synthetic */ Path N(Path path, Path path2, boolean z, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            z = false;
        }
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        return Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final Path N0(Path path, Path path2, boolean z) throws IOException {
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        return Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
    }

    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final Path O(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        return Files.createDirectories(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final Path O0(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        return Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
    }

    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final Path P(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        return Files.createDirectory(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
    }

    public static /* synthetic */ Path P0(Path path, Path path2, boolean z, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            z = false;
        }
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        return Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
    }

    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final Path Q(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        return Files.createFile(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final boolean Q0(Path path, LinkOption... linkOptionArr) {
        return Files.notExists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final Path R(Path path, Path path2) throws IOException {
        return Files.createLink(path, path2);
    }

    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final Path S(Path path, Path path2, FileAttribute<?>... fileAttributeArr) throws IOException {
        return Files.createSymbolicLink(path, path2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
    }

    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final Map<String, Object> S0(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        return Files.readAttributes(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final Path T(String str, FileAttribute<?>... fileAttributeArr) throws IOException {
        return Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final Path T0(Path path) throws IOException {
        return Files.readSymbolicLink(path);
    }

    @s0(version = "1.5")
    @x1(markerClass = {a.class})
    @k.e.a.d
    public static final Path U(@k.e.a.e Path path, @k.e.a.e String str, @k.e.a.d FileAttribute<?>... fileAttributeArr) throws IOException {
        if (path != null) {
            return Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        }
        return Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
    }

    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final Path U0(@k.e.a.d Path path, @k.e.a.d Path path2) {
        try {
            return b.f14895c.a(path, path2);
        } catch (IllegalArgumentException e2) {
            String message = e2.getMessage();
            throw new IllegalArgumentException(f0.C(message, "\nthis path: " + path + "\nbase path: " + path2), e2);
        }
    }

    public static /* synthetic */ Path V(String str, FileAttribute[] fileAttributeArr, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
    }

    @x1(markerClass = {a.class})
    @k.e.a.e
    @s0(version = "1.5")
    public static final Path V0(@k.e.a.d Path path, @k.e.a.d Path path2) {
        try {
            return b.f14895c.a(path, path2);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static /* synthetic */ Path W(Path path, String str, FileAttribute[] fileAttributeArr, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return U(path, str, fileAttributeArr);
    }

    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final Path W0(@k.e.a.d Path path, @k.e.a.d Path path2) {
        Path V0 = V0(path, path2);
        return V0 != null ? V0 : path;
    }

    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final Path X(String str, String str2, FileAttribute<?>... fileAttributeArr) throws IOException {
        return Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final Path X0(Path path, String str, Object obj, LinkOption... linkOptionArr) throws IOException {
        return Files.setAttribute(path, str, obj, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @s0(version = "1.5")
    @x1(markerClass = {a.class})
    @k.e.a.d
    public static final Path Y(@k.e.a.e Path path, @k.e.a.e String str, @k.e.a.e String str2, @k.e.a.d FileAttribute<?>... fileAttributeArr) throws IOException {
        if (path != null) {
            return Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        }
        return Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final Path Y0(Path path, FileTime fileTime) throws IOException {
        return Files.setLastModifiedTime(path, fileTime);
    }

    public static /* synthetic */ Path Z(String str, String str2, FileAttribute[] fileAttributeArr, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final Path Z0(Path path, UserPrincipal userPrincipal) throws IOException {
        return Files.setOwner(path, userPrincipal);
    }

    public static /* synthetic */ Path a0(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        return Y(path, str, str2, fileAttributeArr);
    }

    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final Path a1(Path path, Set<? extends PosixFilePermission> set) throws IOException {
        return Files.setPosixFilePermissions(path, set);
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final void b0(Path path) throws IOException {
        Files.delete(path);
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final Path b1(URI uri) {
        return Paths.get(uri);
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final boolean c0(Path path) throws IOException {
        return Files.deleteIfExists(path);
    }

    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final <T> T c1(Path path, String str, l<? super m<? extends Path>, ? extends T> lVar) throws IOException {
        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            T invoke = lVar.invoke(CollectionsKt___CollectionsKt.n1(newDirectoryStream));
            c0.d(1);
            if (h.g2.l.a(1, 1, 0)) {
                h.h2.b.a(newDirectoryStream, null);
            } else if (newDirectoryStream != null) {
                newDirectoryStream.close();
            }
            c0.c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (h.g2.l.a(1, 1, 0)) {
                    h.h2.b.a(newDirectoryStream, th);
                } else if (newDirectoryStream != null) {
                    try {
                        newDirectoryStream.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final Path d0(Path path, String str) {
        return path.resolve(str);
    }

    public static /* synthetic */ Object d1(Path path, String str, l lVar, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            str = "*";
        }
        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            Object invoke = lVar.invoke(CollectionsKt___CollectionsKt.n1(newDirectoryStream));
            c0.d(1);
            if (h.g2.l.a(1, 1, 0)) {
                h.h2.b.a(newDirectoryStream, null);
            } else if (newDirectoryStream != null) {
                newDirectoryStream.close();
            }
            c0.c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (h.g2.l.a(1, 1, 0)) {
                    h.h2.b.a(newDirectoryStream, th);
                } else if (newDirectoryStream != null) {
                    try {
                        newDirectoryStream.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final Path e0(Path path, Path path2) {
        return path.resolve(path2);
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final boolean f0(Path path, LinkOption... linkOptionArr) {
        return Files.exists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @p0
    @k.e.a.d
    public static final Void g0(@k.e.a.d Path path, @k.e.a.d Class<?> cls) {
        throw new UnsupportedOperationException("The desired attribute view type " + cls + " is not available for the file " + path + '.');
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final /* synthetic */ <V extends FileAttributeView> V h0(Path path, LinkOption... linkOptionArr) {
        f0.y(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        V v = (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        if (v != null) {
            return v;
        }
        f0.y(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        g0(path, FileAttributeView.class);
        throw new KotlinNothingValueException();
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final long j0(Path path) throws IOException {
        return Files.size(path);
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final FileStore k0(Path path) throws IOException {
        return Files.getFileStore(path);
    }

    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final void l0(Path path, String str, l<? super Path, t1> lVar) throws IOException {
        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            for (Path path2 : newDirectoryStream) {
                lVar.invoke(path2);
            }
            t1 t1Var = t1.a;
            c0.d(1);
            if (h.g2.l.a(1, 1, 0)) {
                h.h2.b.a(newDirectoryStream, null);
            } else if (newDirectoryStream != null) {
                newDirectoryStream.close();
            }
            c0.c(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (h.g2.l.a(1, 1, 0)) {
                    h.h2.b.a(newDirectoryStream, th);
                } else if (newDirectoryStream != null) {
                    try {
                        newDirectoryStream.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }

    public static /* synthetic */ void m0(Path path, String str, l lVar, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            str = "*";
        }
        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            for (Path path2 : newDirectoryStream) {
                lVar.invoke(path2);
            }
            t1 t1Var = t1.a;
            c0.d(1);
            if (h.g2.l.a(1, 1, 0)) {
                h.h2.b.a(newDirectoryStream, null);
            } else if (newDirectoryStream != null) {
                newDirectoryStream.close();
            }
            c0.c(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (h.g2.l.a(1, 1, 0)) {
                    h.h2.b.a(newDirectoryStream, th);
                } else if (newDirectoryStream != null) {
                    try {
                        newDirectoryStream.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final Object n0(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        return Files.getAttribute(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @k.e.a.d
    public static final String o0(@k.e.a.d Path path) {
        String obj;
        String n5;
        Path fileName = path.getFileName();
        return (fileName == null || (obj = fileName.toString()) == null || (n5 = StringsKt__StringsKt.n5(obj, '.', "")) == null) ? "" : n5;
    }

    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    public static /* synthetic */ void p0(Path path) {
    }

    private static final String q0(Path path) {
        return s0(path);
    }

    @i(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @q0(expression = "invariantSeparatorsPathString", imports = {}))
    @s0(version = "1.4")
    @a
    @f
    public static /* synthetic */ void r0(Path path) {
    }

    @k.e.a.d
    public static final String s0(@k.e.a.d Path path) {
        String separator = path.getFileSystem().getSeparator();
        return f0.g(separator, MqttTopic.TOPIC_LEVEL_SEPARATOR) ^ true ? u.k2(path.toString(), separator, MqttTopic.TOPIC_LEVEL_SEPARATOR, false, 4, null) : path.toString();
    }

    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    public static /* synthetic */ void t0(Path path) {
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final FileTime u0(Path path, LinkOption... linkOptionArr) throws IOException {
        return Files.getLastModifiedTime(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @k.e.a.d
    public static final String v0(@k.e.a.d Path path) {
        Path fileName = path.getFileName();
        String obj = fileName != null ? fileName.toString() : null;
        return obj != null ? obj : "";
    }

    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    public static /* synthetic */ void w0(Path path) {
    }

    @k.e.a.d
    public static final String x0(@k.e.a.d Path path) {
        String obj;
        String y5;
        Path fileName = path.getFileName();
        return (fileName == null || (obj = fileName.toString()) == null || (y5 = StringsKt__StringsKt.y5(obj, ".", null, 2, null)) == null) ? "" : y5;
    }

    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    public static /* synthetic */ void y0(Path path) {
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final UserPrincipal z0(Path path, LinkOption... linkOptionArr) throws IOException {
        return Files.getOwner(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }
}
