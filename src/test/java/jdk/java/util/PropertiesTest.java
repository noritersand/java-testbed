package jdk.java.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author fixalot
 * @since 2017-07-27
 */
public class PropertiesTest {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesTest.class);

    @Test
    public void testStore() throws IOException {
        // 상대경로를 지정하면 루트는 '워크스페이스/프로젝트' 폴더다.
        File dir = new File("temp");
        Path testProperties = new File("temp/test.properties").toPath();
        File file = new File(testProperties.toString());
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(testProperties.toString());
        Properties prop = new Properties();
        prop.put("서울의수도", "서울에수도가어디있어");
        prop.store(fos, "코멘트테스트");
        fos.close();

        Properties newProp = new Properties();
        newProp.load(new FileInputStream(testProperties.toString()));
        assertEquals("서울에수도가어디있어", newProp.get("서울의수도"));
    }

    @Test
    public void getPropertyDefault() {
        Properties prop = new Properties();
        assertEquals("hello-world", prop.getProperty("I'm not exist", "hello-world").toString());
    }

    @Test
    public void getPropertyByInputStream() throws IOException {
        FileInputStream fis = new FileInputStream("src\\test\\resources\\properties-test\\access-test.properties");
        Properties prop = new Properties();
        prop.load(fis);
        fis.close();
        assertTrue(prop.containsKey("a.b.c"));
        logger.debug("{}", prop);

        assertEquals("http://daum.net", prop.getProperty("web.root"));
        assertEquals("123", prop.getProperty("a.b.c"));
        assertEquals("한글", prop.getProperty("korean"));
        assertEquals("한글2", prop.getProperty("korean2"));
    }

    @Test
    public void getPropertyByReader() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src\\test\\resources\\properties-test\\access-test.properties"));
        Properties prop = new Properties();
        prop.load(reader);
        reader.close();
        assertTrue(prop.containsKey("a.b.c"));
        logger.debug("{}", prop);

        assertEquals("http://daum.net", prop.getProperty("web.root"));
        assertEquals("123", prop.getProperty("a.b.c"));
        assertEquals("한글", prop.getProperty("korean"));
        assertEquals("한글2", prop.getProperty("korean2"));
    }

    @Test
    public void getPropertyFromXml() throws IOException {
        FileInputStream fis = new FileInputStream("src\\test\\resources\\properties-test\\uri-test.xml");
        Properties prop = new Properties();
        prop.loadFromXML(fis);
        fis.close();
        assertTrue(prop.containsKey("image.root"));
        logger.debug("{}", prop);

        Enumeration<Object> keys = prop.keys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            logger.debug("key: " + key + ", value: " + prop.getProperty(key));
        }

        // key: some.korean, value: 한글
        // key: image.root, value: http://tistory.com

        assertEquals("http://tistory.com", prop.getProperty("image.root"));
        assertEquals("한글", prop.getProperty("some.korean"));
    }
}
