package test.com.deinersoft.messenger;

import com.deinersoft.messenger.Messenger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class MessengerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void invalidConfigurationFile() throws Exception {
        thrown.expect(IOException.class);
        thrown.expectMessage("xyzzy.properties (No such file or directory)");

        new Messenger("xyzzy.properties");
    }

}
