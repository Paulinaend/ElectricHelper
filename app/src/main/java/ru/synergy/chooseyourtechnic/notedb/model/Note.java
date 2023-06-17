package ru.synergy.chooseyourtechnic.notedb.model;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

import ru.synergy.chooseyourtechnic.util.Constants;

@Entity(tableName = Constants.TABLE_NAME_NOTE)
public class Note implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long note_id;

    @ColumnInfo(name = "note_content")
    // column name will be "note_content" instead of "power" in table
    private String power;
    private String voltage;
    private String phase;
    private String cosFi;
   // private String current;
    private Date date;

    public Note(String power, String voltage, String phase, String cosFi /*String current*/) {
        this.power = power;
        this.voltage = voltage;
        this.phase = phase;
        this.cosFi = cosFi;
        //this.current = current;
        this.date = new Date(System.currentTimeMillis());
    }
    @Ignore
    public Note() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getNote_id() {
        return note_id;
    }

    public void setNote_id(long note_id) {
        this.note_id = note_id;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) { this.voltage = voltage; }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) { this.phase = phase; }

    public String getCosFi() {
        return cosFi;
    }

    public void setCosFi(String cosFi) { this.cosFi = cosFi; }

//    public String getCurrent() {
//        return current;
//    }
//
//    public void setCurrent(String current) { this.current = current; }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;

        Note note = (Note) o;

        if (note_id != note.note_id) return false;
        return title != null ? title.equals(note.title) : note.title == null;
    }*/

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

/*    @Override
    public int hashCode() {
        int result = (int) note_id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }*/
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Note{" +
                "note_id=" + note_id +
                ", power='" + power + '\'' +
                ", voltage='" + voltage + '\'' +
                ", phase='" + phase + '\'' +
                ", cosFi='" + cosFi + '\'' +
               // ", current='" + current + '\'' +
                ", date=" + date +
                '}';
    }
}