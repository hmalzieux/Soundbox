package com.example.hugo.soundbox;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Home extends AppCompatActivity {
    private MediaPlayer mediaPlayer = null;
    private Object[][] content = {
            {R.drawable.kaaris1,R.raw.kaaris_p, "P*TEUH"},
            {R.drawable.kaaris2,R.raw.kaaris_tchoin, "Tchoin"},
            {R.drawable.box_default,R.raw.trapairhorn, "Horn"},
            {R.drawable.box_default,R.raw.bresil, "Bresil"},
            {R.drawable.box_default,R.raw.chevilles, "Heenok"},
            {R.drawable.box_default,R.raw.john_cena, "John Cena"},
            {R.drawable.box_default,R.raw.gta, "Wasted"},
            {R.drawable.box_default,R.raw.tequila, "Tequila"},
            {R.drawable.box_default,R.raw.kaaris_clique, "Clique"},
            {R.drawable.box_default,R.raw.shanana, "Shanana"},
            {R.drawable.box_default,R.raw.lezarman, "Lezarman"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.box);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this,content));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                playSound((int) content[position][1]);
            }
        });
    }

    @Override
    public void onPause(){
        super.onPause();
        if (mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    public void playSound(int id){
        if (mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(Home.this, id);
        mediaPlayer.start();
    }
}
