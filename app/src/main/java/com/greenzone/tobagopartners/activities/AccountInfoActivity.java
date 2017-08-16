package com.greenzone.tobagopartners.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.greenzone.tobagopartners.R;
import com.greenzone.tobagopartners.utils.TransImage;
import com.squareup.picasso.Picasso;

public class AccountInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        ImageView avatar = (ImageView) findViewById(R.id.activity_account_info_avatar);
        Picasso.with(this).load(R.drawable.avt).transform(new TransImage()).into(avatar);
    }
}
