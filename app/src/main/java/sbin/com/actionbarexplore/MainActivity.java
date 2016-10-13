package sbin.com.actionbarexplore;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
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
                showToast(this, "Display Title/Subtitle");
                setSupportActionBarTitle();
                break;
            case R.id.main_menu_option2:
                showToast(this, "Display Logo");
                setSupportActionBarLogo();
                break;
            case R.id.main_menu_option3:
                showToast(this, "Hide actionbar");
                hideActionBarTitleandSubTitleandLogo();
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

    //Set Actionbar title and subtitle
    public void setSupportActionBarTitle() {
        ActionBar action = getSupportActionBar();
        action.setDisplayShowTitleEnabled(true);
        action.setTitle("Android ActionBar");
        action.setSubtitle("Improve UI interface");
     }

    //Supposed to set logo, but it doesn't on my dislplay
    public void setSupportActionBarLogo() {
        ActionBar action = getSupportActionBar();
        //action.setDisplayShowTitleEnabled(true);
        action.setDisplayUseLogoEnabled(true);
        action.setLogo(R.drawable.pluralsight_logo_whiteback);
    }

    // Hide the title and subtitle.
    public void hideActionBarTitleandSubTitleandLogo(){
        ActionBar action = getSupportActionBar();
        action.setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            toggleActionBar();
        }
        return true;
    }

    //Toggle the actionbar .. hide <-> show and put it into touch event
    // but this doesn't overlay yet. so changed styles.xml to enable the theme overlay... but still doesn't overlay
    private void toggleActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            if (actionBar.isShowing()){
                actionBar.hide();
            }
            else{
                actionBar.show();
            }
        }
    }

    public void showToast(Context context, CharSequence msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
