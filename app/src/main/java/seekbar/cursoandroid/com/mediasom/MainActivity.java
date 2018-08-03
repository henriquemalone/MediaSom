package seekbar.cursoandroid.com.mediasom;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.botaoTocarId);
        mediaplayer = MediaPlayer.create(MainActivity.this, R.raw.musica);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaplayer.isPlaying()){
                    pausarMusica();
                } else {
                    tocarMusica();
                }
            }
        });
    }

    private void tocarMusica(){
        if (mediaplayer != null){
            mediaplayer.start();
            botao.setText("Pausar");
        } else {
            Toast.makeText(MainActivity.this, "Erro no arquivo de som", Toast.LENGTH_SHORT).show();
        }
    }

    private void pausarMusica(){
        if (mediaplayer != null){
            mediaplayer.pause();
            botao.setText("Tocar");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if(mediaplayer != null && mediaplayer.isPlaying()){
            mediaplayer.stop();
            mediaplayer.release();
            mediaplayer = null;
        }


        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
