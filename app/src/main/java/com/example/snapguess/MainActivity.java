package com.example.snapguess;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.snapchat.kit.sdk.SnapLogin;
import com.snapchat.kit.sdk.core.controller.LoginStateController;
import com.snapchat.kit.sdk.login.models.MeData;
import com.snapchat.kit.sdk.login.models.UserDataResponse;
import com.snapchat.kit.sdk.login.networking.FetchUserDataCallback;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView label = (TextView) findViewById(R.id.helloworld);

        label.setText("SnapGuess");

        SnapLogin.getLoginStateController(getApplicationContext()).addOnLoginStateChangedListener(mLoginStateChangedListener);

        Button button = (Button) findViewById(R.id.login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                SnapLogin.getAuthTokenManager((Context)MainActivity.this).startTokenGrant();
                fetchUserData();
                goToNextView();

            }
        });

    }

    private void goToNextView() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    private void fetchUserData() {
        String query = "{me{bitmoji{avatar},displayName}}";

        SnapLogin.fetchUserData(this, query, null, new FetchUserDataCallback() {
            @Override
            public void onSuccess(@Nullable UserDataResponse userDataResponse) {
                if (userDataResponse == null || userDataResponse.getData() == null) {
                    return;
                }

                MeData meData = userDataResponse.getData().getMe();
                if (meData == null) {
                    return;
                }
                TextView label = (TextView) findViewById(R.id.helloworld);
                label.setText(userDataResponse.getData().getMe().getDisplayName());

                ImageView mBitmojiImageView = (ImageView) findViewById(R.id.bitmoji);

                if (meData.getBitmojiData() != null) {
                    Glide.with((Context)MainActivity.this)
                            .load(meData.getBitmojiData().getAvatar())
                            .into(mBitmojiImageView);

                    Bitmap bitImage = BitmapFactory.decodeResource(getResources(), R.id.bitmoji);
//                    bitImage.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                }
            }

            @Override
            public void onFailure(boolean b, int i) {

            }

        });
    }

    final LoginStateController.OnLoginStateChangedListener mLoginStateChangedListener =
            new LoginStateController.OnLoginStateChangedListener() {
                @Override
                public void onLoginSucceeded() {
                    System.out.println("login successful");
                }

                @Override
                public void onLoginFailed() {
                    // Here you could update UI to show login failure
                }

                @Override
                public void onLogout() {
                    // Here you could update UI to reflect logged out state
                }
            };

}
