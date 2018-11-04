package com.sashakhyzhun.healthmonitor.data.db

import com.sashakhyzhun.healthmonitor.data.db.IDatabaseHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseHelper @Inject constructor(private val dbImpl: DatabaseImpl) : IDatabaseHelper {

    override fun doSomething() {
    }
}