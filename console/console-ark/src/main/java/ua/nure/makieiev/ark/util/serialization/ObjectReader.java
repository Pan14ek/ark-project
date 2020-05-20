package ua.nure.makieiev.ark.util.serialization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.makieiev.ark.model.entity.UserInfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectReader.class);
    public static final String SRC_MAIN_RESOURCES_USER_INFO_BIN = "src/main/resources/user_info.bin";

    public static UserInfo readUserInformation() {
        UserInfo userInfo = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(SRC_MAIN_RESOURCES_USER_INFO_BIN))) {
            userInfo = (UserInfo) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        return userInfo;
    }

}
