package ru.xpcom.howtoconnecttowebapi.pojo;

import androidx.annotation.NonNull;

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

    @NonNull
    @Override
    public String toString() {
        return "AllUsers{" +
                "data=" + data +
                '}';
    }
}
