package ru.xpcom.howtoconnecttowebapi.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllUsers {
    @SerializedName("data")
    public List<User> data;

    public static class User {
        @SerializedName("id")
        public int id;

        @SerializedName("email")
        public String email;

        @SerializedName("first_name")
        public String firstName;

        @SerializedName("last_name")
        public String lastName;

        @SerializedName("avatar")
        public String avatar;
    }
}
