package com.dsapr.dsaprmusic.config;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Migration {
    public static void main(String[] args) {
        String fileName = "add_init_user_and_role";
//        String path = "src/main/java/com/dsapr/dsaprmusic/config/";
        String path = "src/main/resources/db/migration/";

        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss");
        String format = sdf.format(new Date());

        fileName = 'V' + format + "__" + fileName + ".sql";

        System.out.println(fileName);
        File file = new File(path + fileName);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
