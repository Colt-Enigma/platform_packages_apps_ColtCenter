package com.colt.settings.fragments;

import com.android.settings.SettingsPreferenceFragment;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import android.provider.Settings;
import android.provider.SearchIndexableResource;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.android.settings.R;

import com.colt.settings.preferences.SystemSettingSeekBarPreference;

import com.android.internal.logging.nano.MetricsProto.MetricsEvent;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settings.search.Indexable;

import java.util.List;
import java.util.Arrays;

public class GestureSettings extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener, Indexable {
    private static final String TAG = "GestureSettings";
    private static final String KEY_SWIPE_LENGTH = "gesture_swipe_length";
    private static final String KEY_SWIPE_TIMEOUT = "gesture_swipe_timeout";

    private SystemSettingSeekBarPreference mSwipeTriggerLength;
    private SystemSettingSeekBarPreference mSwipeTriggerTimeout;

    @Override
    public int getMetricsCategory() {
        return MetricsEvent.COLT;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.gesture_settings);
	ContentResolver resolver = getActivity().getContentResolver();
	mFooterPreferenceMixin.createFooterPreference().setTitle(R.string.gesture_settings_info);

	mSwipeTriggerLength = (SystemSettingSeekBarPreference) findPreference(KEY_SWIPE_LENGTH);
        int triggerLength = Settings.System.getInt(resolver, Settings.System.BOTTOM_GESTURE_SWIPE_LIMIT,
                getSwipeLengthInPixel(getResources().getInteger(com.android.internal.R.integer.nav_gesture_swipe_min_length)));
        mSwipeTriggerLength.setValue(triggerLength);
        mSwipeTriggerLength.setOnPreferenceChangeListener(this);

        mSwipeTriggerTimeout = (SystemSettingSeekBarPreference) findPreference(KEY_SWIPE_TIMEOUT);
        int triggerTimeout = Settings.System.getInt(resolver, Settings.System.BOTTOM_GESTURE_TRIGGER_TIMEOUT,
                getResources().getInteger(com.android.internal.R.integer.nav_gesture_swipe_timout));
        mSwipeTriggerTimeout.setValue(triggerTimeout);
        mSwipeTriggerTimeout.setOnPreferenceChangeListener(this);
    }

	public boolean onPreferenceChange(Preference preference, Object newValue) {
         ContentResolver resolver = getActivity().getContentResolver();
        if (preference == mSwipeTriggerLength) {
	    int value = (Integer) newValue;
            Settings.System.putInt(resolver,
                    Settings.System.BOTTOM_GESTURE_SWIPE_LIMIT, value);
            return true;
        } else if (preference == mSwipeTriggerTimeout) {
            int value = (Integer) newValue;
            Settings.System.putInt(resolver,
                    Settings.System.BOTTOM_GESTURE_TRIGGER_TIMEOUT, value);
            return true;
        }
        return true;
    }

    private int getSwipeLengthInPixel(int value) {
        return Math.round(value * getResources().getDisplayMetrics().density);
    }

}


