package com.ardysyahputra.takehomeexercise.preference;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager
{
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;

    private static final String Is_ClockIn = "IsClockIn";
    private static final String Is_ClockOut= "IsClockOut";

    private static final String Time_In = "TimeIn";
    private static final String Time_Out = "TimeOut";

    public PrefManager(String name,Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(name, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void setClockIn (boolean ClockIn)
    {
        editor.putBoolean(Is_ClockIn, ClockIn);
        editor.commit();
    }

    public void setClockOut (boolean ClockOut)
    {
        editor.putBoolean(Is_ClockOut, ClockOut);
        editor.commit();
    }

    public void setTime_In (String time_In)
    {
        editor.putString(Time_In,time_In);
        editor.commit();
    }

    public void setTime_Out (String time_Out)
    {
        editor.putString(Time_Out,time_Out);
        editor.commit();
    }

    public String getTimeIn()
    {
        return pref.getString(Time_In,"-");
    }
    public String getTimeOut()
    {
        return pref.getString(Time_In,"-");
    }

    public boolean isClockin()
    {
     return pref.getBoolean(Is_ClockIn,false);
    }
    public boolean isClockOut()
    {
        return pref.getBoolean(Is_ClockOut,false);
    }




}
