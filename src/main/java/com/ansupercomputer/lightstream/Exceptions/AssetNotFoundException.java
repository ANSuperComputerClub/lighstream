package com.ansupercomputer.lightstream.Exceptions;

import com.ansupercomputer.lightstream.Util.LogLevel;
import com.ansupercomputer.lightstream.Util.Logger;

public class AssetNotFoundException extends Throwable {
    public AssetNotFoundException(String message) {
        Logger.globalLogger.log(LogLevel.ERROR, "Asset Not Found Exception: " + message);
    }
}
