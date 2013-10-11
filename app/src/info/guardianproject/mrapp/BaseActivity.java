package info.guardianproject.mrapp;

import org.holoeverywhere.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class BaseActivity extends Activity {
	
	private static DrawerLayout sDrawerLayout;
	private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
	
    @Override
	public void setContentView(int layoutResId) {
	
    	super.setContentView(R.layout.activity_base);	
    	mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_wrapper);
    	View childLayout = getLayoutInflater().inflate(layoutResId);
    	
    	mDrawerLayout.addView(childLayout, 0);
    	
    	initNavigationDrawer();
    	
    	//FIXME Need to change when updating the UI (see full description in NavigationDrawerFragment.closeNavDrawer)
    	closeNavDrawer();
    	sDrawerLayout = mDrawerLayout;
    	
    	switch (layoutResId) {
        case R.layout.activity_home:
        case R.layout.activity_projects:
        case R.layout.activity_lessons:
        	mDrawerToggle.setDrawerIndicatorEnabled(true);
            break;
        default:
        	mDrawerToggle.setDrawerIndicatorEnabled(false);
            break;
            
    	}
	} 
    public static void closeNavDrawer()
    {
    	if(sDrawerLayout != null) {
    		sDrawerLayout.closeDrawers();
    		sDrawerLayout.invalidate();
    	}
    }
    
	private void initNavigationDrawer() {
		
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer_white,  /* nav drawer image to replace 'Up' caret */
                R.string.nav_drawer_open,  /* "open drawer" description for accessibility */
                R.string.nav_drawer_close /* "close drawer" description for accessibility */
                ) {
        	
            public void onDrawerClosed(View view) {
                supportInvalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
            
            public void onDrawerOpened(View drawerView) {
            	supportInvalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
    
        mDrawerLayout.setDrawerListener(mDrawerToggle);  
        // enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        //return super.onPrepareOptionsMenu(menu);
    	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
       if (mDrawerToggle.onOptionsItemSelected(Utils.convertABSMenuItemToStock(item))) {
           return true;
       }

       return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    
    @Override
    public void onBackPressed() {
    	closeNavDrawer();
        super.onBackPressed();
    }
}
