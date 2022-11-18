package com.example.dpboss.Activities;

import static com.example.dpboss.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dpboss.Adapter.InfoAdapter;
import com.example.dpboss.Model.info_model;
import com.example.dpboss.R;
import com.example.dpboss.helper.ApiConfig;
import com.example.dpboss.helper.Constant;
import com.example.dpboss.helper.Session;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    TextView Phonenumber, Whatsapp ;

    InfoAdapter infoAdapter;

    Activity activity;
    Session session;
    ImageView imgTelegram,imgSupport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = MainActivity.this;
        session = new Session(activity);


        Phonenumber = findViewById(R.id.tvPhoneNumber);
        Whatsapp = findViewById(R.id.tvWhatsappNumber);
        imgTelegram = findViewById(R.id.imgTelegram);
        imgSupport = findViewById(R.id.imgSupport);



        findViewById(R.id.llWhatsappShare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWhatsApp();





            }
        });
        findViewById(R.id.llWebsite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView();
            }
        });
        
        findViewById(R.id.llHelpandSuppourt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                help_support();
            }
        });
        findViewById(R.id.llDownloadApk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(""+session.getData(Constant.APP)); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        imgTelegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(session.getData(Constant.TELEGRAM)));
                startActivity(intent);

            }
        });

        imgSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://api.whatsapp.com/send?phone="+"91"+session.getData(Constant.SUPPORT);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);


            }
        });

        
        

        recyclerview = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(linearLayoutManager);
        settings_info();
    }

    private void settings_info()
    {


        Map<String, String> params = new HashMap<>();
        ApiConfig.RequestToVolley((result, response) -> {

            Log.d("res",response);

            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        session.setData(Constant.CONTACT,jsonArray.getJSONObject(0).getString(Constant.CONTACT));
                        session.setData(Constant.WHATSAPP,jsonArray.getJSONObject(0).getString(Constant.WHATSAPP));
                        session.setData(Constant.WEB,jsonArray.getJSONObject(0).getString(Constant.WEB));
                        session.setData(Constant.APP,jsonArray.getJSONObject(0).getString(Constant.APP));
                        session.setData(Constant.SUPPORT,jsonArray.getJSONObject(0).getString(Constant.SUPPORT));
                        session.setData(Constant.TELEGRAM,jsonArray.getJSONObject(0).getString(Constant.TELEGRAM));

                        JSONArray jsonArray2 = jsonObject.getJSONArray(Constant.DASHBOARD_LIST);
                        Gson g = new Gson();
                        ArrayList<info_model> info_models = new ArrayList<>();
                        for (int i = 0; i < jsonArray2.length(); i++) {
                            JSONObject jsonObject1 = jsonArray2.getJSONObject(i);
                            if (jsonObject1 != null) {
                                info_model group = g.fromJson(jsonObject1.toString(), info_model.class);
                                info_models.add(group);
                            } else {
                                break;
                            }
                        }


                        infoAdapter = new InfoAdapter(this,info_models);
                        recyclerview.setAdapter(infoAdapter);


                    }

                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, activity, Constant.SETTING_URL, params,true);



    }
    
    
    

    private void help_support() {
        String url = "https://api.whatsapp.com/send?phone="+"91"+session.getData(Constant.CONTACT);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);


    }


    private void openWhatsApp() {

        String url = "https://api.whatsapp.com/send?phone="+"91"+session.getData(Constant.WHATSAPP);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);


    }

    private void webView() {


        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(""+session.getData(Constant.WEB)));
        startActivity(intent);
    }


}