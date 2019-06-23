package com.example.snapguess;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaledrone.lib.Listener;
import com.scaledrone.lib.Room;
import com.scaledrone.lib.RoomListener;
import com.scaledrone.lib.Scaledrone;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameScreenActivity extends AppCompatActivity implements RoomListener {

    private String channelID = "8mghl33q4Hmx69M5";
    private String roomName = "observable-room";
    private EditText editText;
    private Scaledrone scaledrone;
//    private MessageAdapter messageAdapter;
    private TextView messagesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        Who url[] = {new Who("https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Alex.jpg?alt=media&token=60b79552-51ae-4d48-8fb5-f3873f18ae83"),
                new Who("https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Alice.jpg?alt=media&token=c3172c0d-f6b7-4170-828f-0690446b7089"),
                new Who("https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Andrew.jpg?alt=media&token=06d15ceb-2f76-4bdd-b41e-5ed38176aa93"),
                new Who("https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Anna.jpg?alt=media&token=0f6bc399-92c1-4a19-8efc-7ec102221e98"),
                new Who("https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Gerry.jpg?alt=media&token=f7d34a7c-dbbe-4488-b087-4d806208f86f"),
                new Who("https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Harry.jpg?alt=media&token=cd8f9f9a-ed62-4627-95e0-a8de14a275bf"),
                new Who("https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Jeff.jpg?alt=media&token=1448b81d-5980-44f9-890e-48f9c0f2c7a0"),
                new Who("https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Jenn.jpg?alt=media&token=c8ab6119-7ef6-4e6d-9248-3b625a2d09f3"),
                new Who("https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/John.jpg?alt=media&token=b4aac627-0e21-4823-bf86-e9f8a21274b8"),
                new Who("https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Josh.jpg?alt=media&token=10859aeb-27b1-4f23-982d-544238772afd"),
                new Who("https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Julie.jpg?alt=media&token=41bc0171-904a-4985-8f39-a0b28c2362fe"),
                new Who("https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Kristie.jpg?alt=media&token=10cef14f-d963-40a0-a209-a9ed329a5665"),
                new Who("https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Mohamad.jpg?alt=media&token=1c739428-933b-48df-8b02-a0c7e3c95fa0"),
                new Who("https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Stacey.jpg?alt=media&token=e61059cb-7c39-44dc-bbd7-d1928877bf1c"),
                new Who("https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Tobe.jpg?alt=media&token=f4bc8409-fa69-4d8a-907e-81bedb110ee1"),
                new Who("https://firebasestorage.googleapis.com/v0/b/snapguess-6567a.appspot.com/o/Umar.jpg?alt=media&token=7997c1a8-5af4-4a98-8151-692ec6565c92")
        };

        List<Who> strList = Arrays.asList(url);
        Collections.shuffle(strList);
        url = strList.toArray(new Who[strList.size()]);

        editText = (EditText) findViewById(R.id.edddit);
        messagesView = (TextView) findViewById(R.id.messages);

        MemberData data = new MemberData(getRandomName(), getRandomColor());

        scaledrone = new Scaledrone(channelID, data);
        scaledrone.connect(new Listener() {
            @Override
            public void onOpen() {
                System.out.println("Scaledrone connection open");
                scaledrone.subscribe(roomName, GameScreenActivity.this);
            }

            @Override
            public void onOpenFailure(Exception ex) {
                System.err.println(ex);
            }

            @Override
            public void onFailure(Exception ex) {
                System.err.println(ex);
            }

            @Override
            public void onClosed(String reason) {
                System.err.println(reason);
            }
        });

        final ImageView one=(ImageView) findViewById(R.id.one);
        Glide.with(getApplicationContext()).load(url[0].getUrl()).into(one);
        final ImageView two=(ImageView) findViewById(R.id.two);
        Glide.with(getApplicationContext()).load(url[1].getUrl()).into(two);
        final ImageView three=(ImageView) findViewById(R.id.three);
        Glide.with(getApplicationContext()).load(url[2].getUrl()).into(three);
        final ImageView four=(ImageView) findViewById(R.id.four);
        Glide.with(getApplicationContext()).load(url[3].getUrl()).into(four);
        final ImageView five=(ImageView) findViewById(R.id.five);
        Glide.with(getApplicationContext()).load(url[4].getUrl()).into(five);
        final ImageView six=(ImageView) findViewById(R.id.six);
        Glide.with(getApplicationContext()).load(url[5].getUrl()).into(six);
        final ImageView seven=(ImageView) findViewById(R.id.seven);
        Glide.with(getApplicationContext()).load(url[6].getUrl()).into(seven);
        final ImageView eight=(ImageView) findViewById(R.id.eight);
        Glide.with(getApplicationContext()).load(url[7].getUrl()).into(eight);
        final ImageView nine=(ImageView) findViewById(R.id.nine);
        Glide.with(getApplicationContext()).load(url[8].getUrl()).into(nine);
        final ImageView ten=(ImageView) findViewById(R.id.ten);
        Glide.with(getApplicationContext()).load(url[9].getUrl()).into(ten);
        final ImageView eleven=(ImageView) findViewById(R.id.eleven);
        Glide.with(getApplicationContext()).load(url[10].getUrl()).into(eleven);
        final ImageView twelve=(ImageView) findViewById(R.id.twelve);
        Glide.with(getApplicationContext()).load(url[11].getUrl()).into(twelve);
        final ImageView thirteen=(ImageView) findViewById(R.id.thirteen);
        Glide.with(getApplicationContext()).load(url[12].getUrl()).into(thirteen);
        final ImageView fourteen=(ImageView) findViewById(R.id.fourteen);
        Glide.with(getApplicationContext()).load(url[13].getUrl()).into(fourteen);
        final ImageView fifteen=(ImageView) findViewById(R.id.fifteen);
        Glide.with(getApplicationContext()).load(url[14].getUrl()).into(fifteen);
        final ImageView sixteen=(ImageView) findViewById(R.id.sixteen);
        Glide.with(getApplicationContext()).load(url[15].getUrl()).into(sixteen);


        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(15);

        final ImageView chosen_one = (ImageView) findViewById(R.id.guesswho);
        Glide.with(getApplicationContext()).load(url[randomInt].getUrl()).into(chosen_one);
        System.out.println("gatorade" + (url[randomInt].getName()));

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

    public void sendMessage(View view) {
        String message = editText.getText().toString();
        if (message.length() > 0) {
            scaledrone.publish(roomName, message);
            editText.getText().clear();
        }
    }

    @Override
    public void onOpen(Room room) {
        System.out.println("Conneted to room");
    }

    @Override
    public void onOpenFailure(Room room, Exception ex) {
        System.err.println(ex);
    }

    @Override
    public void onMessage(Room room, com.scaledrone.lib.Message receivedMessage) {
        final ObjectMapper mapper = new ObjectMapper();
        final String message2 = "";
        try {
            final MemberData data = mapper.treeToValue(receivedMessage.getMember().getClientData(), MemberData.class);
            boolean belongsToCurrentUser = receivedMessage.getClientID().equals(scaledrone.getClientID());
            final Message message = new Message(receivedMessage.getData().asText(), data, belongsToCurrentUser);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    /*String msg = "";
                    if (message.getText().indexOf(0) =='A')
                    {
                         msg = message.getText().substring(1, message.getText().length()-1);

                    } else if (message.getText().indexOf(0) =='B'){
                        msg = "";
                    }*/
                    messagesView.setText(message.getText());
                }
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private String getRandomName() {
        String[] adjs = {"autumn", "hidden", "bitter", "misty", "silent", "empty", "dry", "dark", "summer", "icy", "delicate", "quiet", "white", "cool", "spring", "winter", "patient", "twilight", "dawn", "crimson", "wispy", "weathered", "blue", "billowing", "broken", "cold", "damp", "falling", "frosty", "green", "long", "late", "lingering", "bold", "little", "morning", "muddy", "old", "red", "rough", "still", "small", "sparkling", "throbbing", "shy", "wandering", "withered", "wild", "black", "young", "holy", "solitary", "fragrant", "aged", "snowy", "proud", "floral", "restless", "divine", "polished", "ancient", "purple", "lively", "nameless"};
        String[] nouns = {"waterfall", "river", "breeze", "moon", "rain", "wind", "sea", "morning", "snow", "lake", "sunset", "pine", "shadow", "leaf", "dawn", "glitter", "forest", "hill", "cloud", "meadow", "sun", "glade", "bird", "brook", "butterfly", "bush", "dew", "dust", "field", "fire", "flower", "firefly", "feather", "grass", "haze", "mountain", "night", "pond", "darkness", "snowflake", "silence", "sound", "sky", "shape", "surf", "thunder", "violet", "water", "wildflower", "wave", "water", "resonance", "sun", "wood", "dream", "cherry", "tree", "fog", "frost", "voice", "paper", "frog", "smoke", "star"};
        return (
                adjs[(int) Math.floor(Math.random() * adjs.length)] +
                        "_" +
                        nouns[(int) Math.floor(Math.random() * nouns.length)]
        );
    }

    private String getRandomColor() {
        Random r = new Random();
        StringBuffer sb = new StringBuffer("#");
        while(sb.length() < 7){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, 7);
    }
}

class MemberData {
    private String name;
    private String color;

    public MemberData(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public MemberData() {
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "MemberData{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
