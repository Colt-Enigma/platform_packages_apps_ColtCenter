/*
 * Copyright © 2018 LeanOS Project
 * Date: 27.11.2018
 * Time: 21:21
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

package com.colt.settings.fragments.common;

import android.graphics.Bitmap;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ImageButton;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.settings.R;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.ArrayList;
import java.util.List;

public class AboutTeamAdapter extends RecyclerView.Adapter<AboutTeamAdapter.Holder> {
    private static final int TYPE_TEAM = R.layout.team_card;
    private static final int TYPE_HEADER = R.layout.maintainers_header;
    private static final int TYPE_MAINTAINER = R.layout.maintainer_card;

    private List<About> list = new ArrayList<>();

    private OnClickListener listener;

    public AboutTeamAdapter(List<About> list, OnClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(viewType, viewGroup, false);
        switch (viewType) {
            case TYPE_TEAM:
                return new TeamViewHolder(view, listener);
            case TYPE_HEADER:
                return new HeaderHolder(view, listener);
            default:
                return new MaintainerHolder(view, listener);
        }
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {
        viewHolder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_TEAM;
            case 1:
                return TYPE_HEADER;
            default:
                return TYPE_MAINTAINER;
        }
    }

    public abstract static class About {
    }

    public static class Header extends About {
    }

    public static class Team extends About {
        public String teamGithub;
        public String teamTelegram;
        public List<Dev> team;

        public Team(String gihub, String telegram, List<Dev> team) {
            teamGithub = gihub;
            teamTelegram = telegram;
            this.team = team;
        }
    }

    public static class Maintainer extends About {
        public Dev dev;
        public String device;

        public Maintainer(String device, Dev dev) {
            this.dev = dev;
            this.device = device;
        }
    }

    public static class Dev {
        public String devAvatarUrl;
        public String devName;
        public String devRole;
        public String devXDA;
        public String devGithub;
        public String devTelegram;

        public Dev(String devName, String devRole, String devAvatarUrl, String devXDA, String devGithub, String devTelegram) {
            this.devName = devName;
            this.devRole = devRole;
            this.devAvatarUrl = devAvatarUrl;
            this.devXDA = devXDA;
            this.devGithub = devGithub;
            this.devTelegram = devTelegram;
        }
    }

    static abstract class Holder extends RecyclerView.ViewHolder {

        public Holder(View itemView, OnClickListener listener) {
            super(itemView);
        }

        abstract void bind(About about);
    }

    static class TeamViewHolder extends Holder {
        private ImageButton teamGithub;
        private ImageButton teamTelegram;
        private ImageView ivDevAvatar;
        private TextView tvDevName;
        private TextView tvDevRole;
        private ImageButton ivDevXDA;
        private ImageButton ivDevTelegram;

        private ImageView ivDevAvatar2;
        private TextView tvDevName2;
        private TextView tvDevRole2;
        private ImageButton ivDevXDA2;
        private ImageButton ivDevTelegram2;

        private ImageView ivDevAvatar3;
        private TextView tvDevName3;
        private TextView tvDevRole3;
        private ImageButton ivDevXDA3;
        private ImageButton ivDevTelegram3;

        private ImageView ivDevAvatar4;
        private TextView tvDevName4;
        private TextView tvDevRole4;
        private ImageButton ivDevXDA4;
        private ImageButton ivDevTelegram4;

        private ImageView ivDevAvatar5;
        private TextView tvDevName5;
        private TextView tvDevRole5;
        private ImageButton ivDevXDA5;
        private ImageButton ivDevTelegram5;

        private ImageView ivDevAvatar6;
        private TextView tvDevName6;
        private TextView tvDevRole6;
        private ImageButton ivDevXDA6;
        private ImageButton ivDevTelegram6;

        private Team team;

        public TeamViewHolder(View itemView, final OnClickListener listener) {
            super(itemView, listener);
            teamGithub = itemView.findViewById(R.id.teamGithub);
            teamTelegram = itemView.findViewById(R.id.teamTelegram);
            ivDevXDA = itemView.findViewById(R.id.ivDevXDA);
            ivDevTelegram = itemView.findViewById(R.id.ivDevTelegram);
            ivDevXDA2 = itemView.findViewById(R.id.ivDevXDA2);
            ivDevTelegram2 = itemView.findViewById(R.id.ivDevTelegram2);
            ivDevXDA3 = itemView.findViewById(R.id.ivDevXDA3);
            ivDevTelegram3 = itemView.findViewById(R.id.ivDevTelegram3);
            ivDevXDA4 = itemView.findViewById(R.id.ivDevXDA4);
            ivDevTelegram4 = itemView.findViewById(R.id.ivDevTelegram4);
            ivDevXDA5 = itemView.findViewById(R.id.ivDevXDA5);
            ivDevTelegram5 = itemView.findViewById(R.id.ivDevTelegram5);
            ivDevXDA6 = itemView.findViewById(R.id.ivDevXDA6);
            ivDevTelegram6 = itemView.findViewById(R.id.ivDevTelegram6);
            ivDevAvatar = itemView.findViewById(R.id.ivDevAvatar);
            ivDevAvatar2 = itemView.findViewById(R.id.ivDevAvatar2);
            ivDevAvatar3 = itemView.findViewById(R.id.ivDevAvatar3);
            ivDevAvatar4 = itemView.findViewById(R.id.ivDevAvatar4);
            ivDevAvatar5 = itemView.findViewById(R.id.ivDevAvatar5);
            ivDevAvatar6 = itemView.findViewById(R.id.ivDevAvatar6);
            tvDevName = itemView.findViewById(R.id.tvDevName);
            tvDevName2 = itemView.findViewById(R.id.tvDevName2);
            tvDevName3 = itemView.findViewById(R.id.tvDevName3);
            tvDevName4 = itemView.findViewById(R.id.tvDevName4);
            tvDevName5 = itemView.findViewById(R.id.tvDevName5);
            tvDevName6 = itemView.findViewById(R.id.tvDevName6);
            tvDevRole = itemView.findViewById(R.id.tvDevRole);
            tvDevRole2 = itemView.findViewById(R.id.tvDevRole2);
            tvDevRole3 = itemView.findViewById(R.id.tvDevRole3);
            tvDevRole4 = itemView.findViewById(R.id.tvDevRole4);
            tvDevRole5 = itemView.findViewById(R.id.tvDevRole5);
            tvDevRole6 = itemView.findViewById(R.id.tvDevRole6);
            teamGithub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(team.teamGithub);
                }
            });
            teamTelegram.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(team.teamTelegram);
                }
            });
            ivDevXDA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(team.team.get(0).devXDA);
                }
            });
            ivDevTelegram.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(team.team.get(0).devTelegram);
                }
            });
            ivDevXDA2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(team.team.get(1).devXDA);
                }
            });
            ivDevTelegram2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(team.team.get(1).devTelegram);
                }
            });
            ivDevXDA3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(team.team.get(2).devXDA);
                }
            });
            ivDevTelegram3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(team.team.get(2).devTelegram);
                }
            });
            ivDevXDA4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(team.team.get(3).devXDA);
                }
            });
            ivDevTelegram4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(team.team.get(3).devTelegram);
                }
            });
            ivDevXDA5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(team.team.get(4).devXDA);
                }
            });
            ivDevTelegram5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(team.team.get(4).devTelegram);
                }
            });
            ivDevXDA6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(team.team.get(5).devXDA);
                }
            });
            ivDevTelegram6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(team.team.get(5).devTelegram);
                }
            });
        }

        @Override
        void bind(final About about) {
            team = (Team) about;

            tvDevName.setText(team.team.get(0).devName);
            tvDevRole.setText(team.team.get(0).devRole);
            Glide.with(itemView.getContext()).load(team.team.get(0).devAvatarUrl).asBitmap().centerCrop().into(new BitmapImageViewTarget(ivDevAvatar){
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(itemView.getContext().getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    ivDevAvatar.setImageDrawable(circularBitmapDrawable);
                }
            });

            tvDevName2.setText(team.team.get(1).devName);
            tvDevRole2.setText(team.team.get(1).devRole);
            Glide.with(itemView.getContext()).load(team.team.get(1).devAvatarUrl).asBitmap().centerCrop().into(new BitmapImageViewTarget(ivDevAvatar2){
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(itemView.getContext().getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    ivDevAvatar2.setImageDrawable(circularBitmapDrawable);
                }
            });

            tvDevName3.setText(team.team.get(2).devName);
            tvDevRole3.setText(team.team.get(2).devRole);
            Glide.with(itemView.getContext()).load(team.team.get(2).devAvatarUrl).asBitmap().centerCrop().into(new BitmapImageViewTarget(ivDevAvatar3){
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(itemView.getContext().getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    ivDevAvatar3.setImageDrawable(circularBitmapDrawable);
                }
            });

            tvDevName4.setText(team.team.get(3).devName);
            tvDevRole4.setText(team.team.get(3).devRole);
            Glide.with(itemView.getContext()).load(team.team.get(3).devAvatarUrl).asBitmap().centerCrop().into(new BitmapImageViewTarget(ivDevAvatar4){
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(itemView.getContext().getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    ivDevAvatar4.setImageDrawable(circularBitmapDrawable);
                }
            });
            tvDevName5.setText(team.team.get(4).devName);
            tvDevRole5.setText(team.team.get(4).devRole);
            Glide.with(itemView.getContext()).load(team.team.get(4).devAvatarUrl).asBitmap().centerCrop().into(new BitmapImageViewTarget(ivDevAvatar5){
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(itemView.getContext().getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    ivDevAvatar5.setImageDrawable(circularBitmapDrawable);
                }
            });
            tvDevName6.setText(team.team.get(5).devName);
            tvDevRole6.setText(team.team.get(5).devRole);
            Glide.with(itemView.getContext()).load(team.team.get(5).devAvatarUrl).asBitmap().centerCrop().into(new BitmapImageViewTarget(ivDevAvatar6){
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(itemView.getContext().getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    ivDevAvatar6.setImageDrawable(circularBitmapDrawable);
                }
            });
        }
    }

    static class HeaderHolder extends Holder {

        public HeaderHolder(View itemView, OnClickListener listener) {
            super(itemView, listener);
        }

        @Override
        void bind(About about) {
        }
    }

    static class MaintainerHolder extends Holder {
        private ImageButton ivXDA;
        private ImageButton ivDevGithub;
        private ImageView ivDevAvatar;
        private TextView tvDevName;
        private TextView tvDevice;
        private Maintainer maintainer;

        public MaintainerHolder(View itemView, final OnClickListener listener) {
            super(itemView, listener);
            ivXDA = itemView.findViewById(R.id.ivXDA);
            ivDevGithub = itemView.findViewById(R.id.ivDevGithub);
            ivDevAvatar = itemView.findViewById(R.id.ivDevAvatar);
            tvDevName = itemView.findViewById(R.id.tvDevName);
            tvDevice = itemView.findViewById(R.id.tvDevice);
            ivXDA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(maintainer.dev.devXDA);
                }
            });
            ivDevGithub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(maintainer.dev.devGithub);
                }
            });
        }

        @Override
        void bind(About about) {
            maintainer = (Maintainer) about;
            tvDevName.setText(maintainer.dev.devName);
            tvDevice.setText(maintainer.device);
            Glide.with(itemView.getContext()).load(maintainer.dev.devAvatarUrl).asBitmap().centerCrop().into(new BitmapImageViewTarget(ivDevAvatar){
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(itemView.getContext().getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    ivDevAvatar.setImageDrawable(circularBitmapDrawable);
                }
            });
        }
    }

    public interface OnClickListener {
        void OnClick(String url);
    }
}
