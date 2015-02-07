/*
 * Copyright 2015 omskscream
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.omskscream.sked.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.omskscream.sked.R;

/**
 * @author omskscream
 */
public class MainFragment extends Fragment {

    private ProgressBar mProgressBar;
    private TextView mUpperView;
    private TextView mDownView;
    private Handler mHandler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mProgressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        mUpperView = (TextView) rootView.findViewById(R.id.txtMainUp);
        mDownView = (TextView) rootView.findViewById(R.id.txtMainDown);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mProgressBar.setVisibility(View.VISIBLE);
        mUpperView.setVisibility(View.GONE);
        mDownView.setVisibility(View.GONE);
        new Thread(new Runnable() {
            @Override
            public void run() {
//                TODO: get info from DB and counters
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //TODO: update information on screen
                        mProgressBar.setVisibility(View.GONE);
                        mUpperView.setVisibility(View.VISIBLE);
                        mDownView.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();
    }
}
