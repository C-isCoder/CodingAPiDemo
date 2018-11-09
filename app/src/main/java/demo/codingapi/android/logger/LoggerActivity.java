package demo.codingapi.android.logger;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.codingapi.android.library.logger.CodingAPILogger;
import demo.codingapi.android.R;
import java.util.Map;

public class LoggerActivity extends Activity {
    TextView tvContent;
    TextView tvDebug;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logger);
        setTitle(R.string.logger);
        tvContent = findViewById(R.id.tvContent);
        tvDebug = findViewById(R.id.tvDebug);
        tvResult = findViewById(R.id.tvResult);
        init();
    }

    private void init() {
        // logger 初始化
        CodingAPILogger.init(this, "http://www.congxiaodan.cn:3000/logupload");
        // 开启 debug
        CodingAPILogger.setDebugMode();
    }

    public void write(View view) {
        CodingAPILogger.write(CodingAPILogger.TYPE.ERROR, "TAG", "即将原地爆炸。。。。");
        try {
            Thread.sleep(500);
            refresh();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void upload(View view) {
        // 上传当天日志
        CodingAPILogger.upload();
        // 某些一天
        //CodingAPILogger.upload(new String[] { "2018-11-08" ,"2018-11-07"});
        // 某一天
        //CodingAPILogger.upload("2018-11-08");
        // 全部
        //CodingAPILogger.uploadAll();
    }

    @SuppressLint("SetTextI18n") public void debug(View view) {
        CodingAPILogger.d("TAG", "Log.d(TAG,message);");
        CodingAPILogger.d("Log.d(TAG,message);");
        CodingAPILogger.i("TAG", "Log.i(TAG,message);");
        CodingAPILogger.i("Log.i(TAG,message);");
        CodingAPILogger.e("TAG", "Log.e(TAG,message);");
        CodingAPILogger.e("TAG", "Log.e(TAG,message,throwable);", new Throwable("错误日志测试，少年莫慌。"));
        CodingAPILogger.e("Log.e(TAG,message,throwable);", new Throwable("错误日志测试，少年莫慌。"));
        CodingAPILogger.w("Log.w(TAG,message);");
        CodingAPILogger.w("TAG", "Log.w(TAG,message);");
        tvDebug.setText("demo.codingapi.android D/TAG: Log.d(TAG,message);\n"
          + "demo.codingapi.android D/CodingAPILogger: Log.d(TAG,message);\n"
          + "demo.codingapi.android I/TAG: Log.i(TAG,message);\n"
          + "demo.codingapi.android I/CodingAPILogger: Log.i(TAG,message);\n"
          + "demo.codingapi.android E/TAG: Log.e(TAG,message);\n"
          + "demo.codingapi.android D/LoganThread: Logan write start\n"
          + "demo.codingapi.android E/TAG: Log.e(TAG,message,throwable);\n"
          + "    java.lang.Throwable: 错误日志测试，少年莫慌。\n"
          + "        at demo.codingapi.android.logger.LoggerActivity.debug(LoggerActivity.java:60)\n"
          + "        at java.lang.reflect.Method.invoke(Native Method)\n"
          + "        at android.support.v7.app.AppCompatViewInflater$DeclaredOnClickListener.onClick(AppCompatViewInflater.java:385)\n"
          + "        at android.view.View.performClick(View.java:5647)\n"
          + "        at android.view.View$PerformClick.run(View.java:22465)\n"
          + "        at android.os.Handler.handleCallback(Handler.java:754)\n"
          + "        at android.os.Handler.dispatchMessage(Handler.java:95)\n"
          + "        at android.os.Looper.loop(Looper.java:163)\n"
          + "        at android.app.ActivityThread.main(ActivityThread.java:6239)\n"
          + "        at java.lang.reflect.Method.invoke(Native Method)\n"
          + "        at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:904)\n"
          + "        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:794)\n"
          + "demo.codingapi.android D/LoganThread: Logan write start\n"
          + "demo.codingapi.android E/CodingAPILogger: Log.e(TAG,message,throwable);\n"
          + "    java.lang.Throwable: 错误日志测试，少年莫慌。\n"
          + "        at demo.codingapi.android.logger.LoggerActivity.debug(LoggerActivity.java:61)\n"
          + "        at java.lang.reflect.Method.invoke(Native Method)\n"
          + "        at android.support.v7.app.AppCompatViewInflater$DeclaredOnClickListener.onClick(AppCompatViewInflater.java:385)\n"
          + "        at android.view.View.performClick(View.java:5647)\n"
          + "        at android.view.View$PerformClick.run(View.java:22465)\n"
          + "        at android.os.Handler.handleCallback(Handler.java:754)\n"
          + "        at android.os.Handler.dispatchMessage(Handler.java:95)\n"
          + "        at android.os.Looper.loop(Looper.java:163)\n"
          + "        at android.app.ActivityThread.main(ActivityThread.java:6239)\n"
          + "        at java.lang.reflect.Method.invoke(Native Method)\n"
          + "        at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:904)\n"
          + "        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:794)\n"
          + "demo.codingapi.android W/CodingAPILogger: Log.w(TAG,message);\n"
          + "demo.codingapi.android D/LoganThread: Logan write start\n"
          + "demo.codingapi.android W/TAG: Log.w(TAG,message);\n");
    }

    private void refresh() {
        Map<String, Long> allLogs = CodingAPILogger.getLogs();
        if (allLogs == null) {
            tvContent.setText("暂无日志");
        } else {
            final StringBuilder sb = new StringBuilder();
            for (String key : allLogs.keySet()) {
                sb.append("日期: ")
                  .append(key)
                  .append(" <---> ")
                  .append("日志大小: ")
                  .append(allLogs.get(key))
                  .append("\n");
            }
            tvContent.setText(sb.toString());
        }
    }
}
