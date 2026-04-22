package com.fixkar.app.core

/**
 * Central place for constants.
 *
 * RULE: No hardcoded strings/values in code. If you find yourself typing a literal
 * twice, move it here or into string resources.
 */
object Constants {

    // --- Firestore collections ---
    const val COLLECTION_USERS    = "users"
    const val COLLECTION_WORKERS  = "workers"
    const val COLLECTION_JOBS     = "jobs"
    const val COLLECTION_BIDS     = "bids"
    const val COLLECTION_REVIEWS  = "reviews"

    // --- User roles ---
    const val ROLE_CUSTOMER = "customer"
    const val ROLE_WORKER   = "worker"

    // --- Job statuses ---
    const val JOB_STATUS_OPEN      = "open"
    const val JOB_STATUS_ASSIGNED  = "assigned"
    const val JOB_STATUS_COMPLETED = "completed"
    const val JOB_STATUS_CANCELLED = "cancelled"

    // --- Bid statuses ---
    const val BID_STATUS_PENDING   = "pending"
    const val BID_STATUS_ACCEPTED  = "accepted"
    const val BID_STATUS_REJECTED  = "rejected"

    // --- Preferences ---
    const val PREFS_NAME      = "fixkar_prefs"
    const val PREF_LANGUAGE   = "pref_language"
    const val PREF_USER_ROLE  = "pref_user_role"

    // --- Supported languages (ISO codes) ---
    const val LANG_ENGLISH = "en"
    const val LANG_HINDI   = "hi"
    const val LANG_MARATHI = "mr"

    // --- Business rules ---
    const val DEFAULT_SEARCH_RADIUS_KM = 10.0
    const val FREE_JOBS_PER_USER       = 3
    const val MAX_WORKERS_NOTIFIED     = 50
}
