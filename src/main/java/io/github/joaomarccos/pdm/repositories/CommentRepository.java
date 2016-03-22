package io.github.joaomarccos.pdm.repositories;

import io.github.joaomarccos.pdm.entitys.Comment;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {

    public long countByDoctorId(long doctorId);

    public List<Comment> findByDoctorId(long doctorId);
}
