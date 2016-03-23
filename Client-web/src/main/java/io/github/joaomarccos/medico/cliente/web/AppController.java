package io.github.joaomarccos.medico.cliente.web;

import io.github.joaomarccos.pdm.entitys.Comment;
import io.github.joaomarccos.pdm.entitys.CommentVO;
import io.github.joaomarccos.pdm.entitys.Doctor;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@Controller
public class AppController {

    @RequestMapping("/login")
    public String login(String username, HttpServletRequest request) {
        request.getSession().setAttribute("username", username);
        getAllDoctors(request);
        return "doctors";
    }

    @RequestMapping("/doctors")
    public String doctors(String username, HttpServletRequest request) {
        return "doctors";
    }

    private void getAllDoctors(HttpServletRequest request) {
        RestTemplate template = new RestTemplate();
        Doctor[] doctors = template.getForObject("http://localhost:8080/doctors", Doctor[].class);
        request.getSession().setAttribute("doctors", Arrays.asList(doctors));
    }

    @RequestMapping("/view/{id}")
    public String viewDoctor(@PathVariable long id, HttpServletRequest request) {
        List<Doctor> doctors = getDoctorsListInMemory(request);
        if (doctors == null) {
            getAllDoctors(request);
            doctors = getDoctorsListInMemory(request);
        }

        Doctor get = doctors.stream().filter(d -> d.getId() == id).findFirst().get();
        request.setAttribute("doctor", get);
        setComments(request, id);
        return "doctorpage";
    }

    @RequestMapping("/comment")
    public String comment(String comment, long userRating, long doctorId, HttpServletRequest request) {
        CommentVO c = new CommentVO((String) request.getSession().getAttribute("username"), userRating, comment, doctorId);
        RestTemplate template = new RestTemplate();
        template.postForObject("http://localhost:8080/doctors/comments/", c, CommentVO.class);
        getAllDoctors(request);
        return "redirect:/view/" + doctorId;
    }

    private void setComments(HttpServletRequest request, long id) {
        RestTemplate template = new RestTemplate();
        Comment[] comments = template.getForObject("http://localhost:8080/doctors/comments/" + id, Comment[].class);
        request.setAttribute("comments", Arrays.asList(comments));
    }

    private List<Doctor> getDoctorsListInMemory(HttpServletRequest request) {
        List<Doctor> doctors = (List<Doctor>) request.getSession().getAttribute("doctors");
        return doctors;
    }

}
