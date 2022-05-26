package sg.edu.np.mad.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    user user = new user("zhi yuan", "year 1", 1, false);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView name = findViewById(R.id.name);
        TextView description = findViewById(R.id.description);
        Button follow = findViewById(R.id.follow);

        Button message = findViewById(R.id.message);


        Intent receivingEnd = getIntent();
        int number = receivingEnd.getIntExtra("number", 1);

        user.name += " " + number;

        name.setText(user.name);
        description.setText(user.description);
        Status();


        follow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Status();
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent messageGroup = new Intent(MainActivity.this,MessageGroup.class);
                startActivity(messageGroup);
            }
        });

    }

    public void Status(){
        Button follow = findViewById(R.id.follow);
        if (user.followed){
            follow.setText("Unfollow");
            user.followed = false;
            Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
        }
        else{
            follow.setText("Follow");
            user.followed = true;
            Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
        }
    }

}
