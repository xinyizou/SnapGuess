package com.example.snapguess;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.google.protobuf.Any;
import com.snapchat.kit.sdk.SnapLogin;
import com.snapchat.kit.sdk.core.controller.LoginStateController;
import com.snapchat.kit.sdk.login.models.MeData;
import com.snapchat.kit.sdk.login.models.UserDataResponse;
import com.snapchat.kit.sdk.login.networking.FetchUserDataCallback;

import org.w3c.dom.Text;

import java.util.Map;

import static java.security.AccessController.getContext;

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
//                goToNextView();

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

//    private class LoginActivity implements LoginStateController.OnLoginStateChangedListener {
//        @Override
//        public void onLoginSucceeded() {
//
//        }
//
//        @Override
//        public void onLoginFailed() {
//
//        }
//
//        @Override
//        public void onLogout() {
//
//        }
//    }

}
