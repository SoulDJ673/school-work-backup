package com.tsguild.addressbook.ui;

/**
 *
 * @author souldj673
 */
public interface UserIO {

    void print(String message);

    String readString(String msgPrompt);

    int readInt(String msgPrompt);

    int readInt(String msgPrompt, int min, int max);

    double readDouble(String msgPrompt);

    double readDouble(String msgPrompt, double min, double max);

    float readFloat(String msgPrompt);

    float readFloat(String msgPrompt, float min, float max);

    long readLong(String msgPrompt);

    long readLong(String msgPrompt, long min, long max);
}
