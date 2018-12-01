package com.colt.settings.preferences;

 import android.content.Context;
 import android.content.res.TypedArray;
 import android.util.AttributeSet;

 public class SecureSettingSeekBarPreference extends CustomSeekBarPreference {

     public SecureSettingSeekBarPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
         super(context, attrs, defStyleAttr, defStyleRes);
         setPreferenceDataStore(new SecureSettingsStore(context.getContentResolver()));
     }

     public SecureSettingSeekBarPreference(Context context, AttributeSet attrs, int defStyle) {
         super(context, attrs, defStyle);
         setPreferenceDataStore(new SecureSettingsStore(context.getContentResolver()));
     }

     public SecureSettingSeekBarPreference(Context context, AttributeSet attrs) {
         super(context, attrs);
         setPreferenceDataStore(new SecureSettingsStore(context.getContentResolver()));
     }

     public SecureSettingSeekBarPreference(Context context) {
         super(context, null);
         setPreferenceDataStore(new SecureSettingsStore(context.getContentResolver()));
     }

     @Override
     protected Object onGetDefaultValue(TypedArray ta, int index) {
         return super.onGetDefaultValue(ta, index);
     }
 }


