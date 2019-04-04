/*
 * Copyright (C) 2018 ColtOS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.colt.settings.fragments;

import android.app.Activity;
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
import com.android.settings.SettingsPreferenceFragment;
import com.android.internal.util.colt.ColtUtils;

import com.android.settings.R;

public class DozeFragment extends SettingsPreferenceFragment {

    public static final String TAG = "DozeFragment";

    private static final String KEY_AMBIENT_DISPLAY_CUSTOM = "ambient_display_custom";

    private Preference mCustomDoze;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.doze_settings);
        mCustomDoze = (Preference) findPreference(KEY_AMBIENT_DISPLAY_CUSTOM);
        if (!getResources().getBoolean(com.android.internal.R.bool.config_alt_ambient_display)) {
            getPreferenceScreen().removePreference(mCustomDoze);
        }
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.COLT;
    }
}
