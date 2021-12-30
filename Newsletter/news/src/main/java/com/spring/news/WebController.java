package com.spring.news;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class WebController {

    String title = "ABC 신문사";
    ArrayList<News> db_news = new ArrayList<News>();
    ArrayList<Banner> db_banner = new ArrayList<Banner>();

    public WebController(){
        db_news.add( new News(0, "title1", "a.jpg", "a's content"));
        db_news.add( new News(1, "title2", "b.jpg", "b's content"));
        db_news.add( new News(2, "title3", "c.jpg", "c's content"));
        db_news.add( new News(3, "title4", "d.jpg", "d's content"));
        db_news.add( new News(4, "title5", "e.jpg", "e's content"));

        db_banner.add(new Banner(0, "banner1.jpg", "http://www.naver.com"));
        db_banner.add(new Banner(1, "banner2.jpg", "http://www.kakao.com"));
        db_banner.add(new Banner(2, "banner3.jpg", "http://www.ebs.co.kr"));
    }
    //@Task(time=10)
    @RequestMapping(value="/")
    public String  main(Model model){
        ArrayList<News> db_top3 = new ArrayList<>();
        db_top3.add(db_news.get(0));
        db_top3.add(db_news.get(1));
        db_top3.add(db_news.get(2));

        model.addAttribute("title",title); //hashmap 구조
        model.addAttribute("address", "서울시 강남구");
        model.addAttribute("db_news", db_news);
        model.addAttribute("db_banner", db_banner);
        model.addAttribute("db_top3",db_top3 );
        return  "main";
    }

    @RequestMapping(value="/read")
    public String read(Model model, @RequestParam int id){
        News find = null;
        for(News news : db_news){
            if (news.getId() == id) {
                find = news;
            }
        }
        model.addAttribute("news", find);
        return "read";
    }

    @RequestMapping(value="/add")
    public String add(){
        return "add";
    }

    @RequestMapping(value="/add_commit")
    public String add_commit(@ModelAttribute News news){ //임시db를 ArrayList로 만들었기때문에-> id값 5부터 시작해야함!
        news.setId(db_news.get(db_news.size()-1).getId()+1); //가장 최근에 추가된 news의 id값+1
        db_news.add(news);
        return "redirect:/";
    }

    @RequestMapping(value = "/del_commit")
    public String del_commit(Model model, @RequestParam int id){
        News find = null;
        /*for(News news : db_news){
            if (news.getId() == id) {
                find = news;
            }
        }*/
        find = db_news.stream().filter(n-> n.getId() == id).findFirst().orElse(null);
        db_news.remove(find);
        return "redirect:/";
    }


    @RequestMapping(value="/update")
    public String readForUpdate(Model model, @RequestParam int id){
        News find = null;
        for(News news : db_news){
            if (news.getId() == id) {
                find = news;
            }
        }
        model.addAttribute("news", find);
        return "update";
    }
    @RequestMapping(value = "/update_commit")
    public String update(@ModelAttribute News form){
        News find = null;
        for(News news : db_news){
            if (news.getId() == form.getId()) {
                find = news;
            }
        }
        find.setTitle(form.getTitle());
        find.setImg(form.getImg());
        find.setContent(form.getContent());

        return "redirect:/";
    }
}

