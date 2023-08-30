package com.example.csv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.tensorflow.lite.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//import org.tensorflow.lite.Interpreter;

public class MainActivity extends AppCompatActivity {
    Button button, button2, button3, button7;
    TextView avg_hr;
    Interpreter tflite;

    CharSequence ch = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewApp = findViewById(android.R.id.content).getRootView();

        Application app = getApplication();
        Context context = app.getApplicationContext();

        AssetManager asset = context.getAssets();
        try {
            String[] list = asset.list("");
            System.out.println(list[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try{
//            MappedByteBuffer map = loadModelFile(context);
//           tflite = new Interpreter(loadModelFile(this));
//           ch = "tflite file uploaded";
//           Snackbar snack = Snackbar.make(viewApp, ch, Snackbar.LENGTH_LONG);
//           snack.setBackgroundTint(Color.parseColor("#FFBB86FC"));
//           snack.setAction("Dismiss", view -> snack.dismiss());
//           snack.show();
//        }catch (Exception e){
//            e.printStackTrace();
//            ch = "tflite failed to upload";
//            Snackbar snack2 = Snackbar.make(viewApp, ch, Snackbar.LENGTH_LONG);
//            snack2.setAction("Dismiss", view -> snack2.dismiss());
//            snack2.show();
//        }

        button = findViewById(R.id.original_button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button7 = findViewById(R.id.button4);
//        readOuraData();

//        avg_hr = findViewById(R.id.avg_hr);



        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, OuraDisplay.class);
            startActivity(intent);
        });

        button2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Oura1.class);
            startActivity(intent);
        });

        button3.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, oura3.class);
            startActivity(intent);
        });

        button7.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, oura7.class);
            startActivity(intent);
        });

    }

    private ByteBuffer loadModelFile(Activity activity) throws IOException {
        AssetFileDescriptor fileDescriptor = activity.getAssets().openFd();
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();

        return fileChannel.map(FileChannel.MapMode.READ_ONLY,
                startOffset, declaredLength);
    }

    public void onLoadButton(View view){
//        Context context = getApplicationContext();
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        this.startActivity(intent);
//        this.onDestroy();
//        int duration = Toast.LENGTH_SHORT;

//        int a = Snackbar.LENGTH_SHORT;
//        CharSequence ch = "File has been uploaded";
//        Snackbar snack = Snackbar.make(view, ch, a);
//        snack.show();
    }

/*
    private List<OuraRingData> ouraSamples = new ArrayList<>();
    private void readOuraData() {

        InputStream is = getResources().openRawResource(R.raw.data);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";
        try {

            reader.readLine();
            while ( (line = reader.readLine()) != null){
                // Split by ','
                String[] tokens = line.split(",");

                // Read data in
                OuraRingData sample = new OuraRingData();
                sample.setHR(Integer.parseInt(tokens[0]));
                sample.setReadiness(Integer.parseInt(tokens[1]));
                sample.setSleep(Integer.parseInt(tokens[2]));

                ouraSamples.add(sample);

                Log.d("Activity", "Just created: " + sample);
            }
        }catch (IOException e){
            Log.wtf("Activty", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }

    }
    public void onButtonClick(View view){

    }
*/

}