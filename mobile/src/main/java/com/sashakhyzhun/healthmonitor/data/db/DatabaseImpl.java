package com.sashakhyzhun.healthmonitor.data.db;

import android.content.Context;

import com.sashakhyzhun.healthmonitor.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DatabaseImpl {

    @Inject
    public DatabaseImpl(@ApplicationContext Context context) {
        // constructor for superclass
    }


}
