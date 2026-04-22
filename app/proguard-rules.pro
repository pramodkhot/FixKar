# ProGuard / R8 rules for the release build.
# These rules keep classes that must NOT be renamed/removed for the app to work.

# --- Firebase (Firestore reads field names via reflection) ---
-keep class com.google.firebase.** { *; }
-keepclassmembers class * {
    @com.google.firebase.firestore.PropertyName <fields>;
    @com.google.firebase.firestore.PropertyName <methods>;
}

# --- Data classes / domain models (used by Firestore auto-serialization) ---
-keep class com.fixkar.app.domain.model.** { *; }
-keepclassmembers class com.fixkar.app.domain.model.** { *; }

# --- Kotlin metadata ---
-keep class kotlin.Metadata { *; }

# --- Keep source file + line numbers for crash reports ---
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# --- Compose ---
# Compose already ships its own rules via BOM, so no extra keeps needed.
