package info.guardianproject.mrapp;

import info.guardianproject.mrapp.server.LoginActivity;

import java.util.Date;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class NavigationDrawerFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
        View view = inflater.inflate(R.layout.fragment_drawer, container, false);      
        initNavigationDrawerListeners(view);
        
        return view;
	}
	
	private void initNavigationDrawerListeners(View view) {
		
		final BaseActivity activity = (BaseActivity) getActivity();
	
        ImageButton btnDrawerQuickCaptureVideo = (ImageButton) view.findViewById(R.id.btnDrawerQuickCaptureVideo);
        ImageButton btnDrawerQuickCapturePhoto = (ImageButton) view.findViewById(R.id.btnDrawerQuickCapturePhoto);
        ImageButton btnDrawerQuickCaptureAudio = (ImageButton) view.findViewById(R.id.btnDrawerQuickCaptureAudio);
        
        Button btnDrawerHome = (Button) view.findViewById(R.id.btnDrawerHome);
        Button btnDrawerProjects = (Button) view.findViewById(R.id.btnDrawerProjects);
        Button btnDrawerLessons = (Button) view.findViewById(R.id.btnDrawerLessons);
        Button btnDrawerAccount = (Button) view.findViewById(R.id.btnDrawerAccount);

       
        btnDrawerQuickCaptureVideo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	String dateNowStr = new Date().toLocaleString();
            	closeNavDrawer();
            	
            	Intent intent = new Intent(activity, StoryNewActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            	intent.putExtra("story_name", "Quick Story " + dateNowStr);
            	intent.putExtra("story_type", 0);
            	intent.putExtra("auto_capture", true);
                
                 activity.startActivity(intent);           
             }
        });
        
        btnDrawerQuickCapturePhoto.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	String dateNowStr = new Date().toLocaleString();
            	closeNavDrawer();
            	
            	Intent intent = new Intent(activity, StoryNewActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            	intent.putExtra("story_name", "Quick Story " + dateNowStr);
            	intent.putExtra("story_type", 2);
            	intent.putExtra("auto_capture", true);
                
                activity.startActivity(intent);           
             }
        });
        
        btnDrawerQuickCaptureAudio.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	String dateNowStr = new Date().toLocaleString();
            	closeNavDrawer();
            	
            	Intent intent = new Intent(activity, StoryNewActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            	intent.putExtra("story_name", "Quick Story " + dateNowStr);
            	intent.putExtra("story_type", 1);
            	intent.putExtra("auto_capture", true);
                
                activity.startActivity(intent);           
             }
        });
        
        btnDrawerHome.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	closeNavDrawer();
				Intent i = new Intent(activity, HomeActivity.class);
				activity.startActivity(i);
            }
        });
        
        btnDrawerProjects.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	closeNavDrawer();
            	Intent i = new Intent(activity, ProjectsActivity.class);
            	activity.startActivity(i);
            }
        });
        
        btnDrawerLessons.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	closeNavDrawer();
                Intent i = new Intent(activity, LessonsActivity.class);
                activity.startActivity(i);
            }
        });
        
        btnDrawerAccount.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	closeNavDrawer();
                Intent i = new Intent(activity, LoginActivity.class);
                activity.startActivity(i);
            }
        });
	}
	
	
	/*FIXME
	 * Need to have a single place where the drawer is called when a button is pressed,
	 * NOT have separate calls in each OnClickListener.
	 * 
	 * Doing this right now since drawerlayout UI is in a fragment instead of a ListView.
	 */
	private void closeNavDrawer() {	

	}
}
