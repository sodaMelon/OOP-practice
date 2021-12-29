package com.spring.mvc.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "<h1>홈페이지</h1>";
    }

    @GetMapping("/test")
    @ResponseBody
    public String testHome() {
        return "<h1>테스트 홈페이지</h1>";
    }

    @GetMapping("/movie")
    @ResponseBody
    public String movie() {
        Movie movie = new Movie(0, "Spider man: No-way-home", "^^^");

        movie.setImg("movie1.jpg");
        String html = "";

        html = "<H1>" + movie.getTitle() + "</H1>" + "영화줄거리 : <H2>" + movie.getStory() + "</h2>"
                + "<img src=" + movie.getImg() + " width=300>";
        return html;
    }

    @GetMapping("/movie2")
    public String movie2(Model model) {
        Movie movie = new Movie(0, "Spider man: No-way-home", "^^^");
        movie.setImg("movie1.jpg");

        model.addAttribute("title", "홍길동");
        model.addAttribute("a", movie);
        /*Movie movie2 = new Movie(0, "Spider man: No-way-home", "^^^");
        movie2.setImg("movie1.jpg");
*/
        return "movie2"; // movie2.jsp.. or
    }
}
