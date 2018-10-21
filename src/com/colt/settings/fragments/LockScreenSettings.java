/*
 * Copyright (C) 2017 ColtOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.colt.settings.fragments;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import android.support.v14.preference.SwitchPreference;
import android.provider.Settings;

import com.android.internal.logging.nano.MetricsProto;
//import com.android.settings.development.DevelopmentSettings;
import com.android.settings.SettingsPreferenceFragment;

import com.colt.settings.R;

public class LockScreenSettings extends SettingsPreferenceFragment {

	public static final String TAG = "LockScreenSettings";

        @Override
        public void onCreate(Bundle savedInstanceState) {
    	    super.onCreate(savedInstanceState);

        Context mContext = getActivity().getApplicationContext();

        addPreferencesFromResource(R.xml.lockscreen_settings);
	}

    @Override
    public int getMetricsCategory() {
	return MetricsProto.MetricsEvent.COLT;
    }
}
