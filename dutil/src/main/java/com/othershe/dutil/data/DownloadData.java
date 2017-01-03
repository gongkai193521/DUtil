package com.othershe.dutil.data;

import android.os.Parcel;
import android.os.Parcelable;

public class DownloadData implements Parcelable {

    private String url;
    private String path;
    private String name;
    private int currentSize;
    private int totalSize;
    private float percentage;
    private int state;
    private int childTaskCount;
    private long date;

    public DownloadData() {

    }

    public DownloadData(String url, String path, String name) {
        this.url = url;
        this.path = path;
        this.name = name;
    }

    public DownloadData(String url, String path, String name, int childTaskCount) {
        this.url = url;
        this.path = path;
        this.name = name;
        this.childTaskCount = childTaskCount;
    }

    public DownloadData(String url, String path, int childTaskCount, String name, int currentSize, int totalSize, long date) {
        this.url = url;
        this.path = path;
        this.childTaskCount = childTaskCount;
        this.currentSize = currentSize;
        this.name = name;
        this.totalSize = totalSize;
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getChildTaskCount() {
        return childTaskCount;
    }

    public void setChildTaskCount(int childTaskCount) {
        this.childTaskCount = childTaskCount;
    }

    public long getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.path);
        dest.writeString(this.name);
        dest.writeInt(this.currentSize);
        dest.writeInt(this.totalSize);
        dest.writeFloat(this.percentage);
        dest.writeInt(this.state);
        dest.writeInt(this.childTaskCount);
        dest.writeLong(this.date);
    }

    protected DownloadData(Parcel in) {
        this.url = in.readString();
        this.path = in.readString();
        this.name = in.readString();
        this.currentSize = in.readInt();
        this.totalSize = in.readInt();
        this.percentage = in.readFloat();
        this.state = in.readInt();
        this.childTaskCount = in.readInt();
        this.date = in.readLong();
    }

    public static final Parcelable.Creator<DownloadData> CREATOR = new Parcelable.Creator<DownloadData>() {
        @Override
        public DownloadData createFromParcel(Parcel source) {
            return new DownloadData(source);
        }

        @Override
        public DownloadData[] newArray(int size) {
            return new DownloadData[size];
        }
    };
}
