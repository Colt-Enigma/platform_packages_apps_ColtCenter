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

import com.android.internal.logging.nano.MetricsProto;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.content.SharedPreferences;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import android.support.v14.preference.SwitchPreference;
import android.provider.Settings;
import com.android.settings.R;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.android.internal.util.colt.ColtUtils;
import com.android.settings.SettingsPreferenceFragment;

public class RecentsSettings extends SettingsPreferenceFragment implements
        OnPreferenceChangeListener {

    private static final String RECENTS_CLEAR_ALL_LOCATION = "recents_clear_all_location";
    private static final String RECENTS_COMPONENT_TYPE = "recents_component";
    private static final String IMMERSIVE_RECENTS = "immersive_recents";
    private static final String RECENTS_DATE = "recents_full_screen_date"; 
    private static final String RECENTS_CLOCK = "recents_full_screen_clock"; 

    private ListPreference mImmersiveRecents;
    private ListPreference mRecentsClearAllLocation;
    private ListPreference mRecentsComponentType;
    private SwitchPreference mRecentsClearAll;
    private SwitchPreference mClock; 
    private SwitchPreference mDate; 

    private SharedPreferences mPreferences;
    private Context mContext;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

	mFooterPreferenceMixin.createFooterPreference()
		.setTitle(R.string.dumb_dev);

        addPreferencesFromResource(R.xml.colt_settings_recents);

        ContentResolver resolver = getActivity().getContentResolver();
	mContext = getActivity().getApplicationContext();

        // clear all recents
        mRecentsClearAllLocation = (ListPreference) findPreference(RECENTS_CLEAR_ALL_LOCATION);
        int location = Settings.System.getIntForUser(resolver,
                Settings.System.RECENTS_CLEAR_ALL_LOCATION, 3, UserHandle.USER_CURRENT);
        mRecentsClearAllLocation.setValue(String.valueOf(location));
        mRecentsClearAllLocation.setSummary(mRecentsClearAllLocation.getEntry());
        mRecentsClearAllLocation.setOnPreferenceChangeListener(this);

        // recents component type
        mRecentsComponentType = (ListPreference) findPreference(RECENTS_COMPONENT_TYPE);
        int type = Settings.System.getInt(resolver,
                Settings.System.RECENTS_COMPONENT, 0);
        mRecentsComponentType.setValue(String.valueOf(type));
        mRecentsComponentType.setSummary(mRecentsComponentType.getEntry());
        mRecentsComponentType.setOnPreferenceChangeListener(this);

	mImmersiveRecents = (ListPreference) findPreference(IMMERSIVE_RECENTS); 
	int mode = Settings.System.getInt(getContentResolver(), 
         Settings.System.IMMERSIVE_RECENTS, 0); 
             mImmersiveRecents.setValue(String.valueOf(mode)); 
        mImmersiveRecents.setSummary(mImmersiveRecents.getEntry()); 
        mImmersiveRecents.setOnPreferenceChangeListener(this); 

        mClock = (SwitchPreference) findPreference(RECENTS_CLOCK); 
         mDate = (SwitchPreference) findPreference(RECENTS_DATE); 
         updateDisablestate(mode); 
     }

     public void updateDisablestate(int mode) { 
         if (mode == 0 || mode == 2) { 
            mClock.setEnabled(false); 
            mDate.setEnabled(false); 
         } else { 
            mClock.setEnabled(true); 
            mDate.setEnabled(true); 
         } 

    }

    @Override
    public boolean onPreferenceTreeClick(Preference preference) {
        return super.onPreferenceTreeClick(preference);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object objValue) {
        if (preference == mRecentsClearAllLocation) {
	    int value = Integer.parseInt((String) objValue);
            int index = mRecentsClearAllLocation.findIndexOfValue((String) objValue);
            Settings.System.putIntForUser(getActivity().getContentResolver(),
		Settings.System.RECENTS_CLEAR_ALL_LOCATION, value, UserHandle.USER_CURRENT);
            mRecentsClearAllLocation.setSummary(mRecentsClearAllLocation.getEntries()[index]);
            return true;
        } else if (preference == mRecentsComponentType) {
            int type = Integer.valueOf((String) objValue);
            int index = mRecentsComponentType.findIndexOfValue((String) objValue);
            Settings.System.putInt(getActivity().getContentResolver(),
                    Settings.System.RECENTS_COMPONENT, type);
            mRecentsComponentType.setSummary(mRecentsComponentType.getEntries()[index]);
            if (type == 1) { // Disable swipe up gesture, if oreo type selected
               Settings.Secure.putInt(getActivity().getContentResolver(),
                    Settings.Secure.SWIPE_UP_TO_SWITCH_APPS_ENABLED, 0);
            }
            ColtUtils.showSystemUiRestartDialog(getContext());
            return true;
        }  if (preference == mImmersiveRecents) {
	   int mode = Integer.valueOf((String) objValue); 
             Settings.System.putIntForUser(getActivity().getContentResolver(), Settings.System.IMMERSIVE_RECENTS,
                     Integer.parseInt((String) objValue), UserHandle.USER_CURRENT);
             mImmersiveRecents.setValue((String) objValue);
             mImmersiveRecents.setSummary(mImmersiveRecents.getEntry());
             updateDisablestate(mode);

             mPreferences = mContext.getSharedPreferences("recent_settings", Activity.MODE_PRIVATE);
             if (!mPreferences.getBoolean("first_info_shown", false) && objValue != null) {
                 getActivity().getSharedPreferences("recent_settings", Activity.MODE_PRIVATE)
                         .edit()
                         .putBoolean("first_info_shown", true)
                         .commit();
                 openAOSPFirstTimeWarning();
             }
             return true;
        }
      return false;

    }

   private void openAOSPFirstTimeWarning() { 
         new AlertDialog.Builder(getActivity()) 
                 .setTitle(getResources().getString(R.string.aosp_first_time_title)) 
                 .setMessage(getResources().getString(R.string.aosp_first_time_message)) 
                 .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() { 
                         public void onClick(DialogInterface dialog, int whichButton) { 
                         } 
                 }).show(); 
     }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.COLT;
    }
}
