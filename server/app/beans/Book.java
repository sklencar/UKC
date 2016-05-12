package beans;

/**
 * Created by Vito on 24. 4. 2016.
 */
public class Book {

    private Long id;
    private String title;
    private String subtitle;
    private String ISBN;
    private String publishDate;
    private String version;
    private Long id_t_author;
    private Long id_t_language;
    private Long id_t_oroginal_language;
    private Long id_t_shelf;
    private Boolean consistent_with_QR;
    private Boolean deleted = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getId_t_author() {
        return id_t_author;
    }

    public void setId_t_author(Long id_t_author) {
        this.id_t_author = id_t_author;
    }

    public Long getId_t_language() {
        return id_t_language;
    }

    public void setId_t_language(Long id_t_language) {
        this.id_t_language = id_t_language;
    }

    public Long getId_t_oroginal_language() {
        return id_t_oroginal_language;
    }

    public void setId_t_oroginal_language(Long id_t_oroginal_language) {
        this.id_t_oroginal_language = id_t_oroginal_language;
    }

    public Long getId_t_shelf() {
        return id_t_shelf;
    }

    public void setId_t_shelf(Long id_t_shelf) {
        this.id_t_shelf = id_t_shelf;
    }

    public Boolean getConsistent_with_QR() {
        return consistent_with_QR;
    }

    public void setConsistent_with_QR(Boolean consistent_with_QR) {
        this.consistent_with_QR = consistent_with_QR;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
