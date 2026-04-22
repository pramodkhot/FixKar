package com.fixkar.app.core

/**
 * Standard wrapper for async operation results.
 *
 * Using a sealed class means the compiler forces you to handle every state
 * in a `when` block — no silent missed cases.
 *
 * Usage:
 *   when (val r = repo.getUser()) {
 *       is Result.Loading -> showSpinner()
 *       is Result.Success -> show(r.data)
 *       is Result.Error   -> showError(r.message)
 *   }
 */
sealed class Result<out T> {
    data object Loading : Result<Nothing>()
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val message: String, val throwable: Throwable? = null) : Result<Nothing>()
}
