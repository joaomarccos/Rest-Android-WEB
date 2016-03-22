package io.github.joaomarccos.pdm;

import io.github.joaomarccos.pdm.entitys.Comment;
import io.github.joaomarccos.pdm.entitys.Doctor;
import io.github.joaomarccos.pdm.repositories.CommentRepository;
import io.github.joaomarccos.pdm.repositories.DoctorRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Comment comment(String userName, Double rating, String comment, Long doctorId) {
        Comment c = new Comment(userName, rating, comment, doctorId);
        Doctor d = doctorRepository.findOne(doctorId);
        d.setRating((d.getRating() + rating) / commentRepository.countByDoctorId(doctorId));
        doctorRepository.save(d);

        return commentRepository.save(c);
    }

    @RequestMapping(value = "/comments/{doctor}", method = RequestMethod.GET)
    public List<Comment> getComments(@PathVariable Long doctor) {
        return commentRepository.findByDoctorId(doctor);
    }
}
