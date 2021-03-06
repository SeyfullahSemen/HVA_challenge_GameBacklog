package app.portal.hva.semen.seyfullah.com.gamebacklog.Classes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/*
 * Created by Seyfullah Semen on 24-9-2018.
 */
@Entity(tableName = "game")
public class Games implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public Long id;

    @ColumnInfo(name = "gametitle")
    public String mGameTitle;
    @ColumnInfo(name = "platformtitle")
    public String mPlatformTitle;
    @ColumnInfo(name = "note")
    public String mNote;
    @ColumnInfo(name = "status")
    public String mStatus;

    public Games(String mGameTitle, String mPlatformTitle, String mNote, String mStatus) {
        this.mGameTitle = mGameTitle;
        this.mPlatformTitle = mPlatformTitle;
        this.mNote = mNote;
        this.mStatus = mStatus;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getmGameTitle() {
        return mGameTitle;
    }

    public void setmGameTitle(String mGameTitle) {
        this.mGameTitle = mGameTitle;
    }

    public String getGameStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getPlatformTitle() {
        return mPlatformTitle;
    }

    public String getNote() {
        return mNote;
    }

    public void setNote(String mNote) {
        this.mNote = mNote;
    }

    public void setmPlatformTitle(String mPlatformTitle) {
        this.mPlatformTitle = mPlatformTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.mGameTitle);
        dest.writeString(this.mPlatformTitle);
        dest.writeString(this.mStatus);
    }

    protected Games(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.mGameTitle = in.readString();
        this.mPlatformTitle = in.readString();
        this.mStatus = in.readString();
    }

    public static final Creator<Games> CREATOR = new Creator<Games>() {
        @Override
        public Games createFromParcel(Parcel source) {
            return new Games(source);
        }

        @Override
        public Games[] newArray(int size) {
            return new Games[size];
        }
    };
}
