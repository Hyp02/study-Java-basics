package HomeWork_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeWork01 {
    public static void main(String[] args) {
        News news = new News("新闻一：新冠确诊病例超过千万，数百万印度教信徒付恒河“圣浴”，引民众担忧");
        News news1 = new News("新闻二：男子突然想起两个月前钓的鱼还在网兜李，捞起来一看赶紧放生");
        List arrayList = new ArrayList();
        arrayList.add(news);
        arrayList.add(news1);

        for (int i = arrayList.size() - 1; i >= 0; i--) {
            News news2 = (News) arrayList.get(i);
            System.out.println(news2.getTitle());
        }
    }

}

class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        if (title == null) {
            return "";
        }
        if (title.length() > 15) {
            return title.substring(0, 15) + "……";
        } else {
            return title;
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }
}
