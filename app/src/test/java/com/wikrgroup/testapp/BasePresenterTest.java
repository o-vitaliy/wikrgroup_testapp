package com.wikrgroup.testapp;

import android.support.annotation.CallSuper;

import org.junit.After;
import org.junit.Before;

import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.schedulers.Schedulers;

/**
 * Created by Uran on 1/17/2017.
 */

public class BasePresenterTest {

    @CallSuper
    @Before
    public void setUp() throws Exception {
        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });

    }

    @CallSuper
    @After
    public void tearDown() throws Exception {
        RxAndroidPlugins.getInstance().reset();
    }

}
