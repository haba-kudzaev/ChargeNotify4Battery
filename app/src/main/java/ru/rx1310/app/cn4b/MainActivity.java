package ru.rx1310.app.cn4b;
 
import android.annotation.NonNull;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import ru.rx1310.app.cn4b.R;

public class MainActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener { 
     
	ListView mListView;
	SharedPreferences mSharedPrefs;
	SharedPreferences.Editor mSharedPrefsEditor;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		
		// Загрузка разметки
        addPreferencesFromResource(R.layout.activity_main);
        
		// Настройка SharedPrefs
		mSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
		mSharedPrefs.registerOnSharedPreferenceChangeListener(this);
		mSharedPrefsEditor = mSharedPrefs.edit();
		
		// Убираем разделители между prefs
		mListView = findViewById(android.R.id.list);
		mListView.setDivider(null);
		
		// Настройка ActionBar'a
		getActionBar().setDisplayHomeAsUpEnabled(true); // In `OnCreate();`
		getActionBar().setHomeButtonEnabled(true);
		
    }
	
	// Обработка нажатий на prefs
	public boolean onPreferenceTreeClick(PreferenceScreen prefScreen, Preference pref) {

		switch (pref.getKey()) {

			case "":
				
				break;

			default: break;

		}

		return super.onPreferenceTreeClick(prefScreen, pref);

	}

	// Обработка изменений в SharedPrefs
	@Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPrefs, String key) {

		/*if (key.equals("")) {
		 //
		 }*/

	}
	
	// Обработка нажатия кнопки Back в ActionBar
	@Override 
	public boolean onNavigateUp() { 
		finish(); 
		return true; 
	}
	
	// Создаю меню
	@Override
    public boolean onCreateOptionsMenu(Menu mMenu) {
		
        getMenuInflater().inflate(R.menu.main, mMenu);
		
        return super.onCreateOptionsMenu(mMenu);
		
    }
	
	// Обработка нажатий пунктов в меню
	@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem mMenuItem) {
		
        switch (mMenuItem.getItemId()){

            case R.id.test:
                // action
                break;

        }
		
        return super.onOptionsItemSelected(mMenuItem);
		
    }
	
} 
