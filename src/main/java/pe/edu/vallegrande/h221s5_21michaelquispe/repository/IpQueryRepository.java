package pe.edu.vallegrande.h221s5_21michaelquispe.repository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.edu.vallegrande.h221s5_21michaelquispe.model.IpQuery;

public interface IpQueryRepository extends ReactiveMongoRepository<IpQuery , String> {
}
