package ru.xpcom.howtoconnecttowebapi;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class PlaceholderPost {

    @SerializedName("userId")
    public int userID;

    @SerializedName("id")
    public int id;

    @Nullable
    @SerializedName("title")
    public String title;

    @Nullable
    @SerializedName("body")
    public String body;

}
