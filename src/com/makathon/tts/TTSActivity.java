package com.makathon.tts;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TTSActivity extends Activity implements OnInitListener {
	private TextToSpeech mTts;
	
	private EditText edtSpeak;
	private Button btnSpeak;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        edtSpeak = (EditText)findViewById(R.id.edtSpeak);
        btnSpeak = (Button)findViewById(R.id.btnSpeak);
        
        mTts = new TextToSpeech(this, this);
        
        btnSpeak.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				say(edtSpeak.getText().toString());
			}
		});
        
    }
    
    public void say(String text2say){
    	mTts.speak(text2say, TextToSpeech.QUEUE_FLUSH, null);
    }

	@Override
	public void onInit(int status) {
		
	}
}