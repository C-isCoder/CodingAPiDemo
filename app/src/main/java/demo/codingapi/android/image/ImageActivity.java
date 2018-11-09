package demo.codingapi.android.image;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.codingapi.android.library.image.Image;
import demo.codingapi.android.R;

public class ImageActivity extends Activity {
    ImageView ivNormal;
    ImageView ivCircle;
    ImageView ivRound;
    ImageView ivAuto;
    ImageView ivDownload;
    TextView tvDownload;
    FrameLayout flLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        setTitle(R.string.image_load);
        ivNormal = findViewById(R.id.ivNormal);
        ivCircle = findViewById(R.id.ivCircle);
        ivRound = findViewById(R.id.ivRound);
        ivAuto = findViewById(R.id.ivAuto);
        ivDownload = findViewById(R.id.ivDownload);
        tvDownload = findViewById(R.id.tvDownload);
        flLayout = findViewById(R.id.flLayout);

        normal();
        circle();
        round();
        auto();
        layout();
    }

    public void normal() {
        Image.load("photo-1541631706300-676537664e86", ivNormal);
        //Image.load("https://images.unsplash.com/", ivNormal);
        Glide.with(this).load("https://images.unsplash.com/photo-1541631706300-676537664e86")
                .into(ivNormal);
    }

    public void circle() {
    }

    public void round() {
    }

    public void auto() {
    }

    public void layout() {
    }

    public void download(View view) {
    }
}
