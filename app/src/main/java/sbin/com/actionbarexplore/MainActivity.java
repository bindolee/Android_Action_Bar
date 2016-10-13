package sbin.com.actionbarexplore;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.main_menu_option1:
                showToast(this, "Option 1 selected");
                break;
            case R.id.main_menu_option2:
                showToast(this, "Option 2 selected");
                break;
            case R.id.main_menu_option3:
                showToast(this, "Option 3 selected");
                break;
            case R.id.main_menu_exit:
                showToast(this, "Exit selected");
                finish();
                break;
            default:
                break;
        }
        return true;
    }

    public void showToast(Context context, CharSequence msg){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
