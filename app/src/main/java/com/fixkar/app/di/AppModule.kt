package com.fixkar.app.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.ktx.messaging
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt module — tells Hilt how to create instances of types it doesn't own
 * (i.e. Firebase classes, which we can't annotate with @Inject).
 *
 * Every repository/viewmodel that needs Firestore will just ask for
 * FirebaseFirestore in its constructor; Hilt will use this module to supply it.
 *
 * Phase 2+ will add:
 *   - Repositories (AuthRepository, UserRepository, etc.)
 *   - SharedPreferences / DataStore wrappers
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = Firebase.auth

    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    @Singleton
    fun provideFirebaseMessaging(): FirebaseMessaging = Firebase.messaging
}
