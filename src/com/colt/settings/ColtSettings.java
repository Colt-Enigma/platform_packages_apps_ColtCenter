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

package com.colt.settings;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.preference.PreferenceScreen;
import androidx.preference.ListPreference;
import androidx.preference.SwitchPreference;
import androidx.preference.Preference;

import android.util.TypedValue;
import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Menu;
import android.view.MenuInflater;

import com.android.internal.logging.nano.MetricsProto;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

import github.com.st235.lib_expandablebottombar.ExpandableBottomBar;
import github.com.st235.lib_expandablebottombar.ExpandableBottomBarMenuItem;

import com.colt.settings.tabs.Statusbar;
import com.colt.settings.tabs.Buttons;
import com.colt.settings.tabs.Lockscreen;
import com.colt.settings.tabs.System;
import com.colt.settings.fragments.AboutTeam;

import com.android.internal.logging.nano.MetricsProto;

import com.android.settings.SettingsPreferenceFragment;
import com.colt.settings.utils.Utils;
import java.util.Random;
import android.graphics.Color;

public class ColtSettings extends SettingsPreferenceFragment {

    private static final String TAG = "ColtSettings";

    Context mContext;
    View view;
    private int mRandomColor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

        mContext = getActivity();
        Resources res = getResources();

    view = inflater.inflate(R.layout.colt, container, false);

    ActionBar actionBar = getActivity().getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.coltos_title);
        }

    ExpandableBottomBar bottomBar = view.findViewById(R.id.expandable_bottom_bar);

	Fragment statusbar = new Statusbar();
        Fragment buttons = new Buttons();
        Fragment lockscreen = new Lockscreen();
        Fragment system = new System();
	Fragment aboutteam = new AboutTeam();

	Fragment fragment = (Fragment) getFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer, statusbar);
            transaction.addToBackStack(null);
            transaction.commit();
        }

	bottomBar.addItems(mContext.getResources().getBoolean(
                R.bool.has_active_edge) ? new ExpandableBottomBarMenuItem.Builder(mContext)
                .addItem(R.id.statusbar,
                        R.drawable.statusbar_tab,
                        R.string.status_bar_tab, getRandomColor())
                .addItem(R.id.buttons,
                        R.drawable.buttons_tab,
                        R.string.button_title, getRandomColor())
                .addItem(R.id.lockscreen,
                        R.drawable.lockscreen_tab,
                        R.string.lockscreen_tab, getRandomColor())
                .addItem(R.id.system,
                        R.drawable.system_tab,
                        R.string.system_tab, getRandomColor())
		.addItem(R.id.aboutteam,
                        R.drawable.about_tab,
                        R.string.about_tab, getRandomColor())
                .build() : new ExpandableBottomBarMenuItem.Builder(mContext)
		.addItem(R.id.statusbar,
                        R.drawable.statusbar_tab,
                        R.string.status_bar_tab, getRandomColor())
                .addItem(R.id.buttons,
                        R.drawable.buttons_tab,
                        R.string.button_title, getRandomColor())
                .addItem(R.id.lockscreen,
                        R.drawable.lockscreen_tab,
                        R.string.lockscreen_tab, getRandomColor())
                .addItem(R.id.system,
                        R.drawable.system_tab,
                        R.string.system_tab, getRandomColor())
                .addItem(R.id.aboutteam,
                        R.drawable.about_tab,
                        R.string.about_tab, getRandomColor())
                .build()
        );

	bottomBar.setOnItemSelectedListener((view, menuItem) -> {
            int id = menuItem.getItemId();
            switch (id){
                case R.id.statusbar:
                    launchFragment(statusbar);
                    break;
                case R.id.buttons:
                    launchFragment(buttons);
                    break;
                case R.id.lockscreen:
                    launchFragment(lockscreen);
                    break;
                case R.id.system:
                        launchFragment(system);
                    break;
		case R.id.aboutteam:
                        launchFragment(aboutteam);
                    break;
            }
            return null;
        });

        setHasOptionsMenu(true);

	return view;
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
    }

    private void launchFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    }

    @Override
    public void onResume() {
        super.onResume();
	getRandomColor();

        view = getView();
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_UP &&
                    keyCode == KeyEvent.KEYCODE_BACK) {
                getActivity().finish();
                return true;
            }
            return false;
        });
    }

    public int getRandomColor(){
       Random rnd = new Random();
       return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    @Override public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.COLT;
    }
}

