package ad.sample;

import java.util.Locale;
import android.os.Bundle;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

// ①画面を表すクラスを拡張してアプリケーションとする
public class MainActivity extends Activity {
	TextToSpeech tts;
	Button bt;

	@Override // ②画面を起動したときに呼び出されるメソッドを記述する
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);        

		// ③レイアウトを作成する
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		setContentView(ll);

		// ④ビューを作成
		bt = new Button(this);
		bt.setText("Hello World!!");

		// ⑤レイアウトにビューを追加する
		ll.addView(bt);

		// TextToSpeechクラスのインスタンス作成
		tts = new TextToSpeech(getApplicationContext(),
				new SampleInitListener());
		// 言語を英国英語の設定
		tts.setLanguage(Locale.ENGLISH);

		// ボタンをクリックしたときに、SampleClickListener()クラスを呼ぶ
		bt.setOnClickListener(new SampleClickListener());
	}

	// ボタンをクリックしたときに呼び出されるクラス
	class SampleClickListener implements OnClickListener {
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			String str = bt.getText().toString();
			if (str != null) {
				// テキストの読み上げ
				tts.speak(str, TextToSpeech.QUEUE_FLUSH, null);
			}			
		}
	}

	// 初期化時に呼び出される
	class SampleInitListener implements OnInitListener {
		@Override
		public void onInit(int arg0) {
			// TODO Auto-generated method stub
		}
	}
}
