package com.example.snapguess;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        String url[] = {"https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Alex.jpg?alt=media&token=60b79552-51ae-4d48-8fb5-f3873f18ae83",
                "https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Alice.jpg?alt=media&token=c3172c0d-f6b7-4170-828f-0690446b7089",
                "https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Andrew.jpg?alt=media&token=06d15ceb-2f76-4bdd-b41e-5ed38176aa93",
                "https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Anna.jpg?alt=media&token=0f6bc399-92c1-4a19-8efc-7ec102221e98",
                "https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Gerry.jpg?alt=media&token=f7d34a7c-dbbe-4488-b087-4d806208f86f",
                "https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Harry.jpg?alt=media&token=cd8f9f9a-ed62-4627-95e0-a8de14a275bf",
                "https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Jeff.jpg?alt=media&token=1448b81d-5980-44f9-890e-48f9c0f2c7a0",
                "https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Jeff.jpg?alt=media&token=1448b81d-5980-44f9-890e-48f9c0f2c7a0",
                "https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Jenn.jpg?alt=media&token=c8ab6119-7ef6-4e6d-9248-3b625a2d09f3",
                "https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/John.jpg?alt=media&token=b4aac627-0e21-4823-bf86-e9f8a21274b8",
                "https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Josh.jpg?alt=media&token=10859aeb-27b1-4f23-982d-544238772afd",
                "https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Julie.jpg?alt=media&token=41bc0171-904a-4985-8f39-a0b28c2362fe",
                "https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Kristie.jpg?alt=media&token=10cef14f-d963-40a0-a209-a9ed329a5665",
                "https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Mohamad.jpg?alt=media&token=1c739428-933b-48df-8b02-a0c7e3c95fa0",
                "https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Stacey.jpg?alt=media&token=e61059cb-7c39-44dc-bbd7-d1928877bf1c",
                "https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Tobe.jpg?alt=media&token=f4bc8409-fa69-4d8a-907e-81bedb110ee1",
                "https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Umar.jpg?alt=media&token=7997c1a8-5af4-4a98-8151-692ec6565c92"
        };

        List<String> strList = Arrays.asList(url);
        Collections.shuffle(strList);
        url = strList.toArray(new String[strList.size()]);

        final ImageView one=(ImageView) findViewById(R.id.one);

//        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("Alex.jpg");
//
//
//// Load the image using Glide
//        Glide.with(this /* context */)
//                .using(new FirebaseImageLoader())
//                .load(storageReference)
//                .into(image );
//
//        one.setImage
        Glide.with(getApplicationContext()).load(url[0]).into(one);
        final ImageView two=(ImageView) findViewById(R.id.two);
        Glide.with(getApplicationContext()).load(url[1]).into(two);
        final ImageView three=(ImageView) findViewById(R.id.three);
        final ImageView four=(ImageView) findViewById(R.id.four);
        final ImageView five=(ImageView) findViewById(R.id.five);
        final ImageView six=(ImageView) findViewById(R.id.six);
        final ImageView seven=(ImageView) findViewById(R.id.seven);
        final ImageView eight=(ImageView) findViewById(R.id.eight);
        final ImageView nine=(ImageView) findViewById(R.id.nine);
        final ImageView ten=(ImageView) findViewById(R.id.ten);
        final ImageView eleven=(ImageView) findViewById(R.id.eleven);
        final ImageView twelve=(ImageView) findViewById(R.id.twelve);
        final ImageView thirteen=(ImageView) findViewById(R.id.thirteen);
        final ImageView fourteen=(ImageView) findViewById(R.id.fourteen);
        final ImageView fifteen=(ImageView) findViewById(R.id.fifteen);
        final ImageView sixteen=(ImageView) findViewById(R.id.sixteen);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (one.getAlpha()!= 1.0f)
                {
                    one.setAlpha(1.0f);
                }
                else
                {
                    one.setAlpha(0.5f);
                }
            }

        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (two.getAlpha() != 1.0f)
                {
                    two.setAlpha(1.0f);
                }
                else
                {
                    two.setAlpha(0.5f);
                }
            }

        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (three.getAlpha() != 1.0f)
                {
                    three.setAlpha(1.0f);
                }
                else
                {
                    three.setAlpha(0.5f);
                }
            }

        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (four.getAlpha() != 1.0f)
                {
                    four.setAlpha(1.0f);
                }
                else
                {
                    four.setAlpha(0.5f);
                }
            }

        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (five.getAlpha() != 1.0f)
                {
                    five.setAlpha(1.0f);
                }
                else
                {
                    five.setAlpha(0.5f);
                }
            }

        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (six.getAlpha() != 1.0f)
                {
                    six.setAlpha(1.0f);
                }
                else
                {
                    six.setAlpha(0.5f);
                }
            }

        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (seven.getAlpha() != 1.0f)
                {
                    seven.setAlpha(1.0f);
                }
                else
                {
                    seven.setAlpha(0.5f);
                }
            }

        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (eight.getAlpha() != 1.0f)
                {
                    eight.setAlpha(1.0f);
                }
                else
                {
                    eight.setAlpha(0.5f);
                }
            }

        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (nine.getAlpha() != 1.0f)
                {
                    nine.setAlpha(1.0f);
                }
                else
                {
                    nine.setAlpha(0.5f);
                }
            }

        });

        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (ten.getAlpha() != 1.0f)
                {
                    ten.setAlpha(1.0f);
                }
                else
                {
                    ten.setAlpha(0.5f);
                }
            }

        });

        eleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (eleven.getAlpha() != 1.0f)
                {
                    eleven.setAlpha(1.0f);
                }
                else
                {
                    eleven.setAlpha(0.5f);
                }
            }

        });

        twelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (twelve.getAlpha() != 1.0f)
                {
                    twelve.setAlpha(1.0f);
                }
                else
                {
                    twelve.setAlpha(0.5f);
                }
            }

        });

        thirteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (thirteen.getAlpha() != 1.0f)
                {
                    thirteen.setAlpha(1.0f);
                }
                else
                {
                    thirteen.setAlpha(0.5f);
                }
            }

        });

        fourteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (fourteen.getAlpha() != 1.0f)
                {
                    fourteen.setAlpha(1.0f);
                }
                else
                {
                    fourteen.setAlpha(0.5f);
                }
            }

        });

        fifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (fifteen.getAlpha() != 1.0f)
                {
                    fifteen.setAlpha(1.0f);
                }
                else
                {
                    fifteen.setAlpha(0.5f);
                }
            }

        });

        sixteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (sixteen.getAlpha() != 1.0f)
                {
                    sixteen.setAlpha(1.0f);
                }
                else
                {
                    sixteen.setAlpha(0.5f);
                }
            }

        });
    }
}
