package tcp;

import org.junit.Test;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UUIDConverter {

    public static UUID fromString(String src) {
        return UUID.fromString(src.substring(7, 15) + "-" + src.substring(3, 7) + "-1"
                + src.substring(0, 3) + "-" + src.substring(15, 19) + "-" + src.substring(19));
    }

    public static String fromTimeUUID(UUID src) {
        if (src.version() != 1) {
            throw new IllegalArgumentException("Only Time-Based UUID (Version 1) is supported!");
        }
        String str = src.toString();
        // 58e0a7d7-eebc-11d8-9669-0800200c9a66 => 1d8-eebc-58e0a7d7-9669-0800200c9a66. Note that [11d8] -> [1d8]
        return str.substring(15, 18) + str.substring(9, 13) + str.substring(0, 8) + str.substring(19, 23) + str.substring(24);
    }

    public static List<String> fromTimeUUIDs(List<UUID> uuids) {
        if (uuids == null) {
            return null;
        }
        return uuids.stream().map(UUIDConverter::fromTimeUUID).collect(Collectors.toList());
    }

    @Test
    public void test () {

        UUID uuid = UUID.fromString("c4bab450-3c5f-11e8-b7a8-43ae0d60669c");
        String str = "1e85989e70bc520933219a5a4cf21f9";

        System.out.println(fromTimeUUID(uuid));
    }
}
