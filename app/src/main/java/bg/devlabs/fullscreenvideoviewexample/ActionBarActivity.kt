package bg.devlabs.fullscreenvideoviewexample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import bg.devlabs.fullscreenvideoview.orientation.LandscapeOrientation
import bg.devlabs.fullscreenvideoview.orientation.PortraitOrientation
import kotlinx.android.synthetic.main.activity_action_bar.*

/**
 * Created by Slavi Petrov on 13.10.2017
 * Dev Labs
 * slavi@devlabs.bg
 */
class ActionBarActivity : AppCompatActivity() {
    companion object {
        fun start(context: Context) {
            val starter = Intent(context, ActionBarActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_bar)

        // Change the ActionBar title
        supportActionBar?.title = getString(R.string.action_bar_activity)
        val videoPath = "http://clips.vorwaerts-gmbh.de/VfE_html5.mp4"

        fullscreenVideoView.build(videoPath)
                .exitFullscreenDrawable(
                        ContextCompat.getDrawable(this, R.drawable.ic_launcher_background))
                .enterFullscreenDrawable(
                        ContextCompat.getDrawable(this, R.drawable.ic_pause_white_48dp))
                .progressBarColor(R.color.colorAccent)
                .isAutoStartEnabled(true)
                .landscapeOrientation(LandscapeOrientation.SENSOR)
                .portraitOrientation(PortraitOrientation.PORTRAIT)
                .canSeekBackward(false)
    }
}