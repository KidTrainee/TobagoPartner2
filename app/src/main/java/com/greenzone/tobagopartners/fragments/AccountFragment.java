package com.greenzone.tobagopartners.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.greenzone.tobagopartners.R;
import com.greenzone.tobagopartners.activities.AccountInfoActivity;
import com.greenzone.tobagopartners.login.LoginActivity;
import com.greenzone.tobagopartners.utils.TransImage;
import com.squareup.picasso.Picasso;

public class AccountFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);

        ImageView avatar = (ImageView) view.findViewById(R.id.fragment_account_imageView_avatar);
        CardView userInfo = (CardView) view.findViewById(R.id.fragment_account_user_info);

        Picasso.with(getContext()).load(R.drawable.avt).transform(new TransImage()).into(avatar);
        avatar.setOnClickListener(this);
        userInfo.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_account_imageView_avatar:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.fragment_account_user_info:
                startActivity(new Intent(getActivity(), AccountInfoActivity.class));
                break;
        }
    }
}
