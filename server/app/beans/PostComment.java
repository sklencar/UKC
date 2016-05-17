package beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import models.User;
import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Model representing Comments to Blog Posts
 */
@Entity
public class PostComment extends Model {

    @Id
    public Long id;

    @ManyToOne
    @JsonIgnore
    public BlogPost blogPost;

    @ManyToOne
    public User user;

    @Column(columnDefinition = "TEXT")
    public String content;

    public static final Finder<Long, PostComment> find = new Finder<Long, PostComment>(
            Long.class, PostComment.class);

    public static List<PostComment> findAllCommentsByPost(final BlogPost blogPost) {
        return find
                .where()
                .eq("post", blogPost)
                .findList();
    }

    public static List<PostComment> findAllCommentsByUser(final User user) {
        return find
                .where()
                .eq("user", user)
                .findList();
    }

}