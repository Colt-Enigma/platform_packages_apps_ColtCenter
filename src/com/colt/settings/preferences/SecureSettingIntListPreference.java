package com.colt.settings.preferences;

import android.content.Context;
import android.util.AttributeSet;

public class SecureSettingIntListPreference extends SecureSettingListPreference {

    public SecureSettingIntListPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SecureSettingIntListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SecureSettingIntListPreference(Context context) {
        super(context);
    }

    @Override
    protected boolean persistString(String value) {
        return persistInt(Integer.parseInt(value));
    }

    @Override
    protected String getPersistedString(String defaultReturnValue) {
        return String.valueOf(getPersistedInt(Integer.parseInt(defaultReturnValue)));
    }

}


