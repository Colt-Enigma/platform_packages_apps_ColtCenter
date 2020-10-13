/*
 * Copyright © 2018 LeanOS Project
 * Date: 27.11.2018
 * Time: 12:31
 * Author: @darkbeast69 <guptaaryan189@gmail.com>
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

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

import com.android.internal.logging.nano.MetricsProto;

import com.colt.settings.fragments.common.AboutTeamAdapter;
import com.colt.settings.fragments.common.AboutTeamAdapter.About;
import com.colt.settings.fragments.common.AboutTeamAdapter.Dev;
import com.colt.settings.fragments.common.AboutTeamAdapter.Team;
import com.colt.settings.fragments.common.AboutTeamAdapter.Header;
import com.colt.settings.fragments.common.AboutTeamAdapter.OnClickListener;

import java.util.ArrayList;
import java.util.List;

public class AboutTeam extends SettingsPreferenceFragment {

	private List<AboutTeamAdapter.About> list = new ArrayList<>();

	@Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.about_team, null);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //getActivity().setTitle(R.string.about_team_title);
        initList();

        RecyclerView recyclerView = getView().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new AboutTeamAdapter(list, new AboutTeamAdapter.OnClickListener() {
            @Override
            public void OnClick(String url) {
                if (!url.isEmpty()) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                }
            }
        }));
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.COLT;
    }

    private void initList() {
        List<AboutTeamAdapter.Dev> team = new ArrayList<>();
        team.add(new AboutTeamAdapter.Dev(
                "Rakesh Batra",
                "Founder | Lead Developer",
                "https://avatars3.githubusercontent.com/rakeshbatra",
                "https://forum.xda-developers.com/member.php?u=5985430",
                "https://github.com/rakeshbatra",
                "https://t.me/RakeshBatra"
        ));
	team.add(new AboutTeamAdapter.Dev(
                "Mrinal Ghosh",
                "ColtOS | Core Developer",
		"https://avatars3.githubusercontent.com/mg712702",
                "https://forum.xda-developers.com/member.php?u=7813190",
                "https://github.com/mg712702",
                "https://t.me/mg712702"
        ));
	team.add(new AboutTeamAdapter.Dev(
                "Nitinkumar Chobhe",
                "Core Team",
                "https://avatars3.githubusercontent.com/nitin1438",
                "https://forum.xda-developers.com/member.php?u=5044214",
                "https://github.com/nitin1438",
                "https://t.me/nitin1438"
        ));
        team.add(new AboutTeamAdapter.Dev(
                "Roger T",
                "Man Behind The Beautification | Core Team",
                "https://avatars3.githubusercontent.com/ROGERDOTT",
                "",
                "https://github.com/ROGERDOTT",
                "https://t.me/Roger_T"
        ));
	team.add(new AboutTeamAdapter.Dev(
                "Sujit Roy",
                "Core Team",
                "https://avatars3.githubusercontent.com/sujitroy",
                "https://forum.xda-developers.com/member.php?u=7598073",
                "https://github.com/sujitroy",
                "https://t.me/sujitroy"
        ));
	team.add(new AboutTeamAdapter.Dev(
                "Saurabh Charde",
                "Core Team",
                "https://avatars3.githubusercontent.com/saurabhchardereal",
                "https://forum.xda-developers.com/member.php?u=6626122",
                "https://github.com/saurabhchardereal",
                "https://t.me/SaurabhCharde"
        ));
        list.add(new AboutTeamAdapter.Team(
                        "https://github.com/Colt-Enigma",
                        "https://t.me/ColtEnigma",
                        team

                )
        );
        list.add(new AboutTeamAdapter.Header());
	list.add(new AboutTeamAdapter.Maintainer(
                        "Asus ZenFone Max Pro M1 (X00T/D)",
                        new AboutTeamAdapter.Dev(
                                "Saurabh Charde",
                                "",
                                "https://avatars3.githubusercontent.com/saurabhchardereal",
                                "https://forum.xda-developers.com/showthread.php?t=4004943",
                                "https://github.com/saurabhchardereal",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Asus ZenFone Max Pro M2 (X01BD)",
                        new AboutTeamAdapter.Dev(
                                "Sonal Singh",
                                "",
                                "https://avatars3.githubusercontent.com/SonalSingh18",
                                "https://forum.xda-developers.com/showthread.php?t=3951353",
                                "https://github.com/SonalSingh18",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Google Pixel 2 XL (Taimen)",
                        new AboutTeamAdapter.Dev(
                                "Nitinkumar Chobhe",
                                "",
                                "https://avatars3.githubusercontent.com/Nitin1438",
                                "https://forum.xda-developers.com/showthread.php?t=3911826",
                                "https://github.com/Nitin1438",
                                ""
                        )
                )
        );
        list.add(new AboutTeamAdapter.Maintainer(
                        "Lenovo Z6 Pro (Zippo)",
                        new AboutTeamAdapter.Dev(
                                "Einar Gednochsson",
                                "",
                                "https://avatars3.githubusercontent.com/wilmabumsson",
                                "https://forum.xda-developers.com/showthread.php?t=4128361",
                                "https://github.com/wilmabumsson",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Moto G5s Plus (Sanders)",
                        new AboutTeamAdapter.Dev(
                                "Ashwatthama",
                                "",
                                "https://avatars3.githubusercontent.com/sai4041412",
                                "https://forum.xda-developers.com/showthread.php?t=4048301",
                                "https://github.com/sai4041412",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Moto G7 (River)",
                        new AboutTeamAdapter.Dev(
                                "SamuelSouzaa",
                                "",
                                "https://avatars3.githubusercontent.com/Nyoutaaa",
                                "https://forum.xda-developers.com/showthread.php?t=4100533",
                                "https://github.com/Nyoutaaa",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Motorola Nexus 6 (Shamu)",
                        new AboutTeamAdapter.Dev(
                                "Nitinkumar Chobhe",
                                "",
                                "https://avatars3.githubusercontent.com/Nitin1438",
                                "https://forum.xda-developers.com/showthread.php?t=3709921",
                                "https://github.com/Nitin1438",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "OnePlus One (Bacon)",
                        new AboutTeamAdapter.Dev(
                                "Shab Qadri",
                                "",
                                "https://avatars3.githubusercontent.com/ShabQadri",
                                "https://forum.xda-developers.com/showthread.php?t=4033897",
                                "https://github.com/ShabQadri",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "OnePlus 3/3T",
                        new AboutTeamAdapter.Dev(
                                "Rakesh Batra",
                                "",
                                "https://avatars3.githubusercontent.com/RakeshBatra",
                                "https://forum.xda-developers.com/showthread.php?t=3971691",
                                "https://github.com/RakeshBatra",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "OnePlus 5/5T (Cheeseburger/Dumpling)",
                        new AboutTeamAdapter.Dev(
                                "Mukesh Singh",
                                "",
                                "https://avatars3.githubusercontent.com/mukesh22584",
                                "https://forum.xda-developers.com/showthread.php?t=3901221",
                                "https://github.com/mukesh22584",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "OnePlus 6T (Fajita)",
                        new AboutTeamAdapter.Dev(
                                "Ziauddin Sameer",
                                "",
                                "https://avatars3.githubusercontent.com/ziasam",
                                "https://forum.xda-developers.com/showthread.php?t=4145769",
                                "https://github.com/ziasam",
                                ""
                        )
                )
        );
        list.add(new AboutTeamAdapter.Maintainer(
                        "POCO X2/Redmi K30 (Phoenix)",
                        new AboutTeamAdapter.Dev(
                                "Chiranth Chiru",
                                "",
                                "https://avatars3.githubusercontent.com/chiru2000",
                                "https://forum.xda-developers.com/member.php?u=10100968",
                                "https://github.com/chiru2000",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Samsung Galaxy Tab Pro 8.4 (Mondrianwifi)",
                        new AboutTeamAdapter.Dev(
                                "Gigabyte",
                                "",
                                "https://avatars3.githubusercontent.com/gigabyte-1000",
                                "https://forum.xda-developers.com/showthread.php?t=4090429",
                                "https://github.com/gigabyte-1000",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Xiaomi Mi 6X (Wayne)",
                        new AboutTeamAdapter.Dev(
                                "Markdarkness",
                                "",
                                "https://avatars3.githubusercontent.com/Markdarkness",
                                "https://forum.xda-developers.com/showthread.php?t=4091681",
                                "https://github.com/Markdarkness",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Xiaomi Mi 8 Lite (Platina)",
                        new AboutTeamAdapter.Dev(
                                "Curse",
                                "",
                                "https://avatars3.githubusercontent.com/anulalat",
                                "https://forum.xda-developers.com/showthread.php?t=4133657",
                                "https://github.com/anulalat",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Xiaomi Mi A2 (Jasmine Sprout)",
                        new AboutTeamAdapter.Dev(
                                "Siddharth Bharadwaj",
                                "",
                                "https://avatars3.githubusercontent.com/SiddharthBharadwaj",
                                "https://forum.xda-developers.com/showthread.php?t=4005401",
                                "https://github.com/SiddharthBharadwaj",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Xiaomi Pocophone F1 (Beryllium)",
                        new AboutTeamAdapter.Dev(
                                "Mani Madhuri",
                                "",
                                "https://avatars3.githubusercontent.com/Joker-commits",
                                "https://forum.xda-developers.com/showthread.php?t=4081133",
                                "https://github.com/Joker-commits",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Xiaomi Redmi 7 (Onclite)",
                        new AboutTeamAdapter.Dev(
                                "Gagan Malvi",
                                "",
                                "https://avatars3.githubusercontent.com/TheAcanthite",
                                "https://forum.xda-developers.com/redmi-7/development/rom-coltos-t4063441",
                                "https://github.com/TheAcanthite",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Xiaomi Redmi 5 Plus / Note 5 (Vince)",
                        new AboutTeamAdapter.Dev(
                                "Alexandru Scurtu",
                                "",
                                "https://avatars3.githubusercontent.com/sashascurtu",
                                "https://forum.xda-developers.com/showthread.php?t=4133341",
                                "https://github.com/sashascurtu",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Xiaomi Redmi K20 Pro (Raphael)",
                        new AboutTeamAdapter.Dev(
                                "HSgod",
                                "",
                                "https://avatars3.githubusercontent.com/HSgod",
                                "https://forum.xda-developers.com/showthread.php?t=4142895",
                                "https://github.com/HSgod",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Xiaomi Redmi Note 3 Pro (Kenzo/Kate)",
                        new AboutTeamAdapter.Dev(
                                "Gigabyte",
                                "",
                                "https://avatars3.githubusercontent.com/gigabyte-1000",
                                "https://forum.xda-developers.com/showthread.php?t=4090359",
                                "https://github.com/gigabyte-1000",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Xiaomi Redmi Note 4/X (Mido)",
                        new AboutTeamAdapter.Dev(
                                "Sagar Rokade",
                                "",
                                "https://avatars3.githubusercontent.com/sagarrokade006",
                                "https://forum.xda-developers.com/redmi-note-4/xiaomi-redmi-note-4-snapdragon-roms-kernels-recoveries--other-development/rom-colt-os-4-6-enigma-mido-t3973461",
                                "https://github.com/sagarrokade006",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Xiaomi Redmi Note 5 Pro (Whyred)",
                        new AboutTeamAdapter.Dev(
                                "Ayush kakkar",
                                "",
                                "https://avatars3.githubusercontent.com/Ayush12ka",
                                "https://forum.xda-developers.com/showthread.php?t=",
                                "https://github.com/Ayush12ka",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Xiaomi Redmi Note 7 Pro (Violet)",
                        new AboutTeamAdapter.Dev(
                                "Athul Dinesan",
                                "",
                                "https://avatars3.githubusercontent.com/athul05",
                                "",
                                "https://github.com/athul05",
                                ""
                        )
                )
        );
	list.add(new AboutTeamAdapter.Maintainer(
                        "Xiaomi Redmi Note 8/8T (Ginkgo)",
                        new AboutTeamAdapter.Dev(
                                "Mrinal Ghosh",
                                "",
                                "https://avatars3.githubusercontent.com/mg712702",
                                "https://forum.xda-developers.com/redmi-note-8/development/rom-coltos-redmi-note-8-8t-t4090029",
                                "https://github.com/mg712702",
                                ""
                        )
                )
        );
    }
}
