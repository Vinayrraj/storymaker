package info.guardianproject.mrapp.publish.sites;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import info.guardianproject.mrapp.model.Job;
import info.guardianproject.mrapp.model.Project;
import info.guardianproject.mrapp.model.PublishJob;
import info.guardianproject.mrapp.publish.UploaderBase;
import info.guardianproject.mrapp.publish.WorkerBase;
import io.scal.secureshareui.controller.FlickrSiteController;
import io.scal.secureshareui.controller.SiteController;

public class FlickrUploader extends UploaderBase {
    private final String TAG = "FlickrUploader";
    
    public FlickrUploader(Context context, WorkerBase worker, Job job) {
        super(context, worker, job);
    }

    @Override
    public void start() {
        Log.d(TAG, "start()");
        
        final SiteController controller = SiteController.getPublishController(FlickrSiteController.SITE_KEY, mContext, null, ""+mJob.getId());
        final Project project = mJob.getProject();
        final PublishJob publishJob = mJob.getPublishJob();
        final String path = publishJob.getLastRenderFilePath();
        if (path != null) {
            Handler mainHandler = new Handler(mContext.getMainLooper());
            Runnable myRunnable = new Runnable() {
                @Override
                public void run() {
                    Log.d(TAG, "run()");
                    controller.upload(project.getTitle(), project.getDescription(), path, null, null); // FIXME, this might not be wise with flickr, does the flickr SDK automatically run itself on a backgroundthread?
                }
            };
            mainHandler.post(myRunnable);
        } else {
            Log.e(TAG, "flickr upload failed, file path is null");
        }
    }
}
