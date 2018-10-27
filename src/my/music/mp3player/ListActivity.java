package my.music.mp3player;
import my.music.mp3player.R;
import java.util.List;

import my.music.mp3player.MusicAdapter;
import my.music.mp3player.Music;
import my.music.mp3player.MusicList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends Activity {

	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listmusic);
		
		listView= (ListView) this.findViewById(R.id.listAllMusic);
		List<Music> listMusic=MusicList.getMusicData(getApplicationContext());
		if(listMusic != null && listMusic.size() > 0){
			MusicAdapter adapter=new MusicAdapter(this, listMusic);
			listView.setAdapter(adapter);
			listView.setOnItemClickListener(new OnItemClickListener() {

				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(ListActivity.this,
							MusicActivity.class);
					intent.putExtra("id", arg2);
					startActivity(intent);
				}
			});
		}else{
			Toast.makeText(this, "当前没有音乐", 0);
		}
		
	}
}
