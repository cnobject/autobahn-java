package io.crossbar.autobahn.wamp.utils;

import java.util.List;

import io.crossbar.autobahn.wamp.exceptions.ProtocolError;

public class MessageUtil {

    /**
     * @param wmsg wamp message to validate
     * @param messageType type of the wamp message
     * @param lengthMin minimum number of items the wamp message is expected to have
     * @param lengthMax maximum number of items the wamp message is expected to have
     */
    public static void validateMessage(List<Object> wmsg,
                                       int messageType,
                                       String messageVerboseName,
                                       int lengthMin,
                                       int lengthMax) {
        if (wmsg.size() == 0 || !(wmsg.get(0) instanceof Integer) || (int) wmsg.get(0) != messageType) {
            throw new IllegalArgumentException("Invalid message.");
        }

        if (wmsg.size() < lengthMin || wmsg.size() > lengthMax) {
            throw new ProtocolError(String.format(
                    "Invalid message length %s for %s", wmsg.size(), messageVerboseName));
        }
    }

    /**
     * @param wmsg wamp message to validate
     * @param messageType type of the wamp message
     * @param length number of items the wamp message is expected to have
     */
    public static void validateMessage(List<Object> wmsg,
                                       int messageType,
                                       String messageVerboseName,
                                       int length) {
        validateMessage(wmsg, messageType, messageVerboseName, length, length);
    }
}