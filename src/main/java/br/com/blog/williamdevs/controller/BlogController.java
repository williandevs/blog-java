package br.com.blog.williamdevs.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.blog.williamdevs.model.Post;
import br.com.blog.williamdevs.service.BlogService;

@Controller
public class BlogController {

    @Autowired

    BlogService blogService;

    @RequestMapping("/")
    public String home() {
        return "redirect:/posts";
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = blogService.findById(id);
        mv.addObject("post", post);
        return mv;
    }
    

    @RequestMapping(value = "/newpost", method = RequestMethod.GET)
    public String getPostForm() {
        return "postForm";
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        blogService.save(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = blogService.findAll();
        mv.addObject("posts", posts);
        return mv;

    }

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("lista");
        final List<Post> lista = blogService.findAll();
        mv.addObject("lista", lista);
        return mv;
    }

    @GetMapping("/deletar")
    public String delete(@RequestParam Long id) {
        blogService.deleteById(id);
        return "redirect:/lista";
    }

    /* navegação padrao */

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView sobre() {
        ModelAndView mv = new ModelAndView("/about");
        return mv;
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView contato() {
        ModelAndView mv = new ModelAndView("/contact");
        return mv;
    }

}
