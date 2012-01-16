package apps.schmitzi.Zensurenverwaltung;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PreferencesActivity extends ListActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		String[] prefs = getResources().getStringArray(R.array.Preferences);
		String[] descriptions = getResources().getStringArray(R.array.PrefDescriptions);
		setListAdapter(new PrefAdapter(this, R.layout.pref_item, prefs, descriptions));
		ListView lv = getListView();
		lv.setOnItemClickListener(new OnItemClickListener(){
			

			@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				switch(position){
				case 0:
					Intent in = new Intent("apps.schmitzi.Zensurenverwaltung.SEMESTER");
					in.addCategory(Intent.CATEGORY_DEFAULT);
					startActivity(in);
				}
			}
		});
	}

	
	
	public class PrefAdapter extends ArrayAdapter<String> {

		String[] names, descriptions;
		
		public PrefAdapter(Context context, int textViewResourceId, String[] names, String[] descriptions) {
			super(context, textViewResourceId, names);
			this.names = names;
			this.descriptions = descriptions;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent){
			View v = convertView;
			if(v==null) {
				 LayoutInflater inf = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				 v = inf.inflate(R.layout.pref_item, null);
			 }
			Log.v("Zensuren1", names[position]);
			String s = names[position];
			if (s != null){
				TextView t1 = (TextView) v.findViewById(R.id.PrefTitle);
				if(t1 != null)
					t1.setText(s);
				TextView t2 = (TextView) v.findViewById(R.id.PrefDescription);
				if (t2 != null)
					t2.setText(descriptions[position]);
			}
			return v;
		}

	}
}
