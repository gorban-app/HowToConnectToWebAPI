package ru.xpcom.howtoconnecttowebapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import ru.xpcom.howtoconnecttowebapi.pojo.AllUsers;
import ru.xpcom.howtoconnecttowebapi.pojo.OneUser;

public class MainActivity extends AppCompatActivity {

    public static final String URL_API = "https://reqres.in/";
    public static final String TAG = "MainActivity";
    private TextView textFirstName, textLastName, textEmail;
    private ImageView imageAvatar;
    private PlaceholderAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = RetrofitFactory.getRetrofit(URL_API);
        api = retrofit.create(PlaceholderAPI.class);
        uiComponent();
        geSingleUser();
        geAllUser();
    }

    /**
     GET One User
     **/
    private void geSingleUser() {
        Call<OneUser> call = api.getUser();
        call.enqueue(new Callback<OneUser>() {
            @Override
            public void onResponse(@NonNull Call<OneUser> call, @NonNull Response<OneUser> response) {
                Log.d(TAG, ""+response.code());
                OneUser resource = response.body();
                 if (resource != null) {
                     textFirstName.setText(resource.data.firstName);
                     textLastName.setText(resource.data.lastName);
                     textEmail.setText(resource.data.email);
                     Glide
                             .with(MainActivity.this)
                             .load(resource.data.avatar)
                             .into(imageAvatar);
                 }
            }

            @Override
            public void onFailure(@NonNull Call<OneUser> call, @NonNull Throwable t) {
                // TODO
                Log.e(TAG, ""+ t.getMessage());
            }
        });
    }

    /**
     GET List Users
     **/
    private void geAllUser() {

        Call<AllUsers> call = api.getAllUsers();
        call.enqueue(new Callback<AllUsers>() {
            @Override
            public void onResponse(@NonNull Call<AllUsers> call, @NonNull Response<AllUsers> response) {
                Log.d(TAG, ""+response.code());
                AllUsers resource = response.body();
                assert resource != null;
                List<AllUsers.User> list = resource.data;
                for (AllUsers.User user : list) {
                    Log.d(TAG, "User: "+user.firstName + " " + user.lastName);
                }
            }

            @Override
            public void onFailure(@NonNull Call<AllUsers> call, @NonNull Throwable t) {
                // TODO
                Log.e(TAG, ""+ t.getMessage());
            }
        });
    }

    private void uiComponent() {
        textFirstName = findViewById(R.id.text_first_name);
        textLastName = findViewById(R.id.text_last_name);
        textEmail = findViewById(R.id.text_email);
        imageAvatar = findViewById(R.id.image_avatar);
    }
}