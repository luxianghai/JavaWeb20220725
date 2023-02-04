import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dom4jDemo {

    @Test
    public void test() throws DocumentException {
        // 第一步：创建SAXReader对象来读取XML文件，并获得 Document 对象
        SAXReader reader = new SAXReader();
        Document document = reader.read("resource/books.xml");
        // 第二步：获取根元素对象
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement);
        // asXML() 方法会将当前元素转换成 String 对象
//        System.out.println(rootElement.asXML());
        // 第三步：根据根元素对象获取所有的book对象
        List<Element> bookElements = rootElement.elements("book");
        // 第四步：遍历所有book标签，将book标签中的属性及标签封装到一个新的集合中
        List<Book> bookList = new ArrayList<>();
        for ( Element e: bookElements ) {
//            System.out.println("e.asXML() = " + e.asXML());
            // 拿到book中的 sn 属性
            String sn = e.attributeValue("sn");
//            System.out.println("sn = " + sn);
            // 拿到book下面的 name 标签的值
            String name = e.elementText("name");
//            System.out.println("name = " + name);
            String author = e.elementText("author");
            Element priceElement = e.element("price");
            String price = priceElement.getText();
            bookList.add(new Book(sn, author, name, BigDecimal.valueOf(Double.parseDouble(price))));
        }

        for (Book book: bookList) {
            System.out.println(book);
        }
    }

}
