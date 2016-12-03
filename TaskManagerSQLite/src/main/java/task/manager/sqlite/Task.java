package task.manager.sqlite;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.beans.factory.annotation.Value;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Task {

    /**
     */
    @NotNull
    @Size(max = 20)
    private String taskname;

    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date deliveryDate;

    /**
     */
    @NotNull
    @Size(max = 20)
    private String owner;

    /**
     */
    @NotNull
    private String taskDescription;

    /**
     */
    @NotNull
    @Value("false")
    private Boolean isComplete;
}
