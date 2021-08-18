package ru.xpcom.howtoconnecttowebapi.pojo;

import com.google.gson.annotations.SerializedName;

public class OneUser {

    @SerializedName("data")
    public User data;

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
