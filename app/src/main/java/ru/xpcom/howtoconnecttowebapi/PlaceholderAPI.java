package ru.xpcom.howtoconnecttowebapi;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.xpcom.howtoconnecttowebapi.pojo.AllUsers;
import ru.xpcom.howtoconnecttowebapi.pojo.OneUser;

public interface PlaceholderAPI {

    @GET("api/users/1")
    Call<OneUser> getUser();

    @GET("api/users?page=2")
    Call<AllUsers> getAllUsers();

}
