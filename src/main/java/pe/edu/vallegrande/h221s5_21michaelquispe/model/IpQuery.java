package pe.edu.vallegrande.h221s5_21michaelquispe.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pe.edu.vallegrande.h221s5_21michaelquispe.model.IpQuery;

@Data
@Document(collection = "ipquery")
public class IpQuery {
    @Id
    private String id;
    private String ip;
    private String city;
    private String region;
    private String country;
    private String loc;
    private String org;
    private String postal;
    private String timezone;
}
