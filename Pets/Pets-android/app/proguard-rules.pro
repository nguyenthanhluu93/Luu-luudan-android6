# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\SDK/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
##---------------Begin: proguard configuration common for all Android apps ----------
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers
-dontpreverify
-verbose

-dump class_files.txt
-printseeds seeds.txt
-printusage unused.txt
-printmapping mapping.txt
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

-allowaccessmodification
-keepattributes *Annotation*
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable
-repackageclasses ''

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.support.v4.app.Fragment
-keep public class * extends android.support.v4.app.FragmentActivity
-keep public class * extends android.support.v7.app.AppCompatActivity
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService
-keep class com.android.vending.billing.*
-keep class android.support.v7.**{ *; }
-dontnote com.android.vending.licensing.ILicensingService

# Explicitly preserve all serialization members. The Serializable interface
# is only a marker interface, so it wouldn't save them.
-keepclassmembers class * implements java.io.Serializable {
static final long serialVersionUID;
private static final java.io.ObjectStreamField[] serialPersistentFields;
private void writeObject(java.io.ObjectOutputStream);
private void readObject(java.io.ObjectInputStream);
java.lang.Object writeReplace();
java.lang.Object readResolve();
}

# Preserve all native method names and the names of their classes.
-keepclasseswithmembernames class * {
	native <methods>;
}

-keepclasseswithmembernames class * {
public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembernames class * {
	public <init>(android.content.Context, android.util.AttributeSet, int);
}

# Preserve static fields of inner classes of R classes that might be accessed
# through introspection.
-keepclassmembers class **.R$* {
	public static <fields>;
}

# Preserve the special static methods that are required in all enumeration classes.
-keepclassmembers enum * {
	public static **[] values();
	public static ** valueOf(java.lang.String);
}

-keep public class * {
	public protected *;
}

-keep class * implements android.os.Parcelable {
	public static final android.os.Parcelable$Creator *;
}

-keep public class com.google.android.gms.ads.** {
   public *;
}
-keep class javax.inject.** { *; }
##---------------End: proguard configuration common for all Android apps ----------

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }

# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature

# Retrofit 2.X
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-dontwarn okio.**
-dontwarn retrofit2.Platform$Java8

# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions

-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

#Enter your proguard-rules here
# autovalue
-dontwarn javax.lang.**
-dontwarn javax.tools.**
-dontwarn javax.annotation.**
-dontwarn autovalue.shaded.com.**
-dontwarn com.google.auto.value.**

# autovalue gson extension
-keep class **.AutoParcelGson_*
-keepnames @auto.parcelgson.AutoParcelGson class *

# Dagger
-dontwarn java.lang.**
-dontwarn javax.lang.**
-dontwarn javax.annotation.**
-dontwarn javax.tools.**
-dontwarn sun.misc.Unsafe
-dontwarn dagger.shaded.auto.common.BasicAnnotationProcessor

-dontwarn dagger.internal.codegen.**
-keepclassmembers,allowobfuscation class * {
    @javax.inject.* *;
    @dagger.* *;
    <init>();
}
-keep class dagger.* { *; }
-keep class javax.inject.* { *; }
-keep class * extends dagger.internal.Binding
-keep class * extends dagger.internal.ModuleAdapter
-keep class * extends dagger.internal.StaticInjection

# cache
-keep class com.google.**
-dontwarn com.google.**
-dontwarn sun.misc.**

#RxJava
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
   long producerIndex;
   long consumerIndex;
}

-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}

-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

#Crashlytics
-dontwarn com.crashlytics.sdk.android.**

#Delete all Log.v(), Log.i()...
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** w(...);
    public static *** e(...);
    public static *** i(...);
}
