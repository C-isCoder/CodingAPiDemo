package demo.codingapi.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.codingapi.android.config.Configuration;
import com.codingapi.android.config.IConfiguration;
import demo.codingapi.android.image.ImageActivity;
import demo.codingapi.android.logger.LoggerActivity;
import demo.codingapi.android.printer.PrinterActivity;

public class MainActivity extends Activity implements IConfiguration {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initConfig();
    }

    private void initConfig() {
        Configuration.init(this);
    }

    public void printer(View view) {
        startActivity(new Intent(this, PrinterActivity.class));
    }

    public void logger(View view) {
        startActivity(new Intent(this, LoggerActivity.class));
    }

    public void image(View view) {
        startActivity(new Intent(this, ImageActivity.class));
    }

    @Override
    public String getApiDefaultHost() {
        return null;
    }

    @Override
    public String getApiWebView() {
        return null;
    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }

    @Override
    public String getApiUploadImage() {
        return null;
    }

    @Override
    public String getApiLoadImage() {
        return "https://images.unsplash.com/";
    }

    @Override
    public String getToken() {
        return null;
    }

    @Override
    public String getApiDownload() {
        return null;
    }

    @Override
    public String getApiUpload() {
        return null;
    }

    @Override
    public void refreshToken() {

    }

    @Override
    public int getAppBarColor() {
        return 0;
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}
