package info.guardianproject.mrapp.publish;

import info.guardianproject.mrapp.model.Job;
import org.holoeverywhere.app.Activity;

import android.content.Context;

// TODO should these vanish and have FacebookUploader et all just derive from JobBase directly?
public class RendererBase extends JobBase {
    private final String TAG = "RendererBase";
    
    protected RendererBase(Context context, WorkerBase worker, Job job) {
        super(context, worker, job);
        // TODO Auto-generated constructor stub
    }
}
