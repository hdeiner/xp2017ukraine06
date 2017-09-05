package com.deinersoft.messenger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Messenger {
    final Properties localConfiguration = new Properties();

    Messenger() { }

    public Messenger(String configurationFile) throws IOException {
        InputStream input = new FileInputStream(configurationFile);
        localConfiguration.load(input);
    }

}
