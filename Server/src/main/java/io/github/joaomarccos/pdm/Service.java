package io.github.joaomarccos.pdm;

import io.github.joaomarccos.pdm.entitys.Comment;
import io.github.joaomarccos.pdm.entitys.CommentVO;
import io.github.joaomarccos.pdm.entitys.Doctor;
import io.github.joaomarccos.pdm.repositories.CommentRepository;
import io.github.joaomarccos.pdm.repositories.DoctorRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@RestController
@RequestMapping("/doctors")
public class Service {

    @Inject
    private DoctorRepository doctorRepository;

    @Inject
    public CommentRepository commentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Doctor> list() {
        List<Doctor> all = new ArrayList<>();
        doctorRepository.findAll().forEach(all::add);
        return all;
    }

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public ResponseEntity<String> comment(@RequestBody CommentVO comment) {
        Comment c = new Comment(comment.getUserName(), comment.getRating(), comment.getComment(), comment.getDoctorId());
        Doctor d = doctorRepository.findOne(comment.getDoctorId());
        long nReviews = commentRepository.countByDoctorId(comment.getDoctorId());        
        Double media = ((d.getRating()*nReviews) + comment.getRating()) / (nReviews+1);        
        d.setRating(Double.parseDouble(String.format("%.1f", media)));
        doctorRepository.save(d);
        commentRepository.save(c);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/comments/{doctor}", method = RequestMethod.GET)
    public List<Comment> getComments(@PathVariable Long doctor) {
        return commentRepository.findByDoctorId(doctor);
    }
}
