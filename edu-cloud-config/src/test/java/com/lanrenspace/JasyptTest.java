package com.lanrenspace;

import com.lanrenspace.edu.ConfigServerApplication;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ConfigServerApplication.class})
public class JasyptTest {


    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void encryptorPwd() {
        System.out.println(stringEncryptor.encrypt("123456"));
    }

}
