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
            {R.raw.kaaris_p, "P*TEUH"},
            {R.raw.kaaris_tchoin, "Tchoin"},
            {R.raw.trapairhorn, "Horn"},
            {R.raw.bresil, "Bresil"},
            {R.raw.chevilles, "Heenok"},
            {R.raw.john_cena, "John Cena"},
            {R.raw.gta, "Wasted"},
            {R.raw.tequila, "Tequila"},
            {R.raw.kaaris_clique, "Clique"},
            {R.raw.shanana, "Shanana"},
            {R.raw.ah, "AH!"},
            {R.raw.alerte_aux_gogoles, "Alerte aux gogoles!"},
            {R.raw.ba_dum_tss, "Ba Dum Tss"},
            {R.raw.bruh, "Bruh!"},
            {R.raw.damnn, "DAMMMN!"},
            {R.raw.fus_ro_dah, "Fus Ro Dah"},
            {R.raw.ha_gay, "AH GAAY!"},
            {R.raw.i_am_the_one, "I am the one"},
            {R.raw.illuminati, "Illuminati!"},
            {R.raw.money_gangster, "Money Gangster"},
            {R.raw.non, "Non"},
            {R.raw.okay, "OKAY!"},
            {R.raw.really_nigga, "Really Nigga ?"},
            {R.raw.run, "RUN"},
            {R.raw.suprise_mother_fucker, "Surprise"},
            {R.raw.this_is_sparta, "This is Sparta!"},
            {R.raw.lezarman, "Lezarman"}
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
                playSound((int) content[position][0]);
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

    @Override
    public void onRestart(){
        super.onRestart();
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
