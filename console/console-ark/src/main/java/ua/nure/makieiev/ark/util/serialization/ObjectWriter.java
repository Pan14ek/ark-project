package ua.nure.makieiev.ark.util.serialization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.makieiev.ark.model.entity.UserInfo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectWriter.class);
    public static final String SRC_MAIN_RESOURCES_USER_INFO_BIN = "src/main/resources/user_info.bin";

    public static void writeUserInfo(UserInfo userInfo) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(SRC_MAIN_RESOURCES_USER_INFO_BIN))) {
            objectOutputStream.writeObject(userInfo);
        } catch (IOException exception) {
            LOGGER.error(exception.getMessage());
        }
    }

}
