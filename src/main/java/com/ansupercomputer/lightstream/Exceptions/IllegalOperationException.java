package com.ansupercomputer.lightstream.Exceptions;

import com.ansupercomputer.lightstream.Util.LogLevel;
import com.ansupercomputer.lightstream.Util.Logger;

public class IllegalOperationException extends Throwable {
    public IllegalOperationException(String message) {
        Logger.globalLogger.log(LogLevel.ERROR, "Illegal Operation Exception: " + message);
    }
}
