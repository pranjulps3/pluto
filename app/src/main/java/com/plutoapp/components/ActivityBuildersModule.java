package com.plutoapp.components;

import com.plutoapp.BaseActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract BaseActivity contributeBaseActivity();
}
