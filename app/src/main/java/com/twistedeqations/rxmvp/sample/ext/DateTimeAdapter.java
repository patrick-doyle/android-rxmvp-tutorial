package com.twistedeqations.rxmvp.sample.ext;

import android.os.Parcel;
import com.ryanharter.auto.value.parcel.TypeAdapter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class DateTimeAdapter implements TypeAdapter<DateTime> {

  private static final DateTimeFormatter formatter = ISODateTimeFormat.dateTime();

  @Override
  public DateTime fromParcel(Parcel in) {
    return formatter.parseDateTime(in.readString());
  }

  @Override
  public void toParcel(DateTime value, Parcel dest) {
    dest.writeString(formatter.print(value));
  }
}
